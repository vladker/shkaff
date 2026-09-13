package X3;

import W3.InterfaceC0233q;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements InterfaceC0233q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f854a;
    public final /* synthetic */ CharSequence b;

    public /* synthetic */ a0(CharSequence charSequence, int i5) {
        this.f854a = i5;
        this.b = charSequence;
    }

    @Override // W3.InterfaceC0233q
    public final Iterator iterator() {
        switch (this.f854a) {
            case 0:
                return new C0253t(this.b);
            default:
                return b0.iterator(this.b);
        }
    }
}
