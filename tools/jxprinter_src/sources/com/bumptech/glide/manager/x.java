package com.bumptech.glide.manager;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f3181a = Collections.newSetFromMap(new WeakHashMap());
    public final HashSet b = new HashSet();
    public boolean c;

    @VisibleForTesting
    public void addRequest(I0.d dVar) {
        this.f3181a.add(dVar);
    }

    public boolean clearAndRemove(@Nullable I0.d dVar) {
        boolean z6 = true;
        if (dVar == null) {
            return true;
        }
        boolean zRemove = this.f3181a.remove(dVar);
        if (!this.b.remove(dVar) && !zRemove) {
            z6 = false;
        }
        if (z6) {
            dVar.clear();
        }
        return z6;
    }

    public void runRequest(@NonNull I0.d dVar) {
        this.f3181a.add(dVar);
        if (!this.c) {
            dVar.e();
            return;
        }
        dVar.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.b.add(dVar);
    }

    public final String toString() {
        return super.toString() + "{numRequests=" + this.f3181a.size() + ", isPaused=" + this.c + VectorFormat.DEFAULT_SUFFIX;
    }
}
