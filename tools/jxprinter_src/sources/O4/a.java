package O4;

import java.util.function.ToIntFunction;
import org.apache.poi.ddf.EscherProperty;
import org.apache.poi.util.BitField;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.soap.SOAPArrayType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements ToIntFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f556a;

    public /* synthetic */ a(int i5) {
        this.f556a = i5;
    }

    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        switch (this.f556a) {
            case 0:
                return SOAPArrayType.collapseDimString((String) obj);
            case 1:
                return ((EscherProperty) obj).getPropertyNumber();
            case 2:
                return ((BitField) obj).getMask();
            default:
                return ((SimpleValue) obj).getIntValue();
        }
    }
}
