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
@SafeParcelable.Class(creator = "TextElementParcelCreator")
public final class zbog extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zbog> CREATOR = new zboh();

    @SafeParcelable.Field(getter = "getText", id = 1)
    private final String zba;

    @SafeParcelable.Field(getter = "getBoundingBox", id = 2)
    private final Rect zbb;

    @SafeParcelable.Field(getter = "getCornerPointList", id = 3)
    private final List zbc;

    @SafeParcelable.Field(getter = "getRecognizedLanguage", id = 4)
    private final String zbd;

    @SafeParcelable.Field(getter = "getConfidence", id = 5)
    private final float zbe;

    @SafeParcelable.Field(getter = "getAngle", id = 6)
    private final float zbf;

    @SafeParcelable.Field(getter = "getTextSymbolList", id = 7)
    private final List zbg;

    @SafeParcelable.Constructor
    public zbog(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) Rect rect, @SafeParcelable.Param(id = 3) List list, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) float f6, @SafeParcelable.Param(id = 6) float f7, @SafeParcelable.Param(id = 7) List list2) {
        this.zba = str;
        this.zbb = rect;
        this.zbc = list;
        this.zbd = str2;
        this.zbe = f6;
        this.zbf = f7;
        this.zbg = list2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        String str = this.zba;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, str, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zbb, i5, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zbc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zbd, false);
        SafeParcelWriter.writeFloat(parcel, 5, this.zbe);
        SafeParcelWriter.writeFloat(parcel, 6, this.zbf);
        SafeParcelWriter.writeTypedList(parcel, 7, this.zbg, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
