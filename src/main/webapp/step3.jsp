<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
  <h1>Training Course Feedback Form</h1>
  <p>Please help us to improve our class by completing this form.</p>
  
  <h2>Summary page</h2>
  <dl>
    <dt>First Name:</dt>
    <dd></dd>
    
    <dt>Last Name:</dt>
    <dd></dd>
    
    <dt>Email Address:</dt>
    <dd></dd>
    
    <dt>Training Course:</dt>
    <dd></dd>
    
    <dt>Training Course Date:</dt>
    <dd></dd>
    
    <dt>Favorite Section:</dt>
    <dd></dd>
    
    <dt>Rating:</dt>
    <dd></dd>
    
    <dt>Comments:</dt>
    <dd></dd>
  </dl>
  
  <form action="/submit3" style="display: inline">
    <input type="submit" name="submit" value="&lt; Back" />
    <input type="submit" name="submit" value="Continue &gt;" />
  </form>
  
</body>
</html>
