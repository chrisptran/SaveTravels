<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Edit Expense</title>
</head>
<body>
<h1>Edit Expense</h1>
<a href="/expenses">Go back</a>
<form:form action="/expenses/${expensed.id}/edit" mode="put" modelAttribute="expensed">
<div>
<form:errors path="expense" />
<form:label path="expense" for="expense">Expense Name: </form:label>
<form:input path="expense" type="text" />
</div>
<div>
<form:errors path="vendor" />
<form:label path="vendor" for="vendor">Vendor: </form:label>
<form:input path="vendor" type="text" />
</div>
<div>
<form:errors path="amount" />
<form:label path="amount" for="amount">Amount: </form:label>
<form:input path="amount" type="number" />
</div>
<div>
<form:errors path="description" />
<form:label path="description" for="description">Vendor: </form:label>
<form:input path="description" type="textarea" row="3" />
</div>
<div>
<input value="Submit" type="submit" />
</div>
</form:form>
</body>
</html>