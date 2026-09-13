package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.MasterShortcutType;
import com.microsoft.schemas.office.visio.x2012.main.MasterType;
import com.microsoft.schemas.office.visio.x2012.main.MastersType;
import java.util.List;
import java.util.function.BiConsumer;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import p105s2.C1638d;
import p105s2.C1639e;
import p105s2.f;
import r5.B0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class MastersTypeImpl extends XmlComplexContentImpl implements MastersType {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.microsoft.com/office/visio/2012/main", "Master"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "MasterShortcut")};
    private static final long serialVersionUID = 1;

    public MastersTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public MasterType addNewMaster() {
        MasterType masterType;
        synchronized (monitor()) {
            check_orphaned();
            masterType = (MasterType) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return masterType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public MasterShortcutType addNewMasterShortcut() {
        MasterShortcutType masterShortcutTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            masterShortcutTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return masterShortcutTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public MasterType[] getMasterArray() {
        return (MasterType[]) getXmlObjectArray(PROPERTY_QNAME[0], new MasterType[0]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public List<MasterType> getMasterList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1638d(this, 0), new B0(this, 15), new C1638d(this, 1), new C1639e(this, 0), new f(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public MasterShortcutType[] getMasterShortcutArray() {
        return getXmlObjectArray(PROPERTY_QNAME[1], (XmlObject[]) new MasterShortcutType[0]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public List<MasterShortcutType> getMasterShortcutList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1638d(this, 2), new BiConsumer() { // from class: s2.g
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8211a.setMasterShortcutArray(((Integer) obj).intValue(), (MasterShortcutType) obj2);
                }
            }, new C1638d(this, 3), new C1639e(this, 1), new f(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public MasterType insertNewMaster(int i5) {
        MasterType masterType;
        synchronized (monitor()) {
            check_orphaned();
            masterType = (MasterType) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return masterType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public MasterShortcutType insertNewMasterShortcut(int i5) {
        MasterShortcutType masterShortcutTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            masterShortcutTypeInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[1], i5);
        }
        return masterShortcutTypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public void removeMaster(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public void removeMasterShortcut(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i5);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public void setMasterArray(MasterType[] masterTypeArr) {
        check_orphaned();
        arraySetterHelper(masterTypeArr, PROPERTY_QNAME[0]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public void setMasterShortcutArray(MasterShortcutType[] masterShortcutTypeArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) masterShortcutTypeArr, PROPERTY_QNAME[1]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public int sizeOfMasterArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public int sizeOfMasterShortcutArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public MasterType getMasterArray(int i5) {
        MasterType masterType;
        synchronized (monitor()) {
            try {
                check_orphaned();
                masterType = (MasterType) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (masterType == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return masterType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public MasterShortcutType getMasterShortcutArray(int i5) {
        MasterShortcutType masterShortcutTypeFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                masterShortcutTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], i5);
                if (masterShortcutTypeFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return masterShortcutTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public void setMasterArray(int i5, MasterType masterType) {
        generatedSetterHelperImpl(masterType, PROPERTY_QNAME[0], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public void setMasterShortcutArray(int i5, MasterShortcutType masterShortcutType) {
        generatedSetterHelperImpl(masterShortcutType, PROPERTY_QNAME[1], i5, (short) 2);
    }
}
