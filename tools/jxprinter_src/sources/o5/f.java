package o5;

import java.math.BigInteger;
import java.util.function.BiConsumer;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.XmlUnsignedLong;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.CTVectorImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class f implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6479a;
    public final /* synthetic */ CTVectorImpl b;

    public /* synthetic */ f(CTVectorImpl cTVectorImpl, int i5) {
        this.f6479a = i5;
        this.b = cTVectorImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f6479a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setUi4Array(iIntValue, ((Long) obj2).longValue());
                break;
            case 1:
                this.b.insertUi4(iIntValue, ((Long) obj2).longValue());
                break;
            case 2:
                this.b.xsetLpwstrArray(iIntValue, (XmlString) obj2);
                break;
            case 3:
                this.b.xsetFiletimeArray(iIntValue, (XmlDateTime) obj2);
                break;
            case 4:
                this.b.xsetLpstrArray(iIntValue, (XmlString) obj2);
                break;
            case 5:
                this.b.setR8Array(iIntValue, ((Double) obj2).doubleValue());
                break;
            case 6:
                this.b.insertR8(iIntValue, ((Double) obj2).doubleValue());
                break;
            case 7:
                this.b.xsetI4Array(iIntValue, (XmlInt) obj2);
                break;
            case 8:
                this.b.setUi8Array(iIntValue, (BigInteger) obj2);
                break;
            case 9:
                this.b.insertUi8(iIntValue, (BigInteger) obj2);
                break;
            case 10:
                this.b.xsetUi8Array(iIntValue, (XmlUnsignedLong) obj2);
                break;
            case 11:
                this.b.xsetR8Array(iIntValue, (XmlDouble) obj2);
                break;
            case 12:
                this.b.setVariantArray(iIntValue, (CTVariant) obj2);
                break;
            case 13:
                this.b.setI8Array(iIntValue, ((Long) obj2).longValue());
                break;
            case 14:
                this.b.insertI8(iIntValue, ((Long) obj2).longValue());
                break;
            case 15:
                this.b.setI1Array(iIntValue, ((Byte) obj2).byteValue());
                break;
            case 16:
                this.b.insertI1(iIntValue, ((Byte) obj2).byteValue());
                break;
            case 17:
                this.b.setI4Array(iIntValue, ((Integer) obj2).intValue());
                break;
            case 18:
                this.b.xsetUi4Array(iIntValue, (XmlUnsignedInt) obj2);
                break;
            case 19:
                this.b.insertI4(iIntValue, ((Integer) obj2).intValue());
                break;
            case 20:
                this.b.xsetR4Array(iIntValue, (XmlFloat) obj2);
                break;
            case 21:
                this.b.setCyArray(iIntValue, (String) obj2);
                break;
            case 22:
                this.b.insertCy(iIntValue, (String) obj2);
                break;
            case 23:
                this.b.setUi1Array(iIntValue, ((Short) obj2).shortValue());
                break;
            case 24:
                this.b.insertUi1(iIntValue, ((Short) obj2).shortValue());
                break;
            default:
                this.b.xsetBstrArray(iIntValue, (XmlString) obj2);
                break;
        }
    }
}
