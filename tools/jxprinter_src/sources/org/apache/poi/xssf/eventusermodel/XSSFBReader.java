package org.apache.poi.xssf.eventusermodel;

import V2.f;
import androidx.collection.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.binary.XSSFBCommentsTable;
import org.apache.poi.xssf.binary.XSSFBParseException;
import org.apache.poi.xssf.binary.XSSFBParser;
import org.apache.poi.xssf.binary.XSSFBRecordType;
import org.apache.poi.xssf.binary.XSSFBRelation;
import org.apache.poi.xssf.binary.XSSFBStylesTable;
import org.apache.poi.xssf.binary.XSSFBUtils;
import org.apache.poi.xssf.model.CommentsTable;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFBReader extends XSSFReader {
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) XSSFBReader.class);
    private static final Set<String> WORKSHEET_RELS = Collections.unmodifiableSet(new HashSet(Arrays.asList(XSSFRelation.WORKSHEET.getRelation(), XSSFRelation.CHARTSHEET.getRelation(), XSSFRelation.MACRO_SHEET_BIN.getRelation(), XSSFRelation.INTL_MACRO_SHEET_BIN.getRelation(), XSSFRelation.DIALOG_SHEET_BIN.getRelation())));

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PathExtractor extends XSSFBParser {
        private static f RECORDS;
        private String path;

        static {
            f fVar = new f();
            RECORDS = fVar;
            fVar.j(XSSFBRecordType.BrtAbsPath15.getId());
        }

        public PathExtractor(InputStream inputStream) {
            super(inputStream, RECORDS);
        }

        public String getPath() {
            return this.path;
        }

        @Override // org.apache.poi.xssf.binary.XSSFBParser
        public void handleRecord(int i5, byte[] bArr) {
            if (i5 != XSSFBRecordType.BrtAbsPath15.getId()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            XSSFBUtils.readXLWideString(bArr, 0, sb);
            this.path = sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SheetIterator extends XSSFReader.SheetIterator {
        @Override // org.apache.poi.xssf.eventusermodel.XSSFReader.SheetIterator
        public Iterator<XSSFReader.XSSFSheetRef> createSheetIteratorFromWB(PackagePart packagePart) throws IOException {
            InputStream inputStream = packagePart.getInputStream();
            try {
                SheetRefLoader sheetRefLoader = new SheetRefLoader(inputStream);
                sheetRefLoader.parse();
                Iterator<XSSFReader.XSSFSheetRef> it = sheetRefLoader.getSheets().iterator();
                if (inputStream != null) {
                    inputStream.close();
                }
                return it;
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
        }

        @Override // org.apache.poi.xssf.eventusermodel.XSSFReader.SheetIterator
        public Set<String> getSheetRelationships() {
            return XSSFBReader.WORKSHEET_RELS;
        }

        public XSSFBCommentsTable getXSSFBSheetComments() {
            PackageRelationship relationship;
            PackagePart sheetPart = getSheetPart();
            try {
                PackageRelationshipCollection relationshipsByType = sheetPart.getRelationshipsByType(XSSFRelation.SHEET_COMMENTS.getRelation());
                if (!relationshipsByType.isEmpty() && (relationship = relationshipsByType.getRelationship(0)) != null && relationship.getTargetURI() != null) {
                    InputStream inputStream = sheetPart.getPackage().getPart(PackagingURIHelper.createPartName(relationship.getTargetURI())).getInputStream();
                    try {
                        XSSFBCommentsTable xSSFBCommentsTable = new XSSFBCommentsTable(inputStream);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return xSSFBCommentsTable;
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
                }
            } catch (IOException | InvalidFormatException unused) {
            }
            return null;
        }

        private SheetIterator(PackagePart packagePart) {
            super(packagePart);
        }

        @Override // org.apache.poi.xssf.eventusermodel.XSSFReader.SheetIterator
        public CommentsTable getSheetComments() {
            throw new IllegalArgumentException("Please use getXSSFBSheetComments");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SheetRefLoader extends XSSFBParser {
        List<XSSFReader.XSSFSheetRef> sheets;

        private void addWorksheet(byte[] bArr) {
            try {
                tryToAddWorksheet(bArr);
            } catch (XSSFBParseException e) {
                if (!tryOldFormat(bArr)) {
                    throw e;
                }
                XSSFBReader.LOGGER.atWarn().log("This file was written with a beta version of Excel. POI will try to parse the file as a regular xlsb.");
            }
        }

        private boolean tryOldFormat(byte[] bArr) {
            long uInt = LittleEndian.getUInt(bArr, 8);
            if (uInt < 1 || uInt > 65535) {
                throw new XSSFBParseException(a.j(uInt, "table id out of range: "));
            }
            StringBuilder sb = new StringBuilder();
            int xLWideString = XSSFBUtils.readXLWideString(bArr, 12, sb) + 12;
            String string = sb.toString();
            sb.setLength(0);
            int xLWideString2 = XSSFBUtils.readXLWideString(bArr, xLWideString, sb) + xLWideString;
            String string2 = sb.toString();
            if (StringUtil.isNotBlank(string)) {
                this.sheets.add(new XSSFReader.XSSFSheetRef(string, string2));
            }
            return xLWideString2 == bArr.length;
        }

        private void tryToAddWorksheet(byte[] bArr) {
            LittleEndian.getUInt(bArr, 0);
            long uInt = LittleEndian.getUInt(bArr, 4);
            if (uInt < 1 || uInt > 65535) {
                throw new XSSFBParseException(a.j(uInt, "table id out of range: "));
            }
            StringBuilder sb = new StringBuilder();
            int xLWideString = XSSFBUtils.readXLWideString(bArr, 8, sb) + 8;
            String string = sb.toString();
            sb.setLength(0);
            XSSFBUtils.readXLWideString(bArr, xLWideString, sb);
            String string2 = sb.toString();
            if (StringUtil.isNotBlank(string)) {
                this.sheets.add(new XSSFReader.XSSFSheetRef(string, string2));
            }
        }

        public List<XSSFReader.XSSFSheetRef> getSheets() {
            return this.sheets;
        }

        @Override // org.apache.poi.xssf.binary.XSSFBParser
        public void handleRecord(int i5, byte[] bArr) {
            if (i5 == XSSFBRecordType.BrtBundleSh.getId()) {
                addWorksheet(bArr);
            }
        }

        private SheetRefLoader(InputStream inputStream) {
            super(inputStream);
            this.sheets = new LinkedList();
        }
    }

    public XSSFBReader(OPCPackage oPCPackage) {
        super(oPCPackage);
    }

    public String getAbsPathMetadata() throws IOException {
        InputStream inputStream = this.workbookPart.getInputStream();
        try {
            PathExtractor pathExtractor = new PathExtractor(inputStream);
            pathExtractor.parse();
            String path = pathExtractor.getPath();
            if (inputStream != null) {
                inputStream.close();
            }
            return path;
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
    }

    @Override // org.apache.poi.xssf.eventusermodel.XSSFReader
    public Iterator<InputStream> getSheetsData() {
        return new SheetIterator(this.workbookPart);
    }

    public XSSFBStylesTable getXSSFBStylesTable() throws IOException {
        ArrayList<PackagePart> partsByContentType = this.pkg.getPartsByContentType(XSSFBRelation.STYLES_BINARY.getContentType());
        if (partsByContentType.isEmpty()) {
            return null;
        }
        InputStream inputStream = partsByContentType.get(0).getInputStream();
        try {
            XSSFBStylesTable xSSFBStylesTable = new XSSFBStylesTable(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
            return xSSFBStylesTable;
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
    }
}
