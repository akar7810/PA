package lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

public class Main {
    public static void main(String args[]) throws IOException, InvalidCatalogException, ClassNotFoundException, URISyntaxException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("Java Resources", "D:/Code/Java/catalog.ser");
        Document doc1 = new Document("java1", "Java Course 5.1",
        		"https://profs.info.uaic.ro/~acf/java/slides/en/input_output_slide_en.pdf");
        Document doc2 = new Document("java2", "Java Course 5.2",
                "https://profs.info.uaic.ro/~acf/java/slides/en/exceptions_slide_en.pdf");
        Document doc3 = new Document("java3", "Java Lab 5",
                "https://profs.info.uaic.ro/~acf/java/labs/slides/lab_05.pdf");
        Document doc4 = new Document("java4", "Java Course 4",
                "D:/Code/Java/collections_slide_en.pdf");
        doc1.addTag("type", "Slides");
        catalog.add(doc1);
        doc2.addTag("type", "Slides");
        catalog.add(doc2);
        doc3.addTag("type", "Slides");
        catalog.add(doc3);
        doc4.addTag("type", "Slides");
        catalog.add(doc4);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws InvalidCatalogException, IOException, ClassNotFoundException, URISyntaxException {
        Catalog catalog = CatalogUtil.load("D:/Code/Java/catalog.ser");
        
        System.out.println("Input your choice of course id: ");   
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String id = reader.readLine();
        
        Document doc = catalog.findById(id);
        if(catalog.findById(id) != null){
	        System.out.println("Name: " + doc.getName() + " with these tags: " + doc.getTags());
	        System.out.println("Document path: " + doc.getPath());
	        CatalogUtil.view(doc);
        }
        else{
        	System.out.println("Tag not found.");
        }
    }
}