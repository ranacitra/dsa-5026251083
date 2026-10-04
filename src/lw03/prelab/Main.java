package lw03.prelab;

import java.lang.foreign.AddressLayout;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner read1 = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        List<String> playlist = new ArrayList<>();

        while(read1.hasNextLine()){
            String input = read1.nextLine();
            String action = input.substring(0, input.indexOf(" " )); //"INSERT"
            if(action.equals("ADD")){
            String title  = input.substring(input.indexOf(" ")+1);
            playlist.add(title);
            } else if(action.equals("REMOVE")){
                String title  = input.substring(input.indexOf(" ")+1);
                playlist.remove(title);    
            }else{
                String details = input.substring(input.indexOf(" ")+1); //"1 ATTENTION"
                int index = Integer.parseInt(details.substring(0, details.indexOf(" "))); //"1"
                String title = details.substring(details.indexOf(" ")+1); //"ATTENTION"
                playlist.add(index,title);
            }
        }
        System.out.println("=== PROBLEM 1 ===");
        System.out.println("Jumlah lagu = " + playlist.size());
        int num = 1;
        for(String song : playlist){
            System.out.println(num + ": " + song);
            num++;
        }






        Scanner read = new Scanner(Main.class.getResourceAsStream("participants.txt"));

        Set<String> participants = new HashSet<>();
        int duplikat = 0;

        while(read.hasNextLine()){ //membaca nama nama mahasiswa setiap barisnya
            String name = read.nextLine(); //simpan nama nama di variabel nama
            if(participants.contains(name)){
                duplikat++;
            }
            participants.add(name);
        }
        System.out.println("=== PROBLEM 2 ====");
        System.out.println("Uniquie Participants : " + participants.size());
        int number = 1;
        for(String abc : participants){
            System.out.println(number + ": " + abc);
            number++;
        }
        System.out.println("Duplicate Registration : " + duplikat);







        Scanner read2 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        Map<String, Integer> inventory = new HashMap<>();
        int failed = 0;

        while(read2.hasNext()){
            String in = read2.nextLine();
            String [] parts = in.split(" ");
            String type = parts[0];
            String item = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            if(type.equals(   "ADD")){
                if(inventory.containsKey(item)){
                    inventory.put(item, inventory.get(item) + quantity);
                }else {
                    inventory.put(item, quantity);
                }
            }else{
                if(inventory.containsKey(item) && inventory.get(item) >= quantity){
                    inventory.put(item, inventory.get(item) - quantity);
                }else{
                    failed++;
                }
            }
        }
        System.out.println("=== PROBLEM 3 ====");
            for(String key : inventory.keySet()){
                System.out.println(key + ": " + inventory.get(key));
            }
            System.out.println("Failed sales : " + failed);
    }
}
