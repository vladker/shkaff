package q5;

import java.util.function.Function;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTimeNodeListImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class n implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7868a;
    public final /* synthetic */ CTTimeNodeListImpl b;

    public /* synthetic */ n(CTTimeNodeListImpl cTTimeNodeListImpl, int i5) {
        this.f7868a = i5;
        this.b = cTTimeNodeListImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7868a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getAudioArray(iIntValue);
            case 1:
                return this.b.getAnimMotionArray(iIntValue);
            case 2:
                return this.b.insertNewAnimMotion(iIntValue);
            case 3:
                return this.b.getAnimEffectArray(iIntValue);
            case 4:
                return this.b.insertNewAnimEffect(iIntValue);
            case 5:
                return this.b.getAnimScaleArray(iIntValue);
            case 6:
                return this.b.insertNewAnimScale(iIntValue);
            case 7:
                return this.b.getAnimRotArray(iIntValue);
            case 8:
                return this.b.insertNewAnimRot(iIntValue);
            case 9:
                return this.b.insertNewAudio(iIntValue);
            case 10:
                return this.b.getExclArray(iIntValue);
            case 11:
                return this.b.insertNewExcl(iIntValue);
            case 12:
                return this.b.getAnimClrArray(iIntValue);
            case 13:
                return this.b.insertNewAnimClr(iIntValue);
            case 14:
                return this.b.getParArray(iIntValue);
            case 15:
                return this.b.insertNewPar(iIntValue);
            case 16:
                return this.b.getSetArray(iIntValue);
            case 17:
                return this.b.insertNewSet(iIntValue);
            case 18:
                return this.b.getVideoArray(iIntValue);
            case 19:
                return this.b.insertNewVideo(iIntValue);
            case 20:
                return this.b.getAnimArray(iIntValue);
            case 21:
                return this.b.insertNewAnim(iIntValue);
            case 22:
                return this.b.getSeqArray(iIntValue);
            case 23:
                return this.b.getCmdArray(iIntValue);
            case 24:
                return this.b.insertNewCmd(iIntValue);
            default:
                return this.b.insertNewSeq(iIntValue);
        }
    }
}
