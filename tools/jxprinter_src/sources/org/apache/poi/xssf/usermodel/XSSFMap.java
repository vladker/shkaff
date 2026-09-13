package org.apache.poi.xssf.usermodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.model.MapInfo;
import org.apache.poi.xssf.model.SingleXmlCells;
import org.apache.poi.xssf.usermodel.helpers.XSSFSingleXmlCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMap;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSchema;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFMap {
    private CTMap ctMap;
    private MapInfo mapInfo;

    public XSSFMap(CTMap cTMap, MapInfo mapInfo) {
        this.ctMap = cTMap;
        this.mapInfo = mapInfo;
    }

    @Internal
    public CTSchema getCTSchema() {
        return this.mapInfo.getCTSchemaById(this.ctMap.getSchemaID());
    }

    @Internal
    public CTMap getCtMap() {
        return this.ctMap;
    }

    public List<XSSFSingleXmlCell> getRelatedSingleXMLCell() {
        ArrayList arrayList = new ArrayList();
        int numberOfSheets = this.mapInfo.getWorkbook().getNumberOfSheets();
        for (int i5 = 0; i5 < numberOfSheets; i5++) {
            for (POIXMLDocumentPart pOIXMLDocumentPart : this.mapInfo.getWorkbook().getSheetAt(i5).getRelations()) {
                if (pOIXMLDocumentPart instanceof SingleXmlCells) {
                    for (XSSFSingleXmlCell xSSFSingleXmlCell : ((SingleXmlCells) pOIXMLDocumentPart).getAllSimpleXmlCell()) {
                        if (xSSFSingleXmlCell.getMapId() == this.ctMap.getID()) {
                            arrayList.add(xSSFSingleXmlCell);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public List<XSSFTable> getRelatedTables() {
        ArrayList arrayList = new ArrayList();
        Iterator<Sheet> it = this.mapInfo.getWorkbook().iterator();
        while (it.hasNext()) {
            for (POIXMLDocumentPart.RelationPart relationPart : ((XSSFSheet) it.next()).getRelationParts()) {
                if (relationPart.getRelationship().getRelationshipType().equals(XSSFRelation.TABLE.getRelation())) {
                    XSSFTable xSSFTable = (XSSFTable) relationPart.getDocumentPart();
                    if (xSSFTable.mapsTo(this.ctMap.getID())) {
                        arrayList.add(xSSFTable);
                    }
                }
            }
        }
        return arrayList;
    }

    public Node getSchema() {
        return getCTSchema().getDomNode().getFirstChild();
    }
}
