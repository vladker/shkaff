package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzgu implements ObjectEncoder {
    static final zzgu zza = new zzgu();
    private static final FieldDescriptor zzb = a.y(1, FieldDescriptor.builder("appId"));
    private static final FieldDescriptor zzc = a.y(2, FieldDescriptor.builder("appVersion"));
    private static final FieldDescriptor zzd = a.y(3, FieldDescriptor.builder("firebaseProjectId"));
    private static final FieldDescriptor zze = a.y(4, FieldDescriptor.builder("mlSdkVersion"));
    private static final FieldDescriptor zzf = a.y(5, FieldDescriptor.builder("tfliteSchemaVersion"));
    private static final FieldDescriptor zzg = a.y(6, FieldDescriptor.builder("gcmSenderId"));
    private static final FieldDescriptor zzh = a.y(7, FieldDescriptor.builder("apiKey"));
    private static final FieldDescriptor zzi = a.y(8, FieldDescriptor.builder("languages"));
    private static final FieldDescriptor zzj = a.y(9, FieldDescriptor.builder("mlSdkInstanceId"));
    private static final FieldDescriptor zzk = a.y(10, FieldDescriptor.builder("isClearcutClient"));
    private static final FieldDescriptor zzl = a.y(11, FieldDescriptor.builder("isStandaloneMlkit"));
    private static final FieldDescriptor zzm = a.y(12, FieldDescriptor.builder("isJsonLogging"));
    private static final FieldDescriptor zzn = a.y(13, FieldDescriptor.builder("buildLevel"));
    private static final FieldDescriptor zzo = a.y(14, FieldDescriptor.builder("optionalModuleVersion"));

    private zzgu() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        zzla zzlaVar = (zzla) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzlaVar.zzg());
        objectEncoderContext2.add(zzc, zzlaVar.zzh());
        objectEncoderContext2.add(zzd, (Object) null);
        objectEncoderContext2.add(zze, zzlaVar.zzj());
        objectEncoderContext2.add(zzf, zzlaVar.zzk());
        objectEncoderContext2.add(zzg, (Object) null);
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, zzlaVar.zza());
        objectEncoderContext2.add(zzj, zzlaVar.zzi());
        objectEncoderContext2.add(zzk, zzlaVar.zzb());
        objectEncoderContext2.add(zzl, zzlaVar.zzd());
        objectEncoderContext2.add(zzm, zzlaVar.zzc());
        objectEncoderContext2.add(zzn, zzlaVar.zze());
        objectEncoderContext2.add(zzo, zzlaVar.zzf());
    }
}
