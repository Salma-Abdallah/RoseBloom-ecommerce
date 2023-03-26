package com.rosebloom.controllers.servlets.adminServlets;

import java.io.BufferedReader;
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
        response.setContentType("text/html;charset=UTF-8");
        List<ProductImageDto> productImageDto = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            String inFileName = "fileInput" + (i);
            System.out.println(inFileName);
            final Part filePart = request.getPart(inFileName);
            final String fileName = getFileName(filePart);
            if (fileName.equals("")) {
                String img = "img" + i;
                if (!request.getParameter(img).equals("")) {
                    ProductImageDto productImageDto2 = new ProductImageDto(request.getParameter(img));
                    productImageDto.add(productImageDto2);
                }
            } else {
                filePart.write(path + fileName);
                ProductImageDto productImageDto2 = new ProductImageDto("view/images/" + fileName);
                productImageDto.add(productImageDto2);
            }
        }
        for (ProductImageDto productImageDto2 : productImageDto) {
            System.out.println(productImageDto2);
        }

        System.out.println("**");
        // System.out.println(path + fileName);
        String categoryName = (request.getParameter("categoryOption"));
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
        productDto.setProductImages(productImageDto);
        productDto.setQuantity(Integer.parseInt(request.getParameter("stock")));
        ProductServices productServices = new ProductServices();
        productServices.updateProduct(categoryName, productDto);
        System.out.println(request.getParameter("img1"));

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
