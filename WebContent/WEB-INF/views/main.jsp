<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar Producto</title>
</head>
<body>


<form:form action="${pageContext.request.contextPath}/formData" method="post" modelAttribute="product">

 <label>Ingrese el nombre del producto: </label><form:input type="text" name="name" path="name"/>
 <form:errors path="name" cssStyle="color:#E81505;"></form:errors><br>
 
 <label>Ingrese la marca del producto: </label><form:input type="text" name="marca" path="marca"/>
 <form:errors path="marca" cssStyle="color:#E81505;"></form:errors><br>

 <label>Ingrese la descripcion del producto: </label><form:input type="text" name="desc" path="desc"/>
 <form:errors path="desc" cssStyle="color:#E81505;"></form:errors><br>
 
 <label>Ingrese la categoria del producto: </label><form:input type="text" name="category" path="category"/>
 <form:errors path="category" cssStyle="color:#E81505;"></form:errors><br>
 
 <label>Ingrese el precio del producto: </label><form:input type="number" min="1" step="any" name="money" path="money"/>
 <form:errors path="money" cssStyle="color:#E81505;"></form:errors><br>

 <label>Ingrese la fecha del producto: </label><form:input type="text" path="fecha" field="*{date}" name = "fecha" />
 <form:errors path="fecha" cssStyle="color:#E81505;"></form:errors><br>

 <input type="submit" value="Add Product">
  
</form:form>
</body>
</html>