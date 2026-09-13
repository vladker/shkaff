package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkh implements ObjectEncoder {
    static final zzkh zza = new zzkh();
    private static final FieldDescriptor zzb = a.e(1, FieldDescriptor.builder("appId"));
    private static final FieldDescriptor zzc = a.e(2, FieldDescriptor.builder("appVersion"));
    private static final FieldDescriptor zzd = a.e(3, FieldDescriptor.builder("firebaseProjectId"));
    private static final FieldDescriptor zze = a.e(4, FieldDescriptor.builder("mlSdkVersion"));
    private static final FieldDescriptor zzf = a.e(5, FieldDescriptor.builder("tfliteSchemaVersion"));
    private static final FieldDescriptor zzg = a.e(6, FieldDescriptor.builder("gcmSenderId"));
    private static final FieldDescriptor zzh = a.e(7, FieldDescriptor.builder("apiKey"));
    private static final FieldDescriptor zzi = a.e(8, FieldDescriptor.builder("languages"));
    private static final FieldDescriptor zzj = a.e(9, FieldDescriptor.builder("mlSdkInstanceId"));
    private static final FieldDescriptor zzk = a.e(10, FieldDescriptor.builder("isClearcutClient"));
    private static final FieldDescriptor zzl = a.e(11, FieldDescriptor.builder("isStandaloneMlkit"));
    private static final FieldDescriptor zzm = a.e(12, FieldDescriptor.builder("isJsonLogging"));
    private static final FieldDescriptor zzn = a.e(13, FieldDescriptor.builder("buildLevel"));
    private static final FieldDescriptor zzo = a.e(14, FieldDescriptor.builder("optionalModuleVersion"));

    private zzkh() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        zzqv zzqvVar = (zzqv) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzqvVar.zzg());
        objectEncoderContext2.add(zzc, zzqvVar.zzh());
        objectEncoderContext2.add(zzd, (Object) null);
        objectEncoderContext2.add(zze, zzqvVar.zzj());
        objectEncoderContext2.add(zzf, zzqvVar.zzk());
        objectEncoderContext2.add(zzg, (Object) null);
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, zzqvVar.zza());
        objectEncoderContext2.add(zzj, zzqvVar.zzi());
        objectEncoderContext2.add(zzk, zzqvVar.zzb());
        objectEncoderContext2.add(zzl, zzqvVar.zzd());
        objectEncoderContext2.add(zzm, zzqvVar.zzc());
        objectEncoderContext2.add(zzn, zzqvVar.zze());
        objectEncoderContext2.add(zzo, zzqvVar.zzf());
    }
}
