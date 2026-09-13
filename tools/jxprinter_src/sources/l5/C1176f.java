package l5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTBackgroundFillStyleListImpl;

/* JADX INFO: renamed from: l5.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1176f implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5994a;
    public final /* synthetic */ CTBackgroundFillStyleListImpl b;

    public /* synthetic */ C1176f(CTBackgroundFillStyleListImpl cTBackgroundFillStyleListImpl, int i5) {
        this.f5994a = i5;
        this.b = cTBackgroundFillStyleListImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f5994a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setNoFillArray(iIntValue, (CTNoFillProperties) obj2);
                break;
            case 1:
                this.b.setGradFillArray(iIntValue, (CTGradientFillProperties) obj2);
                break;
            case 2:
                this.b.setBlipFillArray(iIntValue, (CTBlipFillProperties) obj2);
                break;
            case 3:
                this.b.setPattFillArray(iIntValue, (CTPatternFillProperties) obj2);
                break;
            case 4:
                this.b.setSolidFillArray(iIntValue, (CTSolidColorFillProperties) obj2);
                break;
            default:
                this.b.setGrpFillArray(iIntValue, (CTGroupFillProperties) obj2);
                break;
        }
    }
}
