package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeb;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class zzeb<MessageType extends zzeh<MessageType, BuilderType>, BuilderType extends zzeb<MessageType, BuilderType>> extends zzcp<MessageType, BuilderType> {
    protected zzeh zza;
    private final zzeh zzb;

    public zzeb(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzY()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzK();
    }

    private static void zza(Object obj, Object obj2) {
        zzfu.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn
    public final /* bridge */ /* synthetic */ zzfm zzac() {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn
    public final boolean zzad() {
        return zzeh.zzX(this.zza, false);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcp
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzeb clone() {
        zzeb zzebVar = (zzeb) this.zzb.zzg(5, null, null);
        zzebVar.zza = zzk();
        return zzebVar;
    }

    public final zzeb zzg(zzeh zzehVar) {
        if (!this.zzb.equals(zzehVar)) {
            if (!this.zza.zzY()) {
                zzn();
            }
            zza(this.zza, zzehVar);
        }
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfl
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final MessageType zzj() {
        MessageType messagetype = (MessageType) zzk();
        if (zzeh.zzX(messagetype, true)) {
            return messagetype;
        }
        throw new zzgr(messagetype);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfl
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public MessageType zzk() {
        if (!this.zza.zzY()) {
            return (MessageType) this.zza;
        }
        this.zza.zzT();
        return (MessageType) this.zza;
    }

    public final void zzm() {
        if (this.zza.zzY()) {
            return;
        }
        zzn();
    }

    public void zzn() {
        zzeh zzehVarZzK = this.zzb.zzK();
        zza(zzehVarZzK, this.zza);
        this.zza = zzehVarZzK;
    }
}
