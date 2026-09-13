package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;
import org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontDataId;
import org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTEmbeddedFontListEntryImpl extends XmlComplexContentImpl implements CTEmbeddedFontListEntry {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_PRESENTATIONML, CellUtil.FONT), new QName(XSSFRelation.NS_PRESENTATIONML, "regular"), new QName(XSSFRelation.NS_PRESENTATIONML, "bold"), new QName(XSSFRelation.NS_PRESENTATIONML, "italic"), new QName(XSSFRelation.NS_PRESENTATIONML, "boldItalic")};
    private static final long serialVersionUID = 1;

    public CTEmbeddedFontListEntryImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public CTEmbeddedFontDataId addNewBold() {
        CTEmbeddedFontDataId cTEmbeddedFontDataId;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedFontDataId = (CTEmbeddedFontDataId) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTEmbeddedFontDataId;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public CTEmbeddedFontDataId addNewBoldItalic() {
        CTEmbeddedFontDataId cTEmbeddedFontDataId;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedFontDataId = (CTEmbeddedFontDataId) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTEmbeddedFontDataId;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public CTTextFont addNewFont() {
        CTTextFont cTTextFont;
        synchronized (monitor()) {
            check_orphaned();
            cTTextFont = (CTTextFont) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTextFont;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public CTEmbeddedFontDataId addNewItalic() {
        CTEmbeddedFontDataId cTEmbeddedFontDataId;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedFontDataId = (CTEmbeddedFontDataId) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTEmbeddedFontDataId;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public CTEmbeddedFontDataId addNewRegular() {
        CTEmbeddedFontDataId cTEmbeddedFontDataId;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedFontDataId = (CTEmbeddedFontDataId) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTEmbeddedFontDataId;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public CTEmbeddedFontDataId getBold() {
        CTEmbeddedFontDataId cTEmbeddedFontDataId;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedFontDataId = (CTEmbeddedFontDataId) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTEmbeddedFontDataId == null) {
                cTEmbeddedFontDataId = null;
            }
        }
        return cTEmbeddedFontDataId;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public CTEmbeddedFontDataId getBoldItalic() {
        CTEmbeddedFontDataId cTEmbeddedFontDataId;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedFontDataId = (CTEmbeddedFontDataId) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTEmbeddedFontDataId == null) {
                cTEmbeddedFontDataId = null;
            }
        }
        return cTEmbeddedFontDataId;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public CTTextFont getFont() {
        CTTextFont cTTextFont;
        synchronized (monitor()) {
            check_orphaned();
            cTTextFont = (CTTextFont) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTextFont == null) {
                cTTextFont = null;
            }
        }
        return cTTextFont;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public CTEmbeddedFontDataId getItalic() {
        CTEmbeddedFontDataId cTEmbeddedFontDataId;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedFontDataId = (CTEmbeddedFontDataId) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTEmbeddedFontDataId == null) {
                cTEmbeddedFontDataId = null;
            }
        }
        return cTEmbeddedFontDataId;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public CTEmbeddedFontDataId getRegular() {
        CTEmbeddedFontDataId cTEmbeddedFontDataId;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedFontDataId = (CTEmbeddedFontDataId) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTEmbeddedFontDataId == null) {
                cTEmbeddedFontDataId = null;
            }
        }
        return cTEmbeddedFontDataId;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public boolean isSetBold() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public boolean isSetBoldItalic() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public boolean isSetItalic() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public boolean isSetRegular() {
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public void setBold(CTEmbeddedFontDataId cTEmbeddedFontDataId) {
        generatedSetterHelperImpl(cTEmbeddedFontDataId, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public void setBoldItalic(CTEmbeddedFontDataId cTEmbeddedFontDataId) {
        generatedSetterHelperImpl(cTEmbeddedFontDataId, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public void setFont(CTTextFont cTTextFont) {
        generatedSetterHelperImpl(cTTextFont, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public void setItalic(CTEmbeddedFontDataId cTEmbeddedFontDataId) {
        generatedSetterHelperImpl(cTEmbeddedFontDataId, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public void setRegular(CTEmbeddedFontDataId cTEmbeddedFontDataId) {
        generatedSetterHelperImpl(cTEmbeddedFontDataId, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public void unsetBold() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public void unsetBoldItalic() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public void unsetItalic() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry
    public void unsetRegular() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }
}
