package p049i4;

import E3.q;
import p007a4.InterfaceC0280h0;
import p028e4.E;
import p044h4.p;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f4065a;
    public final Object owner;
    public final p select;

    public d(g gVar, p pVar, Object obj) {
        this.f4065a = gVar;
        this.select = pVar;
        this.owner = obj;
    }

    @Override // p044h4.p, p044h4.o
    public void disposeOnCompletion(InterfaceC0280h0 interfaceC0280h0) {
        this.select.disposeOnCompletion(interfaceC0280h0);
    }

    @Override // p044h4.p, p044h4.o
    public q getContext() {
        return this.select.getContext();
    }

    @Override // p044h4.p, p007a4.B1
    public void invokeOnCancellation(E e, int i5) {
        this.select.invokeOnCancellation(e, i5);
    }

    @Override // p044h4.p, p044h4.o
    public void selectInRegistrationPhase(Object obj) {
        g.f4068g.set(this.f4065a, this.owner);
        this.select.selectInRegistrationPhase(obj);
    }

    @Override // p044h4.p, p044h4.o
    public boolean trySelect(Object obj, Object obj2) {
        boolean zTrySelect = this.select.trySelect(obj, obj2);
        if (zTrySelect) {
            g.f4068g.set(this.f4065a, this.owner);
        }
        return zTrySelect;
    }
}
