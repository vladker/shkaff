package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.RowType;
import com.microsoft.schemas.office.visio.x2012.main.SectionType;
import com.microsoft.schemas.office.visio.x2012.main.TriggerType;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import p105s2.o;
import p105s2.p;
import p105s2.q;
import p105s2.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class SectionTypeImpl extends XmlComplexContentImpl implements SectionType {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.microsoft.com/office/visio/2012/main", "Cell"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "Trigger"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "Row"), new QName("", "N"), new QName("", "Del"), new QName("", "IX")};
    private static final long serialVersionUID = 1;

    public SectionTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public CellType addNewCell() {
        CellType cellType;
        synchronized (monitor()) {
            check_orphaned();
            cellType = (CellType) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cellType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public RowType addNewRow() {
        RowType rowType;
        synchronized (monitor()) {
            check_orphaned();
            rowType = (RowType) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return rowType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public TriggerType addNewTrigger() {
        TriggerType triggerType;
        synchronized (monitor()) {
            check_orphaned();
            triggerType = (TriggerType) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return triggerType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public CellType[] getCellArray() {
        return (CellType[]) getXmlObjectArray(PROPERTY_QNAME[0], new CellType[0]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public List<CellType> getCellList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new o(this, 4), new p(this, 2), new o(this, 5), new q(this, 2), new r(this, 2));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public boolean getDel() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[4]);
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public long getIX() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[5]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public String getN() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[3]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public RowType[] getRowArray() {
        return (RowType[]) getXmlObjectArray(PROPERTY_QNAME[2], new RowType[0]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public List<RowType> getRowList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new o(this, 1), new p(this, 0), new o(this, 2), new q(this, 0), new r(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public TriggerType[] getTriggerArray() {
        return (TriggerType[]) getXmlObjectArray(PROPERTY_QNAME[1], new TriggerType[0]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public List<TriggerType> getTriggerList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new o(this, 0), new p(this, 1), new o(this, 3), new q(this, 1), new r(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public CellType insertNewCell(int i5) {
        CellType cellType;
        synchronized (monitor()) {
            check_orphaned();
            cellType = (CellType) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cellType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public RowType insertNewRow(int i5) {
        RowType rowType;
        synchronized (monitor()) {
            check_orphaned();
            rowType = (RowType) get_store().insert_element_user(PROPERTY_QNAME[2], i5);
        }
        return rowType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public TriggerType insertNewTrigger(int i5) {
        TriggerType triggerType;
        synchronized (monitor()) {
            check_orphaned();
            triggerType = (TriggerType) get_store().insert_element_user(PROPERTY_QNAME[1], i5);
        }
        return triggerType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public boolean isSetDel() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[4]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public boolean isSetIX() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[5]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void removeCell(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void removeRow(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i5);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void removeTrigger(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i5);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void setCellArray(CellType[] cellTypeArr) {
        check_orphaned();
        arraySetterHelper(cellTypeArr, PROPERTY_QNAME[0]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void setDel(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[4]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[4]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void setIX(long j6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[5]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[5]);
                }
                simpleValue.setLongValue(j6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void setN(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[3]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[3]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void setRowArray(RowType[] rowTypeArr) {
        check_orphaned();
        arraySetterHelper(rowTypeArr, PROPERTY_QNAME[2]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void setTriggerArray(TriggerType[] triggerTypeArr) {
        check_orphaned();
        arraySetterHelper(triggerTypeArr, PROPERTY_QNAME[1]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public int sizeOfCellArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public int sizeOfRowArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public int sizeOfTriggerArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void unsetDel() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[4]);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void unsetIX() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[5]);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public XmlBoolean xgetDel() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(PROPERTY_QNAME[4]);
        }
        return xmlBoolean;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public XmlUnsignedInt xgetIX() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(PROPERTY_QNAME[5]);
        }
        return xmlUnsignedInt;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public XmlString xgetN() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[3]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void xsetDel(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[4]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[4]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void xsetIX(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qNameArr[5]);
                if (xmlUnsignedInt2 == null) {
                    xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qNameArr[5]);
                }
                xmlUnsignedInt2.set(xmlUnsignedInt);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void xsetN(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[3]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[3]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public CellType getCellArray(int i5) {
        CellType cellType;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cellType = (CellType) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cellType == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cellType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public RowType getRowArray(int i5) {
        RowType rowType;
        synchronized (monitor()) {
            try {
                check_orphaned();
                rowType = (RowType) get_store().find_element_user(PROPERTY_QNAME[2], i5);
                if (rowType == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return rowType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public TriggerType getTriggerArray(int i5) {
        TriggerType triggerType;
        synchronized (monitor()) {
            try {
                check_orphaned();
                triggerType = (TriggerType) get_store().find_element_user(PROPERTY_QNAME[1], i5);
                if (triggerType == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return triggerType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void setCellArray(int i5, CellType cellType) {
        generatedSetterHelperImpl(cellType, PROPERTY_QNAME[0], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void setRowArray(int i5, RowType rowType) {
        generatedSetterHelperImpl(rowType, PROPERTY_QNAME[2], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void setTriggerArray(int i5, TriggerType triggerType) {
        generatedSetterHelperImpl(triggerType, PROPERTY_QNAME[1], i5, (short) 2);
    }
}
