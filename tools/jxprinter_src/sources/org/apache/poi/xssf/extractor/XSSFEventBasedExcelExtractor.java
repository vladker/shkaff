package org.apache.poi.xssf.extractor;

import androidx.exifinterface.media.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Chars;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.POIXMLProperties;
import org.apache.poi.ooxml.extractor.POIXMLTextExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.util.XMLHelper;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.Comments;
import org.apache.poi.xssf.model.SharedStrings;
import org.apache.poi.xssf.model.Styles;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSimpleShape;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFEventBasedExcelExtractor implements POIXMLTextExtractor, ExcelExtractor {
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) XSSFEventBasedExcelExtractor.class);
    protected boolean concatenatePhoneticRuns;
    protected final OPCPackage container;
    private boolean doCloseFilesystem;
    protected boolean formulasNotResults;
    protected boolean includeCellComments;
    protected boolean includeHeadersFooters;
    protected boolean includeSheetNames;
    protected boolean includeTextBoxes;
    protected Locale locale;
    protected final POIXMLProperties properties;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class SheetTextExtractor implements XSSFSheetXMLHandler.SheetContentsHandler {
        private final Map<String, String> headerFooterMap;
        private final StringBuilder output = new StringBuilder(64);
        private boolean firstCellOfRow = true;

        public SheetTextExtractor() {
            this.headerFooterMap = XSSFEventBasedExcelExtractor.this.includeHeadersFooters ? new HashMap() : null;
        }

        private void appendHeaderFooterText(StringBuilder sb, String str) {
            String str2 = this.headerFooterMap.get(str);
            if (str2 == null || str2.length() <= 0) {
                return;
            }
            sb.append(handleHeaderFooterDelimiter(handleHeaderFooterDelimiter(handleHeaderFooterDelimiter(str2, "&L"), "&C"), "&R"));
            sb.append('\n');
        }

        private String handleHeaderFooterDelimiter(String str, String str2) {
            int iIndexOf = str.indexOf(str2);
            if (iIndexOf == 0) {
                return str.substring(2);
            }
            if (iIndexOf <= 0) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(0, iIndexOf));
            sb.append("\t");
            return a.j(str, iIndexOf + 2, sb);
        }

        public void appendCellText(StringBuilder sb) {
            XSSFEventBasedExcelExtractor.this.checkMaxTextSize(sb, this.output.toString());
            sb.append((CharSequence) this.output);
        }

        public void appendFooterText(StringBuilder sb) {
            appendHeaderFooterText(sb, "firstFooter");
            appendHeaderFooterText(sb, "oddFooter");
            appendHeaderFooterText(sb, "evenFooter");
        }

        public void appendHeaderText(StringBuilder sb) {
            appendHeaderFooterText(sb, "firstHeader");
            appendHeaderFooterText(sb, "oddHeader");
            appendHeaderFooterText(sb, "evenHeader");
        }

        @Override // org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler
        public void cell(String str, String str2, XSSFComment xSSFComment) {
            if (this.firstCellOfRow) {
                this.firstCellOfRow = false;
            } else {
                this.output.append('\t');
            }
            if (str2 != null) {
                XSSFEventBasedExcelExtractor.this.checkMaxTextSize(this.output, str2);
                this.output.append(str2);
            }
            if (!XSSFEventBasedExcelExtractor.this.includeCellComments || xSSFComment == null) {
                return;
            }
            String strReplace = xSSFComment.getString().getString().replace('\n', Chars.SPACE);
            this.output.append(str2 != null ? " Comment by " : "Comment by ");
            XSSFEventBasedExcelExtractor.this.checkMaxTextSize(this.output, strReplace);
            if (strReplace.startsWith(xSSFComment.getAuthor() + ": ")) {
                this.output.append(strReplace);
                return;
            }
            StringBuilder sb = this.output;
            sb.append(xSSFComment.getAuthor());
            sb.append(": ");
            sb.append(strReplace);
        }

        @Override // org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler
        public void endRow(int i5) {
            this.output.append('\n');
        }

        @Override // org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler
        public void headerFooter(String str, boolean z6, String str2) {
            Map<String, String> map = this.headerFooterMap;
            if (map != null) {
                map.put(str2, str);
            }
        }

        public void reset() {
            this.output.setLength(0);
            this.firstCellOfRow = true;
            Map<String, String> map = this.headerFooterMap;
            if (map != null) {
                map.clear();
            }
        }

        @Override // org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler
        public void startRow(int i5) {
            this.firstCellOfRow = true;
        }
    }

    public XSSFEventBasedExcelExtractor(String str) {
        this(OPCPackage.open(str));
    }

    public SharedStrings createSharedStringsTable(XSSFReader xSSFReader, OPCPackage oPCPackage) {
        return new ReadOnlySharedStringsTable(oPCPackage, this.concatenatePhoneticRuns);
    }

    @Override // org.apache.poi.ooxml.extractor.POIXMLTextExtractor
    public POIXMLProperties.CoreProperties getCoreProperties() {
        return this.properties.getCoreProperties();
    }

    @Override // org.apache.poi.ooxml.extractor.POIXMLTextExtractor
    public POIXMLProperties.CustomProperties getCustomProperties() {
        return this.properties.getCustomProperties();
    }

    @Override // org.apache.poi.ooxml.extractor.POIXMLTextExtractor, org.apache.poi.extractor.POITextExtractor
    public POIXMLDocument getDocument() {
        return null;
    }

    @Override // org.apache.poi.ooxml.extractor.POIXMLTextExtractor
    public POIXMLProperties.ExtendedProperties getExtendedProperties() {
        return this.properties.getExtendedProperties();
    }

    public boolean getFormulasNotResults() {
        return this.formulasNotResults;
    }

    public boolean getIncludeCellComments() {
        return this.includeCellComments;
    }

    public boolean getIncludeHeadersFooters() {
        return this.includeHeadersFooters;
    }

    public boolean getIncludeSheetNames() {
        return this.includeSheetNames;
    }

    public boolean getIncludeTextBoxes() {
        return this.includeTextBoxes;
    }

    public Locale getLocale() {
        return this.locale;
    }

    @Override // org.apache.poi.ooxml.extractor.POIXMLTextExtractor
    public OPCPackage getPackage() {
        return this.container;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public String getText() {
        try {
            XSSFReader xSSFReader = new XSSFReader(this.container);
            SharedStrings sharedStringsCreateSharedStringsTable = createSharedStringsTable(xSSFReader, this.container);
            StylesTable stylesTable = xSSFReader.getStylesTable();
            XSSFReader.SheetIterator sheetIterator = (XSSFReader.SheetIterator) xSSFReader.getSheetsData();
            StringBuilder sb = new StringBuilder(64);
            SheetTextExtractor sheetTextExtractor = new SheetTextExtractor();
            while (sheetIterator.hasNext()) {
                InputStream next = sheetIterator.next();
                try {
                    if (this.includeSheetNames) {
                        sb.append(sheetIterator.getSheetName());
                        sb.append('\n');
                    }
                    try {
                        processSheet(sheetTextExtractor, stylesTable, this.includeCellComments ? sheetIterator.getSheetComments() : null, sharedStringsCreateSharedStringsTable, next);
                        if (this.includeHeadersFooters) {
                            sheetTextExtractor.appendHeaderText(sb);
                        }
                        sheetTextExtractor.appendCellText(sb);
                        if (this.includeTextBoxes) {
                            processShapes(sheetIterator.getShapes(), sb);
                        }
                        if (this.includeHeadersFooters) {
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

    @Override // org.apache.poi.extractor.POITextExtractor
    public boolean isCloseFilesystem() {
        return this.doCloseFilesystem;
    }

    public void processShapes(List<XSSFShape> list, StringBuilder sb) {
        String text;
        if (list == null) {
            return;
        }
        for (XSSFShape xSSFShape : list) {
            if ((xSSFShape instanceof XSSFSimpleShape) && (text = ((XSSFSimpleShape) xSSFShape).getText()) != null && text.length() > 0) {
                sb.append(text);
                sb.append('\n');
            }
        }
    }

    public void processSheet(XSSFSheetXMLHandler.SheetContentsHandler sheetContentsHandler, Styles styles, Comments comments, SharedStrings sharedStrings, InputStream inputStream) throws SAXException, IOException {
        DataFormatter dataFormatter = this.locale == null ? new DataFormatter() : new DataFormatter(this.locale);
        InputSource inputSource = new InputSource(inputStream);
        try {
            XMLReader xMLReaderNewXMLReader = XMLHelper.newXMLReader();
            xMLReaderNewXMLReader.setContentHandler(new XSSFSheetXMLHandler(styles, comments, sharedStrings, sheetContentsHandler, dataFormatter, this.formulasNotResults));
            xMLReaderNewXMLReader.parse(inputSource);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("SAX parser appears to be broken - " + e.getMessage());
        }
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public void setCloseFilesystem(boolean z6) {
        this.doCloseFilesystem = z6;
    }

    public void setConcatenatePhoneticRuns(boolean z6) {
        this.concatenatePhoneticRuns = z6;
    }

    public void setFormulasNotResults(boolean z6) {
        this.formulasNotResults = z6;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeCellComments(boolean z6) {
        this.includeCellComments = z6;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeHeadersFooters(boolean z6) {
        this.includeHeadersFooters = z6;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeSheetNames(boolean z6) {
        this.includeSheetNames = z6;
    }

    public void setIncludeTextBoxes(boolean z6) {
        this.includeTextBoxes = z6;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public XSSFEventBasedExcelExtractor(OPCPackage oPCPackage) {
        this.includeTextBoxes = true;
        this.includeSheetNames = true;
        this.includeHeadersFooters = true;
        this.concatenatePhoneticRuns = true;
        this.doCloseFilesystem = true;
        this.container = oPCPackage;
        this.properties = new POIXMLProperties(oPCPackage);
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public OPCPackage getFilesystem() {
        return this.container;
    }
}
