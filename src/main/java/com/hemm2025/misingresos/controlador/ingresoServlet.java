/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hemm2025.misingresos.controlador;

import com.hemm2025.misingresos.DAO.ingresoDAO;

import com.hemm2025.misingresos.modelos.Ingresos;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Date;

import java.util.List;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "ingresoServlet", urlPatterns = {"/ingresoServlet"})
public class ingresoServlet extends HttpServlet {

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
            out.println("<title>Servlet ingresoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ingresoServlet at " + request.getContextPath() + "</h1>");
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
        ingresoDAO dao = new ingresoDAO();
        switch (accion) {
            case "listar":
                List<Ingresos> lista = dao.listar();
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("vistas/ingresos/listaingresos.jsp").forward(request, response);
                break;
            case "agregar":
                Ingresos t = new Ingresos();
                request.setAttribute("ingreso", t);
                request.getRequestDispatcher("vistas/ingresos/formularioingresos.jsp").forward(request, response);
                break;
            case "eliminar":
                int id = Integer.parseInt(request.getParameter("id"));
                Ingresos et = dao.get(id);
                if (et != null) {
                    if (dao.eliminar(et)) {
                        response.sendRedirect("ingresoServlet?accion=listar");
                    } else {
                        response.sendRedirect("vistas/error.jsp");
                    }
                }

                break;
            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                Ingresos etEditado = dao.get(idEditar);
                if (etEditado != null) {
                    request.setAttribute("tipo", etEditado);
                    request.getRequestDispatcher("vistas/ingresos/formularioingresos.jsp").forward(request, response);
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
        String detalle = request.getParameter("detalle");
        Date fecha = Date.valueOf(request.getParameter("fecha"));
        BigDecimal monto = BigDecimal.valueOf((long) Double.parseDouble(request.getParameter("monto")));
        int idtipo = Integer.parseInt(request.getParameter("idtipo"));
        String nombre = request.getParameter("nombre");
        int clase = Integer.parseInt(request.getParameter("clase"));
        Ingresos obj = new Ingresos(id,detalle,fecha,monto,idtipo);
        ingresoDAO dao = new ingresoDAO();
        if (id == 0) {
            if (dao.agregar(obj)) {
                response.sendRedirect("ingresoServlet?accion=listar");
            } else {
                response.sendRedirect("vistas/error.jsp");
            }
        } else {
            if (dao.editar(obj)) {
                response.sendRedirect("ingresoServlet?accion=listar");
            } else {
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
