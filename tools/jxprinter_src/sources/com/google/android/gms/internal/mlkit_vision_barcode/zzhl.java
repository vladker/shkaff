package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhl implements ObjectEncoder {
    static final zzhl zza = new zzhl();
    private static final FieldDescriptor zzb = com.google.android.gms.auth.api.accounttransfer.a.t(1, FieldDescriptor.builder("errorCode"));
    private static final FieldDescriptor zzc = com.google.android.gms.auth.api.accounttransfer.a.t(2, FieldDescriptor.builder("hasResult"));
    private static final FieldDescriptor zzd = com.google.android.gms.auth.api.accounttransfer.a.t(3, FieldDescriptor.builder("isColdCall"));
    private static final FieldDescriptor zze = com.google.android.gms.auth.api.accounttransfer.a.t(4, FieldDescriptor.builder("imageInfo"));
    private static final FieldDescriptor zzf = com.google.android.gms.auth.api.accounttransfer.a.t(5, FieldDescriptor.builder("options"));
    private static final FieldDescriptor zzg = com.google.android.gms.auth.api.accounttransfer.a.t(6, FieldDescriptor.builder("detectedBarcodeFormats"));
    private static final FieldDescriptor zzh = com.google.android.gms.auth.api.accounttransfer.a.t(7, FieldDescriptor.builder("detectedBarcodeValueTypes"));

    private zzhl() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        zzft zzftVar = (zzft) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzftVar.zzc());
        objectEncoderContext2.add(zzc, (Object) null);
        objectEncoderContext2.add(zzd, zzftVar.zze());
        objectEncoderContext2.add(zze, (Object) null);
        objectEncoderContext2.add(zzf, zzftVar.zzd());
        objectEncoderContext2.add(zzg, zzftVar.zza());
        objectEncoderContext2.add(zzh, zzftVar.zzb());
    }
}
