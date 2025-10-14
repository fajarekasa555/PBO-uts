import java.util.ArrayList;
import java.util.List;

public class RekamMedik07 {
    private int id07;
    private Pasien07 pasien07;
    private List<Pemeriksaan07> daftarPemeriksaan07;

    public RekamMedik07(int id07, Pasien07 pasien07) {
        this.id07 = id07;
        this.pasien07 = pasien07;
        this.daftarPemeriksaan07 = new ArrayList<>();
    }

    public void tambahPemeriksaan07(Pemeriksaan07 pemeriksaan07) {
        daftarPemeriksaan07.add(pemeriksaan07);
    }

    public void tampilkanRekamMedik07() {
        System.out.println("=== Rekam Medik Pasien ===");
        System.out.println("Id Rekam Medis\t: " + id07);
        pasien07.tampilkanInfo07();
        for (Pemeriksaan07 p : daftarPemeriksaan07) {
            p.tampilkanPemeriksaan07();
        }
    }
}