package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbt implements ObjectEncoder {
    static final zzbt zza = new zzbt();
    private static final FieldDescriptor zzb = a.y(1, FieldDescriptor.builder("durationMs"));
    private static final FieldDescriptor zzc = a.y(2, FieldDescriptor.builder("handledErrors"));
    private static final FieldDescriptor zzd = a.y(3, FieldDescriptor.builder("partiallyHandledErrors"));
    private static final FieldDescriptor zze = a.y(4, FieldDescriptor.builder("unhandledErrors"));
    private static final FieldDescriptor zzf = a.y(5, FieldDescriptor.builder("modelNamespace"));
    private static final FieldDescriptor zzg = a.y(6, FieldDescriptor.builder("delegateFilter"));
    private static final FieldDescriptor zzh = a.y(7, FieldDescriptor.builder("httpResponseCode"));

    private zzbt() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        throw null;
    }
}
