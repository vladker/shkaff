package com.google.photos.vision.barhopper;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzds;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class BarhopperProto$BarhopperResponse extends zzeh<BarhopperProto$BarhopperResponse, zzh> implements zzfn {
    private static final BarhopperProto$BarhopperResponse zzb;
    private int zzd;
    private int zzf;
    private byte zzi = 2;
    private zzeo zze = zzeh.zzP();
    private String zzg = "";
    private zzdf zzh = zzdf.zzb;

    static {
        BarhopperProto$BarhopperResponse barhopperProto$BarhopperResponse = new BarhopperProto$BarhopperResponse();
        zzb = barhopperProto$BarhopperResponse;
        zzeh.zzV(BarhopperProto$BarhopperResponse.class, barhopperProto$BarhopperResponse);
    }

    private BarhopperProto$BarhopperResponse() {
    }

    public static BarhopperProto$BarhopperResponse zzb(byte[] bArr, zzds zzdsVar) {
        return (BarhopperProto$BarhopperResponse) zzeh.zzL(zzb, bArr, zzdsVar);
    }

    @NonNull
    public final List zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    @NonNull
    public final Object zzg(int i5, @NonNull Object obj, @NonNull Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i6 == 2) {
            return zzeh.zzS(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0002\u0001Л\u0002ᴌ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzd", "zze", zzc.class, "zzf", zzai.zza, "zzg", "zzh"});
        }
        if (i6 == 3) {
            return new BarhopperProto$BarhopperResponse();
        }
        zza zzaVar = null;
        if (i6 == 4) {
            return new zzh(zzaVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
