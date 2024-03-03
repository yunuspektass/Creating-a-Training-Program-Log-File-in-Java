import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("İdman programına hoş geldiniz...");

        String idmanlar = "Geçerli Hareketler...\n"
                         +"Burpee\n"
                         +"Pushup(Şınav)\n"
                         +"Situp(Mekik)\n"
                         +"Squat";
        System.out.println(idmanlar);

        System.out.println("Bir idman oluşturunuz");

        System.out.print("Burpee sayısı:");
        int burpee = scanner.nextInt();

        System.out.print("Pushup sayısı:");
        int pushup = scanner.nextInt();

        System.out.print("Situp sayısı:");
        int situp = scanner.nextInt();

        System.out.print("Squat sayısı:");
        int squat = scanner.nextInt();
        scanner.nextLine();

        Idman idman = new Idman(burpee,pushup,situp,squat);

        System.out.println("İdmanınız Başlıyor...");

        int i = 1;

        try(FileWriter writer = new FileWriter("log.txt")){

            writer.write("İdman Programı\n");
            writer.write("Burpee Sayısı: " + idman.getBurpee_sayisi() + " \n");
            writer.write("Pushup Sayısı: " + idman.getPushup_sayisi()  + " \n");
            writer.write("Situp Sayısı: " + idman.getSitup_sayisi() + " \n");
            writer.write("Squat Sayısı: " + idman.getSquat_sayisi()  + " \n");



      while (idman.idmanBittiMi() == false){

          System.out.print("Hareket Türü(Burpee,Pushup,Situp,Squat):");
          String tur = scanner.nextLine();

          System.out.print("Bu hareketten kaç tane yapıcaksınız?:");
          int sayi = scanner.nextInt();
          scanner.nextLine();
          idman.hareketYap(tur,sayi);

          writer.write(i + ".İşlem ---------->  Hareket : " + tur + " Sayısı : " + sayi + " \n ");
          i++;


      }
    } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("İdmanını başarıyla bitirdin. Tebrikler");
    }
}