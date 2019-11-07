package web.module;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepo {
    private static final String _url = "jdbc:mysql://db:3306/Test";
    private static final String _user = "root";
    private static final String _pass = "password";

    public List<Book> getAll() {

        ResultSet rs;
        List<Book> books = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection conn = DriverManager.getConnection(_url, _user, _pass);
            PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM Books;");) {

            rs = pStmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                books.add(new Book(id, name));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return books;
    }

}
