package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList;
import org.openxmlformats.schemas.presentationml.x2006.main.CmAuthorLstDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CmAuthorLstDocumentImpl extends XmlComplexContentImpl implements CmAuthorLstDocument {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_PRESENTATIONML, "cmAuthorLst")};
    private static final long serialVersionUID = 1;

    public CmAuthorLstDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CmAuthorLstDocument
    public CTCommentAuthorList addNewCmAuthorLst() {
        CTCommentAuthorList cTCommentAuthorList;
        synchronized (monitor()) {
            check_orphaned();
            cTCommentAuthorList = (CTCommentAuthorList) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTCommentAuthorList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CmAuthorLstDocument
    public CTCommentAuthorList getCmAuthorLst() {
        CTCommentAuthorList cTCommentAuthorList;
        synchronized (monitor()) {
            check_orphaned();
            cTCommentAuthorList = (CTCommentAuthorList) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTCommentAuthorList == null) {
                cTCommentAuthorList = null;
            }
        }
        return cTCommentAuthorList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CmAuthorLstDocument
    public void setCmAuthorLst(CTCommentAuthorList cTCommentAuthorList) {
        generatedSetterHelperImpl(cTCommentAuthorList, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
