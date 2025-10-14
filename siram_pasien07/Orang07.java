

public class Orang07 {
    private String nama07;
    private boolean jenisKelamin07;
    private String alamat07;
    private String noTelp07;

    public Orang07(String nama07, boolean jenisKelamin07, String alamat07, String noTelp07) {
        this.nama07 = nama07;
        this.jenisKelamin07 = jenisKelamin07;
        this.alamat07 = alamat07;
        this.noTelp07 = noTelp07;
    }

    // overloading
    public Orang07(String nama07, boolean jenisKelamin07) {
        this(nama07, jenisKelamin07, "Tidak Diketahui", "Tidak Diketahui");
    }

    // setter methods
    public String getNama07() { 
        return nama07; 
    }

    public void setNama07(String nama07) { 
        this.nama07 = nama07; 
    }

    public boolean isJenisKelamin07() { 
        return jenisKelamin07; 
    }

    public void setJenisKelamin07(boolean jenisKelamin07) { 
        this.jenisKelamin07 = jenisKelamin07; 
    }
    
    public void setAlamat07(String alamat07) { 
        this.alamat07 = alamat07; 
    }

    public void setNoTelp07(String noTelp07) { 
        this.noTelp07 = noTelp07; 
    }

    // getter methods
    public String getAlamat07() { 
        return alamat07; 
    }

    public String getNoTelp07() { 
        return noTelp07; 
    }

    public void tampilkanInfo07() {
        System.out.println("Nama\t\t: " + nama07);
        System.out.println("Jenis Kelamin\t: " + (jenisKelamin07 ? "Laki-laki" : "Perempuan"));
        System.out.println("Alamat\t\t: " + alamat07);
        System.out.println("No. Telepon\t: " + noTelp07);
    }
}