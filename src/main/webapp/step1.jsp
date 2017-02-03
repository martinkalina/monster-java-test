<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
<h1>Training Course Feedback Form</h1>
<p>Please help us to improve our class by completing this form.</p>

<form:form action="submit1" commandName="feedback">
    <dl>
        <dt>First Name:</dt>
        <dd><form:input path="visitor.firstName"/></dd>
        <dd><form:errors path="visitor.firstName" cssclass="error"/></dd>

        <dt>Last Name:</dt>
        <dd><form:input path="visitor.lastName"/></dd>
        <dd><form:errors path="visitor.lastName" cssclass="error"/></dd>

        <dt>Email Address:</dt>
        <dd><form:input path="visitor.emailAddress"/></dd>
        <dd><form:errors path="visitor.emailAddress" cssclass="error" /></dd>

        <dt>Training Course:</dt>
        <dd><form:select path="course" items="${courses}" itemLabel="name" /></dd>

        <dt>Training Course Date:</dt>
        <dd><form:input path="date"/></dd>
        <dd><form:errors path="date" cssclass="error" /></dd>

    </dl>
    <input type="submit" name="submit" value="&lt; Back" />
    <input type="submit" name="submit" value="Continue &gt;" />
</form:form>
</body>
</html>
