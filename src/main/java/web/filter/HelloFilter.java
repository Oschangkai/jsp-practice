package web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/hello")
public class HelloFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        if(req.getParameter("name") == null) {

            String message = "Missing Parameter 'name'.";

            req.setAttribute("errorMessage", message);
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return;
        }

        chain.doFilter(req, resp);
    }
}
