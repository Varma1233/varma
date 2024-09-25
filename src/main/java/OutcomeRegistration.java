import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OutcomeRegistration")
public class OutcomeRegistration extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       

        String subject = request.getParameter("subject");
        String subjectcode =request.getParameter("subjectcode");
        String outcome1 = request.getParameter("Outcome1");
        String outcome2 = request.getParameter("Outcome2");
        String outcome3 = request.getParameter("Outcome3");
        String outcome4 = request.getParameter("Outcome4");
        String outcome5 = request.getParameter("Outcome5");
        

        try {
        	String jdbcURL = "jdbc:mysql://localhost:3306/anil";
            String dbUser = "root";
            String dbPassword = "21bq1a1207";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL,dbUser,dbPassword);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO outcomes (Subjectcode, subject, outcome1, outcome2, outcome3, outcome4, outcome5) VALUES (?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, subjectcode );
            pstmt.setString(2, subject);
            pstmt.setString(3, outcome1);
            pstmt.setString(4, outcome2);
            pstmt.setString(5, outcome3);
            pstmt.setString(6, outcome4);
            pstmt.setString(7, outcome5);

            pstmt.executeUpdate();
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("index.html");;
    }
}