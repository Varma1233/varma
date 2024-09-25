

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OutcomeDisplay")
public class OutcomeDisplay extends HttpServlet {
  ArrayList<String> outcomes=new ArrayList<String>();
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String subjectcode = request.getParameter("subjectcode");
        
       String s = null ;
        try {
        	

        	// Load the MySQL JDBC driver
        	 String jdbcURL = "jdbc:mysql://localhost:3306/anil";
             String dbUser = "root";
             String dbPassword = "21bq1a1207";
             
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection conn = DriverManager.getConnection(jdbcURL,dbUser,dbPassword);
           
             // Prepare the SQL query

         
            	String sql="Select Subject,Outcome1,Outcome2,Outcome3,Outcome4,Outcome5 from outcomes where subjectcode=?";
            	PreparedStatement ps=conn.prepareStatement(sql);
            	ps.setString(1,subjectcode);
            	
            	ResultSet rs=ps.executeQuery();
            	while(rs.next()) {
                     s= Objects.toString(s, "")+rs.getString("Subject");
            		String s1=rs.getString("Outcome1");
            		String s2=rs.getString("Outcome2");
            		String s3=rs.getString("Outcome3");
            		String s4=rs.getString("Outcome4");
            		String s5=rs.getString("Outcome5");
            		
            		outcomes.add(s1);outcomes.add(s2);outcomes.add(s3);outcomes.add(s4);outcomes.add(s5);
            		
            		
            	}
            	
             request.setAttribute("code", subjectcode);	
             request.setAttribute("name", s);
             request.setAttribute("Outcomes", outcomes);
            

            // Forward the request to the JSP page
            request.getRequestDispatcher("outcomesdisplay.jsp").forward(request, response);
            outcomes.clear();
            
           conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

       
    }
 

}
