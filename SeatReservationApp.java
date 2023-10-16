import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SeatReservationApp {
    private static Map<Integer, Boolean> seatAvailability = new HashMap<>();

    public static void main(String[] args) {
        initializeSeats();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Boş satırı tüket

            switch (choice) {
                case 1:
                    displayAvailableSeats();
                    break;
                case 2:
                    reserveSeat(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                    break;
            }
        }
    }

    private static void initializeSeats() {
        for (int i = 1; i <= 10; i++) {
            seatAvailability.put(i, true); // Tüm koltukları başlangıçta boş olarak işaretle
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- Koltuk Rezervasyon Uygulaması ---");
        System.out.println("1. Koltuk Durumunu Göster");
        System.out.println("2. Koltuk Rezervasyonu Yap");
        System.out.println("3. Çıkış");
        System.out.println("Lütfen bir seçenek girin: ");
    }

    private static void displayAvailableSeats() {
        System.out.println("\n--- Boş Koltuklar ---");
        for (Map.Entry<Integer, Boolean> entry : seatAvailability.entrySet()) {
            if (entry.getValue()) {
                System.out.println("Koltuk " + entry.getKey());
            }
        }
    }

    private static void reserveSeat(Scanner scanner) {
        System.out.println("\nRezerve etmek istediğiniz koltuğun numarasını girin: ");
        int seatNumber = scanner.nextInt();
        scanner.nextLine(); // Boş satırı tüket

        if (seatAvailability.containsKey(seatNumber) && seatAvailability.get(seatNumber)) {
            seatAvailability.put(seatNumber, false);
            System.out.println("Koltuk " + seatNumber + " başarıyla rezerve edildi.");
        } else {
            System.out.println("Bu koltuk zaten rezerve edilmiş veya geçerli değil.");
        }
    }
}
