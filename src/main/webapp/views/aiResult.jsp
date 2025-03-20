<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>ADMIN PAGE</title>
    <link rel="stylesheet" href="../style/reset.css">
    <link rel="stylesheet" href="../style/detail.css">
    <link rel="stylesheet" href="../style/login.css">
</head>
<body>
<%@include file="layout/header.jsp"%>

<div class="loginWrap">
    <div class="loginBox_admin">

        <h1 style="text-align: center; color: #fff; font-size: 24px; margin-bottom: 25px">AI 추천 결과 입니다.</h1>
<%--        <h1 style="text-align: center; color: #fff; font-size: 24px; margin-bottom: 25px">어떤 영화에 출연진을 삭제 하시겠어요 ?</h1>--%>
        <c:forEach items="${ai_result}" var="ai">
            <c:set var="trimmedAi" value="${fn:trim(ai)}" />
            <c:if test="${not empty trimmedAi}">
                <div style="color: #fff" class="menu_item">${trimmedAi}</div>
            </c:if>
        </c:forEach>
    </div>
</div>
</body>
</html>