package org.apache.poi.hssf.extractor;

import A3.AbstractC0157z;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.extractor.POITextExtractor;
import org.apache.poi.hssf.OldExcelFormatException;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.CodepageRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.OldFormulaRecord;
import org.apache.poi.hssf.record.OldLabelRecord;
import org.apache.poi.hssf.record.OldSheetRecord;
import org.apache.poi.hssf.record.OldStringRecord;
import org.apache.poi.hssf.record.RKRecord;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentNode;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.NotOLE2FileException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.util.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class OldExcelExtractor implements POITextExtractor {
    private static final int FILE_PASS_RECORD_SID = 47;
    private int biffVersion;
    private int fileType;
    private RecordInputStream ris;
    private Closeable toClose;

    public OldExcelExtractor(InputStream inputStream) {
        open(inputStream);
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length < 1) {
            System.err.println("Use:");
            System.err.println("   OldExcelExtractor <filename>");
            System.exit(1);
        }
        OldExcelExtractor oldExcelExtractor = new OldExcelExtractor(new File(strArr[0]));
        try {
            System.out.println(oldExcelExtractor.getText());
            oldExcelExtractor.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    oldExcelExtractor.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private void open(InputStream inputStream) {
        BufferedInputStream bufferedInputStream = inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, 8);
        if (FileMagic.valueOf(bufferedInputStream) != FileMagic.OLE2) {
            this.ris = new RecordInputStream(bufferedInputStream);
            this.toClose = bufferedInputStream;
            prepare();
            return;
        }
        POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem(bufferedInputStream);
        try {
            open(pOIFSFileSystem);
            this.toClose = pOIFSFileSystem;
        } catch (Throwable th) {
            if (this.toClose == null) {
                pOIFSFileSystem.close();
            }
            throw th;
        }
    }

    private void prepare() {
        if (!this.ris.hasNextRecord()) {
            throw new IllegalArgumentException("File contains no records!");
        }
        this.ris.nextRecord();
        short sid = this.ris.getSid();
        if (sid == 9) {
            this.biffVersion = 2;
        } else if (sid == 521) {
            this.biffVersion = 3;
        } else if (sid == 1033) {
            this.biffVersion = 4;
        } else {
            if (sid != 2057) {
                throw new IllegalArgumentException(AbstractC0157z.k(sid, "File does not begin with a BOF, found sid of "));
            }
            this.biffVersion = 5;
        }
        this.fileType = new BOFRecord(this.ris).getType();
    }

    public int getBiffVersion() {
        return this.biffVersion;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public Object getDocument() {
        return this.ris;
    }

    public int getFileType() {
        return this.fileType;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public Closeable getFilesystem() {
        return this.toClose;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public POITextExtractor getMetadataTextExtractor() {
        return new POITextExtractor() { // from class: org.apache.poi.hssf.extractor.OldExcelExtractor.1
            @Override // org.apache.poi.extractor.POITextExtractor
            public Object getDocument() {
                return OldExcelExtractor.this.ris;
            }

            @Override // org.apache.poi.extractor.POITextExtractor
            public Closeable getFilesystem() {
                return OldExcelExtractor.this.toClose;
            }

            @Override // org.apache.poi.extractor.POITextExtractor
            public POITextExtractor getMetadataTextExtractor() {
                throw new IllegalStateException("You already have the Metadata Text Extractor, not recursing!");
            }

            @Override // org.apache.poi.extractor.POITextExtractor
            public String getText() {
                return "";
            }

            @Override // org.apache.poi.extractor.POITextExtractor
            public boolean isCloseFilesystem() {
                return OldExcelExtractor.this.toClose != null;
            }

            @Override // org.apache.poi.extractor.POITextExtractor
            public void setCloseFilesystem(boolean z6) {
            }
        };
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public String getText() {
        StringBuilder sb = new StringBuilder();
        CodepageRecord codepageRecord = null;
        while (this.ris.hasNextRecord()) {
            int nextSid = this.ris.getNextSid();
            this.ris.nextRecord();
            if (nextSid != 4) {
                if (nextSid == 47) {
                    throw new EncryptedDocumentException("Encryption not supported for Old Excel files");
                }
                if (nextSid == 66) {
                    codepageRecord = new CodepageRecord(this.ris);
                } else if (nextSid == 133) {
                    OldSheetRecord oldSheetRecord = new OldSheetRecord(this.ris);
                    oldSheetRecord.setCodePage(codepageRecord);
                    sb.append("Sheet: ");
                    sb.append(oldSheetRecord.getSheetname());
                    sb.append('\n');
                } else if (nextSid != 638) {
                    if (nextSid != 1030 && nextSid != 6) {
                        if (nextSid != 7) {
                            if (nextSid == 515) {
                                handleNumericCell(sb, new NumberRecord(this.ris).getValue());
                            } else if (nextSid != 516) {
                                if (nextSid != 518) {
                                    if (nextSid != 519) {
                                        RecordInputStream recordInputStream = this.ris;
                                        recordInputStream.readFully(IOUtils.safelyAllocate(recordInputStream.remaining(), HSSFWorkbook.getMaxRecordLength()));
                                    }
                                }
                            }
                        }
                        OldStringRecord oldStringRecord = new OldStringRecord(this.ris);
                        oldStringRecord.setCodePage(codepageRecord);
                        sb.append(oldStringRecord.getString());
                        sb.append('\n');
                    }
                    if (this.biffVersion == 5) {
                        FormulaRecord formulaRecord = new FormulaRecord(this.ris);
                        if (formulaRecord.getCachedResultTypeEnum() == CellType.NUMERIC) {
                            handleNumericCell(sb, formulaRecord.getValue());
                        }
                    } else {
                        OldFormulaRecord oldFormulaRecord = new OldFormulaRecord(this.ris);
                        if (oldFormulaRecord.getCachedResultTypeEnum() == CellType.NUMERIC) {
                            handleNumericCell(sb, oldFormulaRecord.getValue());
                        }
                    }
                } else {
                    handleNumericCell(sb, new RKRecord(this.ris).getRKNumber());
                }
            }
            OldLabelRecord oldLabelRecord = new OldLabelRecord(this.ris);
            oldLabelRecord.setCodePage(codepageRecord);
            sb.append(oldLabelRecord.getValue());
            sb.append('\n');
        }
        this.ris = null;
        return sb.toString();
    }

    public void handleNumericCell(StringBuilder sb, double d) {
        sb.append(d);
        sb.append('\n');
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public boolean isCloseFilesystem() {
        return this.toClose != null;
    }

    public OldExcelExtractor(File file) throws Throwable {
        POIFSFileSystem pOIFSFileSystem = null;
        try {
            POIFSFileSystem pOIFSFileSystem2 = new POIFSFileSystem(file);
            try {
                open(pOIFSFileSystem2);
                this.toClose = pOIFSFileSystem2;
            } catch (OldExcelFormatException | NotOLE2FileException unused) {
                pOIFSFileSystem = pOIFSFileSystem2;
                if (this.toClose == null) {
                    IOUtils.closeQuietly(pOIFSFileSystem);
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    open(fileInputStream);
                } catch (IOException | RuntimeException e) {
                    fileInputStream.close();
                    this.toClose.close();
                    throw e;
                }
            } catch (Throwable th) {
                th = th;
                pOIFSFileSystem = pOIFSFileSystem2;
                if (this.toClose == null) {
                    IOUtils.closeQuietly(pOIFSFileSystem);
                }
                throw th;
            }
        } catch (OldExcelFormatException | NotOLE2FileException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void open(POIFSFileSystem pOIFSFileSystem) throws IOException {
        open(pOIFSFileSystem.getRoot());
    }

    private void open(DirectoryNode directoryNode) throws IOException {
        DocumentNode documentNode;
        try {
            documentNode = (DocumentNode) directoryNode.getEntry(InternalWorkbook.OLD_WORKBOOK_DIR_ENTRY_NAME);
        } catch (FileNotFoundException | IllegalArgumentException unused) {
            documentNode = (DocumentNode) directoryNode.getEntry(InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES.get(0));
        }
        if (documentNode != null) {
            this.ris = new RecordInputStream(directoryNode.createDocumentInputStream(documentNode));
            prepare();
            return;
        }
        throw new IOException("No Excel 5/95 Book stream found");
    }

    public OldExcelExtractor(POIFSFileSystem pOIFSFileSystem) throws IOException {
        this.toClose = pOIFSFileSystem;
        open(pOIFSFileSystem);
    }

    public OldExcelExtractor(DirectoryNode directoryNode) throws IOException {
        this.toClose = directoryNode.getFileSystem();
        open(directoryNode);
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public void setCloseFilesystem(boolean z6) {
    }
}
