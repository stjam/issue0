package lb.test.app;

import lb.test.entity.SearchedObject;
import lb.test.util.FindObjectService;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 28.03.2015.
 */
@WebServlet("/search")
public class SearchView extends HttpServlet {
    private Integer callCount = 0;
    List <SearchedObject> allStuff = new LinkedList<SearchedObject>();
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        doPost(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html; charset=UTF-8");
        httpServletRequest.setCharacterEncoding("UTF-8");
        PrintWriter pw = httpServletResponse.getWriter();


        pw.println("<html>");
        pw.println("<head>");
        pw.println("<p>Прайс лист</p>");
        pw.println("<title>");
        pw.println("Прайс лист");
        pw.println("</title>");
        pw.println("</head>");
        pw.println("<body>");

        pw.println("<form method=" + "post" + " action=/invokeQuery>");
        pw.println("<table>");
        pw.println("<tr>");
        pw.println("<td>");
        pw.println("<p>Категория</p>");
        pw.println("</td>");
        pw.println("<td>");
        pw.println("<p>Наименование</p>");
        pw.println("</td>");
        pw.println("<td>");
        pw.println("<p>Цена от</p>");
        pw.println("</td>");
        pw.println("<td>");
        pw.println("<p>Цена до</p>");
        pw.println("</td>");
        pw.println("</tr>");
        pw.println("<tr>");
        pw.println("<td>");
        pw.println("<input type = " + "text" + " name = "+ "category" + ">");
        pw.println("</td>");
        pw.println("<td>");
        pw.println("<input type =" + "text" + " name = " + "goodsname" + ">");
        pw.println("</td>");
        pw.println("<td>");
        pw.println("<input type = " + " text " + "name = priceLowerBound" + ">");
        pw.println("</td>");
        pw.println("<td>");
        pw.println("<input type=" + "text " + "name = priceUpperBound" + ">");
        pw.println("</td>");
        pw.println("<td>");
        pw.println("<input type =" + "submit " + "value="+"Найти"+">");
        pw.println("</td>");
        pw.println("</tr>");

        pw.println("</table>");
        pw.println(" </form>");
        if(callCount>0) {
            final String category = httpServletRequest.getParameter("category");
            final String priceLowerBound = httpServletRequest.getParameter("priceLowerBound");
            final String priceUpperBound = httpServletRequest.getParameter("priceUpperBound");
            final String name = httpServletRequest.getParameter("goodsname");
            if (((category == null) || (category.length() == 0))
                    && ((priceLowerBound == null) || (priceLowerBound.length() == 0))
                    && ((priceUpperBound == null) || (priceUpperBound.length() == 0))
                    && ((name == null) || (name.length() == 0))) {
                pw.println("<tr style=\"background: #CCCCCC\"> Что же ничего не ищете?(</tr>");
            } else {
                List<SearchedObject> list = FindObjectService.findAllByRequest(
                        category,
                        name,
                        priceLowerBound,
                        priceUpperBound);
                if(list.size()>0)
                pw.println("<p>Результаты поиска</p>");
                drawTableComponent(pw, list);
            }
        }
        if(callCount==0) {
            allStuff = FindObjectService.simplyGetAll();
        }
        if(allStuff.size()>0) {
        pw.println("<p>Каталог товаров</p>");
            drawTableComponent(pw, allStuff);
        }
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
        callCount++;
    }

    private static void drawTableComponent(final PrintWriter pw, final List<SearchedObject> list){
        if(list.size()>0){
        pw.println("<table width=\"500\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\">");
        pw.println("<tr style=\"background: #CCCCCC\">");
        pw.println("<td>");
        pw.println("<p>Категория</p>");
        pw.println("</td>");
        pw.println("<td>");
        pw.println("<p>Наименование</p>");
        pw.println("</td>");
        pw.println("<td>");
        pw.println("<p>Цена</p>");
        pw.println("</td>");
        pw.println("</tr>");
        Iterator<SearchedObject> iterator = list.iterator();
        while (iterator.hasNext()) {
            SearchedObject searchedObject = iterator.next();
            pw.println("<tr><td>" + searchedObject.getName() + "</td><td>" + searchedObject.getProductName() + "</td><td>" + searchedObject.getPrice() + "</td></tr>");
        }
        pw.println("</table>");
        }
    }

}
