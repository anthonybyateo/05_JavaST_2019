package by.training.taskxml.demo;

import by.training.taskxml.parser.AbstractTariffBuilder;
import by.training.taskxml.parser.TariffBuilderFaactory;

import java.io.*;
import java.util.GregorianCalendar;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//@WebServlet("/data")
@WebServlet("/timeaction")
public class Demo extends HttpServlet {
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
        GregorianCalendar gc = new GregorianCalendar();
        String timeJsp = request.getParameter("time");
        float delta =
                ((float) (gc.getTimeInMillis() - Long.parseLong(timeJsp)))/1_000;
        request.setAttribute("res", delta);
        request.getRequestDispatcher("/jsp/result.jsp").forward(request, response);
    }
/*        public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        String path = "data/tariffs.xml";

        TariffBuilderFaactory factory = new TariffBuilderFaactory();

        AbstractTariffBuilder saxBuilder = factory.createTariffBuilder("sax");
        AbstractTariffBuilder domBuilder = factory.createTariffBuilder("dom");
        AbstractTariffBuilder staxBuilder = factory.createTariffBuilder("stax");

        saxBuilder.buildSetTariffType(path);
        domBuilder.buildSetTariffType(path);
        staxBuilder.buildSetTariffType(path);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World!</h1>");
        out.println("<p>"+ getClass().getName() +"</p>");
        out.println("<p>"+ domBuilder.getTariffs().toString() +"</p>");
        out.println("<p>"+ staxBuilder.getTariffs().toString() +"</p>");
        out.println("<p>"+ path +"</p>");
        out.println("</body>");
        out.println("</html>");
    }*/
}