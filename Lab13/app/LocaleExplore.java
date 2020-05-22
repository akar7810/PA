package app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

public class LocaleExplore {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

            System.out.println("Language: EN or RO ?");
            String lang = keyboard.nextLine();

            if (lang.toUpperCase().equals("EN")) {
            	SetLocale.setLocaleEn();
            	
                try (InputStream input = new FileInputStream("src/res/Messages.properties")) {

                    Properties prop = new Properties();

                    prop.load(input);
            	
                while (true) {
                    System.out.println(prop.getProperty("prompt"));
                    String choose = keyboard.nextLine();
                    if (choose.equals("locales")) {
                        System.out.println(prop.getProperty("locales"));
                        DisplayLocales.getLocalesEn();
                    } else if (choose.equals("locale.set")) {
                    	String local = DisplayLocales.getDefaultLocale();
                    	System.out.println( MessageFormat.format(prop.getProperty("locale.set"),local));
                        
                    } else if (choose.equals("info")) {
                        System.out.println("Choose a country tag (example: ro, fr etc)");
                        String tag = keyboard.nextLine();
                        Locale newLocale = new Locale(tag.toLowerCase(), tag.toUpperCase());
                        System.out.println(MessageFormat.format(prop.getProperty("info"),tag));
                        Info.displayInfo(newLocale);

                    } else if (choose.equals("exit")) {
                    	System.exit(0);
                    } else {
                    	System.out.println(prop.getProperty("invalid"));
                    }
                }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else if (lang.toUpperCase().equals("RO")) {
            	SetLocale.setLocaleRo();
            	
                try (InputStream input = new FileInputStream("src/res/Messages_ro.properties")) {

                    Properties prop = new Properties();

                    prop.load(input);
                    
                while (true) {
                	System.out.println(prop.getProperty("prompt"));
                    String choose = keyboard.nextLine();
                    if (choose.equals("locales")) {
                    	System.out.println(prop.getProperty("locales"));
                        DisplayLocales.getLocalesRo();
                    } else if (choose.equals("locale.set")) {
                    	String local = DisplayLocales.getDefaultLocale();
                    	System.out.println( MessageFormat.format(prop.getProperty("locale.set"),local));
                    } else if (choose.equals("info")) {
                        System.out.println("Alegeti un tag pentru o tara (exemplu: ro, fr etc)");
                        String tag = keyboard.nextLine();
                        Locale newLocale = new Locale(tag.toLowerCase(), tag.toUpperCase());
                        System.out.println(MessageFormat.format(prop.getProperty("info"),tag));
                        Info.displayInfo(newLocale);

                    } else if (choose.equals("exit")) {
                    	System.exit(0);
                    } else {
                    	System.out.println(prop.getProperty("invalid"));
                    }
                }
                }catch (IOException ex) {
                    ex.printStackTrace();
                }

                
            }
    }
}