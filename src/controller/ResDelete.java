package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ResDAO;
import model.ResVO;

@WebServlet("/ResDelete.do")
public class ResDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("게시글삭제");
		
		Integer no = Integer.parseInt(request.getParameter("no"));
		
		ResVO res = new ResVO();
		
		res.setNo(no);
		
		ResDAO.getInstance().delete(res);
		
		request.setAttribute("res", res);
		
		request.getRequestDispatcher("/res/ResDelete.jsp").forward(request, response);

	}

}
