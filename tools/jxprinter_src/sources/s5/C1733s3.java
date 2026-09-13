package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSimpleFieldImpl;

/* JADX INFO: renamed from: s5.s3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1733s3 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8474a;
    public final /* synthetic */ CTSimpleFieldImpl b;

    public /* synthetic */ C1733s3(CTSimpleFieldImpl cTSimpleFieldImpl, int i5) {
        this.f8474a = i5;
        this.b = cTSimpleFieldImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8474a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getCustomXmlMoveToRangeEndArray(iIntValue);
            case 1:
                return this.b.insertNewCustomXmlMoveToRangeEnd(iIntValue);
            case 2:
                return this.b.getBookmarkEndArray(iIntValue);
            case 3:
                return this.b.insertNewBookmarkEnd(iIntValue);
            case 4:
                return this.b.getMoveFromArray(iIntValue);
            case 5:
                return this.b.insertNewMoveFrom(iIntValue);
            case 6:
                return this.b.getBookmarkStartArray(iIntValue);
            default:
                return this.b.insertNewBookmarkStart(iIntValue);
        }
    }
}
