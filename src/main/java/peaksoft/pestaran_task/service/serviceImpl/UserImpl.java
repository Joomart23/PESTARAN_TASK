package peaksoft.pestaran_task.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.pestaran_task.dto.SimpleResponse;
import peaksoft.pestaran_task.dto.user.UserRequest;
import peaksoft.pestaran_task.dto.user.UserResponse;
import peaksoft.pestaran_task.emum.Role;
import peaksoft.pestaran_task.entiti.Restaurant;
import peaksoft.pestaran_task.entiti.User;
import peaksoft.pestaran_task.repository.RestaurantRepository;
import peaksoft.pestaran_task.repository.UserRepository;
import peaksoft.pestaran_task.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserImpl implements UserService {
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final int max = 4;

    @Override
    public SimpleResponse restaurantAntUser(Long restaurantId, UserRequest userRequest) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(()
                -> new NoSuchElementException("Restaurant not found with ID: " + restaurantId));
        User user = new User();
        user.setId(userRequest.getId());
        user.setEmail(userRequest.getEmail());
        user.setLastName(userRequest.getLastName());
        user.setFirstName(userRequest.getFirstName());
        user.setPassword(userRequest.getPassword());
        restaurant.getUser().add(user);
        user.setRestaurant(restaurant);
        userRepository.save(user);
        return new SimpleResponse(
                HttpStatus.OK,
                "SAKTALDY"
        );
    }

    @Override
    public SimpleResponse restaurantAntUser15(Long restaurantId, UserRequest userRequest) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NoSuchElementException("Ресторан табылган жок, ID: " + restaurantId));
        final int MAX_USERS = 15;
        if (restaurant.getUser().size() >= MAX_USERS) {
            return new SimpleResponse(
                    HttpStatus.BAD_REQUEST,
                    "Ресторан үчүн колдонуучулар саны чектен ашып кеткен."
            );
        }
        User[] users = new User[max];
        for (int i = 0; i < max; i++) {
            if (users[i] == null) {
                users[i] = new User();
                users[i].setId(restaurantId);
                users[i].setEmail(userRequest.getEmail());
                users[i].setLastName(userRequest.getLastName());
                users[i].setFirstName(userRequest.getFirstName());
                users[i].setPassword(userRequest.getPassword());
                if (restaurant.getUser().size() >= MAX_USERS) {
                    return new SimpleResponse(
                            HttpStatus.BAD_REQUEST,
                            "Бул колдонуучуну кошо турганда колдонуучулар саны чектен ашып кетти."
                    );
                }
                restaurant.getUser().add(users[i]);
                users[i].setRestaurant(restaurant);
                userRepository.save(users[i]);
            } else {
                return new SimpleResponse(
                        HttpStatus.BAD_REQUEST,
                        "Массивдин индекси бош болбой жатат."
                );
            }
        }
        return new SimpleResponse(
                HttpStatus.OK,
                "Колдонуучулар ийгиликтүү кошулду."
        );

    }

    @Override
    public SimpleResponse AdminUserSave(UserRequest userRequest) {
        User user = new User();
        user.setId(userRequest.getId());
        user.setEmail(userRequest.getEmail());
        user.setLastName(userRequest.getLastName());
        user.setFirstName(userRequest.getFirstName());
        user.setPassword(userRequest.getPassword());
        user.setRole(Role.Admin);
        userRepository.save(user);
        return   new  SimpleResponse(
                HttpStatus.OK,
                "сакталды"
        );
    }

    @Override
    public SimpleResponse AdminUserSave1(UserRequest userRequest) {
            User user = new User();
            if (userRequest.getEmail().contains("@gmail.com")) {
                user.setEmail(userRequest.getEmail());
            } else {
                return new SimpleResponse(
                        HttpStatus.BAD_REQUEST,
                        "@gmail.com менен аяктаган email киргизилген жок"
                );
            }
            if (userRequest.getPassword().length() > 4) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                String hashedPassword = encoder.encode(userRequest.getPassword());
                user.setPassword(hashedPassword);
            } else {
                return new SimpleResponse(
                        HttpStatus.BAD_REQUEST,
                        "Пароль 4 символдон аз"
                );
            }
            if (userRequest.getPhoneNumber().contains("996")) {
                user.setPhoneNumber(userRequest.getPhoneNumber());
            } else {
                return new SimpleResponse(
                        HttpStatus.BAD_REQUEST,
                        "Телефон номер '996' менен башталбайт"
                );
            }
            user.setId(userRequest.getId());
            user.setLastName(userRequest.getLastName());
            user.setFirstName(userRequest.getFirstName());
            userRepository.save(user);
            return new SimpleResponse(
                    HttpStatus.OK,
                    "Колдонуучу ийгиликтүү сакталды"
            );
        }

    @Override
    public SimpleResponse updateUser(Long id,UserRequest userRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("user табылган жок, ID: " + id));
        user.setEmail(userRequest.getEmail());
        user.setLastName(userRequest.getLastName());
        user.setFirstName(userRequest.getFirstName());
        user.setPassword(userRequest.getPassword());
        user.setRole(Role.Admin);
        userRepository.save(user);

        return new SimpleResponse(
                HttpStatus.OK,
                "ОЗГОРДУ"
        );
    }

    @Override
    public List<UserResponse> getAllUser() {
        List<User> users = (List<User>) userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            userResponses.add(UserResponse.builder()
                            .email(user.getEmail())
                            .expirense(user.getExpirense())
                            .firstName(user.getFirstName())
                            .lastName(user.getLastName())
                    .build());
        }
        return userResponses;
    }

}

