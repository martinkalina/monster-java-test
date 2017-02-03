<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
  <h1>Training Course Feedback Form</h1>
  <p>Please help us to improve our class by completing this form.</p>
  
  <h2>Summary page</h2>
  <form:form action="submit3"  commandName="feedback"  >
  <dl>
    <dt>First Name:</dt>
    <dd><form:input disabled="true" path="visitor.firstName"/></dd>

    <dt>Last Name:</dt>
    <dd><form:input disabled="true" path="visitor.lastName"/></dd>

    <dt>Email Address:</dt>
    <dd><form:input disabled="true" path="visitor.emailAddress"/></dd>
    
    <dt>Training Course:</dt>
    <dd><form:input disabled="true" path="course.name"/></dd>
    
    <dt>Training Course Date:</dt>
    <dd><form:input disabled="true" path="date"/></dd>
    
    <dt>Favorite Section:</dt>
    <dd><form:input disabled="true" path="favoriteSection.name"/></dd>
    
    <dt>Rating:</dt>
    <dd><form:input disabled="true" path="rating"/></dd>
    
    <dt>Comments:</dt>
    <dd><form:input disabled="true" path="comment"/></dd>
  </dl>
    <input type="submit" name="submit" value="&lt; Back" />
    <input type="submit" name="submit" value="Send Feedback" />
  </form:form>


</body>
</html>
