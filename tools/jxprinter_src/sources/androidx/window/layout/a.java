package androidx.window.layout;

import androidx.core.util.Consumer;
import p018c4.x0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1083a;
    public final /* synthetic */ x0 b;

    public /* synthetic */ a(x0 x0Var, int i5) {
        this.f1083a = i5;
        this.b = x0Var;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        switch (this.f1083a) {
            case 0:
                this.b.mo1011trySendJP2dKIU((WindowLayoutInfo) obj);
                break;
            default:
                this.b.mo1011trySendJP2dKIU((WindowLayoutInfo) obj);
                break;
        }
    }
}
