package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class S implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2976a;

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.f2976a) {
            case 0:
                if (message.what != 1) {
                    return false;
                }
                ((O) message.obj).recycle();
                return true;
            default:
                if (message.what != 1) {
                    return false;
                }
                com.bumptech.glide.request.target.i iVar = (com.bumptech.glide.request.target.i) message.obj;
                iVar.f3190a.clear(iVar);
                return true;
        }
    }
}
