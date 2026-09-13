package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTExternalSheetDataImpl;
import r5.B;
import r5.C1566i;
import r5.C1568j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTExternalSheetDataImpl extends XmlComplexContentImpl implements CTExternalSheetData {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "row"), new QName("", "sheetId"), new QName("", "refreshError")};
    private static final long serialVersionUID = 1;

    public CTExternalSheetDataImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData
    public CTExternalRow addNewRow() {
        CTExternalRow cTExternalRow;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalRow = (CTExternalRow) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTExternalRow;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData
    public boolean getRefreshError() {
        boolean booleanValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[2]);
                }
                booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData
    public CTExternalRow[] getRowArray() {
        return (CTExternalRow[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTExternalRow[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData
    public List<CTExternalRow> getRowList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: r5.N
                public final /* synthetic */ CTExternalSheetDataImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getRowArray(iIntValue);
                        default:
                            return this.b.insertNewRow(iIntValue);
                    }
                }
            }, new B(this, 12), new Function(this) { // from class: r5.N
                public final /* synthetic */ CTExternalSheetDataImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getRowArray(iIntValue);
                        default:
                            return this.b.insertNewRow(iIntValue);
                    }
                }
            }, new C1566i(this, 24), new C1568j(this, 24));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData
    public long getSheetId() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData
    public CTExternalRow insertNewRow(int i5) {
        CTExternalRow cTExternalRow;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalRow = (CTExternalRow) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTExternalRow;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData
    public boolean isSetRefreshError() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[2]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData
    public void removeRow(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData
    public void setRefreshError(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[2]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData
    public void setRowArray(CTExternalRow[] cTExternalRowArr) {
        check_orphaned();
        arraySetterHelper(cTExternalRowArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData
    public void setSheetId(long j6) {
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData
    public int sizeOfRowArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData
    public void unsetRefreshError() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[2]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData
    public XmlBoolean xgetRefreshError() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[2]);
                if (xmlBoolean == null) {
                    xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[2]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData
    public XmlUnsignedInt xgetSheetId() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(PROPERTY_QNAME[1]);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData
    public void xsetRefreshError(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[2]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[2]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData
    public void xsetSheetId(XmlUnsignedInt xmlUnsignedInt) {
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData
    public CTExternalRow getRowArray(int i5) {
        CTExternalRow cTExternalRow;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTExternalRow = (CTExternalRow) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTExternalRow == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTExternalRow;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData
    public void setRowArray(int i5, CTExternalRow cTExternalRow) {
        generatedSetterHelperImpl(cTExternalRow, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
