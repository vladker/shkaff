package com.bumptech.glide.load.engine.bitmap_recycle;

import L0.s;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue f2982a = s.createQueue(20);

    public final void a(m mVar) {
        Queue queue = this.f2982a;
        if (queue.size() < 20) {
            queue.offer(mVar);
        }
    }
}
