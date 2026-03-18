
package Encapsulation;
import java.util.Scanner;

public class MainPelanggan {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        
        Pelanggan[] daftar = new Pelanggan[3];
        daftar [0] = new Pelanggan (3000000, "3632333435", "Adit","2323");
        daftar [1] = new Pelanggan (4000000, "5657585960", "Sopo", "2525");
        daftar [2] = new Pelanggan( 2000000,"7411121314", "Jarwo" , "1212");
        
        System.out.println("Selamat Datang!");
        System.out.print("Silakan masukkan nomor pelanggan anda: ");
        String nomor = input.nextLine();
        Pelanggan pelangganon = null;
        
        for (int i =0; i< daftar.length; i++ ){
            if (daftar[i].autentikasino(nomor)){
                pelangganon = daftar[i];
                break;
            }
        }
        
        if (pelangganon== null){
            System.out.println("Nomor pelanggan tidak ditemukan!");
            return;
        }
        
        String pinInput;
        
        while(true){
            if (pelangganon.isBlokir()){
                System.out.println("Program dihentikan karena akun Terblokir");
                return;
           }
           System.out.print("Silakan masukkan pin anda: ");
           pinInput = input.nextLine(); 
           
           if(pelangganon.autentikasi(pinInput)){
               System.out.println("Berhasil Masuk");
               break;
           }
        }
        
        int pilihan;
        
        do{
            System.out.println("=====MENU====");
            System.out.println("1.  Top Up");
            System.out.println("2.  Pembelian");
            System.out.println("3.  Cek Saldo");
            System.out.println("4.  Keluar");
            System.out.print("Masukkan pilihan anda: ");
            
            pilihan = input.nextInt();
            
            switch(pilihan){
                case 1:
                    System.out.print("Masukkan jumlah top up    : ");
                    double topup = input.nextDouble();
                    pelangganon.topup(topup);
                    break;
                case 2: 
                    System.out.println("Masukkan jumlah pembelian   : ");
                    double beli =input.nextDouble();
                    pelangganon.pembelian(beli);
                    break;
                case 3:
                    pelangganon.cetakMessage();
                    break;
                case 4:
                    System.out.println("Terima kasih, Program Selesai");
                    break;
                default: 
                    System.out.println("Menu tidak tersedia");    
            }
        }while(pilihan !=4);
        
        input.close();
    }
    
}
