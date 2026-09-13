package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRunTrackChangeImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C2 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8255a;
    public final /* synthetic */ CTRunTrackChangeImpl b;

    public /* synthetic */ C2(CTRunTrackChangeImpl cTRunTrackChangeImpl, int i5) {
        this.f8255a = i5;
        this.b = cTRunTrackChangeImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8255a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.insertNewGroupChr(iIntValue);
            case 1:
                return this.b.getBorderBoxArray(iIntValue);
            case 2:
                return this.b.insertNewBorderBox(iIntValue);
            case 3:
                return this.b.insertNewBookmarkEnd(iIntValue);
            case 4:
                return this.b.getCustomXmlInsRangeStartArray(iIntValue);
            case 5:
                return this.b.insertNewCustomXmlInsRangeStart(iIntValue);
            case 6:
                return this.b.getLimUppArray(iIntValue);
            case 7:
                return this.b.insertNewLimUpp(iIntValue);
            case 8:
                return this.b.getLimLowArray(iIntValue);
            case 9:
                return this.b.insertNewLimLow(iIntValue);
            case 10:
                return this.b.getCustomXmlMoveToRangeStartArray(iIntValue);
            default:
                return this.b.insertNewCustomXmlMoveToRangeStart(iIntValue);
        }
    }
}
