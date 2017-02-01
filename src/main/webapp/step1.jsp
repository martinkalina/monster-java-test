<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
<h1>Training Course Feedback Form</h1>
<p>Please help us to improve our class by completing this form.</p>

<form:form action="next1">
    <dl>
        <dt>First Name:</dt>

        <dd><form:input path="visitor.firstName"/></dd>

        <dt>Last Name:</dt>
        <dd><form:input path="visitor.lastName"/></dd>

        <dt>Email Address:</dt>
        <dd><form:input path="visitor.emailAddress"/></dd>

        <dt>Training Course:</dt>
        <dd><form:select path="course" items="${courses}" itemLabel="name" /></dd>
        <dt>Training Course Date:</dt>
        <dd><form:input path="date"/></dd>
    </dl>
    <input type="submit" name="submit" value="&lt; Back" />
    <input type="submit" name="submit" value="Continue &gt;" />
</form:form>
</body>
</html>
