package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSimpleFieldImpl;

/* JADX INFO: renamed from: s5.n3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1709n3 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8449a;
    public final /* synthetic */ CTSimpleFieldImpl b;

    public /* synthetic */ C1709n3(CTSimpleFieldImpl cTSimpleFieldImpl, int i5) {
        this.f8449a = i5;
        this.b = cTSimpleFieldImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8449a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getCustomXmlMoveFromRangeEndArray(iIntValue);
            case 1:
                return this.b.getProofErrArray(iIntValue);
            case 2:
                return this.b.insertNewProofErr(iIntValue);
            case 3:
                return this.b.getFldSimpleArray(iIntValue);
            case 4:
                return this.b.insertNewFldSimple(iIntValue);
            case 5:
                return this.b.getMoveToRangeStartArray(iIntValue);
            case 6:
                return this.b.getSubDocArray(iIntValue);
            case 7:
                return this.b.insertNewSubDoc(iIntValue);
            case 8:
                return this.b.getBdoArray(iIntValue);
            case 9:
                return this.b.insertNewBdo(iIntValue);
            case 10:
                return this.b.getDelArray(iIntValue);
            case 11:
                return this.b.insertNewDel(iIntValue);
            case 12:
                return this.b.getPermEndArray(iIntValue);
            case 13:
                return this.b.insertNewPermEnd(iIntValue);
            case 14:
                return this.b.insertNewMoveToRangeStart(iIntValue);
            case 15:
                return this.b.getCustomXmlArray(iIntValue);
            case 16:
                return this.b.insertNewCustomXml(iIntValue);
            case 17:
                return this.b.getCustomXmlInsRangeStartArray(iIntValue);
            case 18:
                return this.b.insertNewCustomXmlInsRangeStart(iIntValue);
            case 19:
                return this.b.getCustomXmlInsRangeEndArray(iIntValue);
            case 20:
                return this.b.insertNewCustomXmlInsRangeEnd(iIntValue);
            case 21:
                return this.b.getMoveToArray(iIntValue);
            case 22:
                return this.b.insertNewMoveTo(iIntValue);
            case 23:
                return this.b.getPermStartArray(iIntValue);
            case 24:
                return this.b.insertNewPermStart(iIntValue);
            case 25:
                return this.b.getCommentRangeStartArray(iIntValue);
            case 26:
                return this.b.insertNewCommentRangeStart(iIntValue);
            case 27:
                return this.b.getMoveFromRangeEndArray(iIntValue);
            case 28:
                return this.b.getDirArray(iIntValue);
            default:
                return this.b.insertNewDir(iIntValue);
        }
    }
}
