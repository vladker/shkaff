package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTBdoContentRunImpl;

/* JADX INFO: renamed from: s5.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1670g implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8407a;
    public final /* synthetic */ CTBdoContentRunImpl b;

    public /* synthetic */ C1670g(CTBdoContentRunImpl cTBdoContentRunImpl, int i5) {
        this.f8407a = i5;
        this.b = cTBdoContentRunImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8407a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getCommentRangeEndArray(iIntValue);
            case 1:
                return this.b.insertNewCommentRangeEnd(iIntValue);
            case 2:
                return this.b.getCustomXmlInsRangeEndArray(iIntValue);
            case 3:
                return this.b.insertNewCustomXmlInsRangeEnd(iIntValue);
            case 4:
                return this.b.getMoveFromRangeEndArray(iIntValue);
            case 5:
                return this.b.insertNewMoveFromRangeEnd(iIntValue);
            case 6:
                return this.b.getRArray(iIntValue);
            default:
                return this.b.insertNewR(iIntValue);
        }
    }
}
