<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
<h1><spring:message key="form.header"/></h1>
<p><spring:message key="form.text"/></p>

<form:form action="submit2" commandName="feedback">
    <dl>
        <dt><spring:message key="favorite.section"/></dt>
        <dd><form:select path="favoriteSection" items="${sections}" itemLabel="name" itemValue="id"/></dd>
        <dt><spring:message key="rate.training"/></dt>
        <dd><form:radiobuttons path="rating" items="${ratings}"/></dd>

        <dt><spring:message key="training.comments"/></dt>
        <dd><form:textarea path="comment" rows="6" cols="40"/></dd>
    </dl>
    <input type="submit" name="submit" value="<spring:message key="btn.back" />"/>
    <input type="submit" name="submit" value="<spring:message key="btn.continue" />"/>
</form:form>

</body>
</html>
