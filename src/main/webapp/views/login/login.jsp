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
            <h2>Wavve 계정으로 로그인</h2>

            <form class="inputWrap">
                <div class="inputInnerWrap">
                    <input placeholder="이메일 주소 또는 아이디" />
                    <input placeholder="비밀번호" />
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
                    <p>회원가입</p>
                </div>

            </form>
        </div>
    </div>
</body>
</html>
</body>
</html>
