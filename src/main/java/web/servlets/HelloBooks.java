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

@WebServlet(name="HelloBooks", urlPatterns={"/books"}, loadOnStartup=1)
public class HelloBooks extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BookRepo br = new BookRepo();
        List<Book> bookList = br.getAll();

        String books = bookList.stream()
                .map(Book::toString)
                .collect(Collectors.joining(" & "));

        req.setAttribute("books", books);

        req.getRequestDispatcher("/books.jsp").forward(req, resp);
    }

}
