package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTRubyImpl extends XmlComplexContentImpl implements CTRuby {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "rubyPr"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "rt"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "rubyBase")};
    private static final long serialVersionUID = 1;

    public CTRubyImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby
    public CTRubyContent addNewRt() {
        CTRubyContent cTRubyContent;
        synchronized (monitor()) {
            check_orphaned();
            cTRubyContent = (CTRubyContent) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTRubyContent;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby
    public CTRubyContent addNewRubyBase() {
        CTRubyContent cTRubyContent;
        synchronized (monitor()) {
            check_orphaned();
            cTRubyContent = (CTRubyContent) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTRubyContent;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby
    public CTRubyPr addNewRubyPr() {
        CTRubyPr cTRubyPr;
        synchronized (monitor()) {
            check_orphaned();
            cTRubyPr = (CTRubyPr) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTRubyPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby
    public CTRubyContent getRt() {
        CTRubyContent cTRubyContent;
        synchronized (monitor()) {
            check_orphaned();
            cTRubyContent = (CTRubyContent) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTRubyContent == null) {
                cTRubyContent = null;
            }
        }
        return cTRubyContent;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby
    public CTRubyContent getRubyBase() {
        CTRubyContent cTRubyContent;
        synchronized (monitor()) {
            check_orphaned();
            cTRubyContent = (CTRubyContent) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTRubyContent == null) {
                cTRubyContent = null;
            }
        }
        return cTRubyContent;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby
    public CTRubyPr getRubyPr() {
        CTRubyPr cTRubyPr;
        synchronized (monitor()) {
            check_orphaned();
            cTRubyPr = (CTRubyPr) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTRubyPr == null) {
                cTRubyPr = null;
            }
        }
        return cTRubyPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby
    public void setRt(CTRubyContent cTRubyContent) {
        generatedSetterHelperImpl(cTRubyContent, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby
    public void setRubyBase(CTRubyContent cTRubyContent) {
        generatedSetterHelperImpl(cTRubyContent, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby
    public void setRubyPr(CTRubyPr cTRubyPr) {
        generatedSetterHelperImpl(cTRubyPr, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
