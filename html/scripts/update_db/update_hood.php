<?php

require_once(__DIR__ . '/../../config.php');

$conn = $Database->getConn();

$file = fopen('damage_or_theft_car.txt', 'r');

	$data_array = array();

    while(!feof($file)) {
        $data = fgets($file);
        $data = explode(';', $data);
        $data_array[] = $data;

    }
    fclose($file);

    // keep header seperate from the rest
    $header_array = $data_array[0];

    // delete header from the data_array
    unset($data_array[0]);

    foreach ($data_array as $data) {
    	//loop through value's in dataset
    	foreach ($data as $key => $value) {
    		if(!empty($value)) {
    			$sql = "INSERT INTO hood (hood_name) VALUES ('$value')";

				if(!$conn->query($sql)) {
		    		echo "Error: " . $sql . "<br>" . $conn->error;
				}
    			break;
    		}	
    	}
    } 

