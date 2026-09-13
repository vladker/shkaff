package l5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTTextParagraphImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class h2 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6005a;
    public final /* synthetic */ CTTextParagraphImpl b;

    public /* synthetic */ h2(CTTextParagraphImpl cTTextParagraphImpl, int i5) {
        this.f6005a = i5;
        this.b = cTTextParagraphImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f6005a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getFldArray(iIntValue);
            case 1:
                return this.b.getRArray(iIntValue);
            case 2:
                return this.b.insertNewR(iIntValue);
            case 3:
                return this.b.insertNewFld(iIntValue);
            case 4:
                return this.b.getBrArray(iIntValue);
            default:
                return this.b.insertNewBr(iIntValue);
        }
    }
}
