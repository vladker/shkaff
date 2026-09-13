package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzjy implements zzgs {
    static final zzgs zza = new zzjy();

    private zzjy() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzgs
    public final boolean zza(int i5) {
        zzjz zzjzVar;
        if (i5 == 0) {
            zzjzVar = zzjz.BROADCAST_ACTION_UNSPECIFIED;
        } else if (i5 == 1) {
            zzjzVar = zzjz.PURCHASES_UPDATED_ACTION;
        } else if (i5 == 2) {
            zzjzVar = zzjz.LOCAL_PURCHASES_UPDATED_ACTION;
        } else if (i5 == 3) {
            zzjzVar = zzjz.ALTERNATIVE_BILLING_ACTION;
        } else if (i5 != 4) {
            zzjzVar = i5 != 5 ? null : zzjz.PLAY_BILLING_ACTIVITY_CREATED_ACTION;
        } else {
            zzjzVar = zzjz.IN_APP_BILLING_RESULT_UPDATE_ACTION;
        }
        return zzjzVar != null;
    }
}
