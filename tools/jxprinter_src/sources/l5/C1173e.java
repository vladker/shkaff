package l5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTBackgroundFillStyleListImpl;

/* JADX INFO: renamed from: l5.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1173e implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5990a;
    public final /* synthetic */ CTBackgroundFillStyleListImpl b;

    public /* synthetic */ C1173e(CTBackgroundFillStyleListImpl cTBackgroundFillStyleListImpl, int i5) {
        this.f5990a = i5;
        this.b = cTBackgroundFillStyleListImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f5990a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getBlipFillArray(iIntValue);
            case 1:
                return this.b.getNoFillArray(iIntValue);
            case 2:
                return this.b.insertNewNoFill(iIntValue);
            case 3:
                return this.b.getGradFillArray(iIntValue);
            case 4:
                return this.b.insertNewGradFill(iIntValue);
            case 5:
                return this.b.getPattFillArray(iIntValue);
            case 6:
                return this.b.insertNewPattFill(iIntValue);
            case 7:
                return this.b.getSolidFillArray(iIntValue);
            case 8:
                return this.b.insertNewSolidFill(iIntValue);
            case 9:
                return this.b.insertNewBlipFill(iIntValue);
            case 10:
                return this.b.getGrpFillArray(iIntValue);
            default:
                return this.b.insertNewGrpFill(iIntValue);
        }
    }
}
