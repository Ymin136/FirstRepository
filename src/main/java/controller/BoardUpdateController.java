package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardUpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println(content);
		BoardDTO dto = new BoardDTO();
		dto.setBno(bno);
		dto.setTitle(title);
		dto.setContent(content);
		
		BoardService.getInstance().updateBoard(dto);
		
		
		return new ModelAndView("boardView.do?bno="+bno, false);
	}

}



