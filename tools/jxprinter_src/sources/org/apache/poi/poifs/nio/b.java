package org.apache.poi.poifs.nio;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.impl.values.XmlObjectBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7164a;

    public /* synthetic */ b(int i5) {
        this.f7164a = i5;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f7164a) {
            case 0:
                FileBackedDataSource.unmap((ByteBuffer) obj2);
                break;
            case 1:
                ((XmlObjectBase) obj).setObjectValue(obj2);
                break;
            case 2:
                ((XmlObjectBase) obj).setBigDecimalValue((BigDecimal) obj2);
                break;
            case 3:
                ((XmlObjectBase) obj).setBigIntegerValue((BigInteger) obj2);
                break;
            case 4:
                ((XmlObjectBase) obj).setGDurationValue((GDuration) obj2);
                break;
            case 5:
                ((XmlObjectBase) obj).setDateValue((Date) obj2);
                break;
            case 6:
                ((XmlObjectBase) obj).setGDateValue((GDate) obj2);
                break;
            case 7:
                ((XmlObjectBase) obj).setListValue((List) obj2);
                break;
            case 8:
                ((XmlObjectBase) obj).setByteArrayValue((byte[]) obj2);
                break;
            case 9:
                ((XmlObjectBase) obj).setEnumValue((StringEnumAbstractBase) obj2);
                break;
            case 10:
                ((XmlObjectBase) obj).setStringValue((String) obj2);
                break;
            case 11:
                ((XmlObjectBase) obj).setCalendarValue((Calendar) obj2);
                break;
            default:
                ((XmlObjectBase) obj).setQNameValue((QName) obj2);
                break;
        }
    }
}
