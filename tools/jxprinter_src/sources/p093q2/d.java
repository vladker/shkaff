package p093q2;

import com.microsoft.schemas.office.drawing.x2008.diagram.impl.CTGroupShapeImpl;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7841a;
    public final /* synthetic */ CTGroupShapeImpl b;

    public /* synthetic */ d(CTGroupShapeImpl cTGroupShapeImpl, int i5) {
        this.f7841a = i5;
        this.b = cTGroupShapeImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfSpArray;
        switch (this.f7841a) {
            case 0:
                iSizeOfSpArray = this.b.sizeOfSpArray();
                break;
            default:
                iSizeOfSpArray = this.b.sizeOfGrpSpArray();
                break;
        }
        return Integer.valueOf(iSizeOfSpArray);
    }
}
