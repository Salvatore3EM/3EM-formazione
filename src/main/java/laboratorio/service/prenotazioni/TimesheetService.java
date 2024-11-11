package laboratorio.service.prenotazioni;

import laboratorio.model.prenotazioni.UserTimesheet;

public interface TimesheetService {
    public UserTimesheet getUserById(Long userId);
}
