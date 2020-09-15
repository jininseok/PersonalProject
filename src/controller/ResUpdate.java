package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ResDAO;
import model.ResVO;

@WebServlet("/ResUpdate.do")
public class ResUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원 수정");
			
		request.getRequestDispatcher("/res/login.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Integer no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
	
		ResVO res = new ResVO();
		res.setNo(no);
		res.setTitle(title);
		res.setContent(content);
		res.setName(name);
		res.setTel(tel);
		res.setAddress(address);
		

		ResDAO dao = new ResDAO();
		dao.update(res);
		
		request.setAttribute("res", res);
		
		response.sendRedirect("ResUpdate.do");
	}

}
