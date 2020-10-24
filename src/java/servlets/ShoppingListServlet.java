/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alex Tompkins - 821984
 */
public class ShoppingListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action != null && action.equals("logout")) {
            request.getSession().invalidate();
        }
        
        if (request.getSession().getAttribute("username") == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        ArrayList<String> items;
        
        if (action.equals("register") && !request.getParameter("username").equals("")) {
            session.setAttribute("username", request.getParameter("username"));
            session.setAttribute("items", new ArrayList());
            response.sendRedirect("ShoppingList");
            
        } else if (action.equals("add")) {
            items = (ArrayList<String>)session.getAttribute("items");
            items.add(request.getParameter("item"));
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            
        } else if (action.equals("delete")) {
            items = (ArrayList<String>)session.getAttribute("items");
            items.remove(request.getParameter("listItem"));
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
        }
    }
}
