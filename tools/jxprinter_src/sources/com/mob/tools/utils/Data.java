package com.mob.tools.utils;

import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes3.dex */
public class Data implements PublicMemberKeeper {
    public static String AES128Decode(String str, byte[] bArr) {
        return cn.fly.tools.utils.Data.AES128Decode(str, bArr);
    }

    public static byte[] AES128Encode(String str, String str2) {
        return cn.fly.tools.utils.Data.AES128Encode(str, str2);
    }

    public static String AES128PaddingDecode(byte[] bArr, byte[] bArr2) {
        return cn.fly.tools.utils.Data.AES128PaddingDecode(bArr, bArr2);
    }

    public static String Base64AES(String str, String str2) {
        return cn.fly.tools.utils.Data.Base64AES(str, str2);
    }

    public static String CRC32(byte[] bArr) {
        return cn.fly.tools.utils.Data.CRC32(bArr);
    }

    public static byte[] EncodeNoPadding(String str, String str2) {
        return cn.fly.tools.utils.Data.EncodeNoPadding(str, str2);
    }

    public static String MD5(String str) {
        return cn.fly.tools.utils.Data.MD5(str);
    }

    public static byte[] SHA1(String str) {
        return cn.fly.tools.utils.Data.SHA1(str);
    }

    public static String byteToHex(byte[] bArr) {
        return cn.fly.tools.utils.Data.byteToHex(bArr);
    }

    public static String bytesToHexFaster(byte[] bArr) {
        return cn.fly.tools.utils.Data.bytesToHexFaster(bArr);
    }

    public static Cipher getCipher(String str, String str2) {
        return cn.fly.tools.utils.Data.getCipher(str, str2);
    }

    public static byte[] paddingDecode(byte[] bArr, byte[] bArr2) {
        return cn.fly.tools.utils.Data.paddingDecode(bArr, bArr2);
    }

    public static byte[] rawMD5(String str) {
        return cn.fly.tools.utils.Data.rawMD5(str);
    }

    public static String urlEncode(String str) {
        return cn.fly.tools.utils.Data.urlEncode(str);
    }

    public static byte[] AES128Decode(byte[] bArr, byte[] bArr2) {
        return cn.fly.tools.utils.Data.AES128Decode(bArr, bArr2);
    }

    public static byte[] AES128Encode(byte[] bArr, String str) {
        return cn.fly.tools.utils.Data.AES128Encode(bArr, str);
    }

    public static String MD5(byte[] bArr) {
        return cn.fly.tools.utils.Data.MD5(bArr);
    }

    public static byte[] SHA1(byte[] bArr) {
        return cn.fly.tools.utils.Data.SHA1(bArr);
    }

    public static String byteToHex(byte[] bArr, int i5, int i6) {
        return cn.fly.tools.utils.Data.byteToHex(bArr, i5, i6);
    }

    public static byte[] rawMD5(byte[] bArr) {
        return cn.fly.tools.utils.Data.rawMD5(bArr);
    }

    public static String urlEncode(String str, String str2) {
        return cn.fly.tools.utils.Data.urlEncode(str, str2);
    }

    public static void AES128Decode(String str, InputStream inputStream, OutputStream outputStream) {
        cn.fly.tools.utils.Data.AES128Decode(str, inputStream, outputStream);
    }

    public static byte[] AES128Encode(byte[] bArr, byte[] bArr2) {
        return cn.fly.tools.utils.Data.AES128Encode(bArr, bArr2);
    }

    public static String MD5(byte[] bArr, int i5, int i6) {
        return cn.fly.tools.utils.Data.MD5(bArr, i5, i6);
    }

    public static byte[] rawMD5(byte[] bArr, int i5, int i6) {
        return cn.fly.tools.utils.Data.rawMD5(bArr, i5, i6);
    }

    public static void AES128Decode(byte[] bArr, InputStream inputStream, OutputStream outputStream) {
        cn.fly.tools.utils.Data.AES128Decode(bArr, inputStream, outputStream);
    }

    public static String MD5(File file) {
        return cn.fly.tools.utils.Data.MD5(file);
    }

    public static byte[] rawMD5(InputStream inputStream) {
        return cn.fly.tools.utils.Data.rawMD5(inputStream);
    }
}
