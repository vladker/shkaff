package com.bumptech.glide.load.resource.gif;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f3145a;

    public l(n nVar) {
        this.f3145a = nVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i5 = message.what;
        n nVar = this.f3145a;
        if (i5 == 1) {
            nVar.onFrameReady((j) message.obj);
            return true;
        }
        if (i5 != 2) {
            return false;
        }
        nVar.d.clear((j) message.obj);
        return false;
    }
}
