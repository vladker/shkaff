package com.google.android.gms.internal.play_billing;

import A3.AbstractC0157z;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class zzav extends Binder implements IInterface {
    private static zzax globalInterceptor;

    public zzav(String str) {
        attachInterface(this, str);
    }

    public static synchronized void installTransactionInterceptorPackagePrivate(zzax zzaxVar) {
        try {
            if (zzaxVar == null) {
                throw new IllegalArgumentException("null interceptor");
            }
            if (globalInterceptor != null) {
                throw new IllegalStateException("Duplicate TransactionInterceptor installation.");
            }
            globalInterceptor = zzaxVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    private boolean routeToSuperOrEnforceInterface(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 > 16777215) {
            return super.onTransact(i5, parcel, parcel2, i6);
        }
        parcel.enforceInterface(getInterfaceDescriptor());
        return false;
    }

    public boolean dispatchTransaction(int i5, Parcel parcel, Parcel parcel2, int i6) {
        return false;
    }

    public void enforceNoDataAvail(Parcel parcel) {
        zzax zzaxVar = globalInterceptor;
        if (zzaxVar != null) {
            zzaxVar.zza();
            return;
        }
        int i5 = zzaw.zza;
        int iDataAvail = parcel.dataAvail();
        if (iDataAvail > 0) {
            throw new BadParcelableException(AbstractC0157z.k(iDataAvail, "Parcel data not fully consumed, unread size: "));
        }
    }

    @Override // android.os.Binder
    public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (routeToSuperOrEnforceInterface(i5, parcel, parcel2, i6)) {
            return true;
        }
        zzax zzaxVar = globalInterceptor;
        return zzaxVar == null ? dispatchTransaction(i5, parcel, parcel2, i6) : zzaxVar.zzb();
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
