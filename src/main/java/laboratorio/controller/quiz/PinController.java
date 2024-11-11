package laboratorio.controller.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import laboratorio.model.quiz.Pin;
import laboratorio.service.quiz.PinService;
import laboratorio.utils.JWTUtil;

@RestController
@RequestMapping("/api/pin")
public class PinController {
    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PinService pinService;

    // Endpoint per la creazione di un nuovo PIN
    @PostMapping("/generate")
    public ResponseEntity<Pin> generatePin() {
        Pin pin = pinService.generatePin();
        return ResponseEntity.ok(pin);
    }

    // Endpoint per visualizzare un PIN esistente
    @GetMapping()
    public ResponseEntity<Pin> getPin() {
        Pin pin = pinService.getPin();
        if (pin != null) {
            return ResponseEntity.ok(pin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint per estendere la validità di un PIN
    @PutMapping("/extend")
    public ResponseEntity<Void> extendPinValidity() {
        pinService.extendTimePin();
        return ResponseEntity.ok().build();
    }

    // Endpoint per verificare se un PIN è valido
//    @PostMapping("/check")
//    public ResponseEntity<AuthenticationResponseDTO> checkPinValidity(@RequestParam String pinText) {
//        boolean isValid = pinService.checkPinVal(pinText);
//        if (isValid) {
//            String jwt = jwtUtil.generateToken("guest", "ROLE_GUEST");
//            return ResponseEntity.ok(new AuthenticationResponseDTO(jwt));
//        } else {
//            return ResponseEntity.status(401).body(new AuthenticationResponseDTO("Invalid PIN"));
//        }
//    }
}
