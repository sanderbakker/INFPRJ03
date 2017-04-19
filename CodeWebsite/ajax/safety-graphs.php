<?php

require_once(__DIR__ . '/../config.php');
require_once(__DIR__ . '/../scripts/SafetyPoints.php');

class SafetyGraph {
	private $conn;
	private $table;
	private $hood_id;

	private $years_avg;
	private $data_avg;

	private $years_hood;
	private $data_hood;

	private $pointsYear;
	private $pointsData;

	function __construct($table, $hood_id) {
		GLOBAL $Database;		
		$this->conn 	= $Database->getConn();
		$this->table 	= $table;
		$this->hood_id 	= $hood_id;

		$this->generateAverage();
		$this->generateData();
		$this->generatePoints();

	}

	private function generateList($result) {
		$years 	= '';
		$data 	= '';

		while($row = $result->fetch_array()) {
			$years 	= $years . "'" . $row['year'] . "', ";
			$data 	= $data . "'" . $row['percentage'] . "', ";
		}

		// Strip last ','
		rtrim($years, ',');
		rtrim($data, ',');	

		// return array with data
		return array('years' => $years, 'percentage' => $data);

	}

	private function generateAverage()  {
		// Select avarage from $table per year 
		$select_avg = "SELECT avg(percentage) as percentage, year FROM $this->table GROUP BY year";

		$result = $this->conn->query($select_avg);

		$list = $this->generateList($result);

		// Set avg variables.
		$this->years_avg 	= $list['years'];
		$this->data_avg 	= $list['percentage'];
			
	}

	public function printAvgYears() {
		echo $this->years_avg;
	}

	public function printAvgData() {
		echo $this->data_avg;
	}

	function generateData() {
		// Select all years from hood
		$select_data = "SELECT * FROM $this->table WHERE hood_id=$this->hood_id GROUP BY year";
		$result = $this->conn->query($select_data);

		$list = $this->generateList($result);

		// Set hood variables.
		$this->years_hood 	= $list['years'];
		$this->data_hood	= $list['percentage'];		
	}

	public function printDataYears() {
		echo $this->years_hood;
	}

	public function printData() {
		echo $this->data_hood;
	}

	function generatePoints() {
		$select_data = "SELECT * FROM $this->table WHERE hood_id=$this->hood_id GROUP BY year";
		$result = $this->conn->query($select_data);

		$year_list = '';
		$data_list = '';

		while($data = $result->fetch_array()) {
			$select_var = "SELECT avg(percentage) as avg, max(percentage) as max FROM $this->table WHERE year=$data[year]";

			$result_var = $this->conn->query($select_var);
			$data_var 	= $result_var->fetch_array();

			$minPerc = 0;
			$maxPerc = $data_var['max'] + ($data_var['avg'] / 2);

			$points = 100 - ((100 / $maxPerc) * ($data['percentage']));
			$points = $points / 20;

			$year_list 	= $year_list . "'" . $data['year'] . "', ";			
			$data_list 	= $data_list . "'" . $points . "' , ";			
		}

		$this->pointsYear = rtrim($year_list, ',');
		$this->pointsData = rtrim($data_list, ',');			
	}

	function pointsYear() {
		echo $this->pointsYear;
	}

	function pointsData() {
		echo $this->pointsData;
	}
}

if(empty($_GET['hood_id'])) {
	header('location: /');
}

$conn = $Database->getConn();

$dotc = new SafetyGraph('damage_or_theft_car', $_GET['hood_id']);
$taoc = new SafetyGraph('theft_outof_car', $_GET['hood_id']); 

$select_park = "SELECT * FROM parkgarage_address INNER JOIN parkgarage USING(parkgarage_address_id) WHERE hood_id=$_GET[hood_id] LIMIT 1";
$result 	 = $conn->query($select_park);
$data_park 	 = $result->fetch_array();

$dotcPoint = new SafetyPoints($data_park['parkgarage_id'],'damage_or_theft_car');
$toacPoint = new SafetyPoints($data_park['parkgarage_id'],'theft_outof_car');

$select_hood 	= "SELECT * FROM hood WHERE hood_id='$_GET[hood_id]'";
$result 	= $conn->query($select_hood);
$data_hood 	= $result->fetch_assoc();

include(__DIR__ . '/../inc/navbar.php');
?>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<h1>Wijk <?php echo $data_hood['hood_name']; ?></h1>

<div class="fluid-container">
 <div class="row">
 	<div class="col-md-6">
	  <h2>Damage or theft car</h2>
	  <div>
	    <canvas id="dotc"></canvas>
	  </div>
	</div>
	<div class="col-md-6">
	  <h2>Theft out of car</h2>
	  <div>
	    <canvas id="toac"></canvas>
	  </div>		
	</div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.4/Chart.min.js"></script>
<script>
var ctx = document.getElementById('dotc').getContext('2d');
var myChart = new Chart(ctx, {
  type: 'line',
  options: {
    scales:
    {
        yAxes: [{
            display: true,
            ticks: {
            	beginAtZero: true,
            	suggestedMax: 5

        	}
        }]
    }, 	
  	tooltips: {
  		'enabled': false
  	}
  },
  data: {
    labels: [<?php $dotc->pointsYear() ?>], 
    datasets: [{
    	label: 'Totaal',
    	data: [<?php echo $dotcPoint->getPoint() . ', ';
					echo $dotcPoint->getPoint() . ', ';
					echo $dotcPoint->getPoint() . ', ';					
					echo $dotcPoint->getPoint() . ', ';
					echo $dotcPoint->getPoint();

    	?>],
    	backgroundColor: "rgba(0,0,0,0)",
	  	borderColor: <?php echo '"rgba(' . SafetyPoints::getSuggestedColor($dotcPoint->getPoint(), true) . ',0.5)"'; ?>
	},
    {
      label: 'Per jaar',
      data: [<?php $dotc->pointsData() ?>],
      backgroundColor: "rgba(47,141,255,0.3)"
    }]
  }
});

var ctx = document.getElementById('toac').getContext('2d');
var myChart = new Chart(ctx, {
  type: 'line',
  options: {
    scales:
    {
        yAxes: [{
            display: true,        	
            ticks: {
            	beginAtZero: true,
            	suggestedMax: 5
        	}
        }]
    }, 	
  	tooltips: {
  		'enabled': false
  	}
  },
  data: {
    labels: [<?php $taoc->pointsYear() ?>],
    datasets: [{
		label: 'Totaal',    	
    	data: [<?php echo $toacPoint->getPoint() . ', ';
    				echo $toacPoint->getPoint() . ', ';
    				echo $toacPoint->getPoint() . ', ';
    				echo $toacPoint->getPoint() . ', ';
    				echo $toacPoint->getPoint();
    	 ?>],
		backgroundColor: "rgba(0,0,0,0)",
		borderColor: <?php echo '"rgba(' . SafetyPoints::getSuggestedColor($toacPoint->getPoint(), true) . ',0.5)"'; ?>

	},
	{    	
      label: 'Per jaar',
      data: [<?php $taoc->pointsData() ?>],
      backgroundColor: "rgba(47,141,255,0.3)"
    }]
  }
});
</script>