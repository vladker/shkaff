package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "TextRecognizerOptionsCreator")
public final class zbom extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zbom> CREATOR = new zbon();

    @SafeParcelable.Field(getter = "getConfigLabel", id = 1)
    private final String zba;

    @SafeParcelable.Field(getter = "getLoggingLibraryName", id = 2)
    private final String zbb;

    @Nullable
    @SafeParcelable.Field(getter = "getModelPath", id = 3)
    private final String zbc;

    @SafeParcelable.Field(getter = "getIsMLKit", id = 4)
    private final boolean zbd;

    @SafeParcelable.Field(getter = "getDetectionTypeValue", id = 5)
    private final int zbe;

    @Nullable
    @SafeParcelable.Field(getter = "getLanguageHint", id = 6)
    private final String zbf;

    @SafeParcelable.Field(getter = "getEnableLowLatencyInBackground", id = 7)
    private final boolean zbg;

    @SafeParcelable.Constructor
    public zbom(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @Nullable @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) boolean z6, @SafeParcelable.Param(id = 5) int i5, @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 7) boolean z7) {
        this.zba = str;
        this.zbb = str2;
        this.zbc = str3;
        this.zbf = str4;
        this.zbe = i5;
        this.zbd = z6;
        this.zbg = z7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        String str = this.zba;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, str, false);
        SafeParcelWriter.writeString(parcel, 2, this.zbb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zbc, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zbd);
        SafeParcelWriter.writeInt(parcel, 5, this.zbe);
        SafeParcelWriter.writeString(parcel, 6, this.zbf, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zbg);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String zba() {
        return this.zba;
    }

    @Nullable
    public final String zbb() {
        return this.zbf;
    }

    @Nullable
    public final String zbc() {
        return this.zbc;
    }

    public final boolean zbd() {
        return this.zbg;
    }
}
