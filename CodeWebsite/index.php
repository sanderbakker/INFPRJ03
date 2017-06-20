<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.2.1.js" integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE=" crossorigin="anonymous"></script>		
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.js"></script>
	</head>
<body>
	<?php
		include('config.php');	
		include('inc/navbar.php');
        require_once('scripts/SafetyPoints.php');        
		$conn = $Database->getConn();
	?>
    <div style="z-index: 10; position: absolute" id="lightbox">

    </div>

	<div class='fluid-container'>
	<div class='row'>
	<div class='col-lg-9 col-md-8 col-sm-8'>
		<div id='map' style='height:90%; width: 100%;'></div>
	</div>
	<div class='col-lg-3 col-md-4 col-sm-4'>
	 <div style='height: 55%'>
       	<select id="garage-picker" name="garages" data-selectr-opts='{ "title": "", "placeholder": "Zoek parkeergarage", "maxSelection": 1 }'>
       	<?php
       		// Select all parkgarages and its hood points
			$sql = "SELECT * FROM parkgarage RIGHT JOIN parkgarage_details USING(parkgarage_code) RIGHT JOIN parkgarage_address USING(parkgarage_address_id) LEFT JOIN hood_points USING(hood_id) GROUP BY parkgarage_id";

			// loop through all parkgarages
			foreach($conn->query($sql) as $result) {
				// Get the suggested color for the amount of points the parkgarage has
				$color = SafetyPoints::getSuggestedColor($result['points']);

				// print out the option with the fetched data
				echo "<option data-selectr-color='$color' value='$result[parkgarage_code]'>$result[parkgarage_name]</option>";
			}
	    ?>
        </select>
       </div>
        <div class="parkgarage-details">
        	<div class="fluid-container">
        		<div id="parkgarage-details-header"></div>
        		<div class="row">
        			<div class="col-md-6 col-sm-8" id="parkgarage-details">

        			</div>
        			<div class="col-md-6 col-sm-4" id="parkgarage-safety">
        			</div>
     			</div>
     		</div>
        </div>
	</div>
	</div>
	</div>
	</div>
</body>
</html>

<script src='https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyAJKNSxrxcT9PN9STITsSC2QI1L1Qbnw-8'></script>
<script src="js/selectr.js"></script>
<script>
		$(document).ready(function() {
			initMap();
		});

            var center = null;
            var map = null;
            var currentPopup;
            var bounds = new google.maps.LatLngBounds();

            // Function to add add markers to google maps
            function addMarker(lat, lng, info, val, image) {

            	// If image is not given, use default image
            	if(image == '') {
            		image = 'ffc777.png';
            	}
            	var icon = new google.maps.MarkerImage("/images/markers/" + image,
                       		new google.maps.Size(32, 32), new google.maps.Point(0, 0),
                       		new google.maps.Point(16, 32));

                var pt = new google.maps.LatLng(lat, lng);
                bounds.extend(pt);
                var marker = new google.maps.Marker({
                    position: pt,
                    icon: icon,
                    map: map
                });
                var popup = new google.maps.InfoWindow({
                    content: info,
                    maxWidth: 300
                });

                google.maps.event.addListener(marker, "click", function() {
                    if (currentPopup != null) {
                        currentPopup.close();
                        currentPopup = null;
                    }

                    map.setZoom(14);
                    map.panTo(marker.position);                    

		 		   emptyGarageDetails();
		 		   loadGarageDetails(val);                   

                    popup.open(map, marker);
                    currentPopup = popup;
                });
                google.maps.event.addListener(popup, "closeclick", function() {
                	emptyGarageDetails();
                    currentPopup = null;

                    center = bounds.getCenter();
                    map.fitBounds(bounds);                    
                });

                return {'marker': marker, 'popup': popup};
            }           

            // Spawn the google maps
            function initMap() {
                map = new google.maps.Map(document.getElementById("map"), {
                    center: new google.maps.LatLng(0, 0),
                    zoom: 14,
                    mapTypeId: google.maps.MapTypeId.ROADMAP,
                    mapTypeControl: true,
                    mapTypeControlOptions: {
                        style: google.maps.MapTypeControlStyle.HORIZONTAL_BAR
                    },
                    navigationControl: true,
                    navigationControlOptions: {
                        style: google.maps.NavigationControlStyle.ZOOM_PAN
                    }
                });
              
        marker_array = {};
		<?php

       	// Select all parkgarages and its hood points	
		$result = $conn->query("SELECT * FROM parkgarage RIGHT JOIN parkgarage_address USING(parkgarage_address_id) RIGHT JOIN hood_points USING(hood_id)");

		// loop through all parkgarages
		while($data = $result->fetch_assoc())
		{

			// Get the suggested color for the amount of points the parkgarage has			
          $color = SafetyPoints::getSuggestedColor($data['points']);
          $image = ltrim($color, '#') . '.png';

		  $name = $data['parkgarage_name'];
		  $lat = $data['langitude'];
		  $lon = $data['longitude'];
		  $code = $data['parkgarage_code'];

		  // Print a marker on the map for this parkgarage
		  echo("marker_array[\"$code\"] = addMarker($lat, $lon, '<b>$name</b>', '$code', '$image');\n");

		}

		?>
 	 center = bounds.getCenter();
     map.fitBounds(bounds);

     currentPopup = null;
	$('#garage-picker').on('change', function() {
        if(currentPopup) {
            currentPopup.close();
        }

        map.setZoom(14);
        map.panTo(marker_array[this.value]['marker'].position);
        marker_array[this.value]['popup'].open(map, marker_array[this.value]['marker']);
        currentPopup = marker_array[this.value]['popup'];
    }); 

     }

     // Function which loads the details of the selected garage
	function loadGarageDetails(val) {
		$.ajax({url: "/ajax/parkgarage-details.php?code=" + val, success: function(result){
		result = JSON.parse(result);

		$("#parkgarage-details-header").append('<h3>' + result.parkgarage_name  + '</h3><table class="table">');

		$("#parkgarage-details").append('<h4>Plaatsen</h4>'); 
		$("#parkgarage-details").append('<tr><td>Plaatsen</td> <td style="padding-left: 10px"><strong>' + result.car_capacity + '</strong></td></tr>');
		$("#parkgarage-details").append('<tr><td>Oplaadpunten</td> <td style="padding-left: 10px"><strong>' + result.charging_capacity + '</strong></td></tr>');
		$("#parkgarage-details").append('</table>');

		$("#parkgarage-safety").append('<h4>Veiligheid buurt</h4>');
		$("#parkgarage-safety").append('<p><span style="font-size: 50px; color:' + result.color + '">' + result.score + '</span> / <strong>5</strong></p>');
        $("#parkgarage-safety").append('<a target="_blank" href="/ajax/safety-graphs.php?hood_id=' + result.hood_id + '" >Veiligheids Informatie</a>')


	  }});	
	}

	// Clear parkgarage details
	function emptyGarageDetails() {
		$("#parkgarage-details-header").empty();
		$("#parkgarage-details").empty();
		$("#parkgarage-safety").empty();
	}

	// On click event for parkgarages
 	$('#garage-picker').on('change', function() { 
 	  	emptyGarageDetails();
 		loadGarageDetails(this.value);
	});

 	// Selecter logic
    $(document).ready(function () {
        $("select").selectr({
			noMatchingOptionsText:  'Geen parkeergarage gevonden.',
			maxListHeight: '80%',
            placeholder: 'Search Expertise'

        });       
    });
 
</script>
<style>
	.selectr .option-name {
		height: initial;
	}
</style>
