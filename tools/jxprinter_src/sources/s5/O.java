package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTDirContentRunImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class O implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8312a;
    public final /* synthetic */ CTDirContentRunImpl b;

    public /* synthetic */ O(CTDirContentRunImpl cTDirContentRunImpl, int i5) {
        this.f8312a = i5;
        this.b = cTDirContentRunImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8312a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getSmartTagArray(iIntValue);
            case 1:
                return this.b.insertNewSmartTag(iIntValue);
            case 2:
                return this.b.getOMathArray(iIntValue);
            case 3:
                return this.b.insertNewOMath(iIntValue);
            case 4:
                return this.b.getCustomXmlMoveFromRangeEndArray(iIntValue);
            case 5:
                return this.b.insertNewCustomXmlMoveFromRangeEnd(iIntValue);
            case 6:
                return this.b.getCommentRangeEndArray(iIntValue);
            default:
                return this.b.insertNewCommentRangeEnd(iIntValue);
        }
    }
}
