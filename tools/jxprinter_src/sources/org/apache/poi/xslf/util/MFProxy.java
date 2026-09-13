package org.apache.poi.xslf.util;

import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.sl.draw.EmbeddedExtractor;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
abstract class MFProxy implements Closeable {
    boolean ignoreParse;
    boolean quiet;

    public abstract void draw(Graphics2D graphics2D);

    public abstract Iterable<EmbeddedExtractor.EmbeddedPart> getEmbeddings(int i5);

    public abstract GenericRecord getRoot();

    public abstract Dimension2D getSize();

    public int getSlideCount() {
        return 1;
    }

    public abstract String getTitle();

    public abstract void parse(File file);

    public abstract void parse(InputStream inputStream);

    public abstract void setDefaultCharset(Charset charset);

    public void setIgnoreParse(boolean z6) {
        this.ignoreParse = z6;
    }

    public void setQuiet(boolean z6) {
        this.quiet = z6;
    }

    public Set<Integer> slideIndexes(String str) {
        return Collections.singleton(1);
    }

    public void setSlideNo(int i5) {
    }
}
