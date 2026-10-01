import java.util.Random;
import java.util.Scanner;

public class CardGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String [] [] array = new String[4][4];
        String [] array1 = {"A", "A","B","B","C","C","D","D","E","E","F","F","G","G","H","H"};
        int k;

        // DİZİ OLUŞTU

        for (int i=0; i<array.length;i++){
            for (int j=0; j<array.length; j++){
                while (true){
                    k = random.nextInt(array1.length);
                    if (!array1[k].equals("x")){
                        array[i][j]=array1[k];
                        array1[k]="x";
                        break;
                    }
                }
            }
        }

        // DİZİ YAZILDI

        for (int i=0; i<array.length; i++){
            for (int j=0; j<array.length; j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

        // KULLANICININ OYUNA BAŞLADIĞI KISIM

        int birinci,ikinci;
        int adımSayısı=0;
        while (true){
            int değişken1 =1;
            int değişken2=1;
            String temp1 ="";
            String temp2 =";";
            int a=0;
            int b=0;
            int c=0;
            int d=0;
            System.out.print("İlk Kartı Seçiniz : ");
            birinci=scanner.nextInt();
            System.out.print("İkinci Kartı Seçiniz : ");
            ikinci=scanner.nextInt();

            for (int i=0; i<array.length; i++){
                for(int j=0; j<array.length; j++){
                    if (birinci==değişken1){
                        temp1=array[i][j];
                        a=i;
                        b=j;
                    }else {
                        değişken1++;
                    }
                }
            }

            for (int i=0; i<array.length; i++){
                for(int j=0; j<array.length; j++){
                    if (ikinci==değişken2){
                        temp2=array[i][j];
                        c=i;
                        d=j;
                    }else {
                        değişken2++;
                    }
                }
            }

            if (temp1.equals(temp2)){
                array[a][b]="X";
                array[c][d]="X";
            }

            int t=0;
            for (int i=0; i<array.length; i++){
                for (int j=0; j<array.length; j++){
                    if (array[i][j].equals("X")){
                        t++;
                    }
                }
            }

            adımSayısı=adımSayısı+1;

            if (t==16){
                System.out.println("OYUN BİTTİ!");
                System.out.println("Toplam Adım Sayısı = " + adımSayısı);
                break;
            }

        }
    }
}
