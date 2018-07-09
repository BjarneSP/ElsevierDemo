package com.example.demo.DAL;

import com.example.demo.Model.Author;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorDB implements IFAuthorDB {
    @Override
    public Author GetAuthor(Author author) {
        Connection conn = null;
        PreparedStatement getAuthor = null;
        ResultSet authorResult;

        String authorQuery = "SELECT Firstname, Lastname " +
                             "FROM Authors " +
                             "WHERE Id = ?";

        try {
            conn = DBConn.getInstance().getDBcon();
            getAuthor = conn.prepareStatement(authorQuery);
            getAuthor.setInt(1, author.getId());
            authorResult = getAuthor.executeQuery();

            while (authorResult.next()){
                Integer Id = authorResult.getInt("Id");
                String firstName = authorResult.getString("Firstname");
                String lastName = authorResult.getString("Lastname");
                author = new Author(Id, firstName, lastName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }
}
