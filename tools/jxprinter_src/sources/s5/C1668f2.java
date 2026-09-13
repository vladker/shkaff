package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRubyContentImpl;

/* JADX INFO: renamed from: s5.f2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1668f2 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8404a;
    public final /* synthetic */ CTRubyContentImpl b;

    public /* synthetic */ C1668f2(CTRubyContentImpl cTRubyContentImpl, int i5) {
        this.f8404a = i5;
        this.b = cTRubyContentImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8404a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getMoveFromRangeEndArray(iIntValue);
            case 1:
                return this.b.insertNewMoveFromRangeEnd(iIntValue);
            case 2:
                return this.b.getDelArray(iIntValue);
            case 3:
                return this.b.insertNewDel(iIntValue);
            case 4:
                return this.b.getPermStartArray(iIntValue);
            case 5:
                return this.b.getOMathArray(iIntValue);
            case 6:
                return this.b.insertNewOMath(iIntValue);
            case 7:
                return this.b.getMoveToRangeStartArray(iIntValue);
            case 8:
                return this.b.insertNewMoveToRangeStart(iIntValue);
            case 9:
                return this.b.getBookmarkEndArray(iIntValue);
            case 10:
                return this.b.insertNewBookmarkEnd(iIntValue);
            case 11:
                return this.b.getCustomXmlInsRangeEndArray(iIntValue);
            case 12:
                return this.b.insertNewCustomXmlInsRangeEnd(iIntValue);
            case 13:
                return this.b.insertNewPermStart(iIntValue);
            case 14:
                return this.b.getInsArray(iIntValue);
            case 15:
                return this.b.insertNewIns(iIntValue);
            case 16:
                return this.b.getCustomXmlDelRangeEndArray(iIntValue);
            case 17:
                return this.b.insertNewCustomXmlDelRangeEnd(iIntValue);
            case 18:
                return this.b.getCustomXmlMoveToRangeEndArray(iIntValue);
            case 19:
                return this.b.insertNewCustomXmlMoveToRangeEnd(iIntValue);
            case 20:
                return this.b.getCustomXmlDelRangeStartArray(iIntValue);
            default:
                return this.b.insertNewCustomXmlDelRangeStart(iIntValue);
        }
    }
}
