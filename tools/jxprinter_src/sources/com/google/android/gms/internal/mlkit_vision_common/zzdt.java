package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdt implements ObjectEncoder {
    static final zzdt zza = new zzdt();
    private static final FieldDescriptor zzb = a.y(1, FieldDescriptor.builder("sdkVersion"));
    private static final FieldDescriptor zzc = a.y(2, FieldDescriptor.builder("osBuild"));
    private static final FieldDescriptor zzd = a.y(3, FieldDescriptor.builder("brand"));
    private static final FieldDescriptor zze = a.y(4, FieldDescriptor.builder("device"));
    private static final FieldDescriptor zzf = a.y(5, FieldDescriptor.builder("hardware"));
    private static final FieldDescriptor zzg = a.y(6, FieldDescriptor.builder("manufacturer"));
    private static final FieldDescriptor zzh = a.y(7, FieldDescriptor.builder("model"));
    private static final FieldDescriptor zzi = a.y(8, FieldDescriptor.builder("product"));
    private static final FieldDescriptor zzj = a.y(9, FieldDescriptor.builder("soc"));
    private static final FieldDescriptor zzk = a.y(10, FieldDescriptor.builder("socMetaBuildId"));

    private zzdt() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        throw null;
    }
}
