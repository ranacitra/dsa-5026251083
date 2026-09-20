import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //buat variable jobs utk menampung semua printjob
        List<PrintJob> jobs = new ArrayList<>();
        
        //buka file jobs.txt
        File file = new File("lw01/prelab/jobs.txt");
        Scanner sc = new Scanner(file);

        //masukin data ke array satu satu
        for(int i=0; i<5;i++){
            String type = sc.next();
            String id = sc.next();
            int pages = sc.nextInt();

        //bandingin type, kalo MONO masukin ke MonoPrint, kalo COLOUR masukin ke ColourPrint
        if(type.equals("MONO")){
            jobs.add(new MonoPrint(id, pages));
        }else{
            jobs.add(new ColourPrint(id, pages));
        }
        }
        sc.close();

        //cetak hasil
        for(int i=0;i<5;i++){
        System.out.println(jobs.get(i).summary());
    } 
    }
}
