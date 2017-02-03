<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <h1>Existing Feedbacks</h1>
    <c:choose>
        <c:when test="${not empty feedbacks}" >
            <table>
                <c:forEach items="${feedbacks}" var="feedback">
                    <tr>
                        <th>Course</th>
                        <th>Date</th>
                        <th>Visitor</th>
                        <th>Rating</th>
                        <th>Comment</th>
                        <th>Favorite Section</th>
                    </tr>
                    <tr>
                        <td>${feedback.course.name}</td>
                        <td>${feedback.date}</td>
                        <td>${feedback.visitor.firstName} ${feedback.visitor.lastName} (${feedback.visitor.emailAddress})</td>
                        <td>${feedback.rating}</td>
                        <td>${feedback.comment}</td>
                        <td>${feedback.favoriteSection.name}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <p>No feedbacks so far.</p>
        </c:otherwise>

    </c:choose>
    <button onclick="location.href='index.jsp'">&lt; Back</button>
</body>
</html>
