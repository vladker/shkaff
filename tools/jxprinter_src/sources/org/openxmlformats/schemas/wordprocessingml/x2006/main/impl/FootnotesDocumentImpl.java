package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFootnotes;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.FootnotesDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class FootnotesDocumentImpl extends XmlComplexContentImpl implements FootnotesDocument {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "footnotes")};
    private static final long serialVersionUID = 1;

    public FootnotesDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.FootnotesDocument
    public CTFootnotes addNewFootnotes() {
        CTFootnotes cTFootnotes;
        synchronized (monitor()) {
            check_orphaned();
            cTFootnotes = (CTFootnotes) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTFootnotes;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.FootnotesDocument
    public CTFootnotes getFootnotes() {
        CTFootnotes cTFootnotes;
        synchronized (monitor()) {
            check_orphaned();
            cTFootnotes = (CTFootnotes) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTFootnotes == null) {
                cTFootnotes = null;
            }
        }
        return cTFootnotes;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.FootnotesDocument
    public void setFootnotes(CTFootnotes cTFootnotes) {
        generatedSetterHelperImpl(cTFootnotes, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
