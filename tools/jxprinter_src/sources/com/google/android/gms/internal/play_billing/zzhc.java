package com.google.android.gms.internal.play_billing;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzb' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzhc {
    public static final zzhc zza;
    public static final zzhc zzb;
    public static final zzhc zzc;
    public static final zzhc zzd;
    public static final zzhc zze;
    public static final zzhc zzf;
    public static final zzhc zzg;
    public static final zzhc zzh;
    public static final zzhc zzi;
    public static final zzhc zzj;
    private static final /* synthetic */ zzhc[] zzk;
    private final Class zzl;

    static {
        zzhc zzhcVar = new zzhc("VOID", 0, Void.class, Void.class, null);
        zza = zzhcVar;
        Class cls = Integer.TYPE;
        zzhc zzhcVar2 = new zzhc("INT", 1, cls, Integer.class, 0);
        zzb = zzhcVar2;
        zzhc zzhcVar3 = new zzhc("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzhcVar3;
        zzhc zzhcVar4 = new zzhc("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzhcVar4;
        zzhc zzhcVar5 = new zzhc("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzhcVar5;
        zzhc zzhcVar6 = new zzhc("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzhcVar6;
        zzhc zzhcVar7 = new zzhc("STRING", 6, String.class, String.class, "");
        zzg = zzhcVar7;
        zzhc zzhcVar8 = new zzhc("BYTE_STRING", 7, zzfp.class, zzfp.class, zzfp.zza);
        zzh = zzhcVar8;
        zzhc zzhcVar9 = new zzhc("ENUM", 8, cls, Integer.class, null);
        zzi = zzhcVar9;
        zzhc zzhcVar10 = new zzhc("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzhcVar10;
        zzk = new zzhc[]{zzhcVar, zzhcVar2, zzhcVar3, zzhcVar4, zzhcVar5, zzhcVar6, zzhcVar7, zzhcVar8, zzhcVar9, zzhcVar10};
    }

    private zzhc(String str, int i5, Class cls, Class cls2, Object obj) {
        super(str, i5);
        this.zzl = cls2;
    }

    public static zzhc[] values() {
        return (zzhc[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzl;
    }
}
