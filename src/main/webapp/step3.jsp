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
  
  <form action="step2.jsp" style="display: inline">
    <input type="submit" value="&lt; Back" />
  </form>
  
  <form action="index.jsp" style="display: inline">
    <input type="submit" value="Send Feedback" style="font-weight: bold" />
  </form>
</body>
</html>
