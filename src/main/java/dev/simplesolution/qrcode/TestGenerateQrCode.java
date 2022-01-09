package dev.simplesolution.qrcode;

import dev.simplesolution.qrcode.service.QrCodeGeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestGenerateQrCode implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(TestGenerateQrCode.class);

    @Value("${qr.code.directory}")
    private String qrCodeDirectory;

    @Autowired
    private QrCodeGeneratorService qrCodeGeneratorService;

    @Override
    public void run(String... args) throws Exception {
        for(int i = 1; i <= 5; i++) {
            String filePath = qrCodeDirectory + i + ".png";
            String qrCodeContent = "Simple Solution " + i;
            int width = 400;
            int height = 400;
            boolean result = qrCodeGeneratorService.generateQRCode(qrCodeContent, filePath, width, height);
            if(result) {
                logger.info("Generate QR code file " + filePath + " successfully");
            }
        }
    }
}
