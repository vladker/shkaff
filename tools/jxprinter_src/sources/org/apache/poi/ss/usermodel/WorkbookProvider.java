package org.apache.poi.ss.usermodel;

import java.io.File;
import java.io.InputStream;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.FileMagic;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface WorkbookProvider {
    boolean accepts(FileMagic fileMagic);

    Workbook create();

    Workbook create(File file, String str, boolean z6);

    Workbook create(InputStream inputStream);

    Workbook create(InputStream inputStream, String str);

    Workbook create(DirectoryNode directoryNode, String str);
}
