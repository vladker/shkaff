package org.apache.poi.xssf.usermodel;

import A3.AbstractC0157z;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Spliterator;
import java.util.regex.Pattern;
import javax.xml.namespace.QName;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hpsf.ClassIDPredefined;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.ooxml.util.PackageHelper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.Ole10Native;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.formula.udf.AggregatingUDFFinder;
import org.apache.poi.ss.formula.udf.IndexedUDFFinder;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.CellReferenceType;
import org.apache.poi.ss.usermodel.Date1904Support;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetVisibility;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.NotImplemented;
import org.apache.poi.util.Removal;
import org.apache.poi.xssf.XLSBUnsupportedException;
import org.apache.poi.xssf.model.CalculationChain;
import org.apache.poi.xssf.model.ExternalLinksTable;
import org.apache.poi.xssf.model.MapInfo;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.model.ThemesTable;
import org.apache.poi.xssf.usermodel.helpers.XSSFFormulaUtils;
import org.apache.poi.xssf.usermodel.helpers.XSSFPasswordHelper;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.opencv.videoio.Videoio;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReference;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCache;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCalcMode;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STRefMode;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSheetState;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFWorkbook extends POIXMLDocument implements Workbook, Date1904Support {
    private static final Pattern COMMA_PATTERN = Pattern.compile(",");
    private static final Pattern GET_ALL_PICTURES_PATTERN = Pattern.compile("/xl/media/.*?");
    private static final Logger LOG = LogManager.getLogger((Class<?>) XSSFWorkbook.class);
    public static final int PICTURE_TYPE_BMP = 11;
    public static final int PICTURE_TYPE_EPS = 10;
    public static final int PICTURE_TYPE_GIF = 8;
    public static final int PICTURE_TYPE_TIFF = 9;
    public static final int PICTURE_TYPE_WPG = 12;
    private XSSFCreationHelper _creationHelper;
    private Row.MissingCellPolicy _missingCellPolicy;
    private final IndexedUDFFinder _udfFinder;
    private CalculationChain calcChain;
    private boolean cellFormulaValidation;
    private List<ExternalLinksTable> externalLinks;
    private XSSFDataFormat formatter;
    private MapInfo mapInfo;
    private List<XSSFName> namedRanges;
    private ListValuedMap<String, XSSFName> namedRangesByName;
    private List<XSSFPictureData> pictures;
    private List<CTPivotCache> pivotCaches;
    private List<XSSFPivotTable> pivotTables;
    private SharedStringsTable sharedStringSource;
    private List<XSSFSheet> sheets;
    private StylesTable stylesSource;
    private CTWorkbook workbook;
    private final XSSFFactory xssfFactory;

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.XSSFWorkbook$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$SheetVisibility;

        static {
            int[] iArr = new int[SheetVisibility.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$SheetVisibility = iArr;
            try {
                iArr[SheetVisibility.VISIBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$SheetVisibility[SheetVisibility.HIDDEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$SheetVisibility[SheetVisibility.VERY_HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class SheetIterator<T extends Sheet> implements Iterator<T> {
        private final Iterator<T> it;

        public SheetIterator() {
            this.it = XSSFWorkbook.this.sheets.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.it.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove method not supported on XSSFWorkbook.iterator(). Use Sheet.removeSheetAt(int) instead.");
        }

        @Override // java.util.Iterator
        public T next() {
            return this.it.next();
        }
    }

    public XSSFWorkbook() {
        this(XSSFWorkbookType.XLSX);
    }

    private static boolean addRelation(POIXMLDocumentPart.RelationPart relationPart, POIXMLDocumentPart pOIXMLDocumentPart) {
        PackageRelationship relationship = relationPart.getRelationship();
        if (relationship.getTargetMode() == TargetMode.EXTERNAL) {
            pOIXMLDocumentPart.getPackagePart().addRelationship(relationship.getTargetURI(), relationship.getTargetMode(), relationship.getRelationshipType(), relationship.getId());
            return true;
        }
        XSSFRelation xSSFRelation = XSSFRelation.getInstance(relationship.getRelationshipType());
        if (xSSFRelation == null) {
            LOG.atWarn().log("Can't clone sheet relationship (some data will be lost in the cloned sheet) - unknown relation type found: {}", relationship.getRelationshipType());
            return false;
        }
        pOIXMLDocumentPart.addRelation(relationship.getId(), xSSFRelation, relationPart.getDocumentPart());
        return true;
    }

    private CTSheet addSheet(String str) {
        CTSheet cTSheetAddNewSheet = this.workbook.getSheets().addNewSheet();
        cTSheetAddNewSheet.setName(str);
        return cTSheetAddNewSheet;
    }

    private boolean containsSheet(String str, int i5) {
        CTSheet[] sheetArray = this.workbook.getSheets().getSheetArray();
        if (str.length() > 31) {
            str = str.substring(0, 31);
        }
        for (int i6 = 0; i6 < sheetArray.length; i6++) {
            String name = sheetArray[i6].getName();
            if (name.length() > 31) {
                name = name.substring(0, 31);
            }
            if (i5 != i6 && str.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    private XSSFName createAndStoreName(CTDefinedName cTDefinedName) {
        XSSFName xSSFName = new XSSFName(cTDefinedName, this);
        this.namedRanges.add(xSSFName);
        this.namedRangesByName.put(cTDefinedName.getName().toLowerCase(Locale.ENGLISH), xSSFName);
        return xSSFName;
    }

    private static String getReferencePrintArea(String str, int i5, int i6, int i7, int i8) {
        CellReference cellReference = new CellReference(str, i7, i5, true, true);
        CellReference cellReference2 = new CellReference(str, i8, i6, true, true);
        return "$" + cellReference.getCellRefParts()[2] + "$" + cellReference.getCellRefParts()[1] + ":$" + cellReference2.getCellRefParts()[2] + "$" + cellReference2.getCellRefParts()[1];
    }

    private String getUniqueSheetName(String str) {
        int i5;
        String strR;
        int iLastIndexOf = str.lastIndexOf(40);
        if (iLastIndexOf <= 0 || !str.endsWith(")")) {
            i5 = 2;
        } else {
            try {
                i5 = Integer.parseInt(androidx.collection.a.g(1, iLastIndexOf + 1, str).trim()) + 1;
                try {
                    str = str.substring(0, iLastIndexOf).trim();
                } catch (NumberFormatException unused) {
                }
            } catch (NumberFormatException unused2) {
                i5 = 2;
            }
        }
        while (true) {
            int i6 = i5 + 1;
            String string = Integer.toString(i5);
            if (string.length() + str.length() + 2 < 31) {
                strR = androidx.exifinterface.media.a.A(str, " (", string, ")");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(str.substring(0, 29 - string.length()));
                strR = androidx.exifinterface.media.a.r(sb, "(", string, ")");
            }
            if (getSheetIndex(strR) == -1) {
                return strR;
            }
            i5 = i6;
        }
    }

    public static OPCPackage newPackage(XSSFWorkbookType xSSFWorkbookType) {
        OPCPackage oPCPackageCreate = null;
        try {
            oPCPackageCreate = OPCPackage.create(new UnsynchronizedByteArrayOutputStream());
            PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName(XSSFRelation.WORKBOOK.getDefaultFileName());
            oPCPackageCreate.addRelationship(packagePartNameCreatePartName, TargetMode.INTERNAL, PackageRelationshipTypes.CORE_DOCUMENT);
            oPCPackageCreate.createPart(packagePartNameCreatePartName, xSSFWorkbookType.getContentType());
            oPCPackageCreate.getPackageProperties().setCreatorProperty(POIXMLDocument.DOCUMENT_CREATOR);
            return oPCPackageCreate;
        } catch (Exception e) {
            IOUtils.closeQuietly(oPCPackageCreate);
            throw new POIXMLException(e);
        }
    }

    private void onSheetDelete(int i5) {
        getSheetAt(i5).onSheetDelete();
        this.workbook.getSheets().removeSheet(i5);
        CalculationChain calculationChain = this.calcChain;
        if (calculationChain != null) {
            removeRelation(calculationChain);
            this.calcChain = null;
        }
        ArrayList arrayList = new ArrayList();
        for (XSSFName xSSFName : this.namedRanges) {
            CTDefinedName cTName = xSSFName.getCTName();
            if (cTName.isSetLocalSheetId()) {
                long j6 = i5;
                if (cTName.getLocalSheetId() == j6) {
                    arrayList.add(xSSFName);
                } else if (cTName.getLocalSheetId() > j6) {
                    cTName.setLocalSheetId(cTName.getLocalSheetId() - 1);
                }
            }
        }
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            removeName((XSSFName) obj);
        }
    }

    private void onWorkbookCreate() {
        CTWorkbook cTWorkbookNewInstance = CTWorkbook.Factory.newInstance();
        this.workbook = cTWorkbookNewInstance;
        cTWorkbookNewInstance.addNewWorkbookPr().setDate1904(false);
        setBookViewsIfMissing();
        this.workbook.addNewSheets();
        getProperties().getExtendedProperties().getUnderlyingProperties().setApplication(POIXMLDocument.DOCUMENT_CREATOR);
        this.sharedStringSource = (SharedStringsTable) createRelationship(XSSFRelation.SHARED_STRINGS, this.xssfFactory);
        StylesTable stylesTable = (StylesTable) createRelationship(XSSFRelation.STYLES, this.xssfFactory);
        this.stylesSource = stylesTable;
        stylesTable.setWorkbook(this);
        this.namedRanges = new ArrayList();
        this.namedRangesByName = new ArrayListValuedHashMap();
        this.sheets = new ArrayList();
        this.pivotTables = new ArrayList();
        this.externalLinks = new ArrayList();
    }

    private void reprocessNamedRanges() {
        this.namedRangesByName = new ArrayListValuedHashMap();
        this.namedRanges = new ArrayList();
        if (this.workbook.isSetDefinedNames()) {
            for (CTDefinedName cTDefinedName : this.workbook.getDefinedNames().getDefinedNameArray()) {
                createAndStoreName(cTDefinedName);
            }
        }
    }

    private CTWorkbookProtection safeGetWorkbookProtection() {
        return !workbookProtectionPresent() ? this.workbook.addNewWorkbookProtection() : this.workbook.getWorkbookProtection();
    }

    private void saveCalculationChain() {
        CalculationChain calculationChain = this.calcChain;
        if (calculationChain == null || calculationChain.getCTCalcChain().sizeOfCArray() != 0) {
            return;
        }
        removeRelation(this.calcChain);
        this.calcChain = null;
    }

    private void saveNamedRanges() {
        if (this.namedRanges.isEmpty()) {
            if (this.workbook.isSetDefinedNames()) {
                this.workbook.unsetDefinedNames();
                return;
            }
            return;
        }
        CTDefinedNames cTDefinedNamesNewInstance = CTDefinedNames.Factory.newInstance();
        CTDefinedName[] cTDefinedNameArr = new CTDefinedName[this.namedRanges.size()];
        Iterator<XSSFName> it = this.namedRanges.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            cTDefinedNameArr[i5] = it.next().getCTName();
            i5++;
        }
        cTDefinedNamesNewInstance.setDefinedNameArray(cTDefinedNameArr);
        if (this.workbook.isSetDefinedNames()) {
            this.workbook.unsetDefinedNames();
        }
        this.workbook.setDefinedNames(cTDefinedNamesNewInstance);
        reprocessNamedRanges();
    }

    private void setBookViewsIfMissing() {
        if (this.workbook.isSetBookViews()) {
            return;
        }
        this.workbook.addNewBookViews().addNewWorkbookView().setActiveTab(0L);
    }

    private void updateActiveSheetAfterSheetReorder(int i5, int i6) {
        int activeSheetIndex = getActiveSheetIndex();
        if (activeSheetIndex == i5) {
            setActiveSheet(i6);
            return;
        }
        if (activeSheetIndex >= i5 || activeSheetIndex >= i6) {
            if (activeSheetIndex <= i5 || activeSheetIndex <= i6) {
                if (i6 > i5) {
                    setActiveSheet(activeSheetIndex - 1);
                } else {
                    setActiveSheet(activeSheetIndex + 1);
                }
            }
        }
    }

    private void updateNamedRangesAfterSheetReorder(int i5, int i6) {
        for (XSSFName xSSFName : this.namedRanges) {
            int sheetIndex = xSSFName.getSheetIndex();
            if (sheetIndex != -1) {
                if (sheetIndex == i5) {
                    xSSFName.setSheetIndex(i6);
                } else if (i6 <= sheetIndex && sheetIndex < i5) {
                    xSSFName.setSheetIndex(sheetIndex + 1);
                } else if (i5 < sheetIndex && sheetIndex <= i6) {
                    xSSFName.setSheetIndex(sheetIndex - 1);
                }
            }
        }
    }

    private void validateSheetIndex(int i5) {
        int size = this.sheets.size() - 1;
        if (i5 < 0 || i5 > size) {
            String strI = androidx.collection.a.i(size, "(0..", ")");
            if (size == -1) {
                strI = "(no sheets)";
            }
            throw new IllegalArgumentException("Sheet index (" + i5 + ") is out of range " + strI);
        }
    }

    private void validateSheetName(String str) {
        if (containsSheet(str, this.sheets.size())) {
            throw new IllegalArgumentException(AbstractC0157z.o("The workbook already contains a sheet named '", str, "'"));
        }
    }

    private boolean workbookProtectionPresent() {
        return this.workbook.isSetWorkbookProtection();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int addOlePackage(byte[] bArr, String str, String str2, String str3) throws IOException {
        XSSFRelation xSSFRelation = XSSFRelation.OLEEMBEDDINGS;
        OPCPackage oPCPackage = getPackage();
        try {
            int unusedPartIndex = oPCPackage.getUnusedPartIndex(xSSFRelation.getDefaultFileName());
            PackagePart packagePartCreatePart = oPCPackage.createPart(PackagingURIHelper.createPartName(xSSFRelation.getFileName(unusedPartIndex)), xSSFRelation.getContentType());
            Ole10Native ole10Native = new Ole10Native(str, str2, str3, bArr);
            UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream(bArr.length + Videoio.CAP_QT);
            try {
                ole10Native.writeOut(unsynchronizedByteArrayOutputStream);
                POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem();
                try {
                    DirectoryNode root = pOIFSFileSystem.getRoot();
                    root.createDocument(Ole10Native.OLE10_NATIVE, unsynchronizedByteArrayOutputStream.toInputStream());
                    root.setStorageClsid(ClassIDPredefined.OLE_V1_PACKAGE.getClassID());
                    OutputStream outputStream = packagePartCreatePart.getOutputStream();
                    try {
                        pOIFSFileSystem.writeFilesystem(outputStream);
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        pOIFSFileSystem.close();
                        unsynchronizedByteArrayOutputStream.close();
                        return unusedPartIndex;
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
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        try {
                            pOIFSFileSystem.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
            } catch (Throwable th7) {
                try {
                    throw th7;
                } catch (Throwable th8) {
                    try {
                        unsynchronizedByteArrayOutputStream.close();
                    } catch (Throwable th9) {
                        th7.addSuppressed(th9);
                    }
                    throw th8;
                }
            }
        } catch (InvalidFormatException e) {
            throw new IOException("ole object name not recognized", e);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int addPicture(byte[] bArr, int i5) {
        int size = getAllPictures().size();
        XSSFPictureData xSSFPictureData = (XSSFPictureData) createRelationship(XSSFPictureData.RELATIONS[i5], this.xssfFactory, size + 1, true).getDocumentPart();
        try {
            OutputStream outputStream = xSSFPictureData.getPackagePart().getOutputStream();
            try {
                outputStream.write(bArr);
                outputStream.close();
                this.pictures.add(xSSFPictureData);
                return size;
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
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    public CTPivotCache addPivotCache(String str) {
        CTWorkbook cTWorkbook = getCTWorkbook();
        CTPivotCache cTPivotCacheAddNewPivotCache = (cTWorkbook.isSetPivotCaches() ? cTWorkbook.getPivotCaches() : cTWorkbook.addNewPivotCaches()).addNewPivotCache();
        cTPivotCacheAddNewPivotCache.setCacheId(getPivotTables().size() + 1);
        cTPivotCacheAddNewPivotCache.setId(str);
        if (this.pivotCaches == null) {
            this.pivotCaches = new ArrayList();
        }
        this.pivotCaches.add(cTPivotCacheAddNewPivotCache);
        return cTPivotCacheAddNewPivotCache;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void addToolPack(UDFFinder uDFFinder) {
        this._udfFinder.add(uDFFinder);
    }

    public void beforeDocumentRead() {
        if (getCorePart().getContentType().equals(XSSFRelation.XLSB_BINARY_WORKBOOK.getContentType())) {
            throw new XLSBUnsupportedException();
        }
        this.pivotTables = new ArrayList();
        this.pivotCaches = new ArrayList();
    }

    @Override // org.apache.poi.ooxml.POIXMLDocument, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } finally {
            IOUtils.closeQuietly(this.sharedStringSource);
        }
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() throws IOException {
        saveNamedRanges();
        saveCalculationChain();
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTWorkbook.type.getName().getNamespaceURI(), "workbook"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            this.workbook.save(outputStream, xmlOptions);
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

    public XSSFName createBuiltInName(String str, int i5) {
        validateSheetIndex(i5);
        CTDefinedName cTDefinedNameAddNewDefinedName = (this.workbook.getDefinedNames() == null ? this.workbook.addNewDefinedNames() : this.workbook.getDefinedNames()).addNewDefinedName();
        cTDefinedNameAddNewDefinedName.setName(str);
        cTDefinedNameAddNewDefinedName.setLocalSheetId(i5);
        if (getBuiltInName(str, i5) == null) {
            return createAndStoreName(cTDefinedNameAddNewDefinedName);
        }
        throw new POIXMLException("Builtin (" + str + ") already exists for sheet (" + i5 + ")");
    }

    public XSSFDialogsheet createDialogsheet(String str, CTDialogsheet cTDialogsheet) {
        return new XSSFDialogsheet(createSheet(str));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getActiveSheetIndex() {
        return (int) this.workbook.getBookViews().getWorkbookViewArray(0).getActiveTab();
    }

    @Override // org.apache.poi.ooxml.POIXMLDocument
    public List<PackagePart> getAllEmbeddedParts() {
        LinkedList linkedList = new LinkedList();
        for (XSSFSheet xSSFSheet : this.sheets) {
            Iterator<PackageRelationship> it = xSSFSheet.getPackagePart().getRelationshipsByType(XSSFRelation.OLEEMBEDDINGS.getRelation()).iterator();
            while (it.hasNext()) {
                linkedList.add(xSSFSheet.getPackagePart().getRelatedPart(it.next()));
            }
            Iterator<PackageRelationship> it2 = xSSFSheet.getPackagePart().getRelationshipsByType(XSSFRelation.PACKEMBEDDINGS.getRelation()).iterator();
            while (it2.hasNext()) {
                linkedList.add(xSSFSheet.getPackagePart().getRelatedPart(it2.next()));
            }
        }
        return linkedList;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<XSSFName> getAllNames() {
        return Collections.unmodifiableList(this.namedRanges);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<XSSFPictureData> getAllPictures() {
        if (this.pictures == null) {
            List<PackagePart> partsByName = getPackage().getPartsByName(GET_ALL_PICTURES_PATTERN);
            this.pictures = new ArrayList(partsByName.size());
            Iterator<PackagePart> it = partsByName.iterator();
            while (it.hasNext()) {
                this.pictures.add(new XSSFPictureData(it.next()));
            }
        }
        return this.pictures;
    }

    public XSSFName getBuiltInName(String str, int i5) {
        for (XSSFName xSSFName : this.namedRangesByName.get(str.toLowerCase(Locale.ENGLISH))) {
            if (xSSFName.getSheetIndex() == i5) {
                return xSSFName;
            }
        }
        return null;
    }

    @Internal
    public CTWorkbook getCTWorkbook() {
        return this.workbook;
    }

    @Internal
    public CalculationChain getCalculationChain() {
        return this.calcChain;
    }

    public boolean getCellFormulaValidation() {
        return this.cellFormulaValidation;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public CellReferenceType getCellReferenceType() {
        CTCalcPr calcPr = getCTWorkbook().getCalcPr();
        if (calcPr == null) {
            return CellReferenceType.UNKNOWN;
        }
        if (calcPr.getRefMode() == STRefMode.R_1_C_1) {
            return CellReferenceType.R1C1;
        }
        return calcPr.getRefMode() == STRefMode.A_1 ? CellReferenceType.A1 : CellReferenceType.UNKNOWN;
    }

    public Collection<XSSFMap> getCustomXMLMappings() {
        MapInfo mapInfo = this.mapInfo;
        return mapInfo == null ? new ArrayList() : mapInfo.getAllXSSFMaps();
    }

    @Internal
    public List<ExternalLinksTable> getExternalLinksTable() {
        return this.externalLinks;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getFirstVisibleTab() {
        return (short) this.workbook.getBookViews().getWorkbookViewArray(0).getFirstSheet();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean getForceFormulaRecalculation() {
        CTCalcPr calcPr = getCTWorkbook().getCalcPr();
        return calcPr != null && calcPr.isSetFullCalcOnLoad() && calcPr.getFullCalcOnLoad();
    }

    @Internal
    public MapInfo getMapInfo() {
        return this.mapInfo;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Row.MissingCellPolicy getMissingCellPolicy() {
        return this._missingCellPolicy;
    }

    @Deprecated
    public XSSFName getNameAt(int i5) {
        int size = this.namedRanges.size();
        if (size < 1) {
            throw new IllegalStateException("There are no defined names in this workbook");
        }
        if (i5 >= 0 && i5 <= size) {
            return this.namedRanges.get(i5);
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Specified name index ", " is outside the allowable range (0..");
        sbT.append(size - 1);
        sbT.append(").");
        throw new IllegalArgumentException(sbT.toString());
    }

    @Deprecated
    public int getNameIndex(String str) {
        XSSFName name = getName(str);
        if (name != null) {
            return this.namedRanges.indexOf(name);
        }
        return -1;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<XSSFName> getNames(String str) {
        return Collections.unmodifiableList(this.namedRangesByName.get(str.toLowerCase(Locale.ENGLISH)));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumCellStyles() {
        return this.stylesSource.getNumCellStyles();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfFonts() {
        return this.stylesSource.getFonts().size();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @Removal(version = "6.0.0")
    @Deprecated
    public int getNumberOfFontsAsInt() {
        return getNumberOfFonts();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfNames() {
        return this.namedRanges.size();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfSheets() {
        return this.sheets.size();
    }

    public List<XSSFPivotTable> getPivotTables() {
        return this.pivotTables;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public String getPrintArea(int i5) {
        XSSFName builtInName = getBuiltInName(XSSFName.BUILTIN_PRINT_AREA, i5);
        if (builtInName == null) {
            return null;
        }
        return builtInName.getRefersToFormula();
    }

    @Internal
    public SharedStringsTable getSharedStringSource() {
        return this.sharedStringSource;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getSheetIndex(String str) {
        Iterator<XSSFSheet> it = this.sheets.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next().getSheetName())) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public String getSheetName(int i5) {
        validateSheetIndex(i5);
        return this.sheets.get(i5).getSheetName();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SheetVisibility getSheetVisibility(int i5) {
        validateSheetIndex(i5);
        STSheetState.Enum state = this.sheets.get(i5).sheet.getState();
        if (state == STSheetState.VISIBLE) {
            return SheetVisibility.VISIBLE;
        }
        if (state == STSheetState.HIDDEN) {
            return SheetVisibility.HIDDEN;
        }
        if (state == STSheetState.VERY_HIDDEN) {
            return SheetVisibility.VERY_HIDDEN;
        }
        throw new IllegalArgumentException("This should never happen");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SpreadsheetVersion getSpreadsheetVersion() {
        return SpreadsheetVersion.EXCEL2007;
    }

    public StylesTable getStylesSource() {
        return this.stylesSource;
    }

    public XSSFTable getTable(String str) {
        List<XSSFSheet> list;
        if (str == null || (list = this.sheets) == null) {
            return null;
        }
        Iterator<XSSFSheet> it = list.iterator();
        while (it.hasNext()) {
            for (XSSFTable xSSFTable : it.next().getTables()) {
                if (str.equalsIgnoreCase(xSSFTable.getName())) {
                    return xSSFTable;
                }
            }
        }
        return null;
    }

    public ThemesTable getTheme() {
        StylesTable stylesTable = this.stylesSource;
        if (stylesTable == null) {
            return null;
        }
        return stylesTable.getTheme();
    }

    public UDFFinder getUDFFinder() {
        return this._udfFinder;
    }

    public XSSFWorkbookType getWorkbookType() {
        return isMacroEnabled() ? XSSFWorkbookType.XLSM : XSSFWorkbookType.XLSX;
    }

    public XSSFFactory getXssfFactory() {
        return this.xssfFactory;
    }

    @Override // org.apache.poi.ss.usermodel.Date1904Support
    @Internal
    public boolean isDate1904() {
        CTWorkbookPr workbookPr = this.workbook.getWorkbookPr();
        return workbookPr != null && workbookPr.getDate1904();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @NotImplemented
    public boolean isHidden() {
        throw new RuntimeException("Not implemented yet");
    }

    public boolean isMacroEnabled() {
        return getPackagePart().getContentType().equals(XSSFRelation.MACROS_WORKBOOK.getContentType());
    }

    public boolean isRevisionLocked() {
        return workbookProtectionPresent() && this.workbook.getWorkbookProtection().getLockRevision();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isSheetHidden(int i5) {
        validateSheetIndex(i5);
        return this.sheets.get(i5).sheet.getState() == STSheetState.HIDDEN;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isSheetVeryHidden(int i5) {
        validateSheetIndex(i5);
        return this.sheets.get(i5).sheet.getState() == STSheetState.VERY_HIDDEN;
    }

    public boolean isStructureLocked() {
        return workbookProtectionPresent() && this.workbook.getWorkbookProtection().getLockStructure();
    }

    public boolean isWindowsLocked() {
        return workbookProtectionPresent() && this.workbook.getWorkbookProtection().getLockWindows();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook, java.lang.Iterable
    public Iterator<Sheet> iterator() {
        return sheetIterator();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int linkExternalWorkbook(String str, Workbook workbook) {
        int nextPartNumber;
        if (getCreationHelper().getReferencedWorkbooks().containsKey(str)) {
            for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
                if ((relationPart.getDocumentPart() instanceof ExternalLinksTable) && ((ExternalLinksTable) relationPart.getDocumentPart()).getLinkedFileName().equals(str)) {
                    String string = relationPart.getRelationship().getTargetURI().toString();
                    String defaultFileName = XSSFRelation.EXTERNAL_LINKS.getDefaultFileName();
                    nextPartNumber = Integer.parseInt(string.substring(defaultFileName.indexOf(35), defaultFileName.indexOf(46)));
                }
            }
            nextPartNumber = -1;
        } else {
            XSSFRelation xSSFRelation = XSSFRelation.EXTERNAL_LINKS;
            nextPartNumber = getNextPartNumber(xSSFRelation, getPackagePart().getPackage().getPartsByContentType(xSSFRelation.getContentType()).size() + 1);
            POIXMLDocumentPart.RelationPart relationPartCreateRelationship = createRelationship(xSSFRelation, this.xssfFactory, nextPartNumber, false);
            ExternalLinksTable externalLinksTable = (ExternalLinksTable) relationPartCreateRelationship.getDocumentPart();
            externalLinksTable.setLinkedFileName(str);
            getExternalLinksTable().add(externalLinksTable);
            getCTWorkbook().addNewExternalReferences().addNewExternalReference().setId(relationPartCreateRelationship.getRelationship().getId());
        }
        getCreationHelper().addExternalWorkbook(str, workbook);
        return nextPartNumber;
    }

    public void lockRevision() {
        safeGetWorkbookProtection().setLockRevision(true);
    }

    public void lockStructure() {
        safeGetWorkbookProtection().setLockStructure(true);
    }

    public void lockWindows() {
        safeGetWorkbookProtection().setLockWindows(true);
    }

    public void onDeleteFormula(XSSFCell xSSFCell) {
        if (this.calcChain != null) {
            this.calcChain.removeItem((int) xSSFCell.getSheet().sheet.getSheetId(), xSSFCell.getReference());
        }
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() throws IOException {
        try {
            InputStream inputStream = getPackagePart().getInputStream();
            try {
                this.workbook = WorkbookDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getWorkbook();
                if (inputStream != null) {
                    inputStream.close();
                }
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                ThemesTable themesTable = null;
                for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
                    POIXMLDocumentPart documentPart = relationPart.getDocumentPart();
                    if (documentPart instanceof SharedStringsTable) {
                        this.sharedStringSource = (SharedStringsTable) documentPart;
                    } else if (documentPart instanceof StylesTable) {
                        this.stylesSource = (StylesTable) documentPart;
                    } else if (documentPart instanceof ThemesTable) {
                        themesTable = (ThemesTable) documentPart;
                    } else if (documentPart instanceof CalculationChain) {
                        this.calcChain = (CalculationChain) documentPart;
                    } else if (documentPart instanceof MapInfo) {
                        this.mapInfo = (MapInfo) documentPart;
                    } else if (documentPart instanceof XSSFSheet) {
                        map.put(relationPart.getRelationship().getId(), (XSSFSheet) documentPart);
                    } else if (documentPart instanceof ExternalLinksTable) {
                        map2.put(relationPart.getRelationship().getId(), (ExternalLinksTable) documentPart);
                    }
                }
                boolean z6 = getPackage().getPackageAccess() == PackageAccess.READ;
                if (this.stylesSource == null) {
                    if (z6) {
                        this.stylesSource = new StylesTable();
                    } else {
                        this.stylesSource = (StylesTable) createRelationship(XSSFRelation.STYLES, this.xssfFactory);
                    }
                }
                this.stylesSource.setWorkbook(this);
                this.stylesSource.setTheme(themesTable);
                if (this.sharedStringSource == null) {
                    if (z6) {
                        this.sharedStringSource = new SharedStringsTable();
                    } else {
                        this.sharedStringSource = (SharedStringsTable) createRelationship(XSSFRelation.SHARED_STRINGS, this.xssfFactory);
                    }
                }
                this.sheets = new ArrayList(map.size());
                CTWorkbook cTWorkbook = this.workbook;
                if (cTWorkbook == null || cTWorkbook.getSheets() == null || this.workbook.getSheets().getSheetArray() == null) {
                    throw new POIXMLException("Cannot read a workbook without sheets");
                }
                for (CTSheet cTSheet : this.workbook.getSheets().getSheetArray()) {
                    parseSheet(map, cTSheet);
                }
                this.externalLinks = new ArrayList(map2.size());
                if (this.workbook.isSetExternalReferences()) {
                    for (CTExternalReference cTExternalReference : this.workbook.getExternalReferences().getExternalReferenceArray()) {
                        ExternalLinksTable externalLinksTable = (ExternalLinksTable) map2.get(cTExternalReference.getId());
                        if (externalLinksTable == null) {
                            LOG.atWarn().log("ExternalLinksTable with r:id {} was defined, but didn't exist in package, skipping", cTExternalReference.getId());
                        } else {
                            this.externalLinks.add(externalLinksTable);
                        }
                    }
                }
                reprocessNamedRanges();
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
        } catch (XmlException e) {
            throw new POIXMLException(e);
        }
    }

    public void parseSheet(Map<String, XSSFSheet> map, CTSheet cTSheet) {
        XSSFSheet xSSFSheet = map.get(cTSheet.getId());
        if (xSSFSheet == null) {
            LOG.atWarn().log("Sheet with name {} and r:id {} was defined, but didn't exist in package, skipping", cTSheet.getName(), cTSheet.getId());
            return;
        }
        xSSFSheet.sheet = cTSheet;
        xSSFSheet.onDocumentRead();
        this.sheets.add(xSSFSheet);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeName(Name name) {
        if (this.namedRangesByName.removeMapping(name.getNameName().toLowerCase(Locale.ENGLISH), name) && this.namedRanges.remove(name)) {
            return;
        }
        throw new IllegalArgumentException("Name was not found: " + name);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removePrintArea(int i5) {
        XSSFName builtInName = getBuiltInName(XSSFName.BUILTIN_PRINT_AREA, i5);
        if (builtInName != null) {
            removeName(builtInName);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeSheetAt(int i5) {
        validateSheetIndex(i5);
        onSheetDelete(i5);
        removeRelation(getSheetAt(i5));
        this.sheets.remove(i5);
        if (this.sheets.isEmpty()) {
            return;
        }
        int size = i5 >= this.sheets.size() ? this.sheets.size() - 1 : i5;
        int activeSheetIndex = getActiveSheetIndex();
        if (activeSheetIndex == i5) {
            setActiveSheet(size);
        } else if (activeSheetIndex > i5) {
            setActiveSheet(activeSheetIndex - 1);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setActiveSheet(int i5) {
        validateSheetIndex(i5);
        for (CTBookView cTBookView : this.workbook.getBookViews().getWorkbookViewArray()) {
            cTBookView.setActiveTab(i5);
        }
    }

    public void setCellFormulaValidation(boolean z6) {
        this.cellFormulaValidation = z6;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setCellReferenceType(CellReferenceType cellReferenceType) {
        CTCalcPr calcPr = getCTWorkbook().getCalcPr();
        if (cellReferenceType == CellReferenceType.UNKNOWN) {
            if (calcPr != null) {
                calcPr.unsetRefMode();
            }
        } else {
            if (calcPr == null) {
                calcPr = getCTWorkbook().addNewCalcPr();
            }
            calcPr.setRefMode(cellReferenceType == CellReferenceType.R1C1 ? STRefMode.R_1_C_1 : STRefMode.A_1);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setFirstVisibleTab(int i5) {
        this.workbook.getBookViews().getWorkbookViewArray(0).setFirstSheet(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setForceFormulaRecalculation(boolean z6) {
        CTWorkbook cTWorkbook = getCTWorkbook();
        CTCalcPr calcPr = cTWorkbook.isSetCalcPr() ? cTWorkbook.getCalcPr() : cTWorkbook.addNewCalcPr();
        calcPr.setFullCalcOnLoad(z6);
        if (z6 && calcPr.getCalcMode() == STCalcMode.MANUAL) {
            calcPr.setCalcMode(STCalcMode.AUTO);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @NotImplemented
    public void setHidden(boolean z6) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setMissingCellPolicy(Row.MissingCellPolicy missingCellPolicy) {
        this._missingCellPolicy = missingCellPolicy;
    }

    public void setPivotTables(List<XSSFPivotTable> list) {
        this.pivotTables = list;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setPrintArea(int i5, String str) {
        XSSFName builtInName = getBuiltInName(XSSFName.BUILTIN_PRINT_AREA, i5);
        if (builtInName == null) {
            builtInName = createBuiltInName(XSSFName.BUILTIN_PRINT_AREA, i5);
        }
        String[] strArrSplit = COMMA_PATTERN.split(str);
        StringBuilder sb = new StringBuilder(32);
        for (int i6 = 0; i6 < strArrSplit.length; i6++) {
            if (i6 > 0) {
                sb.append(',');
            }
            SheetNameFormatter.appendFormat(sb, getSheetName(i5));
            sb.append('!');
            sb.append(strArrSplit[i6]);
        }
        builtInName.setRefersToFormula(sb.toString());
    }

    public void setRevisionsPassword(String str, HashAlgorithm hashAlgorithm) {
        if (str != null || workbookProtectionPresent()) {
            XSSFPasswordHelper.setPassword(safeGetWorkbookProtection(), str, hashAlgorithm, "revisions");
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSelectedTab(int i5) {
        Iterator<XSSFSheet> it = this.sheets.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            it.next().setSelected(i6 == i5);
            i6++;
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetHidden(int i5, boolean z6) {
        setSheetVisibility(i5, z6 ? SheetVisibility.HIDDEN : SheetVisibility.VISIBLE);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetName(int i5, String str) {
        if (str == null) {
            throw new IllegalArgumentException("sheetName must not be null");
        }
        validateSheetIndex(i5);
        String sheetName = getSheetName(i5);
        if (str.length() > 31) {
            str = str.substring(0, 31);
        }
        WorkbookUtil.validateSheetName(str);
        if (str.equals(sheetName)) {
            return;
        }
        if (containsSheet(str, i5)) {
            throw new IllegalArgumentException("The workbook already contains a sheet of this name");
        }
        new XSSFFormulaUtils(this).updateSheetName(i5, sheetName, str);
        this.workbook.getSheets().getSheetArray(i5).setName(str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetOrder(String str, int i5) {
        int sheetIndex = getSheetIndex(str);
        List<XSSFSheet> list = this.sheets;
        list.add(i5, list.remove(sheetIndex));
        CTSheets sheets = this.workbook.getSheets();
        XmlObject xmlObjectCopy = sheets.getSheetArray(sheetIndex).copy();
        this.workbook.getSheets().removeSheet(sheetIndex);
        sheets.insertNewSheet(i5).set(xmlObjectCopy);
        CTSheet[] sheetArray = sheets.getSheetArray();
        for (int i6 = 0; i6 < sheetArray.length; i6++) {
            this.sheets.get(i6).sheet = sheetArray[i6];
        }
        updateNamedRangesAfterSheetReorder(sheetIndex, i5);
        updateActiveSheetAfterSheetReorder(sheetIndex, i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetVisibility(int i5, SheetVisibility sheetVisibility) {
        validateSheetIndex(i5);
        CTSheet cTSheet = this.sheets.get(i5).sheet;
        int i6 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$SheetVisibility[sheetVisibility.ordinal()];
        if (i6 == 1) {
            cTSheet.setState(STSheetState.VISIBLE);
        } else if (i6 == 2) {
            cTSheet.setState(STSheetState.HIDDEN);
        } else {
            if (i6 != 3) {
                throw new IllegalArgumentException("This should never happen");
            }
            cTSheet.setState(STSheetState.VERY_HIDDEN);
        }
    }

    public void setVBAProject(InputStream inputStream) {
        if (!isMacroEnabled()) {
            setWorkbookType(XSSFWorkbookType.XLSM);
        }
        try {
            XSSFRelation xSSFRelation = XSSFRelation.VBA_MACROS;
            PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName(xSSFRelation.getDefaultFileName());
            OPCPackage oPCPackage = getPackage();
            OutputStream outputStream = !oPCPackage.containPart(packagePartNameCreatePartName) ? createRelationship(xSSFRelation, this.xssfFactory).getPackagePart().getOutputStream() : oPCPackage.getPart(packagePartNameCreatePartName).getOutputStream();
            try {
                IOUtils.copy(inputStream, outputStream);
            } finally {
                IOUtils.closeQuietly(outputStream);
            }
        } catch (InvalidFormatException e) {
            throw new POIXMLException(e);
        }
    }

    public void setWorkbookPassword(String str, HashAlgorithm hashAlgorithm) {
        if (str != null || workbookProtectionPresent()) {
            XSSFPasswordHelper.setPassword(safeGetWorkbookProtection(), str, hashAlgorithm, "workbook");
        }
    }

    public void setWorkbookType(XSSFWorkbookType xSSFWorkbookType) {
        try {
            getPackagePart().setContentType(xSSFWorkbookType.getContentType());
        } catch (InvalidFormatException e) {
            throw new POIXMLException(e);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Iterator<Sheet> sheetIterator() {
        return new SheetIterator();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook, java.lang.Iterable
    public Spliterator<Sheet> spliterator() {
        return this.sheets.spliterator();
    }

    public void unLock() {
        if (workbookProtectionPresent()) {
            this.workbook.unsetWorkbookProtection();
        }
    }

    public void unLockRevision() {
        safeGetWorkbookProtection().setLockRevision(false);
    }

    public void unLockStructure() {
        safeGetWorkbookProtection().setLockStructure(false);
    }

    public void unLockWindows() {
        safeGetWorkbookProtection().setLockWindows(false);
    }

    public void updateName(XSSFName xSSFName, String str) {
        ListValuedMap<String, XSSFName> listValuedMap = this.namedRangesByName;
        Locale locale = Locale.ENGLISH;
        if (listValuedMap.removeMapping(str.toLowerCase(locale), xSSFName)) {
            this.namedRangesByName.put(xSSFName.getNameName().toLowerCase(locale), xSSFName);
        } else {
            throw new IllegalArgumentException("Name was not found: " + xSSFName);
        }
    }

    public boolean validateRevisionsPassword(String str) {
        if (workbookProtectionPresent()) {
            return XSSFPasswordHelper.validatePassword(safeGetWorkbookProtection(), str, "revisions");
        }
        return str == null;
    }

    public boolean validateWorkbookPassword(String str) {
        if (workbookProtectionPresent()) {
            return XSSFPasswordHelper.validatePassword(safeGetWorkbookProtection(), str, "workbook");
        }
        return str == null;
    }

    public XSSFWorkbook(XSSFFactory xSSFFactory) {
        this(XSSFWorkbookType.XLSX, xSSFFactory);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFSheet cloneSheet(int i5) {
        return cloneSheet(i5, null);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFCellStyle createCellStyle() {
        return this.stylesSource.createCellStyle();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFDataFormat createDataFormat() {
        if (this.formatter == null) {
            this.formatter = new XSSFDataFormat(this.stylesSource);
        }
        return this.formatter;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFEvaluationWorkbook createEvaluationWorkbook() {
        return XSSFEvaluationWorkbook.create(this);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFFont createFont() {
        XSSFFont xSSFFont = new XSSFFont();
        xSSFFont.registerTo(this.stylesSource);
        return xSSFFont;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFName createName() {
        CTDefinedName cTDefinedNameNewInstance = CTDefinedName.Factory.newInstance();
        cTDefinedNameNewInstance.setName("");
        return createAndStoreName(cTDefinedNameNewInstance);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFFont findFont(boolean z6, short s6, short s7, String str, boolean z7, boolean z8, short s8, byte b) {
        return this.stylesSource.findFont(z6, s6, s7, str, z7, z8, s8, b);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFCellStyle getCellStyleAt(int i5) {
        return this.stylesSource.getStyleAt(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFCreationHelper getCreationHelper() {
        if (this._creationHelper == null) {
            this._creationHelper = new XSSFCreationHelper(this);
        }
        return this._creationHelper;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFFont getFontAt(int i5) {
        return this.stylesSource.getFontAt(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFName getName(String str) {
        List<XSSFName> names = getNames(str);
        if (names.isEmpty()) {
            return null;
        }
        return names.iterator().next();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFSheet getSheet(String str) {
        for (XSSFSheet xSSFSheet : this.sheets) {
            if (str.equalsIgnoreCase(xSSFSheet.getSheetName())) {
                return xSSFSheet;
            }
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFSheet getSheetAt(int i5) {
        validateSheetIndex(i5);
        return this.sheets.get(i5);
    }

    public XSSFWorkbook(XSSFWorkbookType xSSFWorkbookType) {
        this(xSSFWorkbookType, (XSSFFactory) null);
    }

    public XSSFSheet cloneSheet(int i5, String str) {
        validateSheetIndex(i5);
        XSSFSheet xSSFSheet = this.sheets.get(i5);
        if (str == null) {
            str = getUniqueSheetName(xSSFSheet.getSheetName());
        } else {
            validateSheetName(str);
        }
        XSSFSheet xSSFSheetCreateSheet = createSheet(str);
        XSSFDrawing xSSFDrawing = null;
        for (POIXMLDocumentPart.RelationPart relationPart : xSSFSheet.getRelationParts()) {
            POIXMLDocumentPart documentPart = relationPart.getDocumentPart();
            if (documentPart instanceof XSSFDrawing) {
                xSSFDrawing = (XSSFDrawing) documentPart;
            } else {
                addRelation(relationPart, xSSFSheetCreateSheet);
            }
        }
        try {
            for (PackageRelationship packageRelationship : xSSFSheet.getPackagePart().getRelationships()) {
                if (packageRelationship.getTargetMode() == TargetMode.EXTERNAL) {
                    xSSFSheetCreateSheet.getPackagePart().addExternalRelationship(packageRelationship.getTargetURI().toASCIIString(), packageRelationship.getRelationshipType(), packageRelationship.getId());
                }
            }
            try {
                UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
                try {
                    xSSFSheet.write(unsynchronizedByteArrayOutputStream);
                    InputStream inputStream = unsynchronizedByteArrayOutputStream.toInputStream();
                    try {
                        xSSFSheetCreateSheet.read(inputStream);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        unsynchronizedByteArrayOutputStream.close();
                        CTWorksheet cTWorksheet = xSSFSheetCreateSheet.getCTWorksheet();
                        if (cTWorksheet.isSetLegacyDrawing()) {
                            LOG.atWarn().log("Cloning sheets with comments is not yet supported.");
                            cTWorksheet.unsetLegacyDrawing();
                        }
                        if (cTWorksheet.isSetPageSetup()) {
                            LOG.atWarn().log("Cloning sheets with page setup is not yet supported.");
                            cTWorksheet.unsetPageSetup();
                        }
                        xSSFSheetCreateSheet.setSelected(false);
                        if (xSSFDrawing != null) {
                            if (cTWorksheet.isSetDrawing()) {
                                cTWorksheet.unsetDrawing();
                            }
                            XSSFDrawing xSSFDrawingCreateDrawingPatriarch = xSSFSheetCreateSheet.createDrawingPatriarch();
                            xSSFDrawingCreateDrawingPatriarch.getCTDrawing().set(xSSFDrawing.getCTDrawing().copy());
                            XSSFDrawing drawingPatriarch = xSSFSheet.getDrawingPatriarch();
                            if (drawingPatriarch != null) {
                                for (POIXMLDocumentPart.RelationPart relationPart2 : drawingPatriarch.getRelationParts()) {
                                    POIXMLDocumentPart documentPart2 = relationPart2.getDocumentPart();
                                    if (documentPart2 instanceof XSSFChart) {
                                        XSSFChart xSSFChart = (XSSFChart) xSSFDrawingCreateDrawingPatriarch.createChartRelationPart().getDocumentPart();
                                        xSSFChart.importContent((XSSFChart) documentPart2);
                                        xSSFChart.replaceReferences(xSSFSheetCreateSheet);
                                    } else {
                                        addRelation(relationPart2, xSSFDrawingCreateDrawingPatriarch);
                                    }
                                }
                            }
                        }
                        XSSFSheet.cloneTables(xSSFSheetCreateSheet);
                        return xSSFSheetCreateSheet;
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
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        try {
                            unsynchronizedByteArrayOutputStream.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
            } catch (IOException e) {
                throw new POIXMLException("Failed to clone sheet", e);
            }
        } catch (InvalidFormatException e6) {
            throw new POIXMLException("Failed to clone sheet", e6);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFSheet createSheet() {
        String strK = "Sheet" + this.sheets.size();
        int i5 = 0;
        while (getSheet(strK) != null) {
            strK = AbstractC0157z.k(i5, "Sheet");
            i5++;
        }
        return createSheet(strK);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getSheetIndex(Sheet sheet) {
        Iterator<XSSFSheet> it = this.sheets.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            if (it.next() == sheet) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    private XSSFWorkbook(XSSFWorkbookType xSSFWorkbookType, XSSFFactory xSSFFactory) {
        super(newPackage(xSSFWorkbookType));
        this._udfFinder = new IndexedUDFFinder(AggregatingUDFFinder.DEFAULT);
        this._missingCellPolicy = Row.MissingCellPolicy.RETURN_NULL_AND_BLANK;
        this.cellFormulaValidation = true;
        this.xssfFactory = xSSFFactory == null ? XSSFFactory.getInstance() : xSSFFactory;
        onWorkbookCreate();
    }

    public XSSFWorkbook(OPCPackage oPCPackage) {
        super(oPCPackage);
        this._udfFinder = new IndexedUDFFinder(AggregatingUDFFinder.DEFAULT);
        this._missingCellPolicy = Row.MissingCellPolicy.RETURN_NULL_AND_BLANK;
        this.cellFormulaValidation = true;
        XSSFFactory xSSFFactory = XSSFFactory.getInstance();
        this.xssfFactory = xSSFFactory;
        beforeDocumentRead();
        load(xSSFFactory);
        setBookViewsIfMissing();
    }

    public int addPicture(InputStream inputStream, int i5) throws IOException {
        int size = getAllPictures().size();
        XSSFPictureData xSSFPictureData = (XSSFPictureData) createRelationship(XSSFPictureData.RELATIONS[i5], this.xssfFactory, size + 1, true).getDocumentPart();
        OutputStream outputStream = xSSFPictureData.getPackagePart().getOutputStream();
        try {
            IOUtils.copy(inputStream, outputStream);
            if (outputStream != null) {
                outputStream.close();
            }
            this.pictures.add(xSSFPictureData);
            return size;
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

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFSheet createSheet(String str) {
        if (str != null) {
            validateSheetName(str);
            if (str.length() > 31) {
                String strSubstring = str.substring(0, 31);
                LOG.atWarn().log("Sheet '{}' will be added with a trimmed name '{}' for MS Excel compliance.", str, strSubstring);
                str = strSubstring;
            }
            WorkbookUtil.validateSheetName(str);
            CTSheet cTSheetAddSheet = addSheet(str);
            int iMax = 1;
            loop0: while (true) {
                Iterator<XSSFSheet> it = this.sheets.iterator();
                while (it.hasNext()) {
                    iMax = (int) Math.max(it.next().sheet.getSheetId() + 1, iMax);
                }
                String fileName = XSSFRelation.WORKSHEET.getFileName(iMax);
                Iterator<POIXMLDocumentPart> it2 = getRelations().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break loop0;
                    }
                    POIXMLDocumentPart next = it2.next();
                    if (next.getPackagePart() == null || !fileName.equals(next.getPackagePart().getPartName().getName())) {
                    }
                }
                iMax++;
            }
            POIXMLDocumentPart.RelationPart relationPartCreateRelationship = createRelationship(XSSFRelation.WORKSHEET, this.xssfFactory, iMax, false);
            XSSFSheet xSSFSheet = (XSSFSheet) relationPartCreateRelationship.getDocumentPart();
            xSSFSheet.sheet = cTSheetAddSheet;
            cTSheetAddSheet.setId(relationPartCreateRelationship.getRelationship().getId());
            cTSheetAddSheet.setSheetId(iMax);
            if (this.sheets.isEmpty()) {
                xSSFSheet.setSelected(true);
            }
            this.sheets.add(xSSFSheet);
            return xSSFSheet;
        }
        throw new IllegalArgumentException("sheetName must not be null");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setPrintArea(int i5, int i6, int i7, int i8, int i9) {
        setPrintArea(i5, getReferencePrintArea(getSheetName(i5), i6, i7, i8, i9));
    }

    public void setVBAProject(XSSFWorkbook xSSFWorkbook) {
        InputStream contents;
        if (xSSFWorkbook.isMacroEnabled() && (contents = XSSFRelation.VBA_MACROS.getContents(xSSFWorkbook.getCorePart())) != null) {
            setVBAProject(contents);
        }
    }

    public XSSFWorkbook(InputStream inputStream) {
        this(inputStream, false);
    }

    private XSSFWorkbook(InputStream inputStream, boolean z6) {
        this(PackageHelper.open(inputStream, z6));
    }

    public XSSFWorkbook(File file) {
        this(OPCPackage.open(file));
    }

    public XSSFWorkbook(String str) {
        this(POIXMLDocument.openPackage(str));
    }

    public XSSFWorkbook(PackagePart packagePart) {
        this(packagePart.getInputStream(), true);
    }
}
