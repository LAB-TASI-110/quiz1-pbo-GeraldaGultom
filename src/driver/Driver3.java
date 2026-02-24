import java.util.Scanner;
import java.util.ArrayList;

// Class untuk merepresentasikan data Asrama
class Asrama {
    private String nama;
    private String hariJemput;
    private String hariAntar;

    public Asrama(String nama, String hariJemput, String hariAntar) {
        this.nama = nama;
        this.hariJemput = hariJemput;
        this.hariAntar = hariAntar;
    }

    public String getNama() { return nama; }
    public String getHariJemput() { return hariJemput; }
    public String getHariAntar() { return hariAntar; }
}

// Class Driver Utama
public class Driver3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Konstanta sesuai aturan Laundry Del
        final double MAX_KAPASITAS = 7.0;
        final int BIAYA_BULANAN = 45000;

        // Inisialisasi Data Asrama
        ArrayList<Asrama> listAsrama = new ArrayList<>();
        listAsrama.add(new Asrama("Asrama Kembar", "Selasa", "Rabu"));
        listAsrama.add(new Asrama("Asrama Max Planck", "Rabu", "Kamis"));
        listAsrama.add(new Asrama("Asrama Marie Curie", "Jumat", "Sabtu"));
        listAsrama.add(new Asrama("Asrama Archimedes & Louis Pasteur", "Senin", "Selasa"));
        listAsrama.add(new Asrama("Asrama Nikola Tesla", "Kamis", "Jumat"));

        System.out.println("=== SYSTEM OPERASIONAL LAUNDRY DEL ===");
        System.out.println("Biaya Berlangganan: Rp " + BIAYA_BULANAN + "/bulan");
        System.out.println("---------------------------------------");

        // Input Data
        System.out.print("Masukkan Nama Mahasiswa : ");
        String namaMhs = input.nextLine();

        System.out.println("\nDaftar Asrama IT Del:");
        for (int i = 0; i < listAsrama.size(); i++) {
            System.out.println((i + 1) + ". " + listAsrama.get(i).getNama());
        }
        System.out.print("Pilih Nomor Asrama (1-5): ");
        int pilihan = input.nextInt();

        System.out.print("Berat Laundry Bag (kg)  : ");
        double berat = input.nextDouble();

        // Proses Logika dan Output
        System.out.println("\n=======================================");
        System.out.println("            RESIT LAUNDRY DEL          ");
        System.out.println("=======================================");
        
        if (pilihan >= 1 && pilihan <= listAsrama.size()) {
            Asrama terpilih = listAsrama.get(pilihan - 1);
            
            System.out.println("Nama Mahasiswa : " + namaMhs);
            System.out.println("Asrama         : " + terpilih.getNama());
            System.out.println("Berat Pakaian  : " + berat + " kg");
            System.out.println("Biaya Bulanan  : Rp " + BIAYA_BULANAN);

            if (berat > MAX_KAPASITAS) {
                System.out.println("\n[!] STATUS: DITOLAK");
                System.out.println("[!] ALASAN: Berat melebihi batas 7 kg.");
            } else {
                System.out.println("\n[V] STATUS: DITERIMA");
                System.out.println("[V] JADWAL JEMPUT: " + terpilih.getHariJemput());
                System.out.println("[V] JADWAL ANTAR : " + terpilih.getHariAntar());
                System.out.println("\n*Pastikan pakaian sudah di dalam laundry bag.");
            }
        } else {
            System.out.println("Error: Pilihan asrama tidak tersedia.");
        }
        
        System.out.println("=======================================");
        input.close();
    }
}
