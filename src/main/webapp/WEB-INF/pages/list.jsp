<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Questionnaire</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <ul class="nav pull-left">
                <li>
                    <a class="brand"> Questionnaire </a>
                </li>
            </ul>
            <ul class="nav pull-right">
                <li>
                    <a href="${pageContext.request.contextPath}/questionnaire/about/">About</a>
                </li>
            </ul>
            <ul class="nav">
                <li>
                    <a href="${pageContext.request.contextPath}/questionnaire/init/">Back to Start page</a>
                </li>
            </ul>
        </div>
    </div>
</div>
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
    <span class="newElement">
        <fieldset>
            <form:form action="${pageContext.request.contextPath}/questionnaire/new/"
                       modelAttribute="contentForm" method="POST" >
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
                <%--<div class="formField">--%>
                    <%--<p>Question--%>
                        <%--&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp--%>
                        <%--Answer--%>
                    <%--</p>--%>
                <%--</div>--%>
                <%--<div class="formField">--%>
                    <%--<p><form:input path="question" type="text"/> <form:input path="answer" type="text"/>--%>
                    <%--</p>--%>
                <%--</div>--%>
                <%--<br/>--%>
                <%--<input type="submit" value="Save new element" class="btn">--%>
            <%--</form:form>--%>
        </fieldset>
    </span>
</div>
</body>
</html>