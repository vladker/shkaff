package B4;

import A3.C0144l;
import A4.AbstractC0180x;
import A4.V;
import W3.AbstractC0234s;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends G3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractC0234s f99a;
    public AbstractC0180x b;
    public C0144l c;
    public V d;
    public Iterator e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f100f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f101g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f102h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f103i;

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f102h = obj;
        this.f103i |= Integer.MIN_VALUE;
        return f.collectRecursively(null, null, null, null, false, false, this);
    }
}
