/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DigitalDAO;
import entity.Digital;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CongHoangDevelop
 */
@WebServlet(name = "SearchControl", urlPatterns = {"/search"})
public class SearchControl extends RightControl {

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
        try {
            //get txtSearch from Right.jsp
            String txt = request.getParameter("txtSearch");
            String pageNumber = request.getParameter("pageN");
            int pageNum = 0;
            boolean check = false;
            try {
                pageNum = Integer.parseInt(pageNumber);
                check = true;
            } catch (Exception e) {
                request.setAttribute("check", check);
                request.setAttribute("Error", "Page invalid");
            }
            int count = dao.countSearch(txt);
            int size = 3;
            int page = count / size;
            if (count % size != 0) {
                page++;
            }
            //check pageNum to search.jsp
            if (check == true) {
                List<Digital> listSearch = dao.search(txt, pageNum, size);
                request.setAttribute("textSearch", txt);
                request.setAttribute("pageS", page);
                request.setAttribute("listS", listSearch);
                request.setAttribute("pageN", pageNum);
            }
            request.getRequestDispatcher("Search.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
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

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt = request.getParameter("txtSearch");
        response.sendRedirect("search?pageN=1&txtSearch="+txt);
    }

}
