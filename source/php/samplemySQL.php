			<!-- read name, bio, favouriteNumber, project, imageURL FROM researchers table in hawk.csd.abdn.ac.uk database -->
			<?php 
				$con = mysql_connect("hawk.csd.abdn.ac.uk", "wtstudent", "DyNEDurA");
				if (!$con)
				{die('Could not connect: '.my_sql_error());} //error if connection fails
				mysql_select_db("webtech", $con); //otherwise connect and retrive data
				$result = mysql_query("SELECT name, bio, favouriteNumber, project, imageURL FROM researchers");
			?>
			
			<table class="projecttable">
				<tr>
					<th>Name</th><!-- table header row -->
					<th>Bio</th>
					<th>Favourite Number</th>
					<th>Project</th>
					<th>Image</th>
				</tr>
				<?php
					while($row=mysql_fetch_array($result))// read all rows from "researchers" table
					{
						echo "<tr>"; //create and format table rows using php, HTML and data read from database
						echo "<td>".$row['name']."</td>";
						echo "<td>".$row['bio']."</td>";
						echo "<td>".$row['favouriteNumber']."</td>";
						echo "<td>".$row['project']."</td>";
						echo "<td>".'<img name="myimage" src=' . $row['imageURL'] . ' width="60" height="60" alt="word" />'."</td>";
						echo "</tr>";
						
					}
					mysql_close($con);//close "researchers" database connection
				?>
				
			</table>
