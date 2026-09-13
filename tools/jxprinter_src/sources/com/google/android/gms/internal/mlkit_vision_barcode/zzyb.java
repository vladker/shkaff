package com.google.android.gms.internal.mlkit_vision_barcode;

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
public final class zzyb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzyb> CREATOR = new zzyc();

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
    private final zzxu zzg;

    @Nullable
    @SafeParcelable.Field(getter = "getPhoneParcel", id = 8)
    private final zzxx zzh;

    @Nullable
    @SafeParcelable.Field(getter = "getSmsParcel", id = 9)
    private final zzxy zzi;

    @Nullable
    @SafeParcelable.Field(getter = "getWiFiParcel", id = 10)
    private final zzya zzj;

    @Nullable
    @SafeParcelable.Field(getter = "getUrlBookmarkParcel", id = 11)
    private final zzxz zzk;

    @Nullable
    @SafeParcelable.Field(getter = "getGeoPointParcel", id = 12)
    private final zzxv zzl;

    @Nullable
    @SafeParcelable.Field(getter = "getCalendarEventParcel", id = 13)
    private final zzxr zzm;

    @Nullable
    @SafeParcelable.Field(getter = "getContactInfoParcel", id = 14)
    private final zzxs zzn;

    @Nullable
    @SafeParcelable.Field(getter = "getDriverLicenseParcel", id = 15)
    private final zzxt zzo;

    @SafeParcelable.Constructor
    public zzyb(@SafeParcelable.Param(id = 1) int i5, @Nullable @SafeParcelable.Param(id = 2) String str, @Nullable @SafeParcelable.Param(id = 3) String str2, @Nullable @SafeParcelable.Param(id = 4) byte[] bArr, @Nullable @SafeParcelable.Param(id = 5) Point[] pointArr, @SafeParcelable.Param(id = 6) int i6, @Nullable @SafeParcelable.Param(id = 7) zzxu zzxuVar, @Nullable @SafeParcelable.Param(id = 8) zzxx zzxxVar, @Nullable @SafeParcelable.Param(id = 9) zzxy zzxyVar, @Nullable @SafeParcelable.Param(id = 10) zzya zzyaVar, @Nullable @SafeParcelable.Param(id = 11) zzxz zzxzVar, @Nullable @SafeParcelable.Param(id = 12) zzxv zzxvVar, @Nullable @SafeParcelable.Param(id = 13) zzxr zzxrVar, @Nullable @SafeParcelable.Param(id = 14) zzxs zzxsVar, @Nullable @SafeParcelable.Param(id = 15) zzxt zzxtVar) {
        this.zza = i5;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bArr;
        this.zze = pointArr;
        this.zzf = i6;
        this.zzg = zzxuVar;
        this.zzh = zzxxVar;
        this.zzi = zzxyVar;
        this.zzj = zzyaVar;
        this.zzk = zzxzVar;
        this.zzl = zzxvVar;
        this.zzm = zzxrVar;
        this.zzn = zzxsVar;
        this.zzo = zzxtVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
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

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzf;
    }

    @Nullable
    public final zzxr zzc() {
        return this.zzm;
    }

    @Nullable
    public final zzxs zzd() {
        return this.zzn;
    }

    @Nullable
    public final zzxt zze() {
        return this.zzo;
    }

    @Nullable
    public final zzxu zzf() {
        return this.zzg;
    }

    @Nullable
    public final zzxv zzg() {
        return this.zzl;
    }

    @Nullable
    public final zzxx zzh() {
        return this.zzh;
    }

    @Nullable
    public final zzxy zzi() {
        return this.zzi;
    }

    @Nullable
    public final zzxz zzj() {
        return this.zzk;
    }

    @Nullable
    public final zzya zzk() {
        return this.zzj;
    }

    @Nullable
    public final String zzl() {
        return this.zzb;
    }

    @Nullable
    public final String zzm() {
        return this.zzc;
    }

    @Nullable
    public final byte[] zzn() {
        return this.zzd;
    }

    @Nullable
    public final Point[] zzo() {
        return this.zze;
    }
}
