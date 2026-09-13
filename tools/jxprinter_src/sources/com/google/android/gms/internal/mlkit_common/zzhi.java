package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhi implements ObjectEncoder {
    static final zzhi zza = new zzhi();

    static {
        a.m(6, a.d(5, a.d(4, a.d(3, a.d(2, a.d(1, FieldDescriptor.builder("totalStrokeCount"), "totalPointCount"), "addedStrokeCount"), "addedPointCount"), "removedStrokeCount"), "removedPointCount"));
    }

    private zzhi() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        throw null;
    }
}
