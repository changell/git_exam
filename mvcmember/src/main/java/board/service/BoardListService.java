package board.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.control.CommandProcess;
import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardListService implements CommandProcess {

  @Override
  public String requestPro(HttpServletRequest request, HttpServletResponse response)
      throws Throwable {

    // 데이터pg값 받기
    int pg = Integer.parseInt(request.getParameter("pg"));

    // 페이징 처리 - 1페이지당 5개씩
    int endNum = pg * 5;
    int startNum = endNum - 4;

    // DB
    BoardDAO boardDAO = BoardDAO.getInstance();
    List<BoardDTO> list = boardDAO.boardList(startNum, endNum);

    // 페이징처리
    int totalA = boardDAO.getTotalA(); // 총글수
    int totalP = (totalA + 4) / 5;// 페이지 번호 한페이지에 5개씩나올경우 => (총개수+(페이지당개수-1))/페이지당개수

    request.setAttribute("totalP", totalP);

    request.setAttribute("list", list);
    
    request.setAttribute("pg", pg);


    return "/board/boardList.jsp?pg=" + pg;
  }

}
