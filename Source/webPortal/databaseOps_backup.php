<!-- DEFUNCT -->
<?php
if ($_POST){
$reminder_date=stripslashes($_POST['reminder_date']);
$reminder_time=stripslashes($_POST['reminder_time']);
$reminder_text=stripslashes($_POST['reminder_text']);

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
		VALUES (1, '$reminder_date', '$reminder_time', '$reminder_text', 0, 1) ";

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