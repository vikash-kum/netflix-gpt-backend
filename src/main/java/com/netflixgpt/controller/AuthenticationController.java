package com.netflixgpt.controller;

import com.netflixgpt.exception.CommonException;
import com.netflixgpt.request.AuthenticationRequest;
import com.netflixgpt.request.RegisterRequest;
import com.netflixgpt.response.AuthenticationResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthenticationController {

  private final AuthenticationService service;


  @GetMapping("/test")
  public String test( ) {
    return  "hello";
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody RegisterRequest request ) {

    try {
      return ResponseEntity.ok(service.register(request));
    } catch (CommonException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
  @PostMapping("/token")
  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
    var token = service.authenticate(request);
    return ResponseEntity.ok(token);
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws IOException {
    service.refreshToken(request, response);
  }

}
