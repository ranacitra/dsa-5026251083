package lw02.Unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
	
        Scanner sc = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));
        LinkedList<String[]> requests = new LinkedList<>();
        LinkedList<String[]> books = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();
        LinkedList<String[]> success = new LinkedList<>();
        books.add(new String[]{"Kalkulus", "2"});
        books.add(new String[]{"Fisika", "1"});
        books.add(new String[]{"Statistika", "2"});
        while (sc.hasNext()) {
            String[] request = new String[2];
            request[0] = sc.next();//nama 
            request[1] = sc.next();//judul 
            requests.add(request);
        }
        sc.close();
        queue.addAll(requests);
        while(!queue.isEmpty()) {
            String[] request = queue.poll();
            String name = request[0];
            String judul = request[1];
            String[] member = null;
            for(String[] mem : members) {
                if(mem[0].equals(name)) {
                    member = mem	;
                    break;
                }
            }
	        //kalau blm pernah 
            if(member==null) {
                member = new String[]{name, "0"};
                members.add(member);
            }
            String[] book = null;
            for(String[] buku : books) {
                if(buku[0].equals(judul)) {
                    book = buku;
                    break;
                }
            }
            int stock = Integer.parseInt(book[1]);
            int jumlahPinjam = Integer.parseInt(member[1]);

            //syarat berhasil = stok buku >0 dan member blm limit (max 2)
            if(stock> 0 && jumlahPinjam < 2) {
                book[1] = String.valueOf(stock - 1);
                member[1] = String.valueOf(jumlahPinjam + 1);
                success.add(request);
            } else {
                failed.push(request);
            }
        }
        //output
        System.out.println("=== Successfully Processed Requests ===");
        for(String[] sukses : success) {
            System.out.println(sukses[0] + " " + sukses[1]);
        }
        System.out.println("=== Remaining Book Stock ===");
        for(String[] buku : books) {
            System.out.println(buku[0] + ": " + buku[1]);
        }
        System.out.println("=== Failed Requests ===");
        while(!failed.isEmpty()) {
            String[] f = failed.pop();
            System.out.println(f[0] + " " + f[1]);
        }
    }
}