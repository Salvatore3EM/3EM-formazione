package quiz_project.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import quiz_project.demo.model.User;

import java.util.List;

public interface UserService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
