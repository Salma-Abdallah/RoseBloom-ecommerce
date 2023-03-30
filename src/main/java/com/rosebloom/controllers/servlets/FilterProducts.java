package com.rosebloom.controllers.servlets;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.annotations.SourceType;
import org.json.JSONObject;

import com.rosebloom.controllers.services.ProductServices;
import com.rosebloom.dtos.ProductDto;

public class FilterProducts extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String x=request.getQueryString();
                String[]queryString=x.split("&");
                String categoryName=request.getParameter("categoryName");
                System.out.println(queryString[0]);
                int min=Integer.parseInt(request.getParameter("min"));
                int max=Integer.parseInt(request.getParameter("max"));
                ProductServices productServices=new ProductServices();
                List<ProductDto>products=productServices.getProductFilterd(categoryName, min, max);
                JSONObject productsJson = new JSONObject();
                productsJson.put("productsJson", products);
              //  productsJson.put("categoryName", categoryName);
                System.out.println(productsJson);
                PrintWriter out = response.getWriter();
               
                out.println(productsJson);
            }
    
}
