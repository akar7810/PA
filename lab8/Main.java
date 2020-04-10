package lab8;

import java.sql.*;

public class Main {
	
    public static void main(String[] args) {
        try {
            ArtistController artists = new ArtistController();
            AlbumController albums = new AlbumController();
            
            artists.create("Radiohead", "United Kingdom");
            artists.create("Phoenix", "Romania");
            Database.commit();
							
            int phoenixId = artists.findByName("Phoenix");
            albums.create(phoenixId, "Mugur de fluier", 1974);
					
  
	    int radioheadId=artists.findByName("Radiohead");
            albums.create(radioheadId,"OK Computer",1997);
            albums.create(radioheadId,"Kid A",2000);
            albums.create(radioheadId,"In Rainbows",2007);
            albums.list(radioheadId); 
            Database.commit();
          
            Database.closeConnection();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
    
}