package org.apache.poi.poifs.dev;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class POIFSViewEngine {
    private static final String _EOL = System.getProperty("line.separator");

    private static String indent(int i5, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i6 = 0; i6 < i5; i6++) {
            sb2.append(str);
        }
        LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(str2));
        try {
            for (String line = lineNumberReader.readLine(); line != null; line = lineNumberReader.readLine()) {
                sb.append((CharSequence) sb2);
                sb.append(line);
                sb.append(_EOL);
            }
        } catch (IOException e) {
            sb.append((CharSequence) sb2);
            sb.append(e.getMessage());
            sb.append(_EOL);
        }
        return sb.toString();
    }

    public static List<String> inspectViewable(Object obj, boolean z6, int i5, String str) {
        ArrayList arrayList = new ArrayList();
        if (!(obj instanceof POIFSViewable)) {
            arrayList.add(indent(i5, str, obj.toString()));
            return arrayList;
        }
        POIFSViewable pOIFSViewable = (POIFSViewable) obj;
        arrayList.add(indent(i5, str, pOIFSViewable.getShortDescription()));
        if (z6) {
            if (pOIFSViewable.preferArray()) {
                for (Object obj2 : pOIFSViewable.getViewableArray()) {
                    arrayList.addAll(inspectViewable(obj2, z6, i5 + 1, str));
                }
            } else {
                Iterator<Object> viewableIterator = pOIFSViewable.getViewableIterator();
                while (viewableIterator.hasNext()) {
                    arrayList.addAll(inspectViewable(viewableIterator.next(), z6, i5 + 1, str));
                }
            }
        }
        return arrayList;
    }
}
