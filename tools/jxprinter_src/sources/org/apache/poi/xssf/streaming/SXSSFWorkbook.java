package org.apache.poi.xssf.streaming;

import androidx.collection.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import org.apache.commons.compress.archivers.zip.Zip64Mode;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.opc.g;
import org.apache.poi.openxml4j.util.ZipArchiveThresholdInputStream;
import org.apache.poi.openxml4j.util.ZipEntrySource;
import org.apache.poi.openxml4j.util.ZipFileZipEntrySource;
import org.apache.poi.openxml4j.util.ZipInputStreamZipEntrySource;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.CellReferenceType;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetVisibility;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.NotImplemented;
import org.apache.poi.util.Removal;
import org.apache.poi.util.TempFile;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFChartSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SXSSFWorkbook implements Workbook {
    public static final int DEFAULT_WINDOW_SIZE = 100;
    private static final Logger LOG = LogManager.getLogger((Class<?>) SXSSFWorkbook.class);
    private boolean _compressTmpFiles;
    private int _randomAccessWindowSize;
    protected final SharedStringsTable _sharedStringSource;
    private final Map<SXSSFSheet, XSSFSheet> _sxFromXHash;
    protected final XSSFWorkbook _wb;
    private final Map<XSSFSheet, SXSSFSheet> _xFromSxHash;
    private boolean shouldCalculateSheetDimensions;
    protected Zip64Mode zip64Mode;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ISheetInjector {
        void writeSheetData(OutputStream outputStream);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class SheetIterator<T extends Sheet> implements Iterator<T> {
        private final Iterator<XSSFSheet> it;

        public SheetIterator() {
            this.it = SXSSFWorkbook.this._wb.iterator();
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
            return SXSSFWorkbook.this.getSXSSFSheet(this.it.next());
        }
    }

    public SXSSFWorkbook() {
        this((XSSFWorkbook) null);
    }

    private static void copyStreamAndInjectWorksheet(InputStream inputStream, OutputStream outputStream, ISheetInjector iSheetInjector) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        int i5 = 10;
        boolean z6 = true;
        int i6 = 0;
        String str = "<sheetData";
        while (true) {
            int i7 = inputStreamReader.read();
            if (i7 == -1) {
                break;
            }
            if (i7 == str.charAt(i6)) {
                i6++;
                if (i6 != i5) {
                    continue;
                } else {
                    if (!"<sheetData".equals(str)) {
                        break;
                    }
                    int i8 = inputStreamReader.read();
                    if (i8 == -1) {
                        outputStreamWriter.write(str);
                        break;
                    }
                    if (i8 == 62) {
                        outputStreamWriter.write(str);
                        outputStreamWriter.write(i8);
                        i5 = 12;
                        i6 = 0;
                        z6 = false;
                        str = "</sheetData>";
                    } else {
                        if (i8 == 47) {
                            int i9 = inputStreamReader.read();
                            if (i9 == -1) {
                                outputStreamWriter.write(str);
                                break;
                            } else {
                                if (i9 == 62) {
                                    break;
                                }
                                outputStreamWriter.write(str);
                                outputStreamWriter.write(47);
                                outputStreamWriter.write(i9);
                            }
                        } else {
                            outputStreamWriter.write(str);
                            outputStreamWriter.write(47);
                            outputStreamWriter.write(i8);
                        }
                        i6 = 0;
                    }
                }
            } else {
                if (i6 > 0) {
                    outputStreamWriter.write(str, 0, i6);
                }
                if (i7 == str.charAt(0)) {
                    i6 = 1;
                } else {
                    outputStreamWriter.write(i7);
                    i6 = 0;
                }
            }
        }
        outputStreamWriter.flush();
        if (z6) {
            outputStreamWriter.write("<sheetData>\n");
            outputStreamWriter.flush();
        }
        iSheetInjector.writeSheetData(outputStream);
        outputStreamWriter.write("</sheetData>");
        outputStreamWriter.flush();
        while (true) {
            int i10 = inputStreamReader.read();
            if (i10 == -1) {
                outputStreamWriter.flush();
                return;
            }
            outputStreamWriter.write(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createSheetInjector$0(SXSSFSheet sXSSFSheet, OutputStream outputStream) throws IOException {
        InputStream worksheetXMLInputStream = sXSSFSheet.getWorksheetXMLInputStream();
        try {
            IOUtils.copy(worksheetXMLInputStream, outputStream);
            if (worksheetXMLInputStream != null) {
                worksheetXMLInputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (worksheetXMLInputStream != null) {
                    try {
                        worksheetXMLInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int addOlePackage(byte[] bArr, String str, String str2, String str3) {
        return this._wb.addOlePackage(bArr, str, str2, str3);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int addPicture(byte[] bArr, int i5) {
        return this._wb.addPicture(bArr, i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void addToolPack(UDFFinder uDFFinder) {
        this._wb.addToolPack(uDFFinder);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @NotImplemented
    public Sheet cloneSheet(int i5) {
        throw new RuntimeException("Not Implemented");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        for (SXSSFSheet sXSSFSheet : this._xFromSxHash.values()) {
            try {
                SheetDataWriter sheetDataWriter = sXSSFSheet.getSheetDataWriter();
                if (sheetDataWriter != null) {
                    sheetDataWriter.close();
                }
            } catch (IOException e) {
                LOG.atWarn().withThrowable(e).log("An exception occurred while closing sheet data writer for sheet {}.", sXSSFSheet.getSheetName());
            }
        }
        this._wb.close();
    }

    public SXSSFSheet createAndRegisterSXSSFSheet(XSSFSheet xSSFSheet) {
        try {
            SXSSFSheet sXSSFSheet = new SXSSFSheet(this, xSSFSheet);
            registerSheetMapping(sXSSFSheet, xSSFSheet);
            return sXSSFSheet;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ZipArchiveOutputStream createArchiveOutputStream(OutputStream outputStream) {
        if (Zip64Mode.Always.equals(this.zip64Mode)) {
            return new OpcZipArchiveOutputStream(outputStream);
        }
        ZipArchiveOutputStream zipArchiveOutputStream = new ZipArchiveOutputStream(outputStream);
        zipArchiveOutputStream.setUseZip64(this.zip64Mode);
        return zipArchiveOutputStream;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public CellStyle createCellStyle() {
        return this._wb.createCellStyle();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public DataFormat createDataFormat() {
        return this._wb.createDataFormat();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public EvaluationWorkbook createEvaluationWorkbook() {
        return SXSSFEvaluationWorkbook.create(this);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Font createFont() {
        return this._wb.createFont();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Name createName() {
        return this._wb.createName();
    }

    public SheetDataWriter createSheetDataWriter() {
        return this._compressTmpFiles ? new GZIPSheetDataWriter(this._sharedStringSource) : new SheetDataWriter(this._sharedStringSource);
    }

    public ISheetInjector createSheetInjector(SXSSFSheet sXSSFSheet) {
        return new g(sXSSFSheet, 4);
    }

    public void deregisterSheetMapping(XSSFSheet xSSFSheet) {
        SXSSFSheet sXSSFSheet = getSXSSFSheet(xSSFSheet);
        if (sXSSFSheet != null) {
            IOUtils.closeQuietly(sXSSFSheet.getSheetDataWriter());
            this._sxFromXHash.remove(sXSSFSheet);
            this._xFromSxHash.remove(xSSFSheet);
        }
    }

    public boolean dispose() {
        Iterator<SXSSFSheet> it = this._sxFromXHash.keySet().iterator();
        boolean z6 = true;
        while (it.hasNext()) {
            boolean z7 = false;
            try {
                if (it.next().dispose() && z6) {
                    z7 = true;
                }
            } catch (IOException e) {
                LOG.atWarn().withThrowable(e).log("Failed to dispose sheet");
            }
            z6 = z7;
        }
        return z6;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Font findFont(boolean z6, short s6, short s7, String str, boolean z7, boolean z8, short s8, byte b) {
        return this._wb.findFont(z6, s6, s7, str, z7, z8, s8, b);
    }

    public void flushSheets() {
        for (SXSSFSheet sXSSFSheet : this._xFromSxHash.values()) {
            sXSSFSheet.deriveDimension();
            sXSSFSheet.flushRows();
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getActiveSheetIndex() {
        return this._wb.getActiveSheetIndex();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<? extends Name> getAllNames() {
        return this._wb.getAllNames();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<? extends PictureData> getAllPictures() {
        return this._wb.getAllPictures();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public CellReferenceType getCellReferenceType() {
        return getXSSFWorkbook().getCellReferenceType();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public CellStyle getCellStyleAt(int i5) {
        return this._wb.getCellStyleAt(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public CreationHelper getCreationHelper() {
        return new SXSSFCreationHelper(this);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getFirstVisibleTab() {
        return this._wb.getFirstVisibleTab();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Font getFontAt(int i5) {
        return this._wb.getFontAt(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean getForceFormulaRecalculation() {
        return this._wb.getForceFormulaRecalculation();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Row.MissingCellPolicy getMissingCellPolicy() {
        return this._wb.getMissingCellPolicy();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Name getName(String str) {
        return this._wb.getName(str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<? extends Name> getNames(String str) {
        return this._wb.getNames(str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumCellStyles() {
        return this._wb.getNumCellStyles();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfFonts() {
        return this._wb.getNumberOfFonts();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @Removal(version = "6.0.0")
    @Deprecated
    public int getNumberOfFontsAsInt() {
        return getNumberOfFonts();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfNames() {
        return this._wb.getNumberOfNames();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfSheets() {
        return this._wb.getNumberOfSheets();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public String getPrintArea(int i5) {
        return this._wb.getPrintArea(i5);
    }

    public int getRandomAccessWindowSize() {
        return this._randomAccessWindowSize;
    }

    public SXSSFSheet getSXSSFSheet(XSSFSheet xSSFSheet) {
        return this._xFromSxHash.get(xSSFSheet);
    }

    @Internal
    public SharedStringsTable getSharedStringSource() {
        return this._sharedStringSource;
    }

    public XSSFSheet getSheetFromZipEntryName(String str) {
        for (XSSFSheet xSSFSheet : this._sxFromXHash.values()) {
            if (str.equals(xSSFSheet.getPackagePart().getPartName().getName().substring(1))) {
                return xSSFSheet;
            }
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getSheetIndex(String str) {
        return this._wb.getSheetIndex(str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public String getSheetName(int i5) {
        return this._wb.getSheetName(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SheetVisibility getSheetVisibility(int i5) {
        return this._wb.getSheetVisibility(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SpreadsheetVersion getSpreadsheetVersion() {
        return SpreadsheetVersion.EXCEL2007;
    }

    public XSSFSheet getXSSFSheet(SXSSFSheet sXSSFSheet) {
        return this._sxFromXHash.get(sXSSFSheet);
    }

    public XSSFWorkbook getXSSFWorkbook() {
        return this._wb;
    }

    public void injectData(ZipEntrySource zipEntrySource, OutputStream outputStream) throws IOException {
        ZipArchiveOutputStream zipArchiveOutputStreamCreateArchiveOutputStream = createArchiveOutputStream(outputStream);
        try {
            Enumeration<? extends ZipArchiveEntry> entries = zipEntrySource.getEntries();
            while (entries.hasMoreElements()) {
                ZipArchiveEntry zipArchiveEntryNextElement = entries.nextElement();
                ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(zipArchiveEntryNextElement.getName());
                if (zipArchiveEntryNextElement.getSize() >= 0) {
                    zipArchiveEntry.setSize(zipArchiveEntryNextElement.getSize());
                }
                if (zipArchiveEntryNextElement.getTime() >= 0) {
                    zipArchiveEntry.setTime(zipArchiveEntryNextElement.getTime());
                }
                zipArchiveOutputStreamCreateArchiveOutputStream.putArchiveEntry(zipArchiveEntry);
                try {
                    InputStream inputStream = zipEntrySource.getInputStream(zipArchiveEntryNextElement);
                    try {
                        if (inputStream instanceof ZipArchiveThresholdInputStream) {
                            ((ZipArchiveThresholdInputStream) inputStream).setGuardState(false);
                        }
                        XSSFSheet sheetFromZipEntryName = getSheetFromZipEntryName(zipArchiveEntryNextElement.getName());
                        if (sheetFromZipEntryName == null || (sheetFromZipEntryName instanceof XSSFChartSheet)) {
                            IOUtils.copy(inputStream, zipArchiveOutputStreamCreateArchiveOutputStream);
                        } else {
                            copyStreamAndInjectWorksheet(inputStream, zipArchiveOutputStreamCreateArchiveOutputStream, createSheetInjector(getSXSSFSheet(sheetFromZipEntryName)));
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        zipArchiveOutputStreamCreateArchiveOutputStream.closeArchiveEntry();
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
                    zipArchiveOutputStreamCreateArchiveOutputStream.closeArchiveEntry();
                    throw th4;
                }
            }
            zipArchiveOutputStreamCreateArchiveOutputStream.finish();
            zipEntrySource.close();
        } catch (Throwable th5) {
            zipArchiveOutputStreamCreateArchiveOutputStream.finish();
            zipEntrySource.close();
            throw th5;
        }
    }

    public boolean isCompressTempFiles() {
        return this._compressTmpFiles;
    }

    public boolean isDate1904() {
        return this._wb.isDate1904();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @NotImplemented("XSSFWorkbook#isHidden is not implemented")
    public boolean isHidden() {
        return this._wb.isHidden();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isSheetHidden(int i5) {
        return this._wb.isSheetHidden(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isSheetVeryHidden(int i5) {
        return this._wb.isSheetVeryHidden(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @NotImplemented
    public int linkExternalWorkbook(String str, Workbook workbook) {
        throw new RuntimeException("Not Implemented");
    }

    public void registerSheetMapping(SXSSFSheet sXSSFSheet, XSSFSheet xSSFSheet) {
        this._sxFromXHash.put(sXSSFSheet, xSSFSheet);
        this._xFromSxHash.put(xSSFSheet, sXSSFSheet);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeName(Name name) {
        this._wb.removeName(name);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removePrintArea(int i5) {
        this._wb.removePrintArea(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeSheetAt(int i5) {
        XSSFSheet sheetAt = this._wb.getSheetAt(i5);
        SXSSFSheet sXSSFSheet = getSXSSFSheet(sheetAt);
        this._wb.removeSheetAt(i5);
        deregisterSheetMapping(sheetAt);
        try {
            sXSSFSheet.dispose();
        } catch (IOException e) {
            LOG.atWarn().withThrowable(e).log("Failed to dispose old sheet");
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setActiveSheet(int i5) {
        this._wb.setActiveSheet(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setCellReferenceType(CellReferenceType cellReferenceType) {
        getXSSFWorkbook().setCellReferenceType(cellReferenceType);
    }

    public void setCompressTempFiles(boolean z6) {
        this._compressTmpFiles = z6;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setFirstVisibleTab(int i5) {
        this._wb.setFirstVisibleTab(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setForceFormulaRecalculation(boolean z6) {
        this._wb.setForceFormulaRecalculation(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @NotImplemented("XSSFWorkbook#setHidden is not implemented")
    public void setHidden(boolean z6) {
        this._wb.setHidden(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setMissingCellPolicy(Row.MissingCellPolicy missingCellPolicy) {
        this._wb.setMissingCellPolicy(missingCellPolicy);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setPrintArea(int i5, String str) {
        this._wb.setPrintArea(i5, str);
    }

    public void setRandomAccessWindowSize(int i5) {
        if (i5 == 0 || i5 < -1) {
            throw new IllegalArgumentException("rowAccessWindowSize must be greater than 0 or -1");
        }
        this._randomAccessWindowSize = i5;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSelectedTab(int i5) {
        this._wb.setSelectedTab(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetHidden(int i5, boolean z6) {
        this._wb.setSheetHidden(i5, z6);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetName(int i5, String str) {
        this._wb.setSheetName(i5, str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetOrder(String str, int i5) {
        this._wb.setSheetOrder(str, i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetVisibility(int i5, SheetVisibility sheetVisibility) {
        this._wb.setSheetVisibility(i5, sheetVisibility);
    }

    public void setShouldCalculateSheetDimensions(boolean z6) {
        this.shouldCalculateSheetDimensions = z6;
    }

    public void setZip64Mode(Zip64Mode zip64Mode) {
        this.zip64Mode = zip64Mode;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Iterator<Sheet> sheetIterator() {
        return new SheetIterator();
    }

    public boolean shouldCalculateSheetDimensions() {
        return this.shouldCalculateSheetDimensions;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook, java.lang.Iterable
    public Spliterator<Sheet> spliterator() {
        return this._wb.spliterator();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void write(OutputStream outputStream) throws IOException {
        flushSheets();
        File fileCreateTempFile = TempFile.createTempFile("poi-sxssf-template", ".xlsx");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            try {
                this._wb.write(fileOutputStream);
                fileOutputStream.close();
                ZipSecureFile zipSecureFile = new ZipSecureFile(fileCreateTempFile);
                try {
                    ZipFileZipEntrySource zipFileZipEntrySource = new ZipFileZipEntrySource(zipSecureFile);
                    try {
                        injectData(zipFileZipEntrySource, outputStream);
                        zipFileZipEntrySource.close();
                        zipSecureFile.close();
                        if (!fileCreateTempFile.delete()) {
                            throw new IOException(a.k(fileCreateTempFile, "Could not delete temporary file after processing: "));
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                zipFileZipEntrySource.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        try {
                            zipSecureFile.close();
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
                        fileOutputStream.close();
                    } catch (Throwable th9) {
                        th7.addSuppressed(th9);
                    }
                    throw th8;
                }
            }
        } catch (Throwable th10) {
            fileCreateTempFile.delete();
            throw th10;
        }
    }

    public void writeAvoidingTempFiles(OutputStream outputStream) {
        flushSheets();
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
        try {
            this._wb.write(unsynchronizedByteArrayOutputStream);
            InputStream inputStream = unsynchronizedByteArrayOutputStream.toInputStream();
            try {
                ZipInputStreamZipEntrySource zipInputStreamZipEntrySource = new ZipInputStreamZipEntrySource(new ZipArchiveThresholdInputStream(new ZipArchiveInputStream(inputStream)));
                try {
                    injectData(zipInputStreamZipEntrySource, outputStream);
                    zipInputStreamZipEntrySource.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    unsynchronizedByteArrayOutputStream.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            zipInputStreamZipEntrySource.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
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
    }

    public SXSSFWorkbook(XSSFWorkbook xSSFWorkbook) {
        this(xSSFWorkbook, 100);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SXSSFSheet getSheet(String str) {
        return getSXSSFSheet(this._wb.getSheet(str));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SXSSFSheet getSheetAt(int i5) {
        return getSXSSFSheet(this._wb.getSheetAt(i5));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getSheetIndex(Sheet sheet) {
        return this._wb.getSheetIndex(getXSSFSheet((SXSSFSheet) sheet));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setPrintArea(int i5, int i6, int i7, int i8, int i9) {
        this._wb.setPrintArea(i5, i6, i7, i8, i9);
    }

    public SXSSFWorkbook(XSSFWorkbook xSSFWorkbook, int i5) {
        this(xSSFWorkbook, i5, false);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SXSSFSheet createSheet() {
        return createAndRegisterSXSSFSheet(this._wb.createSheet());
    }

    public SXSSFWorkbook(XSSFWorkbook xSSFWorkbook, int i5, boolean z6) {
        this(xSSFWorkbook, i5, z6, false);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SXSSFSheet createSheet(String str) {
        return createAndRegisterSXSSFSheet(this._wb.createSheet(str));
    }

    public SXSSFWorkbook(XSSFWorkbook xSSFWorkbook, int i5, boolean z6, boolean z7) {
        this._sxFromXHash = new HashMap();
        this._xFromSxHash = new HashMap();
        this._randomAccessWindowSize = 100;
        this.zip64Mode = Zip64Mode.Always;
        this.shouldCalculateSheetDimensions = true;
        setRandomAccessWindowSize(i5);
        setCompressTempFiles(z6);
        if (xSSFWorkbook == null) {
            XSSFWorkbook xSSFWorkbook2 = new XSSFWorkbook();
            this._wb = xSSFWorkbook2;
            this._sharedStringSource = z7 ? xSSFWorkbook2.getSharedStringSource() : null;
        } else {
            this._wb = xSSFWorkbook;
            this._sharedStringSource = z7 ? xSSFWorkbook.getSharedStringSource() : null;
            Iterator<Sheet> it = xSSFWorkbook.iterator();
            while (it.hasNext()) {
                createAndRegisterSXSSFSheet((XSSFSheet) it.next());
            }
        }
    }

    public SXSSFWorkbook(int i5) {
        this(null, i5);
    }
}
