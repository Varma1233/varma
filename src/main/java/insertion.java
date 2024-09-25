

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertion")
public class insertion extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[][] matrix = new String[5][14]; // Fixed 5x14 matrix (12 POs, pso1, pso2)
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 14; j++) {
                String paramName = "matrix[co" + (i + 1) + "][";
                if (j < 12) {
                    paramName += "po" + (j + 1);
                } else if (j == 12) {
                    paramName += "pso1";
                } else if (j == 13) {
                    paramName += "pso2";
                }
                paramName += "]";
                
                String value = request.getParameter(paramName);
                matrix[i][j] = value;
            }
        }
        try {
        	String jdbcURL = "jdbc:mysql://localhost:3306/anil";
            String dbUser = "root";
            String dbPassword = "21bq1a1207";
            
            String subjectCode=request.getParameter("subjectCode");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL,dbUser,dbPassword);
            for (int i = 0; i < 5; i++) {
                String insertSQL = "INSERT INTO "+subjectCode +" (co, po1, po2, po3, po4, po5, po6, po7, po8, po9, po10, po11, po12,pso1,pso2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                 PreparedStatement preparedStatement = conn.prepareStatement(insertSQL);

                preparedStatement.setString(1, "co" + (i + 1)); // Set CO as "co1," "co2," etc.

                for (int j = 0; j < 14; j++) {
                    preparedStatement.setString(j + 2, matrix[i][j]); // Set PO values
                }
            
                preparedStatement.executeUpdate();
            }

        	
        }catch(Exception e) {
        	e.printStackTrace();
        }


	}

}
