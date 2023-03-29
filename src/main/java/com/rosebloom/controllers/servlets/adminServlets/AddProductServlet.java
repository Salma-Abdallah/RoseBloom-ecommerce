package com.rosebloom.controllers.servlets.adminServlets;
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.rosebloom.controllers.services.ProductServices;
import com.rosebloom.dtos.ProductDto;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@MultipartConfig
public class AddProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                request.getRequestDispatcher("adminView/html/add-product.html").forward(request, response);
            }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                ServletContext servletContext = getServletContext();
                String contextPath = servletContext.getRealPath(File.separator) + "/view/images/";
                System.out.println(contextPath);
                response.setContentType("text/html;charset=UTF-8");
                ProductServices productServices = new ProductServices();
                productServices.getAddProductRequest(request, contextPath,true);
               
                List<ProductDto> products = productServices.getAllProducts();
                request.setAttribute("products", products);
        
                
                request.getRequestDispatcher("adminView/html/viewProducts.jsp").forward(request, response);
            }
    
}
