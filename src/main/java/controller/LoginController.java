package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberService;
import view.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		String passwd=request.getParameter("passwd");
		MemberDTO dto = MemberService.getInstance().login(id,passwd);
		ModelAndView view = null;
		if(dto != null) {
			view = new ModelAndView("main.do", true);
			//세션에 회원 정보 저장
			dto.setPasswd(null);
			request.getSession().setAttribute("dto", dto);
		}else {
			response.getWriter().
				write("<script>alert('아이디와 비밀번호를 확인하세요');history.back();</script>");
		}
		return view;
	}

}
