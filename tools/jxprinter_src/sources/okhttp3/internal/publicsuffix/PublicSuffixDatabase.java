package okhttp3.internal.publicsuffix;

import A4.B;
import A4.InterfaceC0171n;
import A4.N;
import androidx.webkit.ProxyConfig;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.poi.ss.formula.ptg.RefErrorPtg;
import p130w4.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class PublicSuffixDatabase {
    public static final byte[] e = {RefErrorPtg.sid};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f6654f = new String[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f6655g = {ProxyConfig.MATCH_ALL_SCHEMES};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final PublicSuffixDatabase f6656h = new PublicSuffixDatabase();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f6657a = new AtomicBoolean(false);
    public final CountDownLatch b = new CountDownLatch(1);
    public byte[] c;
    public byte[] d;

    public static String a(byte[] bArr, byte[][] bArr2, int i5) {
        int i6;
        boolean z6;
        int i7;
        int i8;
        int length = bArr.length;
        int i9 = 0;
        while (i9 < length) {
            int i10 = (i9 + length) / 2;
            while (i10 > -1 && bArr[i10] != 10) {
                i10--;
            }
            int i11 = i10 + 1;
            int i12 = 1;
            while (true) {
                i6 = i11 + i12;
                if (bArr[i6] == 10) {
                    break;
                }
                i12++;
            }
            int i13 = i6 - i11;
            int i14 = i5;
            boolean z7 = false;
            int i15 = 0;
            int i16 = 0;
            while (true) {
                if (z7) {
                    i7 = 46;
                    z6 = false;
                } else {
                    z6 = z7;
                    i7 = bArr2[i14][i15] & UnsignedBytes.MAX_VALUE;
                }
                i8 = i7 - (bArr[i11 + i16] & UnsignedBytes.MAX_VALUE);
                if (i8 == 0) {
                    i16++;
                    i15++;
                    if (i16 == i13) {
                        break;
                    }
                    if (bArr2[i14].length != i15) {
                        z7 = z6;
                    } else {
                        if (i14 == bArr2.length - 1) {
                            break;
                        }
                        i14++;
                        i15 = -1;
                        z7 = true;
                    }
                } else {
                    break;
                }
            }
            if (i8 >= 0) {
                if (i8 <= 0) {
                    int i17 = i13 - i16;
                    int length2 = bArr2[i14].length - i15;
                    while (true) {
                        i14++;
                        if (i14 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i14].length;
                    }
                    if (length2 >= i17) {
                        if (length2 <= i17) {
                            return new String(bArr, i11, i13, StandardCharsets.UTF_8);
                        }
                    }
                }
                i9 = i6 + 1;
            }
            length = i10;
        }
        return null;
    }

    private void readTheList() {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        InterfaceC0171n interfaceC0171nBuffer = N.buffer(new B(N.source(resourceAsStream)));
        try {
            byte[] bArr = new byte[interfaceC0171nBuffer.readInt()];
            interfaceC0171nBuffer.readFully(bArr);
            byte[] bArr2 = new byte[interfaceC0171nBuffer.readInt()];
            interfaceC0171nBuffer.readFully(bArr2);
            interfaceC0171nBuffer.close();
            synchronized (this) {
                this.c = bArr;
                this.d = bArr2;
            }
            this.b.countDown();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (interfaceC0171nBuffer != null) {
                    try {
                        interfaceC0171nBuffer.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public final String b(String str) {
        String strA;
        String strA2;
        String strA3;
        String[] strArrSplit;
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit2 = IDN.toUnicode(str).split("\\.");
        if (this.f6657a.get() || !this.f6657a.compareAndSet(false, true)) {
            try {
                this.b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z6 = false;
            while (true) {
                try {
                    try {
                        try {
                            readTheList();
                            break;
                        } catch (InterruptedIOException unused2) {
                            Thread.interrupted();
                            z6 = true;
                        }
                    } catch (IOException e6) {
                        i.f8835a.log(5, "Failed to read public suffix list", e6);
                        if (z6) {
                        }
                    }
                } catch (Throwable th) {
                    if (z6) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z6) {
                Thread.currentThread().interrupt();
            }
        }
        synchronized (this) {
            if (this.c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length3 = strArrSplit2.length;
        byte[][] bArr = new byte[length3][];
        for (int i5 = 0; i5 < strArrSplit2.length; i5++) {
            bArr[i5] = strArrSplit2[i5].getBytes(StandardCharsets.UTF_8);
        }
        int i6 = 0;
        while (true) {
            if (i6 >= length3) {
                strA = null;
                break;
            }
            strA = a(this.c, bArr, i6);
            if (strA != null) {
                break;
            }
            i6++;
        }
        if (length3 <= 1) {
            strA2 = null;
            break;
        }
        byte[][] bArr2 = (byte[][]) bArr.clone();
        int i7 = 0;
        while (true) {
            if (i7 >= bArr2.length - 1) {
                strA2 = null;
                break;
            }
            bArr2[i7] = e;
            strA2 = a(this.c, bArr2, i7);
            if (strA2 != null) {
                break;
            }
            i7++;
        }
        if (strA2 == null) {
            strA3 = null;
            break;
        }
        int i8 = 0;
        while (true) {
            if (i8 >= length3 - 1) {
                strA3 = null;
                break;
            }
            strA3 = a(this.d, bArr, i8);
            if (strA3 != null) {
                break;
            }
            i8++;
        }
        if (strA3 != null) {
            strArrSplit = "!".concat(strA3).split("\\.");
        } else if (strA == null && strA2 == null) {
            strArrSplit = f6655g;
        } else {
            strArrSplit = strA != null ? strA.split("\\.") : f6654f;
            String[] strArrSplit3 = strA2 != null ? strA2.split("\\.") : f6654f;
            if (strArrSplit.length <= strArrSplit3.length) {
                strArrSplit = strArrSplit3;
            }
        }
        if (strArrSplit2.length == strArrSplit.length && strArrSplit[0].charAt(0) != '!') {
            return null;
        }
        if (strArrSplit[0].charAt(0) == '!') {
            length = strArrSplit2.length;
            length2 = strArrSplit.length;
        } else {
            length = strArrSplit2.length;
            length2 = strArrSplit.length + 1;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit4 = str.split("\\.");
        for (int i9 = length - length2; i9 < strArrSplit4.length; i9++) {
            sb.append(strArrSplit4[i9]);
            sb.append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
