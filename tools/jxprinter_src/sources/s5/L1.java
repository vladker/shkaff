package s5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFitText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHighlight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextScale;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalAlignRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRPrOriginalImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class L1 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8299a;
    public final /* synthetic */ CTRPrOriginalImpl b;

    public /* synthetic */ L1(CTRPrOriginalImpl cTRPrOriginalImpl, int i5) {
        this.f8299a = i5;
        this.b = cTRPrOriginalImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8299a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setSzArray(iIntValue, (CTHpsMeasure) obj2);
                break;
            case 1:
                this.b.setPositionArray(iIntValue, (CTSignedHpsMeasure) obj2);
                break;
            case 2:
                this.b.setRStyleArray(iIntValue, (CTString) obj2);
                break;
            case 3:
                this.b.setWArray(iIntValue, (CTTextScale) obj2);
                break;
            case 4:
                this.b.setDstrikeArray(iIntValue, (CTOnOff) obj2);
                break;
            case 5:
                this.b.setBdrArray(iIntValue, (CTBorder) obj2);
                break;
            case 6:
                this.b.setFitTextArray(iIntValue, (CTFitText) obj2);
                break;
            case 7:
                this.b.setSpecVanishArray(iIntValue, (CTOnOff) obj2);
                break;
            case 8:
                this.b.setLangArray(iIntValue, (CTLanguage) obj2);
                break;
            case 9:
                this.b.setBArray(iIntValue, (CTOnOff) obj2);
                break;
            case 10:
                this.b.setNoProofArray(iIntValue, (CTOnOff) obj2);
                break;
            case 11:
                this.b.setWebHiddenArray(iIntValue, (CTOnOff) obj2);
                break;
            case 12:
                this.b.setKernArray(iIntValue, (CTHpsMeasure) obj2);
                break;
            case 13:
                this.b.setUArray(iIntValue, (CTUnderline) obj2);
                break;
            case 14:
                this.b.setSmallCapsArray(iIntValue, (CTOnOff) obj2);
                break;
            case 15:
                this.b.setEmbossArray(iIntValue, (CTOnOff) obj2);
                break;
            case 16:
                this.b.setHighlightArray(iIntValue, (CTHighlight) obj2);
                break;
            case 17:
                this.b.setCapsArray(iIntValue, (CTOnOff) obj2);
                break;
            case 18:
                this.b.setImprintArray(iIntValue, (CTOnOff) obj2);
                break;
            case 19:
                this.b.setSzCsArray(iIntValue, (CTHpsMeasure) obj2);
                break;
            case 20:
                this.b.setCsArray(iIntValue, (CTOnOff) obj2);
                break;
            case 21:
                this.b.setShadowArray(iIntValue, (CTOnOff) obj2);
                break;
            case 22:
                this.b.setVanishArray(iIntValue, (CTOnOff) obj2);
                break;
            case 23:
                this.b.setVertAlignArray(iIntValue, (CTVerticalAlignRun) obj2);
                break;
            case 24:
                this.b.setOMathArray(iIntValue, (CTOnOff) obj2);
                break;
            case 25:
                this.b.setICsArray(iIntValue, (CTOnOff) obj2);
                break;
            case 26:
                this.b.setIArray(iIntValue, (CTOnOff) obj2);
                break;
            case 27:
                this.b.setSpacingArray(iIntValue, (CTSignedTwipsMeasure) obj2);
                break;
            case 28:
                this.b.setOutlineArray(iIntValue, (CTOnOff) obj2);
                break;
            default:
                this.b.setBCsArray(iIntValue, (CTOnOff) obj2);
                break;
        }
    }
}
