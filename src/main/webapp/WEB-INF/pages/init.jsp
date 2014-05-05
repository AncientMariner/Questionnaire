<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Questionnaire</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <%--<link href="${pageContext.request.contextPath}/WEB-INF/WEB-INF/resources/css/bootstrap.css" rel="stylesheet">--%>
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
                    <a href="${pageContext.request.contextPath}/questionnaire/start/">Start questionnaire</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="content">
    <div class="welcome">
        <h4> Please proceed with questionnaire by clicking the start questionnaire item on the top </h4>
    </div>
    <div class="image">
        <img src="${pageContext.request.contextPath}/resources/img/last_action_hero.jpg" alt="here should be a picture"
             width=1280 height=960>
    </div>
</div>
</body>
</html>