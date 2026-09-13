package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtListItem;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSdtComboBoxImpl;
import p105s2.i;
import p105s2.j;
import r5.B0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTSdtComboBoxImpl extends XmlComplexContentImpl implements CTSdtComboBox {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "listItem"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "lastValue")};
    private static final long serialVersionUID = 1;

    public CTSdtComboBoxImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public CTSdtListItem addNewListItem() {
        CTSdtListItem cTSdtListItem;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtListItem = (CTSdtListItem) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTSdtListItem;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public String getLastValue() {
        String stringValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[1]);
                }
                stringValue = simpleValue == null ? null : simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public CTSdtListItem[] getListItemArray() {
        return (CTSdtListItem[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTSdtListItem[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public List<CTSdtListItem> getListItemList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: s5.G2
                public final /* synthetic */ CTSdtComboBoxImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getListItemArray(iIntValue);
                        default:
                            return this.b.insertNewListItem(iIntValue);
                    }
                }
            }, new B0(this, 26), new Function(this) { // from class: s5.G2
                public final /* synthetic */ CTSdtComboBoxImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getListItemArray(iIntValue);
                        default:
                            return this.b.insertNewListItem(iIntValue);
                    }
                }
            }, new i(this, 11), new j(this, 11));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public CTSdtListItem insertNewListItem(int i5) {
        CTSdtListItem cTSdtListItem;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtListItem = (CTSdtListItem) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTSdtListItem;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public boolean isSetLastValue() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = true;
            if (get_store().find_attribute_user(PROPERTY_QNAME[1]) == null) {
                z6 = false;
            }
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public void removeListItem(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public void setLastValue(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[1]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public void setListItemArray(CTSdtListItem[] cTSdtListItemArr) {
        check_orphaned();
        arraySetterHelper(cTSdtListItemArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public int sizeOfListItemArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public void unsetLastValue() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[1]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public STString xgetLastValue() {
        STString sTString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                sTString = (STString) typeStore.find_attribute_user(qNameArr[1]);
                if (sTString == null) {
                    sTString = (STString) get_default_attribute_value(qNameArr[1]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public void xsetLastValue(STString sTString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STString sTString2 = (STString) typeStore.find_attribute_user(qNameArr[1]);
                if (sTString2 == null) {
                    sTString2 = (STString) get_store().add_attribute_user(qNameArr[1]);
                }
                sTString2.set(sTString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public CTSdtListItem getListItemArray(int i5) {
        CTSdtListItem cTSdtListItem;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSdtListItem = (CTSdtListItem) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTSdtListItem == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSdtListItem;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public void setListItemArray(int i5, CTSdtListItem cTSdtListItem) {
        generatedSetterHelperImpl(cTSdtListItem, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
