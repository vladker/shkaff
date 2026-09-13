package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzid extends zzii {
    public zzid() {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzii
    public final void zza() {
        if (!zzj()) {
            for (int i5 = 0; i5 < zzc(); i5++) {
                Map.Entry entryZzg = zzg(i5);
                if (((zzie) entryZzg).zza().zze()) {
                    entryZzg.setValue(Collections.unmodifiableList((List) entryZzg.getValue()));
                }
            }
            for (Map.Entry entry : zzd()) {
                if (((zzgg) entry.getKey()).zze()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
