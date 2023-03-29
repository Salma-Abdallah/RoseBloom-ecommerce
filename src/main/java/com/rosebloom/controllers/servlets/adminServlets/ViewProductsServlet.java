package com.rosebloom.controllers.servlets.adminServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.rosebloom.controllers.persistence.entities.Category;
import com.rosebloom.controllers.persistence.repository.CategoryRepository;
import com.rosebloom.controllers.persistence.repository.ProductRepository;
import com.rosebloom.controllers.services.ProductServices;
import com.rosebloom.dtos.ProductDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewProductsServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductServices productServices = new ProductServices();
        List<ProductDto> products = productServices.getAllProducts();
        request.setAttribute("products", products);

        
        request.getRequestDispatcher("adminView/html/viewProducts.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ProductServices productServices = new ProductServices();
        String id=request.getParameter("categoryName");
        System.out.println(id);
        PrintWriter out = response.getWriter();
        
       
        boolean isPlant=productServices.isPlant(id);
      
        out.println(isPlant);
        System.out.println(isPlant);
        //boolean isPlant=productServices.isPlant(id);


    }

}
