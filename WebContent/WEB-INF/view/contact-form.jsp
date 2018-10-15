<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>Save Contact</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

</head>

<body>


	<div class="col-lg-4 col-lg-offset-4">
		<h1>Save Contact</h1>

		<form:form action="saveContact" modelAttribute="contact" method="POST">

			<!-- associate this data with the contact id -->
			<form:hidden path="id" />

			<div class="form-group">
				<label for="exampleInputName2">Name</label> <input path="name" type="text"
					class="form-control" id="exampleInputName2" placeholder="Name">
			</div>

			<div class="form-group">
				<label for="exampleInputName2">Address</label> <input path="address"  type="text"
					class="form-control" id="exampleInputName2" placeholder="Address">
			</div>

			<div class="form-group">
				<label for="exampleInputFile">File input</label> <input type="file"
					id="exampleInputFile">
				<p class="help-block">Example block-level help text here.</p>
			</div>
			
			<td><input type="submit" value="Save" class="btn btn-default" /></td>
			

		</form:form>



		

	</div>

	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>

</body>

</html>