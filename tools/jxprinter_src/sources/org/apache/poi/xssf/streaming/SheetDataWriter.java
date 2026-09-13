package org.apache.poi.xssf.streaming;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.util.CodepointsUtil;
import org.apache.poi.util.Removal;
import org.apache.poi.util.TempFile;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SheetDataWriter implements Closeable {
    private static final Logger LOG = LogManager.getLogger((Class<?>) SheetDataWriter.class);
    private final File _fd;
    private int _lowestIndexOfFlushedRows;
    private int _numberLastFlushedRow;
    private int _numberOfCellsOfLastFlushedRow;
    private int _numberOfFlushedRows;
    protected final Writer _out;
    private int _rownum;
    private SharedStringsTable _sharedStringSource;

    /* JADX INFO: renamed from: org.apache.poi.xssf.streaming.SheetDataWriter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

        static {
            int[] iArr = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr;
            try {
                iArr[CellType.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BLANK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public SheetDataWriter() {
        this._numberLastFlushedRow = -1;
        File fileCreateTempFile = createTempFile();
        this._fd = fileCreateTempFile;
        this._out = createWriter(fileCreateTempFile);
    }

    public static boolean replaceWithQuestionMark(char c) {
        if (c >= ' ') {
            return 65534 <= c && c <= 65535;
        }
        return true;
    }

    private void writeAttribute(String str, String str2) throws IOException {
        this._out.write(32);
        this._out.write(str);
        this._out.write("=\"");
        this._out.write(str2);
        this._out.write(34);
    }

    public void beginRow(int i5, SXSSFRow sXSSFRow) throws IOException {
        this._out.write("<row");
        writeAttribute("r", Integer.toString(i5 + 1));
        if (sXSSFRow.hasCustomHeight()) {
            writeAttribute("customHeight", "true");
            writeAttribute("ht", Float.toString(sXSSFRow.getHeightInPoints()));
        }
        if (sXSSFRow.getZeroHeight()) {
            writeAttribute(CellUtil.HIDDEN, "true");
        }
        if (sXSSFRow.isFormatted()) {
            writeAttribute("s", Integer.toString(sXSSFRow.getRowStyleIndex()));
            writeAttribute("customFormat", "1");
        }
        if (sXSSFRow.getOutlineLevel() != 0) {
            writeAttribute("outlineLevel", Integer.toString(sXSSFRow.getOutlineLevel()));
        }
        if (sXSSFRow.getHidden() != null) {
            writeAttribute(CellUtil.HIDDEN, sXSSFRow.getHidden().booleanValue() ? "1" : "0");
        }
        if (sXSSFRow.getCollapsed() != null) {
            writeAttribute("collapsed", sXSSFRow.getCollapsed().booleanValue() ? "1" : "0");
        }
        this._out.write(">\n");
        this._rownum = i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this._out.close();
    }

    @Removal(version = "6.0.0")
    public File createTempFile() {
        return TempFile.createTempFile("poi-sxssf-sheet", ".xml");
    }

    @Removal(version = "6.0.0")
    public Writer createWriter(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            return new BufferedWriter(new OutputStreamWriter(decorateOutputStream(fileOutputStream), StandardCharsets.UTF_8));
        } catch (IOException e) {
            fileOutputStream.close();
            throw e;
        }
    }

    public boolean dispose() {
        try {
            this._out.close();
            return this._fd.delete();
        } catch (Throwable th) {
            this._fd.delete();
            throw th;
        }
    }

    public void endRow() throws IOException {
        this._out.write("</row>\n");
    }

    public void flush() throws IOException {
        this._out.flush();
    }

    public int getLastFlushedRow() {
        return this._numberLastFlushedRow;
    }

    public int getLowestIndexOfFlushedRows() {
        return this._lowestIndexOfFlushedRows;
    }

    public int getNumberOfCellsOfLastFlushedRow() {
        return this._numberOfCellsOfLastFlushedRow;
    }

    public int getNumberOfFlushedRows() {
        return this._numberOfFlushedRows;
    }

    public File getTempFile() {
        return this._fd;
    }

    public InputStream getWorksheetXMLInputStream() throws IOException {
        File tempFile = getTempFile();
        if (tempFile == null) {
            throw new IOException("getWorksheetXMLInputStream only works when a temp file is used");
        }
        FileInputStream fileInputStream = new FileInputStream(tempFile);
        try {
            return decorateInputStream(fileInputStream);
        } catch (IOException e) {
            fileInputStream.close();
            throw e;
        }
    }

    public boolean hasLeadingTrailingSpaces(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return Character.isWhitespace(str.charAt(0)) || Character.isWhitespace(str.charAt(str.length() - 1));
    }

    public void outputEscapedString(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return;
        }
        Iterator<String> itIteratorFor = CodepointsUtil.iteratorFor(str);
        while (itIteratorFor.hasNext()) {
            String next = itIteratorFor.next();
            next.getClass();
            switch (next) {
                case "	":
                    this._out.write("&#x9;");
                    break;
                case "
":
                    this._out.write("&#xa;");
                    break;
                case "":
                    this._out.write("&#xd;");
                    break;
                case """:
                    this._out.write("&quot;");
                    break;
                case "&":
                    this._out.write("&amp;");
                    break;
                case "<":
                    this._out.write("&lt;");
                    break;
                case ">":
                    this._out.write("&gt;");
                    break;
                case " ":
                    this._out.write("&#xa0;");
                    break;
                default:
                    if (next.length() == 1) {
                        char cCharAt = next.charAt(0);
                        if (!replaceWithQuestionMark(cCharAt)) {
                            this._out.write(cCharAt);
                        } else {
                            this._out.write(63);
                        }
                        break;
                    } else {
                        this._out.write(next);
                        break;
                    }
                    break;
            }
        }
    }

    public void writeCell(int i5, Cell cell) throws IOException {
        if (cell == null) {
            return;
        }
        String asString = new CellReference(this._rownum, i5).formatAsString();
        this._out.write("<c");
        writeAttribute("r", asString);
        CellStyle cellStyle = cell.getCellStyle();
        if (cellStyle.getIndex() != 0) {
            writeAttribute("s", Integer.toString(cellStyle.getIndex() & 65535));
        }
        CellType cellType = cell.getCellType();
        int[] iArr = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType;
        switch (iArr[cellType.ordinal()]) {
            case 1:
                writeAttribute("t", "n");
                this._out.write("><v>");
                this._out.write(Double.toString(cell.getNumericCellValue()));
                this._out.write("</v>");
                break;
            case 2:
                if (this._sharedStringSource == null) {
                    writeAttribute("t", "inlineStr");
                    this._out.write("><is><t");
                    if (hasLeadingTrailingSpaces(cell.getStringCellValue())) {
                        writeAttribute("xml:space", "preserve");
                    }
                    this._out.write(">");
                    outputEscapedString(cell.getStringCellValue());
                    this._out.write("</t></is>");
                } else {
                    int iAddSharedStringItem = this._sharedStringSource.addSharedStringItem(cell.getRichStringCellValue());
                    writeAttribute("t", STCellType.f7731S.toString());
                    this._out.write("><v>");
                    this._out.write(String.valueOf(iAddSharedStringItem));
                    this._out.write("</v>");
                }
                break;
            case 3:
                writeAttribute("t", "b");
                this._out.write("><v>");
                this._out.write(cell.getBooleanCellValue() ? "1" : "0");
                this._out.write("</v>");
                break;
            case 4:
                FormulaError formulaErrorForInt = FormulaError.forInt(cell.getErrorCellValue());
                writeAttribute("t", "e");
                this._out.write("><v>");
                outputEscapedString(formulaErrorForInt.getString());
                this._out.write("</v>");
                break;
            case 5:
                this._out.write(62);
                break;
            case 6:
                int i6 = iArr[cell.getCachedFormulaResultType().ordinal()];
                if (i6 == 1) {
                    writeAttribute("t", "n");
                } else if (i6 == 2) {
                    writeAttribute("t", STCellType.STR.toString());
                } else if (i6 == 3) {
                    writeAttribute("t", "b");
                } else if (i6 == 4) {
                    writeAttribute("t", "e");
                }
                this._out.write("><f>");
                outputEscapedString(cell.getCellFormula());
                this._out.write("</f>");
                int i7 = iArr[cell.getCachedFormulaResultType().ordinal()];
                if (i7 == 1) {
                    double numericCellValue = cell.getNumericCellValue();
                    if (!Double.isNaN(numericCellValue)) {
                        this._out.write("<v>");
                        this._out.write(Double.toString(numericCellValue));
                        this._out.write("</v>");
                    }
                } else if (i7 == 2) {
                    String stringCellValue = cell.getStringCellValue();
                    if (stringCellValue != null && !stringCellValue.isEmpty()) {
                        this._out.write("<v>");
                        outputEscapedString(stringCellValue);
                        this._out.write("</v>");
                    }
                } else if (i7 == 3) {
                    this._out.write("><v>");
                    this._out.write(cell.getBooleanCellValue() ? "1" : "0");
                    this._out.write("</v>");
                } else if (i7 == 4) {
                    FormulaError formulaErrorForInt2 = FormulaError.forInt(cell.getErrorCellValue());
                    this._out.write("><v>");
                    outputEscapedString(formulaErrorForInt2.getString());
                    this._out.write("</v>");
                }
                break;
            default:
                throw new IllegalStateException("Invalid cell type: " + cellType);
        }
        this._out.write("</c>");
    }

    public void writeRow(int i5, SXSSFRow sXSSFRow) throws IOException {
        if (this._numberOfFlushedRows == 0) {
            this._lowestIndexOfFlushedRows = i5;
        }
        this._numberLastFlushedRow = Math.max(i5, this._numberLastFlushedRow);
        this._numberOfCellsOfLastFlushedRow = sXSSFRow.getLastCellNum();
        this._numberOfFlushedRows++;
        beginRow(i5, sXSSFRow);
        Iterator<Cell> itAllCellsIterator = sXSSFRow.allCellsIterator();
        int i6 = 0;
        while (itAllCellsIterator.hasNext()) {
            writeCell(i6, itAllCellsIterator.next());
            i6++;
        }
        endRow();
    }

    public SheetDataWriter(Writer writer) {
        this._numberLastFlushedRow = -1;
        this._fd = null;
        this._out = writer;
    }

    public SheetDataWriter(SharedStringsTable sharedStringsTable) {
        this();
        this._sharedStringSource = sharedStringsTable;
    }

    public InputStream decorateInputStream(FileInputStream fileInputStream) {
        return fileInputStream;
    }

    public OutputStream decorateOutputStream(FileOutputStream fileOutputStream) {
        return fileOutputStream;
    }
}
