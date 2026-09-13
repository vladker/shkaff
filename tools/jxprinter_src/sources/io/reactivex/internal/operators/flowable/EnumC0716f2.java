package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.f2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class EnumC0716f2 implements p027e3.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC0716f2 f4616a;
    public static final /* synthetic */ EnumC0716f2[] b;

    static {
        EnumC0716f2 enumC0716f2 = new EnumC0716f2("INSTANCE", 0);
        f4616a = enumC0716f2;
        b = new EnumC0716f2[]{enumC0716f2};
    }

    public static EnumC0716f2 valueOf(String str) {
        return (EnumC0716f2) Enum.valueOf(EnumC0716f2.class, str);
    }

    public static EnumC0716f2[] values() {
        return (EnumC0716f2[]) b.clone();
    }

    @Override // p027e3.g
    public void accept(t5.d dVar) {
        dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
    }
}
