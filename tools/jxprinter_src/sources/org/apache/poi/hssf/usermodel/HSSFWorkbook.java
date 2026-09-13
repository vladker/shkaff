package org.apache.poi.hssf.usermodel;

import A3.AbstractC0157z;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.regex.Pattern;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.POIDocument;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherBitmapBlip;
import org.apache.poi.ddf.EscherBlipRecord;
import org.apache.poi.ddf.EscherMetafileBlip;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.hpsf.ClassIDPredefined;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.OldExcelFormatException;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.model.InternalSheet;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.model.WorkbookRecordList;
import org.apache.poi.hssf.record.AbstractEscherHolderRecord;
import org.apache.poi.hssf.record.DrawingGroupRecord;
import org.apache.poi.hssf.record.FilePassRecord;
import org.apache.poi.hssf.record.LabelRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.NameRecord;
import org.apache.poi.hssf.record.RecalcIdRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;
import org.apache.poi.hssf.record.RecordFactory;
import org.apache.poi.hssf.record.RefModeRecord;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.hssf.record.UnknownRecord;
import org.apache.poi.hssf.record.aggregates.RecordAggregate;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.hssf.record.crypto.Biff8DecryptingStream;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.poifs.crypt.ChunkedCipherOutputStream;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentNode;
import org.apache.poi.poifs.filesystem.EntryUtils;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.FilteringDirectoryNode;
import org.apache.poi.poifs.filesystem.Ole10Native;
import org.apache.poi.poifs.filesystem.POIFSDocument;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.formula.udf.AggregatingUDFFinder;
import org.apache.poi.ss.formula.udf.IndexedUDFFinder;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.CellReferenceType;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Shape;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetVisibility;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Configurator;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFWorkbook extends POIDocument implements Workbook {
    private static final int DEFAULT_MAX_IMAGE_LENGTH = 50000000;
    private static final int DEFAULT_MAX_RECORD_LENGTH = 100000;
    private static int MAX_IMAGE_LENGTH = 50000000;
    private static int MAX_RECORD_LENGTH = 100000;
    private static final int MAX_STYLES = 4030;
    protected List<HSSFSheet> _sheets;
    private final UDFFinder _udfFinder;
    private Map<Integer, HSSFFont> fonts;
    private HSSFDataFormat formatter;
    private Row.MissingCellPolicy missingCellPolicy;
    private final ArrayList<HSSFName> names;
    private boolean preserveNodes;
    private InternalWorkbook workbook;
    private static final Pattern COMMA_PATTERN = Pattern.compile(",");
    public static final int INITIAL_CAPACITY = Configurator.getIntValue("HSSFWorkbook.SheetInitialCapacity", 3);
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) HSSFWorkbook.class);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class SheetIterator<T extends Sheet> implements Iterator<T> {
        private final Iterator<T> it;

        public SheetIterator() {
            this.it = HSSFWorkbook.this._sheets.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.it.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove method not supported on HSSFWorkbook.iterator(). Use Sheet.removeSheetAt(int) instead.");
        }

        @Override // java.util.Iterator
        public T next() {
            return this.it.next();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SheetRecordCollector implements RecordAggregate.RecordVisitor {
        private int _totalSize = 0;
        private final List<Record> _list = new ArrayList(128);

        public int getTotalSize() {
            return this._totalSize;
        }

        public int serialize(int i5, byte[] bArr) {
            Iterator<Record> it = this._list.iterator();
            int iSerialize = 0;
            while (it.hasNext()) {
                iSerialize += it.next().serialize(i5 + iSerialize, bArr);
            }
            return iSerialize;
        }

        @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate.RecordVisitor
        public void visitRecord(Record record) {
            this._list.add(record);
            this._totalSize = record.getRecordSize() + this._totalSize;
        }
    }

    public HSSFWorkbook() {
        this(InternalWorkbook.createWorkbook());
    }

    private void convertLabelRecords(List<Record> list, int i5) {
        LOGGER.atDebug().log("convertLabelRecords called");
        while (i5 < list.size()) {
            Record record = list.get(i5);
            if (record.getSid() == 516) {
                LabelRecord labelRecord = (LabelRecord) record;
                list.remove(i5);
                LabelSSTRecord labelSSTRecord = new LabelSSTRecord();
                int iAddSSTString = this.workbook.addSSTString(new UnicodeString(labelRecord.getValue()));
                labelSSTRecord.setRow(labelRecord.getRow());
                labelSSTRecord.setColumn(labelRecord.getColumn());
                labelSSTRecord.setXFIndex(labelRecord.getXFIndex());
                labelSSTRecord.setSSTIndex(iAddSSTString);
                list.add(i5, labelSSTRecord);
            }
            i5++;
        }
        LOGGER.atDebug().log("convertLabelRecords exit");
    }

    public static HSSFWorkbook create(InternalWorkbook internalWorkbook) {
        return new HSSFWorkbook(internalWorkbook);
    }

    public static int getMaxImageLength() {
        return MAX_IMAGE_LENGTH;
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    public static Map<String, ClassID> getOleMap() {
        HashMap map = new HashMap();
        map.put("PowerPoint Document", ClassIDPredefined.POWERPOINT_V8.getClassID());
        Iterator<String> it = InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES.iterator();
        while (it.hasNext()) {
            map.put(it.next(), ClassIDPredefined.EXCEL_V7_WORKBOOK.getClassID());
        }
        return map;
    }

    private HSSFSheet[] getSheets() {
        HSSFSheet[] hSSFSheetArr = new HSSFSheet[this._sheets.size()];
        this._sheets.toArray(hSSFSheetArr);
        return hSSFSheetArr;
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
            if (this.workbook.getSheetIndex(strR) == -1) {
                return strR;
            }
            i5 = i6;
        }
    }

    public static String getWorkbookDirEntryName(DirectoryNode directoryNode) {
        for (String str : InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES) {
            if (directoryNode.hasEntry(str)) {
                return str;
            }
        }
        if (directoryNode.hasEntry(Decryptor.DEFAULT_POIFS_ENTRY)) {
            throw new EncryptedDocumentException("The supplied spreadsheet seems to be an Encrypted .xlsx file. It must be decrypted before use by XSSF, it cannot be used by HSSF");
        }
        if (directoryNode.hasEntry(InternalWorkbook.OLD_WORKBOOK_DIR_ENTRY_NAME)) {
            throw new OldExcelFormatException("The supplied spreadsheet seems to be Excel 5.0/7.0 (BIFF5) format. POI only supports BIFF8 format (from Excel versions 97/2000/XP/2003)");
        }
        if (directoryNode.hasEntry("WordDocument")) {
            throw new IllegalArgumentException("The document is really a DOC file");
        }
        throw new IllegalArgumentException("The supplied POIFSFileSystem does not contain a BIFF8 'Workbook' entry. Is it really an excel file? Had: " + directoryNode.getEntryNames());
    }

    private void searchForPictures(List<EscherRecord> list, List<HSSFPictureData> list2) {
        EscherBlipRecord blipRecord;
        for (EscherRecord escherRecord : list) {
            if ((escherRecord instanceof EscherBSERecord) && (blipRecord = ((EscherBSERecord) escherRecord).getBlipRecord()) != null) {
                list2.add(new HSSFPictureData(blipRecord));
            }
            searchForPictures(escherRecord.getChildRecords(), list2);
        }
    }

    public static void setMaxImageLength(int i5) {
        MAX_IMAGE_LENGTH = i5;
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    private void setPropertiesFromWorkbook(InternalWorkbook internalWorkbook) {
        this.workbook = internalWorkbook;
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

    private void updateEncryptionInfo() {
        readProperties();
        FilePassRecord filePassRecord = (FilePassRecord) this.workbook.findFirstRecordBySid((short) 47);
        String currentUserPassword = Biff8EncryptionKey.getCurrentUserPassword();
        WorkbookRecordList workbookRecordList = this.workbook.getWorkbookRecordList();
        if (currentUserPassword == null) {
            if (filePassRecord != null) {
                workbookRecordList.remove(filePassRecord);
                return;
            }
            return;
        }
        if (filePassRecord == null) {
            filePassRecord = new FilePassRecord(EncryptionMode.cryptoAPI);
            workbookRecordList.add(1, filePassRecord);
        }
        EncryptionInfo encryptionInfo = filePassRecord.getEncryptionInfo();
        EncryptionVerifier verifier = encryptionInfo.getVerifier();
        byte[] encryptedVerifier = verifier.getEncryptedVerifier();
        Decryptor decryptor = encryptionInfo.getDecryptor();
        Encryptor encryptor = encryptionInfo.getEncryptor();
        if (encryptedVerifier != null) {
            try {
                if (decryptor.verifyPassword(currentUserPassword)) {
                    encryptor.confirmPassword(currentUserPassword, null, null, decryptor.getVerifier(), verifier.getSalt(), null);
                    return;
                }
            } catch (GeneralSecurityException e) {
                throw new EncryptedDocumentException("can't validate/update encryption setting", e);
            }
        }
        encryptor.confirmPassword(currentUserPassword);
    }

    private void updateNamedRangesAfterSheetReorder(int i5, int i6) {
        ArrayList<HSSFName> arrayList = this.names;
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size) {
            HSSFName hSSFName = arrayList.get(i7);
            i7++;
            HSSFName hSSFName2 = hSSFName;
            int sheetIndex = hSSFName2.getSheetIndex();
            if (sheetIndex != -1) {
                if (sheetIndex == i5) {
                    hSSFName2.setSheetIndex(i6);
                } else if (i6 <= sheetIndex && sheetIndex < i5) {
                    hSSFName2.setSheetIndex(sheetIndex + 1);
                } else if (i5 < sheetIndex && sheetIndex <= i6) {
                    hSSFName2.setSheetIndex(sheetIndex - 1);
                }
            }
        }
    }

    private void validateSheetIndex(int i5) {
        int size = this._sheets.size() - 1;
        if (i5 < 0 || i5 > size) {
            String strI = androidx.collection.a.i(size, "(0..", ")");
            if (size == -1) {
                strI = "(no sheets)";
            }
            throw new IllegalArgumentException("Sheet index (" + i5 + ") is out of range " + strI);
        }
    }

    public int addOlePackage(POIFSFileSystem pOIFSFileSystem, String str, String str2, String str3) {
        DirectoryNode root = pOIFSFileSystem.getRoot();
        for (Map.Entry<String, ClassID> entry : getOleMap().entrySet()) {
            if (root.hasEntry(entry.getKey())) {
                root.setStorageClsid(entry.getValue());
                break;
            }
        }
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
        try {
            pOIFSFileSystem.writeFilesystem(unsynchronizedByteArrayOutputStream);
            int iAddOlePackage = addOlePackage(unsynchronizedByteArrayOutputStream.toByteArray(), str, str2, str3);
            unsynchronizedByteArrayOutputStream.close();
            return iAddOlePackage;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    unsynchronizedByteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // org.apache.poi.ss.usermodel.Workbook
    public int addPicture(byte[] bArr, int i5) {
        int compressedSize;
        short s6;
        EscherBlipRecord escherBlipRecord;
        initDrawings();
        byte[] bArrMd5 = DigestUtils.md5(bArr);
        if (i5 == 2) {
            EscherMetafileBlip escherMetafileBlip = new EscherMetafileBlip();
            escherMetafileBlip.setUID(bArrMd5);
            escherMetafileBlip.setPictureData(bArr);
            escherMetafileBlip.setFilter((byte) -2);
            compressedSize = escherMetafileBlip.getCompressedSize() + 58;
            s6 = 0;
            escherBlipRecord = escherMetafileBlip;
        } else if (i5 != 3) {
            EscherBitmapBlip escherBitmapBlip = new EscherBitmapBlip();
            escherBitmapBlip.setUID(bArrMd5);
            escherBitmapBlip.setMarker((byte) -1);
            escherBitmapBlip.setPictureData(bArr);
            compressedSize = bArr.length + 25;
            s6 = 255;
            escherBlipRecord = escherBitmapBlip;
        } else {
            if (FileMagic.valueOf(bArr) == FileMagic.WMF) {
                bArr = IOUtils.safelyClone(bArr, 22, bArr.length - 22, MAX_IMAGE_LENGTH);
            }
            EscherMetafileBlip escherMetafileBlip2 = new EscherMetafileBlip();
            escherMetafileBlip2.setUID(bArrMd5);
            escherMetafileBlip2.setPictureData(bArr);
            escherMetafileBlip2.setFilter((byte) -2);
            compressedSize = escherMetafileBlip2.getCompressedSize() + 58;
            s6 = 0;
            escherBlipRecord = escherMetafileBlip2;
        }
        escherBlipRecord.setRecordId((short) (EscherBlipRecord.RECORD_ID_START + i5));
        switch (i5) {
            case 2:
                escherBlipRecord.setOptions(HSSFPictureData.MSOBI_EMF);
                break;
            case 3:
                escherBlipRecord.setOptions(HSSFPictureData.MSOBI_WMF);
                break;
            case 4:
                escherBlipRecord.setOptions(HSSFPictureData.MSOBI_PICT);
                break;
            case 5:
                escherBlipRecord.setOptions(HSSFPictureData.MSOBI_JPEG);
                break;
            case 6:
                escherBlipRecord.setOptions(HSSFPictureData.MSOBI_PNG);
                break;
            case 7:
                escherBlipRecord.setOptions(HSSFPictureData.MSOBI_DIB);
                break;
            default:
                throw new IllegalStateException(AbstractC0157z.k(i5, "Unexpected picture format: "));
        }
        EscherBSERecord escherBSERecord = new EscherBSERecord();
        escherBSERecord.setRecordId(EscherBSERecord.RECORD_ID);
        escherBSERecord.setOptions((short) (2 | (i5 << 4)));
        byte b = (byte) i5;
        escherBSERecord.setBlipTypeMacOS(b);
        escherBSERecord.setBlipTypeWin32(b);
        escherBSERecord.setUid(bArrMd5);
        escherBSERecord.setTag(s6);
        escherBSERecord.setSize(compressedSize);
        escherBSERecord.setRef(0);
        escherBSERecord.setOffset(0);
        escherBSERecord.setBlipRecord(escherBlipRecord);
        return this.workbook.addBSERecord(escherBSERecord);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void addToolPack(UDFFinder uDFFinder) {
        ((AggregatingUDFFinder) this._udfFinder).add(uDFFinder);
    }

    public boolean changeExternalReference(String str, String str2) {
        return this.workbook.changeExternalReference(str, str2);
    }

    @Override // org.apache.poi.POIDocument, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
    }

    public HSSFName createBuiltInName(byte b, int i5) {
        HSSFName hSSFName = new HSSFName(this, this.workbook.createBuiltInName(b, i5 + 1), null);
        this.names.add(hSSFName);
        return hSSFName;
    }

    public void dumpDrawingGroupRecords(boolean z6) {
        DrawingGroupRecord drawingGroupRecord = (DrawingGroupRecord) this.workbook.findFirstRecordBySid(DrawingGroupRecord.sid);
        if (drawingGroupRecord == null) {
            return;
        }
        drawingGroupRecord.decode();
        List<EscherRecord> escherRecords = drawingGroupRecord.getEscherRecords();
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out, Charset.defaultCharset()));
        for (EscherRecord escherRecord : escherRecords) {
            if (z6) {
                System.out.println(escherRecord);
            } else {
                escherRecord.display(printWriter, 0);
            }
        }
        printWriter.flush();
    }

    public void encryptBytes(byte[] bArr) {
        EncryptionInfo encryptionInfo = getEncryptionInfo();
        if (encryptionInfo == null) {
            return;
        }
        Encryptor encryptor = encryptionInfo.getEncryptor();
        LittleEndianByteArrayInputStream littleEndianByteArrayInputStream = new LittleEndianByteArrayInputStream(bArr, 0);
        LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(bArr, 0);
        encryptor.setChunkSize(1024);
        byte[] bArr2 = new byte[1024];
        try {
            ChunkedCipherOutputStream dataStream = encryptor.getDataStream(littleEndianByteArrayOutputStream, 0);
            int i5 = 0;
            while (i5 < bArr.length) {
                IOUtils.readFully(littleEndianByteArrayInputStream, bArr2, 0, 4);
                int uShort = LittleEndian.getUShort(bArr2, 0);
                int uShort2 = LittleEndian.getUShort(bArr2, 2);
                boolean zIsNeverEncryptedRecord = Biff8DecryptingStream.isNeverEncryptedRecord(uShort);
                dataStream.setNextRecordSize(uShort2, zIsNeverEncryptedRecord);
                dataStream.writePlain(bArr2, 0, 4);
                if (uShort == 133) {
                    byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(uShort2, MAX_RECORD_LENGTH);
                    littleEndianByteArrayInputStream.readFully(bArrSafelyAllocate);
                    dataStream.writePlain(bArrSafelyAllocate, 0, 4);
                    dataStream.write(bArrSafelyAllocate, 4, uShort2 - 4);
                } else {
                    int i6 = uShort2;
                    while (i6 > 0) {
                        int iMin = Math.min(i6, 1024);
                        littleEndianByteArrayInputStream.readFully(bArr2, 0, iMin);
                        if (zIsNeverEncryptedRecord) {
                            dataStream.writePlain(bArr2, 0, iMin);
                        } else {
                            dataStream.write(bArr2, 0, iMin);
                        }
                        i6 -= iMin;
                    }
                }
                i5 += uShort2 + 4;
            }
            dataStream.close();
        } catch (Exception e) {
            throw new EncryptedDocumentException(e);
        }
    }

    public int findExistingBuiltinNameRecordIdx(int i5, byte b) {
        for (int i6 = 0; i6 < this.names.size(); i6++) {
            NameRecord nameRecord = this.workbook.getNameRecord(i6);
            if (nameRecord == null) {
                throw new RuntimeException("Unable to find all defined names to iterate over");
            }
            if (nameRecord.isBuiltInName() && nameRecord.getBuiltInName() == b && nameRecord.getSheetNumber() - 1 == i5) {
                return i6;
            }
        }
        return -1;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getActiveSheetIndex() {
        return this.workbook.getWindowOne().getActiveSheetIndex();
    }

    public List<HSSFObjectData> getAllEmbeddedObjects() {
        ArrayList arrayList = new ArrayList();
        Iterator<HSSFSheet> it = this._sheets.iterator();
        while (it.hasNext()) {
            getAllEmbeddedObjects(it.next(), arrayList);
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<HSSFName> getAllNames() {
        return Collections.unmodifiableList(this.names);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<HSSFPictureData> getAllPictures() {
        ArrayList arrayList = new ArrayList();
        for (Record record : this.workbook.getRecords()) {
            if (record instanceof AbstractEscherHolderRecord) {
                AbstractEscherHolderRecord abstractEscherHolderRecord = (AbstractEscherHolderRecord) record;
                abstractEscherHolderRecord.decode();
                searchForPictures(abstractEscherHolderRecord.getEscherRecords(), arrayList);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public boolean getBackupFlag() {
        return this.workbook.getBackupRecord().getBackup() != 0;
    }

    public HSSFName getBuiltInName(byte b, int i5) {
        int iFindExistingBuiltinNameRecordIdx = findExistingBuiltinNameRecordIdx(i5, b);
        if (iFindExistingBuiltinNameRecordIdx < 0) {
            return null;
        }
        return this.names.get(iFindExistingBuiltinNameRecordIdx);
    }

    public byte[] getBytes() {
        LOGGER.atDebug().log("HSSFWorkbook.getBytes()");
        HSSFSheet[] sheets = getSheets();
        int length = sheets.length;
        updateEncryptionInfo();
        this.workbook.preSerialize();
        for (HSSFSheet hSSFSheet : sheets) {
            hSSFSheet.getSheet().preSerialize();
            hSSFSheet.preSerialize();
        }
        int size = this.workbook.getSize();
        SheetRecordCollector[] sheetRecordCollectorArr = new SheetRecordCollector[length];
        for (int i5 = 0; i5 < length; i5++) {
            this.workbook.setSheetBof(i5, size);
            SheetRecordCollector sheetRecordCollector = new SheetRecordCollector();
            sheets[i5].getSheet().visitContainedRecords(sheetRecordCollector, size);
            size += sheetRecordCollector.getTotalSize();
            sheetRecordCollectorArr[i5] = sheetRecordCollector;
        }
        byte[] bArr = new byte[size];
        int iSerialize = this.workbook.serialize(0, bArr);
        for (int i6 = 0; i6 < length; i6++) {
            SheetRecordCollector sheetRecordCollector2 = sheetRecordCollectorArr[i6];
            int iSerialize2 = sheetRecordCollector2.serialize(iSerialize, bArr);
            if (iSerialize2 != sheetRecordCollector2.getTotalSize()) {
                StringBuilder sbT = AbstractC0157z.t(iSerialize2, "Actual serialized sheet size (", ") differs from pre-calculated size (");
                sbT.append(sheetRecordCollector2.getTotalSize());
                sbT.append(") for sheet (");
                sbT.append(i6);
                sbT.append(")");
                throw new IllegalStateException(sbT.toString());
            }
            iSerialize += iSerialize2;
        }
        encryptBytes(bArr);
        return bArr;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public CellReferenceType getCellReferenceType() {
        RefModeRecord refModeRecord;
        Iterator<HSSFSheet> it = this._sheets.iterator();
        while (it.hasNext()) {
            Iterator<RecordBase> it2 = it.next().getSheet().getRecords().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    refModeRecord = null;
                    break;
                }
                RecordBase next = it2.next();
                if (next instanceof RefModeRecord) {
                    refModeRecord = (RefModeRecord) next;
                    break;
                }
            }
            if (refModeRecord != null) {
                if (refModeRecord.getMode() == 0) {
                    return CellReferenceType.R1C1;
                }
                if (refModeRecord.getMode() == 1) {
                    return CellReferenceType.A1;
                }
            }
        }
        return CellReferenceType.UNKNOWN;
    }

    public HSSFPalette getCustomPalette() {
        return new HSSFPalette(this.workbook.getCustomPalette());
    }

    @Override // org.apache.poi.POIDocument
    public EncryptionInfo getEncryptionInfo() {
        FilePassRecord filePassRecord = (FilePassRecord) this.workbook.findFirstRecordBySid((short) 47);
        if (filePassRecord != null) {
            return filePassRecord.getEncryptionInfo();
        }
        return null;
    }

    public EncryptionMode getEncryptionMode() {
        FilePassRecord filePassRecord = (FilePassRecord) getInternalWorkbook().findFirstRecordBySid((short) 47);
        if (filePassRecord == null) {
            return null;
        }
        return filePassRecord.getEncryptionInfo().getEncryptionMode();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getFirstVisibleTab() {
        return this.workbook.getWindowOne().getFirstVisibleTab();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean getForceFormulaRecalculation() {
        RecalcIdRecord recalcIdRecord = (RecalcIdRecord) getWorkbook().findFirstRecordBySid(RecalcIdRecord.sid);
        return (recalcIdRecord == null || recalcIdRecord.getEngineId() == 0) ? false : true;
    }

    @Internal
    public InternalWorkbook getInternalWorkbook() {
        return this.workbook;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Row.MissingCellPolicy getMissingCellPolicy() {
        return this.missingCellPolicy;
    }

    public HSSFName getNameAt(int i5) {
        int size = this.names.size();
        if (size < 1) {
            throw new IllegalStateException("There are no defined names in this workbook");
        }
        if (i5 >= 0 && i5 <= size) {
            return this.names.get(i5);
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Specified name index ", " is outside the allowable range (0..");
        sbT.append(size - 1);
        sbT.append(").");
        throw new IllegalArgumentException(sbT.toString());
    }

    public int getNameIndex(String str) {
        for (int i5 = 0; i5 < this.names.size(); i5++) {
            if (getNameName(i5).equalsIgnoreCase(str)) {
                return i5;
            }
        }
        return -1;
    }

    public String getNameName(int i5) {
        return getNameAt(i5).getNameName();
    }

    public NameRecord getNameRecord(int i5) {
        return getWorkbook().getNameRecord(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<HSSFName> getNames(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList<HSSFName> arrayList2 = this.names;
        int size = arrayList2.size();
        int i5 = 0;
        while (i5 < size) {
            HSSFName hSSFName = arrayList2.get(i5);
            i5++;
            HSSFName hSSFName2 = hSSFName;
            if (hSSFName2.getNameName().equals(str)) {
                arrayList.add(hSSFName2);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumCellStyles() {
        return this.workbook.getNumExFormats();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfFonts() {
        return this.workbook.getNumberOfFontRecords();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @Removal(version = "6.0.0")
    @Deprecated
    public int getNumberOfFontsAsInt() {
        return getNumberOfFonts();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfNames() {
        return this.names.size();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfSheets() {
        return this._sheets.size();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public String getPrintArea(int i5) {
        NameRecord specificBuiltinRecord = this.workbook.getSpecificBuiltinRecord((byte) 6, i5 + 1);
        if (specificBuiltinRecord == null) {
            return null;
        }
        return HSSFFormulaParser.toFormulaString(this, specificBuiltinRecord.getNameDefinition());
    }

    public Collection<Integer> getSelectedTabs() {
        ArrayList arrayList = new ArrayList();
        int size = this._sheets.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (getSheetAt(i5).isSelected()) {
                arrayList.add(Integer.valueOf(i5));
            }
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getSheetIndex(String str) {
        return this.workbook.getSheetIndex(str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public String getSheetName(int i5) {
        validateSheetIndex(i5);
        return this.workbook.getSheetName(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SheetVisibility getSheetVisibility(int i5) {
        return this.workbook.getSheetVisibility(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SpreadsheetVersion getSpreadsheetVersion() {
        return SpreadsheetVersion.EXCEL97;
    }

    public UDFFinder getUDFFinder() {
        return this._udfFinder;
    }

    @Internal
    public InternalWorkbook getWorkbook() {
        return this.workbook;
    }

    public void initDrawings() {
        if (this.workbook.findDrawingGroup() == null) {
            this.workbook.createDrawingGroup();
            return;
        }
        Iterator<HSSFSheet> it = this._sheets.iterator();
        while (it.hasNext()) {
            it.next().getDrawingPatriarch();
        }
    }

    public void insertChartRecord() {
        this.workbook.getRecords().add(this.workbook.findFirstRecordLocBySid(SSTRecord.sid), new UnknownRecord(235, new byte[]{15, 0, 0, -16, 82, 0, 0, 0, 0, 0, 6, -16, Ascii.CAN, 0, 0, 0, 1, 8, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, TarConstants.LF_CHR, 0, 11, -16, 18, 0, 0, 0, -65, 0, 8, 0, 8, 0, -127, 1, 9, 0, 0, 8, -64, 1, 64, 0, 0, 8, 64, 0, 30, -15, 16, 0, 0, 0, 13, 0, 0, 8, 12, 0, 0, 8, 23, 0, 0, 8, -9, 0, 0, 16}));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isHidden() {
        return this.workbook.getWindowOne().getHidden();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isSheetHidden(int i5) {
        validateSheetIndex(i5);
        return this.workbook.isSheetHidden(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isSheetVeryHidden(int i5) {
        validateSheetIndex(i5);
        return this.workbook.isSheetVeryHidden(i5);
    }

    public boolean isWriteProtected() {
        return this.workbook.isWriteProtected();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int linkExternalWorkbook(String str, Workbook workbook) {
        return this.workbook.linkExternalWorkbook(str, workbook);
    }

    public void removeName(int i5) {
        this.names.remove(i5);
        this.workbook.removeName(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removePrintArea(int i5) {
        getWorkbook().removeBuiltinRecord((byte) 6, i5 + 1);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeSheetAt(int i5) {
        validateSheetIndex(i5);
        boolean zIsSelected = getSheetAt(i5).isSelected();
        this._sheets.remove(i5);
        this.workbook.removeSheet(i5);
        int size = this._sheets.size();
        if (size < 1) {
            return;
        }
        int i6 = i5 >= size ? size - 1 : i5;
        if (zIsSelected) {
            int i7 = 0;
            while (true) {
                if (i7 >= size) {
                    setSelectedTab(i6);
                    break;
                } else if (getSheetAt(i7).isSelected()) {
                    break;
                } else {
                    i7++;
                }
            }
        }
        int activeSheetIndex = getActiveSheetIndex();
        if (activeSheetIndex == i5) {
            setActiveSheet(i6);
        } else if (activeSheetIndex > i5) {
            setActiveSheet(activeSheetIndex - 1);
        }
    }

    public void resetFontCache() {
        this.fonts = new HashMap();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setActiveSheet(int i5) {
        validateSheetIndex(i5);
        int size = this._sheets.size();
        int i6 = 0;
        while (i6 < size) {
            getSheetAt(i6).setActive(i6 == i5);
            i6++;
        }
        this.workbook.getWindowOne().setActiveSheetIndex(i5);
    }

    public void setBackupFlag(boolean z6) {
        this.workbook.getBackupRecord().setBackup(z6 ? (short) 1 : (short) 0);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setCellReferenceType(CellReferenceType cellReferenceType) {
        RefModeRecord refModeRecord;
        Iterator<HSSFSheet> it = this._sheets.iterator();
        while (it.hasNext()) {
            List<RecordBase> records = it.next().getSheet().getRecords();
            Iterator<RecordBase> it2 = records.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    refModeRecord = null;
                    break;
                }
                RecordBase next = it2.next();
                if (next instanceof RefModeRecord) {
                    refModeRecord = (RefModeRecord) next;
                    break;
                }
            }
            if (cellReferenceType == CellReferenceType.R1C1) {
                if (refModeRecord == null) {
                    refModeRecord = new RefModeRecord();
                    records.add(records.size() - 1, refModeRecord);
                }
                refModeRecord.setMode((short) 0);
            } else if (cellReferenceType == CellReferenceType.A1) {
                if (refModeRecord == null) {
                    refModeRecord = new RefModeRecord();
                    records.add(records.size() - 1, refModeRecord);
                }
                refModeRecord.setMode((short) 1);
            } else if (refModeRecord != null) {
                records.remove(refModeRecord);
            }
        }
    }

    public void setEncryptionMode(EncryptionMode encryptionMode) {
        if (encryptionMode == null) {
            Biff8EncryptionKey.setCurrentUserPassword(null);
            return;
        }
        if (encryptionMode != EncryptionMode.xor && encryptionMode != EncryptionMode.binaryRC4 && encryptionMode != EncryptionMode.cryptoAPI) {
            throw new IllegalArgumentException("Only xor, binaryRC4 and cryptoAPI are supported.");
        }
        FilePassRecord filePassRecord = (FilePassRecord) getInternalWorkbook().findFirstRecordBySid((short) 47);
        if (encryptionMode == (filePassRecord != null ? filePassRecord.getEncryptionInfo().getEncryptionMode() : null)) {
            return;
        }
        readProperties();
        WorkbookRecordList workbookRecordList = getInternalWorkbook().getWorkbookRecordList();
        if (filePassRecord != null) {
            workbookRecordList.remove(filePassRecord);
        }
        workbookRecordList.add(1, new FilePassRecord(encryptionMode));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setFirstVisibleTab(int i5) {
        this.workbook.getWindowOne().setFirstVisibleTab(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setForceFormulaRecalculation(boolean z6) {
        getWorkbook().getRecalcId().setEngineId(0);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setHidden(boolean z6) {
        this.workbook.getWindowOne().setHidden(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setMissingCellPolicy(Row.MissingCellPolicy missingCellPolicy) {
        this.missingCellPolicy = missingCellPolicy;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setPrintArea(int i5, String str) {
        int i6 = i5 + 1;
        NameRecord specificBuiltinRecord = this.workbook.getSpecificBuiltinRecord((byte) 6, i6);
        if (specificBuiltinRecord == null) {
            specificBuiltinRecord = this.workbook.createBuiltInName((byte) 6, i6);
        }
        String[] strArrSplit = COMMA_PATTERN.split(str);
        StringBuilder sb = new StringBuilder(32);
        for (int i7 = 0; i7 < strArrSplit.length; i7++) {
            if (i7 > 0) {
                sb.append(',');
            }
            SheetNameFormatter.appendFormat(sb, getSheetName(i5));
            sb.append('!');
            sb.append(strArrSplit[i7]);
        }
        specificBuiltinRecord.setNameDefinition(HSSFFormulaParser.parse(sb.toString(), this, FormulaType.NAMEDRANGE, i5));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSelectedTab(int i5) {
        validateSheetIndex(i5);
        int size = this._sheets.size();
        int i6 = 0;
        while (true) {
            boolean z6 = true;
            if (i6 >= size) {
                this.workbook.getWindowOne().setNumSelectedTabs((short) 1);
                return;
            }
            HSSFSheet sheetAt = getSheetAt(i6);
            if (i6 != i5) {
                z6 = false;
            }
            sheetAt.setSelected(z6);
            i6++;
        }
    }

    public void setSelectedTabs(int[] iArr) {
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i5 : iArr) {
            arrayList.add(Integer.valueOf(i5));
        }
        setSelectedTabs(arrayList);
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
        if (this.workbook.doesContainsSheetName(str, i5)) {
            throw new IllegalArgumentException(AbstractC0157z.o("The workbook already contains a sheet named '", str, "'"));
        }
        validateSheetIndex(i5);
        this.workbook.setSheetName(i5, str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetOrder(String str, int i5) {
        int sheetIndex = getSheetIndex(str);
        List<HSSFSheet> list = this._sheets;
        list.add(i5, list.remove(sheetIndex));
        this.workbook.setSheetOrder(str, i5);
        FormulaShifter formulaShifterCreateForSheetShift = FormulaShifter.createForSheetShift(sheetIndex, i5);
        Iterator<HSSFSheet> it = this._sheets.iterator();
        while (it.hasNext()) {
            it.next().getSheet().updateFormulasAfterCellShift(formulaShifterCreateForSheetShift, -1);
        }
        this.workbook.updateNamesAfterCellShift(formulaShifterCreateForSheetShift);
        updateNamedRangesAfterSheetReorder(sheetIndex, i5);
        updateActiveSheetAfterSheetReorder(sheetIndex, i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetVisibility(int i5, SheetVisibility sheetVisibility) {
        validateSheetIndex(i5);
        this.workbook.setSheetHidden(i5, sheetVisibility);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Iterator<Sheet> sheetIterator() {
        return new SheetIterator();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook, java.lang.Iterable
    public Spliterator<Sheet> spliterator() {
        return this._sheets.spliterator();
    }

    public void unwriteProtectWorkbook() {
        this.workbook.unwriteProtectWorkbook();
    }

    @Override // org.apache.poi.POIDocument
    public void write() {
        validateInPlaceWritePossible();
        DirectoryNode directory = getDirectory();
        new POIFSDocument((DocumentNode) directory.getEntry(getWorkbookDirEntryName(directory))).replaceContents(new UnsynchronizedByteArrayInputStream(getBytes()));
        writeProperties();
        directory.getFileSystem().writeFilesystem();
    }

    public void writeProtectWorkbook(String str, String str2) {
        this.workbook.writeProtectWorkbook(str, str2);
    }

    private HSSFWorkbook(InternalWorkbook internalWorkbook) {
        super((DirectoryNode) null);
        this.missingCellPolicy = Row.MissingCellPolicy.RETURN_NULL_AND_BLANK;
        this._udfFinder = new IndexedUDFFinder(AggregatingUDFFinder.DEFAULT);
        this.workbook = internalWorkbook;
        int i5 = INITIAL_CAPACITY;
        this._sheets = new ArrayList(i5);
        this.names = new ArrayList<>(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFSheet cloneSheet(int i5) {
        validateSheetIndex(i5);
        HSSFSheet hSSFSheet = this._sheets.get(i5);
        String sheetName = this.workbook.getSheetName(i5);
        HSSFSheet hSSFSheetCloneSheet = hSSFSheet.cloneSheet(this);
        hSSFSheetCloneSheet.setSelected(false);
        hSSFSheetCloneSheet.setActive(false);
        String uniqueSheetName = getUniqueSheetName(sheetName);
        int size = this._sheets.size();
        this._sheets.add(hSSFSheetCloneSheet);
        this.workbook.setSheetName(size, uniqueSheetName);
        int iFindExistingBuiltinNameRecordIdx = findExistingBuiltinNameRecordIdx(i5, (byte) 13);
        if (iFindExistingBuiltinNameRecordIdx != -1) {
            this.names.add(new HSSFName(this, this.workbook.cloneFilter(iFindExistingBuiltinNameRecordIdx, size)));
        }
        return hSSFSheetCloneSheet;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFCellStyle createCellStyle() {
        if (this.workbook.getNumExFormats() == MAX_STYLES) {
            throw new IllegalStateException("The maximum number of cell styles was exceeded. You can define up to 4000 styles in a .xls workbook");
        }
        return new HSSFCellStyle((short) (getNumCellStyles() - 1), this.workbook.createCellXF(), this);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFDataFormat createDataFormat() {
        if (this.formatter == null) {
            this.formatter = new HSSFDataFormat(this.workbook);
        }
        return this.formatter;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFEvaluationWorkbook createEvaluationWorkbook() {
        return HSSFEvaluationWorkbook.create(this);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFFont createFont() {
        this.workbook.createNewFont();
        int numberOfFonts = getNumberOfFonts();
        int i5 = numberOfFonts - 1;
        if (i5 <= 3) {
            numberOfFonts = i5;
        }
        if (numberOfFonts < 32767) {
            return getFontAt(numberOfFonts);
        }
        throw new IllegalArgumentException("Maximum number of fonts was exceeded");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFName createName() {
        HSSFName hSSFName = new HSSFName(this, this.workbook.createName());
        this.names.add(hSSFName);
        return hSSFName;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFFont findFont(boolean z6, short s6, short s7, String str, boolean z7, boolean z8, short s8, byte b) {
        int numberOfFonts = getNumberOfFonts();
        for (int i5 = 0; i5 <= numberOfFonts; i5++) {
            if (i5 != 4) {
                HSSFFont fontAt = getFontAt(i5);
                if (fontAt.getBold() == z6 && fontAt.getColor() == s6 && fontAt.getFontHeight() == s7 && fontAt.getFontName().equals(str) && fontAt.getItalic() == z7 && fontAt.getStrikeout() == z8 && fontAt.getTypeOffset() == s8 && fontAt.getUnderline() == b) {
                    return fontAt;
                }
            }
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFCellStyle getCellStyleAt(int i5) {
        return new HSSFCellStyle((short) i5, this.workbook.getExFormatAt(i5), this);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFCreationHelper getCreationHelper() {
        return new HSSFCreationHelper(this);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFFont getFontAt(int i5) {
        if (this.fonts == null) {
            this.fonts = new HashMap();
        }
        Integer numValueOf = Integer.valueOf(i5);
        if (this.fonts.containsKey(numValueOf)) {
            return this.fonts.get(numValueOf);
        }
        HSSFFont hSSFFont = new HSSFFont(i5, this.workbook.getFontRecordAt(i5));
        this.fonts.put(numValueOf, hSSFFont);
        return hSSFFont;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFName getName(String str) {
        int nameIndex = getNameIndex(str);
        if (nameIndex < 0) {
            return null;
        }
        return this.names.get(nameIndex);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFSheet getSheet(String str) {
        HSSFSheet hSSFSheet = null;
        for (int i5 = 0; i5 < this._sheets.size(); i5++) {
            if (this.workbook.getSheetName(i5).equalsIgnoreCase(str)) {
                hSSFSheet = this._sheets.get(i5);
            }
        }
        return hSSFSheet;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFSheet getSheetAt(int i5) {
        validateSheetIndex(i5);
        return this._sheets.get(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getSheetIndex(Sheet sheet) {
        return this._sheets.indexOf(sheet);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFSheet createSheet() {
        HSSFSheet hSSFSheet = new HSSFSheet(this);
        this._sheets.add(hSSFSheet);
        this.workbook.setSheetName(this._sheets.size() - 1, "Sheet" + (this._sheets.size() - 1));
        boolean z6 = this._sheets.size() == 1;
        hSSFSheet.setSelected(z6);
        hSSFSheet.setActive(z6);
        return hSSFSheet;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeName(Name name) {
        removeName(getNameIndex((HSSFName) name));
    }

    public int getNameIndex(HSSFName hSSFName) {
        for (int i5 = 0; i5 < this.names.size(); i5++) {
            if (hSSFName == this.names.get(i5)) {
                return i5;
            }
        }
        return -1;
    }

    private void getAllEmbeddedObjects(HSSFSheet hSSFSheet, List<HSSFObjectData> list) {
        HSSFPatriarch drawingPatriarch = hSSFSheet.getDrawingPatriarch();
        if (drawingPatriarch == null) {
            return;
        }
        getAllEmbeddedObjects(drawingPatriarch, list);
    }

    public void setSelectedTabs(Collection<Integer> collection) {
        Iterator<Integer> it = collection.iterator();
        while (it.hasNext()) {
            validateSheetIndex(it.next().intValue());
        }
        HashSet hashSet = new HashSet(collection);
        int size = this._sheets.size();
        for (int i5 = 0; i5 < size; i5++) {
            getSheetAt(i5).setSelected(hashSet.contains(Integer.valueOf(i5)));
        }
        this.workbook.getWindowOne().setNumSelectedTabs((short) hashSet.size());
    }

    private void getAllEmbeddedObjects(HSSFShapeContainer hSSFShapeContainer, List<HSSFObjectData> list) {
        for (Shape shape : hSSFShapeContainer.getChildren()) {
            if (shape instanceof HSSFObjectData) {
                list.add((HSSFObjectData) shape);
            } else if (shape instanceof HSSFShapeContainer) {
                getAllEmbeddedObjects((HSSFShapeContainer) shape, list);
            }
        }
    }

    public HSSFWorkbook(POIFSFileSystem pOIFSFileSystem) {
        this(pOIFSFileSystem, true);
    }

    public HSSFWorkbook(POIFSFileSystem pOIFSFileSystem, boolean z6) {
        this(pOIFSFileSystem.getRoot(), pOIFSFileSystem, z6);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFSheet createSheet(String str) {
        if (str != null) {
            if (!this.workbook.doesContainsSheetName(str, this._sheets.size())) {
                if (str.length() > 31) {
                    String strSubstring = str.substring(0, 31);
                    LOGGER.atWarn().log("Sheet '{}' will be added with a trimmed name '{}' for MS Excel compliance.", str, strSubstring);
                    str = strSubstring;
                }
                HSSFSheet hSSFSheet = new HSSFSheet(this);
                this.workbook.setSheetName(this._sheets.size(), str);
                this._sheets.add(hSSFSheet);
                boolean z6 = this._sheets.size() == 1;
                hSSFSheet.setSelected(z6);
                hSSFSheet.setActive(z6);
                return hSSFSheet;
            }
            throw new IllegalArgumentException(AbstractC0157z.o("The workbook already contains a sheet named '", str, "'"));
        }
        throw new IllegalArgumentException("sheetName must not be null");
    }

    @Override // org.apache.poi.POIDocument
    public void write(File file) {
        POIFSFileSystem pOIFSFileSystemCreate = POIFSFileSystem.create(file);
        try {
            write(pOIFSFileSystemCreate);
            pOIFSFileSystemCreate.writeFilesystem();
            pOIFSFileSystemCreate.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (pOIFSFileSystemCreate != null) {
                    try {
                        pOIFSFileSystemCreate.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public HSSFWorkbook(DirectoryNode directoryNode, POIFSFileSystem pOIFSFileSystem, boolean z6) {
        this(directoryNode, z6);
    }

    public HSSFWorkbook(DirectoryNode directoryNode, boolean z6) {
        super(directoryNode);
        this.missingCellPolicy = Row.MissingCellPolicy.RETURN_NULL_AND_BLANK;
        this._udfFinder = new IndexedUDFFinder(AggregatingUDFFinder.DEFAULT);
        String workbookDirEntryName = getWorkbookDirEntryName(directoryNode);
        this.preserveNodes = z6;
        if (!z6) {
            clearDirectory();
        }
        int i5 = INITIAL_CAPACITY;
        this._sheets = new ArrayList(i5);
        this.names = new ArrayList<>(i5);
        List<Record> listCreateRecords = RecordFactory.createRecords(directoryNode.createDocumentInputStream(workbookDirEntryName));
        InternalWorkbook internalWorkbookCreateWorkbook = InternalWorkbook.createWorkbook(listCreateRecords);
        this.workbook = internalWorkbookCreateWorkbook;
        setPropertiesFromWorkbook(internalWorkbookCreateWorkbook);
        int numRecords = this.workbook.getNumRecords();
        convertLabelRecords(listCreateRecords, numRecords);
        RecordStream recordStream = new RecordStream(listCreateRecords, numRecords);
        while (recordStream.hasNext()) {
            try {
                this._sheets.add(new HSSFSheet(this, InternalSheet.createSheet(recordStream)));
            } catch (InternalSheet.UnsupportedBOFType e) {
                LOGGER.atWarn().log("Unsupported BOF found of type {}", Unbox.box(e.getType()));
            }
        }
        for (int i6 = 0; i6 < this.workbook.getNumNames(); i6++) {
            NameRecord nameRecord = this.workbook.getNameRecord(i6);
            this.names.add(new HSSFName(this, nameRecord, this.workbook.getNameCommentRecord(nameRecord)));
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setPrintArea(int i5, int i6, int i7, int i8, int i9) {
        String asString = new CellReference(i8, i6, true, true).formatAsString();
        CellReference cellReference = new CellReference(i9, i7, true, true);
        StringBuilder sbX = AbstractC0157z.x(asString, ParameterizedMessage.ERROR_MSG_SEPARATOR);
        sbX.append(cellReference.formatAsString());
        setPrintArea(i5, sbX.toString());
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int addOlePackage(byte[] bArr, String str, String str2, String str3) {
        if (initDirectory()) {
            this.preserveNodes = true;
        }
        int i5 = 0;
        DirectoryEntry directoryEntryCreateDirectory = null;
        do {
            StringBuilder sb = new StringBuilder("MBD");
            i5++;
            sb.append(HexDump.toHex(i5));
            String string = sb.toString();
            if (!getDirectory().hasEntry(string)) {
                directoryEntryCreateDirectory = getDirectory().createDirectory(string);
                directoryEntryCreateDirectory.setStorageClsid(ClassIDPredefined.OLE_V1_PACKAGE.getClassID());
            }
        } while (directoryEntryCreateDirectory == null);
        Ole10Native.createOleMarkerEntry(directoryEntryCreateDirectory);
        Ole10Native ole10Native = new Ole10Native(str, str2, str3, bArr);
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
        try {
            ole10Native.writeOut(unsynchronizedByteArrayOutputStream);
            directoryEntryCreateDirectory.createDocument(Ole10Native.OLE10_NATIVE, unsynchronizedByteArrayOutputStream.toInputStream());
            unsynchronizedByteArrayOutputStream.close();
            return i5;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    unsynchronizedByteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.poi.POIDocument
    public void write(OutputStream outputStream) {
        POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem();
        try {
            write(pOIFSFileSystem);
            pOIFSFileSystem.writeFilesystem(outputStream);
            pOIFSFileSystem.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    pOIFSFileSystem.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private void write(POIFSFileSystem pOIFSFileSystem) {
        ArrayList arrayList = new ArrayList(1);
        pOIFSFileSystem.createDocument(new UnsynchronizedByteArrayInputStream(getBytes()), "Workbook");
        writeProperties(pOIFSFileSystem, arrayList);
        if (this.preserveNodes) {
            arrayList.addAll(InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES);
            arrayList.addAll(Arrays.asList(DocumentSummaryInformation.DEFAULT_STREAM_NAME, SummaryInformation.DEFAULT_STREAM_NAME, getEncryptedPropertyStreamName()));
            EntryUtils.copyNodes(new FilteringDirectoryNode(getDirectory(), arrayList), new FilteringDirectoryNode(pOIFSFileSystem.getRoot(), arrayList));
            pOIFSFileSystem.getRoot().setStorageClsid(getDirectory().getStorageClsid());
        }
    }

    public HSSFWorkbook(InputStream inputStream) {
        this(inputStream, true);
    }

    public HSSFWorkbook(InputStream inputStream, boolean z6) {
        this(new POIFSFileSystem(inputStream).getRoot(), z6);
    }
}
