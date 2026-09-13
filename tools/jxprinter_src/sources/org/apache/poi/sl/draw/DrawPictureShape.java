package org.apache.poi.sl.draw;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.common.usermodel.PictureType;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.PictureShape;
import org.apache.poi.sl.usermodel.RectAlign;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DrawPictureShape extends DrawSimpleShape {
    private static final Logger LOG = LogManager.getLogger((Class<?>) DrawPictureShape.class);

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.DrawPictureShape$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$RectAlign;

        static {
            int[] iArr = new int[RectAlign.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$RectAlign = iArr;
            try {
                iArr[RectAlign.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.BOTTOM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.BOTTOM_LEFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.LEFT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.TOP_LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public DrawPictureShape(PictureShape<?, ?> pictureShape) {
        super(pictureShape);
    }

    public static ImageRenderer getImageRenderer(Graphics2D graphics2D, String str) {
        ImageRenderer imageRenderer = graphics2D != null ? (ImageRenderer) graphics2D.getRenderingHint(Drawable.IMAGE_RENDERER) : null;
        if (imageRenderer != null && imageRenderer.canRender(str)) {
            return imageRenderer;
        }
        BitmapImageRenderer bitmapImageRenderer = new BitmapImageRenderer();
        if (bitmapImageRenderer.canRender(str)) {
            return bitmapImageRenderer;
        }
        Iterator it = ServiceLoader.load(ImageRenderer.class, DrawPictureShape.class.getClassLoader()).iterator();
        while (true) {
            try {
                ImageRenderer imageRenderer2 = (ImageRenderer) it.next();
                if (imageRenderer2.canRender(str)) {
                    return imageRenderer2;
                }
            } catch (NoSuchElementException unused) {
                LOG.atWarn().log("No suitable image renderer found for content-type '{}' - include poi-scratchpad (for wmf/emf) or poi-ooxml (for svg) jars - svgs/batik doesn't work on the module-path!", str);
                return bitmapImageRenderer;
            } catch (Exception | ServiceConfigurationError unused2) {
            }
        }
    }

    @Override // org.apache.poi.sl.draw.DrawShape, org.apache.poi.sl.draw.Drawable
    public void drawContent(Graphics2D graphics2D) {
        PictureShape<?, ?> shape = getShape();
        Rectangle2D anchor = DrawShape.getAnchor(graphics2D, shape);
        Insets clipping = shape.getClipping();
        PictureData[] pictureDataArr = {shape.getAlternativePictureData(), shape.getPictureData()};
        for (int i5 = 0; i5 < 2; i5++) {
            PictureData pictureData = pictureDataArr[i5];
            if (pictureData != null) {
                try {
                    byte[] data = pictureData.getData();
                    PictureType pictureTypeValueOf = PictureType.valueOf(FileMagic.valueOf(data));
                    String contentType = pictureTypeValueOf == PictureType.UNKNOWN ? pictureData.getContentType() : pictureTypeValueOf.getContentType();
                    ImageRenderer imageRenderer = getImageRenderer(graphics2D, contentType);
                    if (imageRenderer.canRender(contentType)) {
                        imageRenderer.loadImage(data, contentType);
                        imageRenderer.drawImage(graphics2D, anchor, clipping);
                        return;
                    }
                    continue;
                } catch (IOException e) {
                    LOG.atError().withThrowable(e).log("image can't be loaded/rendered.");
                }
            }
        }
    }

    @Override // org.apache.poi.sl.draw.DrawSimpleShape
    public Paint getFillPaint(Graphics2D graphics2D) {
        return null;
    }

    public void resize() {
        PictureShape<?, ?> shape = getShape();
        Dimension imageDimension = shape.getPictureData().getImageDimension();
        Rectangle2D anchor = shape.getAnchor();
        shape.setAnchor(new Rectangle2D.Double(anchor.getX(), anchor.getY(), imageDimension.getWidth(), imageDimension.getHeight()));
    }

    @Override // org.apache.poi.sl.draw.DrawSimpleShape, org.apache.poi.sl.draw.DrawShape
    public PictureShape<?, ?> getShape() {
        return (PictureShape) this.shape;
    }

    public void resize(Rectangle2D rectangle2D) {
        resize(rectangle2D, RectAlign.CENTER);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void resize(Rectangle2D rectangle2D, RectAlign rectAlign) {
        double height;
        PictureShape<?, ?> shape = getShape();
        Dimension imageDimension = shape.getPictureData().getImageDimension();
        if (imageDimension.width > 0 && imageDimension.height > 0) {
            double width = rectangle2D.getWidth();
            double height2 = rectangle2D.getHeight();
            double d = width / ((double) imageDimension.width);
            double d6 = height2 / ((double) imageDimension.height);
            double width2 = 0.0d;
            if (d > d6) {
                width = d6 * ((double) imageDimension.width);
                width2 = rectangle2D.getWidth() - width;
                height = 0.0d;
            } else if (d6 > d) {
                height2 = ((double) imageDimension.height) * d;
                height = rectangle2D.getHeight() - height2;
            } else {
                shape.setAnchor(rectangle2D);
                return;
            }
            double d7 = width;
            double d8 = height2;
            double x6 = rectangle2D.getX();
            double y6 = rectangle2D.getY();
            switch (AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$RectAlign[rectAlign.ordinal()]) {
                case 1:
                    x6 += width2 / 2.0d;
                    break;
                case 2:
                    x6 += width2;
                    break;
                case 3:
                    x6 += width2;
                    y6 += height / 2.0d;
                    break;
                case 4:
                    x6 += width2;
                    y6 += height;
                    break;
                case 5:
                    x6 += width2 / 2.0d;
                    y6 += height;
                    break;
                case 6:
                    y6 += height;
                    break;
                case 7:
                    y6 += height / 2.0d;
                    break;
                case 8:
                    break;
                default:
                    x6 += width2 / 2.0d;
                    y6 += height / 2.0d;
                    break;
            }
            shape.setAnchor(new Rectangle2D.Double(x6, y6, d7, d8));
            return;
        }
        shape.setAnchor(rectangle2D);
    }
}
