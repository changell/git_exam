package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import board.bean.BoardDTO;

public class BoardDAO {
  private Connection conn;
  private PreparedStatement pstmt;
  private ResultSet rs;

  private DataSource ds;// connection pool안에있는 데이터를 처리해주는 (관리인)

  private static BoardDAO instance = null;

  SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");// 자바에서는 대문자 MM이 월이다.

  public static BoardDAO getInstance() {/* 인스턴스 - 메모리 생성 */
    if (instance == null) {/* 인스턴스가 null일경우는 처음 시작할때 1번밖에 없다 */
      synchronized (BoardDAO.class) {/* 쓰레드처리 동시에 접속할떄 줄세워서 처리 */
        instance = new BoardDAO();// 객체생성
      }
    }
    return instance;
  }

}

