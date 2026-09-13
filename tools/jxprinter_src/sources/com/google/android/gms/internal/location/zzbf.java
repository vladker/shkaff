package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbf implements Parcelable.Creator<zzbe> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbe createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        int i5 = 0;
        short s6 = 0;
        int i6 = 0;
        double d = 0.0d;
        double d6 = 0.0d;
        float f6 = 0.0f;
        long j6 = 0;
        int i7 = -1;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 2:
                    j6 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 3:
                    s6 = SafeParcelReader.readShort(parcel, header);
                    break;
                case 4:
                    d = SafeParcelReader.readDouble(parcel, header);
                    break;
                case 5:
                    d6 = SafeParcelReader.readDouble(parcel, header);
                    break;
                case 6:
                    f6 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 7:
                    i5 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 8:
                    i6 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 9:
                    i7 = SafeParcelReader.readInt(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbe(strCreateString, i5, s6, d, d6, f6, j6, i6, i7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbe[] newArray(int i5) {
        return new zzbe[i5];
    }
}
