package com.bluescope.qrcodegenerator.controller;

import com.bluescope.qrcodegenerator.service.QrcodeService;
import com.google.zxing.WriterException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/qr")
public class QrcodeController {

    private final QrcodeService qrcodeService;

    public QrcodeController(QrcodeService qrcodeService) {
        this.qrcodeService = qrcodeService;
    }

    @GetMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateQRCode()
            throws IOException, WriterException {

        String url = "https://bluescopetech.com/";

        byte[] qrImage = qrcodeService.generateQRCode(url, 300, 300);

        return ResponseEntity.ok(qrImage);
    }
}
