package p5;

import java.util.function.Function;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTRImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class l0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7818a;
    public final /* synthetic */ CTRImpl b;

    public /* synthetic */ l0(CTRImpl cTRImpl, int i5) {
        this.f7818a = i5;
        this.b = cTRImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7818a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getFootnoteReferenceArray(iIntValue);
            case 1:
                return this.b.insertNewFootnoteReference(iIntValue);
            case 2:
                return this.b.getPgNumArray(iIntValue);
            case 3:
                return this.b.insertNewPgNum(iIntValue);
            case 4:
                return this.b.getLastRenderedPageBreakArray(iIntValue);
            case 5:
                return this.b.insertNewLastRenderedPageBreak(iIntValue);
            case 6:
                return this.b.getObjectArray(iIntValue);
            default:
                return this.b.insertNewObject(iIntValue);
        }
    }
}
