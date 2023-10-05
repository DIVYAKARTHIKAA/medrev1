package com.Dynamiccode.medical.service;

import java.util.List;

import com.Dynamiccode.medical.dto.request.UserRequest;
import com.Dynamiccode.medical.dto.response.UserResponse;

public interface UserService {

    List<UserResponse> getAllUsers();

    UserResponse getUser(Long uid);

    UserResponse updateUser(UserRequest request, Long uid);

    boolean deleteDoctor(Long uid);

	

}
