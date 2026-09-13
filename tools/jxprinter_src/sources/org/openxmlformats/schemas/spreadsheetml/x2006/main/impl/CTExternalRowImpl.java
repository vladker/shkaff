package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTExternalRowImpl;
import r5.B;
import r5.C1566i;
import r5.C1568j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTExternalRowImpl extends XmlComplexContentImpl implements CTExternalRow {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "cell"), new QName("", "r")};
    private static final long serialVersionUID = 1;

    public CTExternalRowImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public CTExternalCell addNewCell() {
        CTExternalCell cTExternalCell;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalCell = (CTExternalCell) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTExternalCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public CTExternalCell[] getCellArray() {
        return (CTExternalCell[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTExternalCell[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public List<CTExternalCell> getCellList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: r5.M
                public final /* synthetic */ CTExternalRowImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getCellArray(iIntValue);
                        default:
                            return this.b.insertNewCell(iIntValue);
                    }
                }
            }, new B(this, 11), new Function(this) { // from class: r5.M
                public final /* synthetic */ CTExternalRowImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getCellArray(iIntValue);
                        default:
                            return this.b.insertNewCell(iIntValue);
                    }
                }
            }, new C1566i(this, 23), new C1568j(this, 23));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public long getR() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public CTExternalCell insertNewCell(int i5) {
        CTExternalCell cTExternalCell;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalCell = (CTExternalCell) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTExternalCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public void removeCell(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public void setCellArray(CTExternalCell[] cTExternalCellArr) {
        check_orphaned();
        arraySetterHelper(cTExternalCellArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public void setR(long j6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[1]);
                }
                simpleValue.setLongValue(j6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public int sizeOfCellArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public XmlUnsignedInt xgetR() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(PROPERTY_QNAME[1]);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public void xsetR(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qNameArr[1]);
                if (xmlUnsignedInt2 == null) {
                    xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qNameArr[1]);
                }
                xmlUnsignedInt2.set(xmlUnsignedInt);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public CTExternalCell getCellArray(int i5) {
        CTExternalCell cTExternalCell;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTExternalCell = (CTExternalCell) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTExternalCell == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTExternalCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public void setCellArray(int i5, CTExternalCell cTExternalCell) {
        generatedSetterHelperImpl(cTExternalCell, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
