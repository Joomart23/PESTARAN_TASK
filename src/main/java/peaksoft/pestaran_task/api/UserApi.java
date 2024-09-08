package peaksoft.pestaran_task.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.pestaran_task.dto.SimpleResponse;
import peaksoft.pestaran_task.dto.user.UserRequest;
import peaksoft.pestaran_task.dto.user.UserResponse;
import peaksoft.pestaran_task.service.UserService;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserApi {
    private final UserService userService;
    @PostMapping("/{id}/get")
    public SimpleResponse createUser(@PathVariable Long id, @RequestBody UserRequest user) {
        return  userService.restaurantAntUser(id,user);
    }
    @PostMapping("/{id}")
    public SimpleResponse UserAndRE15(@PathVariable Long id, @RequestBody UserRequest  restaurant ) {
        return  userService.restaurantAntUser15(id,restaurant);
    }
    @PostMapping
    public SimpleResponse UserSave(@RequestBody UserRequest user) {
        return userService.AdminUserSave1(user);

    }
    @PostMapping("admin")
    public SimpleResponse UserSave1(@RequestBody UserRequest user) {
        return userService.AdminUserSave(user);
    }
    @PutMapping("{id}")
    public SimpleResponse UserUpdate(@PathVariable Long id,@RequestBody UserRequest userRequest) {
        return userService.updateUser(id,userRequest);
    }
    @GetMapping
    public List<UserResponse> getAll (){
        return userService.getAllUser();
    }
}
