package lb.test.app;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.table.TableStringConverter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by root on 29.03.2015.
 */
@WebServlet("/invokeQuery")
public final class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        final String  cat = req.getParameter("category");
        final String goodsName =  req.getParameter("goodsname");
        final String priceLowerBound = req.getParameter("priceLowerBound");
        final String priceUpperBound = req.getParameter("priceUpperBound");
        final PrintWriter pw = resp.getWriter();
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<head>");
        pw.println("<body onload=document.createElement('form').submit.call(document.getElementById('someId'))>");

        pw.println("<form id = someId method = post"+ " action=/search>");
        pw.println("<input type = " + "hidden" + " name = category value = " + cat.toString() + ">");
        pw.println("<input type = hidden name = goodsname value = '"+goodsName+"'>");
        pw.println("<input type = hidden name = priceLowerBound value='"+priceLowerBound+"'>");
        pw.println("<input type = hidden name = priceUpperBound value='"+priceUpperBound+"'>");
        pw.print("<input type = hidden >");
        pw.println("</form>");
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
    }
}
