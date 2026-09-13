package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zboc extends zbb implements zbod {
    public zboc() {
        super("com.google.mlkit.vision.text.aidls.ITextRecognizerCreator");
    }

    public static zbod asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.mlkit.vision.text.aidls.ITextRecognizerCreator");
        return iInterfaceQueryLocalInterface instanceof zbod ? (zbod) iInterfaceQueryLocalInterface : new zbob(iBinder);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbb
    public final boolean zba(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 1) {
            IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zbc.zbb(parcel);
            zboa zboaVarNewTextRecognizer = newTextRecognizer(iObjectWrapperAsInterface);
            parcel2.writeNoException();
            zbc.zbc(parcel2, zboaVarNewTextRecognizer);
        } else {
            if (i5 != 2) {
                return false;
            }
            IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zbom zbomVar = (zbom) zbc.zba(parcel, zbom.CREATOR);
            zbc.zbb(parcel);
            zboa zboaVarNewTextRecognizerWithOptions = newTextRecognizerWithOptions(iObjectWrapperAsInterface2, zbomVar);
            parcel2.writeNoException();
            zbc.zbc(parcel2, zboaVarNewTextRecognizerWithOptions);
        }
        return true;
    }
}
