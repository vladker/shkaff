package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class GroupDocumentImpl extends XmlComplexContentImpl implements GroupDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "group")};
    private static final long serialVersionUID = 1;

    public GroupDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument
    public NamedGroup addNewGroup() {
        NamedGroup namedGroup;
        synchronized (monitor()) {
            check_orphaned();
            namedGroup = (NamedGroup) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return namedGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument
    public NamedGroup getGroup() {
        NamedGroup namedGroup;
        synchronized (monitor()) {
            check_orphaned();
            namedGroup = (NamedGroup) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (namedGroup == null) {
                namedGroup = null;
            }
        }
        return namedGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument
    public void setGroup(NamedGroup namedGroup) {
        generatedSetterHelperImpl(namedGroup, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
