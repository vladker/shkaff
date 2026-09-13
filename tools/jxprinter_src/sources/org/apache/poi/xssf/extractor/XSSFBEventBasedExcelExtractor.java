package org.apache.poi.xssf.extractor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.binary.XSSFBCommentsTable;
import org.apache.poi.xssf.binary.XSSFBHyperlinksTable;
import org.apache.poi.xssf.binary.XSSFBSharedStringsTable;
import org.apache.poi.xssf.binary.XSSFBSheetHandler;
import org.apache.poi.xssf.binary.XSSFBStylesTable;
import org.apache.poi.xssf.eventusermodel.XSSFBReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.SharedStrings;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFBEventBasedExcelExtractor extends XSSFEventBasedExcelExtractor {
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) XSSFBEventBasedExcelExtractor.class);
    public static final List<XSSFRelation> SUPPORTED_TYPES = Collections.singletonList(XSSFRelation.XLSB_BINARY_WORKBOOK);
    private boolean handleHyperlinksInCells;

    public XSSFBEventBasedExcelExtractor(String str) {
        super(str);
    }

    @Override // org.apache.poi.xssf.extractor.XSSFEventBasedExcelExtractor, org.apache.poi.extractor.POITextExtractor
    public String getText() {
        try {
            SharedStrings xSSFBSharedStringsTable = new XSSFBSharedStringsTable(getPackage());
            XSSFBReader xSSFBReader = new XSSFBReader(getPackage());
            XSSFBStylesTable xSSFBStylesTable = xSSFBReader.getXSSFBStylesTable();
            XSSFBReader.SheetIterator sheetIterator = (XSSFBReader.SheetIterator) xSSFBReader.getSheetsData();
            StringBuilder sb = new StringBuilder(64);
            XSSFEventBasedExcelExtractor.SheetTextExtractor sheetTextExtractor = new XSSFEventBasedExcelExtractor.SheetTextExtractor();
            while (sheetIterator.hasNext()) {
                InputStream next = sheetIterator.next();
                try {
                    if (getIncludeSheetNames()) {
                        sb.append(sheetIterator.getSheetName());
                        sb.append('\n');
                    }
                    if (this.handleHyperlinksInCells) {
                        new XSSFBHyperlinksTable(sheetIterator.getSheetPart());
                    }
                    try {
                        processSheet(sheetTextExtractor, xSSFBStylesTable, getIncludeCellComments() ? sheetIterator.getXSSFBSheetComments() : null, xSSFBSharedStringsTable, next);
                        if (getIncludeHeadersFooters()) {
                            sheetTextExtractor.appendHeaderText(sb);
                        }
                        sheetTextExtractor.appendCellText(sb);
                        if (getIncludeTextBoxes()) {
                            processShapes(sheetIterator.getShapes(), sb);
                        }
                        if (getIncludeHeadersFooters()) {
                            sheetTextExtractor.appendFooterText(sb);
                        }
                        sheetTextExtractor.reset();
                        if (next != null) {
                            try {
                                next.close();
                            } catch (IOException e) {
                                e = e;
                                LOGGER.atWarn().withThrowable(e).log("Failed to load text");
                                return "";
                            } catch (OpenXML4JException e6) {
                                e = e6;
                                LOGGER.atWarn().withThrowable(e).log("Failed to load text");
                                return "";
                            } catch (SAXException e7) {
                                e = e7;
                                LOGGER.atWarn().withThrowable(e).log("Failed to load text");
                                return "";
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        Throwable th2 = th;
                        try {
                            throw th2;
                        } catch (Throwable th3) {
                            if (next == null) {
                                throw th3;
                            }
                            try {
                                next.close();
                                throw th3;
                            } catch (Throwable th4) {
                                th2.addSuppressed(th4);
                                throw th3;
                            }
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            }
            return sb.toString();
        } catch (IOException e8) {
            e = e8;
            LOGGER.atWarn().withThrowable(e).log("Failed to load text");
            return "";
        } catch (OpenXML4JException e9) {
            e = e9;
            LOGGER.atWarn().withThrowable(e).log("Failed to load text");
            return "";
        } catch (SAXException e10) {
            e = e10;
            LOGGER.atWarn().withThrowable(e).log("Failed to load text");
            return "";
        }
    }

    public void processSheet(XSSFSheetXMLHandler.SheetContentsHandler sheetContentsHandler, XSSFBStylesTable xSSFBStylesTable, XSSFBCommentsTable xSSFBCommentsTable, SharedStrings sharedStrings, InputStream inputStream) throws IOException {
        new XSSFBSheetHandler(inputStream, xSSFBStylesTable, xSSFBCommentsTable, sharedStrings, sheetContentsHandler, getLocale() == null ? new DataFormatter() : new DataFormatter(getLocale()), getFormulasNotResults()).parse();
    }

    @Override // org.apache.poi.xssf.extractor.XSSFEventBasedExcelExtractor, org.apache.poi.ss.extractor.ExcelExtractor
    public void setFormulasNotResults(boolean z6) {
        throw new IllegalArgumentException("Not currently supported");
    }

    public void setHandleHyperlinksInCells(boolean z6) {
        this.handleHyperlinksInCells = z6;
    }

    public XSSFBEventBasedExcelExtractor(OPCPackage oPCPackage) {
        super(oPCPackage);
    }
}
