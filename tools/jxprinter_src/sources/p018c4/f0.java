package p018c4;

import G3.d;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Comparator f1156a;
    public B0 b;
    public InterfaceC0395z c;
    public Object d;
    public /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1157f;

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.f1157f |= Integer.MIN_VALUE;
        return p0.maxWith(null, null, this);
    }
}
