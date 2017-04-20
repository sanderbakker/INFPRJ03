<?php

require_once('api_class.php');

$result = new Api(array(
	'get' 			=> $_GET,
	'table'			=> '',
	'custom_query'	=> "SELECT * FROM damage_or_theft_car INNER JOIN hood USING(hood_id) INNER JOIN hood_points USING(hood_id)"
));

$result->output();