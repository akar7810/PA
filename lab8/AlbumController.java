package lab8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumController {
    public void create(int id,String name, int releaseYear) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("insert into albums (artist_id,name,release_year) values (?, ?, ?)")) {
            pstmt.setInt(1,id);
            pstmt.setString(2, name);
            pstmt.setInt(3, releaseYear);
            pstmt.executeUpdate();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try(Statement stmt = con.createStatement();){
            stmt.executeQuery("select id from albums where name='" + name + "'");
            ResultSet rs = stmt.getResultSet();
            return rs.next() ? rs.getInt(1) : null;
        }
    }    
    public void list(Integer id) throws SQLException{
        Connection con = Database.getConnection();
        try(Statement stmt = con.createStatement();){
            stmt.executeQuery("select * from albums where artist_id=" +id+ "");
            ResultSet rs = stmt.getResultSet();
            while(rs.next())
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(4));
        }
    }
}
