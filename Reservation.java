// public class Reservation {
//     private String passengerName; // Yolcu adı
//     private int reservationNumber; // Rezervasyon numarası
//     private int seatNumber; // Koltuk numarası
//     private Flight flight; // Bağlı olduğu uçuş

//     // Constructor - Tüm alanları başlatan bir constructor
//     public Reservation(String passengerName, int reservationNumber, int seatNumber, Flight flight) {
//         this.passengerName = passengerName;
//         this.reservationNumber = reservationNumber;
//         this.seatNumber = seatNumber;
//         this.flight = flight;
//     }

//     // Getter ve Setter metotları
//     public String getPassengerName() {
//         return passengerName;
//     }

//     public void setPassengerName(String passengerName) {
//         this.passengerName = passengerName;
//     }

//     public int getReservationNumber() {
//         return reservationNumber;
//     }

//     public void setReservationNumber(int reservationNumber) {
//         this.reservationNumber = reservationNumber;
//     }

//     public int getSeatNumber() {
//         return seatNumber;
//     }

//     public void setSeatNumber(int seatNumber) {
//         this.seatNumber = seatNumber;
//     }

//     public Flight getFlight() {
//         return flight;
//     }

//     public void setFlight(Flight flight) {
//         this.flight = flight;
//     }
// }


// public void reserveSeat(String passengerName, int seatNumber) {
//     if (seatNumber > 0 && seatNumber <= flight.getTotalSeats() && ((Flight) flight).isSeatAvailable(seatNumber)) {
//         // Koltuk rezervasyon işlemleri
//         Reservation reservation = new Reservation(passengerName, getReservationNumber(), seatNumber, flight);
//         ((Flight) flight).addReservation(reservation);
//     } else {
//         System.out.println("Üzgünüz, bu koltuk müsait değil veya geçersiz.");
//     }
// }


// // Yeni rezervasyon ekler
// public void addReservation(Reservation reservation) {
//     int availableSeats;
//     if (availableSeats > 0 && isSeatAvailable(reservation.getSeatNumber())) {
//         Object reservations;
//         ((Object) reservations).add(reservation);
//         availableSeats--;
//         System.out.println("Rezervasyon başarıyla eklendi. Kalan boş koltuk sayısı: " + availableSeats);
//     } else {
//         System.out.println("Üzgünüz, rezervasyon eklenemiyor. Koltuk dolu veya geçersiz koltuk numarası.");
//     }
// }
// ß
// private boolean isSeatAvailable(int seatNumber2) {
//     return false;
// }



public class Reservation {
    private String passengerName; // Yolcu adı
    private int reservationNumber; // Rezervasyon numarası
    private Flight flight; // Bağlı olduğu uçuş

    // Constructor - Tüm alanları başlatan bir constructor
    public Reservation(String passengerName, int reservationNumber, int seatNumber, Flight flight) {
        this.passengerName = passengerName;
        this.reservationNumber = reservationNumber;
        this.flight = flight;
    }

    // Getter ve Setter metotları
    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    // Rezervasyon numarası oluşturan statik bir sayaç
    private static int reservationCounter = 1;

    // Rezervasyon numarasını otomatik olarak arttırır
    private int generateReservationNumber() {
        return reservationCounter++;
    }

    // Koltuk rezervasyon işlemi
    public void reserveSeat(String passengerName, int seatNumber) {
        if (seatNumber > 0 && seatNumber <= flight.getTotalSeats() && flight.isSeatAvailable(seatNumber)) {
            // Rezervasyon numarasını otomatik olarak oluştur
            int reservationNumber = generateReservationNumber();
            Reservation reservation = new Reservation(passengerName, reservationNumber, seatNumber, flight);
            flight.addReservation(reservation);
            System.out.println("Rezervasyon başarıyla eklendi. Rezervasyon Numarası: " + reservationNumber);
        } else {
            System.out.println("Üzgünüz, bu koltuk müsait değil veya geçersiz.");
        }
    }

    public int getSeatNumber() {
        return 0;
    }
}
