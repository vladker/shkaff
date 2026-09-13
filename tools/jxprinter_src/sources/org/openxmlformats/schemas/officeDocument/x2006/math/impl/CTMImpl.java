package org.openxmlformats.schemas.officeDocument.x2006.math.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import l5.b2;
import l5.d2;
import l5.g2;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTM;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTMPr;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTMR;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTMImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTMImpl extends XmlComplexContentImpl implements CTM {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "mPr"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "mr")};
    private static final long serialVersionUID = 1;

    public CTMImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public CTMPr addNewMPr() {
        CTMPr cTMPr;
        synchronized (monitor()) {
            check_orphaned();
            cTMPr = (CTMPr) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTMPr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public CTMR addNewMr() {
        CTMR ctmr;
        synchronized (monitor()) {
            check_orphaned();
            ctmr = (CTMR) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return ctmr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public CTMPr getMPr() {
        CTMPr cTMPr;
        synchronized (monitor()) {
            check_orphaned();
            cTMPr = (CTMPr) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTMPr == null) {
                cTMPr = null;
            }
        }
        return cTMPr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public CTMR[] getMrArray() {
        return (CTMR[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTMR[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public List<CTMR> getMrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: p5.c
                public final /* synthetic */ CTMImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getMrArray(iIntValue);
                        default:
                            return this.b.insertNewMr(iIntValue);
                    }
                }
            }, new g2(this, 8), new Function(this) { // from class: p5.c
                public final /* synthetic */ CTMImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getMrArray(iIntValue);
                        default:
                            return this.b.insertNewMr(iIntValue);
                    }
                }
            }, new d2(this, 15), new b2(this, 15));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public CTMR insertNewMr(int i5) {
        CTMR ctmr;
        synchronized (monitor()) {
            check_orphaned();
            ctmr = (CTMR) get_store().insert_element_user(PROPERTY_QNAME[1], i5);
        }
        return ctmr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public boolean isSetMPr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public void removeMr(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public void setMPr(CTMPr cTMPr) {
        generatedSetterHelperImpl(cTMPr, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public void setMrArray(CTMR[] ctmrArr) {
        check_orphaned();
        arraySetterHelper(ctmrArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public int sizeOfMrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public void unsetMPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public CTMR getMrArray(int i5) {
        CTMR ctmr;
        synchronized (monitor()) {
            try {
                check_orphaned();
                ctmr = (CTMR) get_store().find_element_user(PROPERTY_QNAME[1], i5);
                if (ctmr == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ctmr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public void setMrArray(int i5, CTMR ctmr) {
        generatedSetterHelperImpl(ctmr, PROPERTY_QNAME[1], i5, (short) 2);
    }
}
