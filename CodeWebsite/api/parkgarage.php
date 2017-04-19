<?php

require_once('api_class.php');

$result = new Api(array(
	'get' 	=> $_GET,
	'table'	=> 'parkgarage'
));

$result->output();