package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.impl.common.DefaultClassLoaderResourceLoader;
import org.apache.xmlbeans.impl.common.IOUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CommandLine {
    private static final File[] EMPTY_FILEARRAY = new File[0];
    private static final URL[] EMPTY_URLARRAY = new URL[0];
    private String[] _args;
    private String[] _badopts;
    private File _baseDir;
    private List<File> _files;
    private Map<String, String> _options;
    private List<URL> _urls;

    public CommandLine(String[] strArr, Collection<String> collection, Collection<String> collection2) {
        if (collection == null || collection2 == null) {
            throw new IllegalArgumentException("collection required (use Collections.EMPTY_SET if no options)");
        }
        this._options = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i5 = 0;
        while (i5 < strArr.length) {
            if (strArr[i5].indexOf(45) == 0) {
                String strSubstring = strArr[i5].substring(1);
                String str = "";
                if (!collection.contains(strSubstring)) {
                    if (collection2.contains(strSubstring)) {
                        int i6 = i5 + 1;
                        if (i6 < strArr.length) {
                            str = strArr[i6];
                            i5 = i6;
                        }
                    } else {
                        arrayList.add(strArr[i5]);
                        str = null;
                    }
                }
                this._options.put(strSubstring, str);
            } else {
                arrayList2.add(strArr[i5]);
            }
            i5++;
        }
        this._badopts = (String[]) arrayList.toArray(new String[arrayList.size()]);
        this._args = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
    }

    private static List<File> collectFiles(File[] fileArr) {
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            if (file.isDirectory()) {
                arrayList.addAll(collectFiles(file.listFiles()));
            } else {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    private List<File> getFileList() {
        if (this._files == null) {
            String[] strArrArgs = args();
            File[] fileArr = new File[strArrArgs.length];
            boolean z6 = false;
            for (int i5 = 0; i5 < strArrArgs.length; i5++) {
                File file = new File(strArrArgs[i5]);
                fileArr[i5] = file;
                if (z6 || this._baseDir != null) {
                    URI uri = file.toURI();
                    File file2 = this._baseDir;
                    if (file2 != null && file2.toURI().relativize(uri).equals(uri)) {
                        this._baseDir = null;
                        z6 = true;
                    }
                } else if (file.isDirectory()) {
                    this._baseDir = fileArr[i5];
                } else {
                    this._baseDir = fileArr[i5].getParentFile();
                }
            }
            this._files = Collections.unmodifiableList(collectFiles(fileArr));
        }
        return this._files;
    }

    private List<URL> getUrlList() {
        if (this._urls == null) {
            String[] strArrArgs = args();
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < strArrArgs.length; i5++) {
                if (looksLikeURL(strArrArgs[i5])) {
                    try {
                        arrayList.add(new URL(strArrArgs[i5]));
                    } catch (MalformedURLException e) {
                        System.err.println("ignoring invalid url: " + strArrArgs[i5] + ": " + e.getMessage());
                    }
                }
            }
            this._urls = Collections.unmodifiableList(arrayList);
        }
        return this._urls;
    }

    private static boolean looksLikeURL(String str) {
        return str.startsWith("http:") || str.startsWith("https:") || str.startsWith("ftp:") || str.startsWith("file:");
    }

    public static void printLicense() {
        try {
            IOUtil.copyCompletely(new DefaultClassLoaderResourceLoader().getResourceAsStream("LICENSE.txt"), System.out);
        } catch (Exception unused) {
            System.out.println("License available in this JAR in LICENSE.txt");
        }
    }

    public static void printVersion() {
        System.out.println(XmlBeans.getVendor() + ", " + XmlBeans.getTitle() + ".XmlBeans version " + XmlBeans.getVersion());
    }

    public String[] args() {
        String[] strArr = this._args;
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }

    public File[] filesEndingWith(String str) {
        ArrayList arrayList = new ArrayList();
        for (File file : getFileList()) {
            if (file.getName().endsWith(str) && !looksLikeURL(file.getPath())) {
                arrayList.add(file);
            }
        }
        return (File[]) arrayList.toArray(EMPTY_FILEARRAY);
    }

    public String[] getBadOpts() {
        return this._badopts;
    }

    public File getBaseDir() {
        return this._baseDir;
    }

    public File[] getFiles() {
        return (File[]) getFileList().toArray(EMPTY_FILEARRAY);
    }

    public String getOpt(String str) {
        return this._options.get(str);
    }

    public URL[] getURLs() {
        return (URL[]) getUrlList().toArray(EMPTY_URLARRAY);
    }
}
