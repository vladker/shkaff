package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkg implements ObjectEncoder {
    static final zzkg zza = new zzkg();
    private static final FieldDescriptor zzb = com.google.android.gms.auth.api.accounttransfer.a.t(1, FieldDescriptor.builder("imageFormat"));
    private static final FieldDescriptor zzc = com.google.android.gms.auth.api.accounttransfer.a.t(2, FieldDescriptor.builder("originalImageSize"));
    private static final FieldDescriptor zzd = com.google.android.gms.auth.api.accounttransfer.a.t(3, FieldDescriptor.builder("compressedImageSize"));
    private static final FieldDescriptor zze = com.google.android.gms.auth.api.accounttransfer.a.t(4, FieldDescriptor.builder("isOdmlImage"));

    private zzkg() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        zzqk zzqkVar = (zzqk) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzqkVar.zza());
        objectEncoderContext2.add(zzc, zzqkVar.zzb());
        objectEncoderContext2.add(zzd, (Object) null);
        objectEncoderContext2.add(zze, (Object) null);
    }
}
