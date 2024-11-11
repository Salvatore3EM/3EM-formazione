package laboratorio.service.quiz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import laboratorio.model.quiz.Pin;
import laboratorio.repository.quiz.PinRepository;
import laboratorio.service.quiz.PinService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PinServiceImpl implements PinService {

    @Autowired
    private PinRepository pinRepository;

    // Creazione di un nuovo PIN
    @Override
    public Pin generatePin() {
        Pin pin = new Pin();
        pin.setId(1L); // Set the ID to 1
        pin.setPin_text(generateRandomPinText(5)); // Generazione di un PIN casuale di 5 caratteri
        pin.setStart(LocalDateTime.now());
        pin.setEnd(LocalDateTime.now().plusHours(1)); // Validità di 1 ora

        return pinRepository.save(pin); // Salva il PIN nel database
    }

    // Visualizzazione del PIN esistente
    @Override
    public Pin getPin() {
        return pinRepository.findById(1L).orElse(null); // Trova e restituisce il PIN per ID
    }

    // Estensione del tempo di validità del PIN
    @Override
    public void extendTimePin() {
        Pin pin = pinRepository.findById(1L).orElse(null);
        if (pin != null) {
            pin.setEnd(pin.getEnd().plusHours(1)); // Estende la validità di 1 ora
            pinRepository.save(pin);
        }
    }

    // Controllo della validità del PIN
    @Override
    public boolean checkPinVal(String pinText) {
        Pin pin = pinRepository.findById(1L).orElse(null); // Assume che stia verificando il PIN con ID 1
        if (pin == null) {
            return false;
        }

        // Verifica se il PIN corrisponde e se è ancora valido
        return pin.getPin_text().equals(pinText) &&
                LocalDateTime.now().isAfter(pin.getStart()) &&
                LocalDateTime.now().isBefore(pin.getEnd());
    }

    // Helper per generare il PIN casuale
    private String generateRandomPinText(int length) {
        List<Character> characters = new ArrayList<>();
        for (char i = '0'; i <= '9'; i++) {
            characters.add(i);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            characters.add(c);
        }

        Collections.shuffle(characters);
        StringBuilder pinText = new StringBuilder();
        for (char ch : characters.subList(0, length)) {
            pinText.append(ch);
        }

        return pinText.toString();
    }
}