package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdr implements ObjectEncoder {
    static final zzdr zza = new zzdr();
    private static final FieldDescriptor zzb = a.y(1, FieldDescriptor.builder("remoteModelOptions"));
    private static final FieldDescriptor zzc = a.y(2, FieldDescriptor.builder("localModelOptions"));
    private static final FieldDescriptor zzd = a.y(3, FieldDescriptor.builder("errorCodes"));
    private static final FieldDescriptor zze = a.y(4, FieldDescriptor.builder("modelInitializationMs"));
    private static final FieldDescriptor zzf = a.y(5, FieldDescriptor.builder("isNnApiEnabled"));

    private zzdr() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        throw null;
    }
}
