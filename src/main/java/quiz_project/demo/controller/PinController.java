package quiz_project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quiz_project.demo.model.Pin;
import quiz_project.demo.service.PinService;

import java.util.List;

@RestController
@RequestMapping("/api/Pin")
public class PinController {

    @Autowired
    private PinService pinService;

    @GetMapping
    public List<Pin> getAllPin() { return pinService.getAllPins(); }

    @PutMapping("/{id}")
    public void editPinById (@PathVariable Long Id, @RequestBody Pin NewPin) {
        pinService.editPinById(Id,NewPin);
    }

    @PostMapping
    public Pin createPin(@RequestBody Pin pin) {
        return pinService.savePin(pin);
    }

    @PostMapping("/All")
    public List<Pin> createPins(@RequestBody List<Pin> PinList) { return pinService.savePins(PinList); }

    @GetMapping("/generate")
    public Pin generatePin() { return pinService.generatePin(); }

    @DeleteMapping("/{id}")
    public void deletePin(@PathVariable Long id) {
        pinService.deletePin(id);
    }
}
