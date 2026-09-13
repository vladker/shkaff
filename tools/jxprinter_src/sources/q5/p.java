package q5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTimeNodeListImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class p implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7870a;
    public final /* synthetic */ CTTimeNodeListImpl b;

    public /* synthetic */ p(CTTimeNodeListImpl cTTimeNodeListImpl, int i5) {
        this.f7870a = i5;
        this.b = cTTimeNodeListImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f7870a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeAnimMotion(iIntValue);
                break;
            case 1:
                this.b.removeAnimEffect(iIntValue);
                break;
            case 2:
                this.b.removeAnimScale(iIntValue);
                break;
            case 3:
                this.b.removeAnimRot(iIntValue);
                break;
            case 4:
                this.b.removeExcl(iIntValue);
                break;
            case 5:
                this.b.removeAnimClr(iIntValue);
                break;
            case 6:
                this.b.removeAudio(iIntValue);
                break;
            case 7:
                this.b.removePar(iIntValue);
                break;
            case 8:
                this.b.removeSet(iIntValue);
                break;
            case 9:
                this.b.removeVideo(iIntValue);
                break;
            case 10:
                this.b.removeAnim(iIntValue);
                break;
            case 11:
                this.b.removeCmd(iIntValue);
                break;
            default:
                this.b.removeSeq(iIntValue);
                break;
        }
    }
}
