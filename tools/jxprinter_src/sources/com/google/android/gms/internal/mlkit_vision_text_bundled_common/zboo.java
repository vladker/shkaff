package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "TextSymbolParcelCreator")
public final class zboo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zboo> CREATOR = new zbop();

    @SafeParcelable.Field(getter = "getText", id = 1)
    private final String zba;

    @SafeParcelable.Field(getter = "getBoundingBox", id = 2)
    private final Rect zbb;

    @SafeParcelable.Field(getter = "getCornerPointList", id = 3)
    private final List zbc;

    @SafeParcelable.Field(getter = "getConfidence", id = 4)
    private final float zbd;

    @SafeParcelable.Field(getter = "getAngle", id = 5)
    private final float zbe;

    @SafeParcelable.Constructor
    public zboo(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) Rect rect, @SafeParcelable.Param(id = 3) List list, @SafeParcelable.Param(id = 4) float f6, @SafeParcelable.Param(id = 5) float f7) {
        this.zba = str;
        this.zbb = rect;
        this.zbc = list;
        this.zbd = f6;
        this.zbe = f7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        String str = this.zba;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, str, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zbb, i5, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zbc, false);
        SafeParcelWriter.writeFloat(parcel, 4, this.zbd);
        SafeParcelWriter.writeFloat(parcel, 5, this.zbe);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
