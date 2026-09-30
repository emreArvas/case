import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int islem;
        double ilkSayi , ikinciSayi;

        while(true){
            System.out.print("Yapmak istediğiniz işlemi seiniz => ");
            System.out.println("  Toplama : 1 ,  : Çıkarma : 2 , : Çarpma : 3 , : Bölme : 4 , : Mod Alma : 5 , : Çıkış : 0 ");
            System.out.print("0-5 Arasında Bir Değer Seçiniz : ");
            islem = scanner.nextInt();

            if (islem==0){
                System.out.println("İşlem Sonlandı");
                break;
            } else if (islem<0 || islem>5) {
                int deger;
                while (true){
                    System.out.println(" mevcut seçenekler dışında bir değer girilemez");
                    System.out.print("Yapmak istediğiniz işlemi seiniz => ");
                    System.out.println("1:  Toplama ,  2: Çıkarma , 3: Çarpma , 4: Bölme , 5: Mod Alma , 0: Çıkış ");
                    System.out.println("0-5 Arasında Bir Değer Seçiniz");
                    deger = scanner.nextInt();
                    if (deger>=0 && deger<=5){
                        break;
                    }
                }
                islem=deger;
            }

            System.out.print("1. Sayıyı Giriniz : ");
            ilkSayi = scanner.nextDouble();
            System.out.print("2. Sayıyı Giriniz : ");
            ikinciSayi = scanner.nextDouble();

            if (islem==1){
                System.out.println(ilkSayi+ikinciSayi);
            } else if (islem==2) {
                System.out.println(ilkSayi-ikinciSayi);
            } else if (islem==3) {
                System.out.println(ilkSayi*ikinciSayi);
            } else if (islem==4) {
                if (ikinciSayi==0){
                    while (true){
                        System.out.println("bölme işleminde payda 0 olamaz");
                        System.out.print("Yeni Payda Değeri : ");
                        ikinciSayi = scanner.nextDouble();
                        if (ikinciSayi!=0){
                            break;
                        }
                    }
                }
                System.out.println(ilkSayi/ikinciSayi);

            } else if (islem == 5) {
                if (ikinciSayi==0){
                    while (true){
                        System.out.println("mod alma işleminde payda 0 olamaz");
                        System.out.print("Yeni Payda Değeri : ");
                        ikinciSayi = scanner.nextDouble();
                        if (ikinciSayi!=0){
                            break;
                        }
                    }
                }
                System.out.println(ilkSayi%ikinciSayi);
            }

        }

    }
}