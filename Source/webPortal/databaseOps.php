<?php
$reminder_date='';
$reminder_time='';
$reminder_text='';
if ($_POST){
$reminder_date=stripslashes($_POST['reminder_date']);
$reminder_time=stripslashes($_POST['reminder_time']);
$reminder_text=stripslashes($_POST['reminder_text']);


// Already connected so just insert new reminder
$sql = "INSERT INTO reminders (uid, reminder_date, reminder_time_by, reminder_text, reminder_task_completed, s_uid)
		VALUES (1, $reminder_date, $reminder_time_by, $reminder_text, 0, 1)";

if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

?>