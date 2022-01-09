package dev.simplesolution.qrcode.service;

public interface QrCodeGeneratorService {
    boolean generateQRCode(String qrCodeContent, String filePath, int width, int height);
}