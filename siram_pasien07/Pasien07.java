public class Pasien07 extends Orang07 {
    private int id07;
    private RekamMedik07 rekamMedik07;

    // overloading
    public Pasien07(int id07, String nama07, boolean jenisKelamin07, String alamat07, String noTelp07) {
        super(nama07, jenisKelamin07, alamat07, noTelp07);
        this.id07 = id07;
    }

    // setter methods
    public void setRekamMedik07(RekamMedik07 rekamMedik07) {
        this.rekamMedik07 = rekamMedik07;
    }

    // getter methods
    public RekamMedik07 getRekamMedik07() {
        return rekamMedik07;
    }

    // overriding
    @Override
    public void tampilkanInfo07() {
        System.out.println("=== Data Pasien ===");
        // keyword super
        super.tampilkanInfo07();
        System.out.println("ID Pasien\t: " + id07);
        System.out.println("===================\n");
    }

    // getter methods
    public int getId07() { 
        return id07; 
    }
}