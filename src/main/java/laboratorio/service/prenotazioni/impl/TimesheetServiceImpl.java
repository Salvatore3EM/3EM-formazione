package laboratorio.service.prenotazioni.impl;

import laboratorio.model.prenotazioni.UserTimesheet;
import laboratorio.service.prenotazioni.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TimesheetServiceImpl implements TimesheetService {

    @Autowired
    private final JdbcTemplate timesheetJdbcTemplate;

    @Autowired
    public TimesheetServiceImpl(@Qualifier("timesheetJdbcTemplate") JdbcTemplate timesheetJdbcTemplate) {
        this.timesheetJdbcTemplate = timesheetJdbcTemplate;
    }

    public UserTimesheet getUserById(Long userId) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return timesheetJdbcTemplate.queryForObject(sql, new Object[]{userId}, (rs, rowNum) ->
                new UserTimesheet(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("role")
                )
        );
    }
}
