package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.List;
import javax.xml.namespace.QName;
import l5.C1161a;
import l5.C1164b;
import l5.C1167c;
import l5.C1170d;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPolarAdjustHandle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTXYAdjustHandle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTAdjustHandleListImpl extends XmlComplexContentImpl implements CTAdjustHandleList {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_DRAWINGML, "ahXY"), new QName(XSSFRelation.NS_DRAWINGML, "ahPolar")};
    private static final long serialVersionUID = 1;

    public CTAdjustHandleListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTPolarAdjustHandle addNewAhPolar() {
        CTPolarAdjustHandle cTPolarAdjustHandle;
        synchronized (monitor()) {
            check_orphaned();
            cTPolarAdjustHandle = (CTPolarAdjustHandle) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTPolarAdjustHandle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTXYAdjustHandle addNewAhXY() {
        CTXYAdjustHandle cTXYAdjustHandle;
        synchronized (monitor()) {
            check_orphaned();
            cTXYAdjustHandle = (CTXYAdjustHandle) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTXYAdjustHandle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTPolarAdjustHandle[] getAhPolarArray() {
        return (CTPolarAdjustHandle[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTPolarAdjustHandle[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public List<CTPolarAdjustHandle> getAhPolarList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1161a(this, 0), new C1164b(this, 0), new C1161a(this, 1), new C1167c(this, 0), new C1170d(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTXYAdjustHandle[] getAhXYArray() {
        return (CTXYAdjustHandle[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTXYAdjustHandle[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public List<CTXYAdjustHandle> getAhXYList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1161a(this, 2), new C1164b(this, 1), new C1161a(this, 3), new C1167c(this, 1), new C1170d(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTPolarAdjustHandle insertNewAhPolar(int i5) {
        CTPolarAdjustHandle cTPolarAdjustHandle;
        synchronized (monitor()) {
            check_orphaned();
            cTPolarAdjustHandle = (CTPolarAdjustHandle) get_store().insert_element_user(PROPERTY_QNAME[1], i5);
        }
        return cTPolarAdjustHandle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTXYAdjustHandle insertNewAhXY(int i5) {
        CTXYAdjustHandle cTXYAdjustHandle;
        synchronized (monitor()) {
            check_orphaned();
            cTXYAdjustHandle = (CTXYAdjustHandle) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTXYAdjustHandle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public void removeAhPolar(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public void removeAhXY(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public void setAhPolarArray(CTPolarAdjustHandle[] cTPolarAdjustHandleArr) {
        check_orphaned();
        arraySetterHelper(cTPolarAdjustHandleArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public void setAhXYArray(CTXYAdjustHandle[] cTXYAdjustHandleArr) {
        check_orphaned();
        arraySetterHelper(cTXYAdjustHandleArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public int sizeOfAhPolarArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public int sizeOfAhXYArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTPolarAdjustHandle getAhPolarArray(int i5) {
        CTPolarAdjustHandle cTPolarAdjustHandle;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTPolarAdjustHandle = (CTPolarAdjustHandle) get_store().find_element_user(PROPERTY_QNAME[1], i5);
                if (cTPolarAdjustHandle == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTPolarAdjustHandle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTXYAdjustHandle getAhXYArray(int i5) {
        CTXYAdjustHandle cTXYAdjustHandle;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTXYAdjustHandle = (CTXYAdjustHandle) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTXYAdjustHandle == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTXYAdjustHandle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public void setAhPolarArray(int i5, CTPolarAdjustHandle cTPolarAdjustHandle) {
        generatedSetterHelperImpl(cTPolarAdjustHandle, PROPERTY_QNAME[1], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public void setAhXYArray(int i5, CTXYAdjustHandle cTXYAdjustHandle) {
        generatedSetterHelperImpl(cTXYAdjustHandle, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
