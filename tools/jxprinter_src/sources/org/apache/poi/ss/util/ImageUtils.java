package org.apache.poi.ss.util;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.Units;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ImageUtils {
    private static final int HEIGHT_UNITS = 256;
    private static final Logger LOG = LogManager.getLogger((Class<?>) ImageUtils.class);
    private static final int WIDTH_UNITS = 1024;

    private ImageUtils() {
    }

    private static int getDimFromCell(double d, int i5, int i6, int i7, int i8, int i9, Function<Integer, Number> function) {
        double d6;
        double d7;
        double d8;
        int i10 = i5;
        double d9 = 9525.0d;
        if (i7 < i10) {
            d6 = d * 9525.0d;
        } else {
            int i11 = i10;
            double d10 = 0.0d;
            while (i11 <= i7) {
                double dDoubleValue = function.apply(Integer.valueOf(i11)).doubleValue() * d9;
                if (i11 == i10) {
                    d7 = i6;
                    if (i9 > 0) {
                        d7 = (d7 * dDoubleValue) / ((double) i9);
                    }
                } else {
                    d7 = 0.0d;
                }
                if (i11 == i7) {
                    d8 = i9 > 0 ? (((double) (i9 - i8)) * dDoubleValue) / ((double) i9) : dDoubleValue - ((double) i8);
                } else {
                    d8 = 0.0d;
                }
                d10 += (dDoubleValue - d7) - d8;
                i11++;
                i10 = i5;
                d9 = 9525.0d;
            }
            d6 = d10;
        }
        return (int) Math.rint(d6);
    }

    public static Dimension getDimensionFromAnchor(Picture picture) {
        Dimension imageDimension;
        ClientAnchor clientAnchor = picture.getClientAnchor();
        boolean z6 = clientAnchor instanceof HSSFClientAnchor;
        Sheet sheet = picture.getSheet();
        if (clientAnchor.getCol2() < clientAnchor.getCol1() || clientAnchor.getRow2() < clientAnchor.getRow1()) {
            PictureData pictureData = picture.getPictureData();
            imageDimension = getImageDimension(new UnsynchronizedByteArrayInputStream(pictureData.getData()), pictureData.getPictureType());
        } else {
            imageDimension = null;
        }
        double width = imageDimension == null ? 0.0d : imageDimension.getWidth();
        short col1 = clientAnchor.getCol1();
        int dx1 = clientAnchor.getDx1();
        short col2 = clientAnchor.getCol2();
        int dx2 = clientAnchor.getDx2();
        int i5 = z6 ? 1024 : 0;
        sheet.getClass();
        return new Dimension(getDimFromCell(width, col1, dx1, col2, dx2, i5, new d(sheet, 0)), getDimFromCell(imageDimension != null ? imageDimension.getHeight() : 0.0d, clientAnchor.getRow1(), clientAnchor.getDy1(), clientAnchor.getRow2(), clientAnchor.getDy2(), z6 ? 256 : 0, new d(sheet, 2)));
    }

    public static Dimension getImageDimension(InputStream inputStream, int i5) {
        Dimension dimension = new Dimension();
        if (i5 != 5 && i5 != 6 && i5 != 7) {
            LOG.atWarn().log("Only JPEG, PNG and DIB pictures can be automatically sized");
            return dimension;
        }
        try {
            ImageInputStream imageInputStreamCreateImageInputStream = ImageIO.createImageInputStream(inputStream);
            try {
                Iterator imageReaders = ImageIO.getImageReaders(imageInputStreamCreateImageInputStream);
                if (imageReaders.hasNext()) {
                    ImageReader imageReader = (ImageReader) imageReaders.next();
                    try {
                        imageReader.setInput(imageInputStreamCreateImageInputStream);
                        BufferedImage bufferedImage = imageReader.read(0);
                        int[] resolution = getResolution(imageReader);
                        if (resolution[0] == 0) {
                            resolution[0] = 96;
                        }
                        if (resolution[1] == 0) {
                            resolution[1] = 96;
                        }
                        dimension.width = (bufferedImage.getWidth() * 96) / resolution[0];
                        dimension.height = (bufferedImage.getHeight() * 96) / resolution[1];
                        imageReader.dispose();
                    } catch (Throwable th) {
                        imageReader.dispose();
                        throw th;
                    }
                } else {
                    LOG.atWarn().log("ImageIO found no images");
                }
                if (imageInputStreamCreateImageInputStream == null) {
                    return dimension;
                }
                imageInputStreamCreateImageInputStream.close();
                return dimension;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    if (imageInputStreamCreateImageInputStream != null) {
                        try {
                            imageInputStreamCreateImageInputStream.close();
                        } catch (Throwable th4) {
                            th2.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            }
        } catch (IOException e) {
            LOG.atWarn().withThrowable(e).log("Failed to determine image dimensions");
            return dimension;
        }
    }

    public static int[] getResolution(ImageReader imageReader) {
        Element element = (Element) imageReader.getImageMetadata(0).getAsTree("javax_imageio_1.0");
        NodeList elementsByTagName = element.getElementsByTagName("HorizontalPixelSize");
        int i5 = 96;
        int i6 = (elementsByTagName == null || elementsByTagName.getLength() != 1) ? 96 : (int) (25.4d / ((double) Float.parseFloat(((Element) elementsByTagName.item(0)).getAttribute("value"))));
        NodeList elementsByTagName2 = element.getElementsByTagName("VerticalPixelSize");
        if (elementsByTagName2 != null && elementsByTagName2.getLength() == 1) {
            i5 = (int) (25.4d / ((double) Float.parseFloat(((Element) elementsByTagName2.item(0)).getAttribute("value"))));
        }
        return new int[]{i6, i5};
    }

    public static double getRowHeightInPixels(Sheet sheet, int i5) {
        Row row = sheet.getRow(i5);
        return ((double) Units.toEMU(row == null ? sheet.getDefaultRowHeightInPoints() : row.getHeightInPoints())) / 9525.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Number lambda$getDimensionFromAnchor$1(Sheet sheet, Integer num) {
        return Double.valueOf(getRowHeightInPixels(sheet, num.intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Number lambda$setPreferredSize$0(Sheet sheet, Integer num) {
        return Double.valueOf(getRowHeightInPixels(sheet, num.intValue()));
    }

    private static void scaleCell(double d, int i5, int i6, Consumer<Integer> consumer, Consumer<Integer> consumer2, int i7, Function<Integer, Number> function) {
        double dDoubleValue;
        double d6;
        double d7;
        double d8;
        double d9 = 0.0d;
        if (d < 0.0d) {
            throw new IllegalArgumentException("target size < 0");
        }
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("target size " + d + " is not supported");
        }
        int i8 = i5;
        while (true) {
            dDoubleValue = function.apply(Integer.valueOf(i8)).doubleValue();
            if (i8 != i5) {
                d6 = 9525.0d;
                d7 = dDoubleValue;
            } else if (i7 > 0) {
                d6 = 9525.0d;
                d7 = (1.0d - (((double) i6) / ((double) i7))) * dDoubleValue;
            } else {
                d6 = 9525.0d;
                d7 = dDoubleValue - (((double) i6) / 9525.0d);
            }
            d8 = d - d9;
            if (d8 < d7) {
                break;
            }
            i8++;
            d9 += d7;
        }
        double d10 = i7 > 0 ? (d8 / dDoubleValue) * ((double) i7) : d8 * d6;
        if (i8 == i5) {
            d10 += (double) i6;
        }
        consumer.accept(Integer.valueOf(i8));
        consumer2.accept(Integer.valueOf((int) Math.rint(d10)));
    }

    public static Dimension setPreferredSize(Picture picture, double d, double d6) {
        final ClientAnchor clientAnchor = picture.getClientAnchor();
        boolean z6 = clientAnchor instanceof HSSFClientAnchor;
        PictureData pictureData = picture.getPictureData();
        Sheet sheet = picture.getSheet();
        Dimension imageDimension = (d == Double.MAX_VALUE || d6 == Double.MAX_VALUE) ? getImageDimension(new UnsynchronizedByteArrayInputStream(pictureData.getData()), pictureData.getPictureType()) : new Dimension();
        Dimension dimension = (d == Double.MAX_VALUE && d6 == Double.MAX_VALUE) ? new Dimension() : getDimensionFromAnchor(picture);
        double width = d == Double.MAX_VALUE ? imageDimension.getWidth() : (dimension.getWidth() / 9525.0d) * d;
        double height = d6 == Double.MAX_VALUE ? imageDimension.getHeight() : (dimension.getHeight() / 9525.0d) * d6;
        short col1 = clientAnchor.getCol1();
        int dx1 = clientAnchor.getDx1();
        final int i5 = 0;
        Consumer consumer = new Consumer() { // from class: org.apache.poi.ss.util.c
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                int i6 = i5;
                int iIntValue = ((Integer) obj).intValue();
                switch (i6) {
                    case 0:
                        clientAnchor.setCol2(iIntValue);
                        break;
                    case 1:
                        clientAnchor.setDx2(iIntValue);
                        break;
                    case 2:
                        clientAnchor.setRow2(iIntValue);
                        break;
                    default:
                        clientAnchor.setDy2(iIntValue);
                        break;
                }
            }
        };
        final int i6 = 1;
        Consumer consumer2 = new Consumer() { // from class: org.apache.poi.ss.util.c
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                int i7 = i6;
                int iIntValue = ((Integer) obj).intValue();
                switch (i7) {
                    case 0:
                        clientAnchor.setCol2(iIntValue);
                        break;
                    case 1:
                        clientAnchor.setDx2(iIntValue);
                        break;
                    case 2:
                        clientAnchor.setRow2(iIntValue);
                        break;
                    default:
                        clientAnchor.setDy2(iIntValue);
                        break;
                }
            }
        };
        int i7 = z6 ? 1024 : 0;
        sheet.getClass();
        scaleCell(width, col1, dx1, consumer, consumer2, i7, new d(sheet, 0));
        final int i8 = 2;
        final int i9 = 3;
        double d7 = height;
        scaleCell(d7, clientAnchor.getRow1(), clientAnchor.getDy1(), new Consumer() { // from class: org.apache.poi.ss.util.c
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                int i10 = i8;
                int iIntValue = ((Integer) obj).intValue();
                switch (i10) {
                    case 0:
                        clientAnchor.setCol2(iIntValue);
                        break;
                    case 1:
                        clientAnchor.setDx2(iIntValue);
                        break;
                    case 2:
                        clientAnchor.setRow2(iIntValue);
                        break;
                    default:
                        clientAnchor.setDy2(iIntValue);
                        break;
                }
            }
        }, new Consumer() { // from class: org.apache.poi.ss.util.c
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                int i10 = i9;
                int iIntValue = ((Integer) obj).intValue();
                switch (i10) {
                    case 0:
                        clientAnchor.setCol2(iIntValue);
                        break;
                    case 1:
                        clientAnchor.setDx2(iIntValue);
                        break;
                    case 2:
                        clientAnchor.setRow2(iIntValue);
                        break;
                    default:
                        clientAnchor.setDy2(iIntValue);
                        break;
                }
            }
        }, z6 ? 256 : 0, new d(sheet, 1));
        return new Dimension((int) Math.round(width * 9525.0d), (int) Math.round(d7 * 9525.0d));
    }
}
