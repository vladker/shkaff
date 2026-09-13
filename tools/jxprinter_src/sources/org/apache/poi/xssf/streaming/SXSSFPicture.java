package org.apache.poi.xssf.streaming;

import java.awt.Dimension;
import java.io.IOException;
import java.io.InputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Shape;
import org.apache.poi.ss.util.ImageUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.XSSFAnchor;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFPictureData;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class SXSSFPicture implements Picture {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final float DEFAULT_COLUMN_WIDTH = 9.140625f;
    private static final Logger LOG = LogManager.getLogger((Class<?>) SXSSFPicture.class);
    private final XSSFPicture _picture;
    private final SXSSFWorkbook _wb;

    public SXSSFPicture(SXSSFWorkbook sXSSFWorkbook, XSSFPicture xSSFPicture) {
        this._wb = sXSSFWorkbook;
        this._picture = xSSFPicture;
    }

    private float getColumnWidthInPixels(int i5) {
        CTCol column = getSheet().getColumnHelper().getColumn(i5, false);
        return ((float) ((column == null || !column.isSetWidth()) ? 9.140625d : column.getWidth())) * 7.0017f;
    }

    public static Dimension getImageDimension(PackagePart packagePart, int i5) {
        try {
            InputStream inputStream = packagePart.getInputStream();
            try {
                Dimension imageDimension = ImageUtils.getImageDimension(inputStream, i5);
                if (inputStream != null) {
                    inputStream.close();
                }
                return imageDimension;
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
        } catch (IOException e) {
            LOG.atWarn().withThrowable(e).log("Failed to read image");
            return new Dimension();
        }
    }

    private float getRowHeightInPixels(int i5) {
        XSSFSheet sheet = getSheet();
        SXSSFSheet sXSSFSheet = this._wb.getSXSSFSheet(sheet);
        if (sXSSFSheet != null) {
            sheet = sXSSFSheet;
        }
        Row row = sheet.getRow(i5);
        return ((row != null ? row.getHeightInPoints() : sheet.getDefaultRowHeightInPoints()) * 96.0f) / 72.0f;
    }

    @Internal
    public CTPicture getCTPicture() {
        return this._picture.getCTPicture();
    }

    public XSSFDrawing getDrawing() {
        return this._picture.getDrawing();
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public Shape getParent() {
        return this._picture.getParent();
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public String getShapeName() {
        return this._picture.getShapeName();
    }

    public CTShapeProperties getShapeProperties() {
        return getCTPicture().getSpPr();
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public boolean isNoFill() {
        return this._picture.isNoFill();
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public void resize() {
        resize(1.0d);
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public void setFillColor(int i5, int i6, int i7) {
        this._picture.setFillColor(i5, i6, i7);
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public void setLineStyleColor(int i5, int i6, int i7) {
        this._picture.setLineStyleColor(i5, i6, i7);
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public void setNoFill(boolean z6) {
        this._picture.setNoFill(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public XSSFAnchor getAnchor() {
        return this._picture.getAnchor();
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public XSSFClientAnchor getClientAnchor() {
        XSSFAnchor anchor = getAnchor();
        if (anchor instanceof XSSFClientAnchor) {
            return (XSSFClientAnchor) anchor;
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public XSSFPictureData getPictureData() {
        return this._picture.getPictureData();
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public XSSFSheet getSheet() {
        return this._picture.getSheet();
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public void resize(double d) {
        XSSFClientAnchor clientAnchor = getClientAnchor();
        XSSFClientAnchor preferredSize = getPreferredSize(d);
        if (clientAnchor == null || preferredSize == null) {
            LOG.atWarn().log("picture is not anchored via client anchor - ignoring resize call");
            return;
        }
        int row2 = (preferredSize.getRow2() - preferredSize.getRow1()) + clientAnchor.getRow1();
        clientAnchor.setCol2((preferredSize.getCol2() - preferredSize.getCol1()) + clientAnchor.getCol1());
        clientAnchor.setDx1(0);
        clientAnchor.setDx2(preferredSize.getDx2());
        clientAnchor.setRow2(row2);
        clientAnchor.setDy1(0);
        clientAnchor.setDy2(preferredSize.getDy2());
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public XSSFClientAnchor getPreferredSize() {
        return getPreferredSize(1.0d);
    }

    public XSSFClientAnchor getPreferredSize(double d) {
        double d6;
        XSSFClientAnchor clientAnchor = getClientAnchor();
        if (clientAnchor == null) {
            LOG.atWarn().log("picture is not anchored via client anchor - ignoring resize call");
            return null;
        }
        XSSFPictureData pictureData = getPictureData();
        Dimension imageDimension = getImageDimension(pictureData.getPackagePart(), pictureData.getPictureType());
        double width = imageDimension.getWidth() * d;
        double height = imageDimension.getHeight() * d;
        int col1 = clientAnchor.getCol1() - 1;
        float columnWidthInPixels = 0.0f;
        while (true) {
            d6 = columnWidthInPixels;
            if (d6 > width) {
                break;
            }
            col1++;
            columnWidthInPixels += getColumnWidthInPixels(col1);
        }
        int columnWidthInPixels2 = (int) ((((double) getColumnWidthInPixels(col1)) - (d6 - width)) * 9525.0d);
        clientAnchor.setCol2(col1);
        clientAnchor.setDx2(columnWidthInPixels2);
        int row1 = clientAnchor.getRow1() - 1;
        double rowHeightInPixels = 0.0d;
        while (rowHeightInPixels <= height) {
            row1++;
            rowHeightInPixels += (double) getRowHeightInPixels(row1);
        }
        int rowHeightInPixels2 = (int) ((((double) getRowHeightInPixels(row1)) - (rowHeightInPixels - height)) * 9525.0d);
        clientAnchor.setRow2(row1);
        clientAnchor.setDy2(rowHeightInPixels2);
        CTPositiveSize2D ext = getCTPicture().getSpPr().getXfrm().getExt();
        ext.setCx((long) (width * 9525.0d));
        ext.setCy((long) (height * 9525.0d));
        return clientAnchor;
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public Dimension getImageDimension() {
        return this._picture.getImageDimension();
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public void resize(double d, double d6) {
        this._picture.resize(d, d6);
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public XSSFClientAnchor getPreferredSize(double d, double d6) {
        return this._picture.getPreferredSize(d, d6);
    }
}
