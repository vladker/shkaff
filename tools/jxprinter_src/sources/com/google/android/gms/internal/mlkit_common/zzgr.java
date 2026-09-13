package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzgr implements ObjectEncoder {
    static final zzgr zza = new zzgr();
    private static final FieldDescriptor zzb = a.e(1, FieldDescriptor.builder("name"));
    private static final FieldDescriptor zzc = a.e(2, FieldDescriptor.builder("version"));
    private static final FieldDescriptor zzd = a.e(3, FieldDescriptor.builder(FirebaseAnalytics.Param.SOURCE));
    private static final FieldDescriptor zze = a.e(4, FieldDescriptor.builder("uri"));
    private static final FieldDescriptor zzf = a.e(5, FieldDescriptor.builder("hash"));
    private static final FieldDescriptor zzg = a.e(6, FieldDescriptor.builder("modelType"));
    private static final FieldDescriptor zzh = a.e(7, FieldDescriptor.builder("size"));
    private static final FieldDescriptor zzi = a.e(8, FieldDescriptor.builder("hasLabelMap"));
    private static final FieldDescriptor zzj = a.e(9, FieldDescriptor.builder("isManifestModel"));

    private zzgr() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        zznh zznhVar = (zznh) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zznhVar.zzd());
        objectEncoderContext2.add(zzc, (Object) null);
        objectEncoderContext2.add(zzd, zznhVar.zzb());
        objectEncoderContext2.add(zze, (Object) null);
        objectEncoderContext2.add(zzf, zznhVar.zzc());
        objectEncoderContext2.add(zzg, zznhVar.zza());
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, (Object) null);
        objectEncoderContext2.add(zzj, (Object) null);
    }
}
