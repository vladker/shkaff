package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.STGapAmount;
import org.openxmlformats.schemas.drawingml.x2006.chart.STGapAmountPercent;
import org.openxmlformats.schemas.drawingml.x2006.chart.STGapAmountUShort;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class STGapAmountImpl extends XmlUnionImpl implements STGapAmount, STGapAmountPercent, STGapAmountUShort {
    private static final long serialVersionUID = 1;

    public STGapAmountImpl(SchemaType schemaType) {
        super(schemaType, false);
    }

    public STGapAmountImpl(SchemaType schemaType, boolean z6) {
        super(schemaType, z6);
    }
}
