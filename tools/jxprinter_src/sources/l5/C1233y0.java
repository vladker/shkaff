package l5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFixedPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositivePercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTHslColorImpl;

/* JADX INFO: renamed from: l5.y0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1233y0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6059a;
    public final /* synthetic */ CTHslColorImpl b;

    public /* synthetic */ C1233y0(CTHslColorImpl cTHslColorImpl, int i5) {
        this.f6059a = i5;
        this.b = cTHslColorImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f6059a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setLumModArray(iIntValue, (CTPercentage) obj2);
                break;
            case 1:
                this.b.setRedModArray(iIntValue, (CTPercentage) obj2);
                break;
            case 2:
                this.b.setSatArray(iIntValue, (CTPercentage) obj2);
                break;
            case 3:
                this.b.setAlphaModArray(iIntValue, (CTPositivePercentage) obj2);
                break;
            case 4:
                this.b.setGreenArray(iIntValue, (CTPercentage) obj2);
                break;
            case 5:
                this.b.setAlphaOffArray(iIntValue, (CTFixedPercentage) obj2);
                break;
            case 6:
                this.b.setRedOffArray(iIntValue, (CTPercentage) obj2);
                break;
            case 7:
                this.b.setGreenOffArray(iIntValue, (CTPercentage) obj2);
                break;
            case 8:
                this.b.setBlueModArray(iIntValue, (CTPercentage) obj2);
                break;
            case 9:
                this.b.setSatModArray(iIntValue, (CTPercentage) obj2);
                break;
            case 10:
                this.b.setShadeArray(iIntValue, (CTPositiveFixedPercentage) obj2);
                break;
            case 11:
                this.b.setHueModArray(iIntValue, (CTPositivePercentage) obj2);
                break;
            case 12:
                this.b.setGreenModArray(iIntValue, (CTPercentage) obj2);
                break;
            case 13:
                this.b.setBlueArray(iIntValue, (CTPercentage) obj2);
                break;
            case 14:
                this.b.setTintArray(iIntValue, (CTPositiveFixedPercentage) obj2);
                break;
            case 15:
                this.b.setBlueOffArray(iIntValue, (CTPercentage) obj2);
                break;
            case 16:
                this.b.setLumOffArray(iIntValue, (CTPercentage) obj2);
                break;
            case 17:
                this.b.setAlphaArray(iIntValue, (CTPositiveFixedPercentage) obj2);
                break;
            case 18:
                this.b.setSatOffArray(iIntValue, (CTPercentage) obj2);
                break;
            case 19:
                this.b.setRedArray(iIntValue, (CTPercentage) obj2);
                break;
            default:
                this.b.setLumArray(iIntValue, (CTPercentage) obj2);
                break;
        }
    }
}
