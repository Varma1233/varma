

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CourseDisplay")
public class CourseDisplay extends HttpServlet {
	ArrayList<String> subjects=new ArrayList<String>();
	ArrayList<String> subjectcodes=new ArrayList<String>();
	
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String regulation = request.getParameter("regulation");
        int adyear = Integer.parseInt(request.getParameter("admissionyear"));
        String semester = request.getParameter("semester");
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        try {
        	

        	// Load the MySQL JDBC driver
        	 String jdbcURL = "jdbc:mysql://localhost:3306/anil";
             String dbUser = "root";
             String dbPassword = "21bq1a1207";
             
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection conn = DriverManager.getConnection(jdbcURL,dbUser,dbPassword);
           
 // Prepare the SQL query

            if(semester.equalsIgnoreCase("All")) {
            	String sql="Select semester,subject,Subjectcode from courses where regulation=? and admissionyear=?";
            	PreparedStatement ps=conn.prepareStatement(sql);
            	ps.setString(1,regulation);
            	ps.setInt(2, adyear);
            	ResultSet rs=ps.executeQuery();
            	while(rs.next()) {
            		String s=rs.getString("subject");
            		String sc=rs.getString("Subjectcode");
            		int se=rs.getInt("semester");
            		subjects.add(s);
            		subjectcodes.add(sc);
            		
            		
            		
            	}
            }
            else {
                int a=Integer.parseInt(semester);
            	String sql1="Select subject,Subjectcode from courses where regulation=? and admissionyear=? and semester=?";
            	PreparedStatement ps1=conn.prepareStatement(sql1);
            	ps1.setString(1,regulation);
            	ps1.setInt(2, adyear);
            	ps1.setInt(3,a);
            	ResultSet rs1=ps1.executeQuery();
            	while(rs1.next()) {
            		String s=rs1.getString("subject");
            		String sc=rs1.getString("Subjectcode");
            		subjects.add(s);
            		subjectcodes.add(sc);
            		
            	}
            	
            }
           
            request.setAttribute("Subjects", subjects);
            request.setAttribute("Subjectcodes", subjectcodes);

            // Forward the request to the JSP page
            request.getRequestDispatcher("coursedisplay.jsp").forward(request, response);
            subjects.clear();
            subjectcodes.clear(); 
           conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

       
    }
   
}