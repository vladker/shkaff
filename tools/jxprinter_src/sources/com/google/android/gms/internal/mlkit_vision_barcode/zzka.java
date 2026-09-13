package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzka implements ObjectEncoder {
    static final zzka zza = new zzka();
    private static final FieldDescriptor zzb = com.google.android.gms.auth.api.accounttransfer.a.t(1, FieldDescriptor.builder("maxMs"));
    private static final FieldDescriptor zzc = com.google.android.gms.auth.api.accounttransfer.a.t(2, FieldDescriptor.builder("minMs"));
    private static final FieldDescriptor zzd = com.google.android.gms.auth.api.accounttransfer.a.t(3, FieldDescriptor.builder("avgMs"));
    private static final FieldDescriptor zze = com.google.android.gms.auth.api.accounttransfer.a.t(4, FieldDescriptor.builder("firstQuartileMs"));
    private static final FieldDescriptor zzf = com.google.android.gms.auth.api.accounttransfer.a.t(5, FieldDescriptor.builder("medianMs"));
    private static final FieldDescriptor zzg = com.google.android.gms.auth.api.accounttransfer.a.t(6, FieldDescriptor.builder("thirdQuartileMs"));

    private zzka() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        zzqd zzqdVar = (zzqd) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzqdVar.zzc());
        objectEncoderContext2.add(zzc, zzqdVar.zze());
        objectEncoderContext2.add(zzd, zzqdVar.zza());
        objectEncoderContext2.add(zze, zzqdVar.zzb());
        objectEncoderContext2.add(zzf, zzqdVar.zzd());
        objectEncoderContext2.add(zzg, zzqdVar.zzf());
    }
}
