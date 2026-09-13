package org.apache.poi.xslf.util;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.sl.draw.EmbeddedExtractor;
import org.apache.poi.sl.usermodel.ObjectData;
import org.apache.poi.sl.usermodel.ObjectShape;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.Slide;
import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.sl.usermodel.SlideShowFactory;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
class PPTHandler extends MFProxy {
    private static final String RANGE_PATTERN = "(^|,)(?<from>\\d+)?(-(?<to>\\d+))?";
    private SlideShow<?, ?> ppt;
    private Slide<?, ?> slide;

    /* JADX INFO: Access modifiers changed from: private */
    public static EmbeddedExtractor.EmbeddedPart fromObjectShape(Shape<?, ?> shape) {
        final ObjectData objectData = ((ObjectShape) shape).getObjectData();
        EmbeddedExtractor.EmbeddedPart embeddedPart = new EmbeddedExtractor.EmbeddedPart();
        embeddedPart.setName(objectData.getFileName());
        embeddedPart.setData(new Supplier() { // from class: org.apache.poi.xslf.util.d
            @Override // java.util.function.Supplier
            public final Object get() {
                return PPTHandler.lambda$fromObjectShape$3(objectData);
            }
        });
        return embeddedPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] lambda$fromObjectShape$3(ObjectData objectData) {
        try {
            InputStream inputStream = objectData.getInputStream();
            try {
                byte[] byteArray = IOUtils.toByteArray(inputStream);
                if (inputStream != null) {
                    inputStream.close();
                }
                return byteArray;
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
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Iterator lambda$getEmbeddings$2(int i5) {
        int i6 = 0;
        return ((Slide) this.ppt.getSlides().get(i5)).getShapes().stream().filter(new g(i6)).map(new h(i6)).iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$null$1(Shape shape) {
        return shape instanceof ObjectShape;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$range$0(int i5, int i6) {
        return i6 <= i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Stream<Integer> range(Matcher matcher) {
        int i5;
        final int size = this.ppt.getSlides().size();
        String strGroup = matcher.group(TypedValues.TransitionType.S_FROM);
        String strGroup2 = matcher.group(TypedValues.TransitionType.S_TO);
        int i6 = (strGroup == null || strGroup.isEmpty()) ? 1 : Integer.parseInt(strGroup);
        if (strGroup2 == null) {
            i5 = i6;
        } else {
            i5 = (strGroup2.isEmpty() || ((strGroup == null || strGroup.isEmpty()) && "1".equals(strGroup2))) ? size : Integer.parseInt(strGroup2);
        }
        return IntStream.rangeClosed(i6, i5).filter(new IntPredicate() { // from class: org.apache.poi.xslf.util.j
            @Override // java.util.function.IntPredicate
            public final boolean test(int i7) {
                return PPTHandler.lambda$range$0(size, i7);
            }
        }).boxed();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        SlideShow<?, ?> slideShow = this.ppt;
        if (slideShow != null) {
            slideShow.close();
        }
    }

    @Override // org.apache.poi.xslf.util.MFProxy
    public void draw(Graphics2D graphics2D) {
        this.slide.draw(graphics2D);
    }

    @Override // org.apache.poi.xslf.util.MFProxy
    public Iterable<EmbeddedExtractor.EmbeddedPart> getEmbeddings(final int i5) {
        return new Iterable() { // from class: org.apache.poi.xslf.util.i
            @Override // java.lang.Iterable
            public final Iterator iterator() {
                return this.f7339a.lambda$getEmbeddings$2(i5);
            }
        };
    }

    @Override // org.apache.poi.xslf.util.MFProxy
    public GenericRecord getRoot() {
        SlideShow<?, ?> slideShow = this.ppt;
        if (slideShow instanceof GenericRecord) {
            return (GenericRecord) slideShow;
        }
        return null;
    }

    @Override // org.apache.poi.xslf.util.MFProxy
    public Dimension2D getSize() {
        return this.ppt.getPageSize();
    }

    @Override // org.apache.poi.xslf.util.MFProxy
    public int getSlideCount() {
        return this.ppt.getSlides().size();
    }

    @Override // org.apache.poi.xslf.util.MFProxy
    public String getTitle() {
        return this.slide.getTitle();
    }

    @Override // org.apache.poi.xslf.util.MFProxy
    public void parse(File file) throws IOException {
        try {
            SlideShow<?, ?> slideShowCreate = SlideShowFactory.create(file, null, true);
            this.ppt = slideShowCreate;
            if (slideShowCreate == null) {
                throw new IOException("Unknown file format or missing poi-scratchpad.jar / poi-ooxml.jar");
            }
            this.slide = (Slide) slideShowCreate.getSlides().get(0);
        } catch (IOException e) {
            if (!e.getMessage().contains("scratchpad")) {
                throw e;
            }
            throw new PPTX2PNG.NoScratchpadException(e);
        }
    }

    @Override // org.apache.poi.xslf.util.MFProxy
    public void setSlideNo(int i5) {
        this.slide = (Slide) this.ppt.getSlides().get(i5 - 1);
    }

    @Override // org.apache.poi.xslf.util.MFProxy
    public Set<Integer> slideIndexes(String str) {
        final Matcher matcher = Pattern.compile(RANGE_PATTERN).matcher(str);
        return (Set) StreamSupport.stream(new Spliterators.AbstractSpliterator<Matcher>(str.length(), 272) { // from class: org.apache.poi.xslf.util.PPTHandler.1
            @Override // java.util.Spliterator
            public boolean tryAdvance(Consumer<? super Matcher> consumer) {
                boolean zFind = matcher.find();
                if (zFind) {
                    consumer.accept(matcher);
                }
                return zFind;
            }
        }, false).flatMap(new Function() { // from class: org.apache.poi.xslf.util.e
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f7336a.range((Matcher) obj);
            }
        }).collect(Collectors.toCollection(new f()));
    }

    @Override // org.apache.poi.xslf.util.MFProxy
    public void parse(InputStream inputStream) throws IOException {
        try {
            SlideShow<?, ?> slideShowCreate = SlideShowFactory.create(inputStream, (String) null);
            this.ppt = slideShowCreate;
            if (slideShowCreate != null) {
                this.slide = (Slide) slideShowCreate.getSlides().get(0);
                return;
            }
            throw new IOException("Unknown file format or missing poi-scratchpad.jar / poi-ooxml.jar");
        } catch (IOException e) {
            if (e.getMessage().contains("scratchpad")) {
                throw new PPTX2PNG.NoScratchpadException(e);
            }
            throw e;
        }
    }

    @Override // org.apache.poi.xslf.util.MFProxy
    public void setDefaultCharset(Charset charset) {
    }
}
