

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/marksanalysis")
public class marksanalysis extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int[] attainment= {3,2,1,0};
		ArrayList<Integer> Q1=new ArrayList<Integer>();
		ArrayList<Integer> Q2=new ArrayList<Integer>();
		ArrayList<Integer> Q3=new ArrayList<Integer>();
		ArrayList<Integer> assignment=new ArrayList<Integer>();
		ArrayList<Integer> objective=new ArrayList<Integer>();
	  try {	
		String jdbcURL = "jdbc:mysql://localhost:3306/anil";
        String dbUser = "root";
        String dbPassword = "21bq1a1207";
        
        String subjectCode=request.getParameter("subject_code");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(jdbcURL,dbUser,dbPassword);
        
        PreparedStatement ps= conn.prepareStatement("Select count(REGDNO) as count from marks where Q1Attain=3");
        ResultSet rs=ps.executeQuery();
        while(rs.next()) {
        	int a=rs.getInt("count");
        	Q1.add(a);
        }
        PreparedStatement ps1= conn.prepareStatement("Select count(REGDNO) as count from marks where Q1Attain=2");
        ResultSet rs1=ps1.executeQuery();
        while(rs1.next()) {
        	int b=rs.getInt("count");
        	Q1.add(b);
        }
        PreparedStatement ps2= conn.prepareStatement("Select count(REGDNO) as count from marks where Q1Attain=1");
        ResultSet rs2=ps2.executeQuery();
        while(rs2.next()) {
        	int c=rs.getInt("count");
        	Q1.add(c);
        }
        PreparedStatement ps3= conn.prepareStatement("Select count(REGDNO) as count from marks where Q1Attain=0");
        ResultSet rs3=ps3.executeQuery();
        while(rs3.next()) {
        	int a=rs3.getInt("count");
        	Q1.add(a);
        }
        PreparedStatement ps4= conn.prepareStatement("Select count(REGDNO) as count from marks where Q2Attain=3");
        ResultSet rs4=ps4.executeQuery();
        while(rs4.next()) {
        	int a=rs4.getInt("count");
        	Q2.add(a);
        }
        PreparedStatement ps5= conn.prepareStatement("Select count(REGDNO) as count from marks where Q2Attain=2");
        ResultSet rs5=ps5.executeQuery();
        while(rs5.next()) {
        	int a=rs5.getInt("count");
        	Q2.add(a);
        }
        PreparedStatement ps6= conn.prepareStatement("Select count(REGDNO) as count from marks where Q2Attain=1");
        ResultSet rs6=ps6.executeQuery();
        while(rs6.next()) {
        	int a=rs6.getInt("count");
        	Q2.add(a);
        }
        PreparedStatement ps7= conn.prepareStatement("Select count(REGDNO) as count from marks where Q2Attain=0");
        ResultSet rs7=ps7.executeQuery();
        while(rs7.next()) {
        	int a=rs7.getInt("count");
        	Q2.add(a);
        }
        PreparedStatement ps8= conn.prepareStatement("Select count(REGDNO) as count from marks where Q3Attain=3");
        ResultSet rs8=ps8.executeQuery();
        while(rs8.next()) {
        	int a=rs8.getInt("count");
        	Q3.add(a);
        }
        PreparedStatement ps9= conn.prepareStatement("Select count(REGDNO) as count from marks where Q3Attain=2");
        ResultSet rs9=ps9.executeQuery();
        while(rs9.next()) {
        	int a=rs9.getInt("count");
        	Q3.add(a);
        }
        PreparedStatement p10= conn.prepareStatement("Select count(REGDNO) as count from marks where Q3Attain=1");
        ResultSet rs10=p10.executeQuery();
        while(rs10.next()) {
        	int a=rs10.getInt("count");
        	Q3.add(a);
        }
        PreparedStatement ps11= conn.prepareStatement("Select count(REGDNO) as count from marks where Q3Attain=0");
        ResultSet rs11=ps11.executeQuery();
        while(rs11.next()) {
        	int a=rs11.getInt("count");
        	Q3.add(a);
        }
        PreparedStatement ps12= conn.prepareStatement("Select count(REGDNO) as count from assignment where Attainment=3");
        ResultSet rs12=ps12.executeQuery();
        while(rs12.next()) {
        	int a=rs12.getInt("count");
        	assignment.add(a);
        }
        PreparedStatement ps13= conn.prepareStatement("Select count(REGDNO) as count from assignment where Attainment=2");
        ResultSet rs13=ps13.executeQuery();
        while(rs13.next()) {
        	int a=rs13.getInt("count");
        	assignment.add(a);
        }
        PreparedStatement ps14= conn.prepareStatement("Select count(REGDNO) as count from assignment where Attainment=1");
        ResultSet rs14=ps14.executeQuery();
        while(rs14.next()) {
        	int a=rs14.getInt("count");
        	assignment.add(a);
        }
        PreparedStatement ps15= conn.prepareStatement("Select count(REGDNO) as count from assignment where Attainment=0");
        ResultSet rs15=ps15.executeQuery();
        while(rs15.next()) {
        	int a=rs15.getInt("count");
        	assignment.add(a);
        }
        PreparedStatement ps16= conn.prepareStatement("Select count(REGDNO) as count from objective where Attainment=3");
        ResultSet rs16=ps16.executeQuery();
        while(rs16.next()) {
        	int a=rs16.getInt("count");
        	objective.add(a);
        }
        PreparedStatement ps17= conn.prepareStatement("Select count(REGDNO) as count from objective where Attainment=2");
        ResultSet rs17=ps17.executeQuery();
        while(rs17.next()) {
        	int a=rs17.getInt("count");
        	objective.add(a);
        }
        PreparedStatement ps18= conn.prepareStatement("Select count(REGDNO) as count from objective where Attainment=1");
        ResultSet rs18=ps18.executeQuery();
        while(rs18.next()) {
        	int a=rs18.getInt("count");
        	objective.add(a);
        }
        PreparedStatement ps19= conn.prepareStatement("Select count(REGDNO) as count from objective where Attainment=0");
        ResultSet rs19=ps19.executeQuery();
        while(rs19.next()) {
        	int a=rs19.getInt("count");
        	objective.add(a);
        }
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	}

}
