<?php

require_once(__DIR__ . '/../../config.php');

$conn = $Database->getConn();

// Retrieve latest data from rdw.nl.	
$data = file_get_contents('https://opendata.rdw.nl/resource/5c7g-8fuh.json');

// Translate JSON data to PHP objects.
$data = json_decode($data);

$count_insert = 0;
$count_update = 0;

foreach($data as $parkgarage) {
	$parkgarage_code 	= $parkgarage->areaid;
	$car_capacity 		= $parkgarage->capacity;
	$charging_capacity	= $parkgarage->chargingpointcapacity;

	// Check if we already know the parking garage
	$sql = "SELECT * FROM parkgarage_details WHERE parkgarage_code='$parkgarage_code'";
	$result = $conn->query($sql);
	
	$rows = $result->num_rows;

	// Insert new row for parkgarage if we don't know it yet 
	if($rows == 0) {
		$sql = "INSERT INTO parkgarage_details (parkgarage_code, car_capacity, charging_capacity) VALUES ('$parkgarage_code', '$car_capacity', '$charging_capacity')";

		// Increment the count which keeps track of inserted queries.
		$count_insert++;
	// Update the current row
	} else {
		$sql = "UPDATE parkgarage_details SET car_capacity='$car_capacity', charging_capacity='$charging_capacity' WHERE parkgarage_code='$parkgarage_code'";

		// Increment the count which keeps track of updated queries.
		$count_update++;
	}

	// Execute query
	if(!$conn->query($sql)) {
		echo "Error: " . $sql . "<br>" . $conn->error;
	}		

}

echo "Inserted queries: $count_insert | Updated queries: $count_update";