package lab5;

import java.awt.Desktop;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            output.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException, IOException, ClassNotFoundException {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
            Catalog catalog = (Catalog) input.readObject();
            return catalog;
        }
    }

    public static void view(Document doc) throws URISyntaxException,IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI(doc.getPath()));
    }
}