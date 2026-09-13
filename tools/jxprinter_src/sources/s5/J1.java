package s5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRPrImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class J1 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8289a;
    public final /* synthetic */ CTRPrImpl b;

    public /* synthetic */ J1(CTRPrImpl cTRPrImpl, int i5) {
        this.f8289a = i5;
        this.b = cTRPrImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8289a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setRFontsArray(iIntValue, (CTFonts) obj2);
                break;
            case 1:
                this.b.setLangArray(iIntValue, (CTLanguage) obj2);
                break;
            case 2:
                this.b.setSpacingArray(iIntValue, (CTSignedTwipsMeasure) obj2);
                break;
            case 3:
                this.b.setSpecVanishArray(iIntValue, (CTOnOff) obj2);
                break;
            case 4:
                this.b.setBdrArray(iIntValue, (CTBorder) obj2);
                break;
            case 5:
                this.b.setDstrikeArray(iIntValue, (CTOnOff) obj2);
                break;
            default:
                this.b.setPositionArray(iIntValue, (CTSignedHpsMeasure) obj2);
                break;
        }
    }
}
