<?php
	
require_once(__DIR__ . '/../../config.php');
require_once(__DIR__ . '/../SafetyPoints.php');

$conn = $Database->getConn();


// Select all parkgarages with hood
$sql = "SELECT * FROM hood INNER JOIN parkgarage_address USING(hood_id) INNER JOIN parkgarage USING(parkgarage_address_id)";
$result = $conn->query($sql);

while($row = $result->fetch_array()) {
	$SafetyPoints = new SafetyPoints($row['parkgarage_id']);
	$points = $SafetyPoints->getPoint();

	$sql = "INSERT INTO hood_points (points, hood_id) VALUES ($points, $row[hood_id])";
	$conn->query($sql);
}
