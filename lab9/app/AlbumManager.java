package app;

import entity.Album;
import entity.Artist;
import repo.AlbumRepository;
import repo.ArtistRepository;

public class AlbumManager {
    public static void main(String[] args) {
    	AlbumRepository albumRepository = new AlbumRepository();
        ArtistRepository artistRepository = new ArtistRepository();

        artistRepository.create(artistSet("Soil & \"Pimp\" Sessions", "Japan"));
        artistRepository.create(artistSet("Papir ", "Denmark"));
        artistRepository.create(artistSet("Russkaja", "Austria"));


        albumRepository.create(albumSet(1, "Pimp Master", 2005));
        albumRepository.create(albumSet(1, "Magnetic Soil", 2011));
        albumRepository.create(albumSet(1, "Black Track", 2016));

        albumRepository.create(albumSet(2, "Papir", 2010));
        albumRepository.create(albumSet(2, "Stundum", 2011));
        albumRepository.create(albumSet(2, "V", 2017));

        albumRepository.create(albumSet(3, "Russian Voodoo", 2010));
        albumRepository.create(albumSet(3, "Energia!", 2013));
        albumRepository.create(albumSet(3, "No One Is Illegal", 2019));        
        
        System.out.println(artistRepository.findById(1));
        System.out.println(artistRepository.findByName("Papir"));
        System.out.println(albumRepository.findById(3));
    }
    
    public static Album albumSet(int id, String name, int year) {
        Album album = new Album();
        album.setArtistId(id);
        album.setName(name);
        album.setReleseYear(year);
        return album;
    }

    public static Artist artistSet(String name, String contry) {
        Artist artist = new Artist();
        artist.setName(name);
        artist.setCountry(contry);
        return artist;
    }

}