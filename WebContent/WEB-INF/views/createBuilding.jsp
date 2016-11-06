<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Building Creator Application</title>
<link rel='stylesheet' href='<c:url value="/resources/css/style.css" />'
	type='text/css' media='all' />
</head>
<body>
	<h2>Create Building</h2>
	<div id="content">
		<form:form id="createBuildingForm" action="/CreateBuildingApp/createBuilding" method="POST">
			<table>
				<tr>
					<td><form:label path="name">Name:</form:label></td>
					<td><form:input path="name" maxlength="45" required="required"/></td>
				<tr>
        			<td><form:label path="address.street1">Street Line 1:</form:label></td>
        			<td><form:input path="address.street1" maxlength="45" required="required"/></td>
    			</tr>
    			<tr>
        			<td><form:label path="address.street2">Street Line 2:</form:label></td>
        			<td><form:input path="address.street2" /></td>
    			</tr>
    			<tr>
        			<td><form:label path="address.city">City:</form:label></td>
        			<td><form:input path="address.city" maxlength="45" required="required"/></td>
    			</tr>
    			<tr>
        			<td><form:label path="address.state">State:</form:label></td>
        			<td><form:input path="address.state" maxlength="45" required="required"/></td>
    			</tr>
    			<tr>
        			<td><form:label path="address.zipCode">Zip Code:</form:label></td>
        			<td><form:input path="address.zipCode" maxlength="5" required="required"/></td>
    			</tr>
    			
    			<tr>
        			<td colspan="2">
            			<input id="createBtn" name="create" type="submit" value="Create" />
        			</td>
        			<td colspan="2">
            			<input id="cancelBtn" name="cancel" type="submit" value="Cancel" />
        			</td>
    			</tr>
			</table> 
		</form:form>
	</div>
</body>
</html>