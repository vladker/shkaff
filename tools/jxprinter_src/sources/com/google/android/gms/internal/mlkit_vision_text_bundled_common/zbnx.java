package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "ImageMetadataParcelCreator")
public final class zbnx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zbnx> CREATOR = new zbny();

    @SafeParcelable.Field(getter = "getImageFormat", id = 1)
    private final int zba;

    @SafeParcelable.Field(getter = "getWidth", id = 2)
    private final int zbb;

    @SafeParcelable.Field(getter = "getHeight", id = 3)
    private final int zbc;

    @SafeParcelable.Field(getter = "getRotation", id = 4)
    private final int zbd;

    @SafeParcelable.Field(getter = "getTimestampMs", id = 5)
    private final long zbe;

    @SafeParcelable.Constructor
    public zbnx(@SafeParcelable.Param(id = 1) int i5, @SafeParcelable.Param(id = 2) int i6, @SafeParcelable.Param(id = 3) int i7, @SafeParcelable.Param(id = 4) int i8, @SafeParcelable.Param(id = 5) long j6) {
        this.zba = i5;
        this.zbb = i6;
        this.zbc = i7;
        this.zbd = i8;
        this.zbe = j6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zba);
        SafeParcelWriter.writeInt(parcel, 2, this.zbb);
        SafeParcelWriter.writeInt(parcel, 3, this.zbc);
        SafeParcelWriter.writeInt(parcel, 4, this.zbd);
        SafeParcelWriter.writeLong(parcel, 5, this.zbe);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zba() {
        return this.zbc;
    }

    public final int zbb() {
        return this.zba;
    }

    public final int zbc() {
        return this.zbd;
    }

    public final int zbd() {
        return this.zbb;
    }

    public final long zbe() {
        return this.zbe;
    }
}
