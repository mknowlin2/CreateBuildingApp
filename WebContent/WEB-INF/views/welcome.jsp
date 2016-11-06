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
	<h2>Sample Building Creator Application</h2>
	
	<div id="content">
		<p>Current Building List</p>
		<c:if test="${not empty buildingList}">
			<form:form id="buildingListForm" action="/CreateBuildingApp/viewBuilding" method="GET">
				<table id="buildingListTbl">
					<thead>
						<tr>
							<td>Building Id</td>
							<td>Building Name</td>
						</tr>
					</thead>
					<c:forEach  var="building" varStatus="row" items="${buildingList}" >
						<tr>
							<td><input type="submit" name="buildingId" value="${building.buildingId}" /></td>
							<td>${building.name}</td>
						</tr>
					</c:forEach>
				</table>
			</form:form>
			<form:form id="addBuildingForm" action="/CreateBuildingApp/building" method="GET">
				<input type="submit" value="Create Building" />
			</form:form>
		</c:if>
	</div>
</body>
</html>