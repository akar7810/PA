package laborator4;

import java.util.*;

public class Main {

    @SuppressWarnings("serial")
	public static void main(String[] args) {
        List<Resident> residents = new ArrayList<Resident>();
        Set<Hospital> hospitals = new TreeSet<Hospital>();

        residents.add(new Resident("R0", "Ivan"));
        residents.add(new Resident("R1", "Ion"));
        residents.add(new Resident("R2", "Ianik"));
        residents.add(new Resident("R3", "Ioan"));

        hospitals.add(new Hospital("H0", 1));
        hospitals.add(new Hospital("H1", 2));
        hospitals.add(new Hospital("H2", 2));
        
        Map<Resident, List<String>> residentPreferencesMap = new HashMap<>();
        Map<Hospital, List<String>> hospitalPreferencesMap = new TreeMap<>();

        residentPreferencesMap.put(residents.get(0), new ArrayList<String>() {{
            add("H0");
            add("H1");
            add("H2");
        }});

        residentPreferencesMap.put(residents.get(1), new ArrayList<String>() {{
            add("H0");
            add("H1");
            add("H2");
        }});

        residentPreferencesMap.put(residents.get(2), new ArrayList<String>() {{
            add("H0");
            add("H1");
        }});

        residentPreferencesMap.put(residents.get(3), new ArrayList<String>() {{
            add("H0");
            add("H2");
        }});
        
        hospitalPreferencesMap.put(hospitals.stream()
        		.filter(hospital -> {return hospital.getName().compareTo("H0") == 0;})
                .findFirst().get(),new ArrayList<String>() {{
	                    add("R3");
	                    add("R0");
	                    add("R1");
	                    add("R2");
                }});

        hospitalPreferencesMap.put(hospitals.stream()
                .filter(hospital -> {return hospital.getName().compareTo("H1") == 0;})
                .findFirst().get(),new ArrayList<String>() {{
	                    add("R0");
	                    add("R2");
	                    add("R1");
	            }});

        hospitalPreferencesMap.put(hospitals.stream()
                .filter(hospital -> {return hospital.getName().compareTo("H2") == 0;})
                .findFirst().get(),new ArrayList<String>() {{
		                add("R0");
		                add("R1");
		                add("R3");
                }});
        
        
        System.out.print("Residents who find acceptable H0 and H2:");
        System.out.println();

        residents.stream()
        	.filter(res -> residentPreferencesMap.get(res).contains("H0"))
        	.filter(res -> residentPreferencesMap.get(res).contains("H2"))
        	.forEach(System.out::println);


        System.out.print("Hospitals that have R0 as their top preference:");
        System.out.println();
        

        for (Map.Entry<Hospital, List<String>> info : hospitalPreferencesMap.entrySet()) {
            if( info.getValue().get(0).compareTo("R0") == 0 ) {
                System.out.print(info.getKey().getName() + " ");
                System.out.println();
            }
        }
        
        


    }
}