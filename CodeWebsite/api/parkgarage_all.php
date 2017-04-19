<?php

require_once('api_class.php');

$result = new Api(array(
	'get' 			=> $_GET,
	'table'			=> '',
	'custom_query'	=> "SELECT * FROM parkgarage 
INNER JOIN parkgarage_details USING(parkgarage_code)
INNER JOIN parkgarage_address USING(parkgarage_address_id)"
));

$result->output();