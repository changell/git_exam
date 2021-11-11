package member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.bean.ZipcodeDTO;
import member.dao.MemberDAO;

public class CheckPostService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		//데이터
		String sido = request.getParameter("sido");			//리퀘스트겟파라미터 메소드를 사용하면 String 밖에서는 사용할 수 없다.
		String sigungu = request.getParameter("sigungu");
		String roadname = request.getParameter("roadname");
		
		
		System.out.println(sido + ", " + sigungu + ", " + roadname);
		
		//db
		List<ZipcodeDTO> list = null;
		
		if(sido != null && roadname != null) { //시도 로드네임 둘다 널이 아닐시 true 
			MemberDAO memberDAO = MemberDAO.getInstance(); //DAO 에 생성된 객체 를 가져온다.
			list = memberDAO.getZipcodeList(sido, sigungu, roadname);	//DAO에 zipcode리스트에 시, 군, 도 를 리스트 객체에 넣는다.
		}
		//응답
		request.setAttribute("list", list);
		
		return "/member/checkPost.jsp";
	}
}
