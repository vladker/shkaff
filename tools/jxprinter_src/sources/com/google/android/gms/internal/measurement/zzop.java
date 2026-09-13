package com.google.android.gms.internal.measurement;

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
final class zzop {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd;
    private static final boolean zze;
    private static final zzoo zzf;
    private static final boolean zzg;
    private static final boolean zzh;

    /* JADX WARN: Code duplicated, block: B:11:0x003d  */
    static {
        boolean z6;
        boolean z7;
        zzoo zzooVar;
        Unsafe unsafeZzq = zzq();
        zzc = unsafeZzq;
        int i5 = zzkv.zza;
        zzd = Memory.class;
        Class cls = Long.TYPE;
        boolean zZzr = zzr(cls);
        zze = zZzr;
        Class cls2 = Integer.TYPE;
        boolean zZzr2 = zzr(cls2);
        zzoo zzomVar = null;
        if (unsafeZzq != null) {
            if (zZzr) {
                zzomVar = new zzon(unsafeZzq);
            } else if (zZzr2) {
                zzomVar = new zzom(unsafeZzq);
            }
        }
        zzf = zzomVar;
        if (zzomVar == null) {
            z6 = false;
        } else {
            try {
                Class<?> cls3 = zzomVar.zza.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("getLong", Object.class, cls);
                if (zzB() == null) {
                    z6 = false;
                } else {
                    z6 = true;
                }
            } catch (Throwable th) {
                zzy(th);
            }
        }
        zzg = z6;
        zzoo zzooVar2 = zzf;
        if (zzooVar2 == null) {
            z7 = false;
        } else {
            try {
                Class<?> cls4 = zzooVar2.zza.getClass();
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
                zzy(th2);
                z7 = false;
            }
        }
        zzh = z7;
        zza = zzz(byte[].class);
        zzz(boolean[].class);
        zzA(boolean[].class);
        zzz(int[].class);
        zzA(int[].class);
        zzz(long[].class);
        zzA(long[].class);
        zzz(float[].class);
        zzA(float[].class);
        zzz(double[].class);
        zzA(double[].class);
        zzz(Object[].class);
        zzA(Object[].class);
        Field fieldZzB = zzB();
        if (fieldZzB != null && (zzooVar = zzf) != null) {
            zzooVar.zza.objectFieldOffset(fieldZzB);
        }
        zzb = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzop() {
    }

    private static int zzA(Class cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zzB() {
        int i5 = zzkv.zza;
        Field fieldZzC = zzC(Buffer.class, "effectiveDirectAddress");
        if (fieldZzC != null) {
            return fieldZzC;
        }
        Field fieldZzC2 = zzC(Buffer.class, "address");
        if (fieldZzC2 == null || fieldZzC2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzC2;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzD(Object obj, long j6, byte b) {
        Unsafe unsafe = zzf.zza;
        long j7 = (-4) & j6;
        int i5 = unsafe.getInt(obj, j7);
        int i6 = ((~((int) j6)) & 3) << 3;
        unsafe.putInt(obj, j7, ((255 & b) << i6) | (i5 & (~(255 << i6))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzE(Object obj, long j6, byte b) {
        Unsafe unsafe = zzf.zza;
        long j7 = (-4) & j6;
        int i5 = (((int) j6) & 3) << 3;
        unsafe.putInt(obj, j7, ((255 & b) << i5) | (unsafe.getInt(obj, j7) & (~(255 << i5))));
    }

    public static boolean zza() {
        return zzh;
    }

    public static boolean zzb() {
        return zzg;
    }

    public static Object zzc(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static int zzd(Object obj, long j6) {
        return zzf.zza.getInt(obj, j6);
    }

    public static void zze(Object obj, long j6, int i5) {
        zzf.zza.putInt(obj, j6, i5);
    }

    public static long zzf(Object obj, long j6) {
        return zzf.zza.getLong(obj, j6);
    }

    public static void zzg(Object obj, long j6, long j7) {
        zzf.zza.putLong(obj, j6, j7);
    }

    public static boolean zzh(Object obj, long j6) {
        return zzf.zzb(obj, j6);
    }

    public static void zzi(Object obj, long j6, boolean z6) {
        zzf.zzc(obj, j6, z6);
    }

    public static float zzj(Object obj, long j6) {
        return zzf.zzd(obj, j6);
    }

    public static void zzk(Object obj, long j6, float f6) {
        zzf.zze(obj, j6, f6);
    }

    public static double zzl(Object obj, long j6) {
        return zzf.zzf(obj, j6);
    }

    public static void zzm(Object obj, long j6, double d) {
        zzf.zzg(obj, j6, d);
    }

    public static Object zzn(Object obj, long j6) {
        return zzf.zza.getObject(obj, j6);
    }

    public static void zzo(Object obj, long j6, Object obj2) {
        zzf.zza.putObject(obj, j6, obj2);
    }

    public static void zzp(byte[] bArr, long j6, byte b) {
        zzf.zza(bArr, zza + j6, b);
    }

    public static Unsafe zzq() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzol());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean zzr(Class cls) {
        int i5 = zzkv.zza;
        try {
            Class cls2 = zzd;
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

    public static /* synthetic */ boolean zzu(Object obj, long j6) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j6) >>> ((int) (((~j6) & 3) << 3))) & 255)) != 0;
    }

    public static /* synthetic */ boolean zzv(Object obj, long j6) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j6) >>> ((int) ((j6 & 3) << 3))) & 255)) != 0;
    }

    public static /* synthetic */ void zzy(Throwable th) {
        Logger.getLogger(zzop.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    private static int zzz(Class cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }
}
