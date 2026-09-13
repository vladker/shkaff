package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.PageContentsDocument;
import com.microsoft.schemas.office.visio.x2012.main.PageContentsType;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class PageContentsDocumentImpl extends XmlComplexContentImpl implements PageContentsDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.microsoft.com/office/visio/2012/main", "PageContents")};
    private static final long serialVersionUID = 1;

    public PageContentsDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsDocument
    public PageContentsType addNewPageContents() {
        PageContentsType pageContentsType;
        synchronized (monitor()) {
            check_orphaned();
            pageContentsType = (PageContentsType) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return pageContentsType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsDocument
    public PageContentsType getPageContents() {
        PageContentsType pageContentsType;
        synchronized (monitor()) {
            check_orphaned();
            pageContentsType = (PageContentsType) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (pageContentsType == null) {
                pageContentsType = null;
            }
        }
        return pageContentsType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsDocument
    public void setPageContents(PageContentsType pageContentsType) {
        generatedSetterHelperImpl(pageContentsType, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
