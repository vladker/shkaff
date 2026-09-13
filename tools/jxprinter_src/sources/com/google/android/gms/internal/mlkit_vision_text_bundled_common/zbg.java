package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbg implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i5 = 0;
        boolean z6 = false;
        int i6 = 0;
        int i7 = 0;
        zbj[] zbjVarArr = null;
        zbd zbdVar = null;
        zbd zbdVar2 = null;
        zbd zbdVar3 = null;
        String strCreateString = null;
        String strCreateString2 = null;
        float f6 = 0.0f;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    zbjVarArr = (zbj[]) SafeParcelReader.createTypedArray(parcel, header, zbj.CREATOR);
                    break;
                case 3:
                    zbdVar = (zbd) SafeParcelReader.createParcelable(parcel, header, zbd.CREATOR);
                    break;
                case 4:
                    zbdVar2 = (zbd) SafeParcelReader.createParcelable(parcel, header, zbd.CREATOR);
                    break;
                case 5:
                    zbdVar3 = (zbd) SafeParcelReader.createParcelable(parcel, header, zbd.CREATOR);
                    break;
                case 6:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 7:
                    f6 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 8:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 9:
                    i5 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 10:
                    z6 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 11:
                    i6 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 12:
                    i7 = SafeParcelReader.readInt(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zbf(zbjVarArr, zbdVar, zbdVar2, zbdVar3, strCreateString, f6, strCreateString2, i5, z6, i6, i7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i5) {
        return new zbf[i5];
    }
}
