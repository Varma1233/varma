

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Object> l1=new ArrayList<>();
		List<Object> l2=new ArrayList<>();
		int b=0;
		ArrayList<Integer> Q1=new ArrayList<Integer>();
		ArrayList<Integer> Q2=new ArrayList<Integer>();
		ArrayList<Integer> Q3=new ArrayList<Integer>();
		ArrayList<Integer> assignment=new ArrayList<Integer>();
		ArrayList<Integer> objective=new ArrayList<Integer>();
		try {
			String jdbcURL = "jdbc:mysql://localhost:3306/anil";
            String dbUser = "root";
            String dbPassword = "21bq1a1207";
            
            String subject=request.getParameter("subject");
            String subjectCode=request.getParameter("subject_code");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL,dbUser,dbPassword);
            
            PreparedStatement ps111= conn.prepareStatement("Select * from courses where subjectcode=?");
            ps111.setString(1, subjectCode);
            ResultSet rs111=ps111.executeQuery();
            while(rs111.next()) {
            	String s1=rs111.getString("Regulation");
            	int s2=rs111.getInt("Admissionyear");
            	int s3=rs111.getInt("Semester");
            	String s4=rs111.getString("Subject");
            	String  s5=rs111.getString("Subjectcode");
            	l1.add(s1);l1.add(s2);l1.add(s3);l1.add(s4);l1.add(s5);
            }
           
            PreparedStatement ps222= conn.prepareStatement("Select * from outcomes where subjectcode=?");
            ps222.setString(1, subjectCode);
            ResultSet rs222=ps222.executeQuery();
            while(rs222.next()) {
            	String s1=rs222.getString("Subject");
            	String s2=rs222.getString("SubjectCode");
            	String s3=rs222.getString("Outcome1");
            	String s4=rs222.getString("Outcome2");
            	String s5=rs222.getString("Outcome3");
            	String s6=rs222.getString("Outcome4");
            	String s7=rs222.getString("Outcome5");
            	l2.add(s1);l2.add(s2);l2.add(s3);l2.add(s4);l2.add(s5);l2.add(s6);l2.add(s7);
            }
            
            PreparedStatement ps333=conn.prepareStatement("Select count(REGDNO) as count from marks;");
            ResultSet rs333 = ps333.executeQuery();
            while(rs333.next()) {
             b=rs333.getInt("count");
            	
            }
            
            
            PreparedStatement ps1=conn.prepareStatement("Select count(REGDNO) as count from marks where Q1Attain=3;");
            ResultSet rs1 = ps1.executeQuery();
            while(rs1.next()) {
            	int a=rs1.getInt("count");
            	Q1.add(a);
            }
            PreparedStatement ps2=conn.prepareStatement("Select count(REGDNO) as count from marks where Q1Attain=2;");
            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next()) {
            	int a=rs2.getInt("count");
            	Q1.add(a);
            }
            PreparedStatement ps3=conn.prepareStatement("Select count(REGDNO) as count from marks where Q1Attain=1;");
            ResultSet rs3 = ps3.executeQuery();
            while(rs3.next()) {
            	int a=rs3.getInt("count");
            	Q1.add(a);
            }
            PreparedStatement ps4=conn.prepareStatement("Select count(REGDNO) as count from marks where Q1Attain=0;");
            ResultSet rs4 = ps4.executeQuery();
            while(rs4.next()) {
            	int a=rs4.getInt("count");
            	Q1.add(a);
            }

            PreparedStatement ps12=conn.prepareStatement("Select count(REGDNO) as count from marks where Q2Attain=3;");
            ResultSet rs12 = ps12.executeQuery();
            while(rs12.next()) {
            	int a=rs12.getInt("count");
            	Q2.add(a);
            }
            PreparedStatement ps22=conn.prepareStatement("Select count(REGDNO) as count from marks where Q2Attain=2;");
            ResultSet rs22 = ps22.executeQuery();
            while(rs22.next()) {
            	int a=rs22.getInt("count");
            	Q2.add(a);
            }
            PreparedStatement ps32=conn.prepareStatement("Select count(REGDNO) as count from marks where Q2Attain=1;");
            ResultSet rs32 = ps32.executeQuery();
            while(rs32.next()) {
            	int a=rs32.getInt("count");
            	Q2.add(a);
            }
            PreparedStatement ps42=conn.prepareStatement("Select count(REGDNO) as count from marks where Q2Attain=0;");
            ResultSet rs42 = ps42.executeQuery();
            while(rs42.next()) {
            	int a=rs42.getInt("count");
            	Q2.add(a);
            }

            PreparedStatement ps13=conn.prepareStatement("Select count(REGDNO) as count from marks where Q3Attain=3;");
            ResultSet rs13 = ps13.executeQuery();
            while(rs13.next()) {
            	int a=rs13.getInt("count");
            	Q3.add(a);
            }
            PreparedStatement ps23=conn.prepareStatement("Select count(REGDNO) as count from marks where Q3Attain=2;");
            ResultSet rs23 = ps23.executeQuery();
            while(rs23.next()) {
            	int a=rs23.getInt("count");
            	Q3.add(a);
            }
            PreparedStatement ps33=conn.prepareStatement("Select count(REGDNO) as count from marks where Q3Attain=1;");
            ResultSet rs33 = ps33.executeQuery();
            while(rs33.next()) {
            	int a=rs33.getInt("count");
            	Q3.add(a);
            }
            PreparedStatement ps43=conn.prepareStatement("Select count(REGDNO) as count from marks where Q3Attain=0;");
            ResultSet rs43 = ps43.executeQuery();
            while(rs43.next()) {
            	int a=rs43.getInt("count");
            	Q3.add(a);
            }
            PreparedStatement ps14=conn.prepareStatement("Select count(REGDNO) as count from assignment where Attainment=3;");
            ResultSet rs14 = ps14.executeQuery();
            while(rs14.next()) {
            	int a=rs14.getInt("count");
            	assignment.add(a);
            }
            PreparedStatement ps24=conn.prepareStatement("Select count(REGDNO) as count from assignment where Attainment=2;");
            ResultSet rs24 = ps24.executeQuery();
            while(rs24.next()) {
            	int a=rs24.getInt("count");
            	assignment.add(a);
            }
            PreparedStatement ps34=conn.prepareStatement("Select count(REGDNO) as count from assignment where Attainment=1;");
            ResultSet rs34 = ps34.executeQuery();
            while(rs34.next()) {
            	int a=rs34.getInt("count");
            	assignment.add(a);
            }
            PreparedStatement ps44=conn.prepareStatement("Select count(REGDNO) as count from assignment where Attainment=0;");
            ResultSet rs44 = ps44.executeQuery();
            while(rs44.next()) {
            	int a=rs44.getInt("count");
            	assignment.add(a);
            }
            PreparedStatement ps15=conn.prepareStatement("Select count(REGDNO) as count from objective where Attainment=3;");
            ResultSet rs15 = ps15.executeQuery();
            while(rs15.next()) {
            	int a=rs15.getInt("count");
            	objective.add(a);
            }
            PreparedStatement ps25=conn.prepareStatement("Select count(REGDNO) as count from objective where Attainment=2;");
            ResultSet rs25 = ps25.executeQuery();
            while(rs25.next()) {
            	int a=rs25.getInt("count");
            	objective.add(a);
            }
            PreparedStatement ps35=conn.prepareStatement("Select count(REGDNO) as count from objective where Attainment=1;");
            ResultSet rs35 = ps35.executeQuery();
            while(rs35.next()) {
            	int a=rs35.getInt("count");
            	objective.add(a);
            }
            PreparedStatement ps45=conn.prepareStatement("Select count(REGDNO) as count from objective where Attainment=0;");
            ResultSet rs45 = ps45.executeQuery();
            while(rs45.next()) {
            	int a=rs45.getInt("count");
            	objective.add(a);
            }
           request.setAttribute("Subject",subject);
           request.setAttribute("Subjectcode",subjectCode);
           request.setAttribute("Subjectdetails", l1);
           request.setAttribute("Outcomes", l2);
           request.setAttribute("Count",b);
           request.setAttribute("Q1", Q1);
           request.setAttribute("Q2", Q2);
           request.setAttribute("Q3", Q3);
           request.setAttribute("Assignment", assignment);
           request.setAttribute("Objective", objective);
           request.getRequestDispatcher("report.jsp").forward(request, response);
           l1.clear();l2.clear();Q1.clear();Q2.clear();Q3.clear();assignment.clear();objective.clear();
		}catch(Exception  e) {
			e.printStackTrace();
		}
	}
}
