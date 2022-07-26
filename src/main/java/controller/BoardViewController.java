package controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardCommentDTO;
import dto.BoardDTO;
import dto.FileDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		HashSet<Integer> set = (HashSet<Integer>) request.getSession().getAttribute("bno_history");
		if(set == null)
			set = new HashSet<Integer>();
		if(set.add(bno)) {
			//클릭한 게시글 조회수를 증가
			BoardService.getInstance().addBoardCount(bno);
		}
		request.getSession().setAttribute("bno_history", set);
		//게시글 읽어옴
		BoardDTO dto = BoardService.getInstance().selectBoard(bno);
		dto.setContent(dto.getContent().replaceAll("\n", "<br>"));
		request.setAttribute("board", dto);
		//게시글에 해당하는 댓글을 읽어옴
		List<BoardCommentDTO> list = BoardService.getInstance().selectCommentList(bno);
		request.setAttribute("list", list);
		//첨부파일을 읽어옴
		List<FileDTO> fList = BoardService.getInstance().selectFileList(bno);
		request.setAttribute("fList", fList);
		return new ModelAndView("board_view.jsp", false);
	}

}







