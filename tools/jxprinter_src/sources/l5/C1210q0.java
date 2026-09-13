package l5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTFillStyleListImpl;

/* JADX INFO: renamed from: l5.q0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1210q0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6035a;
    public final /* synthetic */ CTFillStyleListImpl b;

    public /* synthetic */ C1210q0(CTFillStyleListImpl cTFillStyleListImpl, int i5) {
        this.f6035a = i5;
        this.b = cTFillStyleListImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f6035a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setSolidFillArray(iIntValue, (CTSolidColorFillProperties) obj2);
                break;
            case 1:
                this.b.setBlipFillArray(iIntValue, (CTBlipFillProperties) obj2);
                break;
            case 2:
                this.b.setGrpFillArray(iIntValue, (CTGroupFillProperties) obj2);
                break;
            case 3:
                this.b.setGradFillArray(iIntValue, (CTGradientFillProperties) obj2);
                break;
            case 4:
                this.b.setNoFillArray(iIntValue, (CTNoFillProperties) obj2);
                break;
            default:
                this.b.setPattFillArray(iIntValue, (CTPatternFillProperties) obj2);
                break;
        }
    }
}
