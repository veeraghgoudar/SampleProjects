<html>
<style>

.errorMessage{
	color:red;
}

</style>
<body>
<div>
	<h1>MVC Spring Framework Demo</h1>
	<h1>${headerMessage}</h1>
	<!-- These are spring objects -->
	<h2>${WelcomeMessage}</h2>
	<form action="/SpringMVCproject/admissionForm.html"
		method="post">
		<p>
			User Name : <input type="text" name="username" />
		</p>

		<p>
			Password : <input type="text" name="password" />
		</p>
		<input type="submit" value="submit" />
	</form>
</div>
<div>
	<p class="errorMessage">${validationMessage}</p>
</div>
</body>
</html>