package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzht implements ObjectEncoder {
    static final zzht zza = new zzht();
    private static final FieldDescriptor zzb = a.B(1, FieldDescriptor.builder("maxMs"));
    private static final FieldDescriptor zzc = a.B(2, FieldDescriptor.builder("minMs"));
    private static final FieldDescriptor zzd = a.B(3, FieldDescriptor.builder("avgMs"));
    private static final FieldDescriptor zze = a.B(4, FieldDescriptor.builder("firstQuartileMs"));
    private static final FieldDescriptor zzf = a.B(5, FieldDescriptor.builder("medianMs"));
    private static final FieldDescriptor zzg = a.B(6, FieldDescriptor.builder("thirdQuartileMs"));

    private zzht() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        zznw zznwVar = (zznw) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zznwVar.zzc());
        objectEncoderContext2.add(zzc, zznwVar.zze());
        objectEncoderContext2.add(zzd, zznwVar.zza());
        objectEncoderContext2.add(zze, zznwVar.zzb());
        objectEncoderContext2.add(zzf, zznwVar.zzd());
        objectEncoderContext2.add(zzg, zznwVar.zzf());
    }
}
