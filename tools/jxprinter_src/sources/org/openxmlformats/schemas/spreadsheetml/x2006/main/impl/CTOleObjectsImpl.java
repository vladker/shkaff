package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTOleObjectsImpl;
import r5.B;
import r5.C1551a0;
import r5.C1553b0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTOleObjectsImpl extends XmlComplexContentImpl implements CTOleObjects {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "oleObject")};
    private static final long serialVersionUID = 1;

    public CTOleObjectsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects
    public CTOleObject addNewOleObject() {
        CTOleObject cTOleObject;
        synchronized (monitor()) {
            check_orphaned();
            cTOleObject = (CTOleObject) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTOleObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects
    public CTOleObject[] getOleObjectArray() {
        return (CTOleObject[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTOleObject[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects
    public List<CTOleObject> getOleObjectList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: r5.m0
                public final /* synthetic */ CTOleObjectsImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getOleObjectArray(iIntValue);
                        default:
                            return this.b.insertNewOleObject(iIntValue);
                    }
                }
            }, new B(this, 24), new Function(this) { // from class: r5.m0
                public final /* synthetic */ CTOleObjectsImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getOleObjectArray(iIntValue);
                        default:
                            return this.b.insertNewOleObject(iIntValue);
                    }
                }
            }, new C1551a0(this, 7), new C1553b0(this, 7));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects
    public CTOleObject insertNewOleObject(int i5) {
        CTOleObject cTOleObject;
        synchronized (monitor()) {
            check_orphaned();
            cTOleObject = (CTOleObject) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTOleObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects
    public void removeOleObject(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects
    public void setOleObjectArray(CTOleObject[] cTOleObjectArr) {
        check_orphaned();
        arraySetterHelper(cTOleObjectArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects
    public int sizeOfOleObjectArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects
    public CTOleObject getOleObjectArray(int i5) {
        CTOleObject cTOleObject;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTOleObject = (CTOleObject) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTOleObject == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTOleObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects
    public void setOleObjectArray(int i5, CTOleObject cTOleObject) {
        generatedSetterHelperImpl(cTOleObject, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
