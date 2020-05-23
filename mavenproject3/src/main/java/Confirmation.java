
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author monke
 */
@WebServlet(urlPatterns = "/Confirmation")
public class Confirmation extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // Write the response message, in an HTML page
      try {
         out.println("<!DOCTYPE HTML>\n" +
                        "<html>\n" +
                        "    <head>\n" +
                        "        <title>JNAH</title>\n" +
                        "        <link rel=\"stylesheet\" href=\"main.css\" />\n" +
                        "        <link rel=\"icon\" href=\"picture/logo-JNAH.PNG\">\n" +
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "        <meta name=\"description\" content=\"Building a dynamic website using HTML, JavaScript, and CSS\">\n" +
                        "        <meta name=\"author\" content=\"Jonathan Tran, Nina Vuong, Anh Nguyen, Huy Luong\">\n" +
                        "        \n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        <!-- NAVBAR -->\n" +
                        "        <nav id=\"main-nav\">\n" +
                        "            <div class=\"row\">\n" +
                        "                <div class=\"container\">\n" +
                        "                    <div class=\"logo\">\n" +
                        "                        <a href=\"home.html\"><img src=\"picture/logo.PNG\" alt=\"logo\"></a>\n" +
                        "                    </div>\n" +
                        "\n" +
                        "                    <ul class=\"nav-menu\" style=\"list-style-type:none;\" id=\"navbar\">\n" +
                        "                        <li><a href=\"home.html\">Home</a></li>\n" +
                        "                        <li><a href=\"home.html#products\">Products</a></li>\n" +
                        "                        <li><a href=\"form.html\">Order</a></li>\n" +
                        "                        <li><a href=\"home.html#about-us\">About Us</a></li>\n" +
                        "                        <li><a href=\"home.html#contact-us\">Contact Us</a></li>\n" +
                        "                        <li> <a href=\"javascript:void(0);\" class=\"nav-icon\" onclick=\"navbar()\">\n" +
                        "                            <i class=\"fa fa-bars\"></i> </a></li>\n" +
                        "                    </ul>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "            <ul id=\"toggle\" class=\"toggle-menu\" style=\"list-style-type:none;\">\n" +
                        "                <li><a href=\"home.html\">Home</a></li>\n" +
                        "                <li><a href=\"home.html#products\">Products</a></li>\n" +
                        "                <li><a href=\"form.html\">Order</a></li>\n" +
                        "                <li><a href=\"home.html#about-us\">About Us</a></li>\n" +
                        "                <li><a href=\"home.html#contact-us\">Contact Us</a></li>\n" +
                        "            </ul>\n" +
                        "        </nav>\n" +
                        "        \n" +
                        "        <!-- PRODUCTS DETAIL -->\n" +
                        "        <div class=\"container\">\n" +
                        "            <section class=\"wrapper confirmation\">                \n" +
                        "                <div class=\"row\">     \n" +
                        "                    <div class=\"col-12\">\n" +
                        "                        <h2>Thank you for your order!</h2>\n" +
                        "                        <h6> We've recieved your order, here are the details.</h6>\n" +
                        "                        <hr>\n" +
                        "                    </div>\n" +
                        "                </div> \n" +
                        "                <div class=\"row body\">\n" +
                        "                    <div class=\"col-12\">\n" +
                        "                        <h3> Delivery Details </h3> \n" +
                        "                    </div>\n" +
                        "                    <div class=\"col-6\">\n" +
                        "                        <h4> Delivery for </h4>\n" +
                        "                        <h5> Customer: <span id=\"customerName\"></span></h5>\n" +
                        "                        <h5> Phone Number: <span id=\"phoneNumber\"></span></h5>\n" +
                        "                        <h5> Address: <span id=\"address\"></span></h5>\n" +
                        "                    </div>     \n" +
                        "                    <div class=\"col-6\">\n" +
                        "                        <h4> Delivery Method </h4>\n" +
                        "                        <h5><span id=\"method\"></span></h5>\n" +
                        "                    </div>\n" +
                        "                    <div class=\"col-12\">\n" +
                        "                        <hr>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "                <div class=\"row body\">\n" +
                        "                    <div class=\"col-12\">\n" +
                        "                        <h3> Order Summary </h3> \n" +
                        "                    </div>\n" +
                        "                    <div class=\"col-6\">\n" +
                        "                        <h4> Item Ordered </h4>\n" +
                        "                        <h5> Item: <span id=\"item\"></span></h5>\n" +
                        "                        <h5> Price: <span id=\"price\"></span></h5>\n" +
                        "                        <h5> Quantity: <span id=\"quantity\"></span></h5>\n" +
                        "                    </div>     \n" +
                        "                    <div class=\"col-6\">\n" +
                        "                        <h4> Receipt Information </h4>\n" +
                        "                        <h5> Subtotal: $<span id=\"subtotal\"></span></h5>\n" +
                        "                        <h5> Shipping: $<span id=\"shipping\"></span></h5>\n" +
                        "                        <h5> Tax: $<span id=\"tax\"></span></h5>\n" +
                        "                        <h5> Total: $<span id=\"total\"></span></h5>\n" +
                        "                    </div>\n" +
                        "                    <div class=\"col-12\">\n" +
                        "                        <hr>\n" +
                        "                    </div>\n" +
                        "                </div> \n" +
                        "                <div class=\"row body\">\n" +
                        "                    <div class=\"col-12\">\n" +
                        "                        <h3> Payment Information </h3> \n" +
                        "                    </div>\n" +
                        "                    <div class=\"col-6\">\n" +
                        "                        <h4> Credit Card </h4>\n" +
                        "                        <h5> Card Number: <span id=\"cardNumber\"></span></h5>\n" +
                        "                        <h5> Expiration Date: <span id=\"expireDate\"></span></h5>\n" +
                        "                    </div>     \n" +
                        "                    <div class=\"col-6\">\n" +
                        "                        <h4> Billing Address </h4>\n" +
                        "                        <h5> <span id=\"billingAddress\"></span> </h5>\n" +
                        "                    </div>\n" +
                        "                </div> \n" +
                        "                <div class=\"row end\">\n" +
                        "                    <div class=\"col-12\">\n" +
                        "                        <a href=\"home.html\" class=\"button\">Go to Home Page</a>\n" +
                        "                    </div>\n" +
                        "                </div>                       \n" +
                        "            </section>\n" +
                        "        </div> \n" +
                        "        \n" +
                        "        <!-- FOOTER -->\n" +
                        "        <footer id=\"contact-us\">\n" +
                        "            <div class=\"row\">\n" +
                        "                <div class=\"col-5 col-s-5\">\n" +
                        "                    <div class=\"field\">\n" +
                        "                        <h4> ABOUT US </h4>\n" +
                        "                        <p> At JNAH, we never follow the trend, because we'd like to start the trend of the world. We promise to stay ahead of fashion trends,\n" +
                        "                            market demand, and latest technology to provide extraordinary goods that fit personal needs in\n" +
                        "                            this constant changing era. <i class=\"fas fa-heart\"></i></p>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "                <div class=\"col-3 col-s-3\">\n" +
                        "                    <div class=\"field\">\n" +
                        "                        <h4>QUICK LINKS</h4>\n" +
                        "                        <h5><a href=\"home.html#products\"> Products </a></h5>\n" +
                        "                        <h5><a href=\"home.html#about-us\"> About us </a></h5>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "                <div class=\"col-4 col-s-4\">\n" +
                        "                    <div class=\"field\">\n" +
                        "                        <h4> CONTACT US </h4>\n" +
                        "                        <h5> <i class=\"fas fa-door-open\"></i> Open Daily: 9am-9pm</h5>\n" +
                        "                        <h5> <i class=\"fas fa-map-marked-alt\"></i> 123456 Bison, Irvine, CA 92697</h5>\n" +
                        "                        <h5> <i class=\"fas fa-phone\"></i> Phone number: 714-999-9999</h5>\n" +
                        "                        <h5> <i class=\"fas fa-envelope\"></i> Email: jnahgroup@gmail.com</h5>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "            <div class=\"row\" style=\"text-align: center;\">\n" +
                        "                <p>Copyright © 2020 All rights reserved | This page is made by JNAH</p>\n" +
                        "            </div>\n" +
                        "        </footer>\n" +
                        "\n" +
                        "    </body>\n" +
                        "</html>");

        } finally {
           out.close();  // Always close the output writer
        }
      
    }          
}
