package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzgk implements ObjectEncoder {
    static final zzgk zza = new zzgk();
    private static final FieldDescriptor zzb = a.B(1, FieldDescriptor.builder("errorCode"));
    private static final FieldDescriptor zzc = a.B(2, FieldDescriptor.builder("hasResult"));
    private static final FieldDescriptor zzd = a.B(3, FieldDescriptor.builder("isColdCall"));
    private static final FieldDescriptor zze = a.B(4, FieldDescriptor.builder("imageInfo"));
    private static final FieldDescriptor zzf = a.B(5, FieldDescriptor.builder("recognizerOptions"));

    private zzgk() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        zzes zzesVar = (zzes) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzesVar.zza());
        objectEncoderContext2.add(zzc, (Object) null);
        objectEncoderContext2.add(zzd, zzesVar.zzc());
        objectEncoderContext2.add(zze, (Object) null);
        objectEncoderContext2.add(zzf, zzesVar.zzb());
    }
}
