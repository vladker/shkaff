package org.openxmlformats.schemas.officeDocument.x2006.math.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTInteger255;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTMCPr;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTXAlign;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTMCPrImpl extends XmlComplexContentImpl implements CTMCPr {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "count"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "mcJc")};
    private static final long serialVersionUID = 1;

    public CTMCPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCPr
    public CTInteger255 addNewCount() {
        CTInteger255 cTInteger255;
        synchronized (monitor()) {
            check_orphaned();
            cTInteger255 = (CTInteger255) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTInteger255;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCPr
    public CTXAlign addNewMcJc() {
        CTXAlign cTXAlign;
        synchronized (monitor()) {
            check_orphaned();
            cTXAlign = (CTXAlign) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTXAlign;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCPr
    public CTInteger255 getCount() {
        CTInteger255 cTInteger255;
        synchronized (monitor()) {
            check_orphaned();
            cTInteger255 = (CTInteger255) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTInteger255 == null) {
                cTInteger255 = null;
            }
        }
        return cTInteger255;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCPr
    public CTXAlign getMcJc() {
        CTXAlign cTXAlign;
        synchronized (monitor()) {
            check_orphaned();
            cTXAlign = (CTXAlign) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTXAlign == null) {
                cTXAlign = null;
            }
        }
        return cTXAlign;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCPr
    public boolean isSetCount() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCPr
    public boolean isSetMcJc() {
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

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCPr
    public void setCount(CTInteger255 cTInteger255) {
        generatedSetterHelperImpl(cTInteger255, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCPr
    public void setMcJc(CTXAlign cTXAlign) {
        generatedSetterHelperImpl(cTXAlign, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCPr
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCPr
    public void unsetMcJc() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }
}
