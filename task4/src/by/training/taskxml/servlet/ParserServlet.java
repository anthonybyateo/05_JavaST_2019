package by.training.taskxml.servlet;

import by.training.taskxml.entity.tariffs.TariffType;
import by.training.taskxml.parser.AbstractTariffBuilder;
import by.training.taskxml.parser.TariffBuilderFaactory;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ParserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         processRequest(request, response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = "E:/Java_course/task4/data/tariffs.xml";

        TariffBuilderFaactory factory = new TariffBuilderFaactory();

        AbstractTariffBuilder saxBuilder = factory.createTariffBuilder("sax");
        AbstractTariffBuilder domBuilder = factory.createTariffBuilder("dom");
        AbstractTariffBuilder staxBuilder = factory.createTariffBuilder("stax");

        saxBuilder.buildSetTariffType(path);
        domBuilder.buildSetTariffType(path);
        staxBuilder.buildSetTariffType(path);

        Set<TariffType> set = new HashSet<>();
        String parser = "sax";

        if (request.getParameter("parser") != null) {

            switch (request.getParameter("parser")) {
                case "sax":
                    parser = "sax";
                    set = saxBuilder.getTariffs();
                    break;
                case "dom":
                    parser = "dom";
                    set = domBuilder.getTariffs();
                    break;
                case "stax":
                    parser = "stax";
                    set = staxBuilder.getTariffs();
                    break;
            }
        }
        request.setAttribute("parser", parser);

        request.setAttribute("res", set );

        String country = "RU";
        String language = "ru";

        if (request.getParameter("lang") != null) {

            switch (request.getParameter("lang")) {
                case "en":
                    country = "GB";
                    language = "en";
                    break;
                case "by":
                    country = "BY";
                    language = "be";
                    break;
                case "ru":
                    country = "RU";
                    language = "ru";
                    break;
            }
        }


        request.setAttribute("language", language);

        Locale current = new Locale(language, country);
        ResourceBundle rb = ResourceBundle.getBundle("text", current);

        String name = rb.getString("th.name");
        String id = rb.getString("th.id");
        String operator = rb.getString("th.operator");
        String payroll = rb.getString("th.payroll");
        String internetPrice = rb.getString("th.internetPrice");
        String mgb = rb.getString("th.mgb");
        String callPrices = rb.getString("th.callPrices");
        String tariffing = rb.getString("th.tariffing");
        String minute = rb.getString("th.minute");
        String favNumber = rb.getString("th.favNumber");
        String connection = rb.getString("th.connection");
        String data = rb.getString("th.data");

        request.setAttribute("name", name);
        request.setAttribute("id", id);
        request.setAttribute("operator", operator);
        request.setAttribute("payroll", payroll);
        request.setAttribute("internetPrice", internetPrice);
        request.setAttribute("mgb", mgb);
        request.setAttribute("callPrices", callPrices);
        request.setAttribute("tariffing", tariffing);
        request.setAttribute("minute", minute);
        request.setAttribute("favNumber", favNumber);
        request.setAttribute("connection", connection);
        request.setAttribute("data", data);

        request.getRequestDispatcher("jsp/result.jsp").forward(request, response);
    }
}