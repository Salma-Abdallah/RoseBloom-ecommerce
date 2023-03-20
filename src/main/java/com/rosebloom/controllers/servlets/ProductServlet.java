package com.rosebloom.controllers.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import org.json.JSONObject;

import com.rosebloom.controllers.services.ProductServices;
import com.rosebloom.dtos.ProductDto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));

        // String categoryName = "";
        // if (br != null) {
            String  categoryName =request.getParameter("categoryName");
        
        
        ProductServices productServices=new ProductServices();
        List<ProductDto> products=productServices.getProducts(categoryName.substring(1, categoryName.length() - 1));
       
        JSONObject productsJson = new JSONObject();
        productsJson.put("productsJson", products);
      //  productsJson.put("categoryName", categoryName);
        System.out.println(productsJson);
        PrintWriter out = response.getWriter();




        out.println(productsJson);
    }
}
