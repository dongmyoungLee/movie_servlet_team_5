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
<%--                    로그인 화면에서 admin 전용 아이디와 비밀번호를 입력--%>
                    <input placeholder="이메일 주소 또는 아이디" type="text" name="user_id_email" />
                    <input placeholder="비밀번호" type="password" name="user_pwd" />
                </div>

                <div class="checkBoxArea">

                    <div>
                        <input id="check1" type="checkbox" />
                        <label for="check1" >아이디 저장</label>
                    </div>

                    <div>
                        <input id="check2" type="checkbox" />
                        <label for="check2" >자동 로그인</label>
                    </div>

                </div>

                <div class="loginBtnArea">
                    <input type="submit" value="로그인" />
                </div>

                <div class="formBottomMenu">
                    <p>아이디 찾기</p>
                    <p>비밀번호 재설정</p>
                    <p><a href="/signup">회원가입</a></p>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
</body>
</html>
