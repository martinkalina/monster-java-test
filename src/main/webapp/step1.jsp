<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
<h1><spring:message key="form.header"/></h1>
<p><spring:message key="form.text" /></p>

<form:form action="submit1" commandName="feedback">
    <dl>
        <dt><spring:message key="visitor.firstName"/></dt>
        <dd><form:input path="visitor.firstName"/></dd>
        <dd><form:errors path="visitor.firstName" cssclass="error"/></dd>

        <dt><spring:message key="visitor.lastName"/></dt>
        <dd><form:input path="visitor.lastName"/></dd>
        <dd><form:errors path="visitor.lastName" cssclass="error"/></dd>

        <dt><spring:message key="visitor.email"/></dt>
        <dd><form:input path="visitor.emailAddress"/></dd>
        <dd><form:errors path="visitor.emailAddress" cssclass="error" /></dd>

        <dt><spring:message key="training.course"/></dt>
        <dd><form:select path="course" items="${courses}" itemLabel="name" /></dd>

        <dt><spring:message key="training.course.date"/></dt>
        <dd><form:input path="date"/></dd>
        <dd><form:errors path="date" cssclass="error" /></dd>

    </dl>
    <input type="submit" name="submit" value="<spring:message key="btn.back"/>" />
    <input type="submit" name="submit" value="<spring:message key="btn.continue" />" />
</form:form>
</body>
</html>
