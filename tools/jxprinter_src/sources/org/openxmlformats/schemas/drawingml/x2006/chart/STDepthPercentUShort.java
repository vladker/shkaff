package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlUnsignedShort;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STDepthPercentUShort extends XmlUnsignedShort {
    public static final SimpleTypeFactory<STDepthPercentUShort> Factory;
    public static final SchemaType type;

    static {
        SimpleTypeFactory<STDepthPercentUShort> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stdepthpercentushorte7a3type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }
}
