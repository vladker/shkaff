package p105s2;

import com.microsoft.schemas.office.visio.x2012.main.impl.TextTypeImpl;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class A implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8200a;
    public final /* synthetic */ TextTypeImpl b;

    public /* synthetic */ A(TextTypeImpl textTypeImpl, int i5) {
        this.f8200a = i5;
        this.b = textTypeImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8200a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeFld(iIntValue);
                break;
            case 1:
                this.b.removeCp(iIntValue);
                break;
            case 2:
                this.b.removePp(iIntValue);
                break;
            default:
                this.b.removeTp(iIntValue);
                break;
        }
    }
}
