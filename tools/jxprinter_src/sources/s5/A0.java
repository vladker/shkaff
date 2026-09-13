package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTHyperlinkImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class A0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8243a;
    public final /* synthetic */ CTHyperlinkImpl b;

    public /* synthetic */ A0(CTHyperlinkImpl cTHyperlinkImpl, int i5) {
        this.f8243a = i5;
        this.b = cTHyperlinkImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8243a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getCustomXmlInsRangeEndArray(iIntValue);
            case 1:
                return this.b.insertNewCustomXmlInsRangeEnd(iIntValue);
            case 2:
                return this.b.getFldSimpleArray(iIntValue);
            case 3:
                return this.b.insertNewFldSimple(iIntValue);
            case 4:
                return this.b.getMoveToArray(iIntValue);
            case 5:
                return this.b.insertNewMoveTo(iIntValue);
            case 6:
                return this.b.getOMathParaArray(iIntValue);
            default:
                return this.b.insertNewOMathPara(iIntValue);
        }
    }
}
