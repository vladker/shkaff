package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkk implements ObjectEncoder {
    static final zzkk zza = new zzkk();
    private static final FieldDescriptor zzb = com.google.android.gms.auth.api.accounttransfer.a.t(1, FieldDescriptor.builder("durationMs"));
    private static final FieldDescriptor zzc = com.google.android.gms.auth.api.accounttransfer.a.t(2, FieldDescriptor.builder("errorCode"));
    private static final FieldDescriptor zzd = com.google.android.gms.auth.api.accounttransfer.a.t(3, FieldDescriptor.builder("isColdCall"));
    private static final FieldDescriptor zze = com.google.android.gms.auth.api.accounttransfer.a.t(4, FieldDescriptor.builder("autoManageModelOnBackground"));
    private static final FieldDescriptor zzf = com.google.android.gms.auth.api.accounttransfer.a.t(5, FieldDescriptor.builder("autoManageModelOnLowMemory"));
    private static final FieldDescriptor zzg = com.google.android.gms.auth.api.accounttransfer.a.t(6, FieldDescriptor.builder("isNnApiEnabled"));
    private static final FieldDescriptor zzh = com.google.android.gms.auth.api.accounttransfer.a.t(7, FieldDescriptor.builder("eventsCount"));
    private static final FieldDescriptor zzi = com.google.android.gms.auth.api.accounttransfer.a.t(8, FieldDescriptor.builder("otherErrors"));
    private static final FieldDescriptor zzj = com.google.android.gms.auth.api.accounttransfer.a.t(9, FieldDescriptor.builder("remoteConfigValueForAcceleration"));
    private static final FieldDescriptor zzk = com.google.android.gms.auth.api.accounttransfer.a.t(10, FieldDescriptor.builder("isAccelerated"));

    private zzkk() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        zzqq zzqqVar = (zzqq) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzqqVar.zze());
        objectEncoderContext2.add(zzc, zzqqVar.zza());
        objectEncoderContext2.add(zzd, zzqqVar.zzd());
        objectEncoderContext2.add(zze, zzqqVar.zzb());
        objectEncoderContext2.add(zzf, zzqqVar.zzc());
        objectEncoderContext2.add(zzg, (Object) null);
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, (Object) null);
        objectEncoderContext2.add(zzj, (Object) null);
        objectEncoderContext2.add(zzk, (Object) null);
    }
}
