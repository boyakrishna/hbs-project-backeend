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

    public void sendOtp(String email){

        String otp = String.valueOf(1000 + new Random().nextInt(9000));

        otpStore.put(email, otp);
        try {

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(email);
            helper.setSubject("Hostel Booking System - Login OTP");

            String htmlContent =
                    "<div style='font-family:Arial;padding:20px'>" +
                    "<h2 style='color:#0ccf61'>Hostel Booking System</h2>" +
                    "<p>Your login OTP is:</p>" +

                    "<div style='font-size:28px;font-weight:bold;" +
                    "background:#f2f2f2;padding:15px;width:150px;" +
                    "text-align:center;border-radius:8px'>" +
                    otp +
                    "</div>" +

                    "<p>This OTP will expire in 5 minutes.</p>" +
                    "<p>If you did not request this, please ignore this email.</p>" +

                    "<hr>" +
                    "<small>Hostel Booking System Team</small>" +
                    "</div>";

            helper.setText(htmlContent, true);

            mailSender.send(message);

        } catch (Exception e) {
            e.printStackTrace();
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