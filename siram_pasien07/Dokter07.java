public class Dokter07 extends Orang07 {
    private int id07;
    private String spesialisasi07;

    // overloading
    public Dokter07(int id07, String nama07, boolean jenisKelamin07, String alamat07, String noTelp07, String spesialisasi07) {
        super(nama07, jenisKelamin07, alamat07, noTelp07);
        this.id07 = id07;
        this.spesialisasi07 = spesialisasi07;
    }

    // overriding
    @Override
    public void tampilkanInfo07() {
        System.out.println("=== Data Dokter ===");
        // keyword super
        super.tampilkanInfo07();
        System.out.println("ID Dokter\t: " + id07);
        System.out.println("Spesialisasi\t: " + spesialisasi07);
        System.out.println("===================\n");
    }

    // setter mothod
    public void setSpesialisasi07(String spesialisasi) {
        this.spesialisasi07 = spesialisasi;
    }

    // getter methods
    public int getId07() { 
        return id07; 
    }

    // getter methods
    public String getSpesialisasi07() { 
        return spesialisasi07; 
    }
}