package Encapsulation;

public class Pelanggan {
    private double saldo;
    private String noPelanggan;
    private String nama;
    private String pin;
    private int percobaan;
    private boolean diblokir;

    
    
    public Pelanggan(double saldo, String noPelanggan, String nama, String pin ){
        this.saldo = saldo;
        this.noPelanggan = noPelanggan;
        this.nama = nama;
        this.pin = pin;
        this. percobaan = 0;
        this.diblokir = false;
    }
    
    public double getSaldo(){
        return saldo;
    }
    public String getNo(){
        return noPelanggan;
    }
    public String getNama(){
        return nama;
    }
    public String getPin(){
        return pin;
    }
    
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    public void setNo(String noPelanggan){
        this.noPelanggan = noPelanggan;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public void setPin(String pin){
        this.pin = pin;
    }
    
    public boolean autentikasino(String nomor){
        return noPelanggan.equals(nomor);
    }
    
    public boolean autentikasi(String pinInput){
        if(diblokir){
            System.out.println("Akun kamu telah diblokir");
            return false;
        }
        if (pin.equals(pinInput)){
            percobaan = 0;
            return true;
        }else {
            percobaan ++;
            System.out.println("Pin salah percobaan gagal ke-" + percobaan);
            
            if (percobaan >= 3){
                diblokir = true;
                System.out.println("Akun di blokir karena 3 kali salah Pin!");
            }
        }
        return false;
    }
    
    public boolean isBlokir(){
        if (diblokir){
          System.out.println("Maaf aku anda ter-blokir, tidak dapat melakukan transaksi");
        }
        return diblokir;
    }
    
    public void topup(double jumlah){
        saldo = saldo + jumlah;
    }
    
    public void pembelian(double jumlah){
        double saldoAfter = saldo - jumlah;
        
        if (saldoAfter < 10000){
            System.out.println("Transaksi gagal! Saldo minimal dalam rekening harus 10.000!");
            return;
        }
        
        double cashback = hitungCashback(jumlah);
        saldo = saldoAfter + cashback;
        
        System.out.println("Pembelian berhasil.");
        System.out.printf("Casback:  %.2f\n" ,cashback);
        System.out.printf("Saldo sekarang: %.2f\n" , saldo);
    }
    
    private double hitungCashback(double jumlah){
        String kodeAwal = noPelanggan.substring(0,2);
        
        switch (kodeAwal) {
            case "38":
                if (jumlah > 1000000){
                    return jumlah*0.05;
                }   break;
            case "56":
                if(jumlah > 1000000){
                    return jumlah* 0.07;
                }else {
                    return jumlah * 0.02;
                }
            case "74":
                if (jumlah > 1000000){
                    return jumlah*0.10;
                }else{
                    return jumlah*0.05;
                }
            default:
                break;
        }
        return 0;
    }
    
    public void cetakMessage(){
        System.out.println("Nomor Pelanggan     :  " + noPelanggan);
        System.out.println("Nama                :  " + nama);
        System.out.printf("Saldo                : %.2f\n" , saldo);
        System.out.println("Tipe Pelanggan      : "+ getType());
    }
    
    public String getType(){
        String kodeAwal = noPelanggan.substring(0,2);
        
        if (kodeAwal.equals("38")){
            return "Silver";
        }else if(kodeAwal.equals("56")){
            return "Gold";
        }else if (kodeAwal.equals("74")){
            return "Platinum";
        }else {
            return "Type pelanggan tidak diketahui";
        }
    }
}
