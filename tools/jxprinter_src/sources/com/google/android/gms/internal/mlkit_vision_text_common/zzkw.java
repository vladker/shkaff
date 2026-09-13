package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkw implements ObjectEncoder {
    static final zzkw zza = new zzkw();

    static {
        a.z(6, a.x(5, a.x(4, a.x(3, a.x(2, a.x(1, FieldDescriptor.builder("detectorMode"), "multipleObjectsEnabled"), "classificationEnabled"), "maxPerObjectLabelCount"), "classificationConfidenceThreshold"), "customLocalModelOptions"));
    }

    private zzkw() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        throw null;
    }
}
