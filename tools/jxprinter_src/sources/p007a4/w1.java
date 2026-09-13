package p007a4;

import G3.d;
import kotlin.jvm.internal.T;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class w1 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f959a;
    public /* synthetic */ Object b;
    public int c;

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.c |= Integer.MIN_VALUE;
        return x1.withTimeoutOrNull(0L, null, this);
    }
}
