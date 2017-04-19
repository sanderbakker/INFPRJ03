<?php

require_once(__DIR__ . '/../config.php');

class Api {
	private $output_array;
	private $conn;

	private $_GET;

	function __construct($array) {

		// Setup DB connection
		GLOBAL $Database;
		$this->conn = $Database->getConn();	

		// Retrieve needed variables from array
		$this->_GET 	= $this->sanitizeInputArray($array['get']); // Sanitize user input 
		$table 	= $array['table'];

		// Generate filters
		$filters = $this->generateFilters();

		// Build query 
		if(empty($filters)) {
			$sql = "SELECT * FROM $table";
		} else {
			$sql = "SELECT * FROM $table $filters";
		}

		if(isset($array['custom_query'])) {
			$sql = $array['custom_query'];

			if(isset($filters)) {
				$sql = $sql . $filters;
			}
		}

		// Execute query
		$result = $this->conn->query($sql);

		$output_array = array();

		if ($result->num_rows > 0) {
		    // save data of each row
		    while($row = $result->fetch_assoc()) {
		        $this->output_array[$table][] = $row;
		    }	
		} else {
			// Throw a warning when no results are found
		    $this->output_array['warning'] = 'No results found.';
		}
	}

	// Print the output in JSON 
	public function output() {
		print_r(json_encode($this->output_array));
	}

	// Sanitize user input
	private function sanitizeInputArray($array) {
		$return_array = array();
		foreach($array as $key => $value) {
			$new_key 				= $this->conn->real_escape_string($key);
			$return_array[$new_key] = $this->conn->real_escape_string($value);
		}

		return $return_array;
	}

	// Generate filters
	private function generateFilters() {
		$filters = '';

		foreach($this->_GET as $key => $value) {
			if(empty($filters)) {
				$filters = "WHERE $key='$value'";
			} else {
				$filters = $filters . " AND $key='$value'";
			}
		}

		return $filters;
	}
}


?>