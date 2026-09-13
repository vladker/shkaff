package p023d4;

import E3.g;
import G3.d;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class B extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3782a;
    public int b;
    public final /* synthetic */ C0623s c;
    public InterfaceC0615p d;
    public Iterator e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(C0623s c0623s, g gVar) {
        super(gVar);
        this.c = c0623s;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3782a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.collect(null, this);
    }
}
