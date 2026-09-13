package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface IGmsCallbacks extends IInterface {
    void onPostInitComplete(int i5, @NonNull IBinder iBinder, @NonNull Bundle bundle);

    void zzb(int i5, @NonNull Bundle bundle);

    void zzc(int i5, IBinder iBinder, zzj zzjVar);
}
