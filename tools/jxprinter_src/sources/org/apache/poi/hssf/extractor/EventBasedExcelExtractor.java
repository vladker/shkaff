package org.apache.poi.hssf.extractor;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.POIDocument;
import org.apache.poi.extractor.POIOLE2TextExtractor;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.eventusermodel.FormatTrackingHSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
import org.apache.poi.hssf.eventusermodel.HSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.LabelRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.NoteRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.hssf.record.StringRecord;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EventBasedExcelExtractor implements POIOLE2TextExtractor, org.apache.poi.ss.extractor.ExcelExtractor {
    private final DirectoryNode _dir;
    boolean _formulasNotResults;
    boolean _includeSheetNames;
    private boolean doCloseFilesystem;
    private final POIFSFileSystem poifs;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class TextListener implements HSSFListener {
        FormatTrackingHSSFListener _ft;
        private boolean outputNextStringValue;
        private int rowNum;
        private SSTRecord sstRecord;
        final StringBuilder _text = new StringBuilder();
        private int sheetNum = -1;
        private int nextRow = -1;
        private final List<String> sheetNames = new ArrayList();

        public TextListener() {
        }

        @Override // org.apache.poi.hssf.eventusermodel.HSSFListener
        public void processRecord(Record record) {
            int row;
            short sid = record.getSid();
            String numberDateCell = null;
            if (sid == 6) {
                FormulaRecord formulaRecord = (FormulaRecord) record;
                row = formulaRecord.getRow();
                if (EventBasedExcelExtractor.this._formulasNotResults) {
                    numberDateCell = HSSFFormulaParser.toFormulaString(null, formulaRecord.getParsedExpression());
                } else if (formulaRecord.hasCachedResultString()) {
                    this.outputNextStringValue = true;
                    this.nextRow = formulaRecord.getRow();
                } else {
                    numberDateCell = this._ft.formatNumberDateCell(formulaRecord);
                }
            } else if (sid != 28) {
                row = -1;
                if (sid == 133) {
                    this.sheetNames.add(((BoundSheetRecord) record).getSheetname());
                } else if (sid != 519) {
                    if (sid != 2057) {
                        if (sid == 252) {
                            this.sstRecord = (SSTRecord) record;
                        } else if (sid == 253) {
                            LabelSSTRecord labelSSTRecord = (LabelSSTRecord) record;
                            row = labelSSTRecord.getRow();
                            SSTRecord sSTRecord = this.sstRecord;
                            if (sSTRecord == null) {
                                throw new IllegalStateException("No SST record found");
                            }
                            numberDateCell = sSTRecord.getString(labelSSTRecord.getSSTIndex()).toString();
                        } else if (sid == 515) {
                            NumberRecord numberRecord = (NumberRecord) record;
                            row = numberRecord.getRow();
                            numberDateCell = this._ft.formatNumberDateCell(numberRecord);
                        } else if (sid == 516) {
                            LabelRecord labelRecord = (LabelRecord) record;
                            row = labelRecord.getRow();
                            numberDateCell = labelRecord.getValue();
                        }
                    } else if (((BOFRecord) record).getType() == 16) {
                        this.sheetNum++;
                        this.rowNum = -1;
                        if (EventBasedExcelExtractor.this._includeSheetNames) {
                            if (this._text.length() > 0) {
                                this._text.append("\n");
                            }
                            this._text.append(this.sheetNames.get(this.sheetNum));
                        }
                    }
                } else if (this.outputNextStringValue) {
                    numberDateCell = ((StringRecord) record).getString();
                    row = this.nextRow;
                    this.outputNextStringValue = false;
                }
            } else {
                row = ((NoteRecord) record).getRow();
            }
            if (numberDateCell != null) {
                if (row != this.rowNum) {
                    this.rowNum = row;
                    if (this._text.length() > 0) {
                        this._text.append("\n");
                    }
                } else {
                    this._text.append("\t");
                }
                this._text.append(numberDateCell);
            }
        }
    }

    public EventBasedExcelExtractor(DirectoryNode directoryNode) {
        this.doCloseFilesystem = true;
        this._includeSheetNames = true;
        this.poifs = null;
        this._dir = directoryNode;
    }

    private TextListener triggerExtraction() {
        TextListener textListener = new TextListener();
        FormatTrackingHSSFListener formatTrackingHSSFListener = new FormatTrackingHSSFListener(textListener);
        textListener._ft = formatTrackingHSSFListener;
        HSSFEventFactory hSSFEventFactory = new HSSFEventFactory();
        HSSFRequest hSSFRequest = new HSSFRequest();
        hSSFRequest.addListenerForAllRecords(formatTrackingHSSFListener);
        hSSFEventFactory.processWorkbookEvents(hSSFRequest, this._dir);
        return textListener;
    }

    @Override // org.apache.poi.extractor.POITextExtractor, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        DirectoryEntry root = getRoot();
        if (root instanceof DirectoryNode) {
            POIFSFileSystem fileSystem = ((DirectoryNode) root).getFileSystem();
            if (!isCloseFilesystem() || fileSystem == null) {
                return;
            }
            fileSystem.close();
        }
    }

    @Override // org.apache.poi.extractor.POIOLE2TextExtractor
    public DocumentSummaryInformation getDocSummaryInformation() {
        throw new IllegalStateException("Metadata extraction not supported in streaming mode, please use ExcelExtractor");
    }

    @Override // org.apache.poi.extractor.POIOLE2TextExtractor, org.apache.poi.extractor.POITextExtractor
    public POIDocument getDocument() {
        return null;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public Closeable getFilesystem() {
        return this.poifs;
    }

    @Override // org.apache.poi.extractor.POIOLE2TextExtractor
    public DirectoryEntry getRoot() {
        return this._dir;
    }

    @Override // org.apache.poi.extractor.POIOLE2TextExtractor
    public SummaryInformation getSummaryInformation() {
        throw new IllegalStateException("Metadata extraction not supported in streaming mode, please use ExcelExtractor");
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public String getText() {
        try {
            String string = triggerExtraction()._text.toString();
            return !string.endsWith("\n") ? string.concat("\n") : string;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        this._formulasNotResults = z6;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeCellComments(boolean z6) {
        throw new IllegalStateException("Comment extraction not supported in streaming mode, please use ExcelExtractor");
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeHeadersFooters(boolean z6) {
        throw new IllegalStateException("Header/Footer extraction not supported in streaming mode, please use ExcelExtractor");
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeSheetNames(boolean z6) {
        this._includeSheetNames = z6;
    }

    public EventBasedExcelExtractor(POIFSFileSystem pOIFSFileSystem) {
        this.doCloseFilesystem = true;
        this._includeSheetNames = true;
        this.poifs = pOIFSFileSystem;
        this._dir = pOIFSFileSystem.getRoot();
    }
}
