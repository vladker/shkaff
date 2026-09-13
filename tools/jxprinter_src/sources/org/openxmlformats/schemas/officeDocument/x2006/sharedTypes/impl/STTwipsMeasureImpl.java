package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STPositiveUniversalMeasure;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTwipsMeasure;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STUnsignedDecimalNumber;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class STTwipsMeasureImpl extends XmlUnionImpl implements STTwipsMeasure, STUnsignedDecimalNumber, STPositiveUniversalMeasure {
    private static final long serialVersionUID = 1;

    public STTwipsMeasureImpl(SchemaType schemaType) {
        super(schemaType, false);
    }

    public STTwipsMeasureImpl(SchemaType schemaType, boolean z6) {
        super(schemaType, z6);
    }
}
