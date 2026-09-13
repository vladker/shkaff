package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeq implements ObjectEncoder {
    static final zzeq zza = new zzeq();
    private static final FieldDescriptor zzb = a.y(1, FieldDescriptor.builder("name"));
    private static final FieldDescriptor zzc = a.y(2, FieldDescriptor.builder("version"));
    private static final FieldDescriptor zzd = a.y(3, FieldDescriptor.builder(FirebaseAnalytics.Param.SOURCE));
    private static final FieldDescriptor zze = a.y(4, FieldDescriptor.builder("uri"));
    private static final FieldDescriptor zzf = a.y(5, FieldDescriptor.builder("hash"));
    private static final FieldDescriptor zzg = a.y(6, FieldDescriptor.builder("modelType"));
    private static final FieldDescriptor zzh = a.y(7, FieldDescriptor.builder("size"));
    private static final FieldDescriptor zzi = a.y(8, FieldDescriptor.builder("hasLabelMap"));
    private static final FieldDescriptor zzj = a.y(9, FieldDescriptor.builder("isManifestModel"));

    private zzeq() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        throw null;
    }
}
