package org.apache.poi.sl.draw;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.RescaleOp;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.MemoryCacheImageInputStream;
import org.apache.commons.collections4.iterators.IteratorIterable;
import org.apache.commons.compress.compressors.bzip2.BZip2Constants;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.util.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BitmapImageRenderer implements ImageRenderer {
    private static final ImageLoader[] IMAGE_LOADERS;
    private static final String UNSUPPORTED_IMAGE_TYPE = "Unsupported Image Type";
    private String cachedContentType;
    private byte[] cachedImage;
    private boolean doCache;
    protected BufferedImage img;
    private static final Logger LOG = LogManager.getLogger((Class<?>) BitmapImageRenderer.class);
    private static final PictureData.PictureType[] ALLOWED_TYPES = {PictureData.PictureType.JPEG, PictureData.PictureType.PNG, PictureData.PictureType.BMP, PictureData.PictureType.GIF};

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ImageLoader {
        BufferedImage load(ImageReader imageReader, ImageInputStream imageInputStream, ImageReadParam imageReadParam);
    }

    static {
        final int i5 = 0;
        final int i6 = 1;
        final int i7 = 2;
        IMAGE_LOADERS = new ImageLoader[]{new ImageLoader() { // from class: org.apache.poi.sl.draw.d
            @Override // org.apache.poi.sl.draw.BitmapImageRenderer.ImageLoader
            public final BufferedImage load(ImageReader imageReader, ImageInputStream imageInputStream, ImageReadParam imageReadParam) {
                switch (i5) {
                    case 0:
                        return BitmapImageRenderer.loadColored(imageReader, imageInputStream, imageReadParam);
                    case 1:
                        return BitmapImageRenderer.loadGrayScaled(imageReader, imageInputStream, imageReadParam);
                    default:
                        return BitmapImageRenderer.loadTruncated(imageReader, imageInputStream, imageReadParam);
                }
            }
        }, new ImageLoader() { // from class: org.apache.poi.sl.draw.d
            @Override // org.apache.poi.sl.draw.BitmapImageRenderer.ImageLoader
            public final BufferedImage load(ImageReader imageReader, ImageInputStream imageInputStream, ImageReadParam imageReadParam) {
                switch (i6) {
                    case 0:
                        return BitmapImageRenderer.loadColored(imageReader, imageInputStream, imageReadParam);
                    case 1:
                        return BitmapImageRenderer.loadGrayScaled(imageReader, imageInputStream, imageReadParam);
                    default:
                        return BitmapImageRenderer.loadTruncated(imageReader, imageInputStream, imageReadParam);
                }
            }
        }, new ImageLoader() { // from class: org.apache.poi.sl.draw.d
            @Override // org.apache.poi.sl.draw.BitmapImageRenderer.ImageLoader
            public final BufferedImage load(ImageReader imageReader, ImageInputStream imageInputStream, ImageReadParam imageReadParam) {
                switch (i7) {
                    case 0:
                        return BitmapImageRenderer.loadColored(imageReader, imageInputStream, imageReadParam);
                    case 1:
                        return BitmapImageRenderer.loadGrayScaled(imageReader, imageInputStream, imageReadParam);
                    default:
                        return BitmapImageRenderer.loadTruncated(imageReader, imageInputStream, imageReadParam);
                }
            }
        }};
    }

    private static int findTruncatedBlackBox(BufferedImage bufferedImage, int i5, int i6) {
        for (int i7 = i6 - 1; i7 > 0; i7--) {
            int i8 = i5 - 1;
            while (i8 > 0) {
                if (bufferedImage.getRGB(i8, i7) != -16777216) {
                    return i7 + 1;
                }
                i8 -= i5 / 10;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$canRender$0(String str, PictureData.PictureType pictureType) {
        return pictureType.contentType.equalsIgnoreCase(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$loadGrayScaled$1(ImageTypeSpecifier imageTypeSpecifier) {
        return imageTypeSpecifier.getBufferedImageType() == 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BufferedImage loadColored(ImageReader imageReader, ImageInputStream imageInputStream, ImageReadParam imageReadParam) {
        imageReader.setInput(imageInputStream, false, true);
        return imageReader.read(0, imageReadParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BufferedImage loadGrayScaled(ImageReader imageReader, ImageInputStream imageInputStream, final ImageReadParam imageReadParam) {
        Optional optionalFindFirst = StreamSupport.stream(new IteratorIterable(imageReader.getImageTypes(0)).spliterator(), false).filter(new b()).findFirst();
        imageReadParam.getClass();
        optionalFindFirst.ifPresent(new Consumer() { // from class: org.apache.poi.sl.draw.c
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                imageReadParam.setDestinationType((ImageTypeSpecifier) obj);
            }
        });
        imageReader.setInput(imageInputStream, false, true);
        return imageReader.read(0, imageReadParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BufferedImage loadTruncated(ImageReader imageReader, ImageInputStream imageInputStream, ImageReadParam imageReadParam) {
        int iFindTruncatedBlackBox;
        imageReader.setInput(imageInputStream, false, true);
        int height = imageReader.getHeight(0);
        int width = imageReader.getWidth(0);
        Iterator imageTypes = imageReader.getImageTypes(0);
        if (!imageTypes.hasNext()) {
            return null;
        }
        BufferedImage bufferedImageCreateBufferedImage = ((ImageTypeSpecifier) imageTypes.next()).createBufferedImage(width, height);
        imageReadParam.setDestination(bufferedImageCreateBufferedImage);
        try {
            imageReader.read(0, imageReadParam);
        } catch (IOException unused) {
        }
        if (bufferedImageCreateBufferedImage.getColorModel().hasAlpha() || (iFindTruncatedBlackBox = findTruncatedBlackBox(bufferedImageCreateBufferedImage, width, height)) >= height) {
            return bufferedImageCreateBufferedImage;
        }
        BufferedImage bufferedImage = new BufferedImage(width, height, 2);
        Graphics2D graphics2DCreateGraphics = bufferedImage.createGraphics();
        graphics2DCreateGraphics.clipRect(0, 0, width, iFindTruncatedBlackBox);
        graphics2DCreateGraphics.drawImage(bufferedImageCreateBufferedImage, 0, 0, (ImageObserver) null);
        graphics2DCreateGraphics.dispose();
        bufferedImageCreateBufferedImage.flush();
        return bufferedImage;
    }

    private static BufferedImage readImage(InputStream inputStream, String str) throws IOException {
        ImageInputStream memoryCacheImageInputStream = new MemoryCacheImageInputStream(inputStream);
        try {
            Iterator imageReaders = ImageIO.getImageReaders(memoryCacheImageInputStream);
            BufferedImage bufferedImageLoad = null;
            IOException iOException = null;
            while (true) {
                if (bufferedImageLoad != null || !imageReaders.hasNext()) {
                    break;
                }
                ImageReader imageReader = (ImageReader) imageReaders.next();
                ImageReadParam defaultReadParam = imageReader.getDefaultReadParam();
                IOException e = null;
                for (ImageLoader imageLoader : IMAGE_LOADERS) {
                    memoryCacheImageInputStream.reset();
                    memoryCacheImageInputStream.mark();
                    try {
                        bufferedImageLoad = imageLoader.load(imageReader, memoryCacheImageInputStream, defaultReadParam);
                        if (bufferedImageLoad != null) {
                            break;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        if (UNSUPPORTED_IMAGE_TYPE.equals(e.getMessage())) {
                            break;
                        }
                    } catch (RuntimeException e7) {
                        e = new IOException("ImageIO runtime exception", e7);
                    }
                }
                imageReader.dispose();
                iOException = e;
            }
            memoryCacheImageInputStream.close();
            if (bufferedImageLoad == null) {
                if (iOException != null) {
                    throw iOException;
                }
                LOG.atWarn().log("Content-type: {} is not supported. Image ignored.", str);
                return null;
            }
            if (bufferedImageLoad.getColorModel().hasAlpha()) {
                return bufferedImageLoad;
            }
            BufferedImage bufferedImage = new BufferedImage(bufferedImageLoad.getWidth(), bufferedImageLoad.getHeight(), 2);
            Graphics graphics = bufferedImage.getGraphics();
            graphics.drawImage(bufferedImageLoad, 0, 0, (ImageObserver) null);
            graphics.dispose();
            return bufferedImage;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    memoryCacheImageInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public boolean canRender(final String str) {
        return Stream.of((Object[]) ALLOWED_TYPES).anyMatch(new Predicate() { // from class: org.apache.poi.sl.draw.a
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return BitmapImageRenderer.lambda$canRender$0(str, (PictureData.PictureType) obj);
            }
        });
    }

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public boolean drawImage(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        return drawImage(graphics2D, rectangle2D, null);
    }

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public Rectangle2D getBounds() {
        return this.img == null ? new Rectangle2D.Double() : new Rectangle2D.Double(0.0d, 0.0d, this.img.getWidth(), this.img.getHeight());
    }

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public String getCachedContentType() {
        return this.cachedContentType;
    }

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public byte[] getCachedImage() {
        return this.cachedImage;
    }

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public BufferedImage getImage() {
        return this.img;
    }

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public Rectangle2D getNativeBounds() {
        return new Rectangle2D.Double(0.0d, 0.0d, this.img.getWidth(), this.img.getHeight());
    }

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public void loadImage(InputStream inputStream, String str) {
        if (this.doCache) {
            UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
            try {
                IOUtils.copy(inputStream, unsynchronizedByteArrayOutputStream);
                this.cachedImage = unsynchronizedByteArrayOutputStream.toByteArray();
                this.cachedContentType = str;
                inputStream = unsynchronizedByteArrayOutputStream.toInputStream();
                unsynchronizedByteArrayOutputStream.close();
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
        this.img = readImage(inputStream, str);
    }

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public void setAlpha(double d) {
        this.img = setAlpha(this.img, d);
    }

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public void setCacheInput(boolean z6) {
        this.doCache = z6;
        if (z6) {
            return;
        }
        this.cachedContentType = null;
        this.cachedImage = null;
    }

    public static BufferedImage setAlpha(BufferedImage bufferedImage, double d) {
        if (bufferedImage == null) {
            return new BufferedImage(1, 1, 2);
        }
        return d == 0.0d ? bufferedImage : new RescaleOp(new float[]{1.0f, 1.0f, 1.0f, (float) d}, new float[]{0.0f, 0.0f, 0.0f, 0.0f}, (RenderingHints) null).filter(bufferedImage, (BufferedImage) null);
    }

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public boolean drawImage(Graphics2D graphics2D, Rectangle2D rectangle2D, Insets insets) {
        Insets insets2;
        boolean z6 = false;
        if (this.img == null) {
            return false;
        }
        if (insets == null) {
            insets2 = new Insets(0, 0, 0, 0);
        } else {
            insets2 = insets;
            z6 = true;
        }
        int width = this.img.getWidth();
        int height = this.img.getHeight();
        double d = ((double) ((BZip2Constants.BASEBLOCKSIZE - insets2.left) - insets2.right)) / 100000.0d;
        double d6 = ((double) ((BZip2Constants.BASEBLOCKSIZE - insets2.top) - insets2.bottom)) / 100000.0d;
        boolean z7 = z6;
        double d7 = width;
        double width2 = rectangle2D.getWidth() / (d * d7);
        double d8 = height;
        double height2 = rectangle2D.getHeight() / (d6 * d8);
        AffineTransform affineTransform = new AffineTransform(width2, 0.0d, 0.0d, height2, rectangle2D.getX() - (((d7 * width2) * ((double) insets2.left)) / 100000.0d), rectangle2D.getY() - (((d8 * height2) * ((double) insets2.top)) / 100000.0d));
        Shape clip = graphics2D.getClip();
        if (z7) {
            graphics2D.clip(rectangle2D.getBounds2D());
        }
        graphics2D.drawRenderedImage(this.img, affineTransform);
        graphics2D.setClip(clip);
        return true;
    }

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public BufferedImage getImage(Dimension2D dimension2D) {
        BufferedImage bufferedImage = this.img;
        if (bufferedImage == null) {
            return null;
        }
        double width = bufferedImage.getWidth();
        double height = this.img.getHeight();
        double width2 = dimension2D.getWidth();
        double height2 = dimension2D.getHeight();
        if (width == width2 && height == height2) {
            return this.img;
        }
        BufferedImage bufferedImage2 = new BufferedImage((int) width2, (int) height2, 2);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.scale(width2 / width, height2 / height);
        new AffineTransformOp(affineTransform, 2).filter(this.img, bufferedImage2);
        return bufferedImage2;
    }

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public void loadImage(byte[] bArr, String str) {
        if (bArr == null) {
            return;
        }
        if (this.doCache) {
            this.cachedImage = (byte[]) bArr.clone();
            this.cachedContentType = str;
        }
        this.img = readImage(new UnsynchronizedByteArrayInputStream(bArr), str);
    }
}
