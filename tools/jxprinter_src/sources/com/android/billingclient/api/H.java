package com.android.billingclient.api;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.play_billing.zzc;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2433a;
    public int b;
    public String c;

    @NonNull
    public static G newBuilder() {
        G g6 = new G();
        g6.b = 0;
        g6.c = "";
        return g6;
    }

    @NonNull
    public String getDebugMessage() {
        return this.c;
    }

    public int getOnPurchasesUpdatedSubResponseCode() {
        return this.b;
    }

    @NonNull
    public String toString() {
        return androidx.exifinterface.media.a.m("Response Code: ", zzc.zzk(this.f2433a), ", Debug Message: ", this.c);
    }
}
