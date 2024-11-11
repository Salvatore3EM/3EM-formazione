package laboratorio.controller.quiz;

import laboratorio.model.prenotazioni.UserTimesheet;
import laboratorio.repository.quiz.UserRepository;
import laboratorio.service.prenotazioni.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import laboratorio.model.quiz.DTO.Pin.AuthenticationRequestDTO;
import laboratorio.model.quiz.DTO.Pin.AuthenticationResponseDTO;
import laboratorio.model.quiz.User;
import laboratorio.service.quiz.PinService;
import laboratorio.utils.JWTUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private PinService pinService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TimesheetService timesheetService;

    // Autenticazione guest (PIN)
    @PostMapping("/guest")
    public ResponseEntity<AuthenticationResponseDTO> authenticateGuest(@RequestParam String pinText) {
        if (pinService.checkPinVal(pinText)) {
            String jwt = jwtUtil.generateToken("guest", "ROLE_GUEST");
            return ResponseEntity.ok(new AuthenticationResponseDTO(jwt));
        } else {
            return ResponseEntity.status(401).body(new AuthenticationResponseDTO("Invalid PIN"));
        }
    }

    // Autenticazione admin (username e password)
    @PostMapping("/admin")
    public ResponseEntity<AuthenticationResponseDTO> authenticateAdmin(@RequestBody AuthenticationRequestDTO request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwt = jwtUtil.generateToken(userDetails.getUsername(), userDetails.getAuthorities().iterator().next().getAuthority());
        return ResponseEntity.ok(new AuthenticationResponseDTO(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        // Codifica la password dell'utente
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Salva l'utente
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/protected")
    public ResponseEntity<String> protectedEndpoint() {
        return ResponseEntity.ok("Accesso riuscito con JWT!");
    }


    @GetMapping("/test")
    public UserTimesheet test(@RequestParam String id) {
        return timesheetService.getUserById( Long.parseLong(id));
    }
}
