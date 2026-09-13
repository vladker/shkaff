package com.google.android.gms.internal.play_billing;

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
final class zzix {
    static final boolean zza;
    private static final Unsafe zzb;
    private static final Class zzc;
    private static final boolean zzd;
    private static final zziw zze;
    private static final boolean zzf;

    static {
        boolean z6;
        zziw zziwVar;
        Unsafe unsafeZzg = zzg();
        zzb = unsafeZzg;
        int i5 = zzfc.zza;
        zzc = Memory.class;
        Class cls = Long.TYPE;
        boolean zZzs = zzs(cls);
        zzd = zZzs;
        Class cls2 = Integer.TYPE;
        boolean zZzs2 = zzs(cls2);
        zziw zziuVar = null;
        if (unsafeZzg != null) {
            if (zZzs) {
                zziuVar = new zziv(unsafeZzg);
            } else if (zZzs2) {
                zziuVar = new zziu(unsafeZzg);
            }
        }
        zze = zziuVar;
        if (zziuVar != null) {
            try {
                Class<?> cls3 = zziuVar.zza.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("getLong", Object.class, cls);
                zzw();
            } catch (Throwable th) {
                zzh(th);
            }
        }
        zziw zziwVar2 = zze;
        if (zziwVar2 == null) {
            z6 = false;
        } else {
            try {
                Class<?> cls4 = zziwVar2.zza.getClass();
                cls4.getMethod("objectFieldOffset", Field.class);
                cls4.getMethod("arrayBaseOffset", Class.class);
                cls4.getMethod("arrayIndexScale", Class.class);
                cls4.getMethod("getInt", Object.class, cls);
                cls4.getMethod("putInt", Object.class, cls, cls2);
                cls4.getMethod("getLong", Object.class, cls);
                cls4.getMethod("putLong", Object.class, cls, cls);
                cls4.getMethod("getObject", Object.class, cls);
                cls4.getMethod("putObject", Object.class, cls, Object.class);
                z6 = true;
            } catch (Throwable th2) {
                zzh(th2);
                z6 = false;
            }
        }
        zzf = z6;
        zzu(byte[].class);
        zzu(boolean[].class);
        zzv(boolean[].class);
        zzu(int[].class);
        zzv(int[].class);
        zzu(long[].class);
        zzv(long[].class);
        zzu(float[].class);
        zzv(float[].class);
        zzu(double[].class);
        zzv(double[].class);
        zzu(Object[].class);
        zzv(Object[].class);
        Field fieldZzw = zzw();
        if (fieldZzw != null && (zziwVar = zze) != null) {
            zziwVar.zza.objectFieldOffset(fieldZzw);
        }
        zza = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzix() {
    }

    public static double zza(Object obj, long j6) {
        return zze.zza(obj, j6);
    }

    public static float zzb(Object obj, long j6) {
        return zze.zzb(obj, j6);
    }

    public static int zzc(Object obj, long j6) {
        return zze.zza.getInt(obj, j6);
    }

    public static long zzd(Object obj, long j6) {
        return zze.zza.getLong(obj, j6);
    }

    public static Object zze(Class cls) {
        try {
            return zzb.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Object zzf(Object obj, long j6) {
        return zze.zza.getObject(obj, j6);
    }

    public static Unsafe zzg() {
        Unsafe unsafe;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new zzit());
        } catch (Throwable unused) {
            unsafe = null;
        }
        if (unsafe == null) {
            return null;
        }
        try {
            unsafe.arrayBaseOffset(byte[].class);
            return unsafe;
        } catch (Exception unused2) {
            Logger.getLogger(zzix.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "getUnsafe", "As part of the planned removal, sun.misc.Unsafe is available in the current environment but configured to throw on use. Protobuf will continue without using it, but with slightly reduced performance. --sun-misc-unsafe-memory-access=allow is likely available to opt back in if desired. A later Protobuf version release will stop using sun.misc.Unsafe entirely.");
            return null;
        }
    }

    public static /* bridge */ /* synthetic */ void zzh(Throwable th) {
        Logger.getLogger(zzix.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    public static /* synthetic */ void zzi(Object obj, long j6, boolean z6) {
        Unsafe unsafe = zze.zza;
        long j7 = (-4) & j6;
        int i5 = unsafe.getInt(obj, j7);
        int i6 = ((~((int) j6)) & 3) << 3;
        unsafe.putInt(obj, j7, ((z6 ? 1 : 0) << i6) | ((~(255 << i6)) & i5));
    }

    public static /* synthetic */ void zzj(Object obj, long j6, boolean z6) {
        Unsafe unsafe = zze.zza;
        long j7 = (-4) & j6;
        int i5 = (((int) j6) & 3) << 3;
        unsafe.putInt(obj, j7, ((z6 ? 1 : 0) << i5) | ((~(255 << i5)) & unsafe.getInt(obj, j7)));
    }

    public static void zzk(Object obj, long j6, boolean z6) {
        zze.zzc(obj, j6, z6);
    }

    public static void zzl(Object obj, long j6, double d) {
        zze.zzd(obj, j6, d);
    }

    public static void zzm(Object obj, long j6, float f6) {
        zze.zze(obj, j6, f6);
    }

    public static void zzn(Object obj, long j6, int i5) {
        zze.zza.putInt(obj, j6, i5);
    }

    public static void zzo(Object obj, long j6, long j7) {
        zze.zza.putLong(obj, j6, j7);
    }

    public static void zzp(Object obj, long j6, Object obj2) {
        zze.zza.putObject(obj, j6, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean zzq(Object obj, long j6) {
        return ((byte) ((zze.zza.getInt(obj, (-4) & j6) >>> ((int) (((~j6) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean zzr(Object obj, long j6) {
        return ((byte) ((zze.zza.getInt(obj, (-4) & j6) >>> ((int) ((j6 & 3) << 3))) & 255)) != 0;
    }

    public static boolean zzs(Class cls) {
        int i5 = zzfc.zza;
        try {
            Class cls2 = zzc;
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

    public static boolean zzt(Object obj, long j6) {
        return zze.zzf(obj, j6);
    }

    private static int zzu(Class cls) {
        if (zzf) {
            return zze.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzv(Class cls) {
        if (zzf) {
            return zze.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zzw() {
        int i5 = zzfc.zza;
        Field fieldZzx = zzx(Buffer.class, "effectiveDirectAddress");
        if (fieldZzx != null) {
            return fieldZzx;
        }
        Field fieldZzx2 = zzx(Buffer.class, "address");
        if (fieldZzx2 == null || fieldZzx2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzx2;
    }

    private static Field zzx(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
