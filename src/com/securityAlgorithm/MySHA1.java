package com.securityAlgorithm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MySHA1 {
  public static void main(String[] args) {
    try {
      byte[] bytes = "SHA1加密算法".getBytes();
      MessageDigest sha1 = MessageDigest.getInstance("SHA1");
      byte[] digest = sha1.digest(bytes);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }

  }
}
