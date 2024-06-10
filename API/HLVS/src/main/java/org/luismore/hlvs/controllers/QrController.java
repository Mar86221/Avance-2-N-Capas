package org.luismore.hlvs.controllers;

import org.luismore.hlvs.domain.dtos.GeneralResponse;
import org.luismore.hlvs.domain.entities.Token;
import org.luismore.hlvs.services.QrService;
import org.luismore.hlvs.handlers.ServoWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/qr")
public class QrController {

    @Autowired
    private QrService qrService;

    @Autowired
    private ServoWebSocketHandler webSocketHandler;

    @GetMapping("/token/{userId}")
    public ResponseEntity<GeneralResponse> getTokenByUserId(@PathVariable Long userId) {
        Token token = qrService.getTokenByUserId(userId);
        return GeneralResponse.getResponse(token, "Token fetched successfully");
    }

    @PostMapping("/generate")
    public ResponseEntity<GeneralResponse> generateToken(@RequestBody Long requestId) {
        Token token = qrService.generateToken(requestId);
        return GeneralResponse.getResponse(token, "Token generated successfully");
    }

    @PostMapping("/expiration")
    public ResponseEntity<GeneralResponse> updateQrDuration(@RequestBody Long newDuration) {
        boolean updated = qrService.updateQrDuration(newDuration);
        if (updated) {
            return GeneralResponse.getResponse("QR duration updated successfully");
        } else {
            return GeneralResponse.getResponse(HttpStatus.BAD_REQUEST, "Failed to update QR duration");
        }
    }

    @PostMapping("/scan-qr")
    public ResponseEntity<GeneralResponse> scanQR(@RequestParam String qrCode) {
        try {
            // Process the QR code if needed
            // For example, if a specific QR code triggers the servo
            if ("your-specific-qr-code".equals(qrCode)) {
                webSocketHandler.sendCommandToAllSessions("move 90");
                Thread.sleep(5000); // Delay for 5 seconds
                webSocketHandler.sendCommandToAllSessions("move 0");
            }
            return GeneralResponse.getResponse("QR Code processed successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return GeneralResponse.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Error processing QR Code");
        }
    }

    @PostMapping("/scan-token")
    public ResponseEntity<GeneralResponse> scanToken(@RequestBody String tokenContent) {
        boolean isScanned = qrService.scanToken(tokenContent);
        if (isScanned) {
            return GeneralResponse.getResponse("Token scanned and deactivated successfully");
        } else {
            return GeneralResponse.getResponse(HttpStatus.BAD_REQUEST, "Failed to scan or deactivate token");
        }
    }
}
