/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Asus
 */
@WebServlet(urlPatterns = {"/GetKomen"})
public class GetKomen extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetKomen</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetKomen at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String id = request.getParameter("id");
                Statement statement = null;
                String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
                String DB_URL = "jdbc:mysql://localhost/tucildb_13511097";
                String USER = "root";
                String PASS = "";
                String output = "";
                Connection conn = null;
                ResultSet rs;
                
                
                
                try {
                conn = DriverManager.getConnection(DB_URL,USER, PASS);
                statement = conn.createStatement();
                String sql = "SELECT * FROM `tucildb_13511097`.`post-komen` WHERE `id_post`="+id+" ORDER BY `tanggal` DESC";
                rs = statement.executeQuery(sql);
                 
                    while(rs.next()){
                        String name = rs.getString("nama");
                        String tanggal = rs.getString("tanggal");
                        String isi = rs.getString("isi");
                        System.out.println("<li class='art-list-item'>");
                        System.out.println("<div class='art-list-item-title-and-time'>");
                        System.out.println("<h2 class='art-list-title'><a href='post.php?id="+id+"'>"+name+"</a></h2>");
                        System.out.println("<div class='art-list-time'>"+tanggal+" </div>");
                        System.out.println("</div>");
                        System.out.println("<p>"+isi+"</p>");
                        System.out.println("</li>");
                        output += "<li class='art-list-item'>"
                                + "<div class='art-list-item-title-and-time'>"
                                + "<h2 class='art-list-title'><a href='post.php?id="+id+"'>"+name+"</a></h2>"
                                + "<div class='art-list-time'>"+tanggal+" </div>"
                                + "</div>"
                                + "<p>"+isi+"</p>"
                                + "</li>";
                    }
		
		
                } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
