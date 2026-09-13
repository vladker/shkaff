package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCommentList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTCommentsImpl extends XmlComplexContentImpl implements CTComments {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "authors"), new QName(XSSFRelation.NS_SPREADSHEETML, "commentList"), new QName(XSSFRelation.NS_SPREADSHEETML, "extLst")};
    private static final long serialVersionUID = 1;

    public CTCommentsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public CTAuthors addNewAuthors() {
        CTAuthors cTAuthors;
        synchronized (monitor()) {
            check_orphaned();
            cTAuthors = (CTAuthors) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTAuthors;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public CTCommentList addNewCommentList() {
        CTCommentList cTCommentList;
        synchronized (monitor()) {
            check_orphaned();
            cTCommentList = (CTCommentList) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTCommentList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public CTAuthors getAuthors() {
        CTAuthors cTAuthors;
        synchronized (monitor()) {
            check_orphaned();
            cTAuthors = (CTAuthors) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTAuthors == null) {
                cTAuthors = null;
            }
        }
        return cTAuthors;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public CTCommentList getCommentList() {
        CTCommentList cTCommentList;
        synchronized (monitor()) {
            check_orphaned();
            cTCommentList = (CTCommentList) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTCommentList == null) {
                cTCommentList = null;
            }
        }
        return cTCommentList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public boolean isSetExtLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public void setAuthors(CTAuthors cTAuthors) {
        generatedSetterHelperImpl(cTAuthors, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public void setCommentList(CTCommentList cTCommentList) {
        generatedSetterHelperImpl(cTCommentList, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public void setExtLst(CTExtensionList cTExtensionList) {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }
}
