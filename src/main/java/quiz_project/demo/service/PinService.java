package quiz_project.demo.service;

import quiz_project.demo.model.Pin;

public interface PinService {

    // Creazione di un nuovo PIN
    Pin generatePin();

    // Visualizzazione del PIN esistente
    Pin getPin();

    // Estensione del tempo di validità del PIN
    void extendTimePin();

    // Controllo della validità del PIN
    boolean checkPinVal(String pinText);
}
