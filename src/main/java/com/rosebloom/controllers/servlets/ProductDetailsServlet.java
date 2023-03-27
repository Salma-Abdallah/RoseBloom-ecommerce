package com.rosebloom.controllers.servlets;

import java.io.IOException;

import com.rosebloom.controllers.services.ProductServices;
import com.rosebloom.dtos.ProductDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

public class ProductDetailsServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("productId"));
        ProductServices productServices = new ProductServices();
        ProductDto product = productServices.getProductDetails(Integer.parseInt(request.getParameter("productId")));
        request.setAttribute("product", product);
        request.getRequestDispatcher("view/html/productDetails.jsp").forward(request, response);
    }

}
