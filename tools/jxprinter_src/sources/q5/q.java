package q5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTimeNodeListImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class q implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7871a;
    public final /* synthetic */ CTTimeNodeListImpl b;

    public /* synthetic */ q(CTTimeNodeListImpl cTTimeNodeListImpl, int i5) {
        this.f7871a = i5;
        this.b = cTTimeNodeListImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfAnimMotionArray;
        switch (this.f7871a) {
            case 0:
                iSizeOfAnimMotionArray = this.b.sizeOfAnimMotionArray();
                break;
            case 1:
                iSizeOfAnimMotionArray = this.b.sizeOfAnimEffectArray();
                break;
            case 2:
                iSizeOfAnimMotionArray = this.b.sizeOfAnimScaleArray();
                break;
            case 3:
                iSizeOfAnimMotionArray = this.b.sizeOfAnimRotArray();
                break;
            case 4:
                iSizeOfAnimMotionArray = this.b.sizeOfExclArray();
                break;
            case 5:
                iSizeOfAnimMotionArray = this.b.sizeOfAnimClrArray();
                break;
            case 6:
                iSizeOfAnimMotionArray = this.b.sizeOfParArray();
                break;
            case 7:
                iSizeOfAnimMotionArray = this.b.sizeOfSetArray();
                break;
            case 8:
                iSizeOfAnimMotionArray = this.b.sizeOfAudioArray();
                break;
            case 9:
                iSizeOfAnimMotionArray = this.b.sizeOfVideoArray();
                break;
            case 10:
                iSizeOfAnimMotionArray = this.b.sizeOfAnimArray();
                break;
            case 11:
                iSizeOfAnimMotionArray = this.b.sizeOfCmdArray();
                break;
            default:
                iSizeOfAnimMotionArray = this.b.sizeOfSeqArray();
                break;
        }
        return Integer.valueOf(iSizeOfAnimMotionArray);
    }
}
