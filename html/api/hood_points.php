<?php

require_once('api_class.php');

$result = new Api(array(
	'get' 			=> $_GET,
	'table'			=> '',
	'custom_query'	=> "SELECT * FROM hood_points INNER JOIN hood USING(hood_id)"
));

$result->output();