<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<style>
.errorMessage {
	color: red;
}
</style>
<body>
	<h1>${headerMessage}</h1>
	<h2>Student Admission form for Colleges</h2>
	<div>
		<form action="/SpringMVCproject/submitAdmissionForm.html"
			method="post">

			<table>
				<tr>
					<td>Students Name :</td>
					<td><input type="text" name="studentName" /></td>
				</tr>
				<tr>
					<td>Students Hobby :</td>
					<td><input type="text" name="studentHobby" /></td>
				</tr>
				<tr>
					<td>Students Mobile :</td>
					<td><input type="text" name="studentMobile" /></td>
				</tr>
				<tr>
					<td>Students DOB :</td>
					<td><input type="text" name="studentDOB" /></td>
				</tr>


				<tr>
					<td>Students Skills Sets :</td>
					<td><select name="studentSkills" multiple />
						<option value="Java Core">Java Core</option>
						<option value="Spring Core">Spring Core</option>
						<option value="Spring MVC">Spring MVC</option> </select></td>
				</tr>

				<table>
					<tr>
						<td>Students Address :</td>

					</tr>
					<tr>
						<td>Country : <input type="text"
							name="studentAddress.country" />
						</td>
						<td>City : <input type="text" name="studentAddress.city" />
						</td>
						<td>Street : <input type="text" name="studentAddress.street" />
						</td>
						<td>Pincode : <input type="text"
							name="studentAddress.pincode" />
						</td>
					</tr>

				</table>

				<tr>
					<td><input type="submit" value="submit" /></td>
				</tr>

			</table>
			<!-- <table>
			
			
			
			<tr><td><input type="submit" value="submit" /> </td></tr>
									
		</table> -->
			<!-- 
		<p>
			Students Name : <input type="text" name="studentName" />
		</p>

		<p>
			Students Hobby : <input type="text" name="studentHobby" />
		</p>
		
		<p>
			<input type="submit" value="submit" /> 
		</p> -->
		</form>
	</div>
	<div>
		<form:errors class="errorMessage" path="studentInfo.*" />
	</div>
</body>
</html>