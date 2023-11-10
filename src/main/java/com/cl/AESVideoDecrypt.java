package com.cl;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author chenliang
 * @since 2023/9/3 19:04
 */
public class AESVideoDecrypt {

    public static void main(String[] args) {
        String videoFilePath = "C:\\Users\\admin\\Desktop\\response.ts"; // 你的视频文件路径
        String keyFilePath = "C:\\Users\\admin\\Desktop\\enc_4547701.key"; // 包含AES密钥的文件路径
        String outputFilePath = "C:\\Users\\admin\\Desktop\\response-entry.ts"; // 解密后的视频文件输出路径
    }

    public void aesDecrypt(String sourcePath, String desPath, String aesKeyPath, String iv) throws Exception {
        // 从文件中读取密钥
        byte[] keyBytes = Files.readAllBytes(Paths.get(aesKeyPath));
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");

        // 初始化AES解密器
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // 32位iv ff7a9df94a2613c1faeda1253eb34248
        IvParameterSpec ivParameterSpec = new IvParameterSpec(hexStringToByteArray(iv));
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);

        // 打开输入和输出文件流
        FileInputStream encryptedFileStream = new FileInputStream(sourcePath);

        // 解密视频文件
        CipherInputStream cipherInputStream = new CipherInputStream(encryptedFileStream, cipher);
        FileOutputStream decryptedFileStream = new FileOutputStream(desPath);
        byte[] buffer = new byte[8192];
        int bytesRead;
        while ((bytesRead = cipherInputStream.read(buffer)) != -1) {
            decryptedFileStream.write(buffer, 0, bytesRead);
        }

        // 关闭流
        cipherInputStream.close();
        encryptedFileStream.close();
        decryptedFileStream.close();
    }

    // 将十六进制字符串转换为字节数组
    private static byte[] hexStringToByteArray(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }
}
