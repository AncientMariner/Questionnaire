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
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="content">
        <div class="row">
            <div class="welcome">
                <ul class="contactList">
                    <li>Here is the about page. Please contact me by:</li>
                    <li>Email:</li>
                    <li><a href="https://github.com/AncientMariner">Github: AncientMariner</a></li>
                    <li>Twitter:</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>

</body>
</html>