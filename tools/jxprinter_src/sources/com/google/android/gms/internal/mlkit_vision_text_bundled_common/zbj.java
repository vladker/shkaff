package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "WordBoxParcelCreator")
@SafeParcelable.Reserved({1})
public final class zbj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zbj> CREATOR = new zbk();

    @SafeParcelable.Field(id = 2)
    public final zbh[] zba;

    @SafeParcelable.Field(id = 3)
    public final zbd zbb;

    @SafeParcelable.Field(id = 4)
    public final zbd zbc;

    @SafeParcelable.Field(id = 5)
    public final String zbd;

    @SafeParcelable.Field(id = 6)
    public final float zbe;

    @SafeParcelable.Field(id = 7)
    public final String zbf;

    @SafeParcelable.Field(id = 8)
    public final boolean zbg;

    @SafeParcelable.Constructor
    public zbj(@SafeParcelable.Param(id = 2) zbh[] zbhVarArr, @SafeParcelable.Param(id = 3) zbd zbdVar, @SafeParcelable.Param(id = 4) zbd zbdVar2, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) float f6, @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) boolean z6) {
        this.zba = zbhVarArr;
        this.zbb = zbdVar;
        this.zbc = zbdVar2;
        this.zbd = str;
        this.zbe = f6;
        this.zbf = str2;
        this.zbg = z6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        zbh[] zbhVarArr = this.zba;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, zbhVarArr, i5, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zbb, i5, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zbc, i5, false);
        SafeParcelWriter.writeString(parcel, 5, this.zbd, false);
        SafeParcelWriter.writeFloat(parcel, 6, this.zbe);
        SafeParcelWriter.writeString(parcel, 7, this.zbf, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zbg);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
