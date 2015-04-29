<?php
// Hilary Hastings, April 2015, reference sources www.php.net and www.w3c.schools.com/php
if ($_POST){
//format date, time and text of reminder
$reminder_date=stripslashes($_POST['reminder_date']);
$reminder_time=stripslashes($_POST['reminder_time']);
$reminder_text=stripslashes($_POST['reminder_text']);
$date_date = date('Ymd', strtotime($reminder_date));
$reminder_time=str_replace(":", "", $reminder_time);
$time_time=(int)$reminder_time;
$time_time*=100;
//set up database parameters
$servername = "mysql.abdn.ac.uk";
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
$sql = "INSERT INTO reminders (uid, reminder_date, reminder_time_by, reminder_text, reminder_task_completed, s_uid)
		VALUES (1, '$date_date', '$time_time', '$reminder_text', 0, 1) ";

if ($conn->query($sql) === TRUE) {
    //do nothing
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}
$conn->close();

}

//return to calling php page
header("Refresh:0; url=supportedindividualpage.php");

?>