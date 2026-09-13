package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzai implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        zzpl zzplVar = null;
        String strCreateString3 = null;
        zzbg zzbgVar = null;
        zzbg zzbgVar2 = null;
        zzbg zzbgVar3 = null;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        boolean z6 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 4:
                    zzplVar = (zzpl) SafeParcelReader.createParcelable(parcel, header, zzpl.CREATOR);
                    break;
                case 5:
                    j6 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 6:
                    z6 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 7:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 8:
                    zzbgVar = (zzbg) SafeParcelReader.createParcelable(parcel, header, zzbg.CREATOR);
                    break;
                case 9:
                    j7 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 10:
                    zzbgVar2 = (zzbg) SafeParcelReader.createParcelable(parcel, header, zzbg.CREATOR);
                    break;
                case 11:
                    j8 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 12:
                    zzbgVar3 = (zzbg) SafeParcelReader.createParcelable(parcel, header, zzbg.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzah(strCreateString, strCreateString2, zzplVar, j6, z6, strCreateString3, zzbgVar, j7, zzbgVar2, j8, zzbgVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i5) {
        return new zzah[i5];
    }
}
