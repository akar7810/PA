package entity;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Artist.findByName",
        query = "select a from Artist a where name = :name")
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(generator = "incrementor")
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "country")
    private String country;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
    	return id + ". Artist: " + name + " from " + country;

    }
}