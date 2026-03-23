package com.example.demo.Service;



import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;







@Service
public class OtpApplicationService {

    @Autowired
    private JavaMailSender mailSender;

    Map<String,String> otpStore = new HashMap<>();

    public boolean sendOtp(String email){

        String otp = String.valueOf(1000 + new Random().nextInt(9000));
        otpStore.put(email, otp);

        try {
            System.out.println("Sending OTP to: " + email);

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(email);
            helper.setSubject("Hostel Booking System - Login OTP");
            helper.setText("<h2>Your OTP is: " + otp + "</h2>", true);

            mailSender.send(message);

            System.out.println("✅ OTP SENT SUCCESSFULLY");
            return true;

        } catch (Exception e) {
            System.out.println("❌ EMAIL FAILED");
            e.printStackTrace();
            return false;
        }
    }
    public boolean verifyOtp(String email,String otp){

        String storedOtp = otpStore.get(email);

        if(storedOtp != null && storedOtp.equals(otp)){
            otpStore.remove(email);
            return true;
        }

        return false;
    }
}