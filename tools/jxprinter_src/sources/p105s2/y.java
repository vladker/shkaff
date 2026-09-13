package p105s2;

import com.microsoft.schemas.office.visio.x2012.main.impl.TextTypeImpl;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class y implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8229a;
    public final /* synthetic */ TextTypeImpl b;

    public /* synthetic */ y(TextTypeImpl textTypeImpl, int i5) {
        this.f8229a = i5;
        this.b = textTypeImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8229a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getPpArray(iIntValue);
            case 1:
                return this.b.getFldArray(iIntValue);
            case 2:
                return this.b.insertNewFld(iIntValue);
            case 3:
                return this.b.getCpArray(iIntValue);
            case 4:
                return this.b.insertNewCp(iIntValue);
            case 5:
                return this.b.insertNewPp(iIntValue);
            case 6:
                return this.b.getTpArray(iIntValue);
            default:
                return this.b.insertNewTp(iIntValue);
        }
    }
}
