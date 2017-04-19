<?php

require_once('api_class.php');

$result = new Api(array(
	'get' 	=> $_GET,
	'table'	=> 'damage_or_theft_car'
));

$result->output();