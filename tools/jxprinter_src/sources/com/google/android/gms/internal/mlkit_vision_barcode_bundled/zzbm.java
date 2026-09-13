package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzbm extends zzb implements zzbn {
    public zzbm() {
        super("com.google.mlkit.vision.barcode.aidls.IBarcodeScanner");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzb
    public final boolean zza(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 1) {
            zzd();
            parcel2.writeNoException();
        } else if (i5 == 2) {
            zzf();
            parcel2.writeNoException();
        } else if (i5 == 3) {
            IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzcc zzccVar = (zzcc) zzc.zza(parcel, zzcc.CREATOR);
            zzc.zzb(parcel);
            List listZzb = zzb(iObjectWrapperAsInterface, zzccVar);
            parcel2.writeNoException();
            parcel2.writeTypedList(listZzb);
        } else if (i5 == 4) {
            IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzcc zzccVar2 = (zzcc) zzc.zza(parcel, zzcc.CREATOR);
            zzbc zzbcVar = (zzbc) zzc.zza(parcel, zzbc.CREATOR);
            zzc.zzb(parcel);
            List listZzc = zzc(iObjectWrapperAsInterface2, zzccVar2, zzbcVar);
            parcel2.writeNoException();
            parcel2.writeTypedList(listZzc);
        } else {
            if (i5 != 5) {
                return false;
            }
            zzbe zzbeVar = (zzbe) zzc.zza(parcel, zzbe.CREATOR);
            zzc.zzb(parcel);
            zze(zzbeVar);
            parcel2.writeNoException();
        }
        return true;
    }
}
