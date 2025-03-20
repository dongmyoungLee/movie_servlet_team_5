# Mavve
***
ChatGPT 기반 영화 추천 기능을 제공하는 Wavve 클론코딩 웹앱
***
&nbsp;
#  🎮 개발 동기
백엔드 개발에 입문하면서 실전 경험을 쌓기위해 Wavve 클론코딩 프로젝트를 진행하였습니다.
특히 MVC구조와 Java8을 활용하여 전통적인 웹 애플리케이션을 구현하는 법을 익히고 싶었습니다.
요즘 핫한 ChatGPT를 통한 영화를 추천받는 기능을 추가하여 클론코딩을 넘어 새로운 기능을 접목시키고 싶었습니다.


&nbsp;
***
&nbsp;

# 🎥 영상
[![영상](https://img.youtube.com/vi/7UMTDyJAuKY/0.jpg)](https://www.youtube.com/watch?v=7UMTDyJAuKY)


&nbsp;
***
# 👩‍🦲 팀원소개


1. 정준기 : https://github.com/JUNKI007
2. 이동명 : https://github.com/dongmyoungLee
3. 김정수 : https://github.com/Jeongsu6637
4. 박태홍 : https://github.com/ajtwu1235
5. 이세인 : https://github.com/sesam-me



&nbsp;
***
&nbsp;
# 🛠️ 기술 스택

### **Frontend**
![HTML](https://img.shields.io/badge/HTML-E34F26?style=flat&logo=html5&logoColor=white) ![CSS3](https://img.shields.io/badge/CSS-1572B6?style=flat&logo=css3&logoColor=white)
![JSP](https://img.shields.io/badge/JSP-4B4B77?style=flat&logo=&logoColor=white) ![JSTL](https://img.shields.io/badge/JSTL%201.2-FF160B?style=flat&logo=&logoColor=white)  ![Java Script](https://img.shields.io/badge/Java%20Script%20ES6-F7DF1E?style=flat&logo=javascript&logoColor=black) 



### **Backend**
![Java](https://img.shields.io/badge/Java8-FF7700?style=flat) ![JSP](https://img.shields.io/badge/JSP&Servlet-4B4B77?style=flat&logo=&logoColor=white) ![JDBC](https://img.shields.io/badge/JDBC-40AEF0?style=flat&logo=&logoColor=white)
![Apache Tomcat](https://img.shields.io/badge/Apache%20Tomcat-F8DC75?style=flat&logo=apachetomcat&logoColor=black) ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white) 
![CHATGPT](https://img.shields.io/badge/OpenAI-412991?style=flat&logo=openai&logoColor=white) 

### **DevOps & Tools**
![GitHub](https://img.shields.io/badge/GitHub-181717?style=flat&logo=github&logoColor=white) ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-000000?style=flat&logo=intellij-idea&logoColor=white) ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=flat&logo=postman&logoColor=black)

&nbsp;
***

&nbsp;
# 📂 레포지터리
- [GitHub](https://github.com/JUNKI007/Mavve)

&nbsp;
 
***
&nbsp;
# **💾  각 페이지별 주요 기능**
&nbsp;
#### **1️⃣ 홈 화면**
- main.jsp
- **인기영화 추천**: 홈화면으로 DB에 main_movie로 저장된 영화들을 추천영화로 나타내줍니다.

&nbsp;

#### **2️⃣ AI 관련**
- ai.jsp, aiResult.jsp  
- **AI를 이용한 영화 추천기능** : OpenAI의 API를 사용하여 영화를 추천받을 수 있게 하였습니다.
- 코스트가 저렴하지만 성능이 뛰어난 gpt 3.5 turbo 모델을 이용

&nbsp;

#### **3️⃣ 영화 상세 페이지**
- detail.jsp
- 특정 영화의 줄거리, 리뷰 등을 표시하는 페이지입니다.

&nbsp;

#### **4️⃣ 관리자 페이지**
- admin.jsp, adminMenu.jsp, addActor.jsp, addMovie.jsp, addSubMovie.jsp, showMovieList.jsp, showActorList.jsp
 - 관리자 기능으로, 영화 및 배우 등록이 가능하고, 영화를 각 장르별로 등록될 수 있게 함.
  - 등록된 영화나 배우를 조회할 수 있도록 함.
  - 로그인시 서버세션에 id가 admin일 경우, 관리자 view로 들어가게함



&nbsp;

#### **5️⃣ 회원 관련 페이지**
- login.jsp, logout.jsp, signup.jsp, findId.jsp, showId.jsp, findPassword.jsp, setPassword.jsp, editUserInfo.jsp
- 로그인 및 로그아웃, 비밀번호 찾기, 회원가입 기능
- 특정 회원 또는 모든 회원 조회 기능
- 유저정보 수정 (비밀번호 포함)


&nbsp;

#### **6️⃣ 헤더**
 - 상단 헤더로, 로그인하였을 때 admin과 일반회원은 표시되는 메뉴가 다르게 설정하였음.

  

&nbsp;

***
&nbsp;


