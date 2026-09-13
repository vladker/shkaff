package org.apache.poi.xssf.model;

import androidx.exifinterface.media.a;
import com.microsoft.schemas.vml.CTShape;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Removal;
import org.apache.poi.xssf.usermodel.OoxmlSheetExtensions;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFVMLDrawing;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCommentList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CommentsDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class CommentsTable extends POIXMLDocumentPart implements Comments {
    public static final String DEFAULT_AUTHOR = "";
    public static final int DEFAULT_AUTHOR_ID = 0;
    private Map<CellAddress, CTComment> commentRefs;
    private CTComments comments;
    private Sheet sheet;
    private XSSFVMLDrawing vmlDrawing;

    public CommentsTable() {
        CTComments cTCommentsNewInstance = CTComments.Factory.newInstance();
        this.comments = cTCommentsNewInstance;
        cTCommentsNewInstance.addNewCommentList();
        this.comments.addNewAuthors().addAuthor("");
    }

    private int addNewAuthor(String str) {
        int iSizeOfAuthorArray = this.comments.getAuthors().sizeOfAuthorArray();
        this.comments.getAuthors().insertAuthor(iSizeOfAuthorArray, str);
        return iSizeOfAuthorArray;
    }

    private XSSFVMLDrawing getVMLDrawing(Sheet sheet, boolean z6) {
        if (this.vmlDrawing == null && (sheet instanceof OoxmlSheetExtensions)) {
            this.vmlDrawing = ((OoxmlSheetExtensions) sheet).getVMLDrawing(z6);
        }
        return this.vmlDrawing;
    }

    private void prepareCTCommentCache() {
        if (this.commentRefs == null) {
            this.commentRefs = new HashMap();
            for (CTComment cTComment : this.comments.getCommentList().getCommentArray()) {
                this.commentRefs.put(new CellAddress(cTComment.getRef()), cTComment);
            }
        }
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            writeTo(outputStream);
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.poi.xssf.model.Comments
    public XSSFComment createNewComment(ClientAnchor clientAnchor) {
        XSSFVMLDrawing vMLDrawing = getVMLDrawing(this.sheet, true);
        CTShape cTShapeNewCommentShape = vMLDrawing == null ? null : vMLDrawing.newCommentShape();
        if (cTShapeNewCommentShape != null && (clientAnchor instanceof XSSFClientAnchor) && ((XSSFClientAnchor) clientAnchor).isSet()) {
            int dx1 = clientAnchor.getDx1() / 9525;
            int dy1 = clientAnchor.getDy1() / 9525;
            int dx2 = clientAnchor.getDx2() / 9525;
            int dy2 = clientAnchor.getDy2() / 9525;
            StringBuilder sb = new StringBuilder();
            sb.append((int) clientAnchor.getCol1());
            sb.append(", ");
            sb.append(dx1);
            sb.append(", ");
            sb.append(clientAnchor.getRow1());
            sb.append(", ");
            sb.append(dy1);
            sb.append(", ");
            sb.append((int) clientAnchor.getCol2());
            sb.append(", ");
            sb.append(dx2);
            sb.append(", ");
            sb.append(clientAnchor.getRow2());
            cTShapeNewCommentShape.getClientDataArray(0).setAnchorArray(0, a.q(sb, ", ", dy2));
        }
        CellAddress cellAddress = new CellAddress(clientAnchor.getRow1(), clientAnchor.getCol1());
        if (findCellComment(cellAddress) == null) {
            return new XSSFComment(this, newComment(cellAddress), cTShapeNewCommentShape);
        }
        throw new IllegalArgumentException("Multiple cell comments in one cell are not allowed, cell: " + cellAddress);
    }

    @Override // org.apache.poi.xssf.model.Comments
    public int findAuthor(String str) {
        String[] authorArray = this.comments.getAuthors().getAuthorArray();
        for (int i5 = 0; i5 < authorArray.length; i5++) {
            if (authorArray[i5].equals(str)) {
                return i5;
            }
        }
        return addNewAuthor(str);
    }

    @Override // org.apache.poi.xssf.model.Comments
    public XSSFComment findCellComment(CellAddress cellAddress) {
        CTComment cTComment = getCTComment(cellAddress);
        if (cTComment == null) {
            return null;
        }
        XSSFVMLDrawing vMLDrawing = getVMLDrawing(this.sheet, false);
        return new XSSFComment(this, cTComment, vMLDrawing != null ? vMLDrawing.findCommentShape(cellAddress.getRow(), cellAddress.getColumn()) : null);
    }

    @Override // org.apache.poi.xssf.model.Comments
    public String getAuthor(long j6) {
        return this.comments.getAuthors().getAuthorArray(Math.toIntExact(j6));
    }

    @Internal
    public CTComment getCTComment(CellAddress cellAddress) {
        prepareCTCommentCache();
        return this.commentRefs.get(cellAddress);
    }

    @Internal
    public CTComments getCTComments() {
        return this.comments;
    }

    @Override // org.apache.poi.xssf.model.Comments
    public Iterator<CellAddress> getCellAddresses() {
        prepareCTCommentCache();
        return this.commentRefs.keySet().iterator();
    }

    @Override // org.apache.poi.xssf.model.Comments
    public int getNumberOfAuthors() {
        return this.comments.getAuthors().sizeOfAuthorArray();
    }

    @Override // org.apache.poi.xssf.model.Comments
    public int getNumberOfComments() {
        return this.comments.getCommentList().sizeOfCommentArray();
    }

    @Internal
    public CTComment newComment(CellAddress cellAddress) {
        CTComment cTCommentAddNewComment = this.comments.getCommentList().addNewComment();
        cTCommentAddNewComment.setRef(cellAddress.formatAsString());
        cTCommentAddNewComment.setAuthorId(0L);
        Map<CellAddress, CTComment> map = this.commentRefs;
        if (map != null) {
            map.put(cellAddress, cTCommentAddNewComment);
        }
        return cTCommentAddNewComment;
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            this.comments = CommentsDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getComments();
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    @Removal(version = "6.0.0")
    @Deprecated
    public void referenceUpdated(CellAddress cellAddress, CTComment cTComment) {
        Map<CellAddress, CTComment> map = this.commentRefs;
        if (map != null) {
            map.remove(cellAddress);
            this.commentRefs.put(new CellAddress(cTComment.getRef()), cTComment);
        }
    }

    @Override // org.apache.poi.xssf.model.Comments
    public boolean removeComment(CellAddress cellAddress) {
        String asString = cellAddress.formatAsString();
        CTCommentList commentList = this.comments.getCommentList();
        if (commentList != null) {
            CTComment[] commentArray = commentList.getCommentArray();
            for (int i5 = 0; i5 < commentArray.length; i5++) {
                if (asString.equals(commentArray[i5].getRef())) {
                    commentList.removeComment(i5);
                    Map<CellAddress, CTComment> map = this.commentRefs;
                    if (map == null) {
                        return true;
                    }
                    map.remove(cellAddress);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // org.apache.poi.xssf.model.Comments
    @Internal
    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }

    public void writeTo(OutputStream outputStream) {
        CommentsDocument commentsDocumentNewInstance = CommentsDocument.Factory.newInstance();
        commentsDocumentNewInstance.setComments(this.comments);
        commentsDocumentNewInstance.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }

    @Override // org.apache.poi.xssf.model.Comments
    public void referenceUpdated(CellAddress cellAddress, XSSFComment xSSFComment) {
        Map<CellAddress, CTComment> map = this.commentRefs;
        if (map != null) {
            map.remove(cellAddress);
            this.commentRefs.put(xSSFComment.getAddress(), xSSFComment.getCTComment());
        }
    }

    public CommentsTable(PackagePart packagePart) throws IOException {
        super(packagePart);
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

    @Override // org.apache.poi.xssf.model.Comments
    public void commentUpdated(XSSFComment xSSFComment) {
    }
}
