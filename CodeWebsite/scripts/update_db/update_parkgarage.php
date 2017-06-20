<?php

require_once(__DIR__ . '/../../config.php');

$conn = $Database->getConn();

// Retrieve latest data from rdw.nl.	
$data = file_get_contents('https://opendata.rdw.nl/resource/kaqu-kwax.json');

// Translate JSON data to PHP objects.
$data = json_decode($data);

// count that keeps track of the inserted data.
$count = 0;

// Loop through rdw data 
foreach($data as $parkgarage) {

	// Don't use parkgarages which are "BETAALDP", we don't want those areas 
	if($parkgarage->usageid == "BETAALDP") {
		continue;
	}

	$parkgarage_code = $parkgarage->areaid;
	$parkgarage_name = $parkgarage->areadesc;

	// Check if we already know the parking garage
	$sql = "SELECT * FROM parkgarage WHERE parkgarage_code='$parkgarage_code'";
	$result = $conn->query($sql);
	
	$rows = $result->num_rows;

	// Insert new row for parkgarage if we don't know it yet 
	if($rows == 0) {
		$sql = "INSERT INTO parkgarage (parkgarage_name, parkgarage_code) VALUES ('$parkgarage_name', '$parkgarage_code')";

		// Increment the count which keeps track of inserted queries.
		$count++;
		if(!$conn->query($sql)) {
		    echo "Error: " . $sql . "<br>" . $conn->error;
		}
	}

}

echo 'Inserted rows: ' . $count;
