package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzgl;
import com.google.android.gms.internal.play_billing.zzgp;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class zzgl<MessageType extends zzgp<MessageType, BuilderType>, BuilderType extends zzgl<MessageType, BuilderType>> extends zzez<MessageType, BuilderType> {
    protected zzgp zza;
    private final zzgp zzb;

    public zzgl(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzF()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzs();
    }

    private static void zza(Object obj, Object obj2) {
        zzhy.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzez
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzgl clone() {
        zzgl zzglVar = (zzgl) this.zzb.zzd(5, null, null);
        zzglVar.zza = zzk();
        return zzglVar;
    }

    public final zzgl zzh(zzgp zzgpVar) {
        zzgp zzgpVar2 = this.zzb;
        if (!zzgpVar2.getClass().isInstance(zzgpVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        if (!zzgpVar2.equals(zzgpVar)) {
            if (!this.zza.zzF()) {
                zzn();
            }
            zza(this.zza, zzgpVar);
        }
        return this;
    }

    public final MessageType zzi() {
        MessageType messagetype = (MessageType) zzk();
        if (messagetype.zzo()) {
            return messagetype;
        }
        throw new zzip(messagetype);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhq
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public MessageType zzk() {
        if (!this.zza.zzF()) {
            return (MessageType) this.zza;
        }
        this.zza.zzz();
        return (MessageType) this.zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhs
    public final /* bridge */ /* synthetic */ zzhr zzl() {
        throw null;
    }

    public final void zzm() {
        if (this.zza.zzF()) {
            return;
        }
        zzn();
    }

    public void zzn() {
        zzgp zzgpVarZzs = this.zzb.zzs();
        zza(zzgpVarZzs, this.zza);
        this.zza = zzgpVarZzs;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhs
    public final boolean zzo() {
        return zzgp.zzc(this.zza, false);
    }
}
