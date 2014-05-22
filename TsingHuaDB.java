package example;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;



/**
 * Hello world!
 *
 */
public class TsingHuaDB extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
    {
        //resp.getWriter().println("TsingHuaDB test!");
     		// database success ful
				try{     	
     			Context ctx = new InitialContext();
					DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mydb");
					Connection conn = ds.getConnection();
					Statement stmt = conn.createStatement();
					ResultSet rst = stmt.executeQuery("select CDID, PICADDR, TITLE from cd");
					while(rst.next()) {
 						int id= rst.getInt(1);
 						String picaddr= rst.getString(2);
 						String title= rst.getString(3);
 					
 						resp.getWriter().println("<h1>" + id + "</h1>");
 						resp.getWriter().println("<h1>" + picaddr + "</h1>");
 						resp.getWriter().println("<h1>" + title + "</h1>");
					}
					conn.close();
     		} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
     	   
    }
}
