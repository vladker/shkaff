package l5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTFillStyleListImpl;

/* JADX INFO: renamed from: l5.p0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1207p0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6032a;
    public final /* synthetic */ CTFillStyleListImpl b;

    public /* synthetic */ C1207p0(CTFillStyleListImpl cTFillStyleListImpl, int i5) {
        this.f6032a = i5;
        this.b = cTFillStyleListImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f6032a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getGrpFillArray(iIntValue);
            case 1:
                return this.b.getSolidFillArray(iIntValue);
            case 2:
                return this.b.insertNewSolidFill(iIntValue);
            case 3:
                return this.b.getBlipFillArray(iIntValue);
            case 4:
                return this.b.insertNewBlipFill(iIntValue);
            case 5:
                return this.b.getGradFillArray(iIntValue);
            case 6:
                return this.b.insertNewGradFill(iIntValue);
            case 7:
                return this.b.getNoFillArray(iIntValue);
            case 8:
                return this.b.insertNewNoFill(iIntValue);
            case 9:
                return this.b.insertNewGrpFill(iIntValue);
            case 10:
                return this.b.getPattFillArray(iIntValue);
            default:
                return this.b.insertNewPattFill(iIntValue);
        }
    }
}
