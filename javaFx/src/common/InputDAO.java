package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InputDAO {
	static Connection conn = null;
	
	public static void updateBoard(BoardVO vo) {
		String sql = "update input_board " //
				+ "		set publicity = ?, " //
			    + "			exit_date = ?, " //
			    + "			 contents = ? " //
			    + "	   where board_no = ?";
		conn = DBCon.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getPublicity());
			stmt.setString(2, vo.getExitDate());
			stmt.setString(3, vo.getContents());
			stmt.setInt(4, vo.getBoardNo());
			int r = stmt.executeUpdate();
			System.out.println("건 변경됨.");
		}catch
	}
	
	public static ObservableList<BoardVO> boardList(){
		String sql = "select * from input_board order by board_no";
		Statement stmt = null;
		ResultSet rs = null;
		ObservableList<BoardVO> boardList = FXCollections.observableArrayList();
		conn = DBCon.getConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBoardNo(rs.getInt("board_no"));
				vo.setContents(rs.getString("contents"));
				vo.setExitDate(rs.getString("exit_date"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setPublicity(rs.getString("publicity"));
				vo.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return boardList;
	}

	public static void insertBoard(InputBoardVO bo) {
		PreparedStatement pstmt = null;
		String sql = "insert into input_board values" + "((select nvl(max(board_no),0)+1 from input_board).?.?.?.?.?)";
		conn = DBCon.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bo.getTitle());
			pstmt.setString(2, bo.getPasswd());
			pstmt.setString(3, bo.getPublicity());
			pstmt.setString(4, bo.getExitDate());
			pstmt.setString(5, bo.getContents());
			int r = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
