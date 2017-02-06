<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
    <h1><spring:message key="existing.feedbacks" /></h1>
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
            <p><spring:message key="no.feedbacks" /></p>
        </c:otherwise>

    </c:choose>
    <button onclick="location.href='/'"><spring:message key="btn.back" /></button>
</body>
</html>
