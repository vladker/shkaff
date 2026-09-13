package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRImpl;

/* JADX INFO: renamed from: s5.u1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1741u1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8482a;
    public final /* synthetic */ CTRImpl b;

    public /* synthetic */ C1741u1(CTRImpl cTRImpl, int i5) {
        this.f8482a = i5;
        this.b = cTRImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8482a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.insertNewSym(iIntValue);
            case 1:
                return this.b.getAnnotationRefArray(iIntValue);
            case 2:
                return this.b.insertNewAnnotationRef(iIntValue);
            case 3:
                return this.b.getPgNumArray(iIntValue);
            case 4:
                return this.b.insertNewPgNum(iIntValue);
            case 5:
                return this.b.insertNewTab(iIntValue);
            case 6:
                return this.b.getEndnoteRefArray(iIntValue);
            case 7:
                return this.b.insertNewEndnoteRef(iIntValue);
            case 8:
                return this.b.getTArray(iIntValue);
            case 9:
                return this.b.insertNewT(iIntValue);
            case 10:
                return this.b.getFootnoteRefArray(iIntValue);
            case 11:
                return this.b.insertNewFootnoteRef(iIntValue);
            case 12:
                return this.b.getDelInstrTextArray(iIntValue);
            case 13:
                return this.b.insertNewDelInstrText(iIntValue);
            case 14:
                return this.b.getNoBreakHyphenArray(iIntValue);
            case 15:
                return this.b.insertNewNoBreakHyphen(iIntValue);
            case 16:
                return this.b.getPictArray(iIntValue);
            case 17:
                return this.b.insertNewPict(iIntValue);
            case 18:
                return this.b.getDelTextArray(iIntValue);
            case 19:
                return this.b.getYearLongArray(iIntValue);
            case 20:
                return this.b.insertNewYearLong(iIntValue);
            case 21:
                return this.b.getPtabArray(iIntValue);
            case 22:
                return this.b.insertNewPtab(iIntValue);
            case 23:
                return this.b.getEndnoteReferenceArray(iIntValue);
            case 24:
                return this.b.insertNewEndnoteReference(iIntValue);
            case 25:
                return this.b.getMonthShortArray(iIntValue);
            case 26:
                return this.b.insertNewMonthShort(iIntValue);
            case 27:
                return this.b.insertNewDelText(iIntValue);
            case 28:
                return this.b.getBrArray(iIntValue);
            default:
                return this.b.insertNewBr(iIntValue);
        }
    }
}
