/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.*;
import Model.Post;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OverviewController_1 extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            ArrayList<Post> arrPosts = new ArrayList<>();
            MyBlogDAO myBlogDAO = new MyBlogDAO();
            arrPosts = myBlogDAO.getAllPosts();
            int size = arrPosts.size();
            int page = Integer.parseInt(request.getParameter("pageNum"));
            request.setAttribute("pageNum", page);
            ArrayList<Post> listPage = myBlogDAO.getByPage(page);
            ArrayList<Mouth> mouthList = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM  yyyy");
            if (!listPage.isEmpty()) {
                Mouth m = new Mouth(listPage.get(0).getPostID(), 
                        sdf.format(listPage.get(0).getDate()));
                mouthList.add(m);
                int i = 0;
                for (Post post : listPage) {
                    String dateMouth = sdf.format(post.getDate());
                    if (!mouthList.get(i).getDate().equals(dateMouth)){
                        mouthList.add(new Mouth(post.getPostID(), dateMouth));
                        i++;
                    }
                }
            }
            
            
            request.setAttribute("size", size);
            request.setAttribute("mouthList", mouthList);
            request.setAttribute("listPage", listPage);
            request.getRequestDispatcher("Overview.jsp").forward(request, response);
        } catch (Exception ex) {
             response.sendRedirect("Error.jsp?error=" + ex);
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
        processRequest(request, response);
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
