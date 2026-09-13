package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STUniversalMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumberOrPercent;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMeasurementOrPercent;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class STMeasurementOrPercentImpl extends XmlUnionImpl implements STMeasurementOrPercent, STDecimalNumberOrPercent, STUniversalMeasure {
    private static final long serialVersionUID = 1;

    public STMeasurementOrPercentImpl(SchemaType schemaType) {
        super(schemaType, false);
    }

    public STMeasurementOrPercentImpl(SchemaType schemaType, boolean z6) {
        super(schemaType, z6);
    }
}
