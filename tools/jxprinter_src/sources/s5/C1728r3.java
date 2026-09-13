package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSimpleFieldImpl;

/* JADX INFO: renamed from: s5.r3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1728r3 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8469a;
    public final /* synthetic */ CTSimpleFieldImpl b;

    public /* synthetic */ C1728r3(CTSimpleFieldImpl cTSimpleFieldImpl, int i5) {
        this.f8469a = i5;
        this.b = cTSimpleFieldImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8469a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getCommentRangeEndArray(iIntValue);
            case 1:
                return this.b.insertNewCommentRangeEnd(iIntValue);
            case 2:
                return this.b.insertNewMoveFromRangeEnd(iIntValue);
            case 3:
                return this.b.getMoveToRangeEndArray(iIntValue);
            case 4:
                return this.b.insertNewMoveToRangeEnd(iIntValue);
            case 5:
                return this.b.getCustomXmlMoveToRangeStartArray(iIntValue);
            case 6:
                return this.b.insertNewCustomXmlMoveToRangeStart(iIntValue);
            case 7:
                return this.b.insertNewCustomXmlMoveFromRangeEnd(iIntValue);
            case 8:
                return this.b.getHyperlinkArray(iIntValue);
            case 9:
                return this.b.insertNewHyperlink(iIntValue);
            case 10:
                return this.b.getCustomXmlDelRangeEndArray(iIntValue);
            case 11:
                return this.b.insertNewCustomXmlDelRangeEnd(iIntValue);
            case 12:
                return this.b.getSdtArray(iIntValue);
            case 13:
                return this.b.insertNewSdt(iIntValue);
            case 14:
                return this.b.getRArray(iIntValue);
            case 15:
                return this.b.insertNewR(iIntValue);
            case 16:
                return this.b.getSmartTagArray(iIntValue);
            case 17:
                return this.b.insertNewSmartTag(iIntValue);
            case 18:
                return this.b.getOMathArray(iIntValue);
            case 19:
                return this.b.insertNewOMath(iIntValue);
            case 20:
                return this.b.getInsArray(iIntValue);
            case 21:
                return this.b.getCustomXmlMoveFromRangeStartArray(iIntValue);
            case 22:
                return this.b.insertNewCustomXmlMoveFromRangeStart(iIntValue);
            case 23:
                return this.b.getMoveFromRangeStartArray(iIntValue);
            case 24:
                return this.b.insertNewMoveFromRangeStart(iIntValue);
            case 25:
                return this.b.getCustomXmlDelRangeStartArray(iIntValue);
            case 26:
                return this.b.insertNewCustomXmlDelRangeStart(iIntValue);
            case 27:
                return this.b.getOMathParaArray(iIntValue);
            case 28:
                return this.b.insertNewOMathPara(iIntValue);
            default:
                return this.b.insertNewIns(iIntValue);
        }
    }
}
