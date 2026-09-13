package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzr extends com.google.android.gms.internal.p000authapi.zzd implements zzq {
    public zzr() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    @Override // com.google.android.gms.internal.p000authapi.zzd
    public final boolean dispatchTransaction(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 1) {
            zzj();
        } else {
            if (i5 != 2) {
                return false;
            }
            zzk();
        }
        return true;
    }
}
