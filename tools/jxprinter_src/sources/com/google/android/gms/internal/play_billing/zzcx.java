package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.mlkit_vision_barcode.a;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zzcx {
    public static /* synthetic */ boolean zza(Unsafe unsafe, Object obj, long j6, Object obj2, Object obj3) {
        while (!a.a(unsafe, obj, j6, obj2, obj3)) {
            if (unsafe.getObject(obj, j6) != obj2) {
                return false;
            }
        }
        return true;
    }
}
