package p056k0;

import A3.AbstractC0157z;
import A3.C;
import S2.l;
import X3.C0241g;
import X3.W;
import X3.b0;
import android.util.Log;
import androidx.collection.LruCache;
import com.alibaba.android.arouter.utils.Consts;
import com.appdev.standard.util.fileDownload.m;
import com.google.android.gms.auth.api.accounttransfer.a;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipException;
import kotlin.jvm.internal.E;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.poifs.filesystem.NotOLE2FileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import p134x2.I;
import p134x2.K;
import p147z3.C1937q;
import p147z3.C1938s;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    private static final String TAG = "ExcelUtil";
    private static String cachePath;
    public static final g INSTANCE = new g();
    private static LruCache<String, Workbook> cache = new LruCache<>(10);

    /* JADX WARN: Code duplicated, block: B:53:0x0121  */
    public static Workbook a(FileInputStream fileInputStream, String str) throws Exception {
        String str2;
        String lowerCase = b0.substringAfterLast(str, '.', "").toLowerCase(Locale.ROOT);
        E.e(lowerCase, "toLowerCase(...)");
        if (lowerCase.equals("xlsx")) {
            try {
                return new XSSFWorkbook(fileInputStream);
            } catch (Exception e) {
                Log.e(TAG, "读取 .xlsx 文件失败: " + e.getMessage());
                throw e;
            }
        }
        if (!lowerCase.equals("xls")) {
            throw new IllegalArgumentException("不支持的文件格式: ".concat(lowerCase));
        }
        try {
            return new HSSFWorkbook(fileInputStream);
        } catch (NotOLE2FileException unused) {
            fileInputStream.close();
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                return new XSSFWorkbook(fileInputStream2);
            } catch (Exception e6) {
                fileInputStream2.close();
                String str3 = "Unknown";
                try {
                    File file = new File(str);
                    byte[] bArr = new byte[512];
                    FileInputStream fileInputStream3 = new FileInputStream(file);
                    int i5 = fileInputStream3.read(bArr);
                    fileInputStream3.close();
                    if (i5 > 0) {
                        String str4 = new String(bArr, 0, Math.min(i5, 100), C0241g.UTF_8);
                        if (W.startsWith(b0.trim((CharSequence) str4).toString(), "<?xml", false)) {
                            str3 = "XML";
                        } else if (W.startsWith(b0.trim((CharSequence) str4).toString(), "<html", true) || W.startsWith(b0.trim((CharSequence) str4).toString(), "<!DOCTYPE", true)) {
                            str3 = "HTML";
                        } else if (b0.contains((CharSequence) str4, (CharSequence) "<table", true)) {
                            str3 = "HTML Table";
                        }
                    }
                } catch (Exception e7) {
                    Log.e(TAG, "检测文件类型失败: " + e7.getMessage());
                }
                int iHashCode = str3.hashCode();
                if (iHashCode != -1986481415) {
                    if (iHashCode != 87031) {
                        if (iHashCode == 2228139 && str3.equals("HTML")) {
                            str2 = "您的文件是 HTML 网页格式，不是真正的 Excel 文件。请在 Excel 中打开该文件，然后另存为标准的 .xlsx 或 .xls 格式。";
                        }
                    } else if (str3.equals("XML")) {
                        str2 = "您的文件是纯 XML 格式，不是标准的 Excel 文件。请在 Excel 中打开该文件，然后另存为标准的 .xlsx 或 .xls 格式。";
                    }
                    str2 = "文件格式错误：既不是有效的二进制 .xls 文件，也不是有效的 .xlsx 文件。请在 Excel 中打开该文件，然后另存为标准的 .xlsx 或 .xls 格式。";
                } else if (str3.equals("HTML Table")) {
                    str2 = "您的文件是 HTML 网页格式，不是真正的 Excel 文件。请在 Excel 中打开该文件，然后另存为标准的 .xlsx 或 .xls 格式。";
                } else {
                    str2 = "文件格式错误：既不是有效的二进制 .xls 文件，也不是有效的 .xlsx 文件。请在 Excel 中打开该文件，然后另存为标准的 .xlsx 或 .xls 格式。";
                }
                throw new IllegalArgumentException(str2, e6);
            }
        } catch (Exception e8) {
            Log.e(TAG, "读取 .xls 文件失败: " + e8.getMessage());
            throw e8;
        }
    }

    public static String b(Cell cell) {
        if (cell == null) {
            return "";
        }
        CellType cellType = cell.getCellType();
        switch (cellType == null ? -1 : f.f5466a[cellType.ordinal()]) {
            case 1:
                String stringCellValue = cell.getStringCellValue();
                E.e(stringCellValue, "getStringCellValue(...)");
                return stringCellValue;
            case 2:
                return String.valueOf(cell.getNumericCellValue());
            case 3:
                String cellFormula = cell.getCellFormula();
                E.e(cellFormula, "getCellFormula(...)");
                return cellFormula;
            case 4:
            case 6:
                return "";
            case 5:
                return String.valueOf(cell.getBooleanCellValue());
            case 7:
                return String.valueOf((int) cell.getErrorCellValue());
            default:
                throw new C1937q();
        }
    }

    public static String c(String str) {
        try {
            String path = new URL(str).getPath();
            E.c(path);
            int iF = b0.f(path, '.');
            if (iF == -1 || iF >= path.length() - 1) {
                return null;
            }
            String strSubstring = path.substring(iF + 1);
            E.e(strSubstring, "substring(...)");
            return strSubstring;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String d(String str) {
        byte[] bytes = str.getBytes(C0241g.UTF_8);
        E.e(bytes, "getBytes(...)");
        byte[] bArrDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(bytes);
        E.c(bArrDigest);
        return C.e(bArrDigest, "", new l(13), 30);
    }

    public static final K downloadToCache(String url) throws Throwable {
        E.f(url, "url");
        FileInputStream fileInputStream = null;
        try {
            try {
                File file = new File(url);
                if (!file.exists() || !file.isFile()) {
                    String str = cachePath;
                    INSTANCE.getClass();
                    file = new File(str, d(url) + Consts.DOT + c(url));
                    if (!file.exists()) {
                        try {
                            new m().downloadFile(url, file.getAbsolutePath());
                        } catch (Exception e) {
                            return K.Companion.from(u.m1361constructorimpl(v.createFailure(new Exception("下载文件失败: " + e.getMessage(), e))));
                        }
                    }
                }
                String absolutePath = file.getAbsolutePath();
                LruCache<String, Workbook> lruCache = cache;
                E.c(absolutePath);
                if (lruCache.get(absolutePath) == null) {
                    FileInputStream fileInputStream2 = new FileInputStream(absolutePath);
                    try {
                        try {
                            INSTANCE.getClass();
                            cache.put(absolutePath, a(fileInputStream2, absolutePath));
                            fileInputStream = fileInputStream2;
                        } catch (Exception e6) {
                            e = e6;
                            fileInputStream = fileInputStream2;
                            K kFrom = K.Companion.from(u.m1361constructorimpl(v.createFailure(new Exception("缓存文件失败: " + e.getMessage(), e))));
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return kFrom;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    } catch (IllegalArgumentException e7) {
                        I i5 = K.Companion;
                        String message = e7.getMessage();
                        if (message == null) {
                            message = "不支持的文件格式";
                        }
                        K kFrom2 = i5.from(u.m1361constructorimpl(v.createFailure(new Exception(message, e7))));
                        fileInputStream2.close();
                        return kFrom2;
                    } catch (ZipException e8) {
                        K kFrom3 = K.Companion.from(u.m1361constructorimpl(v.createFailure(new Exception("文件已损坏或不是有效的 Excel 文件", e8))));
                        fileInputStream2.close();
                        return kFrom3;
                    } catch (NotOfficeXmlFileException e9) {
                        K kFrom4 = K.Companion.from(u.m1361constructorimpl(v.createFailure(new Exception("文件格式错误，请确保选择的是有效的 Excel 文件（.xlsx）", e9))));
                        fileInputStream2.close();
                        return kFrom4;
                    } catch (NotOLE2FileException e10) {
                        K kFrom5 = K.Companion.from(u.m1361constructorimpl(v.createFailure(new Exception("文件格式错误，请确保选择的是有效的 Excel 文件（.xls）", e10))));
                        fileInputStream2.close();
                        return kFrom5;
                    }
                }
                K kFrom6 = K.Companion.from(u.m1361constructorimpl(Q.INSTANCE));
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return kFrom6;
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static final K readCellInfo(String url, int i5, int i6) {
        E.f(url, "url");
        FileInputStream fileInputStream = null;
        try {
            try {
                File file = new File(url);
                if (!file.exists() || !file.isFile()) {
                    String str = cachePath;
                    INSTANCE.getClass();
                    file = new File(str, d(url) + Consts.DOT + c(url));
                    if (!file.exists()) {
                        try {
                            new m().downloadFile(url, file.getAbsolutePath());
                        } catch (Exception e) {
                            return K.Companion.from(u.m1361constructorimpl(v.createFailure(new Exception("下载文件失败: " + e.getMessage(), e))));
                        }
                    }
                }
                String absolutePath = file.getAbsolutePath();
                LruCache<String, Workbook> lruCache = cache;
                E.c(absolutePath);
                Workbook workbook = lruCache.get(absolutePath);
                if (workbook == null) {
                    FileInputStream fileInputStream2 = new FileInputStream(absolutePath);
                    try {
                        try {
                            try {
                                INSTANCE.getClass();
                                Workbook workbookA = a(fileInputStream2, absolutePath);
                                cache.put(absolutePath, workbookA);
                                fileInputStream = fileInputStream2;
                                workbook = workbookA;
                            } catch (ZipException e6) {
                                K kFrom = K.Companion.from(u.m1361constructorimpl(v.createFailure(new Exception("文件已损坏或不是有效的 Excel 文件", e6))));
                                fileInputStream2.close();
                                return kFrom;
                            } catch (NotOLE2FileException e7) {
                                K kFrom2 = K.Companion.from(u.m1361constructorimpl(v.createFailure(new Exception("文件格式错误，请确保选择的是有效的 Excel 文件（.xls）", e7))));
                                fileInputStream2.close();
                                return kFrom2;
                            }
                        } catch (NotOfficeXmlFileException e8) {
                            K kFrom3 = K.Companion.from(u.m1361constructorimpl(v.createFailure(new Exception("文件格式错误，请确保选择的是有效的 Excel 文件（.xlsx）", e8))));
                            fileInputStream2.close();
                            return kFrom3;
                        } catch (IllegalArgumentException e9) {
                            I i7 = K.Companion;
                            String message = e9.getMessage();
                            if (message == null) {
                                message = "不支持的文件格式";
                            }
                            K kFrom4 = i7.from(u.m1361constructorimpl(v.createFailure(new Exception(message, e9))));
                            fileInputStream2.close();
                            return kFrom4;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        fileInputStream = fileInputStream2;
                        K kFrom5 = K.Companion.from(u.m1361constructorimpl(v.createFailure(new Exception("读取单元格信息失败: " + e.getMessage(), e))));
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return kFrom5;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                }
                Sheet sheetAt = workbook.getSheetAt(0);
                if (sheetAt.getLastRowNum() < 1) {
                    K kFrom6 = K.Companion.from(u.m1361constructorimpl(v.createFailure(new Exception("row " + i5 + " not found"))));
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return kFrom6;
                }
                Row row = sheetAt.getRow(0);
                if (sheetAt.getLastRowNum() < i5) {
                    K kFrom7 = K.Companion.from(u.m1361constructorimpl(v.createFailure(new Exception("row " + i5 + " not found"))));
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return kFrom7;
                }
                Row row2 = sheetAt.getRow(i5);
                if (row != null && row2 != null) {
                    if (row2.getLastCellNum() < i6) {
                        K kFrom8 = K.Companion.from(u.m1361constructorimpl(v.createFailure(new Exception("column " + i6 + " not found"))));
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return kFrom8;
                    }
                    I i8 = K.Companion;
                    g gVar = INSTANCE;
                    Cell cell = row.getCell(i6);
                    gVar.getClass();
                    K kFrom9 = i8.from(u.m1361constructorimpl(new c(b(cell), b(row2.getCell(i6)))));
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return kFrom9;
                }
                K kFrom10 = K.Companion.from(u.m1361constructorimpl(v.createFailure(new Exception("row " + i5 + " not found"))));
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return kFrom10;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00d7 A[PHI: r0 r4
  0x00d7: PHI (r0v30 java.lang.Object) = (r0v26 java.lang.Object), (r0v33 java.lang.Object) binds: [B:98:0x00d7, B:84:0x01f7] A[DONT_GENERATE, DONT_INLINE]
  0x00d7: PHI (r4v7 java.io.FileInputStream) = (r4v5 java.io.FileInputStream), (r4v8 java.io.FileInputStream) binds: [B:98:0x00d7, B:84:0x01f7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:64:0x0170 A[PHI: r1
  0x0170: PHI (r1v30 java.lang.Object) = (r1v24 java.lang.Object), (r1v27 java.lang.Object), (r1v32 java.lang.Object) binds: [B:81:0x01d2, B:79:0x01c4, B:63:0x016e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:88:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:90:0x020f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0212  */
    /* JADX WARN: Code duplicated, block: B:96:0x0230  */
    /* JADX INFO: renamed from: readExcelInfo-IoAF18A, reason: not valid java name */
    public static final Object m1039readExcelInfoIoAF18A(String url) throws Throwable {
        FileInputStream fileInputStream;
        Object objM1361constructorimpl;
        FileInputStream fileInputStream2;
        boolean z6;
        Object objM1361constructorimpl2;
        E.f(url, "url");
        if (url.length() == 0) {
            return a.g("url is empty");
        }
        File file = new File(url);
        if (!file.exists() || !file.isFile()) {
            String str = cachePath;
            INSTANCE.getClass();
            file = new File(str, androidx.collection.a.o(d(url), Consts.DOT, c(url)));
            if (!file.exists()) {
                try {
                    new m().downloadFile(url, file.getAbsolutePath());
                } catch (Exception e) {
                    Log.e(TAG, "下载文件失败: " + e.getMessage());
                    return u.m1361constructorimpl(v.createFailure(new Exception(AbstractC0157z.n("下载文件失败: ", e.getMessage()), e)));
                }
            }
        }
        if (!file.exists()) {
            return a.g("文件不存在");
        }
        if (file.length() == 0) {
            return a.g("文件为空");
        }
        g gVar = INSTANCE;
        String absolutePath = file.getAbsolutePath();
        E.e(absolutePath, "getAbsolutePath(...)");
        gVar.getClass();
        Workbook workbook = cache.get(absolutePath);
        FileInputStream fileInputStream3 = null;
        try {
            if (workbook == null) {
                try {
                    fileInputStream = new FileInputStream(absolutePath);
                    try {
                        try {
                            if (fileInputStream.available() == 0) {
                                objM1361constructorimpl = u.m1361constructorimpl(v.createFailure(new Exception("文件为空或无法读取")));
                            } else {
                                try {
                                    Workbook workbookA = a(fileInputStream, absolutePath);
                                    cache.put(absolutePath, workbookA);
                                    fileInputStream2 = fileInputStream;
                                    workbook = workbookA;
                                } catch (IllegalArgumentException e6) {
                                    String message = e6.getMessage();
                                    if (message == null) {
                                        message = "不支持的文件格式";
                                    }
                                    objM1361constructorimpl = u.m1361constructorimpl(v.createFailure(new Exception(message, e6)));
                                    fileInputStream.close();
                                } catch (ZipException e7) {
                                    objM1361constructorimpl = u.m1361constructorimpl(v.createFailure(new Exception("文件已损坏或不是有效的 Excel 文件", e7)));
                                    fileInputStream.close();
                                } catch (NotOLE2FileException e8) {
                                    objM1361constructorimpl = u.m1361constructorimpl(v.createFailure(new Exception("文件格式错误，请确保选择的是有效的 Excel 文件（.xls）", e8)));
                                    fileInputStream.close();
                                } catch (Exception e9) {
                                    objM1361constructorimpl = u.m1361constructorimpl(v.createFailure(new Exception("读取 Excel 文件失败: " + e9.getMessage(), e9)));
                                    fileInputStream.close();
                                }
                            }
                        } catch (Exception e10) {
                            e = e10;
                            objM1361constructorimpl = u.m1361constructorimpl(v.createFailure(new Exception("处理 Excel 文件时发生错误: " + e.getMessage(), e)));
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            z6 = objM1361constructorimpl instanceof u.a;
                            if (z6) {
                                Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(objM1361constructorimpl);
                                E.c(thM1362exceptionOrNullimpl);
                                return u.m1361constructorimpl(v.createFailure(thM1362exceptionOrNullimpl));
                            }
                            Object obj = z6 ? null : objM1361constructorimpl;
                            E.c(obj);
                            C1938s c1938s = (C1938s) obj;
                            return u.m1361constructorimpl(new e(url, ((Number) c1938s.f9134a).intValue(), (List) c1938s.b));
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream3 = fileInputStream;
                        if (fileInputStream3 != null) {
                            fileInputStream3.close();
                        }
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                fileInputStream.close();
                z6 = objM1361constructorimpl instanceof u.a;
                if (z6) {
                    Throwable thM1362exceptionOrNullimpl2 = u.m1362exceptionOrNullimpl(objM1361constructorimpl);
                    E.c(thM1362exceptionOrNullimpl2);
                    return u.m1361constructorimpl(v.createFailure(thM1362exceptionOrNullimpl2));
                }
                if (z6) {
                }
                E.c(obj);
                C1938s c1938s2 = (C1938s) obj;
                return u.m1361constructorimpl(new e(url, ((Number) c1938s2.f9134a).intValue(), (List) c1938s2.b));
            }
            fileInputStream2 = null;
            Sheet sheetAt = workbook.getSheetAt(0);
            if (sheetAt.getLastRowNum() < 1) {
                objM1361constructorimpl2 = u.m1361constructorimpl(new C1938s(0, A3.I.emptyList()));
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
            } else {
                Row row = sheetAt.getRow(0);
                Row row2 = sheetAt.getRow(1);
                if (row == null || row2 == null) {
                    objM1361constructorimpl2 = u.m1361constructorimpl(new C1938s(0, A3.I.emptyList()));
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                } else {
                    ArrayList arrayList = new ArrayList();
                    short lastCellNum = row.getLastCellNum();
                    for (int i5 = 0; i5 < lastCellNum; i5++) {
                        arrayList.add(new d(b(row.getCell(i5)), b(row2.getCell(i5))));
                    }
                    objM1361constructorimpl2 = u.m1361constructorimpl(new C1938s(Integer.valueOf(sheetAt.getLastRowNum()), arrayList));
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                }
            }
            objM1361constructorimpl = objM1361constructorimpl2;
        } catch (Exception e12) {
            fileInputStream = fileInputStream2;
            e = e12;
            objM1361constructorimpl = u.m1361constructorimpl(v.createFailure(new Exception("处理 Excel 文件时发生错误: " + e.getMessage(), e)));
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream3 = fileInputStream2;
            if (fileInputStream3 != null) {
                fileInputStream3.close();
            }
            throw th;
        }
        z6 = objM1361constructorimpl instanceof u.a;
        if (z6) {
            Throwable thM1362exceptionOrNullimpl3 = u.m1362exceptionOrNullimpl(objM1361constructorimpl);
            E.c(thM1362exceptionOrNullimpl3);
            return u.m1361constructorimpl(v.createFailure(thM1362exceptionOrNullimpl3));
        }
        if (z6) {
        }
        E.c(obj);
        C1938s c1938s3 = (C1938s) obj;
        return u.m1361constructorimpl(new e(url, ((Number) c1938s3.f9134a).intValue(), (List) c1938s3.b));
    }

    public static final void setCachePath(String path) {
        E.f(path, "path");
        cachePath = path;
    }

    public final LruCache<String, Workbook> getCache() {
        return cache;
    }

    public final void setCache(LruCache<String, Workbook> lruCache) {
        E.f(lruCache, "<set-?>");
        cache = lruCache;
    }
}
