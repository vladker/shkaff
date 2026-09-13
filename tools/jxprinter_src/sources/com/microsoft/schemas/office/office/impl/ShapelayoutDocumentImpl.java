package com.microsoft.schemas.office.office.impl;

import com.microsoft.schemas.office.office.CTShapeLayout;
import com.microsoft.schemas.office.office.ShapelayoutDocument;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class ShapelayoutDocumentImpl extends XmlComplexContentImpl implements ShapelayoutDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("urn:schemas-microsoft-com:office:office", "shapelayout")};
    private static final long serialVersionUID = 1;

    public ShapelayoutDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.office.ShapelayoutDocument
    public CTShapeLayout addNewShapelayout() {
        CTShapeLayout cTShapeLayout;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeLayout = (CTShapeLayout) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTShapeLayout;
    }

    @Override // com.microsoft.schemas.office.office.ShapelayoutDocument
    public CTShapeLayout getShapelayout() {
        CTShapeLayout cTShapeLayout;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeLayout = (CTShapeLayout) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTShapeLayout == null) {
                cTShapeLayout = null;
            }
        }
        return cTShapeLayout;
    }

    @Override // com.microsoft.schemas.office.office.ShapelayoutDocument
    public void setShapelayout(CTShapeLayout cTShapeLayout) {
        generatedSetterHelperImpl(cTShapeLayout, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
