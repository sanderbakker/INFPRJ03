<?php
	
require_once(__DIR__ . '/../../config.php');

$conn = $Database->getConn();


// Select all parkgarages with hood
$sql = "SELECT * FROM parkgarages INNER JOIN hood USING(hood_id)";
$result = $conn->query($sql);

while($row = $result->fetch_array()) {
	var_dump($row);
	echo "<br />";
}
