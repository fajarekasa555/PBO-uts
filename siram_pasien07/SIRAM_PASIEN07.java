import java.text.SimpleDateFormat;
import java.util.*;

public class SIRAM_PASIEN07 {
    private static List<Pasien07> daftarPasien = new ArrayList<>();
    private static List<Dokter07> daftarDokter = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n=== MENU PROGRAM SIRAM PASIEN ===");
            System.out.println("1. Tambah Pasien");
            System.out.println("2. Tampilkan Daftar Pasien");
            System.out.println("3. Tambah Dokter");
            System.out.println("4. Tampilkan Daftar Dokter");
            System.out.println("5. Tambah Riwayat Pemeriksaan");
            System.out.println("6. Tampilkan Riwayat Pemeriksaan");
            System.out.println("7. Selesai");
            System.out.print("Pilih Menu Nomor: ");

            // Validasi input menu
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid!");
                pilihan = 0;
                continue;
            }

            switch (pilihan) {
                case 1 -> tambahPasien();
                case 2 -> tampilkanPasien();
                case 3 -> tambahDokter();
                case 4 -> tampilkanDokter();
                case 5 -> tambahRiwayat();
                case 6 -> tampilkanRiwayat();
                case 7 -> System.out.println("Program selesai.");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 7);
    }

    // -------------------- VALIDASI INPUT --------------------
    // penerapan metode try catch untuk validasi tipe input data
    private static int inputInt(String pesan) {
        while (true) {
            try {
                System.out.print(pesan);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Coba lagi!");
            }
        }
    }

    // penerapan metode try catch untuk validasi tipe input data
    private static String inputString(String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input tidak boleh kosong. Coba lagi!");
        }
    }

    // penerapan metode try catch untuk validasi tipe input data
    private static Date inputTanggal(String pesan) {
        while (true) {
            try {
                System.out.print(pesan + " (dd/MM/yyyy): ");
                String input = scanner.nextLine();
                return new SimpleDateFormat("dd/MM/yyyy").parse(input);
            } catch (Exception e) {
                System.out.println("Format tanggal salah! Gunakan format dd/MM/yyyy (contoh: 15/10/2025)");
            }
        }
    }

    // -------------------- TAMBAH PASIEN --------------------
    private static void tambahPasien() {
        int id = inputInt("ID Pasien\t\t: ");
        String nama = inputString("Nama\t\t\t: ");
        boolean jk = inputString("Jenis Kelamin (L/P)\t: ").equalsIgnoreCase("L");
        String alamat = inputString("Alamat\t\t\t: ");
        String telp = inputString("No Telp\t\t\t: ");

        Pasien07 pasien = new Pasien07(id, nama, jk, alamat, telp);
        daftarPasien.add(pasien);
        System.out.println("Pasien berhasil ditambahkan!");
    }

    private static void tampilkanPasien() {
        if (daftarPasien.isEmpty()) {
            System.out.println("Belum ada data pasien.");
        } else {
            for (Pasien07 p : daftarPasien) {
                p.tampilkanInfo07();
            }
        }
    }

    // -------------------- TAMBAH DOKTER --------------------
    private static void tambahDokter() {
        int id = inputInt("ID Dokter\t\t: ");
        String nama = inputString("Nama\t\t\t: ");
        boolean jk = inputString("Jenis Kelamin (L/P)\t: ").equalsIgnoreCase("L");
        String alamat = inputString("Alamat\t\t\t: ");
        String telp = inputString("No Telp\t\t\t: ");
        String spesialis = inputString("Spesialisasi\t\t: ");

        Dokter07 dokter = new Dokter07(id, nama, jk, alamat, telp, spesialis);
        daftarDokter.add(dokter);
        System.out.println("Dokter berhasil ditambahkan!");
    }

    private static void tampilkanDokter() {
        if (daftarDokter.isEmpty()) {
            System.out.println("Belum ada data dokter.");
        } else {
            for (Dokter07 d : daftarDokter) {
                d.tampilkanInfo07();
            }
        }
    }

    // -------------------- TAMBAH RIWAYAT --------------------
    private static void tambahRiwayat() {
        try {
            int idPasien = inputInt("Masukkan ID Pasien\t: ");
            Pasien07 pasien = daftarPasien.stream().filter(p -> p.getId07() == idPasien).findFirst().orElse(null);
            if (pasien == null) {
                System.out.println("Pasien tidak ditemukan!");
                return;
            }

            int idDokter = inputInt("Masukkan ID Dokter\t: ");
            Dokter07 dokter = daftarDokter.stream().filter(d -> d.getId07() == idDokter).findFirst().orElse(null);
            if (dokter == null) {
                System.out.println("Dokter tidak ditemukan!");
                return;
            }

            int idP = inputInt("Masukkan ID Pemeriksaan\t: ");
            Date tanggal = inputTanggal("Masukkan Tanggal Pemeriksaan");
            String keluhan = inputString("Keluhan\t\t\t: ");
            String diagnosa = inputString("Diagnosa\t\t: ");
            String tindakan = inputString("Tindakan\t\t: ");
            String obat = inputString("Obat\t\t\t: ");

            Pemeriksaan07 pemeriksaan = new Pemeriksaan07(idP, tanggal, keluhan, diagnosa, tindakan, obat, dokter);

            RekamMedik07 rekam = pasien.getRekamMedik07();
            if (rekam == null) {
                rekam = new RekamMedik07(idPasien, pasien);
                pasien.setRekamMedik07(rekam);
            }

            rekam.tambahPemeriksaan07(pemeriksaan);
            System.out.println("Riwayat pemeriksaan berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan input: " + e.getMessage());
        }
    }

    // -------------------- TAMPILKAN RIWAYAT --------------------
    private static void tampilkanRiwayat() {
        int id = inputInt("Masukkan ID Pasien\t: ");
        Pasien07 pasien = daftarPasien.stream().filter(p -> p.getId07() == id).findFirst().orElse(null);
        if (pasien != null && pasien.getRekamMedik07() != null) {
            pasien.getRekamMedik07().tampilkanRekamMedik07();
        } else {
            System.out.println("Rekam medik tidak ditemukan!");
        }
    }
}
