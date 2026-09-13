package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import A3.AbstractC0157z;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcp;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcq;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzcq<MessageType extends zzcq<MessageType, BuilderType>, BuilderType extends zzcp<MessageType, BuilderType>> implements zzfm {
    protected int zza = 0;

    public int zzB(zzge zzgeVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfm
    public final zzdf zzC() {
        try {
            int iZzF = zzF();
            zzdf zzdfVar = zzdf.zzb;
            byte[] bArr = new byte[iZzF];
            zzdk zzdkVar = new zzdk(bArr, 0, iZzF);
            zzab(zzdkVar);
            zzdkVar.zzC();
            return new zzde(bArr);
        } catch (IOException e) {
            throw new RuntimeException(AbstractC0157z.o("Serializing ", getClass().getName(), " to a ByteString threw an IOException (should never happen)."), e);
        }
    }

    public final byte[] zzD() {
        try {
            int iZzF = zzF();
            byte[] bArr = new byte[iZzF];
            zzdk zzdkVar = new zzdk(bArr, 0, iZzF);
            zzab(zzdkVar);
            zzdkVar.zzC();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(AbstractC0157z.o("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e);
        }
    }
}
