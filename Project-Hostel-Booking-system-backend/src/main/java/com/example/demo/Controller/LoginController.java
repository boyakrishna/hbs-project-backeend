
package com.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.OtpApplicationService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://hbs-frontend-2ujh.onrender.com")
public class LoginController {

    @Autowired
    private OtpApplicationService otpService;


   
    @PostMapping("/send-otp")
    public String sendOtp(@RequestParam String email){

        boolean sent = otpService.sendOtp(email);

        if(sent){
            return "OTP sent to email";
        } else {
            return "Failed to send OTP";
        }
    }

    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestParam String email,
                            @RequestParam String otp){

        boolean result = otpService.verifyOtp(email, otp);

        if(result){
            return "OTP Verified";
        }

        return "Invalid OTP";
    }
}