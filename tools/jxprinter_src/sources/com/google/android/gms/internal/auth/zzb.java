package com.google.android.gms.internal.auth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public class zzb extends Binder implements IInterface {
    private static zzd zzc;

    public zzb(String str) {
        attachInterface(this, str);
    }

    public boolean dispatchTransaction(int i5, Parcel parcel, Parcel parcel2, int i6) {
        return false;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
        boolean zOnTransact;
        if (i5 > 16777215) {
            zOnTransact = super.onTransact(i5, parcel, parcel2, i6);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            zOnTransact = false;
        }
        if (zOnTransact) {
            return true;
        }
        return dispatchTransaction(i5, parcel, parcel2, i6);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
