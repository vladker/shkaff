package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjx extends zzgp implements zzhs {
    private static final zzjx zzb;

    static {
        zzjx zzjxVar = new zzjx();
        zzb = zzjxVar;
        zzgp.zzB(zzjx.class, zzjxVar);
    }

    private zzjx() {
    }

    public static zzjx zzb() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    public final Object zzd(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        zzjw zzjwVar = null;
        if (i6 == 2) {
            return zzgp.zzy(zzb, "\u0004\u0000", null);
        }
        if (i6 == 3) {
            return new zzjx();
        }
        if (i6 == 4) {
            return new zzjv(zzjwVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        throw null;
    }
}
