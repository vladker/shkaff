package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzon implements ObjectEncoder {
    static final zzon zza = new zzon();
    private static final FieldDescriptor zzb = com.google.android.gms.auth.api.accounttransfer.a.t(1, FieldDescriptor.builder("appId"));
    private static final FieldDescriptor zzc = com.google.android.gms.auth.api.accounttransfer.a.t(2, FieldDescriptor.builder("appVersion"));
    private static final FieldDescriptor zzd = com.google.android.gms.auth.api.accounttransfer.a.t(3, FieldDescriptor.builder("firebaseProjectId"));
    private static final FieldDescriptor zze = com.google.android.gms.auth.api.accounttransfer.a.t(4, FieldDescriptor.builder("mlSdkVersion"));
    private static final FieldDescriptor zzf = com.google.android.gms.auth.api.accounttransfer.a.t(5, FieldDescriptor.builder("tfliteSchemaVersion"));
    private static final FieldDescriptor zzg = com.google.android.gms.auth.api.accounttransfer.a.t(6, FieldDescriptor.builder("gcmSenderId"));
    private static final FieldDescriptor zzh = com.google.android.gms.auth.api.accounttransfer.a.t(7, FieldDescriptor.builder("apiKey"));
    private static final FieldDescriptor zzi = com.google.android.gms.auth.api.accounttransfer.a.t(8, FieldDescriptor.builder("languages"));
    private static final FieldDescriptor zzj = com.google.android.gms.auth.api.accounttransfer.a.t(9, FieldDescriptor.builder("mlSdkInstanceId"));
    private static final FieldDescriptor zzk = com.google.android.gms.auth.api.accounttransfer.a.t(10, FieldDescriptor.builder("isClearcutClient"));
    private static final FieldDescriptor zzl = com.google.android.gms.auth.api.accounttransfer.a.t(11, FieldDescriptor.builder("isStandaloneMlkit"));
    private static final FieldDescriptor zzm = com.google.android.gms.auth.api.accounttransfer.a.t(12, FieldDescriptor.builder("isJsonLogging"));
    private static final FieldDescriptor zzn = com.google.android.gms.auth.api.accounttransfer.a.t(13, FieldDescriptor.builder("buildLevel"));
    private static final FieldDescriptor zzo = com.google.android.gms.auth.api.accounttransfer.a.t(14, FieldDescriptor.builder("optionalModuleVersion"));

    private zzon() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        zzvd zzvdVar = (zzvd) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzvdVar.zzg());
        objectEncoderContext2.add(zzc, zzvdVar.zzh());
        objectEncoderContext2.add(zzd, (Object) null);
        objectEncoderContext2.add(zze, zzvdVar.zzj());
        objectEncoderContext2.add(zzf, zzvdVar.zzk());
        objectEncoderContext2.add(zzg, (Object) null);
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, zzvdVar.zza());
        objectEncoderContext2.add(zzj, zzvdVar.zzi());
        objectEncoderContext2.add(zzk, zzvdVar.zzb());
        objectEncoderContext2.add(zzl, zzvdVar.zzd());
        objectEncoderContext2.add(zzm, zzvdVar.zzc());
        objectEncoderContext2.add(zzn, zzvdVar.zze());
        objectEncoderContext2.add(zzo, zzvdVar.zzf());
    }
}
