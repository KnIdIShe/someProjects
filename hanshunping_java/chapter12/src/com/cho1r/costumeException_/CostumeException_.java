package com.cho1r.costumeException_;

/**
 * Author cho1r
 * 2021-11-26 026 05:42 下午
 */
public class CostumeException_ {
    public static void main(String[] args) {
        throw new AgeException("bad age.");
    }
}

class AgeException extends RuntimeException{
    public AgeException(String message) {
        super(message);
    }
}