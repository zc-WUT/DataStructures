package com.securityAlgorithm;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class MyHMAC {
  private Mac mac;
  /**
   * MAC算法可选以下多种算法
   * HmacMD5/HmacSHA1/HmacSHA256/HmacSHA384/HmacSHA512
   */
  private static final String KEY_MAC = "HmacMD5";
  public MyHMAC(String key) {
    try {
      SecretKey secretKey = new SecretKeySpec(key.getBytes(), KEY_MAC);
      mac = Mac.getInstance(secretKey.getAlgorithm());
      mac.init(secretKey);
    } catch (Exception e) {
    }
  }
  public byte[] sign(byte[] content) {
    return mac.doFinal(content);
  }

  public boolean verify(byte[] signature, byte[] content) {
    try {
      byte[] result = mac.doFinal(content);
      return Arrays.equals(signature, result);
    } catch (Exception e) {
    }
    return false;
  }
}
