package org.apache.xmlbeans.impl.store;

import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7386a;
    public final /* synthetic */ int b;

    public /* synthetic */ C(int i5, int i6) {
        this.f7386a = i6;
        this.b = i5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7386a) {
            case 0:
                return DomImpl.lambda$_attributes_item$27(this.b, (DomImpl.Dom) obj);
            default:
                return DomImpl.lambda$_childNodes_item$16(this.b, (DomImpl.Dom) obj);
        }
    }
}
