package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.CpType;
import com.microsoft.schemas.office.visio.x2012.main.FldType;
import com.microsoft.schemas.office.visio.x2012.main.PpType;
import com.microsoft.schemas.office.visio.x2012.main.TextType;
import com.microsoft.schemas.office.visio.x2012.main.TpType;
import java.util.List;
import java.util.function.BiConsumer;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import p105s2.A;
import p105s2.B;
import p105s2.y;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class TextTypeImpl extends XmlComplexContentImpl implements TextType {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.microsoft.com/office/visio/2012/main", "cp"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "pp"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "tp"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "fld")};
    private static final long serialVersionUID = 1;

    public TextTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public CpType addNewCp() {
        CpType cpTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cpTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cpTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public FldType addNewFld() {
        FldType fldTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            fldTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return fldTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public PpType addNewPp() {
        PpType ppTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ppTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return ppTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public TpType addNewTp() {
        TpType tpTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            tpTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return tpTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public CpType[] getCpArray() {
        return getXmlObjectArray(PROPERTY_QNAME[0], (XmlObject[]) new CpType[0]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public List<CpType> getCpList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new y(this, 3), new BiConsumer() { // from class: s2.C
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8202a.setCpArray(((Integer) obj).intValue(), (CpType) obj2);
                }
            }, new y(this, 4), new A(this, 1), new B(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public FldType[] getFldArray() {
        return getXmlObjectArray(PROPERTY_QNAME[3], (XmlObject[]) new FldType[0]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public List<FldType> getFldList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new y(this, 1), new BiConsumer() { // from class: s2.z
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8230a.setFldArray(((Integer) obj).intValue(), (FldType) obj2);
                }
            }, new y(this, 2), new A(this, 0), new B(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public PpType[] getPpArray() {
        return getXmlObjectArray(PROPERTY_QNAME[1], (XmlObject[]) new PpType[0]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public List<PpType> getPpList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new y(this, 0), new BiConsumer() { // from class: s2.D
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8203a.setPpArray(((Integer) obj).intValue(), (PpType) obj2);
                }
            }, new y(this, 5), new A(this, 2), new B(this, 2));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public TpType[] getTpArray() {
        return getXmlObjectArray(PROPERTY_QNAME[2], (XmlObject[]) new TpType[0]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public List<TpType> getTpList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new y(this, 6), new BiConsumer() { // from class: s2.E
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8204a.setTpArray(((Integer) obj).intValue(), (TpType) obj2);
                }
            }, new y(this, 7), new A(this, 3), new B(this, 3));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public CpType insertNewCp(int i5) {
        CpType cpTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cpTypeInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cpTypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public FldType insertNewFld(int i5) {
        FldType fldTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            fldTypeInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[3], i5);
        }
        return fldTypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public PpType insertNewPp(int i5) {
        PpType ppTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ppTypeInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[1], i5);
        }
        return ppTypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public TpType insertNewTp(int i5) {
        TpType tpTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            tpTypeInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[2], i5);
        }
        return tpTypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void removeCp(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void removeFld(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i5);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void removePp(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i5);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void removeTp(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i5);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void setCpArray(CpType[] cpTypeArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cpTypeArr, PROPERTY_QNAME[0]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void setFldArray(FldType[] fldTypeArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) fldTypeArr, PROPERTY_QNAME[3]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void setPpArray(PpType[] ppTypeArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) ppTypeArr, PROPERTY_QNAME[1]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void setTpArray(TpType[] tpTypeArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) tpTypeArr, PROPERTY_QNAME[2]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public int sizeOfCpArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public int sizeOfFldArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public int sizeOfPpArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public int sizeOfTpArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public CpType getCpArray(int i5) {
        CpType cpTypeFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cpTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cpTypeFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cpTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public FldType getFldArray(int i5) {
        FldType fldTypeFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                fldTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[3], i5);
                if (fldTypeFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return fldTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public PpType getPpArray(int i5) {
        PpType ppTypeFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                ppTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], i5);
                if (ppTypeFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ppTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public TpType getTpArray(int i5) {
        TpType tpTypeFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                tpTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], i5);
                if (tpTypeFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return tpTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void setCpArray(int i5, CpType cpType) {
        generatedSetterHelperImpl(cpType, PROPERTY_QNAME[0], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void setFldArray(int i5, FldType fldType) {
        generatedSetterHelperImpl(fldType, PROPERTY_QNAME[3], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void setPpArray(int i5, PpType ppType) {
        generatedSetterHelperImpl(ppType, PROPERTY_QNAME[1], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void setTpArray(int i5, TpType tpType) {
        generatedSetterHelperImpl(tpType, PROPERTY_QNAME[2], i5, (short) 2);
    }
}
