
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 798419
 */
public class Part2Servlet extends HttpServlet {

    private int counter;

    @Override
    public void init() throws ServletException {
        counter = 0;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("guestcount", "<p> you are visitor #" + counter + "!</p>");
        counter++;
        System.out.println("do GET");

        //request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        // response.sendRedirect("ShoppingList");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("guestcount", "<p> you are visitor #" + counter + "!</p>");
        counter++;
        System.out.println("do Post");

        //request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        // response.sendRedirect("ShoppingList");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
