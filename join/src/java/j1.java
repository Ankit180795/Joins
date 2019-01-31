/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class j1 extends HttpServlet {

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         
         
         
         String s = request.getParameter("btn");
         
         
         
         PreparedStatement ps;
         ResultSet rs;
         RequestDispatcher rd;
         
        switch (s) {
            case "Submit":
                  response.setContentType("text/html");
       try {
                  String query2 ="SELECT * FROM DB1 FULL OUTER JOIN DB2 ON DB1.EMAIL=DB2.EMAIL";
                  String query3 ="SELECT * FROM DB1 INNER JOIN DB2 ON DB1.EMAIL=DB2.EMAIL";
                  String query4 ="SELECT * FROM DB1 LEFT JOIN DB2 ON DB1.EMAIL=DB2.EMAIL";
                  String query5 ="SELECT * FROM DB1 RIGHT JOIN DB2 ON DB1.EMAIL=DB2.EMAIL";
        
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","3101");
            
             ps = con.prepareStatement(query2);
             out.println("full");
             out.println("<br>");
             rs = ps.executeQuery();
            
            while(rs.next()){
               
                out.println("<table border='1'>");
                out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td></tr>");
                out.println("</table>");
                }
             ps = con.prepareStatement(query3);
             out.println("<br>");
             out.println("inner");
             out.println("<br>");
             rs = ps.executeQuery();
             while(rs.next()){
               
                out.println("<table border='1'>");
                out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td></tr>");
                out.println("</table>");
                }
              ps = con.prepareStatement(query4);
              out.println("<br>");
              out.println("left");
              out.println("<br>");
             rs = ps.executeQuery();
             while(rs.next()){
               
                out.println("<table border='1'>");
                out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td></tr>");
                out.println("</table>");
                }
              ps = con.prepareStatement(query5);
              out.println("<br>");
              out.println("right");
              out.println("<br>");
             rs = ps.executeQuery();
             while(rs.next()){
               
                out.println("<table border='1'>");
                out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td></tr>");
                out.println("</table>");
                }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(j1.class.getName()).log(Level.SEVERE, null, ex);
        }
           
                break;
            case "db1":
                String eid = request.getParameter("email-id");
                String n = request.getParameter("name");
                String mnum = request.getParameter("mobile-num1");
                String query = "INSERT INTO DB1 VALUES(?,?,?)";
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","3101");
                    ps = con.prepareStatement(query);
                    ps.setString(1, eid);
                    ps.setString(2, n);
                    ps.setString(3,mnum);
                    //rs = ps.executeQuery();
                    if (ps.executeUpdate()>0){
                        out.println("Success");
                    }
                    else{
                        out.println("Failed");
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(j1.class.getName()).log(Level.SEVERE, null, ex);
                }  break;
            case "db2":
                 String eid1 = request.getParameter("email-id1");
                 String dob = request.getParameter("bday");
                 String gen = request.getParameter("gen");
                 String add = request.getParameter("address");
                 String query1 = "INSERT INTO DB2 VALUES(?,?,?,?)";
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","3101");
                    ps = con.prepareStatement(query1);
                    ps.setString(1, eid1);
                    ps.setString(2, dob);
                    ps.setString(3, gen);
                    ps.setString(4, add);
                    //rs = ps.executeQuery();
                    if (ps.executeUpdate()>0){
                         out.println("Success");
                    }
                     else{
                        out.println("Failed");
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(j1.class.getName()).log(Level.SEVERE, null, ex);
                }  break;
            default:
                break;
        }
    }
    }
    
