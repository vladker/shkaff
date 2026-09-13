package org.apache.poi.xwpf.usermodel;

import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.values.XmlObjectBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7347a;

    public /* synthetic */ c(int i5) {
        this.f7347a = i5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7347a) {
            case 0:
                return ((CTTblBorders) obj).getInsideH();
            case 1:
                return ((CTTblBorders) obj).addNewInsideH();
            case 2:
                return ((CTTblBorders) obj).getLeft();
            case 3:
                return ((CTTblBorders) obj).addNewLeft();
            case 4:
                return Boolean.valueOf(((CTTblCellMar) obj).isSetRight());
            case 5:
                return ((CTTblCellMar) obj).getRight();
            case 6:
                return ((CTTblCellMar) obj).addNewRight();
            case 7:
                return ((CTTblCellMar) obj).getTop();
            case 8:
                return ((CTTblCellMar) obj).addNewTop();
            case 9:
                return ((XmlError) obj).toString();
            case 10:
                return QNameHelper.pretty((QName) obj);
            case 11:
                return XmlListImpl.object2String((XmlAnySimpleType) obj);
            case 12:
                return (SimpleValue) SimpleValue.class.cast((XmlObjectBase) obj);
            case 13:
                return ((XmlObjectBase) obj).getEnumValue();
            case 14:
                return ((SimpleValue) obj).getStringValue();
            default:
                return ((SimpleValue) obj).getBigIntegerValue();
        }
    }
}
