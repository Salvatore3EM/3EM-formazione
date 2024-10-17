package quiz_project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quiz_project.demo.model.DTO.ScoreDTO;
import quiz_project.demo.model.User;
import quiz_project.demo.service.UserService;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/User")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public void editUserById (@PathVariable Long id, @RequestBody User NewUser) {
        userService.editUserById(id,NewUser);
    }

    @PostMapping
    public User Register(@RequestBody User user) {
        return userService.Register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> Login(@RequestBody User user) {
        if(userService.Login(user) == true)
        {
            return new ResponseEntity<>("Login Successful", HttpStatus.OK);
        } else if (userService.Login(user) == false) {
            return new ResponseEntity<>("Login Failed", HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }


}

