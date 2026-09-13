package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "MultiScaleDecodingOptionsParcelCreator")
public final class zzbt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbt> CREATOR = new zzbu();

    @SafeParcelable.Field(getter = "getExtraScales", id = 1)
    private final float[] zza;

    @SafeParcelable.Field(getter = "getMinimumDetectedDimension", id = 2)
    private final int zzb;

    @SafeParcelable.Field(getter = "getSkipProcessingIfBarcodeFound", id = 3)
    private final boolean zzc;

    @SafeParcelable.Constructor
    public zzbt(@SafeParcelable.Param(id = 1) float[] fArr, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) boolean z6) {
        this.zza = fArr;
        this.zzb = i5;
        this.zzc = z6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        float[] fArr = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloatArray(parcel, 1, fArr, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return this.zzc;
    }

    public final float[] zzc() {
        return this.zza;
    }
}
