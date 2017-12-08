<html>
<body>
	<h1>${headerMessage}</h1>
	<h3>
		Congratulations !! The Application has been submitted successfully
		</h3>
		
	<h2>Details Submitted by you</h2>

		<table>
			<tr>
				<td>Student Name :</td>
<%-- 				<td>${student1.studentName}</td> --%>
				<td>${studentInfo.studentName}</td>
			</tr>
			<tr>
				<td>Student Hobby :</td>
				<td>${studentInfo.studentHobby}</td>
			</tr>
			<tr>
				<td>Student Mobile :</td>
				<td>${studentInfo.studentMobile}</td>
			</tr>
			<tr>
				<td>Student DOB :</td>
				<td>${studentInfo.studentDOB}</td>
			</tr>
			<tr>
				<td>Student Skills :</td>
				<td>${studentInfo.studentSkills}</td>
			</tr>
		</table>
		<table>
			<tr>
				<td>Student Address :</td>
			</tr>
			<tr>
				<td>Country :</td> <td>${studentInfo.studentAddress.country}</td>
			</tr>
			<tr>
				<td>City : </td> <td>${studentInfo.studentAddress.city}</td>
			</tr>
			<tr>			
				<td>Street : </td> <td>${studentInfo.studentAddress.street}</td>
			</tr>
			<tr>
				<td>Pincode : </td> <td>${studentInfo.studentAddress.pincode}</td>
			</tr>		
		</table>
</body>
</html>