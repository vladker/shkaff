package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.STOverlap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STOverlapByte;
import org.openxmlformats.schemas.drawingml.x2006.chart.STOverlapPercent;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class STOverlapImpl extends XmlUnionImpl implements STOverlap, STOverlapPercent, STOverlapByte {
    private static final long serialVersionUID = 1;

    public STOverlapImpl(SchemaType schemaType) {
        super(schemaType, false);
    }

    public STOverlapImpl(SchemaType schemaType, boolean z6) {
        super(schemaType, z6);
    }
}
