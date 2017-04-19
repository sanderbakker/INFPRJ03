<?php

require_once(__DIR__ . '/../config.php');
require_once(__DIR__ . '/../scripts/SafetyPoints.php');

$conn = $Database->getConn();	

$parkgarage_code = $_GET['code'];

$sql = "SELECT * FROM parkgarage_details 
INNER JOIN parkgarage USING(parkgarage_code)
INNER JOIN parkgarage_address USING(parkgarage_address_id)
WHERE parkgarage_code='$parkgarage_code'";

$result = $conn->query($sql);
$data = $result->fetch_assoc();

$points = new SafetyPoints($data['parkgarage_id']);
$data['score'] = $points->getPoint();

$data['color'] = $points::getSuggestedColor($data['score']);

$json_data = json_encode($data);

print_r($json_data);
