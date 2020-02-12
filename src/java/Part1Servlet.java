
import java.io.IOException;
import java.util.concurrent.Phaser;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 798419
 */
public class Part1Servlet extends HttpServlet {

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

        request.getServletContext().getRequestDispatcher("/WEB-INF/part1.jsp").forward(request, response);
        // response.sendRedirect("ShoppingList");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("guestcount", "<p> you are visitor #" + counter + "!</p>");
        counter++;
        System.out.println("do Post");

        HttpSession session = request.getSession();
        String phrase = request.getParameter("fldPhrase");
        session.setAttribute("phrase", phrase);
        if (phrase != null && !phrase.equals("")) {
            request.getServletContext().getRequestDispatcher("/WEB-INF/part1.jsp").forward(request, response);
            // response.sendRedirect("ShoppingList");
        } else {
            request.getServletContext().getRequestDispatcher("/WEB-INF/part1.jsp").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
