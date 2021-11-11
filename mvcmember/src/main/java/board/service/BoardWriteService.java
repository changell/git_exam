package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.control.CommandProcess;
import board.bean.BoardDTO;
import board.dao.BoardDAO;
import member.bean.MemberDTO;

public class BoardWriteService implements CommandProcess {

  @Override
  public String requestPro(HttpServletRequest request, HttpServletResponse response)
      throws Throwable {
    // 세션 데이터
    HttpSession session = request.getSession(); // 세션 생성

    String id = (String) session.getAttribute("memId");		//문자열 형변환
    String name = (String) session.getAttribute("memName");
    String email = (String) session.getAttribute("memEmail");

    //MemberDTO memberDTO = (MemberDTO) session.getAttribute("membDTO");	//오브젝트 형변환
    //String name = memberDTO.getName();
    //String id = memberDTO.getId();
    //String email = memberDTO.getEmail() +"@"+memberDTO.getEmail2();
    
    // 디비 데이터
    String subject = request.getParameter("subject");
    String content = request.getParameter("content");

    
   
    //BoardDTO boardDTO = new BoardDTO();
    //boardDTO.setId(id);
    //boardDTO.setName(name);
    //boardDTO.setEmail(email);
    //boardDTO.setSubject(subject);
    //boardDTO.setContent(content);

    Map<String, String> map = new HashMap<String, String>();
    map.put("id", id);
    map.put("name", name);
    map.put("email", email);
    map.put("subject", subject);
    map.put("content", content);
    
    // DB
    BoardDAO boardDAO = BoardDAO.getInstance();
    //boardDAO.boardWrite(boardDTO);
    boardDAO.boardWrite(map);


    return "/board/boardWrite.jsp";
  }

}
