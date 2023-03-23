package com.rosebloom.controllers.servlets.adminServlets;

import java.io.IOException;
import java.util.List;

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

}
