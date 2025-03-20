package servlet;
import dao.UserDao;
import dto.UserDto;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.http.Cookie;
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("id");
        // 유저 아이디가 null이 아니면
        if(userId != null){
            req.setAttribute("id",userId);
            session.setAttribute("isChecked",true);
        }else{
            req.setAttribute("id",""); // 로그인 실패는 값이 없음(null)-> 아무 값도 저장X
            session.setAttribute("isChecked",false);
        }
        req.getRequestDispatcher("views/login/login.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      #1 wep에서 입력 받은 값 가져오기
//      로그인은 입력 칸이 2개이기 때문에, Parameter는 2개임
//      Parameter는 실제 DB변수명을 적어야함
        String userIdEmail = req.getParameter("user_id_email");
        String userPwd = req.getParameter("user_pwd");
        String isChecked = req.getParameter("isChecked");



//      #2 로그인 정보 저장
//      아이디로 로그인
        UserDto userDto1 = new UserDao().loginById(userIdEmail, userPwd);
//      이메일로 로그인
        UserDto userDto2 = new UserDao().loginByEmail(userIdEmail, userPwd);

//        TODO ||(또는) 없애는 방법으로도 할 수 있음
//        UserDto userDto3 = new UserDao().loginById(userIdEmail, userPwd);
//        if(userDto3==null)
//            userDto3 = new UserDao().loginByEmail(userIdEmail, userPwd);




//       TODO 로그인 성공/실패 하는걸 메소드로 빼라???
//      #3 로그인 성공/실패
//      userDto1 != null을 하면 오류 뜸 -> 왜? userDto1은 껍데기이지 null이 아님
//      userDto1.getUser_email()로 구체적인 값이 null인 걸 지정해줘야함..!
        HttpSession session = req.getSession();
        if(isChecked!=null){
            session.setAttribute("id",userIdEmail);
        }else{
            session.removeAttribute("id");
        }


        if(userDto1!= null || userDto2!= null) {

            Integer seq=userDto1.getUser_seq();
            if(userDto1==null){
                seq = userDto2.getUser_seq();
            }



            session.setAttribute("useq",seq);
            //  # 아이디 저장
          // 위에 Parameter에서 받아온 값을 세션에 저장

            resp.sendRedirect("/main");


//          로그인 실패 시.
//          #4 login페이지로 이동
        } else {
            resp.sendRedirect("/login");
        }




    }
}