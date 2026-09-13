package androidx.datastore.core;

import O3.l;
import p007a4.InterfaceC0280h0;
import p012b4.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements InterfaceC0280h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1036a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(Object obj, Object obj2, int i5) {
        this.f1036a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // p007a4.InterfaceC0280h0
    public final void dispose() {
        switch (this.f1036a) {
            case 0:
                MulticastFileObserver.Companion.observe$lambda$4((String) this.b, (l) this.c);
                break;
            default:
                c.a((c) this.b, (Runnable) this.c);
                break;
        }
    }
}
