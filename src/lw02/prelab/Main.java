package lw02.prelab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        
        LinkedList<String[]> listTransaksi = new LinkedList<>();
        Scanner scanner = new Scanner(new File("src/lw02/prelab/transactions.txt"));        
        while (scanner.hasNextLine()) {
            listTransaksi.add(scanner.nextLine().split(" "));
        }
        scanner.close();

        LinkedList<String[]> listNasabah = new LinkedList<>();
        for (String[] transaksi : listTransaksi) {
            boolean ada = false;
            for (String[] nasabah : listNasabah) {
                if (nasabah[0].equals(transaksi[0])) {
                    ada = true;
                    break;}
            }
            if (!ada) {
                listNasabah.add(new String[]{transaksi[0], "0"});
            }
        }

        Queue<String[]> queueTransaksi = new LinkedList<>();
        for (String[] t : listTransaksi) {
            queueTransaksi.add(t);
        }

        Stack<String[]> stackGagal = new Stack<>();
        
        while (!queueTransaksi.isEmpty()) {
            String[] t = queueTransaksi.poll();
            for (String[] nasabah : listNasabah) {
                if (nasabah[0].equals(t[0])) {
                    int saldoSekarang = Integer.parseInt(nasabah[1]);
                    int nominal = Integer.parseInt(t[2]);
                    
                    if (t[1].equals("DEPOSIT")) {
                        nasabah[1] = String.valueOf(saldoSekarang + nominal);
                    } else if (t[1].equals("WITHDRAW")) {
                        if (saldoSekarang >= nominal) {
                            nasabah[1] = String.valueOf(saldoSekarang - nominal);
                        } else {
                            stackGagal.push(t);
                        }
                    }
                    break;
                }
            }
        }

        System.out.println("=== Final Balances ===");
        for (String[] nasabah : listNasabah) {
            System.out.println(nasabah[0] + ": " + nasabah[1]);
        }

        System.out.println("=== Failed Transactions ===");
        while (!stackGagal.isEmpty()) {
            String[] gagal = stackGagal.pop();
            System.out.println(gagal[0] + " " + gagal[1] + " " + gagal[2]);
        }
    }
}