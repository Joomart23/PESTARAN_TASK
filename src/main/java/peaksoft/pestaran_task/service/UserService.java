package peaksoft.pestaran_task.service;

import peaksoft.pestaran_task.dto.SimpleResponse;
import peaksoft.pestaran_task.dto.user.UserRequest;
import peaksoft.pestaran_task.dto.user.UserResponse;

import java.util.List;

public interface UserService {
    SimpleResponse restaurantAntUser(Long restaurantId, UserRequest userRequest);
    SimpleResponse restaurantAntUser15( Long id,UserRequest userRequest);
    SimpleResponse AdminUserSave(UserRequest userRequest);
    SimpleResponse AdminUserSave1( UserRequest userRequest);
    SimpleResponse updateUser(Long id,UserRequest userRequest);
   List< UserResponse> getAllUser();



}
