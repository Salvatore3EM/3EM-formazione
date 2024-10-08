package quiz_project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz_project.demo.model.Pin;
import quiz_project.demo.repository.PinRepository;


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
}
