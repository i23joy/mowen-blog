package com.blog.mowen.util;

import javax.xml.bind.DatatypeConverter;

public class BlobUtils {
    public static String byteToBase64(byte[] bytes) {
        return DatatypeConverter.printBase64Binary(bytes);
    }

    public static byte[] base64ToByte(String base64) {
        return DatatypeConverter.parseBase64Binary(base64);
    }
}
