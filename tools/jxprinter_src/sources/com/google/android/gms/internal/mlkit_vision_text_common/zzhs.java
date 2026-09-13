package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhs implements ObjectEncoder {
    static final zzhs zza = new zzhs();

    static {
        a.z(14, a.x(13, a.x(12, a.x(11, a.x(10, a.x(9, a.x(8, a.x(7, a.x(6, a.x(5, a.x(4, a.x(3, a.x(2, a.x(1, FieldDescriptor.builder(FirebaseAnalytics.Param.SOURCE), "appliedFilter"), "isAutoCaptureManuallyTriggered"), "isRotated"), "hasLowConfidenceProposedCorners"), "autoCaptureTriggerLatencyMs"), "galleryImportProcessingMs"), "imageWidth"), "imageHeight"), "proposedCorners"), "adjustedCorners"), "isShadowRemoved"), "numOfAppliedCleanUpStrokes"), "numOfAttemptedCleanUpStrokes"));
    }

    private zzhs() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        throw null;
    }
}
