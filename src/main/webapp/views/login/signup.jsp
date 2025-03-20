<%--
  Created by IntelliJ IDEA.
  User: Playdata
  Date: 2023-06-20
  Time: 오후 3:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Mavve 회원가입</title>
  <link rel="stylesheet" href="../style/reset.css">
  <link rel="stylesheet" href="../style/detail.css">
  <link rel="stylesheet" href="../style/login.css">
  <link rel="stylesheet" href="../style/signup.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"/>
</head>
<body>
<%@include file="../layout/header.jsp"%>
<div class="signupWrap">
  <div class="signupBox">
    <h2 class="join-hd">
      <div class = "aaa" style="margin-bottom: 30px">
        <span>Mavve 회원가입 환영합니다!</span>
        <br> <br>
      </div>
    </h2>
    <form action="/signup" method="post" class="inputWrap1">
      <div class="inputInnerWrap1">
        <input name="userName" placeholder="mavve 이름 설정" />
        <p class="loginerrortop">
          ◎본인의 이름을 입력해 주세요.
        </p>
        <input name="userId"placeholder="mavve 아이디 설정" />
        <p class="loginerrortop">
          ◎로그인은 비밀번호 찾기에 사용되니 정확한 아이디를 입력해 주세요.
        </p>
        <input name="userEmail" placeholder="mavve@example.com 입력" />
        <p style="font-size: 14px; color: #A5A5A5; margin-bottom: 16px;">
          ◎로그인, 비밀번호 찾기, 알림에 사용되니 정확한 이메일을 입력해 주세요.
        </p>
        <input name="userPwd" placeholder="mavve 비밀번호 설정" type="password"/>
        <p class="loginerrortop">
          ◎비밀번호는 8~20자 이내로 입력해 주세요.
        </p>
        <input name="userBirthdate" placeholder="mavve 생년월일 입력" />
        <p class="loginerrortop">
          ◎생년월일 6자리 입력해주세요.(Ex. 2000-01-01)
        </p>
        <input name="userPhonenumber" placeholder="mavve 010-0000-0000 입력" />
        <p class="loginerrortop">
          ◎- 를 같이 입력해주세요. (Ex. 010-1234-5678)
        </p>
      </div>
      <div class="signupBtnArea">
        <input type="submit" value="Mavve 회원가입" />
      </div>
    </form>
  </div>
</div>
</body>
</html>
</body>
</html>