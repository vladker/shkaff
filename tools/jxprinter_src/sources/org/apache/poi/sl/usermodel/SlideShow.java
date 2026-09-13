package org.apache.poi.sl.usermodel;

import java.awt.Dimension;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.common.usermodel.fonts.FontInfo;
import org.apache.poi.extractor.POITextExtractor;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface SlideShow<S extends Shape<S, P>, P extends TextParagraph<S, P, ? extends TextRun>> extends Closeable {
    FontInfo addFont(InputStream inputStream);

    PictureData addPicture(File file, PictureData.PictureType pictureType);

    PictureData addPicture(InputStream inputStream, PictureData.PictureType pictureType);

    PictureData addPicture(byte[] bArr, PictureData.PictureType pictureType);

    MasterSheet<S, P> createMasterSheet();

    Slide<S, P> createSlide();

    PictureData findPictureData(byte[] bArr);

    List<? extends FontInfo> getFonts();

    POITextExtractor getMetadataTextExtractor();

    Dimension getPageSize();

    Object getPersistDocument();

    List<? extends PictureData> getPictureData();

    List<? extends MasterSheet<S, P>> getSlideMasters();

    List<? extends Slide<S, P>> getSlides();

    void setPageSize(Dimension dimension);

    void write(OutputStream outputStream);
}
