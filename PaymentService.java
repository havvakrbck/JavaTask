
import java.util.Scanner;

public class FlightBookingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentService paymentService = new PaymentService();

        // Koltuk seçimi ve diğer işlemler burada gerçekleştirilir.

        // Ödeme işlemi
        System.out.println("Ödeme yapılacak tutarı girin: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Boş satırı tüket

        System.out.println("Kredi Kartı Numarasını Girin: ");
        String creditCardNumber = scanner.nextLine();

        boolean paymentResult = paymentService.processPayment(amount, creditCardNumber);
        if (paymentResult) {
            System.out.println("Ödeme başarılı! Koltuklarınızı ayırdık.");
            // Koltuk rezervasyonu işlemi burada gerçekleştirilebilir.
        } else {
            System.out.println("Ödeme başarısız. Lütfen tekrar deneyin.");
        }
    }
}

public class PaymentService {
    public boolean processPayment(double amount, String creditCardNumber){  // Burada gerçek bir ödeme işlemi yapılabilir.
        System.out.println("Ödeme işlemi tamamlandı: " + amount + " TL, Kredi Kartı: " + creditCardNumber);
        return true; // Ödeme başarılı ise true dönebilir.
    }
}
