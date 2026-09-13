package org.apache.poi.sl.usermodel;

import java.io.File;
import java.io.InputStream;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface SlideShowProvider<S extends Shape<S, P>, P extends TextParagraph<S, P, ? extends TextRun>> {
    boolean accepts(FileMagic fileMagic);

    SlideShow<S, P> create();

    SlideShow<S, P> create(File file, String str, boolean z6);

    SlideShow<S, P> create(InputStream inputStream);

    SlideShow<S, P> create(InputStream inputStream, String str);

    SlideShow<S, P> create(DirectoryNode directoryNode, String str);
}
