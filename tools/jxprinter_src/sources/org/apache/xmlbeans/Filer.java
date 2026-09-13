package org.apache.xmlbeans;

import java.io.OutputStream;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface Filer {
    OutputStream createBinaryFile(String str);

    Writer createSourceFile(String str);
}
