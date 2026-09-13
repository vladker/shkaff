package org.apache.xmlbeans.impl.values;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.SimpleValue;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class d implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7452a;
    public final /* synthetic */ SimpleValue[] b;

    public /* synthetic */ d(SimpleValue[] simpleValueArr, int i5) {
        this.f7452a = i5;
        this.b = simpleValueArr;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        XmlObjectBase xmlObjectBase = (XmlObjectBase) obj;
        Integer num = (Integer) obj2;
        switch (this.f7452a) {
            case 0:
                XmlComplexContentImpl.lambda$arraySetterHelper$1(this.b, xmlObjectBase, num);
                break;
            default:
                XmlComplexContentImpl.lambda$arraySetterHelper$0(this.b, xmlObjectBase, num);
                break;
        }
    }
}
