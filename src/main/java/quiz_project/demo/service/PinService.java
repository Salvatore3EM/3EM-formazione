package quiz_project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz_project.demo.model.Pin;
import quiz_project.demo.repository.PinRepository;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PinService {

    @Autowired
    private PinRepository pinRepository;

    public List<Pin> getAllPins() {
        return pinRepository.findAll();
    }

    public Pin getPinById(Long id) {
        return pinRepository.findById(id).orElse(null);
    }

    public void editPinById(Long id, Pin NewPin) {
        Pin OldPin = pinRepository.findById(id).orElse(null);
        if (OldPin != null) {
            OldPin.setPin_text(NewPin.getPin_text());
            OldPin.setStart(NewPin.getStart());
            OldPin.setEnd(NewPin.getEnd());


        }
    }

    public Pin savePin(Pin pin) {
        return pinRepository.save(pin);
    }

    public List<Pin> savePins(List<Pin> PinList) {
        return pinRepository.saveAll(PinList);
    }

    public void deletePin(Long id) {
        pinRepository.deleteById(id);
    }

    public Pin generatePin() {
        Pin OldPin = pinRepository.findById(1L).orElse(null);
        Pin localPin = new Pin();
        List<Character> pinList = new ArrayList<>();

        for (char i = '0'; i <= '9'; i++) {
            pinList.add(i);
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            pinList.add(c);
        }

        // Shuffle list
        Collections.shuffle(pinList);

        // subList
        StringBuilder sb = new StringBuilder();
        for (char ch: pinList.subList(0,5)) {
            sb.append(ch);
        }
        String Pin_text = sb.toString();
        localPin.setPin_text(Pin_text);
        localPin.setStart(LocalDateTime.from(LocalDateTime.now()));
        localPin.setEnd(LocalDateTime.from(LocalDateTime.now().plusHours(1)));

        return localPin;
    }
}
