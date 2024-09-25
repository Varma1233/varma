
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CourseRegistration")
public class CourseRegistration extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String regulation = request.getParameter("regulation");
        int adyear = Integer.parseInt(request.getParameter("admissionyear"));
        int semester = Integer.parseInt(request.getParameter("semester"));
        String subject = request.getParameter("subject");
        String subjectCode =request.getParameter("subject_code");

        try {
        	String jdbcURL = "jdbc:mysql://localhost:3306/anil";
            String dbUser = "root";
            String dbPassword = "21bq1a1207";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL,dbUser,dbPassword);

            String query = "INSERT INTO courses (regulation, admissionyear, semester, subject, subjectCode) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, regulation);
            pstmt.setInt(2, adyear);
            pstmt.setInt(3, semester);
            pstmt.setString(4, subject);
            pstmt.setString(5,subjectCode);

            pstmt.executeUpdate();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("index.html");
    }
}
