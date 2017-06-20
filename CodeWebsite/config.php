<?php

require_once('.env.php');

// Class which hold the database connecton
class Database {
	private $conn;

	// Constructor which creates the DB connection
	function __construct() {  
		GLOBAL $db;
		$this->conn = new mysqli($db['host'], $db['user'], $db['pass'], $db['dbname']);
		if ($this->conn->connect_error) {
	    	die("Connection failed: " . $conn->connect_error);
		}
	}

	// returns the connection 
	function getConn() {
		return $this->conn;
	}
}

// new Database instance
$Database = new Database();