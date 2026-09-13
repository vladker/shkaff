package com.bumptech.glide;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f3184a;
    public static final o b;
    public static final o c;
    public static final o d;
    public static final /* synthetic */ o[] e;

    static {
        o oVar = new o("IMMEDIATE", 0);
        f3184a = oVar;
        o oVar2 = new o("HIGH", 1);
        b = oVar2;
        o oVar3 = new o("NORMAL", 2);
        c = oVar3;
        o oVar4 = new o("LOW", 3);
        d = oVar4;
        e = new o[]{oVar, oVar2, oVar3, oVar4};
    }

    public static o valueOf(String str) {
        return (o) Enum.valueOf(o.class, str);
    }

    public static o[] values() {
        return (o[]) e.clone();
    }
}
