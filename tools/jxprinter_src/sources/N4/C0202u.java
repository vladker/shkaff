package N4;

import java.util.function.Function;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl;

/* JADX INFO: renamed from: N4.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C0202u implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f540a;
    public final /* synthetic */ GroupImpl b;

    public /* synthetic */ C0202u(GroupImpl groupImpl, int i5) {
        this.f540a = i5;
        this.b = groupImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f540a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getGroupArray(iIntValue);
            case 1:
                return this.b.getAllArray(iIntValue);
            case 2:
                return this.b.insertNewAll(iIntValue);
            case 3:
                return this.b.getChoiceArray(iIntValue);
            case 4:
                return this.b.insertNewChoice(iIntValue);
            case 5:
                return this.b.getElementArray(iIntValue);
            case 6:
                return this.b.insertNewElement(iIntValue);
            case 7:
                return this.b.getAnyArray(iIntValue);
            case 8:
                return this.b.insertNewAny(iIntValue);
            case 9:
                return this.b.insertNewGroup(iIntValue);
            case 10:
                return this.b.getSequenceArray(iIntValue);
            default:
                return this.b.insertNewSequence(iIntValue);
        }
    }
}
