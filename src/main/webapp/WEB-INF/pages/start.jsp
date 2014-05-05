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
                    <a href="${pageContext.request.contextPath}/questionnaire/init/">Display the whole questionnaire list</a>
                </li>
            </ul>
            <ul class="nav">
                <li>
                    <a href="${pageContext.request.contextPath}/questionnaire/list/">Back to Start page</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="contentList">
    <c:forEach items="${contentList}" var="content">
        <span class="question">
            <c:out value="${content.question}"/>
        </span>
        <span class="answer">
            <c:out value="${content.answer}"/> <br/>
        </span>
    </c:forEach>
</div>
</body>
</html>