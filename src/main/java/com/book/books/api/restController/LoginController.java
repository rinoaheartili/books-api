package com.book.books.api.restController;

import com.book.books.api.request.UserRequest;
import com.book.books.api.security.JwtUtil;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alberto
 */
@RestController
@RequestMapping("/auth")
public class LoginController 
{
    @Autowired
    private JwtUtil jwtUtil;

    // Aquí deberías usar un UserService que consulte de la base de datos
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest request) 
    {
        if("usuario".equals(request.getUsername()) && "1234".equals(request.getPassword())) 
        {
            String token = jwtUtil.generateToken(request.getUsername());
            String refreshToken = jwtUtil.generateRefreshToken(request.getPassword());
            
            Map<String, String> tokenResponse = new HashMap<String, String>();
            tokenResponse.put("access_token", token);
            tokenResponse.put("refresh_token", refreshToken);
            
            return ResponseEntity.ok(tokenResponse);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody Map<String, String> request) 
    {
        String refreshToken = request.get("refresh_token");

        if (jwtUtil.isValid(refreshToken)) 
        {
            String username = jwtUtil.extractUsername(refreshToken);
            String newToken = jwtUtil.generateToken(username);
            
            Map<String, String> userToken = new HashMap<String, String>();
            userToken.put(username, newToken);
            
            return ResponseEntity.ok(userToken);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
