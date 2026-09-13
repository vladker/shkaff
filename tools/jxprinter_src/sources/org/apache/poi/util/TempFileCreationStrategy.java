package org.apache.poi.util;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface TempFileCreationStrategy {
    File createTempDirectory(String str);

    File createTempFile(String str, String str2);
}
