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

		$hood_name = '';

    	//loop through value's in dataset
    	foreach ($data as $key => $value) {

    		//retrieve the hood_name
    		if(!empty($value) && empty($hood_name)) {
    			$hood_name = $value;
    			$sql = "SELECT * FROM hood WHERE hood_name='$hood_name'";

    			if(!$result = $conn->query($sql)) {
		    		echo "Error: " . $sql . "<br>" . $conn->error;    				
    			}
				$hood = $result->fetch_assoc();

    			$hood_id = $hood['hood_id'];
    		}

    		//translate commas to dots.
    		$value = str_replace(',', '.', $value);

    		//check if value is a float
    		if(floatval($value)) {
    			//retrieve the year out of the header
    			$year = $header_array[$key];

    			$sql = "INSERT INTO damage_or_theft_car (hood_id, year, percentage) VALUES ($hood_id, $header_array[$key], '$value')";

				if(!$conn->query($sql)) {
		    		echo "Error: " . $sql . "<br>" . $conn->error;
				}    			
    		} else {
    			continue;
    		}
    	}
    }
?>