package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPicBullet;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;
import s5.G0;
import s5.H0;
import s5.I0;
import s5.J0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTNumberingImpl extends XmlComplexContentImpl implements CTNumbering {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "numPicBullet"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "abstractNum"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "num"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "numIdMacAtCleanup")};
    private static final long serialVersionUID = 1;

    public CTNumberingImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTAbstractNum addNewAbstractNum() {
        CTAbstractNum cTAbstractNum;
        synchronized (monitor()) {
            check_orphaned();
            cTAbstractNum = (CTAbstractNum) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTAbstractNum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNum addNewNum() {
        CTNum cTNum;
        synchronized (monitor()) {
            check_orphaned();
            cTNum = (CTNum) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTNum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTDecimalNumber addNewNumIdMacAtCleanup() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNumPicBullet addNewNumPicBullet() {
        CTNumPicBullet cTNumPicBulletAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumPicBulletAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTNumPicBulletAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTAbstractNum[] getAbstractNumArray() {
        return (CTAbstractNum[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTAbstractNum[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public List<CTAbstractNum> getAbstractNumList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new G0(this, 1), new H0(this, 0), new G0(this, 2), new I0(this, 0), new J0(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNum[] getNumArray() {
        return (CTNum[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTNum[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTDecimalNumber getNumIdMacAtCleanup() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTDecimalNumber == null) {
                cTDecimalNumber = null;
            }
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public List<CTNum> getNumList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new G0(this, 4), new H0(this, 1), new G0(this, 5), new I0(this, 2), new J0(this, 2));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNumPicBullet[] getNumPicBulletArray() {
        return getXmlObjectArray(PROPERTY_QNAME[0], (XmlObject[]) new CTNumPicBullet[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public List<CTNumPicBullet> getNumPicBulletList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new G0(this, 0), new BiConsumer() { // from class: s5.K0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8293a.setNumPicBulletArray(((Integer) obj).intValue(), (CTNumPicBullet) obj2);
                }
            }, new G0(this, 3), new I0(this, 1), new J0(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTAbstractNum insertNewAbstractNum(int i5) {
        CTAbstractNum cTAbstractNum;
        synchronized (monitor()) {
            check_orphaned();
            cTAbstractNum = (CTAbstractNum) get_store().insert_element_user(PROPERTY_QNAME[1], i5);
        }
        return cTAbstractNum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNum insertNewNum(int i5) {
        CTNum cTNum;
        synchronized (monitor()) {
            check_orphaned();
            cTNum = (CTNum) get_store().insert_element_user(PROPERTY_QNAME[2], i5);
        }
        return cTNum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNumPicBullet insertNewNumPicBullet(int i5) {
        CTNumPicBullet cTNumPicBulletInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumPicBulletInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTNumPicBulletInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public boolean isSetNumIdMacAtCleanup() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void removeAbstractNum(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void removeNum(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void removeNumPicBullet(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setAbstractNumArray(CTAbstractNum[] cTAbstractNumArr) {
        check_orphaned();
        arraySetterHelper(cTAbstractNumArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setNumArray(CTNum[] cTNumArr) {
        check_orphaned();
        arraySetterHelper(cTNumArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setNumIdMacAtCleanup(CTDecimalNumber cTDecimalNumber) {
        generatedSetterHelperImpl(cTDecimalNumber, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setNumPicBulletArray(CTNumPicBullet[] cTNumPicBulletArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTNumPicBulletArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public int sizeOfAbstractNumArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public int sizeOfNumArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public int sizeOfNumPicBulletArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void unsetNumIdMacAtCleanup() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTAbstractNum getAbstractNumArray(int i5) {
        CTAbstractNum cTAbstractNum;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTAbstractNum = (CTAbstractNum) get_store().find_element_user(PROPERTY_QNAME[1], i5);
                if (cTAbstractNum == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTAbstractNum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNum getNumArray(int i5) {
        CTNum cTNum;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTNum = (CTNum) get_store().find_element_user(PROPERTY_QNAME[2], i5);
                if (cTNum == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTNum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNumPicBullet getNumPicBulletArray(int i5) {
        CTNumPicBullet cTNumPicBulletFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTNumPicBulletFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTNumPicBulletFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTNumPicBulletFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setAbstractNumArray(int i5, CTAbstractNum cTAbstractNum) {
        generatedSetterHelperImpl(cTAbstractNum, PROPERTY_QNAME[1], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setNumArray(int i5, CTNum cTNum) {
        generatedSetterHelperImpl(cTNum, PROPERTY_QNAME[2], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setNumPicBulletArray(int i5, CTNumPicBullet cTNumPicBullet) {
        generatedSetterHelperImpl(cTNumPicBullet, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
