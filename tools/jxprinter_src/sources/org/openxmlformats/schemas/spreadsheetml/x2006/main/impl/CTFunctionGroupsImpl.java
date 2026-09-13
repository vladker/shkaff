package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroup;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTFunctionGroupsImpl;
import r5.C1566i;
import r5.C1568j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTFunctionGroupsImpl extends XmlComplexContentImpl implements CTFunctionGroups {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "functionGroup"), new QName("", "builtInGroupCount")};
    private static final long serialVersionUID = 1;

    public CTFunctionGroupsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public CTFunctionGroup addNewFunctionGroup() {
        CTFunctionGroup cTFunctionGroupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFunctionGroupAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTFunctionGroupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public long getBuiltInGroupCount() {
        long longValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[1]);
                }
                longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public CTFunctionGroup[] getFunctionGroupArray() {
        return getXmlObjectArray(PROPERTY_QNAME[0], (XmlObject[]) new CTFunctionGroup[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public List<CTFunctionGroup> getFunctionGroupList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: r5.X
                public final /* synthetic */ CTFunctionGroupsImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getFunctionGroupArray(iIntValue);
                        default:
                            return this.b.insertNewFunctionGroup(iIntValue);
                    }
                }
            }, new BiConsumer() { // from class: r5.Y
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8024a.setFunctionGroupArray(((Integer) obj).intValue(), (CTFunctionGroup) obj2);
                }
            }, new Function(this) { // from class: r5.X
                public final /* synthetic */ CTFunctionGroupsImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getFunctionGroupArray(iIntValue);
                        default:
                            return this.b.insertNewFunctionGroup(iIntValue);
                    }
                }
            }, new C1566i(this, 29), new C1568j(this, 29));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public CTFunctionGroup insertNewFunctionGroup(int i5) {
        CTFunctionGroup cTFunctionGroupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFunctionGroupInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTFunctionGroupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public boolean isSetBuiltInGroupCount() {
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public void removeFunctionGroup(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public void setBuiltInGroupCount(long j6) {
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public void setFunctionGroupArray(CTFunctionGroup[] cTFunctionGroupArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTFunctionGroupArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public int sizeOfFunctionGroupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public void unsetBuiltInGroupCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[1]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public XmlUnsignedInt xgetBuiltInGroupCount() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                xmlUnsignedInt = (XmlUnsignedInt) typeStore.find_attribute_user(qNameArr[1]);
                if (xmlUnsignedInt == null) {
                    xmlUnsignedInt = (XmlUnsignedInt) get_default_attribute_value(qNameArr[1]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public void xsetBuiltInGroupCount(XmlUnsignedInt xmlUnsignedInt) {
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public CTFunctionGroup getFunctionGroupArray(int i5) {
        CTFunctionGroup cTFunctionGroupFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTFunctionGroupFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTFunctionGroupFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTFunctionGroupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public void setFunctionGroupArray(int i5, CTFunctionGroup cTFunctionGroup) {
        generatedSetterHelperImpl(cTFunctionGroup, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
