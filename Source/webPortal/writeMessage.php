<?php
// Hilary Hastings, April 2015, reference sources www.php.net and www.w3c.schools.com/php
if ($_POST){
//format date
$message_text=stripslashes($_POST['message_text']);
$message_date=date("Ymd");
//$date_date = date('Ymd', strtotime($message_date));
$message_time=date("H:i");
//initialise database parameters
$servername = "mysql.abdn.ac.uk";
$port = 3306;
$username = "t02hah14_sistech";
$password = "sistech";
$dbname = "t02hah14_sistech";


// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
	die("Connection failed: " . $conn->connect_error);
}

// Already connected so just insert new reminder
$sql = "INSERT INTO messages (uid, message_stream, message_date, message_time, message_type, typed_message_text, s_uid)
		VALUES (1, 1, '$message_date', '$message_time', 'T','$message_text', 1) ";

if ($conn->query($sql) === TRUE) {
    //do nothing
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}
//close connection
$conn->close();
}
//return to calling php page
header("Refresh:0; url=supportedindividualpage.php");
?>