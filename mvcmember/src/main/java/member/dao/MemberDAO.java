package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public class MemberDAO {
  private Connection conn;
  private PreparedStatement pstmt;
  private ResultSet rs;

  private DataSource ds;

  private static MemberDAO instance = null;

  // 싱글톤
  public static MemberDAO getInstance() {/* 인스턴스 - 메모리 생성 */
    if (instance == null) {/* 인스턴스가 null일경우는 처음 시작할때 1번밖에 없다 */
      synchronized (MemberDAO.class) {/* 쓰레드처리 동시에 접속할떄 줄세워서 처리 */
        instance = new MemberDAO();// 객체생성
      }
    }
    return instance;
  }

  // driver loading
  public MemberDAO() {
    try {
      // Context는 인터페이스
      Context ctx = new InitialContext();
      // Tomcat의경우에만 "java:comp/env/"이 추가된다
      ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");// Tomcat의경우 java:comp/env 접두사가 꼭
                                                                // 들어가주어야한다.

    } catch (NamingException e) {
      e.printStackTrace();
    }
  }

  // Connection

  public void write(MemberDTO memberDTO) {
    String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";


    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(sql);// 생성

      pstmt.setString(1, memberDTO.getName());
      pstmt.setString(2, memberDTO.getId());
      pstmt.setString(3, memberDTO.getPwd());
      pstmt.setString(4, memberDTO.getGender());
      pstmt.setString(5, memberDTO.getEmail1());
      pstmt.setString(6, memberDTO.getEmail2());
      pstmt.setString(7, memberDTO.getTel1());
      pstmt.setString(8, memberDTO.getTel2());
      pstmt.setString(9, memberDTO.getTel3());
      pstmt.setString(10, memberDTO.getZipcode());
      pstmt.setString(11, memberDTO.getAddr1());
      pstmt.setString(12, memberDTO.getAddr2());

      pstmt.executeUpdate();// 실행
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (pstmt != null)
          pstmt.close();
        if (conn != null)
          conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public String login(String id, String pwd) {
    String name = null;
    String sql = "select * from member where id=? and pwd=?";
    MemberDTO memberDTO = null;
    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, pwd);

      rs = pstmt.executeQuery();// 실행

      if (rs.next())
        name = rs.getString("name");

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (rs != null)
          rs.close();
        if (pstmt != null)
          pstmt.close();
        if (conn != null)
          conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return name;
  }

  public boolean isCheckId(String id) {
    boolean exist = false;
    String sql = "select * from member where id=?";

    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);

      rs = pstmt.executeQuery();// 실행

      if (rs.next())
        exist = true;

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (rs != null)
          rs.close();
        if (pstmt != null)
          pstmt.close();
        if (conn != null)
          conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return exist;

  }


  public String getEmail(String id, String pwd) {
    String email = null;
    String email1 = null;
    String email2 = null;

    String sql = "select * from member where id=? and pwd=?";

    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, pwd);

      rs = pstmt.executeQuery();// 실행

      if (rs.next()) {
        email1 = rs.getString("EMAIL1");
        email2 = rs.getString("EMAIL2");
        email = email1 + "@" + email2;
        System.out.println(email1);
        System.out.println(email2);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (rs != null)
          rs.close();
        if (pstmt != null)
          pstmt.close();
        if (conn != null)
          conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return email;
  }

public List<ZipcodeDTO> getZipcodeList(String sido, String sigungu, String roadname) {
	List<ZipcodeDTO> list = new ArrayList<ZipcodeDTO>();
	String sql = "select * from newzipcode where sido like ? and sigungu like ? and roadname like ?";
	
	try {
		conn = ds.getConnection();
		
		pstmt = conn.prepareStatement(sql); //생성
		pstmt.setString(1, "%" + sido + "%");
		pstmt.setString(2, "%" + sigungu + "%");
		pstmt.setString(3, "%" + roadname + "%");
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			ZipcodeDTO zipcodeDTO = new ZipcodeDTO();
			zipcodeDTO.setZipcode(rs.getString("zipcode"));
			zipcodeDTO.setSido(rs.getString("sido"));
			zipcodeDTO.setSigungu(rs.getString("sigungu"));
			zipcodeDTO.setYubmyundong(rs.getString("yubmyundong"));
			zipcodeDTO.setRi(rs.getString("ri"));
			zipcodeDTO.setRoadname(rs.getString("roadname"));
			zipcodeDTO.setBuildingname(rs.getString("buildingname"));
			
			list.add(zipcodeDTO);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		list = null; // 
	} finally {
	      try {
	          if (rs != null)
	            rs.close();
	          if (pstmt != null)
	            pstmt.close();
	          if (conn != null)
	            conn.close();
	        } catch (SQLException e) {
	          e.printStackTrace();
	        }
	      }
	
	return list;
}

}
