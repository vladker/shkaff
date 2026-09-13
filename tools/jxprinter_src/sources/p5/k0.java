package p5;

import java.util.function.Function;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTRImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class k0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7816a;
    public final /* synthetic */ CTRImpl b;

    public /* synthetic */ k0(CTRImpl cTRImpl, int i5) {
        this.f7816a = i5;
        this.b = cTRImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7816a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getT2Array(iIntValue);
            case 1:
                return this.b.insertNewT2(iIntValue);
            case 2:
                return this.b.insertNewAnnotationRef(iIntValue);
            case 3:
                return this.b.getYearShortArray(iIntValue);
            case 4:
                return this.b.insertNewYearShort(iIntValue);
            case 5:
                return this.b.getInstrTextArray(iIntValue);
            case 6:
                return this.b.insertNewInstrText(iIntValue);
            case 7:
                return this.b.insertNewSeparator(iIntValue);
            case 8:
                return this.b.getDelTextArray(iIntValue);
            case 9:
                return this.b.insertNewDelText(iIntValue);
            case 10:
                return this.b.getPictArray(iIntValue);
            case 11:
                return this.b.insertNewPict(iIntValue);
            case 12:
                return this.b.getSoftHyphenArray(iIntValue);
            case 13:
                return this.b.insertNewSoftHyphen(iIntValue);
            case 14:
                return this.b.getYearLongArray(iIntValue);
            case 15:
                return this.b.insertNewYearLong(iIntValue);
            case 16:
                return this.b.getCrArray(iIntValue);
            case 17:
                return this.b.insertNewCr(iIntValue);
            case 18:
                return this.b.getTArray(iIntValue);
            case 19:
                return this.b.insertNewT(iIntValue);
            case 20:
                return this.b.getDelInstrTextArray(iIntValue);
            case 21:
                return this.b.getMonthShortArray(iIntValue);
            case 22:
                return this.b.insertNewMonthShort(iIntValue);
            case 23:
                return this.b.getFldCharArray(iIntValue);
            case 24:
                return this.b.insertNewFldChar(iIntValue);
            case 25:
                return this.b.getRubyArray(iIntValue);
            case 26:
                return this.b.insertNewRuby(iIntValue);
            case 27:
                return this.b.getNoBreakHyphenArray(iIntValue);
            case 28:
                return this.b.insertNewNoBreakHyphen(iIntValue);
            default:
                return this.b.insertNewDelInstrText(iIntValue);
        }
    }
}
