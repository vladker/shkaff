package org.apache.poi.hssf.extractor;

import A3.AbstractC0157z;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Locale;
import org.apache.logging.log4j.util.Chars;
import org.apache.poi.extractor.POIOLE2TextExtractor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HeaderFooter;
import org.apache.poi.ss.usermodel.Row;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ExcelExtractor implements POIOLE2TextExtractor, org.apache.poi.ss.extractor.ExcelExtractor {
    private final HSSFDataFormatter _formatter;
    private boolean _includeBlankCells;
    private boolean _includeCellComments;
    private boolean _includeHeadersFooters;
    private boolean _includeSheetNames;
    private boolean _shouldEvaluateFormulas;
    private final HSSFWorkbook _wb;
    private boolean doCloseFilesystem;

    /* JADX INFO: renamed from: org.apache.poi.hssf.extractor.ExcelExtractor$1, reason: invalid class name */
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
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.NUMERIC.ordinal()] = 2;
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
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class CommandArgs {
        private final boolean _evaluateFormulas;
        private final boolean _headersFooters;
        private final File _inputFile;
        private final boolean _requestHelp;
        private final boolean _showBlankCells;
        private final boolean _showCellComments;
        private final boolean _showSheetNames;

        public CommandArgs(String[] strArr) throws CommandParseException {
            int i5;
            int length = strArr.length;
            File file = null;
            boolean z6 = false;
            int i6 = 0;
            boolean boolArg = false;
            boolean boolArg2 = false;
            boolean boolArg3 = true;
            boolean boolArg4 = true;
            boolean boolArg5 = true;
            while (i6 < length) {
                String str = strArr[i6];
                if ("-help".equalsIgnoreCase(str)) {
                    z6 = true;
                    break;
                }
                if ("-i".equals(str)) {
                    i5 = i6 + 1;
                    if (i5 >= length) {
                        throw new CommandParseException("Expected filename after '-i'");
                    }
                    String str2 = strArr[i5];
                    if (file != null) {
                        throw new CommandParseException("Only one input file can be supplied");
                    }
                    file = new File(str2);
                    if (!file.exists()) {
                        throw new CommandParseException(AbstractC0157z.o("Specified input file '", str2, "' does not exist"));
                    }
                    if (file.isDirectory()) {
                        throw new CommandParseException(AbstractC0157z.o("Specified input file '", str2, "' is a directory"));
                    }
                } else if ("--show-sheet-names".equals(str)) {
                    i5 = i6 + 1;
                    boolArg3 = parseBoolArg(strArr, i5);
                } else if ("--evaluate-formulas".equals(str)) {
                    i5 = i6 + 1;
                    boolArg4 = parseBoolArg(strArr, i5);
                } else if ("--show-comments".equals(str)) {
                    i5 = i6 + 1;
                    boolArg = parseBoolArg(strArr, i5);
                } else if ("--show-blanks".equals(str)) {
                    i5 = i6 + 1;
                    boolArg2 = parseBoolArg(strArr, i5);
                } else {
                    if (!"--headers-footers".equals(str)) {
                        throw new CommandParseException(AbstractC0157z.o("Invalid argument '", str, "'"));
                    }
                    i5 = i6 + 1;
                    boolArg5 = parseBoolArg(strArr, i5);
                }
                i6 = i5 + 1;
            }
            this._requestHelp = z6;
            this._inputFile = file;
            this._showSheetNames = boolArg3;
            this._evaluateFormulas = boolArg4;
            this._showCellComments = boolArg;
            this._showBlankCells = boolArg2;
            this._headersFooters = boolArg5;
        }

        private static boolean parseBoolArg(String[] strArr, int i5) throws CommandParseException {
            if (i5 >= strArr.length) {
                throw new CommandParseException(AbstractC0157z.s(new StringBuilder("Expected value after '"), strArr[i5 - 1], "'"));
            }
            String upperCase = strArr[i5].toUpperCase(Locale.ROOT);
            if ("Y".equals(upperCase) || "YES".equals(upperCase) || "ON".equals(upperCase) || "TRUE".equals(upperCase)) {
                return true;
            }
            if ("N".equals(upperCase) || "NO".equals(upperCase) || "OFF".equals(upperCase) || "FALSE".equals(upperCase)) {
                return false;
            }
            StringBuilder sb = new StringBuilder("Invalid value '");
            sb.append(strArr[i5]);
            sb.append("' for '");
            throw new CommandParseException(AbstractC0157z.s(sb, strArr[i5 - 1], "'. Expected 'Y' or 'N'"));
        }

        public File getInputFile() {
            return this._inputFile;
        }

        public boolean isRequestHelp() {
            return this._requestHelp;
        }

        public boolean shouldEvaluateFormulas() {
            return this._evaluateFormulas;
        }

        public boolean shouldIncludeHeadersFooters() {
            return this._headersFooters;
        }

        public boolean shouldShowBlankCells() {
            return this._showBlankCells;
        }

        public boolean shouldShowCellComments() {
            return this._showCellComments;
        }

        public boolean shouldShowSheetNames() {
            return this._showSheetNames;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class CommandParseException extends Exception {
        public CommandParseException(String str) {
            super(str);
        }
    }

    public ExcelExtractor(HSSFWorkbook hSSFWorkbook) {
        this.doCloseFilesystem = true;
        this._includeSheetNames = true;
        this._shouldEvaluateFormulas = true;
        this._includeHeadersFooters = true;
        this._wb = hSSFWorkbook;
        this._formatter = new HSSFDataFormatter();
    }

    public static String _extractHeaderFooter(HeaderFooter headerFooter) {
        StringBuilder sb = new StringBuilder();
        if (headerFooter.getLeft() != null) {
            sb.append(headerFooter.getLeft());
        }
        if (headerFooter.getCenter() != null) {
            if (sb.length() > 0) {
                sb.append("\t");
            }
            sb.append(headerFooter.getCenter());
        }
        if (headerFooter.getRight() != null) {
            if (sb.length() > 0) {
                sb.append("\t");
            }
            sb.append(headerFooter.getRight());
        }
        if (sb.length() > 0) {
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] strArr) throws IOException {
        try {
            CommandArgs commandArgs = new CommandArgs(strArr);
            if (commandArgs.isRequestHelp()) {
                printUsageMessage(System.out);
                return;
            }
            InputStream fileInputStream = commandArgs.getInputFile() == null ? System.in : new FileInputStream(commandArgs.getInputFile());
            try {
                HSSFWorkbook hSSFWorkbook = new HSSFWorkbook(fileInputStream);
                try {
                    ExcelExtractor excelExtractor = new ExcelExtractor(hSSFWorkbook);
                    try {
                        excelExtractor.setIncludeSheetNames(commandArgs.shouldShowSheetNames());
                        excelExtractor.setFormulasNotResults(true ^ commandArgs.shouldEvaluateFormulas());
                        excelExtractor.setIncludeCellComments(commandArgs.shouldShowCellComments());
                        excelExtractor.setIncludeBlankCells(commandArgs.shouldShowBlankCells());
                        excelExtractor.setIncludeHeadersFooters(commandArgs.shouldIncludeHeadersFooters());
                        System.out.println(excelExtractor.getText());
                        excelExtractor.close();
                        hSSFWorkbook.close();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                excelExtractor.close();
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
                            hSSFWorkbook.close();
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
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th9) {
                            th7.addSuppressed(th9);
                        }
                    }
                    throw th8;
                }
            }
        } catch (CommandParseException e) {
            System.err.println(e.getMessage());
            printUsageMessage(System.err);
            System.exit(1);
        }
    }

    private static void printUsageMessage(PrintStream printStream) {
        printStream.println("Use:");
        printStream.println("    " + ExcelExtractor.class.getName() + " [<flag> <value> [<flag> <value> [...]]] [-i <filename.xls>]");
        printStream.println("       -i <filename.xls> specifies input file (default is to use stdin)");
        printStream.println("       Flags can be set on or off by using the values 'Y' or 'N'.");
        printStream.println("       Following are available flags and their default values:");
        printStream.println("       --show-sheet-names  Y");
        printStream.println("       --evaluate-formulas Y");
        printStream.println("       --show-comments     N");
        printStream.println("       --show-blanks       Y");
        printStream.println("       --headers-footers   Y");
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public String getText() {
        boolean z6;
        String sheetName;
        StringBuilder sb = new StringBuilder();
        this._wb.setMissingCellPolicy(Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
        for (int i5 = 0; i5 < this._wb.getNumberOfSheets(); i5++) {
            HSSFSheet sheetAt = this._wb.getSheetAt(i5);
            if (sheetAt != null) {
                if (this._includeSheetNames && (sheetName = this._wb.getSheetName(i5)) != null) {
                    sb.append(sheetName);
                    sb.append("\n");
                }
                if (this._includeHeadersFooters) {
                    sb.append(_extractHeaderFooter(sheetAt.getHeader()));
                }
                int lastRowNum = sheetAt.getLastRowNum();
                for (int firstRowNum = sheetAt.getFirstRowNum(); firstRowNum <= lastRowNum; firstRowNum++) {
                    HSSFRow row = sheetAt.getRow(firstRowNum);
                    if (row != null) {
                        int firstCellNum = row.getFirstCellNum();
                        short lastCellNum = row.getLastCellNum();
                        if (this._includeBlankCells) {
                            firstCellNum = 0;
                        }
                        while (firstCellNum < lastCellNum) {
                            HSSFCell cell = row.getCell(firstCellNum);
                            if (cell == null) {
                                z6 = this._includeBlankCells;
                            } else {
                                int[] iArr = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType;
                                int i6 = iArr[cell.getCellType().ordinal()];
                                if (i6 == 1) {
                                    sb.append(cell.getRichStringCellValue().getString());
                                } else if (i6 == 2) {
                                    sb.append(this._formatter.formatCellValue(cell));
                                } else if (i6 == 3) {
                                    sb.append(cell.getBooleanCellValue());
                                } else if (i6 == 4) {
                                    sb.append(ErrorEval.getText(cell.getErrorCellValue()));
                                } else {
                                    if (i6 != 5) {
                                        throw new RuntimeException("Unexpected cell type (" + cell.getCellType() + ")");
                                    }
                                    if (this._shouldEvaluateFormulas) {
                                        int i7 = iArr[cell.getCachedFormulaResultType().ordinal()];
                                        if (i7 == 1) {
                                            HSSFRichTextString richStringCellValue = cell.getRichStringCellValue();
                                            if (richStringCellValue != null && richStringCellValue.length() > 0) {
                                                sb.append(richStringCellValue);
                                            }
                                        } else if (i7 == 2) {
                                            HSSFCellStyle cellStyle = cell.getCellStyle();
                                            sb.append(this._formatter.formatRawCellContents(cell.getNumericCellValue(), cellStyle.getDataFormat(), cellStyle.getDataFormatString()));
                                        } else if (i7 == 3) {
                                            sb.append(cell.getBooleanCellValue());
                                        } else {
                                            if (i7 != 4) {
                                                throw new IllegalStateException("Unexpected cell cached formula result type: " + cell.getCachedFormulaResultType());
                                            }
                                            sb.append(ErrorEval.getText(cell.getErrorCellValue()));
                                        }
                                    } else {
                                        sb.append(cell.getCellFormula());
                                    }
                                }
                                HSSFComment cellComment = cell.getCellComment();
                                if (this._includeCellComments && cellComment != null) {
                                    String strReplace = cellComment.getString().getString().replace('\n', Chars.SPACE);
                                    sb.append(" Comment by ");
                                    sb.append(cellComment.getAuthor());
                                    sb.append(": ");
                                    sb.append(strReplace);
                                }
                                z6 = true;
                            }
                            if (z6 && firstCellNum < lastCellNum - 1) {
                                sb.append("\t");
                            }
                            firstCellNum++;
                        }
                        sb.append("\n");
                    }
                }
                if (this._includeHeadersFooters) {
                    sb.append(_extractHeaderFooter(sheetAt.getFooter()));
                }
            }
        }
        return sb.toString();
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public boolean isCloseFilesystem() {
        return this.doCloseFilesystem;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public void setCloseFilesystem(boolean z6) {
        this.doCloseFilesystem = z6;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setFormulasNotResults(boolean z6) {
        this._shouldEvaluateFormulas = !z6;
    }

    public void setIncludeBlankCells(boolean z6) {
        this._includeBlankCells = z6;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeCellComments(boolean z6) {
        this._includeCellComments = z6;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeHeadersFooters(boolean z6) {
        this._includeHeadersFooters = z6;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeSheetNames(boolean z6) {
        this._includeSheetNames = z6;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public HSSFWorkbook getFilesystem() {
        return this._wb;
    }

    @Override // org.apache.poi.extractor.POIOLE2TextExtractor, org.apache.poi.extractor.POITextExtractor
    public HSSFWorkbook getDocument() {
        return this._wb;
    }

    public ExcelExtractor(POIFSFileSystem pOIFSFileSystem) {
        this(pOIFSFileSystem.getRoot());
    }

    public ExcelExtractor(DirectoryNode directoryNode) {
        this(new HSSFWorkbook(directoryNode, true));
    }
}
