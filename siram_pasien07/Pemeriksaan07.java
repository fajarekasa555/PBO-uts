import java.util.Date;

public class Pemeriksaan07 {
    private int id07;
    private Date tanggalPemeriksaan07;
    private String keluhan07;
    private String diagnosa07;
    private String tindakan07;
    private String obat07;
    private Dokter07 dokter07;

    public Pemeriksaan07(int id07, Date tanggalPemeriksaan07, String keluhan07, String diagnosa07, String tindakan07, String obat07, Dokter07 dokter07) {
        this.id07 = id07;
        this.tanggalPemeriksaan07 = tanggalPemeriksaan07;
        this.keluhan07 = keluhan07;
        this.diagnosa07 = diagnosa07;
        this.tindakan07 = tindakan07;
        this.obat07 = obat07;
        this.dokter07 = dokter07;
    }

    // getter method
    public void tampilkanPemeriksaan07() {
        System.out.println("ID Pemeriksaan\t: " + id07);
        System.out.println("Tanggal\t\t: " + tanggalPemeriksaan07);
        System.out.println("Keluhan\t\t: " + keluhan07);
        System.out.println("Diagnosa\t: " + diagnosa07);
        System.out.println("Tindakan\t: " + tindakan07);
        System.out.println("Obat\t\t: " + obat07);
        System.out.println("Dokter\t\t: " + dokter07.getNama07() + " (" + dokter07.getSpesialisasi07() + ")");
        System.out.println("--------------------------");
    }
}