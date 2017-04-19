<?php

require_once('api_class.php');

$result = new Api(array(
	'get' 	=> $_GET,
	'table'	=> 'theft_outof_car'
));

$result->output();