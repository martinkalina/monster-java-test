<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
<h1><spring:message key="form.header"/></h1>
<p><spring:message key="form.text"/></p>

<h2><spring:message key="summary" /></h2>
<form:form action="submit3" commandName="feedback">
    <dl>
        <dt><spring:message key="visitor.firstName"/></dt>
        <dd><form:input disabled="true" path="visitor.firstName"/></dd>

        <dt><spring:message key="visitor.lastName"/></dt>
        <dd><form:input disabled="true" path="visitor.lastName"/></dd>

        <dt><spring:message key="visitor.email"/></dt>
        <dd><form:input disabled="true" path="visitor.emailAddress"/></dd>

        <dt><spring:message key="training.course"/></dt>
        <dd><form:input disabled="true" path="course.name"/></dd>

        <dt><spring:message key="training.course.date"/></dt>
        <dd><form:input disabled="true" path="date"/></dd>

        <dt><spring:message key="favorite.section"/></dt>
        <dd><form:input disabled="true" path="favoriteSection.name"/></dd>

        <dt><spring:message key="rating"/></dt>
        <dd><form:input disabled="true" path="rating"/></dd>

        <dt><spring:message key="comments" /> </dt>
        <dd><form:input disabled="true" path="comment"/></dd>
    </dl>
    <input type="submit" name="submit" value="<spring:message key="btn.back" />"/>
    <input type="submit" name="submit" value="<spring:message key="btn.send.feedback" />"/>
</form:form>


</body>
</html>
