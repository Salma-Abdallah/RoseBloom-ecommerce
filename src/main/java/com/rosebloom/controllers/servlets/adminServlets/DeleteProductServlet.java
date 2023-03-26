package com.rosebloom.controllers.servlets.adminServlets;

import java.io.IOException;

import com.rosebloom.controllers.services.ProductServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class DeleteProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
                System.out.println(request.getParameter("ProductId"));
                ProductServices productServices=new ProductServices();
                String id=request.getParameter("ProductId");
                productServices.deleteProduct(Integer.parseInt(id));
            }
    
}
