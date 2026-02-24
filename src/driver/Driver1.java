import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Driver1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Inisialisasi Data Menu (Harga dalam ribuan sesuai gambar menu.jpeg)
        Map<String, Integer> hargaMenu = new HashMap<>();
        Map<String, String> namaMenu = new HashMap<>();
        
        String[] kodes = {"NGS", "AP", "SA", "BU", "MAP", "GG", "SAM", "RD", "IB", "NUK"};
        String[] namas = {"Nasi Goreng Spesial", "Ayam Penyet", "Sate Ayam (10 Tusuk)", "Bakso Urat", 
                          "Mie Ayam Pangsit", "Gado-Gado", "Soto Ayam", "Rendang Daging", "Ikan Bakar", "Nasi Uduk Komplit"};
        int[] hargas = {15000, 20000, 25000, 18000, 15000, 15000, 17000, 25000, 35000, 20000};

        for (int i = 0; i < kodes.length; i++) {
            hargaMenu.put(kodes[i], hargas[i]);
            namaMenu.put(kodes[i], namas[i]);
        }

        ArrayList<OrderItem> orders = new ArrayList<>();
        
        // Input Loop
        while (true) {
            String kode = sc.next();
            if (kode.equalsIgnoreCase("END")) break;
            
            int porsiButet = sc.nextInt();
            // Rasio porsi: Ucok(100kg):Butet(50kg) = 2:1. Total = 3 * porsiButet
            int totalPorsi = 3 * porsiButet;
            
            if (hargaMenu.containsKey(kode)) {
                int subTotal = hargaMenu.get(kode) * totalPorsi;
                orders.add(new OrderItem(namaMenu.get(kode), totalPorsi, hargaMenu.get(kode), subTotal));
            }
        }

        // Hitung Total Pembayaran
        long totalKotor = 0;
        for (OrderItem item : orders) {
            totalKotor += item.total;
        }

        // Logika Diskon Kupon
        double diskon = 0;
        if (totalKotor >= 500000) diskon = 0.25;
        else if (totalKotor >= 400000) diskon = 0.20;
        else if (totalKotor >= 300000) diskon = 0.15;
        else if (totalKotor >= 200000) diskon = 0.10;
        else if (totalKotor >= 100000) diskon = 0.05;

        long totalAkhir = (long) (totalKotor - (totalKotor * diskon));

        // Cetak Struk (Format sesuai output.jpeg)
        System.out.printf("%-20s %-7s %-10s %-10s\n", "Menu", "Porsi", "Harga", "Total");
        System.out.println("==================================================");
        for (OrderItem item : orders) {
            System.out.printf("%-20s %-7d %-10d %-10d\n", item.name, item.porsi, item.harga, item.total);
        }
        System.out.println("==================================================");
        System.out.printf("%-39s %-10d\n", "Total Pembayaran", totalAkhir);
    }
}

class OrderItem {
    String name;
    int porsi;
    int harga;
    int total;

    OrderItem(String name, int porsi, int harga, int total) {
        this.name = name;
        this.porsi = porsi;
        this.harga = harga;
        this.total = total;
    }
}
