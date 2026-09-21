package lw01.Unguided;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //buat variable rentals untuk menampung semua rental
        Rental[] rentals = new Rental[100]; // asumsi maksimal 100 rental
        int rentalCount = 0;

        //buka file rentals.txt
        File file = new File("lw01/Unguided/rentals.txt");
        Scanner scanner = new Scanner(System.in);

        //masukin data ke array satu per satu
        while (scanner.hasNextLine()) {
            String type = scanner.nextLine();
            String id = scanner.next();
            int days = scanner.nextInt();
            int units = scanner.nextInt();
        }

        //bandingin type, kalo PROJECTOR masukin ke ProjectorRental, kalo LAPTOP masukin ke LaptopRental
            if (type.equals("PROJECTOR")) {
                rentals[rentalCount++] = new ProjectorRental(id, days);
            } else if (type.equals("LAPTOP")) {
                rentals[rentalCount++] = new LaptopRental(id, days);
            }
        

        //cetak hasil
        for (int i = 0; i < rentalCount; i++) {
            System.out.println(rentals[i].summary());
        }
    }
}

