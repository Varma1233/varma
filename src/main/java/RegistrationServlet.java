import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            // Establish a database connection
            
            String facultyid=request.getParameter("facultyid");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String fullName = request.getParameter("fullName");
            String department = request.getParameter("department");
            String designation = request.getParameter("designation");
            String email =request.getParameter("email");
            
            String jdbcURL = "jdbc:mysql://localhost:3306/triveni";
            String dbUser = "root";
            String dbPassword = "21bq1a1247";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL,dbUser,dbPassword);
            String sql = "INSERT INTO users (Facultyid,username, password, Name, department, designation, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,facultyid);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, fullName);
            preparedStatement.setString(5, department);
            preparedStatement.setString(6, designation);
            preparedStatement.setString(7, email);
            
          
            response.sendRedirect("login.html");
            
        } catch (Exception e) {
            e.printStackTrace();
          
        }
      }
    }