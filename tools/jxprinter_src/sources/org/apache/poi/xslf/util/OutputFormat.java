package org.apache.poi.xslf.util;

import java.awt.Graphics2D;
import java.io.Closeable;
import java.io.File;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
interface OutputFormat extends Closeable {
    Graphics2D addSlide(double d, double d6);

    void writeSlide(MFProxy mFProxy, File file);

    default void writeDocument(MFProxy mFProxy, File file) {
    }
}
