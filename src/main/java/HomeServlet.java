import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/person")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id").trim();
        Pattern pattern = Pattern.compile("\\d*");
        Matcher matcher = pattern.matcher(id);
        if (matcher.matches()) {
            int userId = Integer.parseInt(id);
            resp.getWriter().print(new PersonFinder().getPerson(userId));
        } else {
            resp.getWriter().print("Wrong ID data. ID should be a number more than 0!");
        }
    }
}
