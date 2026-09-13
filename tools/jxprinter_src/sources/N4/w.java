package N4;

import java.util.function.Consumer;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class w implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f542a;
    public final /* synthetic */ GroupImpl b;

    public /* synthetic */ w(GroupImpl groupImpl, int i5) {
        this.f542a = i5;
        this.b = groupImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f542a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeAll(iIntValue);
                break;
            case 1:
                this.b.removeChoice(iIntValue);
                break;
            case 2:
                this.b.removeElement(iIntValue);
                break;
            case 3:
                this.b.removeAny(iIntValue);
                break;
            case 4:
                this.b.removeGroup(iIntValue);
                break;
            default:
                this.b.removeSequence(iIntValue);
                break;
        }
    }
}
