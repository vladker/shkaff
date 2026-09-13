package org.apache.poi.sl.draw.geom;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import org.apache.poi.util.XMLHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class PresetGeometries {
    private final Map<String, CustomGeometry> map;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SingletonHelper {
        private static final PresetGeometries INSTANCE = new PresetGeometries();

        private SingletonHelper() {
        }
    }

    public static PresetGeometries getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public CustomGeometry get(String str) {
        if (str == null) {
            return null;
        }
        return this.map.get(str);
    }

    public int hashCode() {
        return Objects.hash(this.map);
    }

    public Set<String> keySet() {
        return this.map.keySet();
    }

    public int size() {
        return this.map.size();
    }

    private PresetGeometries() {
        TreeMap treeMap = new TreeMap();
        this.map = treeMap;
        try {
            InputStream resourceAsStream = PresetGeometries.class.getResourceAsStream("presetShapeDefinitions.xml");
            try {
                XMLStreamReader xMLStreamReaderCreateXMLStreamReader = XMLHelper.newXMLInputFactory().createXMLStreamReader(new StreamSource(resourceAsStream));
                try {
                    PresetParser presetParser = new PresetParser(PresetParser.Mode.FILE);
                    presetParser.parse(xMLStreamReaderCreateXMLStreamReader);
                    treeMap.putAll(presetParser.getGeom());
                    xMLStreamReaderCreateXMLStreamReader.close();
                    if (resourceAsStream != null) {
                        resourceAsStream.close();
                    }
                } catch (Throwable th) {
                    xMLStreamReaderCreateXMLStreamReader.close();
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    if (resourceAsStream != null) {
                        try {
                            resourceAsStream.close();
                        } catch (Throwable th4) {
                            th2.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            }
        } catch (XMLStreamException | IOException e) {
            throw new RuntimeException((Throwable) e);
        }
    }
}
