package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbws {
    static final long zba;
    static final boolean zbb;
    private static final Unsafe zbc;
    private static final Class zbd;
    private static final boolean zbe;
    private static final zbwr zbf;
    private static final boolean zbg;
    private static final boolean zbh;

    /* JADX WARN: Code duplicated, block: B:11:0x003d  */
    static {
        boolean z6;
        boolean z7;
        zbwr zbwrVar;
        Unsafe unsafeZbg = zbg();
        zbc = unsafeZbg;
        int i5 = zbsm.zba;
        zbd = Memory.class;
        Class cls = Long.TYPE;
        boolean zZbv = zbv(cls);
        zbe = zZbv;
        Class cls2 = Integer.TYPE;
        boolean zZbv2 = zbv(cls2);
        zbwr zbwpVar = null;
        if (unsafeZbg != null) {
            if (zZbv) {
                zbwpVar = new zbwq(unsafeZbg);
            } else if (zZbv2) {
                zbwpVar = new zbwp(unsafeZbg);
            }
        }
        zbf = zbwpVar;
        if (zbwpVar == null) {
            z6 = false;
        } else {
            try {
                Class<?> cls3 = zbwpVar.zba.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("getLong", Object.class, cls);
                if (zbB() == null) {
                    z6 = false;
                } else {
                    z6 = true;
                }
            } catch (Throwable th) {
                zbh(th);
            }
        }
        zbg = z6;
        zbwr zbwrVar2 = zbf;
        if (zbwrVar2 == null) {
            z7 = false;
        } else {
            try {
                Class<?> cls4 = zbwrVar2.zba.getClass();
                cls4.getMethod("objectFieldOffset", Field.class);
                cls4.getMethod("arrayBaseOffset", Class.class);
                cls4.getMethod("arrayIndexScale", Class.class);
                cls4.getMethod("getInt", Object.class, cls);
                cls4.getMethod("putInt", Object.class, cls, cls2);
                cls4.getMethod("getLong", Object.class, cls);
                cls4.getMethod("putLong", Object.class, cls, cls);
                cls4.getMethod("getObject", Object.class, cls);
                cls4.getMethod("putObject", Object.class, cls, Object.class);
                z7 = true;
            } catch (Throwable th2) {
                zbh(th2);
                z7 = false;
            }
        }
        zbh = z7;
        zba = zbz(byte[].class);
        zbz(boolean[].class);
        zbA(boolean[].class);
        zbz(int[].class);
        zbA(int[].class);
        zbz(long[].class);
        zbA(long[].class);
        zbz(float[].class);
        zbA(float[].class);
        zbz(double[].class);
        zbA(double[].class);
        zbz(Object[].class);
        zbA(Object[].class);
        Field fieldZbB = zbB();
        if (fieldZbB != null && (zbwrVar = zbf) != null) {
            zbwrVar.zba.objectFieldOffset(fieldZbB);
        }
        zbb = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zbws() {
    }

    private static int zbA(Class cls) {
        if (zbh) {
            return zbf.zba.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zbB() {
        int i5 = zbsm.zba;
        Field fieldZbC = zbC(Buffer.class, "effectiveDirectAddress");
        if (fieldZbC != null) {
            return fieldZbC;
        }
        Field fieldZbC2 = zbC(Buffer.class, "address");
        if (fieldZbC2 == null || fieldZbC2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZbC2;
    }

    private static Field zbC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zbD(Object obj, long j6, byte b) {
        zbwr zbwrVar = zbf;
        long j7 = (-4) & j6;
        int i5 = zbwrVar.zba.getInt(obj, j7);
        int i6 = ((~((int) j6)) & 3) << 3;
        zbwrVar.zba.putInt(obj, j7, ((255 & b) << i6) | (i5 & (~(255 << i6))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zbE(Object obj, long j6, byte b) {
        zbwr zbwrVar = zbf;
        long j7 = (-4) & j6;
        int i5 = (((int) j6) & 3) << 3;
        zbwrVar.zba.putInt(obj, j7, ((255 & b) << i5) | (zbwrVar.zba.getInt(obj, j7) & (~(255 << i5))));
    }

    public static double zba(Object obj, long j6) {
        return zbf.zba(obj, j6);
    }

    public static float zbb(Object obj, long j6) {
        return zbf.zbb(obj, j6);
    }

    public static int zbc(Object obj, long j6) {
        return zbf.zba.getInt(obj, j6);
    }

    public static long zbd(Object obj, long j6) {
        return zbf.zba.getLong(obj, j6);
    }

    public static Object zbe(Class cls) {
        try {
            return zbc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Object zbf(Object obj, long j6) {
        return zbf.zba.getObject(obj, j6);
    }

    public static Unsafe zbg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zbwo());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* bridge */ /* synthetic */ void zbh(Throwable th) {
        Logger.getLogger(zbws.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    public static void zbm(Object obj, long j6, boolean z6) {
        zbf.zbc(obj, j6, z6);
    }

    public static void zbn(byte[] bArr, long j6, byte b) {
        zbf.zbd(bArr, zba + j6, b);
    }

    public static void zbo(Object obj, long j6, double d) {
        zbf.zbe(obj, j6, d);
    }

    public static void zbp(Object obj, long j6, float f6) {
        zbf.zbf(obj, j6, f6);
    }

    public static void zbq(Object obj, long j6, int i5) {
        zbf.zba.putInt(obj, j6, i5);
    }

    public static void zbr(Object obj, long j6, long j7) {
        zbf.zba.putLong(obj, j6, j7);
    }

    public static void zbs(Object obj, long j6, Object obj2) {
        zbf.zba.putObject(obj, j6, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean zbt(Object obj, long j6) {
        return ((byte) ((zbf.zba.getInt(obj, (-4) & j6) >>> ((int) (((~j6) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean zbu(Object obj, long j6) {
        return ((byte) ((zbf.zba.getInt(obj, (-4) & j6) >>> ((int) ((j6 & 3) << 3))) & 255)) != 0;
    }

    public static boolean zbv(Class cls) {
        int i5 = zbsm.zba;
        try {
            Class cls2 = zbd;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean zbw(Object obj, long j6) {
        return zbf.zbg(obj, j6);
    }

    public static boolean zbx() {
        return zbh;
    }

    public static boolean zby() {
        return zbg;
    }

    private static int zbz(Class cls) {
        if (zbh) {
            return zbf.zba.arrayBaseOffset(cls);
        }
        return -1;
    }
}
