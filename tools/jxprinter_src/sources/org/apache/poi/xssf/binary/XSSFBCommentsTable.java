package org.apache.poi.xssf.binary;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class XSSFBCommentsTable extends XSSFBParser {
    private StringBuilder authorBuffer;
    private int authorId;
    private List<String> authors;
    private CellAddress cellAddress;
    private XSSFBCellRange cellRange;
    private String comment;
    private Queue<CellAddress> commentAddresses;
    private Map<CellAddress, XSSFBComment> comments;

    /* JADX INFO: renamed from: org.apache.poi.xssf.binary.XSSFBCommentsTable$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType;

        static {
            int[] iArr = new int[XSSFBRecordType.values().length];
            $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType = iArr;
            try {
                iArr[XSSFBRecordType.BrtBeginComment.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtCommentText.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtEndComment.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtCommentAuthor.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public XSSFBCommentsTable(InputStream inputStream) throws IOException {
        super(inputStream);
        this.comments = new TreeMap();
        this.commentAddresses = new LinkedList();
        this.authors = new ArrayList();
        this.authorId = -1;
        this.authorBuffer = new StringBuilder();
        parse();
        this.commentAddresses.addAll(this.comments.keySet());
    }

    public XSSFBComment get(CellAddress cellAddress) {
        if (cellAddress == null) {
            return null;
        }
        return this.comments.get(cellAddress);
    }

    public Queue<CellAddress> getAddresses() {
        return this.commentAddresses;
    }

    @Override // org.apache.poi.xssf.binary.XSSFBParser
    public void handleRecord(int i5, byte[] bArr) {
        int i6 = AnonymousClass1.$SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.lookup(i5).ordinal()];
        if (i6 == 1) {
            this.authorId = XSSFBUtils.castToInt(LittleEndian.getUInt(bArr));
            this.cellRange = XSSFBCellRange.parse(bArr, 4, this.cellRange);
            XSSFBCellRange xSSFBCellRange = this.cellRange;
            this.cellAddress = new CellAddress(xSSFBCellRange.firstRow, xSSFBCellRange.firstCol);
            return;
        }
        if (i6 == 2) {
            this.comment = XSSFBRichStr.build(bArr, 0).getString();
            return;
        }
        if (i6 != 3) {
            if (i6 != 4) {
                return;
            }
            this.authorBuffer.setLength(0);
            XSSFBUtils.readXLWideString(bArr, 0, this.authorBuffer);
            this.authors.add(this.authorBuffer.toString());
            return;
        }
        Map<CellAddress, XSSFBComment> map = this.comments;
        CellAddress cellAddress = this.cellAddress;
        map.put(cellAddress, new XSSFBComment(cellAddress, this.authors.get(this.authorId), this.comment));
        this.authorId = -1;
        this.cellAddress = null;
    }
}
