<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>sistech als</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<link rel="stylesheet" type="text/css" href="SISTECHstyle.css"/>
	<link rel="stylesheet" type="text/css" href="jquery.ui.timepicker.css"/>
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script src="js/jquery.ui.timepicker.js"></script>	
	<script>
		$(document).ready(function(){
			$( "#datepicker" ).datepicker();
			$('#timepicker').timepicker();
		});
	</script>
	
</head>
<body>
<div id="container"><center>
 <?php include "header.php"?>
 <div class="innercontainer">
	<div class="contentcontainer">
	<div class="blurbcontainerleft">
	<div class="blurbheader"> Today's Reminders </div>
	<table>
	<th></th><th><th></th></th><th>Done?</th>
	
	<?php
		$servername = "mysql.abdn.ac.uk";
		$username = "t02hah14_sistech";
		$password = "sistech";
		$dbname = "t02hah14_sistech";
		$userid=1;
		$task_no=1;
		// Create connection and read tasks
		$conn = new mysqli($servername, $username, $password, $dbname);
		// Check connection
		if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
		}
		/*
		$sql = "SELECT rem_table_key, uid, reminder_date, reminder_time_by, reminder_text, reminder_task_completed FROM reminders
		WHERE s_uid =$userid AND reminder_task_completed =0
		ORDER BY reminder_date ASC , reminder_time_by ASC
		LIMIT 0 , 30";
		*/
		$sql = "SELECT rem_table_key, uid, reminder_date, reminder_time_by, reminder_text, reminder_task_completed FROM reminders
		WHERE s_uid =$userid
		ORDER BY reminder_date ASC , reminder_time_by ASC
		LIMIT 0 , 30";
		
		$result = $conn->query($sql);
		
		if ($result->num_rows > 0) {
		// output data of each row
		while($row = $result->fetch_assoc()) {
		echo "<tr>"; //create and format table rows using php, HTML and data read from database
		echo "<td>".$task_no." "."</td>";
		echo "<td>".$row["reminder_time_by"]."</td>";
		echo "<td>". $row["reminder_text"]."</td>";
		echo '<td>';
		//echo '<input type="checkbox" name="done" value="done"';
		if ($row["reminder_task_completed"]==1){
			// put a tick beside a task
			// echo 'checked>';
			echo '&#10003';
		}
		else{
			// no tick
			//echo '>';
		}
		echo "</tr>";
		$task_no+=1;
		}
		} else {
		echo "0 results";
		}
	?>
	</table>
	
	<form name="reminders" method="post" onsubmit=""
		action="writeReminder.php"> 
		<fieldset><div class="blurbheader"><br/>Type In A New Reminder Here</div>
			<div class="datetimecontainer">
				<br/><br/><label for="date">Date:</label><input type="text" id="datepicker" name="reminder_date" size="8"/>
				<label for="time">Time:</label><input type="text" id="timepicker" name="reminder_time" size="6"/><br/>
				<br/><label for="reminder">Reminder:</label><textarea name="reminder_text" id="reminder_text" rows="8" cols="33"></textarea><br/>
			</div> <!-- datetimecontainer -->
		</fieldset>
			<div class="lower">
				<input type="submit" class="submitreset" id="submit" name="submit" value="Add Reminder"/>
				<input type="reset" class="submitreset" id ="reset" name="reset" value="Reset"/>
			</div> <!--lower-->

	</form> 

	</div> <!-- end blurbcontainerleft -->

	<div class="blurbcontainerright">
	 <div class="blurbheader"> Today's Messages </div>
	 <table>
	 <th></th>
	 
	 <?php
	        $sql = "SELECT message_stream, message_type, s_uid, uid, message_number, image_message_path, typed_message_text, message_time, message_date
              FROM messages 
			  WHERE s_uid = 1 
			  AND uid = 1 
			  ORDER BY message_number ";
              
			  $result = $conn->query($sql);
              if ($result->num_rows > 0) {
                   // output data of each row
					while($row = $result->fetch_assoc()) {
						echo '<tr>'.'<td>';
						if($row["message_type"]=="I")
						{
							echo '<img src=' . $row['image_message_path'] . ' width="380" height="60" alt="word" />'.'</td></tr>';
						}
						else
						{
							echo $row["typed_message_text"].'</td></tr>';
						}
					}
             } else {
                    echo "0 results";
                    }
     ?>
	 </table>
   
   <form name="message" method="post" onsubmit=""
		action="writeMessage.php"> 
		<fieldset><div class="blurbheader"><br/>Type in a new message here</div>
			<br/><textarea name="message_text" id="message_text" rows="8" cols="33"></textarea><br/>			
			<input type="submit" class="submitreset" id="submit" name="submit" value="Add Message"/>
			<input type="reset" class="submitreset" id ="reset" name="reset" value="Reset"/>
		</fieldset>
	</form> 
	
	</div>
 <?php include "footer.php"?>           
  </div> <!-- content container -->
  
 </div> <!-- inner container -->
 
</center></div> <!-- container -->
</body>
</html>