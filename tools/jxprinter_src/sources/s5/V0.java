package s5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFitText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHighlight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextScale;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTParaRPrImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class V0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8347a;
    public final /* synthetic */ CTParaRPrImpl b;

    public /* synthetic */ V0(CTParaRPrImpl cTParaRPrImpl, int i5) {
        this.f8347a = i5;
        this.b = cTParaRPrImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8347a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setDstrikeArray(iIntValue, (CTOnOff) obj2);
                break;
            case 1:
                this.b.setShadowArray(iIntValue, (CTOnOff) obj2);
                break;
            case 2:
                this.b.setCapsArray(iIntValue, (CTOnOff) obj2);
                break;
            case 3:
                this.b.setSmallCapsArray(iIntValue, (CTOnOff) obj2);
                break;
            case 4:
                this.b.setICsArray(iIntValue, (CTOnOff) obj2);
                break;
            case 5:
                this.b.setPositionArray(iIntValue, (CTSignedHpsMeasure) obj2);
                break;
            case 6:
                this.b.setIArray(iIntValue, (CTOnOff) obj2);
                break;
            case 7:
                this.b.setOutlineArray(iIntValue, (CTOnOff) obj2);
                break;
            case 8:
                this.b.setRtlArray(iIntValue, (CTOnOff) obj2);
                break;
            case 9:
                this.b.setSzCsArray(iIntValue, (CTHpsMeasure) obj2);
                break;
            case 10:
                this.b.setWebHiddenArray(iIntValue, (CTOnOff) obj2);
                break;
            case 11:
                this.b.setOMathArray(iIntValue, (CTOnOff) obj2);
                break;
            case 12:
                this.b.setCsArray(iIntValue, (CTOnOff) obj2);
                break;
            case 13:
                this.b.setNoProofArray(iIntValue, (CTOnOff) obj2);
                break;
            case 14:
                this.b.setHighlightArray(iIntValue, (CTHighlight) obj2);
                break;
            case 15:
                this.b.setKernArray(iIntValue, (CTHpsMeasure) obj2);
                break;
            case 16:
                this.b.setBdrArray(iIntValue, (CTBorder) obj2);
                break;
            case 17:
                this.b.setFitTextArray(iIntValue, (CTFitText) obj2);
                break;
            case 18:
                this.b.setBCsArray(iIntValue, (CTOnOff) obj2);
                break;
            case 19:
                this.b.setBArray(iIntValue, (CTOnOff) obj2);
                break;
            case 20:
                this.b.setSzArray(iIntValue, (CTHpsMeasure) obj2);
                break;
            case 21:
                this.b.setWArray(iIntValue, (CTTextScale) obj2);
                break;
            case 22:
                this.b.setRStyleArray(iIntValue, (CTString) obj2);
                break;
            case 23:
                this.b.setEmbossArray(iIntValue, (CTOnOff) obj2);
                break;
            case 24:
                this.b.setImprintArray(iIntValue, (CTOnOff) obj2);
                break;
            case 25:
                this.b.setColorArray(iIntValue, (CTColor) obj2);
                break;
            case 26:
                this.b.setUArray(iIntValue, (CTUnderline) obj2);
                break;
            case 27:
                this.b.setLangArray(iIntValue, (CTLanguage) obj2);
                break;
            case 28:
                this.b.setStrikeArray(iIntValue, (CTOnOff) obj2);
                break;
            default:
                this.b.setRFontsArray(iIntValue, (CTFonts) obj2);
                break;
        }
    }
}
