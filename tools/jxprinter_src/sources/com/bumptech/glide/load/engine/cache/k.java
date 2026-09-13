package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class k {

    @VisibleForTesting
    static final int BYTES_PER_ARGB_8888_PIXEL = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3008a;
    public final int b;
    public final int c;

    public k(i iVar) {
        Context context = iVar.f3007a;
        float f6 = iVar.d;
        int i5 = isLowMemoryDevice(iVar.b) ? 2097152 : 4194304;
        this.c = i5;
        ActivityManager activityManager = iVar.b;
        int iRound = Math.round(activityManager.getMemoryClass() * 1048576 * (isLowMemoryDevice(activityManager) ? 0.33f : 0.4f));
        DisplayMetrics displayMetrics = (DisplayMetrics) ((p075n1.a) iVar.c).b;
        float f7 = displayMetrics.widthPixels * displayMetrics.heightPixels * 4;
        int iRound2 = Math.round(f7 * f6);
        int iRound3 = Math.round(f7 * 2.0f);
        int i6 = iRound - i5;
        int i7 = iRound3 + iRound2;
        if (i7 <= i6) {
            this.b = iRound3;
            this.f3008a = iRound2;
        } else {
            float f8 = i6 / (f6 + 2.0f);
            this.b = Math.round(2.0f * f8);
            this.f3008a = Math.round(f8 * f6);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder("Calculation complete, Calculated memory cache size: ");
            sb.append(Formatter.formatFileSize(context, this.b));
            sb.append(", pool size: ");
            sb.append(Formatter.formatFileSize(context, this.f3008a));
            sb.append(", byte array size: ");
            sb.append(Formatter.formatFileSize(context, i5));
            sb.append(", memory class limited? ");
            sb.append(i7 > iRound);
            sb.append(", max size: ");
            sb.append(Formatter.formatFileSize(context, iRound));
            sb.append(", memoryClass: ");
            sb.append(iVar.b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(isLowMemoryDevice(iVar.b));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    @TargetApi(19)
    public static boolean isLowMemoryDevice(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
