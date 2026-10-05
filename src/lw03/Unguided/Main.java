package lw03.Unguided;

import java.util.*;

public class Main {
    Scanner read1 = new Scanner (Main.class.getResourceAsStream("enrollment.txt"));
    Map<String, Integer> enrollment = new HashMap<>();
    int rejected = 0; 

        while(read1.hasNext()){
            String in = read1.nextLine();
            String [] parts = in.split(" ");
            String action = parts[0];
            String type = parts[1];
            String cek = parts [2];
            int jumlah = Integer.parseInt(parts[2]);

            if(type.equals(   "REGISTER")){
                if(enrollment.containsKey(type)){
                    enrollment.put(type, enrollment.get(type) + jumlah);
                }else{
                    enrollment.put(type, jumlah);
                }
            }else if(type.equals("WITHDRAW")){
                if(enrollment.containsKey(type) && enrollment.get(type) >= jumlah){
                    enrollment.put(type, enrollment.get(type) - jumlah);
                }else{
                    rejected++;
            }if(type.equals("CHECK")){
                System.out.println(jumlah);
            }
        }

        System.out.println("=== Enrollment Checks ====");
            for(String key : enrollment.keySet()){
                System.out.println(key + ": " + enrollment.get(key) + "students");
            }
        System.out.println("=== Final Enrollment ===");
        for(String key : enrollment.keySet()){
        System.out.println(key + ": " + enrollment.get(key) + "students");
        }
            System.out.println("Rejected operations: " + rejected);
    }
}

