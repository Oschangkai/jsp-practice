package web.servlets;

import web.module.Book;
import web.module.BookRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
public class Hello extends HttpServlet {

    private AtomicInteger _counter = null;

    @Override
    public void init() throws ServletException {
        _counter = new AtomicInteger();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String name = req.getParameter("name");
        int count = _counter.incrementAndGet();
        StringBuilder books = new StringBuilder();

        BookRepo br = new BookRepo();
        List<Book> bookList = br.getAll();

        for (Book b : bookList) {
            books.append(b.toString());
        }

        req.setAttribute("greeting", String.format("Hello %s!", name));
        req.setAttribute("books", books.toString());
        req.setAttribute("count", String.valueOf(count));

        req.getRequestDispatcher("/books.jsp").forward(req, resp);
    }

}
