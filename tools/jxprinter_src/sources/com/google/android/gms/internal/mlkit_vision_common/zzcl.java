package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcl implements ObjectEncoder {
    static final zzcl zza = new zzcl();
    private static final FieldDescriptor zzb = a.y(1, FieldDescriptor.builder("errorCode"));
    private static final FieldDescriptor zzc = a.y(2, FieldDescriptor.builder("imageInfo"));
    private static final FieldDescriptor zzd = a.y(3, FieldDescriptor.builder("isColdCall"));
    private static final FieldDescriptor zze = a.y(4, FieldDescriptor.builder("options"));

    private zzcl() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        throw null;
    }
}
