import java.util.ArrayList;
import java.util.List;



public class Flight {
    private String departure; // Uçuşun kalkış noktası
    private String destination; // Uçuşun varış noktası
    private String date; // Uçuş tarihi
    private String time; // Uçuş saati
    private int totalSeats; // Toplam koltuk sayısı
    private int availableSeats; // Uçuşta boş koltuk sayısı
    private List<Reservation> reservations; // Rezervasyonların listesi

    // Constructor 
    public Flight(String departure, String destination, String date, String time, int totalSeats) {
        this.departure = departure;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.reservations = new ArrayList<>();
    }

    // Getter ve Setter metotları
    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    // Koltukların müsaitlik durumunu kontrol eder
    public boolean isSeatAvailable(int seatNumber) {
        for (Reservation reservation : reservations) {
            if (reservation.getSeatNumber() == seatNumber) {
                return false; // Koltuk dolu
            }
        }
        return true; // Koltuk boş
    }

    public void addReservation(Reservation reservation) {
    }  
}
