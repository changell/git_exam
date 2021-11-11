package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.control.CommandProcess;
import member.dao.MemberDAO;

public class LoginService implements CommandProcess {

  @Override
  public String requestPro(HttpServletRequest request, HttpServletResponse response)
      throws Throwable {
    // 데이터
    /* 아이디속성X 네임속성으로 데이터를 가져온다 */
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    String email = null;


    // DB
    MemberDAO memberDAO = MemberDAO.getInstance(); // 싱글톤 - 1번 생성해서 계속 사용한다.
    String name = memberDAO.login(id, pwd);// 호출
    if (name != null) {
      email = memberDAO.getEmail(id, pwd);
    }
    
    // 응답
    if (name == null) {
      return "/member/loginFail.jsp";
    } else {

      // return "/member/loginOk.jsp?name="+name; //get방법
      /*
       * // 쿠키 Cookie cookie = new Cookie("memName", name); // 쿠키생성(쿠키명, 값) cookie.setMaxAge(3); //
       * 쿠키적용시간 3초 -> 정보를 3초간만 유지해라 cookie.setPath("/"); // ex)만약 "/member/" 쓴다면, member폴더로 쿠키 전송해라
       * 의미 response.addCookie(cookie); // 클라이언트로 보내기
       * 
       * Cookie cookie2 = new Cookie("memId", id); // 쿠키생성(쿠키명, 값) cookie2.setMaxAge(3); // 쿠키적용시간
       * 3초 -> 정보를 3초간만 유지해라 cookie2.setPath("/"); response.addCookie(cookie2); // 클라이언트로 보내기
       */

      // 세션
      HttpSession session = request.getSession(); // 세션 생성
      session.setAttribute("memName", name);
      session.setAttribute("memId", id);
      session.setAttribute("memEmail", email);

      return "/member/loginOk.jsp";
    }
  }
}
