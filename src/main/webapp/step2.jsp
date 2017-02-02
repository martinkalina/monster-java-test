<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
  <h1>Training Course Feedback Form</h1>
  <p>Please help us to improve our class by completing this form.</p>

  <form:form action="submit2">
    <dl>
      <dt>Favorite Section:</dt>
      <dd><form:select path="favouriteSection" items="${sections}" itemLabel="name" itemValue="id"/></dd>
      <dt>Please rate the training:</dt>
      <dd><form:radiobuttons path="rating" items="${ratings}" /></dd>

      <dt>Please share with us your comments on how we can improve this class for future:</dt>
      <dd><form:textarea path="comment" rows="6" cols="40"/></dd>
    </dl>
    <input type="submit" name="submit" value="&lt; Back" />
    <input type="submit" name="submit" value="Continue &gt;" />
  </form:form>
  
</body>
</html>
