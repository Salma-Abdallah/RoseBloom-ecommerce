package com.rosebloom.controllers.servlets.adminServlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import org.json.JSONObject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import com.rosebloom.controllers.services.CategoryServices;
import com.rosebloom.controllers.services.ProductServices;
import com.rosebloom.dtos.PlantdescriptionDto;
import com.rosebloom.dtos.ProductDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
public class EditProductServlet extends HttpServlet {
    final String path = "view/images/";

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
        // JSONObject productsJson = new JSONObject();
        // productsJson.put("productsJson", productDto);
        // productsJson.put("categoryName", categoryName);
        // System.out.println(productsJson);
        request.getRequestDispatcher("adminView/html/edit-product.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        final Part filePart1 = request.getPart("fileInput1");
        final String fileName = getFileName(filePart1);
        if(fileName.equals(""))
            System.out.println("**");
        System.out.println(path + fileName);
        String categoryName=(request.getParameter("categoryOption"));
        ProductDto productDto = new ProductDto();
        productDto.setId(Integer.parseInt(request.getParameter("productId")));
        productDto.setName(request.getParameter("name"));
        productDto.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        productDto.setDescription(request.getParameter("description"));
        productDto.setPrice(Integer.parseInt(request.getParameter("price")));
        productDto.setOldPrice(Integer.parseInt(request.getParameter("oldPrice")));
        productDto.setColor(request.getParameter("color"));
        productDto.setSize(Integer.parseInt(request.getParameter("size")));
        productDto.setPlantdescription(new PlantdescriptionDto());
        productDto.setProductImages(new ArrayList<>());
        productDto.setQuantity(Integer.parseInt(request.getParameter("stock")));
        ProductServices productServices=new ProductServices();
        productServices.updateProduct(categoryName, productDto);
        
    }

    private String getFileName(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
