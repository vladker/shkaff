package org.apache.poi.xssf.streaming;

import java.util.Iterator;
import java.util.Spliterator;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.ObjectData;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SXSSFDrawing implements Drawing<XSSFShape> {
    private final XSSFDrawing _drawing;
    private final SXSSFWorkbook _wb;

    public SXSSFDrawing(SXSSFWorkbook sXSSFWorkbook, XSSFDrawing xSSFDrawing) {
        this._wb = sXSSFWorkbook;
        this._drawing = xSSFDrawing;
    }

    @Override // org.apache.poi.ss.usermodel.Drawing
    public ClientAnchor createAnchor(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        return this._drawing.createAnchor(i5, i6, i7, i8, i9, i10, i11, i12);
    }

    @Override // org.apache.poi.ss.usermodel.Drawing
    public Comment createCellComment(ClientAnchor clientAnchor) {
        return this._drawing.createCellComment(clientAnchor);
    }

    @Override // org.apache.poi.ss.usermodel.Drawing
    public ObjectData createObjectData(ClientAnchor clientAnchor, int i5, int i6) {
        return this._drawing.createObjectData(clientAnchor, i5, i6);
    }

    @Override // java.lang.Iterable
    public Iterator<XSSFShape> iterator() {
        return this._drawing.getShapes().iterator();
    }

    @Override // java.lang.Iterable
    public Spliterator<XSSFShape> spliterator() {
        return this._drawing.getShapes().spliterator();
    }

    @Override // org.apache.poi.ss.usermodel.Drawing
    public SXSSFPicture createPicture(ClientAnchor clientAnchor, int i5) {
        return new SXSSFPicture(this._wb, this._drawing.createPicture(clientAnchor, i5));
    }
}
