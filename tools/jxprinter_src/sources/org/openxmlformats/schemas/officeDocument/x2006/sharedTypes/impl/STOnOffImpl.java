package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STOnOff;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STOnOff1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class STOnOffImpl extends XmlUnionImpl implements STOnOff, XmlBoolean, STOnOff1 {
    private static final long serialVersionUID = 1;

    public STOnOffImpl(SchemaType schemaType) {
        super(schemaType, false);
    }

    public STOnOffImpl(SchemaType schemaType, boolean z6) {
        super(schemaType, z6);
    }
}
