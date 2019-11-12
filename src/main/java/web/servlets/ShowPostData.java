package web.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/show")
public class ShowPostData extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("Your Post Data: ");
        out.println("<br />");
        out.println("<code>");
        out.println(bodyContent(request.getReader()));
        out.println("</code>");
        out.println("</body>");
        out.println("</html>");
    }

    private String bodyContent(BufferedReader reader) throws IOException {
        String input = null;
        StringBuilder requestBody = new StringBuilder();
        while((input = reader.readLine()) != null) {
            requestBody.append(input).append("<br>");
        }
        return requestBody.toString();
    }

}
