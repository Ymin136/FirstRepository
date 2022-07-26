package service;

import java.util.HashMap;
import java.util.List;

import dto.BoardCommentDTO;
import dto.BoardDTO;
import dto.FileDTO;
import mapper.BoardMapper;

public class BoardService {
	private static BoardService instance = new BoardService();
	private BoardService() {
	}
	public static BoardService getInstance() {
		if(instance == null)
			instance = new BoardService();
		return instance;
	}
	public List<BoardDTO> selectBoardList(int pageNo) {
		return BoardMapper.getInstance().selectBoardList(pageNo);
	}
	public int selectAllCount() {
		return BoardMapper.getInstance().selectBoardCount();
	}
	public void insertBoard(BoardDTO dto) {
		BoardMapper.getInstance().insertBoard(dto);
	}
	public BoardDTO selectBoard(int bno) {
		return BoardMapper.getInstance().selectBoard(bno);
	}
	public void deleteBoard(int bno) {
		BoardMapper.getInstance().deleteBoard(bno);
	}
	public void updateBoard(BoardDTO dto) {
		BoardMapper.getInstance().updateBoard(dto);
	}
	public void addBoardCount(int bno) {
		BoardMapper.getInstance().addCountBoard(bno);
	}
	public int insertBoardLike(int bno,String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("id", id);
		int result = BoardMapper.getInstance().insertBoardLike(map);
		if(result == 0)
			BoardMapper.getInstance().deleteBoardLike(map);
		return result;
	}
	public int insertBoardHate(int bno, String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("id", id);
		System.out.println(map);
		int result = BoardMapper.getInstance().insertBoardHate(map);
		if(result == 0)
			BoardMapper.getInstance().deleteBoardHate(map);
		return result;
	}
	public void insertBoardComment(BoardCommentDTO boardCommentDTO) {
		BoardMapper.getInstance().insertBoardComment(boardCommentDTO);
	}
	public List<BoardCommentDTO> selectCommentList(int bno) {
		return BoardMapper.getInstance().selectBoardCommentList(bno);
	}
	public void deleteBoardComment(int cno) {
		BoardMapper.getInstance().deleteBoardComment(cno);		
	}
	public int insertBoardCommentLike(int cno, String id) {
		int result =BoardMapper.getInstance().insertBoardCommentLike(cno,id);
		if(result == 0)
			BoardMapper.getInstance().deleteBoardCommentLike(cno,id);
		return result;
	}
	public int insertBoardCommentHate(int cno, String id) {
		int result =BoardMapper.getInstance().insertBoardCommentHate(cno,id);
		if(result == 0)
			BoardMapper.getInstance().deleteBoardCommentHate(cno,id);
		return result;
	}
	public int selectBoardNo() {	
		return BoardMapper.getInstance().selectBoardNo();
	}
	public int insertFile(FileDTO file) {
		return BoardMapper.getInstance().insertFile(file);
	}
	public List<FileDTO> selectFileList(int bno) {
		return BoardMapper.getInstance().selectFileList(bno);
	}
	public FileDTO selectFile(int bno, int fno) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("fno", fno);
		return BoardMapper.getInstance().selectFile(map);
	}
	
}













