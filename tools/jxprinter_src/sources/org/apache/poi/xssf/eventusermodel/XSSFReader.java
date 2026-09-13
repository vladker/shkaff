package org.apache.poi.xssf.eventusermodel;

import A3.AbstractC0157z;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.util.XMLHelper;
import org.apache.poi.xssf.model.Comments;
import org.apache.poi.xssf.model.CommentsTable;
import org.apache.poi.xssf.model.SharedStrings;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.model.ThemesTable;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.xmlbeans.XmlException;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFReader {
    protected OPCPackage pkg;
    protected boolean useReadOnlySharedStringsTable;
    protected PackagePart workbookPart;
    private static final Set<String> WORKSHEET_RELS = Collections.unmodifiableSet(new HashSet(Arrays.asList(XSSFRelation.WORKSHEET.getRelation(), XSSFRelation.CHARTSHEET.getRelation(), XSSFRelation.MACRO_SHEET_BIN.getRelation())));
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) XSSFReader.class);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SheetIterator implements Iterator<InputStream> {
        protected final Iterator<XSSFSheetRef> sheetIterator;
        protected final Map<String, PackagePart> sheetMap;
        protected XSSFSheetRef xssfSheetRef;

        public SheetIterator(PackagePart packagePart) {
            try {
                this.sheetMap = new HashMap();
                OPCPackage oPCPackage = packagePart.getPackage();
                Set<String> sheetRelationships = getSheetRelationships();
                for (PackageRelationship packageRelationship : packagePart.getRelationships()) {
                    if (sheetRelationships.contains(packageRelationship.getRelationshipType())) {
                        this.sheetMap.put(packageRelationship.getId(), oPCPackage.getPart(PackagingURIHelper.createPartName(packageRelationship.getTargetURI())));
                    }
                }
                this.sheetIterator = createSheetIteratorFromWB(packagePart);
            } catch (InvalidFormatException e) {
                throw new POIXMLException(e);
            }
        }

        public Iterator<XSSFSheetRef> createSheetIteratorFromWB(PackagePart packagePart) throws IOException {
            XMLSheetRefReader xMLSheetRefReader = new XMLSheetRefReader();
            try {
                XMLReader xMLReaderNewXMLReader = XMLHelper.newXMLReader();
                xMLReaderNewXMLReader.setContentHandler(xMLSheetRefReader);
                try {
                    InputStream inputStream = packagePart.getInputStream();
                    try {
                        xMLReaderNewXMLReader.parse(new InputSource(inputStream));
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        ArrayList arrayList = new ArrayList();
                        for (XSSFSheetRef xSSFSheetRef : xMLSheetRefReader.getSheetRefs()) {
                            String id = xSSFSheetRef.getId();
                            if (id != null && id.length() > 0) {
                                arrayList.add(xSSFSheetRef);
                            }
                        }
                        return arrayList.iterator();
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
                } catch (SAXException e) {
                    throw new POIXMLException(e);
                }
            } catch (ParserConfigurationException | SAXException e6) {
                throw new POIXMLException(e6);
            }
        }

        public List<XSSFShape> getShapes() {
            PackagePart sheetPart = getSheetPart();
            LinkedList linkedList = new LinkedList();
            try {
                PackageRelationshipCollection relationshipsByType = sheetPart.getRelationshipsByType(XSSFRelation.DRAWINGS.getRelation());
                int size = relationshipsByType.size();
                for (int i5 = 0; i5 < size; i5++) {
                    PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName(relationshipsByType.getRelationship(i5).getTargetURI());
                    PackagePart part = sheetPart.getPackage().getPart(packagePartNameCreatePartName);
                    if (part == null) {
                        XSSFReader.LOGGER.atWarn().log("Missing drawing: {}. Skipping it.", packagePartNameCreatePartName);
                    } else {
                        linkedList.addAll(new XSSFDrawing(part).getShapes());
                    }
                }
                return linkedList;
            } catch (IOException e) {
                e = e;
                XSSFReader.LOGGER.atWarn().withThrowable(e).log("Failed to load shapes");
                return null;
            } catch (InvalidFormatException e6) {
                e = e6;
                XSSFReader.LOGGER.atWarn().withThrowable(e).log("Failed to load shapes");
                return null;
            } catch (XmlException e7) {
                e = e7;
                XSSFReader.LOGGER.atWarn().withThrowable(e).log("Failed to load shapes");
                return null;
            }
        }

        public Comments getSheetComments() {
            PackagePart sheetPart = getSheetPart();
            try {
                PackageRelationshipCollection relationshipsByType = sheetPart.getRelationshipsByType(XSSFRelation.SHEET_COMMENTS.getRelation());
                if (relationshipsByType.isEmpty()) {
                    return null;
                }
                return parseComments(sheetPart.getPackage().getPart(PackagingURIHelper.createPartName(relationshipsByType.getRelationship(0).getTargetURI())));
            } catch (IOException | InvalidFormatException e) {
                XSSFReader.LOGGER.atWarn().withThrowable(e).log("Failed to load sheet comments");
                return null;
            }
        }

        public String getSheetName() {
            return this.xssfSheetRef.getName();
        }

        public PackagePart getSheetPart() {
            return this.sheetMap.get(this.xssfSheetRef.getId());
        }

        public Set<String> getSheetRelationships() {
            return XSSFReader.WORKSHEET_RELS;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.sheetIterator.hasNext();
        }

        public Comments parseComments(PackagePart packagePart) {
            return new CommentsTable(packagePart);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException("Not supported");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public InputStream next() {
            XSSFSheetRef next = this.sheetIterator.next();
            this.xssfSheetRef = next;
            try {
                return this.sheetMap.get(next.getId()).getInputStream();
            } catch (IOException e) {
                throw new POIXMLException(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class XMLSheetRefReader extends DefaultHandler {
        private static final String ID = "id";
        private static final String NAME = "name";
        private static final String SHEET = "sheet";
        private final List<XSSFSheetRef> sheetRefs = new LinkedList();

        public List<XSSFSheetRef> getSheetRefs() {
            return Collections.unmodifiableList(this.sheetRefs);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (str2.equalsIgnoreCase(SHEET)) {
                String value = null;
                String value2 = null;
                for (int i5 = 0; i5 < attributes.getLength(); i5++) {
                    String localName = attributes.getLocalName(i5);
                    if (localName.equalsIgnoreCase("name")) {
                        value = attributes.getValue(i5);
                    } else if (localName.equalsIgnoreCase(ID)) {
                        value2 = attributes.getValue(i5);
                    }
                    if (value != null && value2 != null) {
                        this.sheetRefs.add(new XSSFSheetRef(value2, value));
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class XSSFSheetRef {
        private final String id;
        private final String name;

        public XSSFSheetRef(String str, String str2) {
            this.id = str;
            this.name = str2;
        }

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }
    }

    public XSSFReader(OPCPackage oPCPackage) {
        this(oPCPackage, false);
    }

    public InputStream getSharedStringsData() {
        return XSSFRelation.SHARED_STRINGS.getContents(this.workbookPart);
    }

    public SharedStrings getSharedStringsTable() throws InvalidFormatException {
        ArrayList<PackagePart> partsByContentType = this.pkg.getPartsByContentType(XSSFRelation.SHARED_STRINGS.getContentType());
        try {
            if (partsByContentType.isEmpty()) {
                return null;
            }
            return this.useReadOnlySharedStringsTable ? new ReadOnlySharedStringsTable(partsByContentType.get(0)) : new SharedStringsTable(partsByContentType.get(0));
        } catch (SAXException e) {
            throw new InvalidFormatException("Failed to parse SharedStringsTable", e);
        }
    }

    public InputStream getSheet(String str) {
        PackageRelationship relationship = this.workbookPart.getRelationship(str);
        if (relationship == null) {
            throw new IllegalArgumentException(AbstractC0157z.n("No Sheet found with r:id ", str));
        }
        PackagePart part = this.pkg.getPart(PackagingURIHelper.createPartName(relationship.getTargetURI()));
        if (part != null) {
            return part.getInputStream();
        }
        throw new IllegalArgumentException(AbstractC0157z.n("No data found for Sheet with r:id ", str));
    }

    public Iterator<InputStream> getSheetsData() {
        return new SheetIterator(this.workbookPart);
    }

    public InputStream getStylesData() {
        return XSSFRelation.STYLES.getContents(this.workbookPart);
    }

    public StylesTable getStylesTable() {
        ArrayList<PackagePart> partsByContentType = this.pkg.getPartsByContentType(XSSFRelation.STYLES.getContentType());
        if (partsByContentType.isEmpty()) {
            return null;
        }
        StylesTable stylesTable = new StylesTable(partsByContentType.get(0));
        ArrayList<PackagePart> partsByContentType2 = this.pkg.getPartsByContentType(XSSFRelation.THEME.getContentType());
        if (partsByContentType2.size() != 0) {
            stylesTable.setTheme(new ThemesTable(partsByContentType2.get(0)));
        }
        return stylesTable;
    }

    public InputStream getThemesData() {
        return XSSFRelation.THEME.getContents(this.workbookPart);
    }

    public InputStream getWorkbookData() {
        return this.workbookPart.getInputStream();
    }

    public void setUseReadOnlySharedStringsTable(boolean z6) {
        this.useReadOnlySharedStringsTable = z6;
    }

    public boolean useReadOnlySharedStringsTable() {
        return this.useReadOnlySharedStringsTable;
    }

    public XSSFReader(OPCPackage oPCPackage, boolean z6) {
        this.pkg = oPCPackage;
        PackageRelationship relationship = oPCPackage.getRelationshipsByType(PackageRelationshipTypes.CORE_DOCUMENT).getRelationship(0);
        if (relationship == null) {
            if (z6) {
                relationship = this.pkg.getRelationshipsByType(PackageRelationshipTypes.STRICT_CORE_DOCUMENT).getRelationship(0);
            } else if (this.pkg.getRelationshipsByType(PackageRelationshipTypes.STRICT_CORE_DOCUMENT).getRelationship(0) != null) {
                throw new POIXMLException("Strict OOXML isn't currently supported, please see bug #57699");
            }
            if (relationship == null) {
                throw new POIXMLException("OOXML file structure broken/invalid - no core document found!");
            }
        }
        this.workbookPart = this.pkg.getPart(relationship);
    }
}
