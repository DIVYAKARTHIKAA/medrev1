package com.Dynamiccode.medical.service;

import com.Dynamiccode.medical.dto.request.AuthenticationRequest;
import com.Dynamiccode.medical.dto.request.RegisterRequest;
import com.Dynamiccode.medical.dto.response.AuthenticationResponse;

public interface AuthService {
    boolean userRegistration(RegisterRequest request);

    AuthenticationResponse userAuthentication(AuthenticationRequest request);
}
