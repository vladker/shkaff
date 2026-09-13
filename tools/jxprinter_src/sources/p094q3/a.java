package p094q3;

import java.util.concurrent.atomic.AtomicInteger;
import p043h3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends AtomicInteger implements g {
    private static final long serialVersionUID = -6671519529404341862L;

    @Override // p043h3.g, p043h3.f, p043h3.j
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public abstract /* synthetic */ Object poll();

    @Override // p043h3.g, p043h3.f, p043h3.j
    public final boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
