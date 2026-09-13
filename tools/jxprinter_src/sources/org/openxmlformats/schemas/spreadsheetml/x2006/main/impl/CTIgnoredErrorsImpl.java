package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredError;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTIgnoredErrorsImpl;
import r5.B;
import r5.C1551a0;
import r5.C1553b0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTIgnoredErrorsImpl extends XmlComplexContentImpl implements CTIgnoredErrors {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "ignoredError"), new QName(XSSFRelation.NS_SPREADSHEETML, "extLst")};
    private static final long serialVersionUID = 1;

    public CTIgnoredErrorsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public CTIgnoredError addNewIgnoredError() {
        CTIgnoredError cTIgnoredError;
        synchronized (monitor()) {
            check_orphaned();
            cTIgnoredError = (CTIgnoredError) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTIgnoredError;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public CTIgnoredError[] getIgnoredErrorArray() {
        return (CTIgnoredError[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTIgnoredError[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public List<CTIgnoredError> getIgnoredErrorList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: r5.d0
                public final /* synthetic */ CTIgnoredErrorsImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getIgnoredErrorArray(iIntValue);
                        default:
                            return this.b.insertNewIgnoredError(iIntValue);
                    }
                }
            }, new B(this, 19), new Function(this) { // from class: r5.d0
                public final /* synthetic */ CTIgnoredErrorsImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getIgnoredErrorArray(iIntValue);
                        default:
                            return this.b.insertNewIgnoredError(iIntValue);
                    }
                }
            }, new C1551a0(this, 2), new C1553b0(this, 2));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public CTIgnoredError insertNewIgnoredError(int i5) {
        CTIgnoredError cTIgnoredError;
        synchronized (monitor()) {
            check_orphaned();
            cTIgnoredError = (CTIgnoredError) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTIgnoredError;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public boolean isSetExtLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = true;
            if (get_store().count_elements(PROPERTY_QNAME[1]) == 0) {
                z6 = false;
            }
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public void removeIgnoredError(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public void setExtLst(CTExtensionList cTExtensionList) {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public void setIgnoredErrorArray(CTIgnoredError[] cTIgnoredErrorArr) {
        check_orphaned();
        arraySetterHelper(cTIgnoredErrorArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public int sizeOfIgnoredErrorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public CTIgnoredError getIgnoredErrorArray(int i5) {
        CTIgnoredError cTIgnoredError;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTIgnoredError = (CTIgnoredError) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTIgnoredError == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTIgnoredError;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public void setIgnoredErrorArray(int i5, CTIgnoredError cTIgnoredError) {
        generatedSetterHelperImpl(cTIgnoredError, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
