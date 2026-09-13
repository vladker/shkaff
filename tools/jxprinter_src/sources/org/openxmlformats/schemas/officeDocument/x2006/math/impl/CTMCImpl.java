package org.openxmlformats.schemas.officeDocument.x2006.math.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTMC;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTMCPr;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTMCImpl extends XmlComplexContentImpl implements CTMC {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "mcPr")};
    private static final long serialVersionUID = 1;

    public CTMCImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMC
    public CTMCPr addNewMcPr() {
        CTMCPr cTMCPr;
        synchronized (monitor()) {
            check_orphaned();
            cTMCPr = (CTMCPr) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTMCPr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMC
    public CTMCPr getMcPr() {
        CTMCPr cTMCPr;
        synchronized (monitor()) {
            check_orphaned();
            cTMCPr = (CTMCPr) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTMCPr == null) {
                cTMCPr = null;
            }
        }
        return cTMCPr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMC
    public boolean isSetMcPr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMC
    public void setMcPr(CTMCPr cTMCPr) {
        generatedSetterHelperImpl(cTMCPr, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMC
    public void unsetMcPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }
}
