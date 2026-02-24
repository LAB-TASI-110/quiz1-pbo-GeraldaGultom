import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Input Jumlah Total Data (N)
        System.out.print("Masukkan jumlah total data (N): ");
        int n = input.nextInt();

        // 2. Input Deret Nilai
        int[] deretNilai = new int[n];
        System.out.println("Masukkan deret nilai:");
        for (int i = 0; i < n; i++) {
            deretNilai[i] = input.nextInt();
        }

        // 3. Input Kode Kelompok (Misal: 0 untuk Perempuan, 1 untuk Laki-laki)
        System.out.print("Masukkan kode kelompok (0: Perempuan/Genap, 1: Laki-laki/Ganjil): ");
        int kodeKelompok = input.nextInt();

        // Proses Hitung
        int totalNilai = hitungTotalPerKelompok(deretNilai, kodeKelompok);

        // Output
        System.out.println("Total nilai untuk kelompok tersebut adalah: " + totalNilai);
    }

    /**
     * Method untuk menjumlahkan nilai berdasarkan pola index
     * Index Genap (0, 2, 4) = Kelompok Perempuan (Yohana, Indah)
     * Index Ganjil (1, 3, 5) = Kelompok Laki-laki (Julius, Wilson)
     */
    public static int hitungTotalPerKelompok(int[] nilai, int kode) {
        int total = 0;
        for (int i = 0; i < nilai.length; i++) {
            // Mengecek apakah index sesuai dengan sisa bagi kode kelompok
            if (i % 2 == kode) {
                total += nilai[i];
            }
        }
        return total;
    }
}
