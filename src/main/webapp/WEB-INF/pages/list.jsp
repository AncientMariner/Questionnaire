<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Questionnaire</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="contentList">
    <c:choose>
        <c:when test="${empty contentList}">
            No data currently added
        </c:when>
        <c:otherwise>
            <c:forEach items="${contentList}" var="content">
                <span class="question">
                    <c:out value="${content.question}"/>
                </span>
                <span class="answer">
                    <c:out value="${content.answer}"/> <br/>
                </span>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    <a href="${pageContext.request.contextPath}/questionnaire/new/">
        <h3 class="btn">add default one</h3> <br/>
    </a>
    <form:form action="${pageContext.request.contextPath}/questionnaire/more/" method="POST">
        <input type="hidden" name="number" value="${fn:length(contentList)}"/>
        <input type="submit" value="More" class="btn">
    </form:form>
</div>
<div class="newElement">
    <form:form action="${pageContext.request.contextPath}/questionnaire/new/"
               modelAttribute="contentForm" method="POST">
        <table>
            <tr>
                <td>Question</td>
                <td>Answer</td>
            </tr>
            <tr>
                <td><form:input path="question" type="text"/></td>
                <td><form:input path="answer" type="text"/></td>
            </tr>
        </table>
        <input type="submit" value="Save new element" class="btn">
    </form:form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>