package org.apache.poi.xssf.extractor;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.ooxml.util.DocumentHelper;
import org.apache.poi.ooxml.util.XPathHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFMap;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFTableColumn;
import org.apache.poi.xssf.usermodel.helpers.XSSFSingleXmlCell;
import org.apache.poi.xssf.usermodel.helpers.XSSFXmlColumnPr;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFImportFromXML {
    private static final Logger LOG = LogManager.getLogger((Class<?>) XSSFImportFromXML.class);
    private final XSSFMap _map;

    /* JADX INFO: renamed from: org.apache.poi.xssf.extractor.XSSFImportFromXML$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$extractor$XSSFImportFromXML$DataType;

        static {
            int[] iArr = new int[DataType.values().length];
            $SwitchMap$org$apache$poi$xssf$extractor$XSSFImportFromXML$DataType = iArr;
            try {
                iArr[DataType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$extractor$XSSFImportFromXML$DataType[DataType.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$extractor$XSSFImportFromXML$DataType[DataType.INTEGER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$extractor$XSSFImportFromXML$DataType[DataType.DATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$extractor$XSSFImportFromXML$DataType[DataType.STRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum DataType {
        BOOLEAN("boolean"),
        DOUBLE(XmlErrorCodes.DOUBLE),
        INTEGER(XmlErrorCodes.INT, "unsignedInt", "integer"),
        STRING(TypedValues.Custom.S_STRING),
        DATE(XmlErrorCodes.DATE);

        private Set<String> xmlDataTypes;

        DataType(String... strArr) {
            this.xmlDataTypes = new HashSet(Arrays.asList(strArr));
        }

        public static DataType getDataType(String str) {
            for (DataType dataType : values()) {
                if (dataType.xmlDataTypes.contains(str)) {
                    return dataType;
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class DefaultNamespaceContext implements NamespaceContext {
        private final Element _docElem;

        public DefaultNamespaceContext(Document document) {
            this._docElem = document.getDocumentElement();
        }

        private String getNamespaceForPrefix(String str) {
            if (str.equals("xml")) {
                return "http://www.w3.org/XML/1998/namespace";
            }
            Node parentNode = this._docElem;
            while (parentNode != null) {
                short nodeType = parentNode.getNodeType();
                if (nodeType == 1) {
                    if (parentNode.getNodeName().startsWith(str.concat(ParameterizedMessage.ERROR_MSG_SEPARATOR))) {
                        return parentNode.getNamespaceURI();
                    }
                    NamedNodeMap attributes = parentNode.getAttributes();
                    for (int i5 = 0; i5 < attributes.getLength(); i5++) {
                        Node nodeItem = attributes.item(i5);
                        String nodeName = nodeItem.getNodeName();
                        boolean zStartsWith = nodeName.startsWith(Sax2Dom.XMLNS_STRING);
                        if (zStartsWith || nodeName.equals(Sax2Dom.XMLNS_PREFIX)) {
                            if ((zStartsWith ? nodeName.substring(nodeName.indexOf(58) + 1) : "").equals(str)) {
                                return nodeItem.getNodeValue();
                            }
                        }
                    }
                    parentNode = parentNode.getParentNode();
                } else if (nodeType != 5) {
                    return null;
                }
            }
            return null;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getNamespaceURI(String str) {
            return getNamespaceForPrefix(str);
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getPrefix(String str) {
            return null;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public Iterator<String> getPrefixes(String str) {
            return null;
        }
    }

    public XSSFImportFromXML(XSSFMap xSSFMap) {
        this._map = xSSFMap;
    }

    private void setCellValue(String str, XSSFCell xSSFCell, String str2) {
        DataType dataType = DataType.getDataType(str2);
        try {
            if (!str.isEmpty() && dataType != null) {
                int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$xssf$extractor$XSSFImportFromXML$DataType[dataType.ordinal()];
                if (i5 == 1) {
                    xSSFCell.setCellValue(Boolean.parseBoolean(str));
                    return;
                }
                if (i5 == 2) {
                    xSSFCell.setCellValue(Double.parseDouble(str));
                    return;
                }
                if (i5 == 3) {
                    xSSFCell.setCellValue(Integer.parseInt(str));
                    return;
                }
                if (i5 != 4) {
                    xSSFCell.setCellValue(str.trim());
                    return;
                }
                xSSFCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd", LocaleUtil.getUserLocale()).parse(str));
                if (DateUtil.isValidExcelDate(xSSFCell.getNumericCellValue())) {
                    return;
                }
                xSSFCell.setCellValue(str);
                return;
            }
            xSSFCell.setCellValue((String) null);
        } catch (IllegalArgumentException | ParseException unused) {
            LocaleUtil.getUserLocale();
            throw new IllegalArgumentException("Unable to format value '" + str + "' as " + dataType + " for cell " + new CellReference(xSSFCell).formatAsString());
        }
    }

    public void importFromXML(String str) throws SAXException, IOException {
        Document document = DocumentHelper.newDocumentBuilder().parse(new InputSource(new StringReader(str.trim())));
        List<XSSFSingleXmlCell> relatedSingleXMLCell = this._map.getRelatedSingleXMLCell();
        List<XSSFTable> relatedTables = this._map.getRelatedTables();
        XPath xPathNewXPath = XPathHelper.getFactory().newXPath();
        xPathNewXPath.setNamespaceContext(new DefaultNamespaceContext(document));
        for (XSSFSingleXmlCell xSSFSingleXmlCell : relatedSingleXMLCell) {
            String xmlDataType = xSSFSingleXmlCell.getXmlDataType();
            String xpath = xSSFSingleXmlCell.getXpath();
            Node node = (Node) xPathNewXPath.evaluate(xpath, document, XPathConstants.NODE);
            if (node != null) {
                String textContent = node.getTextContent();
                Logger logger = LOG;
                logger.atDebug().log("Extracting with xpath {} : value is '{}'", xpath, textContent);
                XSSFCell referencedCell = xSSFSingleXmlCell.getReferencedCell();
                logger.atDebug().log("Setting '{}' to cell {}-{} in sheet {}", textContent, Unbox.box(referencedCell.getColumnIndex()), Unbox.box(referencedCell.getRowIndex()), referencedCell.getSheet().getSheetName());
                setCellValue(textContent, referencedCell, xmlDataType);
            }
        }
        Iterator<XSSFTable> it = relatedTables.iterator();
        while (it.hasNext()) {
            XSSFTable next = it.next();
            NodeList nodeList = (NodeList) xPathNewXPath.evaluate(next.getCommonXpath(), document, XPathConstants.NODESET);
            int headerRowCount = next.getHeaderRowCount() + next.getStartCellReference().getRow();
            short col = next.getStartCellReference().getCol();
            next.setDataRowCount(nodeList.getLength());
            for (int i5 = 0; i5 < nodeList.getLength(); i5++) {
                int i6 = 1;
                Node nodeCloneNode = nodeList.item(i5).cloneNode(true);
                for (XSSFTableColumn xSSFTableColumn : next.getColumns()) {
                    XSSFXmlColumnPr xmlColumnPr = xSSFTableColumn.getXmlColumnPr();
                    if (xmlColumnPr != null) {
                        int i7 = headerRowCount + i5;
                        int columnIndex = xSSFTableColumn.getColumnIndex() + col;
                        Document document2 = document;
                        String localXPath = xmlColumnPr.getLocalXPath();
                        Iterator<XSSFTable> it2 = it;
                        String strSubstring = localXPath.substring(localXPath.indexOf(47, i6) + i6);
                        String str2 = (String) xPathNewXPath.evaluate(strSubstring, nodeCloneNode, XPathConstants.STRING);
                        Logger logger2 = LOG;
                        logger2.atDebug().log("Extracting with xpath {} : value is '{}'", strSubstring, str2);
                        XSSFRow row = next.getXSSFSheet().getRow(i7);
                        if (row == null) {
                            row = next.getXSSFSheet().createRow(i7);
                        }
                        XSSFCell cell = row.getCell(columnIndex);
                        if (cell == null) {
                            cell = row.createCell(columnIndex);
                        }
                        logger2.atDebug().log("Setting '{}' to cell {}-{} in sheet {}", str2, Unbox.box(cell.getColumnIndex()), Unbox.box(cell.getRowIndex()), next.getXSSFSheet().getSheetName());
                        setCellValue(str2, cell, xmlColumnPr.getXmlDataType());
                        document = document2;
                        it = it2;
                        i6 = 1;
                    }
                }
            }
        }
    }
}
