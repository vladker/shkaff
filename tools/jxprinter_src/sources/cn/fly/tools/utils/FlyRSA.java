package cn.fly.tools.utils;

import cn.fly.commons.C0396r;
import cn.fly.tools.proguard.PublicMemberKeeper;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes.dex */
public class FlyRSA implements PublicMemberKeeper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1929a;

    public FlyRSA(int i5) {
        this.f1929a = i5;
    }

    private byte[] a(byte[] bArr, int i5, int i6, BigInteger bigInteger, BigInteger bigInteger2, int i7) throws Throwable {
        if (bArr.length != i6 || i5 != 0) {
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i5, bArr2, 0, i6);
            bArr = bArr2;
        }
        BigInteger bigInteger3 = new BigInteger(a(bArr, i7));
        if (bigInteger3.compareTo(bigInteger2) <= 0) {
            return bigInteger3.modPow(bigInteger, bigInteger2).toByteArray();
        }
        throw new Throwable("the message must be smaller than the modulue");
    }

    public byte[] encode(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) throws Throwable {
        Throwable th;
        int i5 = this.f1929a / 8;
        int i6 = i5 - 11;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = null;
        try {
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
            int i7 = 0;
            while (bArr.length > i7) {
                try {
                    int iMin = Math.min(bArr.length - i7, i6);
                    byte[] bArrA = a(bArr, i7, iMin, bigInteger, bigInteger2, i5);
                    dataOutputStream2.writeInt(bArrA.length);
                    dataOutputStream2.write(bArrA);
                    i7 += iMin;
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream = dataOutputStream2;
                    C0396r.a(dataOutputStream, byteArrayOutputStream);
                    throw th;
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            C0396r.a(dataOutputStream2, byteArrayOutputStream);
            return byteArray;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private byte[] a(byte[] bArr, int i5) throws Throwable {
        if (bArr.length <= i5 - 1) {
            byte[] bArr2 = new byte[i5];
            bArr2[0] = 1;
            int length = bArr.length;
            bArr2[1] = (byte) (length >> 24);
            bArr2[2] = (byte) (length >> 16);
            bArr2[3] = (byte) (length >> 8);
            bArr2[4] = (byte) length;
            SecureRandom secureRandom = new SecureRandom();
            int i6 = 5;
            while (true) {
                int i7 = i5 - length;
                if (i6 < i7) {
                    bArr2[i6] = (byte) (secureRandom.nextInt(256) - 128);
                    i6++;
                } else {
                    System.arraycopy(bArr, 0, bArr2, i7, length);
                    return bArr2;
                }
            }
        } else {
            throw new Throwable("Message too large");
        }
    }
}
