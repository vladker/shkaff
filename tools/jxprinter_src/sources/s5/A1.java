package s5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFitText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHighlight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextScale;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalAlignRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRPrImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class A1 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8244a;
    public final /* synthetic */ CTRPrImpl b;

    public /* synthetic */ A1(CTRPrImpl cTRPrImpl, int i5) {
        this.f8244a = i5;
        this.b = cTRPrImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8244a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setKernArray(iIntValue, (CTHpsMeasure) obj2);
                break;
            case 1:
                this.b.setSzCsArray(iIntValue, (CTHpsMeasure) obj2);
                break;
            case 2:
                this.b.setICsArray(iIntValue, (CTOnOff) obj2);
                break;
            case 3:
                this.b.setCapsArray(iIntValue, (CTOnOff) obj2);
                break;
            case 4:
                this.b.setOutlineArray(iIntValue, (CTOnOff) obj2);
                break;
            case 5:
                this.b.setShadowArray(iIntValue, (CTOnOff) obj2);
                break;
            case 6:
                this.b.setHighlightArray(iIntValue, (CTHighlight) obj2);
                break;
            case 7:
                this.b.setVertAlignArray(iIntValue, (CTVerticalAlignRun) obj2);
                break;
            case 8:
                this.b.setShdArray(iIntValue, (CTShd) obj2);
                break;
            case 9:
                this.b.setRtlArray(iIntValue, (CTOnOff) obj2);
                break;
            case 10:
                this.b.setEmbossArray(iIntValue, (CTOnOff) obj2);
                break;
            case 11:
                this.b.setStrikeArray(iIntValue, (CTOnOff) obj2);
                break;
            case 12:
                this.b.setRStyleArray(iIntValue, (CTString) obj2);
                break;
            case 13:
                this.b.setBCsArray(iIntValue, (CTOnOff) obj2);
                break;
            case 14:
                this.b.setUArray(iIntValue, (CTUnderline) obj2);
                break;
            case 15:
                this.b.setBArray(iIntValue, (CTOnOff) obj2);
                break;
            case 16:
                this.b.setSmallCapsArray(iIntValue, (CTOnOff) obj2);
                break;
            case 17:
                this.b.setSzArray(iIntValue, (CTHpsMeasure) obj2);
                break;
            case 18:
                this.b.setColorArray(iIntValue, (CTColor) obj2);
                break;
            case 19:
                this.b.setCsArray(iIntValue, (CTOnOff) obj2);
                break;
            case 20:
                this.b.setFitTextArray(iIntValue, (CTFitText) obj2);
                break;
            case 21:
                this.b.setWebHiddenArray(iIntValue, (CTOnOff) obj2);
                break;
            case 22:
                this.b.setSnapToGridArray(iIntValue, (CTOnOff) obj2);
                break;
            case 23:
                this.b.setWArray(iIntValue, (CTTextScale) obj2);
                break;
            case 24:
                this.b.setOMathArray(iIntValue, (CTOnOff) obj2);
                break;
            case 25:
                this.b.setEmArray(iIntValue, (CTEm) obj2);
                break;
            case 26:
                this.b.setNoProofArray(iIntValue, (CTOnOff) obj2);
                break;
            case 27:
                this.b.setImprintArray(iIntValue, (CTOnOff) obj2);
                break;
            case 28:
                this.b.setIArray(iIntValue, (CTOnOff) obj2);
                break;
            default:
                this.b.setVanishArray(iIntValue, (CTOnOff) obj2);
                break;
        }
    }
}
