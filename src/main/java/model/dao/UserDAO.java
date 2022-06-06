/*
 * WebApp_05_sp03_UseBean
 * model.dao.EmployeeDAO.java
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.UserBean;


/**
 * m_employeeテーブルのDAOです。
 * @author emBex Education
 */
public class UserDAO {
  /**
   * すべての従業員のリストを返します。
   * @return 従業員のリスト
   * @throws SQLException
   * @throws ClassNotFoundException
   */

  /*
   * ログイン承認をするメソッド
   * @return 承認結果
   */
  public boolean loginCheck(String id, String password)
      throws SQLException, ClassNotFoundException {

    boolean isLogin = false;

    // データベースへの接続の取得、Statementの取得、SQLステートメントの実行
    try (Connection con = ConnectionManager.getConnection();
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM m_user WHERE user_id = ? AND password = ?")){

      //プレースホルダへの値の設定
      pstmt.setString(1, id);
      pstmt.setString(2, password);



      ResultSet res = pstmt.executeQuery();

      if(res.next()) {
        //       String id2 = res.getString("user_id");
        //       String password2 = res.getString("password");
        //   
        isLogin = true;

      }

    }
    return isLogin;
  }










  public List<UserBean> selectAll()
      throws SQLException, ClassNotFoundException {

    List<UserBean> ubList = new ArrayList<UserBean>();

    // データベースへの接続の取得、Statementの取得、SQLステートメントの実行
    try (Connection con = ConnectionManager.getConnection();
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM m_user")) {

      // 結果の操作
      while (res.next()) {
        String id = res.getString("user_id");
        String name = res.getString("name");
        int age = res.getInt("age");

        UserBean ub = new UserBean();
        ub.setId(id);
        ub.setName(name);
        ub.setAge(age);

        ubList.add(ub);
        
        
      }
    }
    return ubList;
  }
}
