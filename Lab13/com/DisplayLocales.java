package com;

import java.util.Locale;

public class DisplayLocales {
public String lan;

    public static void getLocalesEn() {

    	String[] countryCodes = Locale.getISOCountries();

    	for (String countryCode : countryCodes) {

    	    Locale obj = new Locale("", countryCode);

    	    System.out.println("Country Code = " + obj.getCountry() + ", Country Name = " + obj.getDisplayCountry());

    	}
    }
    
    public static void getLocalesRo() {

    	String[] countryCodes = Locale.getISOCountries();

    	for (String countryCode : countryCodes) {

    	    Locale obj = new Locale("", countryCode);

    	    System.out.println("Codul tarii = " + obj.getCountry() + ", Numele tarii = " + obj.getDisplayCountry());

    	}
    }

    public static String getDefaultLocale() {
    	Locale temp = Locale.getDefault();
    	String ok = temp.toLanguageTag();
    	return ok;
    }
    
    
/*
    public static String getDefaultLocale(String lan){
        if(!lan.toLowerCase().equals("ro")) {
        	Locale temp = Locale.getDefault();
        	String ok = temp.toLanguageTag();
          return ok;
        }
        else return "ro";
    }
*/
}