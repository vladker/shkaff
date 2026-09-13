package com.google.android.gms.internal.play_billing;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzc' uses external variables
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
public final class zzjg {
    public static final zzjg zza;
    public static final zzjg zzb;
    public static final zzjg zzc;
    public static final zzjg zzd;
    public static final zzjg zze;
    public static final zzjg zzf;
    public static final zzjg zzg;
    public static final zzjg zzh;
    public static final zzjg zzi;
    public static final zzjg zzj;
    public static final zzjg zzk;
    public static final zzjg zzl;
    public static final zzjg zzm;
    public static final zzjg zzn;
    public static final zzjg zzo;
    public static final zzjg zzp;
    public static final zzjg zzq;
    public static final zzjg zzr;
    private static final /* synthetic */ zzjg[] zzs;
    private final zzjh zzt;
    private final int zzu;

    static {
        zzjg zzjgVar = new zzjg("DOUBLE", 0, zzjh.DOUBLE, 1);
        zza = zzjgVar;
        zzjg zzjgVar2 = new zzjg("FLOAT", 1, zzjh.FLOAT, 5);
        zzb = zzjgVar2;
        zzjh zzjhVar = zzjh.LONG;
        zzjg zzjgVar3 = new zzjg("INT64", 2, zzjhVar, 0);
        zzc = zzjgVar3;
        zzjg zzjgVar4 = new zzjg("UINT64", 3, zzjhVar, 0);
        zzd = zzjgVar4;
        zzjh zzjhVar2 = zzjh.INT;
        zzjg zzjgVar5 = new zzjg("INT32", 4, zzjhVar2, 0);
        zze = zzjgVar5;
        zzjg zzjgVar6 = new zzjg("FIXED64", 5, zzjhVar, 1);
        zzf = zzjgVar6;
        zzjg zzjgVar7 = new zzjg("FIXED32", 6, zzjhVar2, 5);
        zzg = zzjgVar7;
        zzjg zzjgVar8 = new zzjg("BOOL", 7, zzjh.BOOLEAN, 0);
        zzh = zzjgVar8;
        zzjg zzjgVar9 = new zzjg("STRING", 8, zzjh.STRING, 2);
        zzi = zzjgVar9;
        zzjh zzjhVar3 = zzjh.MESSAGE;
        zzjg zzjgVar10 = new zzjg("GROUP", 9, zzjhVar3, 3);
        zzj = zzjgVar10;
        zzjg zzjgVar11 = new zzjg("MESSAGE", 10, zzjhVar3, 2);
        zzk = zzjgVar11;
        zzjg zzjgVar12 = new zzjg("BYTES", 11, zzjh.BYTE_STRING, 2);
        zzl = zzjgVar12;
        zzjg zzjgVar13 = new zzjg("UINT32", 12, zzjhVar2, 0);
        zzm = zzjgVar13;
        zzjg zzjgVar14 = new zzjg("ENUM", 13, zzjh.ENUM, 0);
        zzn = zzjgVar14;
        zzjg zzjgVar15 = new zzjg("SFIXED32", 14, zzjhVar2, 5);
        zzo = zzjgVar15;
        zzjg zzjgVar16 = new zzjg("SFIXED64", 15, zzjhVar, 1);
        zzp = zzjgVar16;
        zzjg zzjgVar17 = new zzjg("SINT32", 16, zzjhVar2, 0);
        zzq = zzjgVar17;
        zzjg zzjgVar18 = new zzjg("SINT64", 17, zzjhVar, 0);
        zzr = zzjgVar18;
        zzs = new zzjg[]{zzjgVar, zzjgVar2, zzjgVar3, zzjgVar4, zzjgVar5, zzjgVar6, zzjgVar7, zzjgVar8, zzjgVar9, zzjgVar10, zzjgVar11, zzjgVar12, zzjgVar13, zzjgVar14, zzjgVar15, zzjgVar16, zzjgVar17, zzjgVar18};
    }

    private zzjg(String str, int i5, zzjh zzjhVar, int i6) {
        super(str, i5);
        this.zzt = zzjhVar;
        this.zzu = i6;
    }

    public static zzjg[] values() {
        return (zzjg[]) zzs.clone();
    }

    public final int zza() {
        return this.zzu;
    }

    public final zzjh zzb() {
        return this.zzt;
    }
}
