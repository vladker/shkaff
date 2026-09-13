package com.zlylib.fileselectorlib.utils;

import A4.X;
import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.collection.a;
import com.alibaba.android.arouter.utils.Consts;
import com.zlylib.fileselectorlib.bean.BreadModel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class FileUtils {
    public static final int BY_EXTENSION_ASC = 6;
    public static final int BY_EXTENSION_DESC = 7;
    public static final int BY_NAME_ASC = 0;
    public static final int BY_NAME_DESC = 1;
    public static final int BY_SIZE_ASC = 4;
    public static final int BY_SIZE_DESC = 5;
    public static final int BY_TIME_ASC = 2;
    public static final int BY_TIME_DESC = 3;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SortByExtension implements Comparator<File> {
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            if (file == null || file2 == null) {
                return file == null ? -1 : 1;
            }
            if (file.isDirectory() && file2.isFile()) {
                return -1;
            }
            if (file.isFile() && file2.isDirectory()) {
                return 1;
            }
            return file.getName().compareToIgnoreCase(file2.getName());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SortByName implements Comparator<File> {
        private boolean caseSensitive;

        public SortByName(boolean z6) {
            this.caseSensitive = z6;
        }

        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            if (file == null || file2 == null) {
                return file == null ? -1 : 1;
            }
            if (file.isDirectory() && file2.isFile()) {
                return -1;
            }
            if (file.isFile() && file2.isDirectory()) {
                return 1;
            }
            String name = file.getName();
            String name2 = file2.getName();
            return this.caseSensitive ? name.compareTo(name2) : name.compareToIgnoreCase(name2);
        }

        public SortByName() {
            this.caseSensitive = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SortBySize implements Comparator<File> {
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            if (file == null || file2 == null) {
                return file == null ? -1 : 1;
            }
            if (file.isDirectory() && file2.isFile()) {
                return -1;
            }
            return (!(file.isFile() && file2.isDirectory()) && file.length() < file2.length()) ? -1 : 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SortByTime implements Comparator<File> {
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            if (file == null || file2 == null) {
                return file == null ? -1 : 1;
            }
            if (file.isDirectory() && file2.isFile()) {
                return -1;
            }
            return (!(file.isFile() && file2.isDirectory()) && file.lastModified() > file2.lastModified()) ? -1 : 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface SortType {
    }

    public static boolean appendText(String str, String str2) throws Throwable {
        LogUtils.verbose("append " + str);
        File file = new File(str);
        FileWriter fileWriter = null;
        try {
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fileWriter2 = new FileWriter(file, true);
                try {
                    fileWriter2.write(str2);
                    closeSilently(fileWriter2);
                    return true;
                } catch (IOException e) {
                    e = e;
                    fileWriter = fileWriter2;
                    LogUtils.warn(e);
                    closeSilently(fileWriter);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    closeSilently(fileWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
            e = e6;
        }
    }

    public static boolean canBackParent(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            StringBuilder sbR = a.r(it.next());
            sbR.append(File.separator);
            if (str.equals(sbR.toString())) {
                return false;
            }
        }
        return true;
    }

    public static void closeSilently(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static int compareLastModified(String str, String str2) {
        long jLastModified = new File(str).lastModified();
        long jLastModified2 = new File(str2).lastModified();
        if (jLastModified > jLastModified2) {
            return 1;
        }
        return jLastModified < jLastModified2 ? -1 : 0;
    }

    public static boolean copy(String str, String str2) {
        File file = new File(str);
        return file.exists() && copy(file, new File(str2));
    }

    public static boolean delete(File file, boolean z6) {
        LogUtils.verbose("delete file " + file.getAbsolutePath());
        if (file.isFile()) {
            return deleteResolveEBUSY(file);
        }
        File[] fileArrListFiles = file.listFiles();
        z = false;
        boolean z7 = false;
        if (fileArrListFiles == null) {
            return false;
        }
        if (fileArrListFiles.length != 0) {
            boolean zDeleteResolveEBUSY = false;
            for (File file2 : fileArrListFiles) {
                delete(file2, z6);
                zDeleteResolveEBUSY = deleteResolveEBUSY(file2);
            }
            z7 = zDeleteResolveEBUSY;
        } else if (z6 && deleteResolveEBUSY(file)) {
            z7 = true;
        }
        return z6 ? deleteResolveEBUSY(file) : z7;
    }

    private static boolean deleteResolveEBUSY(File file) {
        File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
        file.renameTo(file2);
        return file2.delete();
    }

    public static boolean exist(String str) {
        return new File(str).exists();
    }

    public static List<String> getAllSdCardList(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < list.size(); i5++) {
            if (i5 == 0) {
                arrayList.add("内部存储设备");
            } else {
                arrayList.add("SD卡" + i5);
            }
        }
        return arrayList;
    }

    public static List<String> getAllSdPaths(Context context) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        String[] strArr = null;
        try {
            strArr = (String[]) storageManager.getClass().getMethod("getVolumePaths", null).invoke(storageManager, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strArr != null ? Arrays.asList(strArr) : new ArrayList();
    }

    public static List<BreadModel> getBreadModeListFromPath(List<String> list, String str) {
        List<String> arrayList = new ArrayList();
        for (int i5 = 0; i5 < list.size(); i5++) {
            LogUtils.debug("getBreadModeListFromPath", "--" + list.get(i5));
            str = i5 == 0 ? str.replace(list.get(i5), "/内部存储设备") : str.replace(list.get(i5), "/SD卡" + i5);
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList = Arrays.asList(str.substring(1, str.length()).split(PackagingURIHelper.FORWARD_SLASH_STRING));
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : arrayList) {
            LogUtils.debug("getBreadModeListFromPath", str2);
            BreadModel breadModel = new BreadModel();
            breadModel.setCurName(str2);
            arrayList2.add(breadModel);
        }
        return arrayList2;
    }

    public static String getBreadModelListByPosition(List<String> list, List<BreadModel> list2, int i5) {
        StringBuilder sb = new StringBuilder(PackagingURIHelper.FORWARD_SLASH_STRING);
        for (int i6 = 0; i6 < list2.size() && i5 >= i6; i6++) {
            sb.append(list2.get(i6).getCurName());
            sb.append(File.separator);
        }
        String string = sb.toString();
        if (string.startsWith("/内部存储设备")) {
            return string.replace("/内部存储设备", list.get(0));
        }
        if (!string.startsWith("/SD卡")) {
            return string;
        }
        return string.replace("/SD卡" + String.valueOf(string.charAt(4)), list.get(Integer.valueOf(String.valueOf(string.charAt(4))).intValue()));
    }

    public static String getChangeSdCard(String str, List<String> list) {
        if (TextUtils.isEmpty(str)) {
            return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
        }
        if (str.startsWith("内部存储设备")) {
            return list.get(0) + File.separator;
        }
        if (str.startsWith("SD卡")) {
            return list.get(Integer.valueOf(String.valueOf(str.charAt(3))).intValue()) + File.separator;
        }
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
    }

    public static String getDateTime(String str) {
        return getDateTime(str, "yyyy-MM-dd HH:mm");
    }

    public static String getExtension(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf >= 0 ? str.substring(iLastIndexOf + 1) : "ext";
    }

    public static long getLength(String str) {
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            return file.length();
        }
        return 0L;
    }

    public static String getMimeType(String str) {
        String extension = getExtension(str);
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        return singleton.hasExtension(extension) ? singleton.getMimeTypeFromExtension(extension) : "*/*";
    }

    public static String getName(String str) {
        if (str == null) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(47);
        if (iLastIndexOf >= 0) {
            return str.substring(iLastIndexOf + 1);
        }
        return String.valueOf(System.currentTimeMillis()) + Consts.DOT + getExtension(str);
    }

    public static String getNameExcludeExtension(String str) {
        try {
            String name = new File(str).getName();
            int iLastIndexOf = name.lastIndexOf(Consts.DOT);
            return iLastIndexOf != -1 ? name.substring(0, iLastIndexOf) : name;
        } catch (Exception e) {
            LogUtils.warn(e);
            return "";
        }
    }

    public static String getSize(String str) {
        return ConvertUtils.toFileSizeString(getLength(str));
    }

    public static File[] listDirs(String str, String[] strArr, int i5) {
        ArrayList arrayList = new ArrayList();
        File file = new File(str);
        if (!file.isDirectory()) {
            return new File[0];
        }
        File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.zlylib.fileselectorlib.utils.FileUtils.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2 != null && file2.isDirectory();
            }
        });
        if (fileArrListFiles == null) {
            return new File[0];
        }
        if (strArr == null) {
            strArr = new String[0];
        }
        for (File file2 : fileArrListFiles) {
            File absoluteFile = file2.getAbsoluteFile();
            if (!ConvertUtils.toString(strArr).contains(absoluteFile.getName())) {
                arrayList.add(absoluteFile);
            }
        }
        if (i5 == 0) {
            Collections.sort(arrayList, new SortByName());
        } else if (i5 == 1) {
            Collections.sort(arrayList, new SortByName());
            Collections.reverse(arrayList);
        } else if (i5 == 2) {
            Collections.sort(arrayList, new SortByTime());
        } else if (i5 == 3) {
            Collections.sort(arrayList, new SortByTime());
            Collections.reverse(arrayList);
        } else if (i5 == 4) {
            Collections.sort(arrayList, new SortBySize());
        } else if (i5 == 5) {
            Collections.sort(arrayList, new SortBySize());
            Collections.reverse(arrayList);
        } else if (i5 == 6) {
            Collections.sort(arrayList, new SortByExtension());
        } else if (i5 == 7) {
            Collections.sort(arrayList, new SortByExtension());
            Collections.reverse(arrayList);
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    public static File[] listDirsAndFiles(String str, String[] strArr) {
        File[] fileArrListDirs = listDirs(str);
        File[] fileArrListFiles = strArr == null ? listFiles(str) : listFiles(str, strArr);
        if (fileArrListDirs == null || fileArrListFiles == null) {
            return null;
        }
        File[] fileArr = new File[fileArrListDirs.length + fileArrListFiles.length];
        System.arraycopy(fileArrListDirs, 0, fileArr, 0, fileArrListDirs.length);
        System.arraycopy(fileArrListFiles, 0, fileArr, fileArrListDirs.length, fileArrListFiles.length);
        return fileArr;
    }

    public static File[] listFiles(String str, final Pattern pattern, int i5) {
        LogUtils.verbose("list file " + str);
        ArrayList arrayList = new ArrayList();
        File file = new File(str);
        if (!file.isDirectory()) {
            return new File[0];
        }
        File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.zlylib.fileselectorlib.utils.FileUtils.2
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2 == null || file2.isDirectory()) {
                    return false;
                }
                Pattern pattern2 = pattern;
                if (pattern2 == null) {
                    return true;
                }
                return pattern2.matcher(file2.getName()).find();
            }
        });
        if (fileArrListFiles == null) {
            return new File[0];
        }
        for (File file2 : fileArrListFiles) {
            arrayList.add(file2.getAbsoluteFile());
        }
        if (i5 == 0) {
            Collections.sort(arrayList, new SortByName());
        } else if (i5 == 1) {
            Collections.sort(arrayList, new SortByName());
            Collections.reverse(arrayList);
        } else if (i5 == 2) {
            Collections.sort(arrayList, new SortByTime());
        } else if (i5 == 3) {
            Collections.sort(arrayList, new SortByTime());
            Collections.reverse(arrayList);
        } else if (i5 == 4) {
            Collections.sort(arrayList, new SortBySize());
        } else if (i5 == 5) {
            Collections.sort(arrayList, new SortBySize());
            Collections.reverse(arrayList);
        } else if (i5 == 6) {
            Collections.sort(arrayList, new SortByExtension());
        } else if (i5 == 7) {
            Collections.sort(arrayList, new SortByExtension());
            Collections.reverse(arrayList);
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    public static boolean makeDirs(String str) {
        return makeDirs(new File(str));
    }

    public static boolean move(String str, String str2) {
        return move(new File(str), new File(str2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] readBytes(String str) throws Throwable {
        FileInputStream fileInputStream;
        LogUtils.verbose("read " + str);
        X x6 = 0;
        try {
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i5 = fileInputStream.read(bArr, 0, 1024);
                        if (i5 == -1) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                            closeSilently(fileInputStream);
                            return byteArray;
                        }
                        byteArrayOutputStream.write(bArr, 0, i5);
                    }
                } catch (IOException e) {
                    e = e;
                    LogUtils.warn(e);
                    closeSilently(fileInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                x6 = "read ";
                closeSilently(x6);
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            closeSilently(x6);
            throw th;
        }
    }

    public static String readText(String str, String str2) throws Throwable {
        LogUtils.verbose("read " + str + " use " + str2);
        try {
            byte[] bytes = readBytes(str);
            return bytes != null ? new String(bytes, str2).trim() : "";
        } catch (UnsupportedEncodingException e) {
            LogUtils.warn(e);
            return "";
        }
    }

    public static boolean rename(String str, String str2) {
        return rename(new File(str), new File(str2));
    }

    public static String separator(String str) {
        String str2 = File.separator;
        String strReplace = str.replace("\\", str2);
        return !strReplace.endsWith(str2) ? a.n(strReplace, str2) : strReplace;
    }

    public static boolean writeBytes(String str, byte[] bArr) throws Throwable {
        LogUtils.verbose("write " + str);
        File file = new File(str);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    fileOutputStream2.write(bArr);
                    closeSilently(fileOutputStream2);
                    return true;
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    LogUtils.warn(e);
                    closeSilently(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    closeSilently(fileOutputStream);
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean writeText(String str, String str2, String str3) throws Throwable {
        try {
            writeBytes(str, str2.getBytes(str3));
            return true;
        } catch (UnsupportedEncodingException e) {
            LogUtils.warn(e);
            return false;
        }
    }

    public static String getDateTime(String str, String str2) {
        return getDateTime(new File(str), str2);
    }

    public static boolean makeDirs(File file) {
        return file.mkdirs();
    }

    public static boolean move(File file, File file2) {
        return rename(file, file2);
    }

    public static boolean rename(File file, File file2) {
        LogUtils.verbose("rename " + file.getAbsolutePath() + " to " + file2.getAbsolutePath());
        return file.renameTo(file2);
    }

    public static boolean copy(File file, File file2) {
        try {
            LogUtils.verbose("copy " + file.getAbsolutePath() + " to " + file2.getAbsolutePath());
            if (file.isFile()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                byte[] bArr = new byte[8192];
                while (true) {
                    int i5 = bufferedInputStream.read(bArr);
                    if (i5 == -1) {
                        bufferedInputStream.close();
                        bufferedOutputStream.close();
                        return true;
                    }
                    bufferedOutputStream.write(bArr, 0, i5);
                }
            } else {
                if (!file.isDirectory()) {
                    return true;
                }
                File[] fileArrListFiles = file.listFiles();
                file2.mkdirs();
                for (File file3 : fileArrListFiles) {
                    copy(file3.getAbsoluteFile(), new File(file2.getAbsoluteFile(), file3.getName()));
                }
                return true;
            }
        } catch (Exception e) {
            LogUtils.error(e);
            return false;
        }
    }

    public static boolean writeText(String str, String str2) {
        return writeText(str, str2, "utf-8");
    }

    public static String getDateTime(File file, String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(file.lastModified());
        return DateUtils.formatDate(calendar.getTime(), str);
    }

    public static String readText(String str) {
        return readText(str, "utf-8");
    }

    public static File[] listDirsAndFiles(String str) {
        return listDirsAndFiles(str, null);
    }

    public static boolean delete(String str, boolean z6) {
        File file = new File(str);
        if (file.exists()) {
            return delete(file, z6);
        }
        return false;
    }

    public static boolean delete(String str) {
        return delete(str, false);
    }

    public static boolean delete(File file) {
        return delete(file, false);
    }

    public static File[] listFiles(String str, Pattern pattern) {
        return listFiles(str, pattern, 0);
    }

    public static File[] listFiles(String str) {
        return listFiles(str, null, 0);
    }

    public static File[] listDirs(String str, String[] strArr) {
        return listDirs(str, strArr, 0);
    }

    public static File[] listFiles(String str, final String[] strArr) {
        LogUtils.verbose("list file " + str);
        return new File(str).listFiles(new FilenameFilter() { // from class: com.zlylib.fileselectorlib.utils.FileUtils.3
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str2) {
                return ConvertUtils.toString(strArr).contains(FileUtils.getExtension(str2));
            }
        });
    }

    public static File[] listDirs(String str) {
        return listDirs(str, null, 0);
    }

    public static File[] listFiles(String str, String str2) {
        return listFiles(str, new String[]{str2});
    }
}
