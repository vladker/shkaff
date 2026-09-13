package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2977a;
    public final Handler b = new Handler(Looper.getMainLooper(), new S(0));

    public final synchronized void a(O o6, boolean z6) {
        try {
            if (this.f2977a || z6) {
                this.b.obtainMessage(1, o6).sendToTarget();
            } else {
                this.f2977a = true;
                o6.recycle();
                this.f2977a = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
