package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextScale;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextScaleDecimal;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextScalePercent;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class STTextScaleImpl extends XmlUnionImpl implements STTextScale, STTextScalePercent, STTextScaleDecimal {
    private static final long serialVersionUID = 1;

    public STTextScaleImpl(SchemaType schemaType) {
        super(schemaType, false);
    }

    public STTextScaleImpl(SchemaType schemaType, boolean z6) {
        super(schemaType, z6);
    }
}
