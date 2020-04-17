package entity;

import javax.persistence.*;

@Entity
@Table(name = "albums")
@NamedQueries({
@NamedQuery(name="Albums.findByName",
        query="select nume from Albums nume where name = :name") ,
@NamedQuery(name="Albums.findByArtist",
        query="select idul from Albums idul where idul.artistId = :id ")
})
public class Album {
	
    @Id
    @GeneratedValue(generator = "incrementor")
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "artist_id")
    private int artistId;
    
    @Column(name = "release_year")
    private int releseYear;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getReleseYear() {
        return releseYear;
    }

    public void setReleseYear(int releseYear) {
        this.releseYear = releseYear;
    }

    @Override
    public String toString() {
    	return id + ". Albums: " + name + " from " + artistId + " in " + releseYear;

    }
}