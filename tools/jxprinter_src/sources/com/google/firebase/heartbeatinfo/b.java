package com.google.firebase.heartbeatinfo;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3501a;
    public final /* synthetic */ DefaultHeartBeatController b;

    public /* synthetic */ b(DefaultHeartBeatController defaultHeartBeatController, int i5) {
        this.f3501a = i5;
        this.b = defaultHeartBeatController;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f3501a) {
            case 0:
                return this.b.lambda$getHeartBeatsHeader$1();
            default:
                return this.b.lambda$registerHeartBeat$0();
        }
    }
}
