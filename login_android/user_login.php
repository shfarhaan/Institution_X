<?php 

	if($_SERVER['REQUEST_METHOD']=='POST'){
		//Getting values 
		$email = $_POST['email'];
		$password = $_POST['password'];
		
		//Creating sql query
		$sql = "SELECT * FROM user_login WHERE email='$email' AND password='$password'";
		
		//importing dbConnect.php script 
		require_once('dbConnect.php');
		
		//executing query
		$result = mysqli_query($conn,$sql);
		
		//fetching result
		$check = mysqli_fetch_array($result);
		
		//if we got some result 
		if(isset($check)){
			//displaying success 
			echo "success";
		}else{
			//displaying failure
			echo "failure";
		}
		mysqli_close($conn);
    }
?>