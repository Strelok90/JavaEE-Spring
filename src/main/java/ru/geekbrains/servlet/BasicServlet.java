package ru.geekbrains.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "BasicServlet", urlPatterns = "/basic_list")
public class BasicServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.getWriter().printf("<h1>Список продуктов</h1>");
        Product p1 = new Product(1, 10, "Продукт 1");
        Product p2 = new Product(2, 11, "Продукт 2");
        Product p3 = new Product(3, 12, "Продукт 3");
        Product p4 = new Product(4, 13, "Продукт 4");
        Product p5 = new Product(5, 14, "Продукт 5");
        Product p6 = new Product(6, 15, "Продукт 6");
        Product p7 = new Product(7, 16, "Продукт 7");
        Product p8 = new Product(8, 17, "Продукт 8");
        Product p9 = new Product(9, 18, "Продукт 9");
        Product p10 = new Product(10, 19, "Продукт 10");
        List<Product> products = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10));
        products.forEach(p-> {
            try {
                resp.getWriter().println("<p>" + p.toString() + "<p>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().printf("<h1>New POST request</h1>");
    }
}