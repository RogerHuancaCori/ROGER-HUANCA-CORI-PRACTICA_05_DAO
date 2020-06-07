/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controlador;

import com.emergentes.dao.AlmacenDAO;
import com.emergentes.dao.AlmacenDAOimpl;
import com.emergentes.modelo.Almacen;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Huanca Cori Roger
 */
@WebServlet(name = "Servlet_Controlador", urlPatterns = {"/Servlet_Controlador"})
public class Servlet_Controlador extends HttpServlet {

    
   
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            AlmacenDAO dao = new AlmacenDAOimpl();
            int id;
            Almacen almc = new Almacen();
            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            
            switch(action){
                case "add":
                    request.setAttribute("almacen", almc);
                    request.getRequestDispatcher("frmalmacen.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    almc = dao.getById(id);
                    request.setAttribute("almacen", almc);
                    request.getRequestDispatcher("frmalmacen.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath()+"/Servlet_Controlador");
                    break;
                case "view":
                    List<Almacen> lista = dao.getAll();
                    request.setAttribute("almacen", lista);
                    request.getRequestDispatcher("productos.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("error"+ex.getMessage());
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
        int stock = Integer.parseInt(request.getParameter("stock"));
        
        
        Almacen almc = new Almacen();
        
        almc.setId(id);
        almc.setDescripcion(descripcion);
        almc.setStock(stock);
        
        if (id == 0){
            try {
                AlmacenDAO dao = new AlmacenDAOimpl();
                dao.insert(almc);
                response.sendRedirect(request.getContextPath()+"/Servlet_Controlador");
            } catch (Exception ex) {
                System.out.println("error"+ex.getMessage());
            }
        }
        else {
            try {
                AlmacenDAO dao = new AlmacenDAOimpl();
                dao.update(almc);
                response.sendRedirect(request.getContextPath()+"/Servlet_Controlador");
            } catch (Exception ex) {
                System.out.println("error"+ex.getMessage());
            }            
        }
        
    }

  
}
