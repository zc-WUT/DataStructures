package com.securityAlgorithm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.locks.ReentrantLock;

public class MyMd5 {
  public static void main(String[] args) {
    try {
      byte[] bytes = "md5加密算法".getBytes();
      MessageDigest md5 = MessageDigest.getInstance("MD5");
      byte[] digest = md5.digest(bytes);
      ReentrantLock lock=new ReentrantLock();
      lock.lock();

    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }

  }
}
