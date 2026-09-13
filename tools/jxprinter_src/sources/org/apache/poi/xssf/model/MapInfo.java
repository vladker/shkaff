package org.apache.poi.xssf.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xssf.usermodel.XSSFMap;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMap;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSchema;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.MapInfoDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MapInfo extends POIXMLDocumentPart {
    private CTMapInfo mapInfo;
    private Map<Integer, XSSFMap> maps;

    public MapInfo() {
        this.mapInfo = CTMapInfo.Factory.newInstance();
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            writeTo(outputStream);
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public Collection<XSSFMap> getAllXSSFMaps() {
        return this.maps.values();
    }

    public CTMapInfo getCTMapInfo() {
        return this.mapInfo;
    }

    public CTSchema getCTSchemaById(String str) {
        for (CTSchema cTSchema : this.mapInfo.getSchemaArray()) {
            if (cTSchema.getID().equals(str)) {
                return cTSchema;
            }
        }
        return null;
    }

    public XSSFWorkbook getWorkbook() {
        return (XSSFWorkbook) getParent();
    }

    public XSSFMap getXSSFMapById(int i5) {
        return this.maps.get(Integer.valueOf(i5));
    }

    public XSSFMap getXSSFMapByName(String str) {
        XSSFMap xSSFMap = null;
        for (XSSFMap xSSFMap2 : this.maps.values()) {
            if (xSSFMap2.getCtMap().getName() != null && xSSFMap2.getCtMap().getName().equals(str)) {
                xSSFMap = xSSFMap2;
            }
        }
        return xSSFMap;
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            this.mapInfo = MapInfoDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getMapInfo();
            this.maps = new HashMap();
            for (CTMap cTMap : this.mapInfo.getMapArray()) {
                this.maps.put(Integer.valueOf((int) cTMap.getID()), new XSSFMap(cTMap, this));
            }
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public void writeTo(OutputStream outputStream) {
        MapInfoDocument mapInfoDocumentNewInstance = MapInfoDocument.Factory.newInstance();
        mapInfoDocumentNewInstance.setMapInfo(this.mapInfo);
        mapInfoDocumentNewInstance.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }

    public MapInfo(PackagePart packagePart) throws IOException {
        super(packagePart);
        InputStream inputStream = packagePart.getInputStream();
        try {
            readFrom(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
