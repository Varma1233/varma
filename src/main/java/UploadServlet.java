

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    int a,b,c;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try{
        
            String jdbcURL = "jdbc:mysql://localhost:3306/anil";
            String dbUser = "root";
            String dbPassword = "21bq1a1207";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL,dbUser,dbPassword);
             
            String mid=request.getParameter("mid");
            String e=request.getParameter("exam");
     
             Part filePart = request.getPart("file1");
             InputStream fileContent = filePart.getInputStream();
             Workbook workbook = Workbook.getWorkbook(fileContent);
           if(mid.equalsIgnoreCase("Mid1")) {
             if (e.equalsIgnoreCase("descriptive")) {
                   insertDescriptive(workbook, conn);
             }
             else if(e.equalsIgnoreCase("assignment")) {
            	 insertAssignment(workbook, conn); 
             }
             else if(e.equalsIgnoreCase("objective")) {
            	 insertObjective(workbook, conn); 
             }
           }else {
        	   if (e.equalsIgnoreCase("descriptive")) {
                   insertDescriptive2(workbook, conn);
             }
             else if(e.equalsIgnoreCase("assignment")) {
            	 insertAssignment2(workbook, conn); 
             }
             else if(e.equalsIgnoreCase("objective")) {
            	 insertObjective2(workbook, conn); 
             }
           }
           
        } catch (Exception e) {
            e.printStackTrace(); // Redirect to an error page
        }
        response.sendRedirect("index.html");
    }
    private void insertObjective(Workbook workbook, Connection conn) throws SQLException {
		for (Sheet sheet : workbook.getSheets()) {
            for (int row = 1; row < sheet.getRows(); row++) { // Assuming the first row contains headers
                 Cell[] cells = sheet.getRow(row);
             
             // Step 4: Insert data into MySQL
                 
                      Connection con=conn;
                      String sql = "INSERT INTO objective(REGDNO, StudentName, O1,Attainment) VALUES (?, ?, ?, ?)";
					  PreparedStatement statement1 = con.prepareStatement(sql);
             
             // Set parameters based on your Excel columns
                      statement1.setString(1, cells[0].getContents());
                      statement1.setString(2, cells[1].getContents());
                      a =Integer.parseInt(cells[2].getContents());
                      statement1.setInt(3,a);
                      statement1.setInt(4, calculateAttain(a));
             
                      statement1.executeUpdate();
             
                      statement1.close();
         }
     } 
         workbook.close();
		
	}
	private void insertAssignment(Workbook workbook, Connection conn) throws SQLException {
		for (Sheet sheet : workbook.getSheets()) {
            for (int row = 1; row < sheet.getRows(); row++) { // Assuming the first row contains headers
                 Cell[] cells = sheet.getRow(row);
             
             // Step 4: Insert data into MySQL
                 
                      Connection con=conn;
                      String sql = "INSERT INTO assignment(REGDNO, StudentName, A1,Attainment) VALUES (?, ?, ?, ?)";
					  PreparedStatement statement1 = con.prepareStatement(sql);
             
             // Set parameters based on your Excel columns
                      statement1.setString(1, cells[0].getContents());
                      statement1.setString(2, cells[1].getContents());
                      a =Integer.parseInt(cells[2].getContents());
                      statement1.setInt(3,a);
                      statement1.setInt(4, calculate(a));
             
                      statement1.executeUpdate();
             
                      statement1.close();
         }
     } 
         workbook.close();
		
	}
	private void insertDescriptive(Workbook workbook, Connection con) throws SQLException {
    	for (Sheet sheet : workbook.getSheets()) {
            for (int row = 1; row < sheet.getRows(); row++) { // Assuming the first row contains headers
                 Cell[] cells = sheet.getRow(row);
             
             // Step 4: Insert data into MySQL
                 

                      String sql = "INSERT INTO marks(REGDNO, StudentName, Q1, Q2, Q3, Q1Attain, Q2Attain, Q3Attain, Total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                     
					  PreparedStatement statement = con.prepareStatement(sql);
             
             // Set parameters based on your Excel columns
                      statement.setString(1, cells[0].getContents());
                      statement.setString(2, cells[1].getContents());
                      a =Integer.parseInt(cells[2].getContents());
                      b = Integer.parseInt(cells[3].getContents());
                      c= Integer.parseInt(cells[4].getContents());
                      statement.setInt(3,a);
                      statement.setInt(4,b);
                      statement.setInt(5,c);
                      statement.setInt(6, calculateAttain(a));
                      statement.setInt(7, calculateAttain(b));
                      statement.setInt(8, calculateAttain(c));
                      statement.setFloat(9,(a+b+c));
             
                      statement.executeUpdate();
             
                      statement.close();
         }
     } 
         workbook.close();
		
	}
	private void insertObjective2(Workbook workbook, Connection conn) throws SQLException {
		for (Sheet sheet : workbook.getSheets()) {
            for (int row = 1; row < sheet.getRows(); row++) { // Assuming the first row contains headers
                 Cell[] cells = sheet.getRow(row);
             
             // Step 4: Insert data into MySQL
                 
                      Connection con=conn;
                      String sql = "INSERT INTO objective2(REGDNO, StudentName, O1,Attainment) VALUES (?, ?, ?, ?)";
					  PreparedStatement statement1 = con.prepareStatement(sql);
             
             // Set parameters based on your Excel columns
                      statement1.setString(1, cells[0].getContents());
                      statement1.setString(2, cells[1].getContents());
                      a =Integer.parseInt(cells[2].getContents());
                      statement1.setInt(3,a);
                      statement1.setInt(4, calculateAttain(a));
             
                      statement1.executeUpdate();
             
                      statement1.close();
         }
     } 
         workbook.close();
		
	}
	private void insertAssignment2(Workbook workbook, Connection conn) throws SQLException {
		for (Sheet sheet : workbook.getSheets()) {
            for (int row = 1; row < sheet.getRows(); row++) { // Assuming the first row contains headers
                 Cell[] cells = sheet.getRow(row);
             
             // Step 4: Insert data into MySQL
                 
                      Connection con=conn;
                      String sql = "INSERT INTO assignment2(REGDNO, StudentName, A1,Attainment) VALUES (?, ?, ?, ?)";
					  PreparedStatement statement1 = con.prepareStatement(sql);
             
             // Set parameters based on your Excel columns
                      statement1.setString(1, cells[0].getContents());
                      statement1.setString(2, cells[1].getContents());
                      a =Integer.parseInt(cells[2].getContents());
                      statement1.setInt(3,a);
                      statement1.setInt(4, calculate(a));
             
                      statement1.executeUpdate();
             
                      statement1.close();
         }
     } 
         workbook.close();
		
	}
	private void insertDescriptive2(Workbook workbook, Connection con) throws SQLException {
    	for (Sheet sheet : workbook.getSheets()) {
            for (int row = 1; row < sheet.getRows(); row++) { // Assuming the first row contains headers
                 Cell[] cells = sheet.getRow(row);
             
             // Step 4: Insert data into MySQL
                 

                      String sql = "INSERT INTO marks2(REGDNO, StudentName, Q1, Q2, Q3, Q1Attain, Q2Attain, Q3Attain, Total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                     
					  PreparedStatement statement = con.prepareStatement(sql);
             
             // Set parameters based on your Excel columns
                      statement.setString(1, cells[0].getContents());
                      statement.setString(2, cells[1].getContents());
                      a =Integer.parseInt(cells[2].getContents());
                      b = Integer.parseInt(cells[3].getContents());
                      c= Integer.parseInt(cells[4].getContents());
                      statement.setInt(3,a);
                      statement.setInt(4,b);
                      statement.setInt(5,c);
                      statement.setInt(6, calculateAttain(a));
                      statement.setInt(7, calculateAttain(b));
                      statement.setInt(8, calculateAttain(c));
                      statement.setFloat(9,(a+b+c));
             
                      statement.executeUpdate();
             
                      statement.close();
         }
     } 
         workbook.close();
		
	}

	private int calculate( int a2) {
    	double percentage = (double) a2 / 5 * 100;
        int attainment;

        if (percentage >= 70) {
            attainment = 3;
        } else if (percentage >= 60) {
            attainment = 2;
        } else if (percentage >= 50) {
            attainment = 1;
        } else {
            attainment = 0;
        }
        
        return attainment;
    }
		


	private int calculateAttain(int a2) {
        double percentage = (double) a2 / 10 * 100;
        int attainment;

        if (percentage >= 70) {
            attainment = 3;
        } else if (percentage >= 60) {
            attainment = 2;
        } else if (percentage >= 50) {
            attainment = 1;
        } else {
            attainment = 0;
        }
        
        return attainment;
    }

    

}