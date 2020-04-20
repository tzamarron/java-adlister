import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CountServlet", urlPatterns = "/count")
public class CountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        int pageCounter = 0;
        String counter = req.getParameter("count");
        if (counter != null ) {
            pageCounter = 0;
            out.println("<p>Number of times this page has been viewed: "+pageCounter);
        } else {
            pageCounter++;
            out.println("<p>Number of times this page has been viewed: "+pageCounter);
        }
    }
}