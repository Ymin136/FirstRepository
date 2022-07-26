package mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.BoardCommentDTO;
import dto.BoardDTO;
import dto.FileDTO;

public class BoardMapper {
	private static BoardMapper instance = new BoardMapper();

	private BoardMapper() {

	}

	public static BoardMapper getInstance() {
		if(instance == null)
			instance = new BoardMapper();
		return instance;
	}

	public List<BoardDTO> selectBoardList(int pageNo) {
		SqlSession session = DBManager.getInstance().getSession();
		List<BoardDTO> list = session.selectList("selectBoardList", pageNo);
		session.close();
		return list;
	}

	public BoardDTO selectBoard(int bno) {
		SqlSession session = DBManager.getInstance().getSession();
		BoardDTO dto = session.selectOne("selectBoard", bno);
		session.close();
		return dto;
	}
	
	public int selectBoardCount() {
		SqlSession session = DBManager.getInstance().getSession();
		int result = session.selectOne("selectBoardCount");
		session.close();
		
		return result;
	}

	public int insertBoard(BoardDTO dto) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = session.insert("insertBoard", dto);
		session.commit();
		session.close();
		return result;
	}

	public int updateBoard(BoardDTO dto) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = session.update("updateBoard", dto);
		session.commit();
		session.close();
		return result;
	}

	public int insertBoardLike(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.insert("insertBoardLike", map);
			session.commit();
			session.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public int deleteBoardLike(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.insert("deleteBoardLike", map);
			session.commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public int insertBoardHate(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.insert("insertBoardHate", map);
			session.commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public int deleteBoardHate(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.insert("deleteBoardHate", map);
			session.commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public int addCountBoard(int bno) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.update("addCountBoard", bno);
			session.commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
		
	}

	public int insertBoardComment(BoardCommentDTO dto) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.insert("insertBoardComment", dto);
			session.commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;		
	}

	public int insertBoardCommentLike(int cno, String id) {
		SqlSession session = DBManager.getInstance().getSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cno", cno);
		map.put("id", id);
		int result = 0;
		try {
			result = session.insert("insertBoardCommentLike", map);
			session.commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;		
	}

	public int deleteBoardCommentLike(int cno, String id) {
		SqlSession session = DBManager.getInstance().getSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cno", cno);
		map.put("id", id);
		int result = 0;
		try {
			result = session.delete("deleteBoardCommentLike", map);
			session.commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;		
	}

	public int insertBoardCommentHate(int cno, String id) {
		SqlSession session = DBManager.getInstance().getSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cno", cno);
		map.put("id", id);
		int result = 0;
		try {
			result = session.insert("insertBoardCommentHate", map);
			session.commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;		
	}

	public int deleteBoardCommentHate(int cno, String id) {
		SqlSession session = DBManager.getInstance().getSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cno", cno);
		map.put("id", id);
		int result = 0;
		try {
			result = session.delete("deleteBoardCommentHate", map);
			session.commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;		
	}

	public int deleteBoardComment(int cno) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.delete("deleteBoardComment", cno);
			session.commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;		
		
	}

	public List<BoardCommentDTO> selectBoardCommentList(int bno) {
		SqlSession session = DBManager.getInstance().getSession();
		List<BoardCommentDTO> list = session.selectList("selectBoardCommentList", bno);
		session.close();
		return list;
	}

	public int deleteBoard(int bno) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.delete("deleteBoard", bno);
			session.commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;	
	}

	public int selectBoardNo() {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		result = session.selectOne("selectBoardNo");
		session.close();
		return result;
	}

	public int insertFile(FileDTO file) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		result = session.insert("insertFile",file);
		session.commit();
		session.close();
		return result;
	}

	public List<FileDTO> selectFileList(int bno) {
		SqlSession session = DBManager.getInstance().getSession();
		List<FileDTO> fList = session.selectList("selectFileList", bno);
		session.close();
		return fList;
	}

	public FileDTO selectFile(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		FileDTO dto = session.selectOne("selectFile", map);
		session.close();
		return dto;
	}
	
}










