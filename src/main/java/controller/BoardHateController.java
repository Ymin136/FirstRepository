package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardHateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String id = ((MemberDTO)request.getSession().getAttribute("dto")).getId();
		int result = BoardService.getInstance().insertBoardHate(bno,id);
		System.out.println(result);
		response.getWriter().write(String.valueOf(result));
		
		
		return null;
	}

}
