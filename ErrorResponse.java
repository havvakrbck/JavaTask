
public class ErrorResponse {
    private String error;
    private String message;

    public ErrorResponse(String error, String message) {
        this.error = error;
        this.message = message;
    }

    // Getter ve Setter metotları
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/{flightId}")
    public ResponseEntity<?> getFlightById(@PathVariable Long flightId) {
        try {
            Flight flight = flightService.getFlightById(flightId);
            return ResponseEntity.ok(flight);
        } catch (FlightNotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse("Uçuş Bulunamadı", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(errorResponse);
        }
    }

    // Diğer REST hizmetlerini burada tanımlayabilirsiniz
}
public class FlightNotFoundException extends RuntimeException {
    public FlightNotFoundException(Long flightId) {
        super("Uçuş Kimliği Bulunamadı: " + flightId);
    }
}
public class ErrorResponse {
    // Diğer sınıf üyeleri
    
    public void body() {
        // Yöntemin gövdesi burada tanımlanır.
    }
}
