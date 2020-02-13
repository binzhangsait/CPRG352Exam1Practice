
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.security.pkcs11.wrapper.Functions;

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

        String message = "";
        String readAge = readAge(request);
        message = "Average age: " + readAge;
        request.setAttribute("message", message);
        System.out.println(message);

        HttpSession session = request.getSession();
        ArrayList<Person> loadList = Person.loadList(request);
        session.setAttribute("loadlist", loadList);

        request.getRequestDispatcher("/WEB-INF/part2.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("guestcount", "<p> you are visitor #" + counter + "!</p>");
        counter++;
        System.out.println("do Post");

        String name = request.getParameter("fldName");
        String age = request.getParameter("fldAge");

        //or create a validate method in Person to validate the input of name and age.
        try {
            int ageInt = Integer.parseInt(age);
            if (ageInt > 0) {
                String path = getServletContext().getRealPath("/WEB-INF/list.txt");
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
                String line = name + "," + age + "\r\n";
                System.out.println(line);
                pw.write(line);
                pw.flush();
                String message = "";
                String readAge = readAge(request);
                message = "Average age: " + readAge;
                request.setAttribute("message", message);

                HttpSession session = request.getSession();
                ArrayList<Person> loadList = Person.loadList(request);
                session.setAttribute("loadlist", loadList);

                request.getRequestDispatcher("/WEB-INF/part2.jsp").forward(request, response);
            } else {
                String message = "Invalid input";
                request.setAttribute("message", message);
                
                  HttpSession session = request.getSession();
                ArrayList<Person> loadList = Person.loadList(request);
                session.setAttribute("loadlist", loadList);
                
                
                request.getRequestDispatcher("/WEB-INF/part2.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println("invalid input");
            String message = "Invalid input";
            request.setAttribute("message", message);
            
              HttpSession session = request.getSession();
                ArrayList<Person> loadList = Person.loadList(request);
                session.setAttribute("loadlist", loadList);
            
            request.getRequestDispatcher("/WEB-INF/part2.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String readAge(HttpServletRequest request) {
        BufferedReader br = null;
        double totalAge = 0;
        int countAge = 0;
        String temp;

        try {
            String path = request.getServletContext().getRealPath("/WEB-INF/list.txt");
            br = new BufferedReader(new FileReader(new File(path)));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Part2Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while ((temp = br.readLine()) != null) {
                countAge++;
                String[] splitedLine = temp.split(",");
                totalAge += Integer.parseInt(splitedLine[1]);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Not found list.txt");
            return null;
        }
        return (totalAge / countAge) + "";
    }

}
