package p134x2;

import A2.h;
import A3.AbstractC0157z;
import E3.g;
import F3.i;
import G3.b;
import O3.l;
import O3.p;
import X3.C0241g;
import android.content.Context;
import android.graphics.Bitmap;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import kotlin.jvm.internal.E;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.compress.archivers.tar.TarConstants;
import p007a4.AbstractC0275f;
import p140y2.e;
import p140y2.f;
import p146z2.j;
import p147z3.D;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class K0 {
    public static final Z Companion = new Z();
    public static final String TAG = "Printer";
    private S0 connection;
    private byte[] latestCmd;
    private l sendFailedListener;

    public final boolean a() {
        return this.latestCmd != null;
    }

    public final boolean b() {
        return this.connection != null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: checkMd5-IoAF18A, reason: not valid java name */
    public final Object m1097checkMd5IoAF18A(g<? super u> gVar) {
        C1846a0 c1846a0;
        String string;
        String str;
        Object objB;
        if (gVar instanceof C1846a0) {
            c1846a0 = (C1846a0) gVar;
            int i5 = c1846a0.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c1846a0.d = i5 - Integer.MIN_VALUE;
            } else {
                c1846a0 = new C1846a0(this, gVar);
            }
        } else {
            c1846a0 = new C1846a0(this, gVar);
        }
        Object obj = c1846a0.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c1846a0.d;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            if (this.connection == null) {
                return a.g("Connection is null");
            }
            String strValueOf = String.valueOf(new Random().nextInt(9000) + 1000);
            String strSubstring = strValueOf.substring(0, 1);
            E.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strSubstring2 = strValueOf.substring(1, 2);
            E.e(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            String strSubstring3 = strValueOf.substring(2, 3);
            E.e(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
            String strSubstring4 = strValueOf.substring(3, 4);
            E.e(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
            String strConcat = "1B2323444C505704".concat(String.format("3%s3%s3%s3%s", Arrays.copyOf(new Object[]{strSubstring, strSubstring2, strSubstring3, strSubstring4}, 4)));
            String strConcat2 = "gezhi419".concat(strValueOf);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                byte[] bytes = strConcat2.getBytes(C0241g.UTF_8);
                E.e(bytes, "this as java.lang.String).getBytes(charset)");
                byte[] bArrDigest = messageDigest.digest(bytes);
                StringBuilder sb = new StringBuilder();
                E.c(bArrDigest);
                for (byte b : bArrDigest) {
                    String hexString = Integer.toHexString(b & UnsignedBytes.MAX_VALUE);
                    if (hexString.length() == 1) {
                        sb.append('0');
                    }
                    sb.append(hexString);
                }
                string = sb.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                string = null;
            }
            E.c(string);
            Locale locale = Locale.getDefault();
            E.e(locale, "getDefault(...)");
            String upperCase = string.toUpperCase(locale);
            E.e(upperCase, "this as java.lang.String).toUpperCase(locale)");
            C1845a c1845a = C1845a.INSTANCE;
            byte[] bArrHexStringToBytes = c1845a.hexStringToBytes(strConcat);
            E.c(bArrHexStringToBytes);
            byte[] bArrHexStringToBytes2 = c1845a.hexStringToBytes("1B23234D4D4435");
            E.c(bArrHexStringToBytes2);
            byte[] bArrByteMerger = c1845a.byteMerger(bArrHexStringToBytes, bArrHexStringToBytes2);
            S0 s6 = this.connection;
            E.c(s6);
            c1846a0.f8890a = upperCase;
            c1846a0.d = 1;
            Object objM1119sendWithRespBWLJW6A = s6.m1119sendWithRespBWLJW6A(bArrByteMerger, 16, null, c1846a0);
            if (objM1119sendWithRespBWLJW6A == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = upperCase;
            objB = objM1119sendWithRespBWLJW6A;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = c1846a0.f8890a;
            v.throwOnFailure(obj);
            objB = ((u) obj).b();
        }
        boolean z6 = objB instanceof u.a;
        if (z6) {
            Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(objB);
            E.c(thM1362exceptionOrNullimpl);
            return u.m1361constructorimpl(v.createFailure(thM1362exceptionOrNullimpl));
        }
        C1845a c1845a2 = C1845a.INSTANCE;
        Object obj2 = z6 ? null : objB;
        E.c(obj2);
        String strBytesToHexString = c1845a2.bytesToHexString((byte[]) obj2);
        E.c(strBytesToHexString);
        String upperCase2 = strBytesToHexString.toUpperCase(Locale.ROOT);
        E.e(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        O o6 = O.INSTANCE;
        o6.i(TAG, "MD5Check设备返回：".concat(upperCase2));
        o6.i(TAG, "MD5Check本地校验：" + str);
        return u.m1361constructorimpl(b.boxBoolean(E.a(str, upperCase2)));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object close(g<? super Q> gVar) throws Throwable {
        C1848b0 c1848b0;
        K0 k6;
        if (gVar instanceof C1848b0) {
            c1848b0 = (C1848b0) gVar;
            int i5 = c1848b0.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c1848b0.d = i5 - Integer.MIN_VALUE;
            } else {
                c1848b0 = new C1848b0(this, gVar);
            }
        } else {
            c1848b0 = new C1848b0(this, gVar);
        }
        Object obj = c1848b0.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c1848b0.d;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            S0 s6 = this.connection;
            if (s6 != null) {
                c1848b0.f8892a = this;
                c1848b0.d = 1;
                if (s6.m1116closeIoAF18A(c1848b0) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                k6 = this;
            }
            return Q.INSTANCE;
        }
        if (i6 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        k6 = c1848b0.f8892a;
        v.throwOnFailure(obj);
        ((u) obj).getClass();
        k6.connection = null;
        return Q.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0081  */
    /* JADX WARN: Code duplicated, block: B:28:0x0088  */
    /* JADX WARN: Code duplicated, block: B:30:0x0094 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x0095  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: connect-0E7RQCE, reason: not valid java name */
    public final Object m1098connect0E7RQCE(Context context, M0 m6, g<? super u> gVar) {
        C1850c0 c1850c0;
        S0 s6;
        S0 s7;
        Object objM1117connectIoAF18A;
        K0 k6;
        if (gVar instanceof C1850c0) {
            c1850c0 = (C1850c0) gVar;
            int i5 = c1850c0.e;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c1850c0.e = i5 - Integer.MIN_VALUE;
            } else {
                c1850c0 = new C1850c0(this, gVar);
            }
        } else {
            c1850c0 = new C1850c0(this, gVar);
        }
        Object obj = c1850c0.c;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c1850c0.e;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            if (m6.getPrinterType() == L0.f8859a) {
                s7 = new S0(new e(context, (f) m6));
            } else {
                if (m6.getPrinterType() == L0.b) {
                    s7 = new S0(new j(context, (p146z2.b) m6));
                } else {
                    s6 = m6.getPrinterType() == L0.c ? new S0(new A2.g((h) m6)) : null;
                }
                if (s6 == null) {
                    return a.g("Unknown printer type");
                }
                c1850c0.f8894a = this;
                c1850c0.b = s6;
                c1850c0.e = 1;
                objM1117connectIoAF18A = s6.m1117connectIoAF18A(c1850c0);
                if (objM1117connectIoAF18A == coroutine_suspended) {
                    return coroutine_suspended;
                }
                k6 = this;
            }
            s6 = s7;
            if (s6 == null) {
                return a.g("Unknown printer type");
            }
            c1850c0.f8894a = this;
            c1850c0.b = s6;
            c1850c0.e = 1;
            objM1117connectIoAF18A = s6.m1117connectIoAF18A(c1850c0);
            if (objM1117connectIoAF18A == coroutine_suspended) {
                return coroutine_suspended;
            }
            k6 = this;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            s6 = c1850c0.b;
            k6 = c1850c0.f8894a;
            v.throwOnFailure(obj);
            objM1117connectIoAF18A = ((u) obj).b();
        }
        if (!(objM1117connectIoAF18A instanceof u.a)) {
            k6.connection = s6;
        }
        return objM1117connectIoAF18A;
    }

    public final K connectSync(Context context, M0 device) {
        E.f(context, "context");
        E.f(device, "device");
        return (K) AbstractC0275f.runBlocking$default(null, new C1852d0(this, context, device, null), 1, null);
    }

    public final M0 getPrinterDevice() {
        S0 s6 = this.connection;
        if (s6 != null) {
            return s6.getPrinterDevice();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: getPrinterInfo-IoAF18A, reason: not valid java name */
    public final Object m1099getPrinterInfoIoAF18A(g<? super u> gVar) {
        C1854e0 c1854e0;
        Object objM1119sendWithRespBWLJW6A;
        if (gVar instanceof C1854e0) {
            c1854e0 = (C1854e0) gVar;
            int i5 = c1854e0.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c1854e0.c = i5 - Integer.MIN_VALUE;
            } else {
                c1854e0 = new C1854e0(this, gVar);
            }
        } else {
            c1854e0 = new C1854e0(this, gVar);
        }
        Object obj = c1854e0.f8898a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c1854e0.c;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            S0 s6 = this.connection;
            if (s6 == null) {
                return a.g("Connection is null");
            }
            byte[] bArrJxig = Y.jxig();
            c1854e0.c = 1;
            objM1119sendWithRespBWLJW6A = s6.m1119sendWithRespBWLJW6A(bArrJxig, 116, null, c1854e0);
            if (objM1119sendWithRespBWLJW6A == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            objM1119sendWithRespBWLJW6A = ((u) obj).b();
        }
        boolean z6 = objM1119sendWithRespBWLJW6A instanceof u.a;
        if (z6) {
            Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(objM1119sendWithRespBWLJW6A);
            E.c(thM1362exceptionOrNullimpl);
            return u.m1361constructorimpl(v.createFailure(thM1362exceptionOrNullimpl));
        }
        Object obj2 = z6 ? null : objM1119sendWithRespBWLJW6A;
        E.c(obj2);
        return u.m1361constructorimpl(new P0((byte[]) obj2));
    }

    public final K getPrinterInfoSync() {
        return (K) AbstractC0275f.runBlocking$default(null, new C1856f0(this, null), 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: getPrinterState-IoAF18A, reason: not valid java name */
    public final Object m1100getPrinterStateIoAF18A(g<? super u> gVar) {
        C1858g0 c1858g0;
        if (gVar instanceof C1858g0) {
            c1858g0 = (C1858g0) gVar;
            int i5 = c1858g0.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c1858g0.c = i5 - Integer.MIN_VALUE;
            } else {
                c1858g0 = new C1858g0(this, gVar);
            }
        } else {
            c1858g0 = new C1858g0(this, gVar);
        }
        Object obj = c1858g0.f8901a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c1858g0.c;
        if (i6 != 0) {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return ((u) obj).b();
        }
        v.throwOnFailure(obj);
        S0 s6 = this.connection;
        if (s6 == null) {
            return a.g("Connection is null");
        }
        byte[] bArrJxDeviceState = Y.jxDeviceState();
        c1858g0.c = 1;
        Object objM1119sendWithRespBWLJW6A = s6.m1119sendWithRespBWLJW6A(bArrJxDeviceState, 4, null, c1858g0);
        return objM1119sendWithRespBWLJW6A == coroutine_suspended ? coroutine_suspended : objM1119sendWithRespBWLJW6A;
    }

    public final K getPrinterStateSync() {
        return (K) AbstractC0275f.runBlocking$default(null, new C1860h0(this, null), 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: getWifiState-IoAF18A, reason: not valid java name */
    public final Object m1101getWifiStateIoAF18A(g<? super u> gVar) throws Throwable {
        C1862i0 c1862i0;
        Object objM1119sendWithRespBWLJW6A;
        if (gVar instanceof C1862i0) {
            c1862i0 = (C1862i0) gVar;
            int i5 = c1862i0.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c1862i0.c = i5 - Integer.MIN_VALUE;
            } else {
                c1862i0 = new C1862i0(this, gVar);
            }
        } else {
            c1862i0 = new C1862i0(this, gVar);
        }
        Object obj = c1862i0.f8905a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c1862i0.c;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            S0 s6 = this.connection;
            if (s6 == null) {
                return a.g("Connection is null");
            }
            byte[] bArr = {Ascii.ESC, 35, 35, 71, 82, 84, TarConstants.LF_GNUTYPE_SPARSE};
            c1862i0.c = 1;
            objM1119sendWithRespBWLJW6A = s6.m1119sendWithRespBWLJW6A(bArr, 5, null, c1862i0);
            if (objM1119sendWithRespBWLJW6A == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            objM1119sendWithRespBWLJW6A = ((u) obj).b();
        }
        boolean z6 = objM1119sendWithRespBWLJW6A instanceof u.a;
        if (z6) {
            Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(objM1119sendWithRespBWLJW6A);
            E.c(thM1362exceptionOrNullimpl);
            return u.m1361constructorimpl(v.createFailure(thM1362exceptionOrNullimpl));
        }
        Object obj2 = z6 ? null : objM1119sendWithRespBWLJW6A;
        E.c(obj2);
        byte[] bArr2 = (byte[]) obj2;
        String strM1172toStringimpl = D.m1172toStringimpl(D.m1131constructorimpl(bArr2[0]));
        String strM1172toStringimpl2 = D.m1172toStringimpl(D.m1131constructorimpl(bArr2[1]));
        String strM1172toStringimpl3 = D.m1172toStringimpl(D.m1131constructorimpl(bArr2[2]));
        String strM1172toStringimpl4 = D.m1172toStringimpl(D.m1131constructorimpl(bArr2[3]));
        StringBuilder sb = new StringBuilder();
        sb.append(strM1172toStringimpl);
        sb.append(Consts.DOT);
        sb.append(strM1172toStringimpl2);
        sb.append(Consts.DOT);
        sb.append(strM1172toStringimpl3);
        return u.m1361constructorimpl(new c1(AbstractC0157z.s(sb, Consts.DOT, strM1172toStringimpl4), bArr2[4] == 1));
    }

    public final K getWifiStateSync() {
        return (K) AbstractC0275f.runBlocking$default(null, new C1864j0(this, null), 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: printESCBitmap-yxL6bBk, reason: not valid java name */
    public final Object m1102printESCBitmapyxL6bBk(Bitmap bitmap, boolean z6, int i5, p pVar, g<? super u> gVar) throws Throwable {
        C1866k0 c1866k0;
        byte[] bArrByteMerger;
        if (gVar instanceof C1866k0) {
            c1866k0 = (C1866k0) gVar;
            int i6 = c1866k0.c;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                c1866k0.c = i6 - Integer.MIN_VALUE;
            } else {
                c1866k0 = new C1866k0(this, gVar);
            }
        } else {
            c1866k0 = new C1866k0(this, gVar);
        }
        Object obj = c1866k0.f8911a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i7 = c1866k0.c;
        if (i7 != 0) {
            if (i7 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return ((u) obj).b();
        }
        v.throwOnFailure(obj);
        byte[] bArrByteMerger2 = new byte[0];
        for (int i8 = 0; i8 < i5; i8++) {
            byte[] bArrByteMerger3 = Y.byteMerger(Y.byteMerger(bArrByteMerger2, G.start()), G.centerAligned());
            if (z6) {
                byte[] bArrRasterBmpToSendDataByZLib = G.rasterBmpToSendDataByZLib(bitmap);
                if (bArrRasterBmpToSendDataByZLib == null) {
                    return a.g("ZLib compress failed");
                }
                bArrByteMerger = Y.byteMerger(bArrByteMerger3, bArrRasterBmpToSendDataByZLib);
            } else {
                bArrByteMerger = Y.byteMerger(bArrByteMerger3, G.rasterBmpToSendData(bitmap));
            }
            bArrByteMerger2 = Y.byteMerger(bArrByteMerger, G.end());
        }
        S0 s6 = this.connection;
        if (s6 == null) {
            return a.g("Connection is null");
        }
        c1866k0.c = 1;
        Object objM1118send0E7RQCE = s6.m1118send0E7RQCE(bArrByteMerger2, pVar, c1866k0);
        return objM1118send0E7RQCE == coroutine_suspended ? coroutine_suspended : objM1118send0E7RQCE;
    }

    public final K printESCBitmapSync(Bitmap bitmap, boolean z6, int i5, p pVar) {
        E.f(bitmap, "bitmap");
        return (K) AbstractC0275f.runBlocking$default(null, new C1868l0(this, bitmap, z6, i5, pVar, null), 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: printTSCBitmap-bMdYcbs, reason: not valid java name */
    public final Object m1103printTSCBitmapbMdYcbs(Bitmap bitmap, boolean z6, int i5, String str, int i6, p pVar, g<? super u> gVar) throws Throwable {
        C1870m0 c1870m0;
        byte[] bArrByteMerger;
        if (gVar instanceof C1870m0) {
            c1870m0 = (C1870m0) gVar;
            int i7 = c1870m0.c;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                c1870m0.c = i7 - Integer.MIN_VALUE;
            } else {
                c1870m0 = new C1870m0(this, gVar);
            }
        } else {
            c1870m0 = new C1870m0(this, gVar);
        }
        Object obj = c1870m0.f8917a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i8 = c1870m0.c;
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return ((u) obj).b();
        }
        v.throwOnFailure(obj);
        byte[] bArrSizeBymm = a1.sizeBymm((int) C1849c.px2mm(bitmap.getWidth()), (int) C1849c.px2mm(bitmap.getHeight()));
        E.c(bArrSizeBymm);
        byte[] bArrByteMerger2 = Y.byteMerger(new byte[0], bArrSizeBymm);
        byte[] bArrSpeed = a1.speed(str);
        E.c(bArrSpeed);
        byte[] bArrByteMerger3 = Y.byteMerger(bArrByteMerger2, bArrSpeed);
        byte[] bArrDensity = a1.density(i6);
        E.c(bArrDensity);
        byte[] bArrByteMerger4 = Y.byteMerger(bArrByteMerger3, bArrDensity);
        byte[] bArrCls = a1.cls();
        E.c(bArrCls);
        byte[] bArrByteMerger5 = Y.byteMerger(bArrByteMerger4, bArrCls);
        byte[] bArrDirection = a1.direction(0);
        E.c(bArrDirection);
        byte[] bArrByteMerger6 = Y.byteMerger(bArrByteMerger5, bArrDirection);
        for (int i9 = 0; i9 < i5; i9++) {
            if (z6) {
                bArrByteMerger = Y.byteMerger(bArrByteMerger6, a1.bitmapByZLib(0, 0, bitmap, 128));
            } else {
                byte[] bArrBitmap = a1.bitmap(0, 0, 0, bitmap, 128);
                E.c(bArrBitmap);
                bArrByteMerger = Y.byteMerger(bArrByteMerger6, bArrBitmap);
            }
            byte[] bArrPrint = a1.print(1);
            E.c(bArrPrint);
            bArrByteMerger6 = Y.byteMerger(bArrByteMerger, bArrPrint);
        }
        S0 s6 = this.connection;
        if (s6 == null) {
            return a.g("Connection is null");
        }
        c1870m0.c = 1;
        Object objM1118send0E7RQCE = s6.m1118send0E7RQCE(bArrByteMerger6, pVar, c1870m0);
        return objM1118send0E7RQCE == coroutine_suspended ? coroutine_suspended : objM1118send0E7RQCE;
    }

    public final K printTSCBitmapSync(Bitmap bitmap, boolean z6, int i5, String speedLev, int i6, p pVar) {
        E.f(bitmap, "bitmap");
        E.f(speedLev, "speedLev");
        return (K) AbstractC0275f.runBlocking$default(null, new C1872n0(this, bitmap, z6, i5, speedLev, i6, pVar, null), 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: resetPrinter-IoAF18A, reason: not valid java name */
    public final Object m1104resetPrinterIoAF18A(g<? super u> gVar) throws Throwable {
        C1874o0 c1874o0;
        if (gVar instanceof C1874o0) {
            c1874o0 = (C1874o0) gVar;
            int i5 = c1874o0.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c1874o0.c = i5 - Integer.MIN_VALUE;
            } else {
                c1874o0 = new C1874o0(this, gVar);
            }
        } else {
            c1874o0 = new C1874o0(this, gVar);
        }
        Object obj = c1874o0.f8926a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c1874o0.c;
        if (i6 != 0) {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return ((u) obj).b();
        }
        v.throwOnFailure(obj);
        S0 s6 = this.connection;
        if (s6 == null) {
            return a.g("Connection is null");
        }
        byte[] bArrJxDeviceReset = Y.jxDeviceReset();
        c1874o0.c = 1;
        Object objM1118send0E7RQCE = s6.m1118send0E7RQCE(bArrJxDeviceReset, null, c1874o0);
        return objM1118send0E7RQCE == coroutine_suspended ? coroutine_suspended : objM1118send0E7RQCE;
    }

    public final K resetPrinterSync() {
        return (K) AbstractC0275f.runBlocking$default(null, new C1876p0(this, null), 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: selfCheck-IoAF18A, reason: not valid java name */
    public final Object m1105selfCheckIoAF18A(g<? super u> gVar) throws Throwable {
        C1878q0 c1878q0;
        if (gVar instanceof C1878q0) {
            c1878q0 = (C1878q0) gVar;
            int i5 = c1878q0.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c1878q0.c = i5 - Integer.MIN_VALUE;
            } else {
                c1878q0 = new C1878q0(this, gVar);
            }
        } else {
            c1878q0 = new C1878q0(this, gVar);
        }
        Object obj = c1878q0.f8931a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c1878q0.c;
        if (i6 != 0) {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return ((u) obj).b();
        }
        v.throwOnFailure(obj);
        S0 s6 = this.connection;
        if (s6 == null) {
            return a.g("Connection is null");
        }
        byte[] bArrJxDeviceCheck = Y.jxDeviceCheck();
        c1878q0.c = 1;
        Object objM1118send0E7RQCE = s6.m1118send0E7RQCE(bArrJxDeviceCheck, null, c1878q0);
        return objM1118send0E7RQCE == coroutine_suspended ? coroutine_suspended : objM1118send0E7RQCE;
    }

    public final K selfCheckSync() {
        return (K) AbstractC0275f.runBlocking$default(null, new C1879r0(this, null), 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: send-0E7RQCE, reason: not valid java name */
    public final Object m1106send0E7RQCE(byte[] bArr, p pVar, g<? super u> gVar) throws Throwable {
        C1881s0 c1881s0;
        Object objM1118send0E7RQCE;
        K0 k6;
        l lVar;
        if (gVar instanceof C1881s0) {
            c1881s0 = (C1881s0) gVar;
            int i5 = c1881s0.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c1881s0.d = i5 - Integer.MIN_VALUE;
            } else {
                c1881s0 = new C1881s0(this, gVar);
            }
        } else {
            c1881s0 = new C1881s0(this, gVar);
        }
        Object obj = c1881s0.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c1881s0.d;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            S0 s6 = this.connection;
            if (s6 == null) {
                return a.g("Connection is null");
            }
            this.latestCmd = bArr;
            c1881s0.f8937a = this;
            c1881s0.d = 1;
            objM1118send0E7RQCE = s6.m1118send0E7RQCE(bArr, pVar, c1881s0);
            if (objM1118send0E7RQCE == coroutine_suspended) {
                return coroutine_suspended;
            }
            k6 = this;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k6 = c1881s0.f8937a;
            v.throwOnFailure(obj);
            objM1118send0E7RQCE = ((u) obj).b();
        }
        if ((objM1118send0E7RQCE instanceof u.a) && (lVar = k6.sendFailedListener) != null) {
            lVar.invoke(u.m1362exceptionOrNullimpl(objM1118send0E7RQCE));
        }
        return objM1118send0E7RQCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: sendData-0E7RQCE, reason: not valid java name */
    public final Object m1107sendData0E7RQCE(byte[] bArr, p pVar, g<? super u> gVar) throws Throwable {
        C1883t0 c1883t0;
        if (gVar instanceof C1883t0) {
            c1883t0 = (C1883t0) gVar;
            int i5 = c1883t0.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c1883t0.c = i5 - Integer.MIN_VALUE;
            } else {
                c1883t0 = new C1883t0(this, gVar);
            }
        } else {
            c1883t0 = new C1883t0(this, gVar);
        }
        Object obj = c1883t0.f8939a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c1883t0.c;
        if (i6 != 0) {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return ((u) obj).b();
        }
        v.throwOnFailure(obj);
        S0 s6 = this.connection;
        if (s6 == null) {
            return a.g("Connection is null");
        }
        c1883t0.c = 1;
        Object objM1118send0E7RQCE = s6.m1118send0E7RQCE(bArr, pVar, c1883t0);
        return objM1118send0E7RQCE == coroutine_suspended ? coroutine_suspended : objM1118send0E7RQCE;
    }

    public final K sendDataSync(byte[] data, p pVar) {
        E.f(data, "data");
        return (K) AbstractC0275f.runBlocking$default(null, new C1885u0(this, data, pVar, null), 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: sendLatestCmd-gIAlu-s, reason: not valid java name */
    public final Object m1108sendLatestCmdgIAlus(p pVar, g<? super u> gVar) throws Throwable {
        C1887v0 c1887v0;
        if (gVar instanceof C1887v0) {
            c1887v0 = (C1887v0) gVar;
            int i5 = c1887v0.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c1887v0.c = i5 - Integer.MIN_VALUE;
            } else {
                c1887v0 = new C1887v0(this, gVar);
            }
        } else {
            c1887v0 = new C1887v0(this, gVar);
        }
        Object obj = c1887v0.f8944a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c1887v0.c;
        if (i6 != 0) {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return ((u) obj).b();
        }
        v.throwOnFailure(obj);
        byte[] bArr = this.latestCmd;
        if (bArr == null) {
            return a.g("No latest command");
        }
        E.c(bArr);
        c1887v0.c = 1;
        Object objM1106send0E7RQCE = m1106send0E7RQCE(bArr, pVar, c1887v0);
        return objM1106send0E7RQCE == coroutine_suspended ? coroutine_suspended : objM1106send0E7RQCE;
    }

    public final K sendLatestCmdSync(p pVar) {
        return (K) AbstractC0275f.runBlocking$default(null, new C1889w0(this, pVar, null), 1, null);
    }

    public final K sendSync(byte[] data, p pVar) {
        E.f(data, "data");
        return (K) AbstractC0275f.runBlocking$default(null, new C1891x0(this, data, pVar, null), 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: sendWithResp-BWLJW6A, reason: not valid java name */
    public final Object m1109sendWithRespBWLJW6A(byte[] bArr, int i5, p pVar, g<? super u> gVar) throws Throwable {
        C1893y0 c1893y0;
        Object objM1119sendWithRespBWLJW6A;
        K0 k6;
        l lVar;
        if (gVar instanceof C1893y0) {
            c1893y0 = (C1893y0) gVar;
            int i6 = c1893y0.d;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                c1893y0.d = i6 - Integer.MIN_VALUE;
            } else {
                c1893y0 = new C1893y0(this, gVar);
            }
        } else {
            c1893y0 = new C1893y0(this, gVar);
        }
        Object obj = c1893y0.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i7 = c1893y0.d;
        if (i7 == 0) {
            v.throwOnFailure(obj);
            S0 s6 = this.connection;
            if (s6 == null) {
                return a.g("Connection is null");
            }
            c1893y0.f8950a = this;
            c1893y0.d = 1;
            objM1119sendWithRespBWLJW6A = s6.m1119sendWithRespBWLJW6A(bArr, i5, pVar, c1893y0);
            if (objM1119sendWithRespBWLJW6A == coroutine_suspended) {
                return coroutine_suspended;
            }
            k6 = this;
        } else {
            if (i7 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k6 = c1893y0.f8950a;
            v.throwOnFailure(obj);
            objM1119sendWithRespBWLJW6A = ((u) obj).b();
        }
        if ((objM1119sendWithRespBWLJW6A instanceof u.a) && (lVar = k6.sendFailedListener) != null) {
            lVar.invoke(u.m1362exceptionOrNullimpl(objM1119sendWithRespBWLJW6A));
        }
        return objM1119sendWithRespBWLJW6A;
    }

    public final K sendWithRespSync(byte[] data, int i5, p pVar) {
        E.f(data, "data");
        return (K) AbstractC0275f.runBlocking$default(null, new C1895z0(this, data, i5, pVar, null), 1, null);
    }

    public final void setRecvListener(l listener) {
        E.f(listener, "listener");
        S0 s6 = this.connection;
        if (s6 != null) {
            s6.setRecvListener(listener);
        }
    }

    public final void setSendFailedListener(l listener) {
        E.f(listener, "listener");
        this.sendFailedListener = listener;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: setWifiDHCP-gIAlu-s, reason: not valid java name */
    public final Object m1110setWifiDHCPgIAlus(boolean z6, g<? super u> gVar) throws Throwable {
        A0 a6;
        if (gVar instanceof A0) {
            a6 = (A0) gVar;
            int i5 = a6.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                a6.c = i5 - Integer.MIN_VALUE;
            } else {
                a6 = new A0(this, gVar);
            }
        } else {
            a6 = new A0(this, gVar);
        }
        Object obj = a6.f8844a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = a6.c;
        if (i6 != 0) {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return ((u) obj).b();
        }
        v.throwOnFailure(obj);
        S0 s6 = this.connection;
        if (s6 == null) {
            return a.g("Connection is null");
        }
        byte[] bArr = {Ascii.ESC, 35, 35, 68, 72, 67, 80, z6 ? (byte) 1 : (byte) 0};
        a6.c = 1;
        Object objM1118send0E7RQCE = s6.m1118send0E7RQCE(bArr, null, a6);
        return objM1118send0E7RQCE == coroutine_suspended ? coroutine_suspended : objM1118send0E7RQCE;
    }

    public final K setWifiDHCPSync(boolean z6) {
        return (K) AbstractC0275f.runBlocking$default(null, new B0(this, z6, null), 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: setWifiName-gIAlu-s, reason: not valid java name */
    public final Object m1111setWifiNamegIAlus(String str, g<? super u> gVar) throws Throwable {
        C0 c6;
        if (gVar instanceof C0) {
            c6 = (C0) gVar;
            int i5 = c6.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c6.c = i5 - Integer.MIN_VALUE;
            } else {
                c6 = new C0(this, gVar);
            }
        } else {
            c6 = new C0(this, gVar);
        }
        Object obj = c6.f8848a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c6.c;
        if (i6 != 0) {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return ((u) obj).b();
        }
        v.throwOnFailure(obj);
        if (this.connection == null) {
            return a.g("Connection is null");
        }
        byte[] bytes = str.getBytes(C0241g.UTF_8);
        E.e(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] bArrByteMerger = Y.byteMerger(new byte[]{Ascii.ESC, 35, 35, 82, 84, 78, 65, (byte) bytes.length}, bytes);
        S0 s6 = this.connection;
        E.c(s6);
        c6.c = 1;
        Object objM1118send0E7RQCE = s6.m1118send0E7RQCE(bArrByteMerger, null, c6);
        return objM1118send0E7RQCE == coroutine_suspended ? coroutine_suspended : objM1118send0E7RQCE;
    }

    public final K setWifiNameSync(String name) {
        E.f(name, "name");
        return (K) AbstractC0275f.runBlocking$default(null, new D0(this, name, null), 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: setWifiPassword-gIAlu-s, reason: not valid java name */
    public final Object m1112setWifiPasswordgIAlus(String str, g<? super u> gVar) throws Throwable {
        E0 e1;
        if (gVar instanceof E0) {
            e1 = (E0) gVar;
            int i5 = e1.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                e1.c = i5 - Integer.MIN_VALUE;
            } else {
                e1 = new E0(this, gVar);
            }
        } else {
            e1 = new E0(this, gVar);
        }
        Object obj = e1.f8852a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = e1.c;
        if (i6 != 0) {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return ((u) obj).b();
        }
        v.throwOnFailure(obj);
        if (this.connection == null) {
            return a.g("Connection is null");
        }
        byte[] bytes = str.getBytes(C0241g.UTF_8);
        E.e(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] bArrByteMerger = Y.byteMerger(new byte[]{Ascii.ESC, 35, 35, 82, 84, 80, 87, (byte) bytes.length}, bytes);
        S0 s6 = this.connection;
        E.c(s6);
        e1.c = 1;
        Object objM1118send0E7RQCE = s6.m1118send0E7RQCE(bArrByteMerger, null, e1);
        return objM1118send0E7RQCE == coroutine_suspended ? coroutine_suspended : objM1118send0E7RQCE;
    }

    public final K setWifiPasswordSync(String password) {
        E.f(password, "password");
        return (K) AbstractC0275f.runBlocking$default(null, new F0(this, password, null), 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: updateSetting-gIAlu-s, reason: not valid java name */
    public final Object m1113updateSettinggIAlus(P0 p1, g<? super u> gVar) throws Throwable {
        G0 g1;
        if (gVar instanceof G0) {
            g1 = (G0) gVar;
            int i5 = g1.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                g1.c = i5 - Integer.MIN_VALUE;
            } else {
                g1 = new G0(this, gVar);
            }
        } else {
            g1 = new G0(this, gVar);
        }
        Object obj = g1.f8854a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = g1.c;
        if (i6 != 0) {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return ((u) obj).b();
        }
        v.throwOnFailure(obj);
        if (this.connection == null) {
            return a.g("Connection is null");
        }
        byte[] bArrJxis = Y.jxis(p1);
        S0 s6 = this.connection;
        E.c(s6);
        g1.c = 1;
        Object objM1118send0E7RQCE = s6.m1118send0E7RQCE(bArrJxis, null, g1);
        return objM1118send0E7RQCE == coroutine_suspended ? coroutine_suspended : objM1118send0E7RQCE;
    }

    public final K updateSettingSync(P0 printInfo) {
        E.f(printInfo, "printInfo");
        return (K) AbstractC0275f.runBlocking$default(null, new H0(this, printInfo, null), 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: updateTime-gIAlu-s, reason: not valid java name */
    public final Object m1114updateTimegIAlus(String str, g<? super u> gVar) throws Throwable {
        I0 i1;
        if (gVar instanceof I0) {
            i1 = (I0) gVar;
            int i5 = i1.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                i1.c = i5 - Integer.MIN_VALUE;
            } else {
                i1 = new I0(this, gVar);
            }
        } else {
            i1 = new I0(this, gVar);
        }
        Object obj = i1.f8856a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = i1.c;
        if (i6 != 0) {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return ((u) obj).b();
        }
        v.throwOnFailure(obj);
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        byte[] bArr = {Ascii.ESC, 35, 35, TarConstants.LF_GNUTYPE_SPARSE, 82, 84, 77, (byte) (date.getYear() - 100), (byte) (date.getMonth() + 1), (byte) date.getDate(), (byte) date.getHours(), (byte) date.getMinutes(), (byte) date.getSeconds()};
        S0 s6 = this.connection;
        if (s6 == null) {
            return a.g("Connection is null");
        }
        i1.c = 1;
        Object objM1118send0E7RQCE = s6.m1118send0E7RQCE(bArr, null, i1);
        return objM1118send0E7RQCE == coroutine_suspended ? coroutine_suspended : objM1118send0E7RQCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: upgrade-0E7RQCE, reason: not valid java name */
    public final Object m1115upgrade0E7RQCE(byte[] bArr, p pVar, g<? super u> gVar) throws Throwable {
        J0 j1;
        if (gVar instanceof J0) {
            j1 = (J0) gVar;
            int i5 = j1.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                j1.c = i5 - Integer.MIN_VALUE;
            } else {
                j1 = new J0(this, gVar);
            }
        } else {
            j1 = new J0(this, gVar);
        }
        Object obj = j1.f8858a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = j1.c;
        if (i6 != 0) {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return ((u) obj).b();
        }
        v.throwOnFailure(obj);
        S0 s6 = this.connection;
        if (s6 == null) {
            return a.g("Connection is null");
        }
        j1.c = 1;
        Object objM1118send0E7RQCE = s6.m1118send0E7RQCE(bArr, pVar, j1);
        return objM1118send0E7RQCE == coroutine_suspended ? coroutine_suspended : objM1118send0E7RQCE;
    }
}
