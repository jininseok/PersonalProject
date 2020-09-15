package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ResDAO;
import model.ResVO;

/**
 * Servlet implementation class ResSearch
 */
@WebServlet("/ResSearch.do")
public class ResSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("검색");
		request.setCharacterEncoding("UTF-8");
		
	//파라미터 변수에 저장
	ResVO rest = new ResVO();
	Integer no = Integer.parseInt(request.getParameter("no"));
	rest.setNo(no);
	

	//서비스 
	ResDAO dao = new ResDAO();
	ResVO res = dao.selectOne(rest);

	//결과 처리
	
	//뷰페이지 이동
	request.setAttribute("res", res);
	
	request.getRequestDispatcher("/res/ResDelete.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
