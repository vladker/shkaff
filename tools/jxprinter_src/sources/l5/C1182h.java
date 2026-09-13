package l5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTBackgroundFillStyleListImpl;

/* JADX INFO: renamed from: l5.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1182h implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6002a;
    public final /* synthetic */ CTBackgroundFillStyleListImpl b;

    public /* synthetic */ C1182h(CTBackgroundFillStyleListImpl cTBackgroundFillStyleListImpl, int i5) {
        this.f6002a = i5;
        this.b = cTBackgroundFillStyleListImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfNoFillArray;
        switch (this.f6002a) {
            case 0:
                iSizeOfNoFillArray = this.b.sizeOfNoFillArray();
                break;
            case 1:
                iSizeOfNoFillArray = this.b.sizeOfGradFillArray();
                break;
            case 2:
                iSizeOfNoFillArray = this.b.sizeOfPattFillArray();
                break;
            case 3:
                iSizeOfNoFillArray = this.b.sizeOfSolidFillArray();
                break;
            case 4:
                iSizeOfNoFillArray = this.b.sizeOfBlipFillArray();
                break;
            default:
                iSizeOfNoFillArray = this.b.sizeOfGrpFillArray();
                break;
        }
        return Integer.valueOf(iSizeOfNoFillArray);
    }
}
