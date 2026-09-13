package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
enum zzb {
    RESPONSE_CODE_UNSPECIFIED(-999),
    SERVICE_TIMEOUT(-3),
    FEATURE_NOT_SUPPORTED(-2),
    SERVICE_DISCONNECTED(-1),
    OK(0),
    USER_CANCELED(1),
    SERVICE_UNAVAILABLE(2),
    BILLING_UNAVAILABLE(3),
    ITEM_UNAVAILABLE(4),
    DEVELOPER_ERROR(5),
    ERROR(6),
    ITEM_ALREADY_OWNED(7),
    ITEM_NOT_OWNED(8),
    EXPIRED_OFFER_TOKEN(11),
    NETWORK_ERROR(12);

    private static final zzcd zzp;
    private final int zzr;

    static {
        zzcc zzccVar = new zzcc();
        for (zzb zzbVar : values()) {
            zzccVar.zza(Integer.valueOf(zzbVar.zzr), zzbVar);
        }
        zzp = zzccVar.zzb();
    }

    zzb(int i5) {
        this.zzr = i5;
    }

    public static zzb zza(int i5) {
        zzcd zzcdVar = zzp;
        Integer numValueOf = Integer.valueOf(i5);
        return !zzcdVar.containsKey(numValueOf) ? RESPONSE_CODE_UNSPECIFIED : (zzb) zzcdVar.get(numValueOf);
    }
}
