/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hemm2025.misingresos.controlador;

import com.hemm2025.misingresos.DAO.tipoDAO;
import com.hemm2025.misingresos.modelos.Tipo;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "tipoServlet", urlPatterns = {"/tipoServlet"})
public class tipoServlet extends HttpServlet {

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
            out.println("<title>Servlet tipoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet tipoServlet at " + request.getContextPath() + "</h1>");
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
        String accion = request.getParameter("accion");
        tipoDAO dao = new tipoDAO();
        switch (accion) {
            case "listar":
                List<Tipo> lista = dao.listar();
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("vistas/tipo/lista.jsp").forward(request, response);
                break;
            case "agregar":
                Tipo t = new Tipo();
                request.setAttribute("tip", t);
                request.getRequestDispatcher("vistas/tipo/formulario.jsp").forward(request, response);
                break;
            case "eliminar":
                int id = Integer.parseInt(request.getParameter("id"));
                Tipo et = dao.get(id);
                if (et != null) {
                    if (dao.eliminar(et)) {
                        response.sendRedirect("tipoServlet?accion=listar");
                    } else {
                        response.sendRedirect("vistas/error.jsp");
                    }
                }

                break;
            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                Tipo etEditado = dao.get(idEditar);
                if (etEditado != null) {
                    request.setAttribute("tipo", etEditado);
                    request.getRequestDispatcher("vistas/tipo/formulario.jsp").forward(request, response);
                }
                break;
            default:
                throw new AssertionError();
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
        int id = request.getParameter("id").isEmpty() ? 0 : Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        int clase = Integer.parseInt(request.getParameter("clase"));
        Tipo obj = new Tipo(id, nombre, clase);
        tipoDAO dao = new tipoDAO();
        if (id == 0) {
            if (dao.agregar(obj)) {
                response.sendRedirect("tipoServlet?accion=listar");
            } else {
                response.sendRedirect("vistas/error.jsp");
            }
        }else{
            if(dao.editar(obj)){
                response.sendRedirect("tipoServlet?accion=listar");
            }else {
                response.sendRedirect("vistas/error.jsp");
            }
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
