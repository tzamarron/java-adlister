import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CountServlet", urlPatterns = "/count")
public class CountServlet extends HttpServlet {

    private Integer sharedCounter;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        getServletContext().log("init() called");
        sharedCounter = 0;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String counter = req.getParameter("count");
        if (counter != null ) {
            try {
                sharedCounter = Integer.valueOf(counter);
            } catch (NumberFormatException nfe){
                res.resetBuffer();
            }
            out.println("<p>Number of times this page has been viewed: "+sharedCounter);
            res.sendRedirect("/count");
        } else {
            sharedCounter++;
            out.println("<p>Number of times this page has been viewed: "+sharedCounter);
        }

    }

}