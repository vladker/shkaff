package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zbnz extends zbb implements zboa {
    public zbnz() {
        super("com.google.mlkit.vision.text.aidls.ITextRecognizer");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbb
    public final boolean zba(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 1) {
            zbc();
            parcel2.writeNoException();
        } else if (i5 == 2) {
            zbd();
            parcel2.writeNoException();
        } else if (i5 == 3) {
            IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zbnx zbnxVar = (zbnx) zbc.zba(parcel, zbnx.CREATOR);
            zbc.zbb(parcel);
            zbok zbokVarZbb = zbb(iObjectWrapperAsInterface, zbnxVar);
            parcel2.writeNoException();
            parcel2.writeInt(1);
            zbokVarZbb.writeToParcel(parcel2, 1);
        } else {
            if (i5 != 4) {
                return false;
            }
            IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zbnx zbnxVar2 = (zbnx) zbc.zba(parcel, zbnx.CREATOR);
            zbc.zbb(parcel);
            zbf[] zbfVarArrZbe = zbe(iObjectWrapperAsInterface2, zbnxVar2);
            parcel2.writeNoException();
            parcel2.writeTypedArray(zbfVarArrZbe, 1);
        }
        return true;
    }
}
