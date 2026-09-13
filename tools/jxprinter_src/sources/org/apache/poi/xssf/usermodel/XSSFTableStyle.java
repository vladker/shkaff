package org.apache.poi.xssf.usermodel;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DifferentialStyleProvider;
import org.apache.poi.ss.usermodel.TableStyle;
import org.apache.poi.ss.usermodel.TableStyleType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFTableStyle implements TableStyle {
    private static final Logger LOG = LogManager.getLogger((Class<?>) XSSFTableStyle.class);
    private final Map<TableStyleType, DifferentialStyleProvider> elementMap = new EnumMap(TableStyleType.class);
    private final int index;
    private final String name;

    /* JADX WARN: Code duplicated, block: B:37:0x00d3  */
    public XSSFTableStyle(int i5, CTDxfs cTDxfs, CTTableStyle cTTableStyle, IndexedColorMap indexedColorMap) {
        XSSFDxfStyleProvider xSSFDxfStyleProvider;
        this.name = cTTableStyle.getName();
        this.index = i5;
        ArrayList arrayList = new ArrayList();
        XmlCursor xmlCursorNewCursor = cTDxfs.newCursor();
        try {
            xmlCursorNewCursor.selectPath("declare namespace x='http://schemas.openxmlformats.org/spreadsheetml/2006/main' .//x:dxf | .//dxf");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                String nodeName = object.getDomNode().getParentNode().getNodeName();
                if (nodeName.equals("mc:Fallback") || nodeName.equals("x:dxfs") || nodeName.contentEquals("dxfs")) {
                    try {
                        CTDxf cTDxf = object instanceof CTDxf ? (CTDxf) object : CTDxf.Factory.parse(object.newXMLStreamReader(), new XmlOptions().setDocumentType(CTDxf.type));
                        if (cTDxf != null) {
                            arrayList.add(cTDxf);
                        }
                    } catch (XmlException e) {
                        LOG.atWarn().withThrowable(e).log("Error parsing XSSFTableStyle");
                    }
                }
            }
            xmlCursorNewCursor.close();
            for (CTTableStyleElement cTTableStyleElement : cTTableStyle.getTableStyleElementList()) {
                TableStyleType tableStyleTypeValueOf = TableStyleType.valueOf(cTTableStyleElement.getType().toString());
                if (cTTableStyleElement.isSetDxfId()) {
                    CTDxf cTDxf2 = (CTDxf) arrayList.get((int) cTTableStyleElement.getDxfId());
                    int size = cTTableStyleElement.isSetSize() ? (int) cTTableStyleElement.getSize() : 0;
                    if (cTDxf2 != null) {
                        xSSFDxfStyleProvider = new XSSFDxfStyleProvider(cTDxf2, size, indexedColorMap);
                    } else {
                        xSSFDxfStyleProvider = null;
                    }
                } else {
                    xSSFDxfStyleProvider = null;
                }
                this.elementMap.put(tableStyleTypeValueOf, xSSFDxfStyleProvider);
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.TableStyle
    public int getIndex() {
        return this.index;
    }

    @Override // org.apache.poi.ss.usermodel.TableStyle
    public String getName() {
        return this.name;
    }

    @Override // org.apache.poi.ss.usermodel.TableStyle
    public DifferentialStyleProvider getStyle(TableStyleType tableStyleType) {
        return this.elementMap.get(tableStyleType);
    }

    @Override // org.apache.poi.ss.usermodel.TableStyle
    public boolean isBuiltin() {
        return false;
    }
}
