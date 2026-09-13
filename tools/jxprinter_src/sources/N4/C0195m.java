package N4;

import java.util.function.Function;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.ElementImpl;

/* JADX INFO: renamed from: N4.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C0195m implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f532a;
    public final /* synthetic */ ElementImpl b;

    public /* synthetic */ C0195m(ElementImpl elementImpl, int i5) {
        this.f532a = i5;
        this.b = elementImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f532a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getUniqueArray(iIntValue);
            case 1:
                return this.b.getKeyrefArray(iIntValue);
            case 2:
                return this.b.insertNewKeyref(iIntValue);
            case 3:
                return this.b.insertNewUnique(iIntValue);
            case 4:
                return this.b.getKeyArray(iIntValue);
            default:
                return this.b.insertNewKey(iIntValue);
        }
    }
}
