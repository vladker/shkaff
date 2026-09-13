package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTBdoContentRunImpl;

/* JADX INFO: renamed from: s5.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1645b implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8377a;
    public final /* synthetic */ CTBdoContentRunImpl b;

    public /* synthetic */ C1645b(CTBdoContentRunImpl cTBdoContentRunImpl, int i5) {
        this.f8377a = i5;
        this.b = cTBdoContentRunImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8377a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getPermStartArray(iIntValue);
            case 1:
                return this.b.getCustomXmlMoveFromRangeEndArray(iIntValue);
            case 2:
                return this.b.insertNewCustomXmlMoveFromRangeEnd(iIntValue);
            case 3:
                return this.b.getMoveFromArray(iIntValue);
            case 4:
                return this.b.insertNewMoveFrom(iIntValue);
            case 5:
                return this.b.getCustomXmlInsRangeStartArray(iIntValue);
            case 6:
                return this.b.getProofErrArray(iIntValue);
            case 7:
                return this.b.insertNewProofErr(iIntValue);
            case 8:
                return this.b.getFldSimpleArray(iIntValue);
            case 9:
                return this.b.insertNewFldSimple(iIntValue);
            case 10:
                return this.b.getHyperlinkArray(iIntValue);
            case 11:
                return this.b.insertNewHyperlink(iIntValue);
            case 12:
                return this.b.getOMathParaArray(iIntValue);
            case 13:
                return this.b.insertNewOMathPara(iIntValue);
            case 14:
                return this.b.insertNewCustomXmlInsRangeStart(iIntValue);
            case 15:
                return this.b.getDirArray(iIntValue);
            case 16:
                return this.b.insertNewDir(iIntValue);
            case 17:
                return this.b.getCustomXmlArray(iIntValue);
            case 18:
                return this.b.insertNewCustomXml(iIntValue);
            case 19:
                return this.b.getInsArray(iIntValue);
            case 20:
                return this.b.insertNewIns(iIntValue);
            case 21:
                return this.b.getBookmarkStartArray(iIntValue);
            case 22:
                return this.b.insertNewBookmarkStart(iIntValue);
            case 23:
                return this.b.getCustomXmlMoveToRangeEndArray(iIntValue);
            case 24:
                return this.b.insertNewCustomXmlMoveToRangeEnd(iIntValue);
            case 25:
                return this.b.getSubDocArray(iIntValue);
            case 26:
                return this.b.insertNewSubDoc(iIntValue);
            case 27:
                return this.b.getBdoArray(iIntValue);
            case 28:
                return this.b.getMoveToArray(iIntValue);
            default:
                return this.b.insertNewMoveTo(iIntValue);
        }
    }
}
