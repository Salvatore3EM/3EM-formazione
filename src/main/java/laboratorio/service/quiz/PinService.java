package laboratorio.service.quiz;

import laboratorio.model.quiz.Pin;

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
