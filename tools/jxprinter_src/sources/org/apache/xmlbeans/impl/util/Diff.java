package org.apache.xmlbeans.impl.util;

import A3.AbstractC0157z;
import androidx.collection.a;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Diff {
    public static void readersAsText(Reader reader, String str, Reader reader2, String str2, List list) throws IOException {
        LineNumberReader lineNumberReader = new LineNumberReader(reader);
        LineNumberReader lineNumberReader2 = new LineNumberReader(reader2);
        String line = lineNumberReader.readLine();
        String line2 = lineNumberReader2.readLine();
        while (line != null && line2 != null) {
            if (!line.equals(line2)) {
                StringBuilder sbU = a.u("File \"", str, "\" and file \"", str2, "\" differ at line ");
                sbU.append(lineNumberReader.getLineNumber());
                sbU.append(":\n");
                sbU.append(line);
                sbU.append("\n========\n");
                sbU.append(line2);
                list.add(sbU.toString());
                break;
            }
            line = lineNumberReader.readLine();
            line2 = lineNumberReader2.readLine();
        }
        if (line == null && line2 != null) {
            StringBuilder sbY = AbstractC0157z.y("File \"", str2, "\" has extra lines at line ");
            sbY.append(lineNumberReader2.getLineNumber());
            sbY.append(":\n");
            sbY.append(line2);
            list.add(sbY.toString());
        }
        if (line == null || line2 != null) {
            return;
        }
        StringBuilder sbY2 = AbstractC0157z.y("File \"", str, "\" has extra lines at line ");
        sbY2.append(lineNumberReader.getLineNumber());
        sbY2.append(":\n");
        sbY2.append(line);
        list.add(sbY2.toString());
    }
}
