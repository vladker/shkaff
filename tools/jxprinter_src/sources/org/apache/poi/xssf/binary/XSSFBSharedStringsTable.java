package org.apache.poi.xssf.binary;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.xssf.model.SharedStrings;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class XSSFBSharedStringsTable implements SharedStrings {
    private int count;
    private List<String> strings = new ArrayList();
    private int uniqueCount;

    /* JADX INFO: renamed from: org.apache.poi.xssf.binary.XSSFBSharedStringsTable$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType;

        static {
            int[] iArr = new int[XSSFBRecordType.values().length];
            $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType = iArr;
            try {
                iArr[XSSFBRecordType.BrtSstItem.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtBeginSst.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class SSTBinaryReader extends XSSFBParser {
        public SSTBinaryReader(InputStream inputStream) {
            super(inputStream);
        }

        @Override // org.apache.poi.xssf.binary.XSSFBParser
        public void handleRecord(int i5, byte[] bArr) {
            int i6 = AnonymousClass1.$SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.lookup(i5).ordinal()];
            if (i6 == 1) {
                XSSFBSharedStringsTable.this.strings.add(XSSFBRichStr.build(bArr, 0).getString());
            } else {
                if (i6 != 2) {
                    return;
                }
                XSSFBSharedStringsTable.this.count = XSSFBUtils.castToInt(LittleEndian.getUInt(bArr, 0));
                XSSFBSharedStringsTable.this.uniqueCount = XSSFBUtils.castToInt(LittleEndian.getUInt(bArr, 4));
            }
        }
    }

    public XSSFBSharedStringsTable(OPCPackage oPCPackage) throws IOException {
        ArrayList<PackagePart> partsByContentType = oPCPackage.getPartsByContentType(XSSFBRelation.SHARED_STRINGS_BINARY.getContentType());
        if (partsByContentType.isEmpty()) {
            return;
        }
        InputStream inputStream = partsByContentType.get(0).getInputStream();
        try {
            readFrom(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
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

    private void readFrom(InputStream inputStream) throws IOException {
        new SSTBinaryReader(inputStream).parse();
    }

    @Override // org.apache.poi.xssf.model.SharedStrings
    public int getCount() {
        return this.count;
    }

    @Override // org.apache.poi.xssf.model.SharedStrings
    public RichTextString getItemAt(int i5) {
        return new XSSFRichTextString(this.strings.get(i5));
    }

    @Override // org.apache.poi.xssf.model.SharedStrings
    public int getUniqueCount() {
        return this.uniqueCount;
    }

    public XSSFBSharedStringsTable(PackagePart packagePart) throws IOException {
        InputStream inputStream = packagePart.getInputStream();
        try {
            readFrom(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
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
