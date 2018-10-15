
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<title>List Customers</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	
</head>

<body>

	
	<h1>ADDRESS BOOK</h1>
	
	
	<div id="container">
		<div id="content">
			<!-- put new button:Addcontact -->
			
			<input type="button" value="Add Contact"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="btn btn-default"
			/>
			
			
			<!-- add our html table here -->
		
			<table class="table table-bordered">
				<tr>
					<th>Name</th>
					<th>Address</th>
					<th>Picture</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our contacts -->
				
				<c:forEach var="tempContact" items="${contacts}">
				
					<!-- construct an "update link" with contact id -->
					<c:url var="updateLink" value="/contact/showFormForUpdate">
						<c:param name="contactId" value="${tempContact.id} "/>
					</c:url>
					
					<!-- construct an "delete" link with contact id -->
					<c:url var="deleteLink" value="/contact/delete">
						<c:param name="contactId" value="${tempContact.id} "/>
					</c:url>
					
					<tr>
						<td> ${tempContact.name} </td>
						<td> ${tempContact.address} </td>
						<td><img src="${tempContact.picture}" alt="Responsive image" class="img-thumbnail">  </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							
							<!-- display the delete link -->
							<a href="${deleteLink}"
							   onClick="if(!(confirm('Delete this contact?'))) return false">| Delete</a>
						</td>
	
					</tr>
					
				</c:forEach>
				
			</table>
		
		</div>
	</div>
	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</body>

</html>