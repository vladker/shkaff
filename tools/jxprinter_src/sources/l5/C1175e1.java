package l5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFixedPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositivePercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTSRgbColorImpl;

/* JADX INFO: renamed from: l5.e1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1175e1 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5992a;
    public final /* synthetic */ CTSRgbColorImpl b;

    public /* synthetic */ C1175e1(CTSRgbColorImpl cTSRgbColorImpl, int i5) {
        this.f5992a = i5;
        this.b = cTSRgbColorImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f5992a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setHueModArray(iIntValue, (CTPositivePercentage) obj2);
                break;
            case 1:
                this.b.setBlueOffArray(iIntValue, (CTPercentage) obj2);
                break;
            case 2:
                this.b.setGreenOffArray(iIntValue, (CTPercentage) obj2);
                break;
            case 3:
                this.b.setRedArray(iIntValue, (CTPercentage) obj2);
                break;
            case 4:
                this.b.setLumOffArray(iIntValue, (CTPercentage) obj2);
                break;
            case 5:
                this.b.setBlueArray(iIntValue, (CTPercentage) obj2);
                break;
            case 6:
                this.b.setSatModArray(iIntValue, (CTPercentage) obj2);
                break;
            case 7:
                this.b.setGreenArray(iIntValue, (CTPercentage) obj2);
                break;
            case 8:
                this.b.setLumModArray(iIntValue, (CTPercentage) obj2);
                break;
            case 9:
                this.b.setAlphaModArray(iIntValue, (CTPositivePercentage) obj2);
                break;
            case 10:
                this.b.setBlueModArray(iIntValue, (CTPercentage) obj2);
                break;
            case 11:
                this.b.setGreenModArray(iIntValue, (CTPercentage) obj2);
                break;
            case 12:
                this.b.setSatArray(iIntValue, (CTPercentage) obj2);
                break;
            case 13:
                this.b.setLumArray(iIntValue, (CTPercentage) obj2);
                break;
            case 14:
                this.b.setAlphaArray(iIntValue, (CTPositiveFixedPercentage) obj2);
                break;
            case 15:
                this.b.setTintArray(iIntValue, (CTPositiveFixedPercentage) obj2);
                break;
            case 16:
                this.b.setAlphaOffArray(iIntValue, (CTFixedPercentage) obj2);
                break;
            case 17:
                this.b.setShadeArray(iIntValue, (CTPositiveFixedPercentage) obj2);
                break;
            case 18:
                this.b.setRedModArray(iIntValue, (CTPercentage) obj2);
                break;
            case 19:
                this.b.setSatOffArray(iIntValue, (CTPercentage) obj2);
                break;
            default:
                this.b.setRedOffArray(iIntValue, (CTPercentage) obj2);
                break;
        }
    }
}
