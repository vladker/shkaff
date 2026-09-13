package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CommentsDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CommentsDocumentImpl extends XmlComplexContentImpl implements CommentsDocument {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "comments")};
    private static final long serialVersionUID = 1;

    public CommentsDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CommentsDocument
    public CTComments addNewComments() {
        CTComments cTComments;
        synchronized (monitor()) {
            check_orphaned();
            cTComments = (CTComments) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTComments;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CommentsDocument
    public CTComments getComments() {
        CTComments cTComments;
        synchronized (monitor()) {
            check_orphaned();
            cTComments = (CTComments) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTComments == null) {
                cTComments = null;
            }
        }
        return cTComments;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CommentsDocument
    public void setComments(CTComments cTComments) {
        generatedSetterHelperImpl(cTComments, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
