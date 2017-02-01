<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
  <h1>Training Course Feedback Form</h1>
  <p>Please help us to improve our class by completing this form.</p>

  <form:form action="next2">
    <dl>
      <dt>Favorite Section:</dt>
      <dd><select></select></dd>
      <form:input path="visitor.firstName" />
      <dt>Please rate the training:</dt>
      <dd><input type="radio" />1 <input type="radio" />2 <input type="radio" />3 <input type="radio" />4 <input type="radio" />5</dd>
      
      <dt>Please share with us your comments on how we can improve this class for future:</dt>
      <dd><textarea rows="6" cols="40"></textarea></dd>
    </dl>
    <input type="submit" name="submit" value="&lt; Back" />
    <input type="submit" name="submit" value="Continue &gt;" />
  </form:form>
  
</body>
</html>
