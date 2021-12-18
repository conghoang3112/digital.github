/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DigitalDAO;
import entity.Digital;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "DetailControl", urlPatterns = {"/detail"})
public class DetailControl extends RightControl {

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
            String did = request.getParameter("did");
            int id = 0;
            int check = 0;
            try {
                id = Integer.parseInt(did);
                check = 1;
            } catch (Exception e) {
                request.setAttribute("check", check);
                request.setAttribute("Error", "id invalid");
            }
            Digital d = dao.getById(id);
            if(d == null){
                d = dao.getTop1();
            }
            //check id valid to detail.jsp
            if (check == 1) {
                request.setAttribute("check", check);
                request.setAttribute("detail", d);
            }
            request.getRequestDispatcher("Detail.jsp").forward(request, response);
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
        processRequest(request, response);
    }

}
