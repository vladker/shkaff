package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTCustomXmlRunImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class F implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8267a;
    public final /* synthetic */ CTCustomXmlRunImpl b;

    public /* synthetic */ F(CTCustomXmlRunImpl cTCustomXmlRunImpl, int i5) {
        this.f8267a = i5;
        this.b = cTCustomXmlRunImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8267a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getOMathArray(iIntValue);
            case 1:
                return this.b.insertNewOMath(iIntValue);
            case 2:
                return this.b.getSubDocArray(iIntValue);
            case 3:
                return this.b.insertNewSubDoc(iIntValue);
            case 4:
                return this.b.getOMathParaArray(iIntValue);
            case 5:
                return this.b.insertNewOMathPara(iIntValue);
            case 6:
                return this.b.getMoveToRangeStartArray(iIntValue);
            default:
                return this.b.insertNewMoveToRangeStart(iIntValue);
        }
    }
}
