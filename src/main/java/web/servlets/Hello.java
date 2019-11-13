package web.servlets;

import web.module.Book;
import web.module.BookRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@WebServlet(name="HelloWorld", urlPatterns={"/hello"}, loadOnStartup=1)
public class Hello extends HttpServlet {

    private AtomicInteger _counter = null;

    @Override
    public void init() throws ServletException {
        _counter = new AtomicInteger();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String name = req.getParameter("name");
//        String[] values = req.getParameterValues("param");  // param=10&param=20&param=30
        int count = _counter.incrementAndGet();

        req.setAttribute("greeting", String.format("Hello %s!", name));
        req.setAttribute("count", String.valueOf(count));

        req.getRequestDispatcher("/hello.jsp").forward(req, resp);
    }

}
