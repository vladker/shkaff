package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbf implements Parcelable.Creator<LocationRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ LocationRequest createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i5 = 102;
        long j6 = 3600000;
        long j7 = 600000;
        boolean z6 = false;
        boolean z7 = false;
        long j8 = Long.MAX_VALUE;
        int i6 = Integer.MAX_VALUE;
        float f6 = 0.0f;
        long j9 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i5 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 2:
                    j6 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 3:
                    j7 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 4:
                    z6 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 5:
                    j8 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 6:
                    i6 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 7:
                    f6 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 8:
                    j9 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 9:
                    z7 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new LocationRequest(i5, j6, j7, z6, j8, i6, f6, j9, z7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ LocationRequest[] newArray(int i5) {
        return new LocationRequest[i5];
    }
}
