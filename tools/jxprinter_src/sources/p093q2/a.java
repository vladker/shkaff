package p093q2;

import com.microsoft.schemas.office.drawing.x2008.diagram.impl.CTGroupShapeImpl;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7838a;
    public final /* synthetic */ CTGroupShapeImpl b;

    public /* synthetic */ a(CTGroupShapeImpl cTGroupShapeImpl, int i5) {
        this.f7838a = i5;
        this.b = cTGroupShapeImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7838a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getSpArray(iIntValue);
            case 1:
                return this.b.insertNewSp(iIntValue);
            case 2:
                return this.b.getGrpSpArray(iIntValue);
            default:
                return this.b.insertNewGrpSp(iIntValue);
        }
    }
}
