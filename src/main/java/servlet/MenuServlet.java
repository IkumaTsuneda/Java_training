package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UserDAO;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu-servlet")
public class MenuServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
   doPost(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    
    boolean isLogin = false;
    
    HttpSession session = request.getSession();
    String id = (String) session.getAttribute("id");
    String password = (String) session.getAttribute("password");
    String url = null;
    
    UserDAO dao = new UserDAO();
    
    try {
      isLogin = dao.loginCheck(id, password);
    } catch (ClassNotFoundException | SQLException e) {
      // TODO 自動生成された catch ブロック
      e.printStackTrace();
    }
    
    if(isLogin) {
      // 転送先の設定
      url = "menu.jsp";
    } else {
      // 転送先の設定
      url = "login.html";
    }

  // リクエストの転送
  RequestDispatcher rd = request.getRequestDispatcher(url);
  rd.forward(request, response);
  }

}
