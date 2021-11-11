package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.control.CommandProcess;

public class LogoutService implements CommandProcess {

  @Override
  public String requestPro(HttpServletRequest request, HttpServletResponse response)
      throws Throwable {
    HttpSession session = request.getSession();

    // 특정 세션 제거
    session.removeAttribute("memName");
    session.removeAttribute("memId");
    session.removeAttribute("memEmail");

    // 세션 삭제
    session.invalidate();

    return "/member/logout.jsp";
  }

}
