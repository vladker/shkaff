package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkl implements ObjectEncoder {
    static final zzkl zza = new zzkl();

    static {
        com.google.android.gms.auth.api.accounttransfer.a.u(2, com.google.android.gms.auth.api.accounttransfer.a.s(1, FieldDescriptor.builder(FirebaseAnalytics.Param.SOURCE), "errorCode"));
    }

    private zzkl() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        throw null;
    }
}
