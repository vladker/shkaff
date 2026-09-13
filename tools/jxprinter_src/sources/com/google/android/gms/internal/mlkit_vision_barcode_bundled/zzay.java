package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "BarcodeParcelCreator")
public final class zzay extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzay> CREATOR = new zzaz();

    @SafeParcelable.Field(getter = "getFormat", id = 1)
    private final int zza;

    @Nullable
    @SafeParcelable.Field(getter = "getDisplayValue", id = 2)
    private final String zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getRawValue", id = 3)
    private final String zzc;

    @Nullable
    @SafeParcelable.Field(getter = "getRawBytes", id = 4)
    private final byte[] zzd;

    @Nullable
    @SafeParcelable.Field(getter = "getCornerPoints", id = 5)
    private final Point[] zze;

    @SafeParcelable.Field(getter = "getValueType", id = 6)
    private final int zzf;

    @Nullable
    @SafeParcelable.Field(getter = "getEmailParcel", id = 7)
    private final zzar zzg;

    @Nullable
    @SafeParcelable.Field(getter = "getPhoneParcel", id = 8)
    private final zzau zzh;

    @Nullable
    @SafeParcelable.Field(getter = "getSmsParcel", id = 9)
    private final zzav zzi;

    @Nullable
    @SafeParcelable.Field(getter = "getWiFiParcel", id = 10)
    private final zzax zzj;

    @Nullable
    @SafeParcelable.Field(getter = "getUrlBookmarkParcel", id = 11)
    private final zzaw zzk;

    @Nullable
    @SafeParcelable.Field(getter = "getGeoPointParcel", id = 12)
    private final zzas zzl;

    @Nullable
    @SafeParcelable.Field(getter = "getCalendarEventParcel", id = 13)
    private final zzao zzm;

    @Nullable
    @SafeParcelable.Field(getter = "getContactInfoParcel", id = 14)
    private final zzap zzn;

    @Nullable
    @SafeParcelable.Field(getter = "getDriverLicenseParcel", id = 15)
    private final zzaq zzo;

    @SafeParcelable.Constructor
    public zzay(@SafeParcelable.Param(id = 1) int i5, @Nullable @SafeParcelable.Param(id = 2) String str, @Nullable @SafeParcelable.Param(id = 3) String str2, @Nullable @SafeParcelable.Param(id = 4) byte[] bArr, @Nullable @SafeParcelable.Param(id = 5) Point[] pointArr, @SafeParcelable.Param(id = 6) int i6, @Nullable @SafeParcelable.Param(id = 7) zzar zzarVar, @Nullable @SafeParcelable.Param(id = 8) zzau zzauVar, @Nullable @SafeParcelable.Param(id = 9) zzav zzavVar, @Nullable @SafeParcelable.Param(id = 10) zzax zzaxVar, @Nullable @SafeParcelable.Param(id = 11) zzaw zzawVar, @Nullable @SafeParcelable.Param(id = 12) zzas zzasVar, @Nullable @SafeParcelable.Param(id = 13) zzao zzaoVar, @Nullable @SafeParcelable.Param(id = 14) zzap zzapVar, @Nullable @SafeParcelable.Param(id = 15) zzaq zzaqVar) {
        this.zza = i5;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bArr;
        this.zze = pointArr;
        this.zzf = i6;
        this.zzg = zzarVar;
        this.zzh = zzauVar;
        this.zzi = zzavVar;
        this.zzj = zzaxVar;
        this.zzk = zzawVar;
        this.zzl = zzasVar;
        this.zzm = zzaoVar;
        this.zzn = zzapVar;
        this.zzo = zzaqVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int i6 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i6);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.zze, i5, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i5, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i5, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i5, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzj, i5, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i5, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzl, i5, false);
        SafeParcelWriter.writeParcelable(parcel, 13, this.zzm, i5, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzn, i5, false);
        SafeParcelWriter.writeParcelable(parcel, 15, this.zzo, i5, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
