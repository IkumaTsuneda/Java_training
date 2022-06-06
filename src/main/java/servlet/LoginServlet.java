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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public LoginServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    //response.getWriter().append("Served at: ").append(request.getContextPath());
    doPost(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub

    String id = request.getParameter("id");
    String password = request.getParameter("password");
    String url = null;
    boolean isLogin  = false;


    UserDAO dao = new UserDAO();


    
      try {
        isLogin = dao.loginCheck(id, password);
      } catch (ClassNotFoundException | SQLException e) {
        // TODO 自動生成された catch ブロック
        e.printStackTrace();
      }
      
      if(isLogin) {
        
        //セッションの取得
        HttpSession session = request.getSession();
        session.setAttribute("id", id);
        session.setAttribute("password", password);

        // 転送先の設定
        url = "menu-servlet";
      } else {
        // 転送先の設定
        url = "login-failure.html";
      }

    // リクエストの転送
    RequestDispatcher rd = request.getRequestDispatcher(url);
    rd.forward(request, response);
  }
}


