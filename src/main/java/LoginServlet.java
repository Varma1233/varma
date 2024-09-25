

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String email =request.getParameter("email");
			String password = request.getParameter("password");

			String jdbcURL = "jdbc:mysql://localhost:3306/triveni";
            String dbUser = "root";
            String dbPassword = "21bq1a1247";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL,dbUser,dbPassword);
          
            PreparedStatement st = conn.prepareStatement("select email,password from users where email=? and password=?");
			st.setString(1, email);
			st.setString(2, password);
			ResultSet rs=st.executeQuery();
			st.close();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("index.html");
			}

}