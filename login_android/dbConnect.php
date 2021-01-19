<?php
	// define('HOST','localhost');
	// define('USER','root');
	// define('PASS','');
	// define('DB','institution_x');

$HostName = "localhost";
$HostUser = "root";
$HostPass = "";
$DatabaseName = "institution_x";
	
$conn = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName) or die('Unable to Connect');

?>