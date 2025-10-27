/**
 * Kelas Karakter merepresentasikan entitas umum dalam game
 * yang memiliki nama dan tingkat kesehatan (HP).
 * Kelas ini menjadi superclass untuk Pahlawan dan Musuh.
 *
 * @author Ahmad Rizqi Maulana
 * Nim : 202410370110198
 */
class Karakter {
    private String nama;
    private int kesehatan;

    /**
     * Konstruktor untuk membuat objek Karakter baru dengan nama dan kesehatan tertentu.
     *
     * @param nama nama karakter
     * @param kesehatan jumlah kesehatan karakter
     */
    public Karakter(String nama, int kesehatan) {
        this.setNama(nama);
        this.setKesehatan(kesehatan);
    }

    /**
     * Mengambil nama karakter.
     *
     * @return nama karakter
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mengambil nilai kesehatan karakter.
     *
     * @return jumlah kesehatan karakter
     */
    public int getKesehatan() {
        return kesehatan;
    }

    /**
     * Mengatur nilai kesehatan karakter.
     *
     * @param kesehatan nilai baru kesehatan karakter
     */
    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    /**
     * Mengurangi kesehatan karakter sebesar nilai tertentu.
     * Jika hasilnya di bawah 0, maka akan diset menjadi 0.
     *
     * @param amount jumlah damage yang diterima
     */
    public void takeDamage(int amount) {
        this.setKesehatan(Math.max(0, this.getKesehatan() - amount));
        System.out.println(this.getNama() + " sekarang memiliki kesehatan " + this.getKesehatan());
    }

    /**
     * Menampilkan pesan serangan dengan nama metode serangan yang digunakan.
     *
     * @param method jenis serangan (misalnya: pedang, sihir)
     * @param target karakter yang menjadi target serangan
     */
    protected void announceAttack(String method, Karakter target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan " + method + "!");
    }

    /**
     * Method dasar untuk melakukan serangan terhadap karakter lain.
     * Method ini dapat dioverride oleh subclass seperti Pahlawan dan Musuh.
     *
     * @param target karakter yang diserang
     */
    public void serang(Karakter target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + "!");
    }

    /**
     * Mengembalikan representasi string dari karakter, berisi nama dan HP.
     *
     * @return string representasi karakter
     */
    @Override
    public String toString() {
        return getNama() + " (HP: " + getKesehatan() + ")";
    }

    /**
     * Mengatur nama karakter.
     *
     * @param nama nama baru karakter
     */
    public void setNama(String nama) {
        this.nama = nama;
    }


}



/**
 * Kelas Pahlawan merepresentasikan karakter pemain utama yang memiliki kemampuan menyerang dengan pedang.
 * Kelas ini merupakan turunan dari {@link Karakter}.
 */
class Pahlawan extends Karakter {
    /** Damage tetap yang dihasilkan oleh serangan pahlawan. */
    private final int damage = 20;

    /**
     * Konstruktor untuk membuat objek Pahlawan.
     *
     * @param nama nama pahlawan
     * @param kesehatan jumlah kesehatan pahlawan
     */
    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    /**
     * Override method serang untuk menggunakan metode pedang.
     *
     * @param target karakter yang diserang
     */
    @Override
    public void serang(Karakter target) {
        Serang_dengan_pedang(target);
    }

    /**
     * Method privat untuk menyerang musuh menggunakan pedang.
     *
     * @param target karakter yang diserang
     */
    private void Serang_dengan_pedang(Karakter target) {
        announceAttack("pedang", target);
        target.takeDamage(damage);
    }
}

/**
 * Kelas Musuh merepresentasikan karakter lawan yang menyerang menggunakan sihir.
 * Kelas ini merupakan turunan dari {@link Karakter}.
 */
class Musuh extends Karakter {
    /** Damage tetap yang dihasilkan oleh serangan musuh. */
    private final int damage = 15;

    /**
     * Konstruktor untuk membuat objek Musuh.
     *
     * @param nama nama musuh
     * @param kesehatan jumlah kesehatan musuh
     */
    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    /**
     * Override method serang untuk menggunakan metode sihir.
     *
     * @param target karakter yang diserang
     */
    @Override
    public void serang(Karakter target) {
        Serang_dengan_sihir(target);
    }

    /**
     * Method privat untuk menyerang musuh menggunakan sihir.
     *
     * @param target karakter yang diserang
     */
    private void Serang_dengan_sihir(Karakter target) {
        announceAttack("sihir", target);
        target.takeDamage(damage);
    }
}


/**
 * Kelas Main berfungsi sebagai titik masuk program utama.
 * Program ini membuat beberapa karakter (pahlawan dan musuh)
 * lalu menjalankan simulasi serangan antar karakter.
 */
public class Main {
    /**
     * Method utama (entry point) dari program.
     *
     * @param args argumen baris perintah
     */
    public static void main(String[] args) {
        Karakter umum = new Karakter("Karakter Umum", 100);
        Pahlawan brimstone = new Pahlawan("Brimstone", 150);
        Musuh viper = new Musuh("Viper", 200);

        System.out.println("Yo Hola Puto!");
        System.out.println("Status awal:");
        System.out.println(brimstone);
        System.out.println(viper);


        brimstone.serang(viper);
        viper.serang(brimstone);
    }
}
