package cn.fly.tools.utils;

import android.text.TextUtils;
import android.util.Base64;
import cn.fly.commons.C0396r;
import cn.fly.commons.a.l;
import cn.fly.tools.FlyLog;
import cn.fly.tools.proguard.PublicMemberKeeper;
import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.zip.CRC32;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class Data implements PublicMemberKeeper {
    public static String AES128Decode(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return null;
        }
        return new String(AES128Decode(str.getBytes("UTF-8"), bArr), "UTF-8").trim();
    }

    public static byte[] AES128Encode(String str, String str2) throws UnsupportedEncodingException {
        if (str == null || str2 == null) {
            return null;
        }
        byte[] bytes = str.getBytes("UTF-8");
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, 16));
        return AES128Encode(bArr, str2);
    }

    public static String AES128PaddingDecode(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return AES128PaddingDecode(str, Base64.decode(str2, 0));
    }

    public static String Base64AES(String str, String str2) {
        String strEncodeToString = null;
        try {
            strEncodeToString = Base64.encodeToString(AES128Encode(str2, str), 0);
            return strEncodeToString.contains("\n") ? strEncodeToString.replace("\n", "") : strEncodeToString;
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return strEncodeToString;
        }
    }

    public static String CRC32(byte[] bArr) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        long value = crc32.getValue();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 56)) & UnsignedBytes.MAX_VALUE)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 48)) & UnsignedBytes.MAX_VALUE)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 40)) & UnsignedBytes.MAX_VALUE)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 32)) & UnsignedBytes.MAX_VALUE)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 24)) & UnsignedBytes.MAX_VALUE)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 16)) & UnsignedBytes.MAX_VALUE)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 8)) & UnsignedBytes.MAX_VALUE)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) value) & UnsignedBytes.MAX_VALUE)));
        while (sb.charAt(0) == '0') {
            sb = sb.deleteCharAt(0);
        }
        return sb.toString().toLowerCase();
    }

    public static byte[] EncodeNoPadding(String str, String str2) throws InvalidKeyException, UnsupportedEncodingException {
        if (str == null || str2 == null) {
            return null;
        }
        byte[] bytes = str.getBytes("UTF-8");
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, 16));
        int length = 16 - (str2.length() % 16);
        StringBuilder sb = new StringBuilder(str2);
        for (int i5 = 0; i5 < length; i5++) {
            sb.append(" ");
        }
        byte[] bytes2 = sb.toString().getBytes("UTF-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, l.a("003+gehjfm"));
        Cipher cipher = getCipher(l.a("003'gehjfm") + l.a("003m1hjfe") + l.a("005CgkTmMfhelhm") + l.a("006eJededejIf;fk"), l.a("002%gkfe"));
        cipher.init(1, secretKeySpec);
        return cipher.doFinal(bytes2);
    }

    public static String MD5(String str) {
        byte[] bArrRawMD5;
        if (str == null || (bArrRawMD5 = rawMD5(str)) == null) {
            return null;
        }
        return bytesToHexFaster(bArrRawMD5);
    }

    public static byte[] SHA1(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return SHA1(str.getBytes("utf-8"));
    }

    public static String byteToHex(byte[] bArr) {
        return byteToHex(bArr, 0, bArr.length);
    }

    public static String bytesToHexFaster(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        int i5 = 0;
        for (byte b : bArr) {
            cArr2[i5] = cArr[(b >>> 4) & 15];
            cArr2[i5 + 1] = cArr[b & 15];
            i5 += 2;
        }
        return new String(cArr2);
    }

    public static Cipher getCipher(String str, String str2) {
        Cipher cipher = null;
        if (!TextUtils.isEmpty(str2)) {
            try {
                Provider provider = Security.getProvider(str2);
                if (provider != null) {
                    cipher = Cipher.getInstance(str, provider);
                }
            } catch (Throwable unused) {
            }
        }
        return cipher == null ? Cipher.getInstance(str, str2) : cipher;
    }

    public static byte[] paddingDecode(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, l.a("003,gehjfm"));
        Cipher cipher = getCipher(l.a("003'gehjfm") + l.a("003mIhjfe") + l.a("008OgkMmPhmjdfefmjlhm") + l.a("006e'ededej]fEfk"), l.a("002Rgkfe"));
        cipher.init(2, secretKeySpec);
        return cipher.doFinal(bArr2);
    }

    public static byte[] rawMD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            return rawMD5(str.getBytes("utf-8"));
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return null;
        }
    }

    public static String urlEncode(String str) {
        try {
            return urlEncode(str, "utf-8");
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return null;
        }
    }

    public static String byteToHex(byte[] bArr, int i5, int i6) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bArr == null) {
            return stringBuffer.toString();
        }
        while (i5 < i6) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i5])));
            i5++;
        }
        return stringBuffer.toString();
    }

    public static String AES128PaddingDecode(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return null;
        }
        return AES128PaddingDecode(rawMD5(str), bArr);
    }

    public static String MD5(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return MD5(bArr, 0, bArr.length);
    }

    public static byte[] rawMD5(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return rawMD5(bArr, 0, bArr.length);
    }

    public static String urlEncode(String str, String str2) {
        String strEncode = TextUtils.isEmpty(str) ? "" : URLEncoder.encode(str, str2);
        return TextUtils.isEmpty(strEncode) ? strEncode : strEncode.replace("+", "%20");
    }

    public static byte[] AES128Decode(byte[] bArr, byte[] bArr2) {
        return AES128Decode(bArr, bArr2, true);
    }

    public static String MD5(byte[] bArr, int i5, int i6) {
        byte[] bArrRawMD5;
        if (bArr == null || (bArrRawMD5 = rawMD5(bArr, i5, i6)) == null) {
            return null;
        }
        return bytesToHexFaster(bArrRawMD5);
    }

    public static byte[] SHA1(byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(l.a("005Jfmglgeilig"));
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    public static byte[] rawMD5(byte[] bArr, int i5, int i6) {
        ByteArrayInputStream byteArrayInputStream;
        if (bArr == null) {
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr, i5, i6);
            try {
                byte[] bArrRawMD5 = rawMD5(byteArrayInputStream);
                C0396r.a(byteArrayInputStream);
                return bArrRawMD5;
            } catch (Throwable th) {
                th = th;
                try {
                    FlyLog.getInstance().w(th);
                    C0396r.a(byteArrayInputStream);
                    return null;
                } catch (Throwable th2) {
                    C0396r.a(byteArrayInputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
        }
    }

    public static byte[] AES128Decode(byte[] bArr, byte[] bArr2, boolean z6) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, ShortBufferException {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        if (z6) {
            byte[] bArr3 = new byte[16];
            System.arraycopy(bArr, 0, bArr3, 0, Math.min(bArr.length, 16));
            bArr = bArr3;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, l.a("003!gehjfm"));
        Cipher cipher = getCipher(l.a("0036gehjfm") + l.a("003m+hjfe") + l.a("005^gk0m3fhelhm") + l.a("006e7ededej:f?fk"), l.a("002Xgkfe"));
        cipher.init(2, secretKeySpec);
        byte[] bArr4 = new byte[cipher.getOutputSize(bArr2.length)];
        cipher.doFinal(bArr4, cipher.update(bArr2, 0, bArr2.length, bArr4, 0));
        return bArr4;
    }

    public static byte[] AES128Encode(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return AES128Encode(bArr, str.getBytes("UTF-8"));
    }

    public static String AES128PaddingDecode(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr, 0, bArr3, 0, Math.min(bArr.length, 16));
        return new String(paddingDecode(bArr3, bArr2), "UTF-8").trim();
    }

    public static String MD5(File file) {
        FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArrRawMD5 = rawMD5(fileInputStream);
                C0396r.a(fileInputStream);
                if (bArrRawMD5 == null) {
                    return null;
                }
                return bytesToHexFaster(bArrRawMD5);
            } catch (Throwable th) {
                th = th;
                try {
                    FlyLog.getInstance().w(th);
                    C0396r.a(fileInputStream);
                    return null;
                } catch (Throwable th2) {
                    C0396r.a(fileInputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static byte[] AES128Encode(byte[] bArr, byte[] bArr2) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, ShortBufferException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, l.a("003Wgehjfm"));
        Cipher cipher = getCipher(l.a("003Rgehjfm") + l.a("003m=hjfe") + l.a("008?gk^mRhmjdfefmjlhm") + l.a("006eTededej<f4fk"), l.a("002[gkfe"));
        cipher.init(1, secretKeySpec);
        byte[] bArr3 = new byte[cipher.getOutputSize(bArr2.length)];
        cipher.doFinal(bArr3, cipher.update(bArr2, 0, bArr2.length, bArr3, 0));
        return bArr3;
    }

    public static byte[] rawMD5(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance(l.a("003Eidgmij"));
            int i5 = inputStream.read(bArr);
            while (i5 != -1) {
                messageDigest.update(bArr, 0, i5);
                i5 = inputStream.read(bArr);
            }
            return messageDigest.digest();
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return null;
        }
    }

    public static void AES128Decode(String str, InputStream inputStream, OutputStream outputStream) {
        if (str == null) {
            return;
        }
        AES128Decode(str.getBytes("UTF-8"), inputStream, outputStream);
    }

    public static void AES128Decode(byte[] bArr, InputStream inputStream, OutputStream outputStream) {
        if (bArr == null || inputStream == null || outputStream == null) {
            return;
        }
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, 16));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, l.a("003Jgehjfm"));
        Cipher cipher = getCipher(l.a("0038gehjfm") + l.a("003m2hjfe") + l.a("008[gk<m7hmjdfefmjlhm") + l.a("006e6ededej!fNfk"), l.a("002Kgkfe"));
        cipher.init(2, secretKeySpec);
        CipherInputStream cipherInputStream = null;
        try {
            CipherInputStream cipherInputStream2 = new CipherInputStream(inputStream, cipher);
            try {
                byte[] bArr3 = new byte[1024];
                for (int i5 = cipherInputStream2.read(bArr3); i5 != -1; i5 = cipherInputStream2.read(bArr3)) {
                    outputStream.write(bArr3, 0, i5);
                }
                outputStream.flush();
                C0396r.a(cipherInputStream2);
            } catch (Throwable th) {
                th = th;
                cipherInputStream = cipherInputStream2;
                C0396r.a(cipherInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
