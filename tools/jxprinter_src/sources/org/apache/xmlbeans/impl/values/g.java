package org.apache.xmlbeans.impl.values;

import java.util.function.BiConsumer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class g implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7455a;
    public final /* synthetic */ long[] b;

    public /* synthetic */ g(long[] jArr, int i5) {
        this.f7455a = i5;
        this.b = jArr;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        XmlObjectBase xmlObjectBase = (XmlObjectBase) obj;
        Integer num = (Integer) obj2;
        switch (this.f7455a) {
            case 0:
                XmlComplexContentImpl.lambda$arraySetterHelper$15(this.b, xmlObjectBase, num);
                break;
            default:
                XmlComplexContentImpl.lambda$arraySetterHelper$8(this.b, xmlObjectBase, num);
                break;
        }
    }
}
