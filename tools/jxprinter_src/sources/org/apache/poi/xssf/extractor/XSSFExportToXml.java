package org.apache.poi.xssf.extractor;

import androidx.collection.a;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.ooxml.util.DocumentHelper;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.XMLHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFMap;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFTableColumn;
import org.apache.poi.xssf.usermodel.helpers.XSSFSingleXmlCell;
import org.apache.poi.xssf.usermodel.helpers.XSSFXmlColumnPr;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFExportToXml implements Comparator<String> {
    private static final Logger LOG = LogManager.getLogger((Class<?>) XSSFExportToXml.class);
    private final HashMap<String, Integer> indexMap = new HashMap<>();
    private XSSFMap map;

    /* JADX INFO: renamed from: org.apache.poi.xssf.extractor.XSSFExportToXml$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

        static {
            int[] iArr = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr;
            try {
                iArr[CellType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.NUMERIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @FunctionalInterface
    public interface SecurityFeature {
        void accept(String str);
    }

    public XSSFExportToXml(XSSFMap xSSFMap) {
        this.map = xSSFMap;
    }

    private Node createAttribute(Document document, Node node, String str) {
        String strSubstring = str.substring(1);
        NamedNodeMap attributes = node.getAttributes();
        Node namedItem = attributes.getNamedItem(strSubstring);
        if (namedItem != null) {
            return namedItem;
        }
        Attr attrCreateAttributeNS = document.createAttributeNS("", strSubstring);
        attributes.setNamedItem(attrCreateAttributeNS);
        return attrCreateAttributeNS;
    }

    private Node createElement(Document document, Node node, String str) {
        Element elementCreateElementNS = isNamespaceDeclared() ? document.createElementNS(getNamespace(), str) : document.createElementNS("", str);
        node.appendChild(elementCreateElementNS);
        return elementCreateElementNS;
    }

    private int getAndStoreIndex(String str, String str2) {
        return this.indexMap.getOrDefault(a.o(str, PackagingURIHelper.FORWARD_SLASH_STRING, str2), -1).intValue();
    }

    private Node getComplexTypeForElement(String str, Node node, Node node2) {
        String complexTypeNameFromChildren = getComplexTypeNameFromChildren(node2, removeNamespace(str));
        if ("".equals(complexTypeNameFromChildren)) {
            return null;
        }
        return getComplexTypeNodeFromSchemaChildren(node, null, complexTypeNameFromChildren);
    }

    private String getComplexTypeNameFromChildren(Node node, String str) {
        Node namedItem;
        if (node == null) {
            return "";
        }
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if ((firstChild instanceof Element) && "element".equals(firstChild.getLocalName()) && getNameOrRefElement(firstChild).getNodeValue().equals(str) && (namedItem = firstChild.getAttributes().getNamedItem("type")) != null) {
                return namedItem.getNodeValue();
            }
        }
        return "";
    }

    private Node getComplexTypeNodeFromSchemaChildren(Node node, Node node2, String str) {
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if ((firstChild instanceof Element) && "complexType".equals(firstChild.getLocalName()) && getNameOrRefElement(firstChild).getNodeValue().equals(str)) {
                for (Node firstChild2 = firstChild.getFirstChild(); firstChild2 != null; firstChild2 = firstChild2.getNextSibling()) {
                    if (firstChild2 instanceof Element) {
                        String localName = firstChild2.getLocalName();
                        if ("sequence".equals(localName) || "all".equals(localName)) {
                            node2 = firstChild2;
                            break;
                        }
                    }
                }
                if (node2 != null) {
                    return node2;
                }
            }
        }
        return node2;
    }

    private String getFormattedDate(XSSFCell xSSFCell) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
        simpleDateFormat.setTimeZone(LocaleUtil.getUserTimeZone());
        return simpleDateFormat.format(xSSFCell.getDateCellValue());
    }

    private Node getNameOrRefElement(Node node) {
        Node namedItem = node.getAttributes().getNamedItem("ref");
        return namedItem != null ? namedItem : node.getAttributes().getNamedItem("name");
    }

    private String getNamespace() {
        return this.map.getCTSchema().getNamespace();
    }

    private Node getNodeByXPath(String str, Node node, Document document, boolean z6) {
        String[] strArrSplit = str.split(PackagingURIHelper.FORWARD_SLASH_STRING);
        int i5 = 2;
        while (i5 < strArrSplit.length) {
            String strRemoveNamespace = removeNamespace(strArrSplit[i5]);
            if (strRemoveNamespace.startsWith("@")) {
                node = createAttribute(document, node, strRemoveNamespace);
            } else {
                Node nodeSelectNode = (z6 && i5 == strArrSplit.length + (-1)) ? null : selectNode(strRemoveNamespace, node.getChildNodes());
                if (nodeSelectNode == null) {
                    nodeSelectNode = createElement(document, node, strRemoveNamespace);
                }
                node = nodeSelectNode;
            }
            i5++;
        }
        return node;
    }

    private int indexOfElementInComplexType(String str, String str2, String str3, Node node) {
        if (node == null) {
            return 0;
        }
        String strRemoveNamespace = removeNamespace(str2);
        int andStoreIndex = getAndStoreIndex(str, strRemoveNamespace);
        String strRemoveNamespace2 = removeNamespace(str3);
        int andStoreIndex2 = getAndStoreIndex(str, strRemoveNamespace2);
        int i5 = 0;
        for (Node firstChild = node.getFirstChild(); firstChild != null && (andStoreIndex2 == -1 || andStoreIndex == -1); firstChild = firstChild.getNextSibling()) {
            if ((firstChild instanceof Element) && "element".equals(firstChild.getLocalName())) {
                String nodeValue = getNameOrRefElement(firstChild).getNodeValue();
                if (nodeValue.equals(strRemoveNamespace)) {
                    this.indexMap.put(a.o(str, PackagingURIHelper.FORWARD_SLASH_STRING, strRemoveNamespace), Integer.valueOf(i5));
                    andStoreIndex = i5;
                }
                if (nodeValue.equals(strRemoveNamespace2)) {
                    this.indexMap.put(a.o(str, PackagingURIHelper.FORWARD_SLASH_STRING, strRemoveNamespace2), Integer.valueOf(i5));
                    andStoreIndex2 = i5;
                }
            }
            i5++;
        }
        if (andStoreIndex == -1 || andStoreIndex2 == -1) {
            return 0;
        }
        return Integer.compare(andStoreIndex, andStoreIndex2);
    }

    private boolean isNamespaceDeclared() {
        String namespace = getNamespace();
        return (namespace == null || namespace.isEmpty()) ? false : true;
    }

    private boolean isValid(Document document) throws SAXException {
        try {
            XMLHelper.getSchemaFactory().newSchema(new DOMSource(this.map.getSchema())).newValidator().validate(new DOMSource(document));
            return true;
        } catch (IOException e) {
            LOG.atError().withThrowable(e).log("document is not valid");
            return false;
        }
    }

    private void mapCellOnNode(XSSFCell xSSFCell, Node node) {
        String stringCellValue;
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[xSSFCell.getCellType().ordinal()];
        if (i5 != 1) {
            stringCellValue = "";
            if (i5 == 2) {
                stringCellValue = "" + xSSFCell.getBooleanCellValue();
            } else if (i5 == 3) {
                stringCellValue = xSSFCell.getErrorCellString();
            } else if (i5 != 4) {
                if (i5 == 5) {
                    if (DateUtil.isCellDateFormatted(xSSFCell)) {
                        stringCellValue = getFormattedDate(xSSFCell);
                    } else {
                        stringCellValue = "" + xSSFCell.getRawValue();
                    }
                }
            } else if (xSSFCell.getCachedFormulaResultType() == CellType.STRING) {
                stringCellValue = xSSFCell.getStringCellValue();
            } else if (xSSFCell.getCachedFormulaResultType() == CellType.BOOLEAN) {
                stringCellValue = "" + xSSFCell.getBooleanCellValue();
            } else if (xSSFCell.getCachedFormulaResultType() == CellType.ERROR) {
                stringCellValue = xSSFCell.getErrorCellString();
            } else if (xSSFCell.getCachedFormulaResultType() == CellType.NUMERIC) {
                if (DateUtil.isCellDateFormatted(xSSFCell)) {
                    stringCellValue = getFormattedDate(xSSFCell);
                } else {
                    stringCellValue = "" + xSSFCell.getNumericCellValue();
                }
            }
        } else {
            stringCellValue = xSSFCell.getStringCellValue();
        }
        if (node instanceof Element) {
            ((Element) node).setTextContent(stringCellValue);
        } else {
            node.setNodeValue(stringCellValue);
        }
    }

    private String removeNamespace(String str) {
        return str.matches(".*:.*") ? str.split(ParameterizedMessage.ERROR_MSG_SEPARATOR)[1] : str;
    }

    private Node selectNode(String str, NodeList nodeList) {
        for (int i5 = 0; i5 < nodeList.getLength(); i5++) {
            Node nodeItem = nodeList.item(i5);
            if (nodeItem.getNodeName().equals(str)) {
                return nodeItem;
            }
        }
        return null;
    }

    private static void trySet(String str, SecurityFeature securityFeature) {
        try {
            securityFeature.accept(str);
        } catch (AbstractMethodError e) {
            LOG.atWarn().withThrowable(e).log("Cannot set SchemaFactory feature ({}) because outdated XML parser in classpath", str);
        } catch (Exception e6) {
            LOG.atWarn().withThrowable(e6).log("SchemaFactory feature ({}) unsupported", str);
        }
    }

    public void exportToXML(OutputStream outputStream, boolean z6) throws TransformerException {
        exportToXML(outputStream, "UTF-8", z6);
    }

    @Override // java.util.Comparator
    public int compare(String str, String str2) {
        Node schema = this.map.getSchema();
        String[] strArrSplit = str.split(PackagingURIHelper.FORWARD_SLASH_STRING);
        String[] strArrSplit2 = str2.split(PackagingURIHelper.FORWARD_SLASH_STRING);
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        String strO = "";
        Node complexTypeForElement = schema;
        for (int i5 = 1; i5 < iMin; i5++) {
            String str3 = strArrSplit[i5];
            String str4 = strArrSplit2[i5];
            if (!str3.equals(str4)) {
                return indexOfElementInComplexType(strO, str3, str4, complexTypeForElement);
            }
            strO = a.o(strO, PackagingURIHelper.FORWARD_SLASH_STRING, str3);
            complexTypeForElement = getComplexTypeForElement(str3, schema, complexTypeForElement);
        }
        return 0;
    }

    public void exportToXML(OutputStream outputStream, String str, boolean z6) throws TransformerException {
        XSSFXmlColumnPr xmlColumnPr;
        XSSFCell referencedCell;
        List<XSSFSingleXmlCell> relatedSingleXMLCell = this.map.getRelatedSingleXMLCell();
        List<XSSFTable> relatedTables = this.map.getRelatedTables();
        String rootElement = this.map.getCtMap().getRootElement();
        Document documentCreateDocument = DocumentHelper.createDocument();
        documentCreateDocument.appendChild(isNamespaceDeclared() ? documentCreateDocument.createElementNS(getNamespace(), rootElement) : documentCreateDocument.createElementNS("", rootElement));
        Vector vector = new Vector();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        for (XSSFSingleXmlCell xSSFSingleXmlCell : relatedSingleXMLCell) {
            vector.add(xSSFSingleXmlCell.getXpath());
            map.put(xSSFSingleXmlCell.getXpath(), xSSFSingleXmlCell);
        }
        for (XSSFTable xSSFTable : relatedTables) {
            String commonXpath = xSSFTable.getCommonXpath();
            vector.add(commonXpath);
            map2.put(commonXpath, xSSFTable);
        }
        this.indexMap.clear();
        vector.sort(this);
        this.indexMap.clear();
        Iterator it = vector.iterator();
        while (true) {
            boolean z7 = true;
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            XSSFSingleXmlCell xSSFSingleXmlCell2 = (XSSFSingleXmlCell) map.get(str2);
            XSSFTable xSSFTable2 = (XSSFTable) map2.get(str2);
            if (!str2.matches(".*\\[.*")) {
                if (xSSFSingleXmlCell2 != null && (referencedCell = xSSFSingleXmlCell2.getReferencedCell()) != null) {
                    Node nodeByXPath = getNodeByXPath(str2, documentCreateDocument.getFirstChild(), documentCreateDocument, false);
                    mapCellOnNode(referencedCell, nodeByXPath);
                    if ("".equals(nodeByXPath.getTextContent()) && nodeByXPath.getParentNode() != null) {
                        nodeByXPath.getParentNode().removeChild(nodeByXPath);
                    }
                }
                if (xSSFTable2 != null) {
                    List<XSSFTableColumn> columns = xSSFTable2.getColumns();
                    XSSFSheet xSSFSheet = xSSFTable2.getXSSFSheet();
                    int headerRowCount = xSSFTable2.getHeaderRowCount() + xSSFTable2.getStartCellReference().getRow();
                    int row = xSSFTable2.getEndCellReference().getRow();
                    while (headerRowCount <= row) {
                        XSSFRow row2 = xSSFSheet.getRow(headerRowCount);
                        Node nodeByXPath2 = getNodeByXPath(xSSFTable2.getCommonXpath(), documentCreateDocument.getFirstChild(), documentCreateDocument, z7);
                        short col = xSSFTable2.getStartCellReference().getCol();
                        for (XSSFTableColumn xSSFTableColumn : columns) {
                            XSSFCell cell = row2.getCell(xSSFTableColumn.getColumnIndex() + col);
                            if (cell != null && (xmlColumnPr = xSSFTableColumn.getXmlColumnPr()) != null) {
                                mapCellOnNode(cell, getNodeByXPath(xmlColumnPr.getLocalXPath(), nodeByXPath2, documentCreateDocument, false));
                            }
                            it = it;
                        }
                        headerRowCount++;
                        z7 = true;
                    }
                }
            }
            it = it;
        }
        if (z6 ? isValid(documentCreateDocument) : true) {
            Transformer transformerNewTransformer = XMLHelper.newTransformer();
            transformerNewTransformer.setOutputProperty("omit-xml-declaration", "yes");
            transformerNewTransformer.setOutputProperty("indent", "yes");
            transformerNewTransformer.setOutputProperty("encoding", str);
            transformerNewTransformer.transform(new DOMSource(documentCreateDocument), new StreamResult(outputStream));
        }
    }
}
