package com.dltao.bxd.utill;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by ui on 2016/4/14.
 */
public class MyDesUtil {

    public static void main(String[] args) throws Exception {

        String plaintext = "mWvEA8CT3FPItgkFLnw9bQ==";
        String cliperText1="mWvEA8CT3FPItgkFLnw9bQ==";
        String cliperText2="Cmzh5Yu8TfM=";
        String key="12345678";
//        String ciphertext = MyDesUtil.encryptDES(plaintext, key);
//        System.out.println("明文：" + plaintext);
//        System.out.println("密钥：" + key);
//        System.out.println("密文：" + ciphertext);
//        System.out.println("解密后：" + MyDesUtil.decryptDES(ciphertext, key));
//        System.out.println("解密后1：" + MyDesUtil.decryptDES(cliperText1, key));
//        System.out.println("解密后2：" + MyDesUtil.decryptDES(cliperText2, key));
        String strEncryData="15271944681";
        System.out.println(MyDesUtil.encryptDES(strEncryData,key));
    }

    private static byte[] iv = { 1, 2, 3, 4, 5, 6, 7, 8 };

    public static String encryptDES(String encryptString, String encryptKey)
            throws Exception {
        IvParameterSpec zeroIv = new IvParameterSpec(iv);
        SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
        byte[] encryptedData = cipher.doFinal(encryptString.getBytes());
        return MyBase64.encode(encryptedData);
    }

    public static String decryptDES(String decryptString, String decryptKey)
            throws Exception {
        byte[] byteMi = MyBase64.decode(decryptString);
        IvParameterSpec zeroIv = new IvParameterSpec(iv);
        SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
        byte decryptedData[] = cipher.doFinal(byteMi);

        return new String(decryptedData);
    }
}
