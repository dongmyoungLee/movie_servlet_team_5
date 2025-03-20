<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Movie_Team_5</title>
    <link rel="stylesheet" href="../style/reset.css">
    <link rel="stylesheet" href="../style/detail.css">
    <link rel="stylesheet" href="../style/login.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"/>
</head>
<body>
    <%@include file="../layout/header.jsp"%>
    <div class="loginWrap">
        <div class="loginBox">
            <h1>로그인</h1>
            <h2>Mavve 계정으로 로그인</h2>

            <form class="inputWrap" action="/login" method="post">
                <div class="inputInnerWrap">

                    <input placeholder="이메일 주소 또는 아이디" name="user_id_email" value="${id}"/>
                    <input placeholder="비밀번호" name="user_pwd" type="password"/>

                </div>

                <div class="checkBoxArea">

                    <div>


                        <%

                            Boolean isChecked =(Boolean)session.getAttribute("isChecked");

                            if(isChecked) {

                                %>

                        <input id="check1" type="checkbox" name="isChecked" checked />
                        <label for="check1" >아이디 저장</label> <%}
                        else {%>
                        <input id="check1" type="checkbox" name="isChecked" />
                        <label for="check1" >아이디 저장</label><%}%>


                    </div>

<%--                    <div>--%>
<%--                        <input id="check2" type="checkbox" />--%>
<%--                        <label for="check2" >자동 로그인</label>--%>
<%--                    </div>--%>

                </div>

                <div class="loginBtnArea">
                    <input type="submit" value="로그인" />
                </div>

                <div class="formBottomMenu">
                    <p><a href="/findId">아이디 찾기</a></p>
                    <p><a href="/findPassword">비밀번호 재설정</a></p>
                    <p><a href="/signup">회원가입</a></p>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
</body>
</html>
