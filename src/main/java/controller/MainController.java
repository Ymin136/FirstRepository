package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardService;
import view.ModelAndView;
import vo.PaggingVO;

public class MainController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNo = 1;
		
		if(request.getParameter("pageNo") != null)
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		
		List<BoardDTO> list = BoardService.getInstance().selectBoardList(pageNo);
		request.setAttribute("board_list", list);
		
		int count = BoardService.getInstance().selectAllCount();
		PaggingVO vo = new PaggingVO(count, pageNo, 15, 5);
		request.setAttribute("pagging", vo);
		
		ModelAndView view = new ModelAndView("main.jsp", false);
		
		return view;
	}

}








