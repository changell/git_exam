package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.control.CommandProcess;
import member.dao.MemberDAO;

public class CheckIdService implements CommandProcess {

  @Override
  public String requestPro(HttpServletRequest request, HttpServletResponse response)
      throws Throwable {

    // 데이터

    /* 아이디속성X 네임속성으로 데이터를 가져온다 */
    String id = request.getParameter("id");

    // DB
    MemberDAO memberDAO = MemberDAO.getInstance(); // 싱글톤 - 1번 생성해서 계속 사용한다.
    boolean exist = memberDAO.isCheckId(id);// 호출


    if (!exist) {
      return "/member/checkIdOk.jsp";
    } else {
      return "/member/checkIdFail.jsp";
    }
  }
}
