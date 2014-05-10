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
            <form:form action="${pageContext.request.contextPath}/questionnaire/singleAnswer/${content.id}"
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
    </table>
</div>
<div class="numbersList">
    <c:choose>
        <c:when test="${empty numberSet}">
            No data currently added
        </c:when>
        <c:otherwise>
            <c:if test="${content.id ne 1}">
                <a href="${pageContext.request.contextPath}/questionnaire/singleAnswer/${1}">&lt&lt</a>
            &nbsp
            </c:if>
            <c:if test="${content.id gt 1}">
                <a href="${pageContext.request.contextPath}/questionnaire/singleAnswer/${content.id-1}">&lt</a>
            &nbsp&nbsp&nbsp
            </c:if>

            <c:forEach items="${numberSet}" var="number">
                    <a href="${pageContext.request.contextPath}/questionnaire/singleAnswer/${number}">
                        <%--<c:if test="${fn:length(numberSet) > 5}">--%>
                        <%--</c:if>--%>
                        <c:if test="${number eq content.id}">&gt</c:if>
                        <c:out value="${number}"/>
                        <c:if test="${number eq content.id}">&lt</c:if>
                    </a>
            </c:forEach>
            <c:if test="${fn:length(numberSet) gt 1 and content.id ne fn:length(numberSet)}">
            &nbsp&nbsp&nbsp
                <a href="${pageContext.request.contextPath}/questionnaire/singleAnswer/${content.id+1}">&gt</a>
            </c:if>
            <c:if test="${content.id ne fn:length(numberSet)}">
            &nbsp
                <a href="${pageContext.request.contextPath}/questionnaire/singleAnswer/${fn:length(numberSet)}">&gt&gt</a>
            </c:if>
        </c:otherwise>
    </c:choose>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>