package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardCommentDTO;
import dto.MemberDTO;
import service.BoardService;
import view.ModelAndView;

public class CommentWriteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String writer = ((MemberDTO)request.getSession().getAttribute("dto")).getId();
		String comment = request.getParameter("comment");
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardService.getInstance().insertBoardComment(new BoardCommentDTO(bno, comment, writer));
		
		return new ModelAndView("boardView.do?bno="+bno, true);
	}

}
