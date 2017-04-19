
<?php
require_once('api_class.php');

$result = new Api(array(
	'get' 	=> $_GET,
	'table'	=> 'parkgarage_details'
));

$result->output();