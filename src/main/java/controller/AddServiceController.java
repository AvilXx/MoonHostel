/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.RoomDAO;
import dao.ServiceDAO;
import dto.HostelDTO;
import dto.ServiceDetailDTO;
import dto.ServiceTypeDTO;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author avillX
 */
@WebServlet(name = "AddServiceController", urlPatterns = {"/AddServiceController"})
public class AddServiceController extends HttpServlet {

    private static final String ERROR = "View/addNewService.jsp";
    private static final String SUCCESS = "MainController?action=ServicePage";   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
        String url = ERROR;
        try {
            HttpSession ss = request.getSession();
            UserDTO us =  (UserDTO) ss.getAttribute("LOGIN_USER");

            RoomDAO dao = new RoomDAO();
            ServiceDAO SerDAO = new ServiceDAO();

            List<HostelDTO> HostelList = dao.GetListHostel(us.getUserID());
            List<ServiceTypeDTO> ServiceList = SerDAO.GetListService();

            request.setAttribute("HostelList",HostelList);
            request.setAttribute("ServiceTypeList",ServiceList);
        } catch (Exception e) {
            log("Error at AddServiceController(doGet): " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
        String url = ERROR;
        try {
            ServiceDAO dao = new ServiceDAO();
            HttpSession ss = request.getSession();
            UserDTO us =  (UserDTO) ss.getAttribute("LOGIN_USER");
 
            String detail_name = request.getParameter("detail_name");
            String calUnit = "";
            Double unit_price = Double.parseDouble(request.getParameter("unit_price"));
            String updated_date = request.getParameter("updated_date");
            String description = request.getParameter("description");
            String hostel_id = request.getParameter("hostel_id");
            String service_id = request.getParameter("service_id"); 
            if (service_id.equals("1")) calUnit = "kWh"; else if (service_id.equals("2")) calUnit = "m3";
            
            boolean check = dao.AddServiceDetail(new ServiceDetailDTO("1",detail_name,calUnit,unit_price,Date.valueOf(updated_date),description,"ACTIVE",hostel_id,service_id));
            if (check) {
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at AddServiceController(doPost): " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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

}