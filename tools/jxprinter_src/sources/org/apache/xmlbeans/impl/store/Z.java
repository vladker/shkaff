package org.apache.xmlbeans.impl.store;

import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Z implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7407a;
    public final /* synthetic */ String b;

    public /* synthetic */ Z(String str, int i5) {
        this.f7407a = i5;
        this.b = str;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f7407a) {
            case 0:
                DomImpl.lambda$_node_setPrefix$14(this.b, (DomImpl.Dom) obj);
                break;
            default:
                DomImpl.lambda$_node_setNodeValue$15(this.b, (DomImpl.Dom) obj);
                break;
        }
    }
}
