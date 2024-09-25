

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sc = request.getParameter("subject_code");
        String co = request.getParameter("co");
        String po1 = request.getParameter("po1");
        String po2 = request.getParameter("po2");
        String po3 = request.getParameter("po3");
        String po4 = request.getParameter("po4");
        String po5 = request.getParameter("po5");
        String po6 = request.getParameter("po6");
        String po7 = request.getParameter("po7");
        String po8 = request.getParameter("po8");
        String po9 = request.getParameter("po9");
        String po10 = request.getParameter("po10");
        String po11 = request.getParameter("po11");
        String po12 = request.getParameter("po12");
        String pso1 = request.getParameter("pso1");
        String pso2 = request.getParameter("pso2");

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcURL = "jdbc:mysql://localhost:3306/anil";
            String dbUser = "root";
            String dbPassword = "21bq1a1207";
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            
            String updateSQL = "UPDATE " + sc + " SET po1 = ?, po2 = ?, po3 = ?, po4 = ?, po5 = ?, po6 = ?, po7 = ?, po8 = ?, po9 = ?, po10 = ?, po11 = ?, po12 = ?, pso1 = ?, pso2 = ? WHERE co = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, po1);
            preparedStatement.setString(2, po2);
            preparedStatement.setString(3, po3);
            preparedStatement.setString(4, po4);
            preparedStatement.setString(5, po5);
            preparedStatement.setString(6, po6);
            preparedStatement.setString(7, po7);
            preparedStatement.setString(8, po8);
            preparedStatement.setString(9, po9);
            preparedStatement.setString(10, po10);
            preparedStatement.setString(11, po11);
            preparedStatement.setString(12, po12);
            preparedStatement.setString(13, pso1);
            preparedStatement.setString(14, pso2);
            preparedStatement.setString(15, co);

            preparedStatement.executeUpdate();
            
                response.sendRedirect("copotable.html");
            
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
	}

}
