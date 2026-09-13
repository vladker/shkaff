package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzid implements ObjectEncoder {
    static final zzid zza = new zzid();
    private static final FieldDescriptor zzb = a.B(1, FieldDescriptor.builder("durationMs"));
    private static final FieldDescriptor zzc = a.B(2, FieldDescriptor.builder("errorCode"));
    private static final FieldDescriptor zzd = a.B(3, FieldDescriptor.builder("isColdCall"));
    private static final FieldDescriptor zze = a.B(4, FieldDescriptor.builder("autoManageModelOnBackground"));
    private static final FieldDescriptor zzf = a.B(5, FieldDescriptor.builder("autoManageModelOnLowMemory"));
    private static final FieldDescriptor zzg = a.B(6, FieldDescriptor.builder("isNnApiEnabled"));
    private static final FieldDescriptor zzh = a.B(7, FieldDescriptor.builder("eventsCount"));
    private static final FieldDescriptor zzi = a.B(8, FieldDescriptor.builder("otherErrors"));
    private static final FieldDescriptor zzj = a.B(9, FieldDescriptor.builder("remoteConfigValueForAcceleration"));
    private static final FieldDescriptor zzk = a.B(10, FieldDescriptor.builder("isAccelerated"));

    private zzid() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        zzoj zzojVar = (zzoj) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzojVar.zze());
        objectEncoderContext2.add(zzc, zzojVar.zza());
        objectEncoderContext2.add(zzd, zzojVar.zzd());
        objectEncoderContext2.add(zze, zzojVar.zzb());
        objectEncoderContext2.add(zzf, zzojVar.zzc());
        objectEncoderContext2.add(zzg, (Object) null);
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, (Object) null);
        objectEncoderContext2.add(zzj, (Object) null);
        objectEncoderContext2.add(zzk, (Object) null);
    }
}
