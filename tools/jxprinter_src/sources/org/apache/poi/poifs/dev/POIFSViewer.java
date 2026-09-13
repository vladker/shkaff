package org.apache.poi.poifs.dev;

import androidx.collection.a;
import com.alibaba.android.arouter.utils.Consts;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class POIFSViewer {
    private POIFSViewer() {
    }

    public static void main(String[] strArr) {
        if (strArr.length == 0) {
            System.err.println("Must specify at least one file to view");
            System.exit(1);
        }
        boolean z6 = strArr.length > 1;
        for (String str : strArr) {
            viewFile(str, z6);
        }
    }

    private static void viewFile(String str, boolean z6) {
        if (z6) {
            StringBuilder sbR = a.r(Consts.DOT);
            for (int i5 = 0; i5 < str.length(); i5++) {
                sbR.append(ProcessIdUtil.DEFAULT_PROCESSID);
            }
            sbR.append(Consts.DOT);
            System.out.println(sbR);
            System.out.println("|" + str + "|");
            System.out.println(sbR);
        }
        try {
            POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem(new File(str));
            Iterator<String> it = POIFSViewEngine.inspectViewable(pOIFSFileSystem, true, 0, "  ").iterator();
            while (it.hasNext()) {
                System.out.print(it.next());
            }
            pOIFSFileSystem.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
