import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Satır Sayısını Giriniz = ");
        int satırSayısı = scanner.nextInt();
        int [][] dizi = new int [satırSayısı][satırSayısı];

        for (int i=0; i<satırSayısı; i++){
            for (int j=0; j<=i; j++){
                if(j==0 || j==i){
                    dizi[i][j]=1;
                }else {
                    dizi[i][j]=dizi[i-1][j-1]+dizi[i-1][j];
                }
            }
        }
        for (int i=0;i<satırSayısı;i++){
            for (int j=0;j<=i;j++){
                System.out.print(dizi[i][j] +"");
            }
            System.out.println();
        }
    }
}
