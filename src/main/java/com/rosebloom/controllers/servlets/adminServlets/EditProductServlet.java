package com.rosebloom.controllers.servlets.adminServlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.sql.Timestamp;

import com.rosebloom.controllers.services.CategoryServices;
import com.rosebloom.controllers.services.ProductServices;
import com.rosebloom.dtos.PlantdescriptionDto;
import com.rosebloom.dtos.ProductDto;
import com.rosebloom.dtos.ProductImageDto;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
public class EditProductServlet extends HttpServlet {
    final String path = "C:/Users/PC/Documents/GitHub/RoseBloom-ecommerce/src/main/webapp/view/images/";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println(request.getParameter("productId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        CategoryServices categoryServices = new CategoryServices();
        String categoryName = categoryServices.getCategoryName(productId);
        ProductServices productsServices = new ProductServices();
        ProductDto productDto = productsServices.getProductDetails(productId);
        Collections.sort(productDto.getProductImages());
        request.setAttribute("category", categoryName);
        request.setAttribute("product", productDto);

        request.getRequestDispatcher("adminView/html/edit-product.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        String contextPath = servletContext.getRealPath(File.separator) + "/view/images/";
        System.out.println(contextPath);
        response.setContentType("text/html;charset=UTF-8");
        ProductServices productServices = new ProductServices();
        productServices.getAddProductRequest(request, contextPath, false);
        List<ProductDto> products = productServices.getAllProducts();
        request.setAttribute("products", products);

        request.getRequestDispatcher("adminView/html/viewProducts.jsp").forward(request, response);

    }

}
