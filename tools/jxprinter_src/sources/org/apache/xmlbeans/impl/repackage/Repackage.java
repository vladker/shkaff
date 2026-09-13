package org.apache.xmlbeans.impl.repackage;

import A3.AbstractC0157z;
import androidx.collection.a;
import com.alibaba.android.arouter.utils.Consts;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Repackage {
    private List<List<String>> _fromPackages;
    private List<String> _moveAlongFiles;
    private Map<String, String> _movedDirs;
    private Pattern _packagePattern;
    private final Repackager _repackager;
    private int _skippedFiles;
    private final File _sourceBase;
    private final File _targetBase;
    private List<List<String>> _toPackages;

    private Repackage(String[] strArr) {
        int i5;
        String str = null;
        String str2 = null;
        String str3 = null;
        int i6 = 0;
        boolean z6 = false;
        while (i6 < strArr.length) {
            if (strArr[i6].equals("-repackage") && (i5 = i6 + 1) < strArr.length) {
                str = strArr[i5];
            } else if (!strArr[i6].equals("-f") || (i5 = i6 + 1) >= strArr.length) {
                if (!strArr[i6].equals("-t") || (i5 = i6 + 1) >= strArr.length) {
                    z6 = true;
                } else {
                    str3 = strArr[i5];
                }
                i6++;
            } else {
                str2 = strArr[i5];
            }
            i6 = i5;
            i6++;
        }
        if (!z6 && str != null) {
            if (!((str2 == null) ^ (str3 == null))) {
                this._repackager = new Repackager(str);
                if (str2 == null || str3 == null) {
                    this._targetBase = null;
                    this._sourceBase = null;
                    return;
                } else {
                    this._sourceBase = new File(str2);
                    this._targetBase = new File(str3);
                    return;
                }
            }
        }
        throw new RuntimeException("Usage: repackage -repackage [spec] [ -f [sourcedir] -t [targetdir] ]");
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[16384];
        while (true) {
            int i5 = inputStream.read(bArr, 0, 16384);
            if (i5 < 0) {
                return;
            } else {
                outputStream.write(bArr, 0, i5);
            }
        }
    }

    public static void copyFile(File file, File file2) throws IOException {
        file2.getParentFile().mkdirs();
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                copy(fileInputStream, fileOutputStream);
                fileOutputStream.close();
                fileInputStream.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                try {
                    fileInputStream.close();
                } catch (Throwable th6) {
                    th4.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }

    public static void main(String[] strArr) throws IOException {
        new Repackage(strArr).repackage();
    }

    public void fillFiles(List<File> list, File file) {
        if (!file.isDirectory()) {
            list.add(file);
            return;
        }
        if (file.getName().equals("build") || file.getName().equals("CVS")) {
            return;
        }
        String[] list2 = file.list();
        if (list2 == null) {
            throw new RuntimeException("Directory can't be accessed: " + file.toString());
        }
        for (String str : list2) {
            fillFiles(list, new File(file, str));
        }
    }

    public void finishMovingFiles() throws IOException {
        for (String str : this._moveAlongFiles) {
            String str2 = this._movedDirs.get(Repackager.dirForPath(str));
            String string = str2 == null ? str : new File(str2, new File(str).getName()).toString();
            if (str.endsWith(".html")) {
                repackageNonJavaFile(str, string);
            } else {
                justMoveNonJavaFile(str, string);
            }
        }
    }

    public void justMoveNonJavaFile(String str, String str2) throws IOException {
        File file = new File(this._sourceBase, str);
        File file2 = new File(this._targetBase, str2);
        if (file.lastModified() < file2.lastModified()) {
            this._skippedFiles++;
        } else {
            copyFile(file, file2);
        }
    }

    public void moveAlongWithJavaFiles(String str) {
        this._moveAlongFiles.add(str);
    }

    public StringBuffer readFile(File file) throws IOException {
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(file.toPath(), StandardCharsets.ISO_8859_1);
        try {
            StringWriter stringWriter = new StringWriter();
            try {
                copy(bufferedReaderNewBufferedReader, stringWriter);
                StringBuffer buffer = stringWriter.getBuffer();
                stringWriter.close();
                if (bufferedReaderNewBufferedReader != null) {
                    bufferedReaderNewBufferedReader.close();
                }
                return buffer;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        stringWriter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                if (bufferedReaderNewBufferedReader != null) {
                    try {
                        bufferedReaderNewBufferedReader.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        }
    }

    public StringBuffer readInputStream(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1);
        try {
            StringWriter stringWriter = new StringWriter();
            try {
                copy(inputStreamReader, stringWriter);
                StringBuffer buffer = stringWriter.getBuffer();
                stringWriter.close();
                inputStreamReader.close();
                return buffer;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        stringWriter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                try {
                    inputStreamReader.close();
                } catch (Throwable th6) {
                    th4.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }

    public void recursiveDelete(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                String[] list = file.list();
                if (list == null) {
                    throw new RuntimeException("Directory can't be accessed: " + file.toString());
                }
                for (String str : list) {
                    recursiveDelete(new File(file, str));
                }
            }
            file.delete();
        }
    }

    public void repackage() throws IOException {
        if (this._sourceBase == null || this._targetBase == null) {
            System.out.println(this._repackager.repackage(readInputStream(System.in)).toString());
            return;
        }
        this._fromPackages = this._repackager.getFromPackages();
        this._toPackages = this._repackager.getToPackages();
        this._packagePattern = Pattern.compile("^\\s*package\\s+((?:\\w|\\.)*)\\s*;", 8);
        this._moveAlongFiles = new ArrayList();
        this._movedDirs = new HashMap();
        this._targetBase.mkdirs();
        ArrayList arrayList = new ArrayList();
        fillFiles(arrayList, this._sourceBase);
        System.out.println("Repackaging " + arrayList.size() + " files ...");
        int length = this._sourceBase.getCanonicalPath().length();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            repackageFile(((File) obj).getCanonicalPath().substring(length + 1));
        }
        finishMovingFiles();
        if (this._skippedFiles > 0) {
            System.out.println("Skipped " + this._skippedFiles + " unmodified files.");
        }
    }

    public void repackageFile(String str) throws IOException {
        if (str.endsWith(".java")) {
            repackageJavaFile(str);
            return;
        }
        if (str.endsWith(".xsdconfig") || str.endsWith(".xml") || str.endsWith(".g")) {
            repackageNonJavaFile(str);
            return;
        }
        if (str.startsWith("bin" + File.separatorChar)) {
            repackageNonJavaFile(str);
        } else {
            moveAlongWithJavaFiles(str);
        }
    }

    public void repackageJavaFile(String str) throws IOException {
        List<String> list;
        List<String> list2;
        String str2 = str;
        File file = new File(this._sourceBase, str2);
        StringBuffer file2 = readFile(file);
        Matcher matcher = this._packagePattern.matcher(file2);
        int i5 = 1;
        if (matcher.find()) {
            String strGroup = matcher.group(1);
            int iStart = matcher.start(1);
            int iEnd = matcher.end(1);
            if (matcher.find()) {
                throw new RuntimeException(AbstractC0157z.n("Two package specifications found: ", str2));
            }
            List<String> listSplitPath = Repackager.splitPath(str2, File.separatorChar);
            String strDirForPath = Repackager.dirForPath(str2);
            while (true) {
                int i6 = i5;
                int i7 = 0;
                while (i6 < listSplitPath.size()) {
                    int i8 = i6 - 1;
                    String str3 = listSplitPath.get(i8);
                    String str4 = listSplitPath.get(i6);
                    int i9 = i5;
                    if (str3.indexOf(58) < str4.indexOf(58)) {
                        listSplitPath.set(i8, str4);
                        listSplitPath.set(i6, str3);
                        i7 = i9;
                    }
                    i6++;
                    i5 = i9;
                }
                int i10 = i5;
                if (i7 == 0) {
                    break;
                } else {
                    i5 = i10;
                }
            }
            List<String> listSplitPath2 = Repackager.splitPath(strGroup, '.');
            int size = listSplitPath.size() - 2;
            if (size < 0 || listSplitPath.size() - 1 < listSplitPath2.size()) {
                throw new RuntimeException(AbstractC0157z.n("Package spec differs from file path: ", str2));
            }
            for (int size2 = listSplitPath2.size() - 1; size2 >= 0; size2--) {
                if (!listSplitPath2.get(size2).equals(listSplitPath.get(size))) {
                    throw new RuntimeException(AbstractC0157z.n("Package spec differs from file path: ", str2));
                }
                size--;
            }
            int i11 = 0;
            loop3: while (true) {
                if (i11 >= this._fromPackages.size()) {
                    list = null;
                    list2 = null;
                    break;
                }
                list = this._fromPackages.get(i11);
                if (list.size() <= listSplitPath2.size()) {
                    int i12 = 0;
                    while (true) {
                        if (i12 >= list.size()) {
                            list2 = this._toPackages.get(i11);
                            break loop3;
                        } else if (!list.get(i12).equals(listSplitPath2.get(i12))) {
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
                i11++;
            }
            if (list2 != null) {
                String string = "";
                String string2 = "";
                for (int i13 = 0; i13 < list2.size(); i13++) {
                    if (i13 > 0) {
                        string = a.n(string, Consts.DOT);
                        StringBuilder sbR = a.r(string2);
                        sbR.append(File.separatorChar);
                        string2 = sbR.toString();
                    }
                    StringBuilder sbR2 = a.r(string);
                    sbR2.append(list2.get(i13));
                    string = sbR2.toString();
                    StringBuilder sbR3 = a.r(string2);
                    sbR3.append(list2.get(i13));
                    string2 = sbR3.toString();
                }
                for (int size3 = (listSplitPath.size() - listSplitPath2.size()) - 2; size3 >= 0; size3--) {
                    string2 = listSplitPath.get(size3) + File.separatorChar + string2;
                }
                for (int size4 = list.size(); size4 < listSplitPath2.size(); size4++) {
                    StringBuilder sbR4 = a.r(string2);
                    sbR4.append(File.separatorChar);
                    sbR4.append(listSplitPath2.get(size4));
                    string2 = sbR4.toString();
                    string = string + '.' + listSplitPath2.get(size4);
                }
                StringBuilder sbR5 = a.r(string2);
                sbR5.append(File.separatorChar);
                sbR5.append(listSplitPath.get(listSplitPath.size() - 1));
                String string3 = sbR5.toString();
                file2.replace(iStart, iEnd, string);
                String strDirForPath2 = Repackager.dirForPath(string3);
                if (!strDirForPath.equals(strDirForPath2)) {
                    this._movedDirs.put(strDirForPath, strDirForPath2);
                }
                str2 = string3;
            }
        }
        if (file.lastModified() < new File(this._targetBase, str2).lastModified()) {
            this._skippedFiles++;
        } else {
            writeFile(new File(this._targetBase, str2), this._repackager.repackage(file2));
        }
    }

    public void repackageNonJavaFile(String str) throws IOException {
        File file = new File(this._sourceBase, str);
        File file2 = new File(this._targetBase, str);
        if (file.lastModified() < file2.lastModified()) {
            this._skippedFiles++;
        } else {
            writeFile(file2, this._repackager.repackage(readFile(file)));
        }
    }

    public void writeFile(File file, StringBuffer stringBuffer) throws IOException {
        file.getParentFile().mkdirs();
        BufferedWriter bufferedWriterNewBufferedWriter = Files.newBufferedWriter(file.toPath(), StandardCharsets.ISO_8859_1, new OpenOption[0]);
        try {
            StringReader stringReader = new StringReader(stringBuffer.toString());
            try {
                copy(stringReader, bufferedWriterNewBufferedWriter);
                stringReader.close();
                if (bufferedWriterNewBufferedWriter != null) {
                    bufferedWriterNewBufferedWriter.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        stringReader.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                if (bufferedWriterNewBufferedWriter != null) {
                    try {
                        bufferedWriterNewBufferedWriter.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        }
    }

    public static void copy(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[16384];
        while (true) {
            int i5 = reader.read(cArr, 0, 16384);
            if (i5 < 0) {
                return;
            } else {
                writer.write(cArr, 0, i5);
            }
        }
    }

    public void repackageNonJavaFile(String str, String str2) throws IOException {
        File file = new File(this._sourceBase, str);
        File file2 = new File(this._targetBase, str2);
        if (file.lastModified() < file2.lastModified()) {
            this._skippedFiles++;
        } else {
            writeFile(file2, this._repackager.repackage(readFile(file)));
        }
    }
}
