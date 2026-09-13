package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRunTrackChangeImpl;

/* JADX INFO: renamed from: s5.v2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1747v2 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8488a;
    public final /* synthetic */ CTRunTrackChangeImpl b;

    public /* synthetic */ C1747v2(CTRunTrackChangeImpl cTRunTrackChangeImpl, int i5) {
        this.f8488a = i5;
        this.b = cTRunTrackChangeImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8488a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeFunc(iIntValue);
                break;
            case 1:
                this.b.removeIns(iIntValue);
                break;
            case 2:
                this.b.removeBdo(iIntValue);
                break;
            case 3:
                this.b.removeMoveFrom(iIntValue);
                break;
            case 4:
                this.b.removeRad(iIntValue);
                break;
            case 5:
                this.b.removeF(iIntValue);
                break;
            case 6:
                this.b.removeSSup(iIntValue);
                break;
            case 7:
                this.b.removeOMath(iIntValue);
                break;
            case 8:
                this.b.removeR2(iIntValue);
                break;
            case 9:
                this.b.removeCustomXmlMoveFromRangeEnd(iIntValue);
                break;
            case 10:
                this.b.removeCustomXmlInsRangeEnd(iIntValue);
                break;
            case 11:
                this.b.removeSSub(iIntValue);
                break;
            case 12:
                this.b.removeCommentRangeEnd(iIntValue);
                break;
            case 13:
                this.b.removeCommentRangeStart(iIntValue);
                break;
            case 14:
                this.b.removeGroupChr(iIntValue);
                break;
            case 15:
                this.b.removeBorderBox(iIntValue);
                break;
            case 16:
                this.b.removeCustomXmlInsRangeStart(iIntValue);
                break;
            case 17:
                this.b.removeLimUpp(iIntValue);
                break;
            case 18:
                this.b.removeBookmarkEnd(iIntValue);
                break;
            case 19:
                this.b.removeLimLow(iIntValue);
                break;
            default:
                this.b.removeCustomXmlMoveToRangeStart(iIntValue);
                break;
        }
    }
}
