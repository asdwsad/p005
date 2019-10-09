/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import dao.EntryDao;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Entry;
import model.MonthSoft;

/**
 *
 * @author dattv
 */
@WebServlet(name = "OverviewController", urlPatterns = {"/OverviewController"})
public class OverviewController extends HttpServlet {

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

        EntryDao dao = new EntryDao();
//        List<Entry> list = dao.getEntryByOderDate();

//        -----------------------------------------------------
        int size = 0;
        int total=9456;
        request.setAttribute("total", total);

        size = dao.getSizeEntry();
        request.setAttribute("size", size);

        String Spage = request.getParameter("page");

        int page = 1;

        if (Spage != null) {
            try {
                page = Integer.parseInt(Spage);
            } catch (Exception e) {
                    response.sendRedirect("jsp/error.jsp");
            }

        }

        int numPerPage = 3;
        int allOfPage;

        if (size % numPerPage == 0) {
            allOfPage = size / numPerPage;
        } else {
            allOfPage = size / numPerPage + 1;
        }

        request.setAttribute("maxpage", allOfPage);

        List<Entry> list = dao.getEntryByPage( page,numPerPage);

        request.setAttribute("list", list);

        request.setAttribute("page", page);

//-----------------------------------------------------------

        List<MonthSoft> monthlist = new ArrayList();
        SimpleDateFormat formatDate = new SimpleDateFormat("MMMM yyyy");

        if (!list.isEmpty()) {
            MonthSoft m = new MonthSoft(formatDate.format(list.get(0).getCreateDate()), list.get(0).getId());
            monthlist.add(m);
            int i = 0;
            for (Entry e : list) {
                String createdate = formatDate.format(e.getCreateDate());
                
                if (!monthlist.get(i).getCreatedate().equals(createdate)) {
                    monthlist.add(new MonthSoft(createdate, e.getId()));
                    i++;
                }
            }
        }
        request.setAttribute("monthlist", monthlist);
        request.getRequestDispatcher("jsp/overview.jsp").forward(request, response);
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
