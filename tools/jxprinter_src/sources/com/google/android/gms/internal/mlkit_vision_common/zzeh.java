package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeh implements ObjectEncoder {
    static final zzeh zza = new zzeh();
    private static final FieldDescriptor zzb = a.y(1, FieldDescriptor.builder("durationMs"));
    private static final FieldDescriptor zzc = a.y(2, FieldDescriptor.builder("errorCode"));
    private static final FieldDescriptor zzd = a.y(3, FieldDescriptor.builder("isColdCall"));
    private static final FieldDescriptor zze = a.y(4, FieldDescriptor.builder("autoManageModelOnBackground"));
    private static final FieldDescriptor zzf = a.y(5, FieldDescriptor.builder("autoManageModelOnLowMemory"));
    private static final FieldDescriptor zzg = a.y(6, FieldDescriptor.builder("isNnApiEnabled"));
    private static final FieldDescriptor zzh = a.y(7, FieldDescriptor.builder("eventsCount"));
    private static final FieldDescriptor zzi = a.y(8, FieldDescriptor.builder("otherErrors"));
    private static final FieldDescriptor zzj = a.y(9, FieldDescriptor.builder("remoteConfigValueForAcceleration"));
    private static final FieldDescriptor zzk = a.y(10, FieldDescriptor.builder("isAccelerated"));

    private zzeh() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        throw null;
    }
}
