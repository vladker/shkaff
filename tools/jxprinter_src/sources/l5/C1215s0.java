package l5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTFillStyleListImpl;

/* JADX INFO: renamed from: l5.s0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1215s0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6041a;
    public final /* synthetic */ CTFillStyleListImpl b;

    public /* synthetic */ C1215s0(CTFillStyleListImpl cTFillStyleListImpl, int i5) {
        this.f6041a = i5;
        this.b = cTFillStyleListImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfSolidFillArray;
        switch (this.f6041a) {
            case 0:
                iSizeOfSolidFillArray = this.b.sizeOfSolidFillArray();
                break;
            case 1:
                iSizeOfSolidFillArray = this.b.sizeOfBlipFillArray();
                break;
            case 2:
                iSizeOfSolidFillArray = this.b.sizeOfGradFillArray();
                break;
            case 3:
                iSizeOfSolidFillArray = this.b.sizeOfNoFillArray();
                break;
            case 4:
                iSizeOfSolidFillArray = this.b.sizeOfGrpFillArray();
                break;
            default:
                iSizeOfSolidFillArray = this.b.sizeOfPattFillArray();
                break;
        }
        return Integer.valueOf(iSizeOfSolidFillArray);
    }
}
