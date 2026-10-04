import java.util.Scanner;

public class CevreAlanHesabı {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            while (true) {

                System.out.println("\n--- ALAN ÇEVRE HESAPLAYICI ---");
                System.out.println("1 - Hesaplama");
                System.out.println("0 - Çıkış");

                int anaSecim = tamSayiAl(scanner, "Seçiminiz: ");

                if (anaSecim == 0) {
                    System.out.println("Programdan çıkılıyor...");
                    break;
                }

                if (anaSecim != 1) {
                    System.out.println("Hatalı seçim! Lütfen 1 veya 0 giriniz.");
                    continue;
                }

                System.out.println("\n--- İŞLEM SEÇİMİ ---");
                System.out.println("1 - Alan");
                System.out.println("2 - Çevre");

                int islem = secimAl(scanner, "Seçiminiz: ", 1, 2);

                System.out.println("\n--- ŞEKİL SEÇİMİ ---");
                System.out.println("1 - Üçgen");
                System.out.println("2 - Kare");
                System.out.println("3 - Dikdörtgen");
                System.out.println("4 - Daire");

                int sekil = secimAl(scanner, "Seçiminiz: ", 1, 4);

                double sonuc = 0;

                if (sekil == 1) {

                    System.out.println("\n--- ÜÇGEN TÜRÜ ---");
                    System.out.println("1 - Eşkenar üçgen");
                    System.out.println("2 - İkizkenar üçgen");
                    System.out.println("3 - Çeşitkenar üçgen");

                    int ucgenTuru = secimAl(scanner, "Seçiminiz: ", 1, 3);

                    if (ucgenTuru == 1) {

                        double kenar = pozitifSayiAl(scanner, "Kenar uzunluğunu giriniz: ");

                        if (islem == 1) {
                            sonuc = (Math.sqrt(3) / 4) * kenar * kenar;
                            System.out.println("Üçgenin alanı: " + sonuc);
                        } else {
                            sonuc = 3 * kenar;
                            System.out.println("Üçgenin çevresi: " + sonuc);
                        }
                    }

                    else if (ucgenTuru == 2) {

                        double esitKenar = pozitifSayiAl(scanner,
                                "Eşit kenarlardan birini giriniz: ");

                        double taban = pozitifSayiAl(scanner,
                                "Taban uzunluğunu giriniz: ");

                        if (islem == 1) {

                            double yukseklik = Math.sqrt(
                                    (esitKenar * esitKenar)
                                            - ((taban / 2) * (taban / 2))
                            );

                            sonuc = (taban * yukseklik) / 2;

                            System.out.println("Üçgenin alanı: " + sonuc);

                        } else {

                            sonuc = 2 * esitKenar + taban;

                            System.out.println("Üçgenin çevresi: " + sonuc);
                        }
                    }

                    else {

                        double a = pozitifSayiAl(scanner, "1. kenarı giriniz: ");
                        double b = pozitifSayiAl(scanner, "2. kenarı giriniz: ");
                        double c = pozitifSayiAl(scanner, "3. kenarı giriniz: ");

                        if (a + b <= c || a + c <= b || b + c <= a) {

                            System.out.println("Bu kenarlarla geçerli bir üçgen oluşturulamaz.");

                        } else {

                            if (islem == 1) {
                                double s = (a + b + c) / 2;

                                sonuc = Math.sqrt(
                                        s * (s - a) * (s - b) * (s - c)
                                );

                                System.out.println("Üçgenin alanı: " + sonuc);

                            } else {

                                sonuc = a + b + c;

                                System.out.println("Üçgenin çevresi: " + sonuc);
                            }
                        }
                    }
                }

                else if (sekil == 2) {

                    double kenar = pozitifSayiAl(scanner,
                            "Karenin kenar uzunluğunu giriniz: ");

                    if (islem == 1) {

                        sonuc = kenar * kenar;

                        System.out.println("Karenin alanı: " + sonuc);

                    } else {

                        sonuc = 4 * kenar;

                        System.out.println("Karenin çevresi: " + sonuc);
                    }
                }

                else if (sekil == 3) {

                    double kisaKenar = pozitifSayiAl(scanner,
                            "Kısa kenarı giriniz: ");

                    double uzunKenar = pozitifSayiAl(scanner,
                            "Uzun kenarı giriniz: ");

                    if (islem == 1) {

                        sonuc = kisaKenar * uzunKenar;

                        System.out.println("Dikdörtgenin alanı: " + sonuc);

                    } else {

                        sonuc = 2 * (kisaKenar + uzunKenar);

                        System.out.println("Dikdörtgenin çevresi: " + sonuc);
                    }
                }


                else {

                    double yaricap = pozitifSayiAl(scanner,
                            "Dairenin yarıçapını giriniz: ");

                    if (islem == 1) {

                        sonuc = Math.PI * yaricap * yaricap;

                        System.out.println("Dairenin alanı: " + sonuc);

                    } else {

                        sonuc = 2 * Math.PI * yaricap;

                        System.out.println("Dairenin çevresi: " + sonuc);
                    }
                }
            }

            scanner.close();
        }

        public static int tamSayiAl(Scanner scanner, String mesaj) {

            while (true) {

                System.out.print(mesaj);

                if (scanner.hasNextInt()) {

                    int sayi = scanner.nextInt();
                    return sayi;

                } else {

                    System.out.println("Hatalı giriş! Lütfen tam sayı giriniz.");
                    scanner.next();
                }
            }
        }


        public static int secimAl(
                Scanner scanner,
                String mesaj,
        int min,
        int max) {

            while (true) {

                int secim = tamSayiAl(scanner, mesaj);

                if (secim >= min && secim <= max) {
                    return secim;
                }

                System.out.println(
                        "Hatalı seçim! " + min + " ile " + max
                                + " arasında bir değer giriniz."
                );
            }
        }


        public static double pozitifSayiAl(
                Scanner scanner,
                String mesaj) {

            while (true) {

                System.out.print(mesaj);

                if (scanner.hasNextDouble()) {

                    double sayi = scanner.nextDouble();

                    if (sayi > 0) {
                        return sayi;
                    }

                    System.out.println(
                            "Hatalı giriş! Sayı 0'dan büyük olmalıdır."
                    );

                } else {

                    System.out.println(
                            "Hatalı giriş! Lütfen sayı giriniz."
                    );

                    scanner.next();
                }
            }
    }
}
