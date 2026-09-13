package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTNumberingImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class G0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8273a;
    public final /* synthetic */ CTNumberingImpl b;

    public /* synthetic */ G0(CTNumberingImpl cTNumberingImpl, int i5) {
        this.f8273a = i5;
        this.b = cTNumberingImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8273a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getNumPicBulletArray(iIntValue);
            case 1:
                return this.b.getAbstractNumArray(iIntValue);
            case 2:
                return this.b.insertNewAbstractNum(iIntValue);
            case 3:
                return this.b.insertNewNumPicBullet(iIntValue);
            case 4:
                return this.b.getNumArray(iIntValue);
            default:
                return this.b.insertNewNum(iIntValue);
        }
    }
}
