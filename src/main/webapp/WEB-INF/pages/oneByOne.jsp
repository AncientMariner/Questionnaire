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
    <table>
        <tr>
            <td>Question</td>
            <td>Answer</td>
        </tr>

        <c:choose>
            <c:when test="${empty contentList}">
                No data currently added
            </c:when>
            <c:otherwise>
                <c:forEach items="${contentList}" var="content">
                    <form:form action="${pageContext.request.contextPath}/questionnaire/singleAnswer/"
                               modelAttribute="contentForm" method="POST">
                        <tr>
                            <td>
                                <span class="question">
                                    <input type="hidden" name="id" value="${content.id}"/>
                                    <input type="hidden" name="question" value="${content.question}"/>
                                    <c:out value="${content.question}"/>
                                </span>
                            </td>
                        <td>
                            <span class="answerToUpdate">
                            <form:input path="answer" type="text" value="${content.answer}"/>
                                <input type="submit" value="Update element" class="btn-mini">
                            </form:form>
                             </span>
                         </td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>

        <tr>
            <%--<td>--%>
                <%--<form:form action="${pageContext.request.contextPath}/questionnaire/more/" method="POST">--%>
                    <%--<input type="hidden" name="number" value="${fn:length(contentList)}"/>--%>
                    <%--<input type="submit" value="More" class="btn">--%>
                <%--</form:form>--%>
            <%--</td>--%>
        </tr>
    </table>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>