package cn.fly.tools.b;

import A3.AbstractC0157z;
import android.app.ActivityManager;
import android.app.Application;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.net.Proxy;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.CellInfo;
import android.telephony.NeighboringCellInfo;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import cn.fly.commons.C0396r;
import cn.fly.commons.CSCenter;
import cn.fly.commons.FlyMeta;
import cn.fly.commons.ab;
import cn.fly.commons.x;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.Data;
import cn.fly.tools.utils.NtFetcher;
import cn.fly.tools.utils.ReflectHelper;
import cn.fly.tools.utils.ResHelper;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static b b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1684a;
    private volatile int c = -1;

    private b(Context context) {
        this.f1684a = context.getApplicationContext();
    }

    public static synchronized b a(Context context) {
        try {
            if (b == null && context != null) {
                b = new b(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    private String aA() {
        HashMap map;
        HashMap<String, Object> mapAB = aB();
        if (mapAB == null || (map = (HashMap) mapAB.get(x.b("010Jcb*eOccch@be+dd d$decj"))) == null) {
            return null;
        }
        try {
            return Data.byteToHex(Data.SHA1("null:null:" + ((String) map.get(x.b("005Ucecjcb1ef")))));
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return null;
        }
    }

    private HashMap<String, Object> aB() {
        HashMap<String, Object> mapC = cn.fly.commons.f.c();
        if (mapC.isEmpty()) {
            return null;
        }
        return (HashMap) mapC.get(x.b("010Ecb=eZccchHbe5ddXd decj"));
    }

    private String aC() {
        ObjectInputStream objectInputStream;
        FileInputStream fileInputStream;
        File cacheRootFile;
        File file = new File(s(), x.b("008Jdk$gc!ci]eUdkekhb"));
        if (file.exists()) {
            File file2 = new File(file, x.b("003'ckcbdg"));
            if (file2.exists() && (cacheRootFile = ResHelper.getCacheRootFile(this.f1684a, x.b("003_ckcbdg"))) != null && file2.renameTo(cacheRootFile)) {
                file2.delete();
            }
        }
        File cacheRootFile2 = ResHelper.getCacheRootFile(this.f1684a, x.b("003!ckcbdg"));
        String strValueOf = null;
        if (cacheRootFile2 != null && !cacheRootFile2.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(cacheRootFile2);
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);
                try {
                    Object object = objectInputStream.readObject();
                    if (object != null && (object instanceof char[])) {
                        strValueOf = String.valueOf((char[]) object);
                    }
                    C0396r.a(objectInputStream, fileInputStream);
                    return strValueOf;
                } catch (Throwable th) {
                    th = th;
                    try {
                        FlyLog.getInstance().d(th);
                        C0396r.a(objectInputStream, fileInputStream);
                        return null;
                    } catch (Throwable th2) {
                        C0396r.a(objectInputStream, fileInputStream);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
            fileInputStream = null;
        }
    }

    private HashMap<String, String> aD() {
        try {
            return (HashMap) ResHelper.readObjectFromFile(ResHelper.getDataCacheFile(this.f1684a, x.b("0049ck5cd7eh")).getAbsolutePath());
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            ResHelper.getDataCacheFile(this.f1684a, x.b("0046ckPcdReh")).delete();
            return null;
        }
    }

    private Set<String> aE() {
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        Object objC;
        HashSet hashSet = new HashSet();
        if (cn.fly.commons.e.b() && !x.b("005_ce,eRchfccf").equalsIgnoreCase(DH.SyncMtd.getManufacturerForFly()) && l.a()) {
            try {
                try {
                    objC = C0396r.c(x.b("016iOcehe,f cheh<h.heNicb8dg(cBdi'e@eh"));
                    try {
                        inputStream = (InputStream) ReflectHelper.invokeInstanceMethod(objC, x.b("014=di9eh7ddJdi(cfThBdk@h;ciAec6ce"), new Object[0]);
                        try {
                            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                            try {
                                bufferedReader = new BufferedReader(inputStreamReader);
                                try {
                                    for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                                        String strTrim = line.trim();
                                        if (strTrim.length() > 8 && strTrim.substring(0, 8).equalsIgnoreCase(x.b("008icbTdgHc diIej"))) {
                                            String strTrim2 = strTrim.substring(8).trim();
                                            if (!TextUtils.isEmpty(strTrim2)) {
                                                hashSet.add(strTrim2);
                                            }
                                        }
                                    }
                                    C0396r.a(bufferedReader, inputStreamReader, inputStream);
                                    if (objC != null) {
                                        ReflectHelper.invokeInstanceMethod(objC, x.b("007QcbZeLeh-h>cicjdb"), new Object[0]);
                                        return hashSet;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        FlyLog.getInstance().w(th);
                                        C0396r.a(bufferedReader, inputStreamReader, inputStream);
                                        if (objC != null) {
                                            ReflectHelper.invokeInstanceMethod(objC, x.b("007QcbZeLeh-h>cicjdb"), new Object[0]);
                                        }
                                    } catch (Throwable th3) {
                                        C0396r.a(bufferedReader, inputStreamReader, inputStream);
                                        if (objC != null) {
                                            try {
                                                ReflectHelper.invokeInstanceMethod(objC, x.b("007QcbZeLeh-h>cicjdb"), new Object[0]);
                                            } catch (Throwable unused) {
                                            }
                                        }
                                        throw th3;
                                    }
                                }
                            } catch (Throwable th4) {
                                bufferedReader = null;
                                th = th4;
                            }
                        } catch (Throwable th5) {
                            bufferedReader = null;
                            th = th5;
                            inputStreamReader = null;
                        }
                    } catch (Throwable th6) {
                        inputStreamReader = null;
                        bufferedReader = null;
                        th = th6;
                        inputStream = null;
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable th7) {
                inputStream = null;
                inputStreamReader = null;
                bufferedReader = null;
                th = th7;
                objC = null;
            }
        }
        return hashSet;
    }

    private Set<String> aF() {
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        Object objC;
        HashSet hashSet = new HashSet();
        if (cn.fly.commons.e.b()) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    objC = C0396r.c(x.b("032b:cecbheIicbNdg+c.di e7hecdcf_e_cidbgj.cbhAchccch0hIch_e>ehhegj=c=he") + x.b("026cdGcbcicjchcbckch3dhedh1ckPcbh9chcj'dIckgbecdddf") + " " + x.b("008+gjgjcfehLeBciheeg"));
                    try {
                        inputStream = (InputStream) ReflectHelper.invokeInstanceMethod(objC, x.b("0144diPehTdd*di:cf!h;dkRh5ci7ec(ce"), new Object[0]);
                        if (inputStream != null) {
                            try {
                                inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                                try {
                                    bufferedReader = new BufferedReader(inputStreamReader);
                                    try {
                                        String strB = x.b("012icbZdg!c?diWeMdf<c$ce,eJhh");
                                        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                                            String strTrim = line.trim();
                                            if (strTrim.length() > strB.length() && strTrim.substring(0, strB.length()).equalsIgnoreCase(strB)) {
                                                String strTrim2 = strTrim.substring(strB.length()).trim();
                                                if (!TextUtils.isEmpty(strTrim2)) {
                                                    hashSet.add(strTrim2);
                                                }
                                            }
                                        }
                                        bufferedReader2 = bufferedReader;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        try {
                                            FlyLog.getInstance().w(th);
                                            C0396r.a(bufferedReader, inputStreamReader, inputStream);
                                            if (objC != null) {
                                                ReflectHelper.invokeInstanceMethod(objC, x.b("0074cb1e8ehThVcicjdb"), new Object[0]);
                                            }
                                        } catch (Throwable th3) {
                                            C0396r.a(bufferedReader, inputStreamReader, inputStream);
                                            if (objC != null) {
                                                try {
                                                    ReflectHelper.invokeInstanceMethod(objC, x.b("0074cb1e8ehThVcicjdb"), new Object[0]);
                                                } catch (Throwable unused) {
                                                }
                                            }
                                            throw th3;
                                        }
                                    }
                                } catch (Throwable th4) {
                                    bufferedReader = null;
                                    th = th4;
                                }
                            } catch (Throwable th5) {
                                bufferedReader = null;
                                th = th5;
                                inputStreamReader = null;
                            }
                        } else {
                            inputStreamReader = null;
                        }
                        C0396r.a(bufferedReader2, inputStreamReader, inputStream);
                        if (objC != null) {
                            ReflectHelper.invokeInstanceMethod(objC, x.b("0074cb1e8ehThVcicjdb"), new Object[0]);
                            return hashSet;
                        }
                    } catch (Throwable th6) {
                        inputStreamReader = null;
                        bufferedReader = null;
                        th = th6;
                        inputStream = null;
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable th7) {
                inputStream = null;
                inputStreamReader = null;
                bufferedReader = null;
                th = th7;
                objC = null;
            }
        }
        return hashSet;
    }

    private Set<String> aG() {
        HashSet hashSet = new HashSet();
        if (cn.fly.commons.e.b()) {
            for (int i5 = 10000; i5 <= 13000; i5++) {
                String[] strArr = (String[]) ReflectHelper.invokeInstanceMethod(this.f1684a.getPackageManager(), "getPackagesForUid", new Object[]{Integer.valueOf(i5)}, new Class[]{Integer.TYPE}, null);
                if (strArr != null && !TextUtils.isEmpty(strArr[0]) && !strArr[0].startsWith(x.b("035bNcjceckdicjcjdiOfeRckLcdAcbcicjchcbck6h]cich]bg5cicjceEefVcheeciKcGcidb"))) {
                    hashSet.add(strArr[0]);
                }
            }
        }
        return hashSet;
    }

    private boolean aH() {
        try {
            return ((Boolean) ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(x.b("016cdKcbcicjchcbckcjehckekJe'eecfdi")), x.b("019.chehekPe4eecfdidi4eVcidccj(ddebhe>cb"), new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private String az() {
        try {
            return Data.byteToHex(Data.SHA1("null:null:" + c.a(this.f1684a).d().n()));
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return null;
        }
    }

    public static Context w() {
        return C0396r.a();
    }

    public HashMap<String, Object> A() {
        HashMap<String, Object> map = new HashMap<>();
        try {
            FileReader fileReader = new FileReader(x.b("013ki5cicj7bkbi^cfch%d^decj"));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList arrayList = new ArrayList();
            map.put(x.b("010iZcicj)beSehehcjcieh"), arrayList);
            while (true) {
                HashMap map2 = null;
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        bufferedReader.close();
                        fileReader.close();
                        return map;
                    }
                    if (TextUtils.isEmpty(line)) {
                        break;
                    }
                    String strTrim = line.trim();
                    if (strTrim.startsWith(x.b("009iCcicjJbe<ehehcjci"))) {
                        if (map2 != null) {
                            arrayList.add(map2);
                        }
                        map2 = new HashMap();
                    }
                    String[] strArrSplit = strTrim.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
                    if (strArrSplit.length > 1) {
                        if (map2 == null) {
                            map.put(strArrSplit[0].trim(), strArrSplit[1].trim());
                        } else {
                            map2.put(strArrSplit[0].trim(), strArrSplit[1].trim());
                        }
                    }
                }
                if (map2 != null) {
                    arrayList.add(map2);
                }
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return map;
        }
    }

    public ArrayList<ArrayList<String>> B() {
        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        if (DH.SyncMtd.getOSVersionIntForFly() < 28) {
            try {
                FileReader fileReader = new FileReader(x.b("017kiMcicj6bkhhCdb@k$cbcichcc*eYcieh"));
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        bufferedReader.close();
                        fileReader.close();
                        return arrayList;
                    }
                    if (!TextUtils.isEmpty(line)) {
                        String[] strArrSplit = line.trim().split(" ");
                        if (strArrSplit.length > 1) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            for (String str : strArrSplit) {
                                if (!TextUtils.isEmpty(str)) {
                                    arrayList2.add(str.trim());
                                }
                            }
                            arrayList.add(arrayList2);
                        }
                    }
                }
            } catch (Throwable th) {
                FlyLog.getInstance().d(th.getMessage(), new Object[0]);
            }
        }
        return arrayList;
    }

    public String C() {
        String strA = e.a(this.f1684a).a(x.b("014Dcicjckdg8e.ci)def5ckcd5eCcecf"), "0");
        return strA == null ? "0" : strA;
    }

    public HashMap<String, HashMap<String, Long>> D() {
        long availableBlocksLong;
        long freeBlocksLong;
        long blockCountLong;
        long blockSizeLong;
        HashMap<String, HashMap<String, Long>> map = new HashMap<>();
        String[] strArr = {x.b("0065ehcbBbcQcicb"), x.b("004:cbIchc")};
        for (int i5 = 0; i5 < 2; i5++) {
            String str = strArr[i5];
            HashMap<String, Long> map2 = new HashMap<>();
            map2.put("available", -1L);
            map2.put(x.b("004+deciBee"), -1L);
            map2.put(x.b("005h@cjMhcf"), -1L);
            map.put(str, map2);
        }
        HashMap map3 = new HashMap();
        String strS = s();
        if (strS != null) {
            map3.put(x.b("006'ehcb2bc)cicb"), new StatFs(strS));
        }
        File dataDirectory = Environment.getDataDirectory();
        if (dataDirectory != null) {
            map3.put(x.b("0041cbKchc"), new StatFs(dataDirectory.getPath()));
        }
        for (Map.Entry entry : map3.entrySet()) {
            StatFs statFs = (StatFs) entry.getValue();
            if (DH.SyncMtd.getOSVersionIntForFly() <= 18) {
                availableBlocksLong = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
                freeBlocksLong = ((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize());
                blockCountLong = statFs.getBlockCount();
                blockSizeLong = statFs.getBlockSize();
            } else {
                availableBlocksLong = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
                freeBlocksLong = statFs.getFreeBlocksLong() * statFs.getBlockSizeLong();
                blockCountLong = statFs.getBlockCountLong();
                blockSizeLong = statFs.getBlockSizeLong();
            }
            HashMap<String, Long> map4 = map.get(entry.getKey());
            map4.put("available", Long.valueOf(availableBlocksLong));
            map4.put(x.b("004Gdeci+ee"), Long.valueOf(freeBlocksLong));
            map4.put(x.b("005h2cjThcf"), Long.valueOf(blockCountLong * blockSizeLong));
        }
        return map;
    }

    public HashMap<String, Long> E() {
        HashMap<String, Long> map = new HashMap<>();
        map.put("available", -1L);
        map.put(x.b("005hPcj0hcf"), -1L);
        map.put(x.b("005Cchehedcjef"), -1L);
        map.put(x.b("009hgEciTeFehSg]cj$f>cb"), -1L);
        Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(x.b("008cbh^chccch;h db"));
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ReflectHelper.invokeInstanceMethodNoThrow(systemServiceSafe, x.b("013QdiYeh]gb,e<cecjcidbddZd<decj"), null, memoryInfo);
        map.put("available", Long.valueOf(memoryInfo.availMem));
        if (DH.SyncMtd.getOSVersionIntForFly() >= 16) {
            map.put(x.b("005h.cj-hcf"), Long.valueOf(memoryInfo.totalMem));
        }
        map.put(x.b("0054chehedcjef"), Long.valueOf(memoryInfo.lowMemory ? 1L : 0L));
        map.put(x.b("009hg,ciSeYeh>g]cj:f[cb"), Long.valueOf(memoryInfo.threshold));
        return map;
    }

    public String F() {
        return cn.fly.tools.utils.f.a().b();
    }

    public boolean G() {
        String[] strArr = {x.b("020b8cjceckDh*cj?iOgfcjUgd+efcfckce'cNdichehdg"), x.b("0247chcjckdichUhgUcfeeck+gIcfehdgdbcbdickce-cMdichehdg"), x.b("032Ccb[eZckcicjeeccckAcdScbcicjchcbckdh,i8cjeh.e8cbckchOdHehBhcffeHci"), x.b("028^cjcidickceLeIcjefKbchBckRe cbdh3iQcjeh7eUcbckce@cdc*di1eKci"), x.b("0272cecj-e(ckehJgYchfccfdgcfckciDeLcbchciIebhFeh hWcjci[cXdi[e"), x.b("0185ce9e'ckefReQchehBgLcfckdg^eKciXdef6ehcf"), x.b("027Qchcjckdich^hg-cfeeckcccceegdegggegckce4cgQcjeh1gScjgfcj"), x.b("0130ejcjcjdgckfdchcffecfckff.i"), "club.youppgd.adhook", x.b("027FchKb!cfckUd;cfEffih!cick]ciifVcheh%h,cb:ehebh2cjci"), x.b("0323chcjckdich?hg2cfeeck!gHcfehdgdbcbdickceUePcecjcidbcbRehebh<cjci"), x.b("034b4cjceckdich7hg=cfeeck'bcidh.cichRi ehckdg?eBci6def[de?fcQehRgeEci")};
        for (int i5 = 0; i5 < 12; i5++) {
            try {
                if (c.a(this.f1684a).d().a(strArr[i5], 0) != null) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        try {
            throw new Exception("msk");
        } catch (Throwable th) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (stackTraceElement.getClassName().contains(x.b("035Mcb;e]ckcicjeeccckPcdZcbcicjchcbckdh]iAcjeh0eWcbckff5iBcjeh<e@cbeicichcbdi-e"))) {
                    return true;
                }
            }
            try {
                try {
                    ClassLoader.getSystemClassLoader().loadClass(x.b("036Xcb]e;ckcicjeeccck*cdIcbcicjchcbckdh8iHcjehPe5cbckffWiMcjeh0e)cbejIefieUcieh")).newInstance();
                    try {
                        ClassLoader.getSystemClassLoader().loadClass(x.b("035HcbDe=ckcicjeeccckXcd cbcicjchcbckdh@i@cjeh!e[cbckffGi,cjehMe?cbeicichcbdi$e")).newInstance();
                    } catch (IllegalAccessException | InstantiationException unused2) {
                    }
                    return true;
                } catch (IllegalAccessException | InstantiationException unused3) {
                    return true;
                }
            } catch (Throwable unused4) {
                BufferedReader bufferedReader = null;
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(x.b("006ki9cicj7bk") + Process.myPid() + x.b("005k.ce2ciSeh")));
                    boolean zContains = false;
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null || zContains) {
                                break;
                            }
                            zContains = line.toLowerCase().contains(x.b("006-dhAi4cjeh*eQcb"));
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            try {
                                FlyLog.getInstance().d(th);
                                C0396r.a(bufferedReader);
                                return false;
                            } catch (Throwable th3) {
                                C0396r.a(bufferedReader);
                                throw th3;
                            }
                        }
                    }
                    C0396r.a(bufferedReader2);
                    return zContains;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
    }

    public boolean H() {
        return (this.f1684a.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public boolean I() {
        try {
            if (DH.SyncMtd.getOSVersionIntForFly() >= 17) {
                return Settings.Secure.getInt(this.f1684a.getContentResolver(), "adb_enabled", 0) > 0;
            }
            return Settings.Secure.getInt(this.f1684a.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Throwable unused) {
        }
    }

    public boolean J() {
        try {
            if (DH.SyncMtd.getOSVersionIntForFly() >= 17) {
                return Settings.Secure.getInt(this.f1684a.getContentResolver(), "development_settings_enabled", 0) > 0;
            }
            return Settings.Secure.getInt(this.f1684a.getContentResolver(), "development_settings_enabled", 0) > 0;
        } catch (Throwable unused) {
        }
    }

    public boolean K() {
        Intent intentA = C0396r.a((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return intentA != null && intentA.getIntExtra("plugged", -1) == 2;
    }

    public boolean L() {
        return false;
    }

    public boolean M() {
        ApplicationInfo applicationInfoA = c.a(this.f1684a).d().a(false, DH.SyncMtd.getPackageName(), 1);
        return (applicationInfoA == null || (applicationInfoA.flags & 2) == 0) ? false : true;
    }

    public boolean N() {
        String host;
        int port;
        try {
            if (DH.SyncMtd.getOSVersionIntForFly() >= 14) {
                host = System.getProperty(x.b("014ghhi.ckTi?cicjdhdbejcjehEh"));
                String property = System.getProperty(x.b("014ghhi.ckXiBcicjdhdbfkcjciPh"));
                if (property == null) {
                    property = StructuredDataId.RESERVED;
                }
                try {
                    port = Integer.parseInt(property);
                } catch (Throwable unused) {
                    port = -1;
                }
            } else {
                host = Proxy.getHost(this.f1684a);
                port = Proxy.getPort(this.f1684a);
            }
            return (TextUtils.isEmpty(host) || port == -1) ? false : true;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public boolean O() {
        return (DH.SyncMtd.getOSVersionIntForFly() >= 29) && (c.a(this.f1684a).d().ar().targetSdkVersion >= 29);
    }

    public String P() {
        try {
            String id = TimeZone.getDefault().getID();
            if (!TextUtils.isEmpty(id)) {
                return id;
            }
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            Settings.System.getConfiguration(this.f1684a.getContentResolver(), configuration);
            Locale locale = configuration.locale;
            if (locale == null) {
                locale = Locale.getDefault();
            }
            return Calendar.getInstance(locale).getTimeZone().getID();
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return null;
        }
    }

    public String Q() {
        return c.a(this.f1684a).d().a(x.b("0150cicjckeecfch+fXcbckde3fc[cccjci"));
    }

    public String R() {
        return c.a(this.f1684a).d().a(x.b("020Wdiehceckcc@e;ciehchcjQd1ckeeHcEehWe-ee7cd!cb"));
    }

    public String S() {
        return c.a(this.f1684a).d().a(x.b("016GcicjckBi<cicjcbcfPbhLckeecj0cXcicb"));
    }

    public String T() {
        return c.a(this.f1684a).d().a(x.b("017DcicjckeecjRcBcicbckMifch7decjcice"));
    }

    public int U() {
        return NtFetcher.getInstance(this.f1684a).getDtNtType();
    }

    public String V() {
        return Build.BRAND;
    }

    public boolean W() {
        return b(this.f1684a) != 0;
    }

    public String X() {
        try {
            if (DH.SyncMtd.getOSVersionIntForFly() >= 28) {
                return Application.getProcessName();
            }
            Method declaredMethod = Class.forName(x.b("026cd9cbcicjchcbckDciiTckecIbh?chccch[h_dbebPg!ci(ec<cb"), false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, null);
            return objInvoke instanceof String ? (String) objInvoke : "";
        } catch (Throwable th) {
            FlyLog.getInstance().d(androidx.exifinterface.media.a.n("getProcessName: ", th), new Object[0]);
            return "";
        }
    }

    public long Y() {
        Object objB = c.a(this.f1684a).d().b(false, 0, n(), 0);
        if (objB != null) {
            return cn.fly.tools.c.e(objB, DH.SyncMtd.getPackageName());
        }
        return 0L;
    }

    public String Z() {
        return Build.DEVICE;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0065  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    public String aa() {
        Object objC;
        InputStream inputStream;
        ?? bufferedReader;
        String line;
        ?? r7;
        try {
            objC = C0396r.c(x.b("021bch]he=ki;cicj]bk5ehVef!de@kb)dicicjcfYi"));
            try {
                inputStream = (InputStream) ReflectHelper.invokeInstanceMethodNoThrow(objC, x.b("014MdiUeh<ddKdi+cfThKdkDhRciYec7ce"), null, new Object[0]);
                if (inputStream != null) {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        try {
                            line = bufferedReader.readLine();
                            r7 = bufferedReader;
                        } catch (Throwable th) {
                            th = th;
                            try {
                                FlyLog.getInstance().d(th);
                                C0396r.a((Closeable[]) new Closeable[]{bufferedReader, inputStream});
                                if (objC != null) {
                                    ReflectHelper.invokeInstanceMethodNoThrow(objC, x.b("007 cb7eHeh8hEcicjdb"), null, new Object[0]);
                                }
                                return null;
                            } catch (Throwable th2) {
                                C0396r.a((Closeable[]) new Closeable[]{bufferedReader, inputStream});
                                if (objC != null) {
                                    ReflectHelper.invokeInstanceMethodNoThrow(objC, x.b("007 cb7eHeh8hEcicjdb"), null, new Object[0]);
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = 0;
                    }
                } else {
                    r7 = 0;
                    line = null;
                }
                C0396r.a((Closeable[]) new Closeable[]{r7, inputStream});
                if (objC != null) {
                    ReflectHelper.invokeInstanceMethodNoThrow(objC, x.b("007 cb7eHeh8hEcicjdb"), null, new Object[0]);
                }
                return line;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                bufferedReader = inputStream;
                FlyLog.getInstance().d(th);
                C0396r.a((Closeable[]) new Closeable[]{bufferedReader, inputStream});
                if (objC != null) {
                    ReflectHelper.invokeInstanceMethodNoThrow(objC, x.b("007 cb7eHeh8hEcicjdb"), null, new Object[0]);
                }
                return null;
            }
        } catch (Throwable th5) {
            th = th5;
            objC = null;
            inputStream = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x008f  */
    /* JADX WARN: Code duplicated, block: B:51:? A[RETURN, SYNTHETIC] */
    public String ab() {
        Object objC;
        InputStream inputStream;
        Closeable closeable;
        try {
            objC = C0396r.c(x.b("017bch=he)kiBcicjEbkbi.cfchQdRdecj"));
            try {
                inputStream = (InputStream) ReflectHelper.invokeInstanceMethodNoThrow(objC, x.b("014?diAeh'dd<diScfBhKdk6h'ci'ecYce"), null, new Object[0]);
                if (inputStream == null) {
                    C0396r.a(null, inputStream);
                    if (objC == null) {
                        return "";
                    }
                    ReflectHelper.invokeInstanceMethodNoThrow(objC, x.b("007$cb=eRehRh-cicjdb"), null, new Object[0]);
                    return "";
                }
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            stringBuffer.append(line);
                        } catch (Throwable th) {
                            th = th;
                            closeable = bufferedReader;
                            try {
                                FlyLog.getInstance().d(th);
                                C0396r.a(closeable, inputStream);
                                if (objC != null) {
                                    return "";
                                }
                                ReflectHelper.invokeInstanceMethodNoThrow(objC, x.b("007$cb=eRehRh-cicjdb"), null, new Object[0]);
                                return "";
                            } catch (Throwable th2) {
                                C0396r.a(closeable, inputStream);
                                if (objC != null) {
                                    ReflectHelper.invokeInstanceMethodNoThrow(objC, x.b("007$cb=eRehRh-cicjdb"), null, new Object[0]);
                                }
                                throw th2;
                            }
                        }
                    }
                    bufferedReader.close();
                    String lowerCase = stringBuffer.toString().toLowerCase();
                    C0396r.a(bufferedReader, inputStream);
                    if (objC != null) {
                        ReflectHelper.invokeInstanceMethodNoThrow(objC, x.b("007$cb=eRehRh-cicjdb"), null, new Object[0]);
                    }
                    return lowerCase;
                } catch (Throwable th3) {
                    th = th3;
                    closeable = null;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                closeable = inputStream;
                FlyLog.getInstance().d(th);
                C0396r.a(closeable, inputStream);
                if (objC != null) {
                    return "";
                }
                ReflectHelper.invokeInstanceMethodNoThrow(objC, x.b("007$cb=eRehRh-cicjdb"), null, new Object[0]);
                return "";
            }
        } catch (Throwable th5) {
            th = th5;
            objC = null;
            inputStream = null;
        }
    }

    public String ac() {
        return cn.fly.commons.c.d.b(this.f1684a);
    }

    public boolean ad() {
        if (CSCenter.getInstance().isSystemInfoAvailable()) {
            return DH.SyncMtd.getOSVersionIntForFly() < 17 || Settings.Global.getInt(this.f1684a.getContentResolver(), "auto_time", 0) == 1;
        }
        return Settings.Global.getInt(this.f1684a.getContentResolver(), "auto_time", 0) == 1;
    }

    public HashMap<String, Object> ae() {
        return cn.fly.commons.c.d.a(this.f1684a);
    }

    public String af() {
        return "";
    }

    public long ag() {
        return Build.TIME;
    }

    public double ah() {
        return ResHelper.getScreenInch(this.f1684a);
    }

    public int ai() {
        return ResHelper.getScreenPpi(this.f1684a);
    }

    public boolean aj() {
        return x.b("007)ejWc@cicecj]dEdb").equalsIgnoreCase((String) ReflectHelper.invokeStaticMethodNoThrow(ReflectHelper.importClassNoThrow(x.b("025b:cjceckLgFcfZcTef?eAchckehdbehXhe3ceckeicfch:f[cbfhdh"), null), x.b("010Bdi+eh(fgeheici:cdEcb"), null, new Object[0]));
    }

    public String ak() {
        return c.a(this.f1684a).d().a(x.b("028gGefcgeh%b$ckeecfch,f4cbck_ifch7decjciceckccUeTciehchcj>d"));
    }

    public String al() {
        String strGroup = null;
        try {
            String strAy = c.a(this.f1684a).d().ay();
            String strA = c.a(this.f1684a).d().a("ro.build.ver.physical");
            if (!TextUtils.isEmpty(strA) && strA.contains(strAy)) {
                Matcher matcher = Pattern.compile(strAy + "(\\.\\d+)?").matcher(strA);
                while (matcher.find()) {
                    strGroup = matcher.group();
                }
            }
            return strGroup;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return null;
        }
    }

    public int am() {
        try {
            return Settings.Secure.getInt(this.f1684a.getContentResolver(), x.b("015i^cfci-e@cgcecjcb$eCcgeh4hche"));
        } catch (Settings.SettingNotFoundException unused) {
            return -1;
        }
    }

    public String an() {
        return DH.SyncMtd.getOSVersionIntForFly() >= 23 ? Build.VERSION.SECURITY_PATCH : "";
    }

    public HashMap<String, Long> ao() {
        HashMap<String, Long> map = new HashMap<>();
        map.put(x.b("005h@cj*hcf"), -1L);
        map.put(x.b("003@ce2cIdh"), -1L);
        map.put(x.b("004Ndeci3ee"), -1L);
        Runtime runtime = Runtime.getRuntime();
        map.put(x.b("005h1cj8hcf"), Long.valueOf(runtime.totalMemory()));
        map.put(x.b("003+ce cMdh"), Long.valueOf(runtime.maxMemory()));
        map.put(x.b("004%deci%ee"), Long.valueOf(runtime.freeMemory()));
        return map;
    }

    public String ap() {
        try {
            return ab.a().e();
        } catch (Throwable unused) {
            return null;
        }
    }

    public int aq() {
        try {
            return Settings.Secure.getInt(this.f1684a.getContentResolver(), x.b("024i5cfciAeLcg<edgcdbe)cbcgcecjcb$e,cgeh:hche"));
        } catch (Settings.SettingNotFoundException unused) {
            return -1;
        }
    }

    public Object ar() {
        Object cellLocation;
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        int i5;
        int iIntValue4;
        int iIntValue5;
        int iIntValue6;
        Object systemServiceSafe;
        int i6 = -1;
        HashMap map = null;
        if (cn.fly.commons.e.h()) {
            if (CSCenter.getInstance().isCellLocationDataEnable()) {
                cellLocation = (!DH.SyncMtd.checkPermission(x.b("041cdHcbcicjchcbckHie cicechehehchcjGdUckecdcdcfhdkdkcgdcfgecfidkfhcgedfgdcecebddfgdf")) || (systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(x.b("005igLcj5de"))) == null) ? null : ReflectHelper.invokeInstanceMethodNoThrow(systemServiceSafe, x.b("0152diBeh^dc,eff+edcj<bch8chcj1d"), null, new Object[0]);
            } else {
                cellLocation = CSCenter.getInstance().getCellLocation();
            }
            if (cellLocation != null) {
                map = new HashMap();
                if (x.b("016FdccbceFc)dcReff'edcj>bch[chcjMd").equals(cellLocation.getClass().getSimpleName())) {
                    map.put(x.b("0160dccbce+cXdcBeffKedcj2bchJchcjId"), 1);
                    int iIntValue7 = ((Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethodNoThrow(cellLocation, x.b("022@di4eh3eiJcSeh4eTdk7hch[chcjWd>edXch<ch]hTcfcb4e"), -1, new Object[0]), -1)).intValue();
                    iIntValue6 = ((Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethodNoThrow(cellLocation, x.b("023?diQeh.eiWc,ehQe,dkYhch@chcjJd@edcj^d6dich hIcfcbEe"), -1, new Object[0]), -1)).intValue();
                    iIntValue4 = ((Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethodNoThrow(cellLocation, x.b("016Qdi.ehYeiFc0ehSe!dk8hch!chcjHdYddcb"), -1, new Object[0]), -1)).intValue();
                    iIntValue5 = ((Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethodNoThrow(cellLocation, x.b("011EdiIehIdkdbehUheTceddcb"), -1, new Object[0]), -1)).intValue();
                    iIntValue3 = ((Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethodNoThrow(cellLocation, x.b("0124diCeh=dfXeh%efcjcidgddcb"), -1, new Object[0]), -1)).intValue();
                    i5 = iIntValue7;
                    iIntValue2 = -1;
                    iIntValue = -1;
                } else {
                    map.put(x.b("0167dccbce<cVdc;effNedcj]bch)chcj%d"), -1);
                    iIntValue = ((Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethodNoThrow(cellLocation, x.b("0066diRehPfkeh!b"), -1, new Object[0]), -1)).intValue();
                    int iIntValue8 = ((Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethodNoThrow(cellLocation, x.b("006 diUehLed-cb"), -1, new Object[0]), -1)).intValue();
                    iIntValue2 = ((Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethodNoThrow(cellLocation, x.b("006-di>eh_dcchcb"), -1, new Object[0]), -1)).intValue();
                    iIntValue3 = -1;
                    i5 = -1;
                    iIntValue4 = -1;
                    iIntValue5 = -1;
                    i6 = iIntValue8;
                    iIntValue6 = -1;
                }
                map.put(x.b("003fcb"), Integer.valueOf(i6));
                map.put(x.b("004beff"), Integer.valueOf(iIntValue2));
                map.put(x.b("003iNeh%b"), Integer.valueOf(iIntValue));
                map.put(x.b("003Qeechcb"), Integer.valueOf(iIntValue4));
                map.put(x.b("003?ehchcb"), Integer.valueOf(iIntValue5));
                map.put(x.b("003dMchcb"), Integer.valueOf(iIntValue3));
                map.put(x.b("003fch"), Integer.valueOf(i5));
                map.put(x.b("003fWcj%d"), Integer.valueOf(iIntValue6));
            }
        }
        return map;
    }

    public String as() {
        LocaleList localeList;
        Locale locale;
        if (DH.SyncMtd.getOSVersionIntForFly() < 33 || (localeList = (LocaleList) ReflectHelper.invokeInstanceMethodNoThrow(DH.SyncMtd.getSystemServiceSafe("locale"), "getApplicationLocales", null, new Object[0])) == null || localeList.isEmpty() || (locale = localeList.get(0)) == null) {
            return null;
        }
        return locale.getLanguage();
    }

    public int at() {
        if (DH.SyncMtd.getOSVersionIntForFly() >= 34) {
            try {
                return ((Integer) ReflectHelper.invokeInstanceMethod(this.f1684a.getSystemService(Class.forName("android.app.GrammaticalInflectionManager")), "getApplicationGrammaticalGender", new Object[0])).intValue();
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public boolean au() {
        String strSubstring;
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(x.b("006ki>cicj]bk") + Process.myPid() + x.b("007k:eh+hchLcfeh"), "r");
            strSubstring = "0";
            while (true) {
                try {
                    String line = randomAccessFile2.readLine();
                    if (line == null) {
                        break;
                    }
                    String strReplace = line.trim().replace("\t", "").trim().replace(" ", "");
                    if (strReplace.contains(x.b("010Yebci=cbeWcifkchcbLj"))) {
                        strSubstring = strReplace.substring(10);
                    }
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    try {
                        FlyLog.getInstance().d(th);
                        C0396r.a(randomAccessFile);
                    } catch (Throwable th2) {
                        C0396r.a(randomAccessFile);
                        throw th2;
                    }
                }
            }
            C0396r.a(randomAccessFile2);
        } catch (Throwable th3) {
            th = th3;
            strSubstring = "0";
        }
        if (TextUtils.isEmpty(strSubstring) || TextUtils.equals("0", strSubstring)) {
            return false;
        }
        return h(strSubstring);
    }

    public ArrayList<HashMap<String, Object>> av() {
        List<CellInfo> allCellInfo;
        Object systemServiceSafe;
        int oSVersionIntForFly = DH.SyncMtd.getOSVersionIntForFly();
        if (oSVersionIntForFly >= 17 && cn.fly.commons.e.h()) {
            if (CSCenter.getInstance().isCellLocationDataEnable()) {
                FlyLog.getInstance().d("gtci: direct", new Object[0]);
                allCellInfo = (((oSVersionIntForFly >= 29 || !DH.SyncMtd.checkPermission(x.b("041cdMcbcicjchcbckEie9cicechehehchcjWdYckecdcdcfhdkdkcgdcfgecfidkfhcgedfgdcecebddfgdf"))) && (oSVersionIntForFly < 29 || !DH.SyncMtd.checkPermission(x.b("039cd>cbcicjchcbckIie?cicechehehchcjOd'ckecdcdcfhdkdkcgfbdddffhcgedfgdcecebddfgdf")))) || (systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(x.b("005igRcjHde"))) == null) ? null : (List) ReflectHelper.invokeInstanceMethodNoThrow(systemServiceSafe, "getAllCellInfo", null, new Object[0]);
            } else {
                FlyLog.getInstance().d("gtci: mcc", new Object[0]);
                allCellInfo = CSCenter.getInstance().getAllCellInfo();
            }
            if (allCellInfo != null && !allCellInfo.isEmpty()) {
                ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
                for (CellInfo cellInfo : allCellInfo) {
                    if (cn.fly.tools.utils.a.C0033a.a(cellInfo)) {
                        arrayList.add(a(cellInfo));
                    }
                }
                if (arrayList.isEmpty()) {
                    arrayList.add(a(allCellInfo.get(0)));
                }
                return arrayList;
            }
        }
        return null;
    }

    public boolean aw() {
        return aH() || au();
    }

    public boolean ax() {
        return false;
    }

    public String ay() {
        return TextUtils.join(",", Build.SUPPORTED_ABIS);
    }

    public String b() {
        String str = Build.MODEL;
        return !TextUtils.isEmpty(str) ? str.trim() : str;
    }

    public String c() {
        return Build.MANUFACTURER;
    }

    public String d() {
        try {
            String str = c.a(this.f1684a).d().n() + "|" + DH.SyncMtd.getOSVersionIntForFly() + "|" + DH.SyncMtd.getManufacturerForFly() + "|" + l() + "|" + k();
            String strB = b(false);
            if (strB == null) {
                strB = "";
            } else if (strB.length() > 16) {
                strB = strB.substring(0, 16);
            }
            return Data.Base64AES(str, strB);
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return "";
        }
    }

    public String e() {
        return c.a(this.f1684a).d().m() + "|" + DH.SyncMtd.getOSVersionIntForFly() + "|" + DH.SyncMtd.getManufacturerForFly() + "|" + l() + "|" + k();
    }

    public int f() {
        return Build.VERSION.SDK_INT;
    }

    public String g() {
        return Build.VERSION.RELEASE;
    }

    public String h() {
        return Locale.getDefault().getLanguage();
    }

    public String i() {
        return this.f1684a.getResources().getConfiguration().locale.getLanguage();
    }

    public String j() {
        return Locale.getDefault().getCountry();
    }

    public String k() {
        int[] screenSize = ResHelper.getScreenSize(this.f1684a);
        if (this.f1684a.getResources().getConfiguration().orientation == 1) {
            return screenSize[0] + "x" + screenSize[1];
        }
        return screenSize[1] + "x" + screenSize[0];
    }

    public String l() {
        Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(x.b("005ig<cjZde"));
        if (systemServiceSafe == null) {
            return StructuredDataId.RESERVED;
        }
        String simOperator = CSCenter.getInstance().isPhoneStateDataEnable() ? (String) ReflectHelper.invokeInstanceMethodNoThrow(systemServiceSafe, x.b("014$diEeh:dkchcefg0ieSci@chGcjci"), null, new Object[0]) : CSCenter.getInstance().getSimOperator();
        return TextUtils.isEmpty(simOperator) ? StructuredDataId.RESERVED : simOperator;
    }

    public String m() {
        Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(x.b("005ig1cj$de"));
        if (systemServiceSafe == null) {
            return null;
        }
        String simOperatorName = CSCenter.getInstance().isPhoneStateDataEnable() ? (String) ReflectHelper.invokeInstanceMethodNoThrow(systemServiceSafe, x.b("0189di_eh%dkchcefg?ie@ci:ch2cjcidf-c%ceBe"), null, new Object[0]) : CSCenter.getInstance().getSimOperatorName();
        if (TextUtils.isEmpty(simOperatorName)) {
            return null;
        }
        return simOperatorName;
    }

    public String n() {
        return this.f1684a.getPackageName();
    }

    public String o() {
        try {
            ApplicationInfo applicationInfoAr = c.a(this.f1684a).d().ar();
            String packageName = DH.SyncMtd.getPackageName();
            String strB = cn.fly.tools.c.b(applicationInfoAr, packageName);
            if (strB != null) {
                if (DH.SyncMtd.getOSVersionIntForFly() < 25 || strB.endsWith(".*")) {
                    return strB;
                }
                ReflectHelper.importClassNoThrow(strB, null);
            }
            int iC = cn.fly.tools.c.c(applicationInfoAr, packageName);
            return iC > 0 ? this.f1684a.getString(iC) : String.valueOf(cn.fly.tools.c.d(applicationInfoAr, packageName));
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return "";
        }
    }

    public int p() {
        try {
            int iIntValue = ((Integer) FlyMeta.get(null, x.b("011OccGe:ciehchcj?dEdccjcbOe"), Integer.class, 0)).intValue();
            if (iIntValue > 0) {
                return iIntValue;
            }
            Object objB = c.a(this.f1684a).d().b(false, 0, n(), 0);
            return DH.SyncMtd.getOSVersionIntForFly() >= 28 ? (int) cn.fly.tools.c.g(objB, DH.SyncMtd.getPackageName()) : cn.fly.tools.c.f(objB, DH.SyncMtd.getPackageName());
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return 0;
        }
    }

    public String q() {
        try {
            String str = (String) FlyMeta.get(null, x.b("011HccFe2ciehchcj1dPdf:c4ceQe"), String.class, null);
            return !TextUtils.isEmpty(str) ? str : cn.fly.tools.c.c(c.a(this.f1684a).d().b(false, 0, n(), 0), DH.SyncMtd.getPackageName());
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return "1.0";
        }
    }

    public Set<String> r() {
        if (DH.SyncMtd.getOSVersionIntForFly() <= 25) {
            return aE();
        }
        Set<String> setA = null;
        try {
            ArrayList arrayList = (ArrayList) cn.fly.commons.c.a(x.b("004cf[cj$f"), (Object) null);
            if (arrayList == null || arrayList.size() == 0) {
                arrayList = new ArrayList(Arrays.asList("1", ExifInterface.GPS_MEASUREMENT_2D));
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                int i6 = Integer.parseInt(String.valueOf(arrayList.get(i5)));
                if (i6 == 1) {
                    setA = l.a(this.f1684a, 1);
                } else if (i6 == 2) {
                    setA = aF();
                } else if (i6 == 3) {
                    setA = aE();
                } else if (i6 == 4) {
                    setA = l.a(this.f1684a, 4);
                } else if (i6 == 5) {
                    setA = aG();
                }
                if (setA != null && !setA.isEmpty() && setA.size() > 1) {
                    return setA;
                }
            }
            return setA;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return setA;
        }
    }

    public String s() {
        return (DH.SyncMtd.getOSVersionIntForFly() < 29 || c.a(this.f1684a).d().ar().targetSdkVersion < 29 || !"mounted".equals(Environment.getExternalStorageState())) ? this.f1684a.getFilesDir().getAbsolutePath() : this.f1684a.getExternalFilesDir(null).getAbsolutePath();
    }

    public String t() {
        return null;
    }

    public ArrayList<HashMap<String, Object>> u() {
        List list;
        if (!cn.fly.commons.e.h()) {
            return null;
        }
        try {
            if (!d(x.b("041cd*cbcicjchcbckEieBcicechehehchcj$d8ckecdcdcfhdkdkcgdcfgecfidkfhcgedfgdcecebddfgdf")) || O()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (CSCenter.getInstance().isCellLocationDataEnable()) {
                Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(x.b("005ig cjPde"));
                if (systemServiceSafe != null) {
                    list = arrayList;
                    list = (List) ReflectHelper.invokeInstanceMethod(systemServiceSafe, x.b("022]di[ehFdfGeTchdiEgOeecjcich%d)didcIeff>ddDd]decj"), new Object[0]);
                }
            } else {
                List<NeighboringCellInfo> neighboringCellInfo = CSCenter.getInstance().getNeighboringCellInfo();
                if (neighboringCellInfo != null && !neighboringCellInfo.isEmpty()) {
                    list = arrayList;
                    list = arrayList;
                    arrayList.addAll(neighboringCellInfo);
                    list = arrayList;
                }
            }
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList<HashMap<String, Object>> arrayList2 = new ArrayList<>();
            for (Object obj : list) {
                Integer num = (Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(obj, x.b("006JdiPeh5dcchcb"), new Object[0]), -1);
                int iIntValue = num.intValue();
                Integer num2 = (Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(obj, x.b("006TdiWeh-edNcb"), new Object[0]), -1);
                int iIntValue2 = num2.intValue();
                Integer num3 = (Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(obj, x.b("0075diNehCfiehehch"), new Object[0]), -1);
                num3.intValue();
                Integer num4 = (Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(obj, x.b("006Idi[ehFfkehAb"), new Object[0]), -1);
                num4.intValue();
                Integer num5 = (Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(obj, x.b("014Ddi8ehMdfDehDefcjcidgebdb8ie"), new Object[0]), -1);
                num5.intValue();
                if (iIntValue != -1 && iIntValue2 != -1) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put(x.b("004beff"), num);
                    map.put(x.b("003fcb"), num2);
                    map.put(x.b("004Zciehehch"), num3);
                    map.put(x.b("003i!ehWb"), num4);
                    map.put(x.b("011deh]efcjcidgebdb[ie"), num5);
                    arrayList2.add(map);
                }
            }
            if (arrayList2.size() > 0) {
                return arrayList2;
            }
            return null;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return null;
        }
    }

    public String v() {
        String strB = x.b("009Idjdfekfhfbdddffhek");
        UiModeManager uiModeManager = (UiModeManager) DH.SyncMtd.getSystemServiceSafe("uimode");
        if (uiModeManager == null) {
            return strB;
        }
        switch (uiModeManager.getCurrentModeType()) {
            case 1:
                return x.b("005Ldffgcgdjdd");
            case 2:
                return x.b("004_ekfhdkhb");
            case 3:
                return x.b("003Cdcecfi");
            case 4:
                return x.b("010Debfhedfhfjdddkddfgdf");
            case 5:
                return x.b("0095ecfkfkedddecdfdcfh");
            case 6:
                return x.b("0057feecebdcej");
            case 7:
                return x.b("0097fjfiejfhecekdkfheb");
            default:
                return x.b("009Udjdfekfhfbdddffhek");
        }
    }

    public HashMap<String, Object> x() {
        Object connectionInfo;
        if (cn.fly.commons.e.c()) {
            try {
                if (d(x.b("036cd8cbcicjchcbck'ie<cicechehehchcjSdZckecdcdcfhdkdkcgfeddfbddcgdkebecebfh"))) {
                    if (CSCenter.getInstance().isWifiDataEnable()) {
                        Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(x.b("004Nefchdech"));
                        connectionInfo = systemServiceSafe != null ? ReflectHelper.invokeInstanceMethod(systemServiceSafe, x.b("017_di$eh9dccj<ddebhQchcj3d4ddMdXdecj"), new Object[0]) : null;
                    } else {
                        connectionInfo = CSCenter.getInstance().getConnectionInfo();
                    }
                    if (connectionInfo != null) {
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("bsmt", (String) ReflectHelper.invokeInstanceMethodNoThrow(connectionInfo, x.b("008@di(eh>eidkdkddek"), null, new Object[0]));
                        String str = (String) ReflectHelper.invokeInstanceMethodNoThrow(connectionInfo, x.b("007?di3eh0dkdkddek"), null, new Object[0]);
                        map.put("ssmt", str == null ? null : str.replace("\"", ""));
                        try {
                            Boolean bool = (Boolean) ReflectHelper.invokeInstanceMethod(connectionInfo, x.b("013*diHehEejchcbcb$ed0dkdkddek"), new Object[0]);
                            bool.booleanValue();
                            map.put(x.b("006gWchcbcb]ed"), bool);
                        } catch (Throwable unused) {
                        }
                        try {
                            Integer num = (Integer) ReflectHelper.invokeInstanceMethod(connectionInfo, x.b("012!di.eh3edch<dIdgdk:iee3cb"), new Object[0]);
                            num.intValue();
                            map.put("spmt", num);
                        } catch (Throwable unused2) {
                        }
                        try {
                            Integer num2 = (Integer) ReflectHelper.invokeInstanceMethod(connectionInfo, x.b("012:diSeh?df'eh@efcjcidgddcb"), new Object[0]);
                            num2.intValue();
                            map.put(x.b("009deh0efcjcidgddcb"), num2);
                        } catch (Throwable unused3) {
                        }
                        try {
                            Integer num3 = (Integer) ReflectHelper.invokeInstanceMethod(connectionInfo, x.b("007@di4eh7fiehehch"), new Object[0]);
                            num3.intValue();
                            map.put(x.b("005feUccZef"), num3);
                        } catch (Throwable unused4) {
                        }
                        try {
                            Integer num4 = (Integer) ReflectHelper.invokeInstanceMethod(connectionInfo, x.b("012Vdi)eh?fbci<e cdcfHedb:db"), new Object[0]);
                            num4.intValue();
                            map.put(x.b("0095deciPe cdcfLedbQdb"), num4);
                        } catch (Throwable unused5) {
                        }
                        return map;
                    }
                }
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
            }
        }
        return null;
    }

    public ArrayList<HashMap<String, Object>> y() {
        List list;
        String[] strArrSplit;
        String[] strArrSplit2;
        if (cn.fly.commons.e.d()) {
            try {
                if (d(x.b("036cd)cbcicjchcbck]ieXcicechehehchcj^dNckecdcdcfhdkdkcgfeddfbddcgdkebecebfh"))) {
                    if (CSCenter.getInstance().isWifiDataEnable()) {
                        Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(x.b("004%efchdech"));
                        if (systemServiceSafe == null) {
                            return null;
                        }
                        list = (List) ReflectHelper.invokeInstanceMethod(systemServiceSafe, x.b("014Tdi_ehCdk5bcd^fi'e$ehcfIfh[eh"), new Object[0]);
                    } else {
                        List<ScanResult> wifiScanResults = CSCenter.getInstance().getWifiScanResults();
                        if (wifiScanResults != null) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(wifiScanResults);
                            list = arrayList;
                        } else {
                            list = null;
                        }
                    }
                    if (list == null) {
                        return null;
                    }
                    if (DH.SyncMtd.getOSVersionIntForFly() > 27) {
                        strArrSplit = x.b("086<dkdkddekigeidkdkddekigKbcic5eech4f3ch6h%ch1eFehig_feIcc(ef2igdeciJe:cdcf3edb7dbigGbgcddefIfechcb7hgIig2bedheCcifbci@e8cdegigKbedheOcifbci<eLcdgeig5hYchce9e:ehWhcPce?i").split(",");
                        strArrSplit2 = x.b("031?ccIed3cfDeBdf'c!ce$e[ighecjPieGci!chXcjcifbcichDedFcbBf-dbdfZcXce,e").split(",");
                    } else {
                        strArrSplit = "SSID,BSSID,hessid,anqpDomainId,capabilities,level,frequency,channelWidth,centerFreq0,centerFreq1,timestamp,seen,isAutoJoinCandidate,numIpConfigFailures,blackListTimestamp,untrusted,numConnection,numUsage,distanceCm,distanceSdCm,flags".split(",");
                        strArrSplit2 = x.b("0393efchdechdkehchcbigccIed:cfVe_dfTcVce,e,igcj*ieMci=chKcjcifbcichKed<cb%f6dbdf?c:ce-e").split(",");
                    }
                    ArrayList<HashMap<String, Object>> arrayList2 = new ArrayList<>();
                    for (Object obj : list) {
                        HashMap<String, Object> map = new HashMap<>();
                        String str = null;
                        for (String str2 : strArrSplit) {
                            String strTrim = str2.trim();
                            if (x.b("004)dkdkddek").equals(strTrim)) {
                                str = (String) ReflectHelper.getInstanceField(obj, strTrim, null);
                                if (TextUtils.isEmpty(str)) {
                                    break;
                                }
                                map.put(strTrim, str);
                            } else {
                                if (x.b("012bcic%eech%f1chKh6ch3e:eh").equals(strTrim)) {
                                    String str3 = (String) ReflectHelper.getInstanceField(obj, strTrim, null);
                                    if (str3 != null && str3.contains("[IBSS]")) {
                                        str = null;
                                        break;
                                    }
                                    map.put(strTrim, str3);
                                } else {
                                    map.put(strTrim, ReflectHelper.getInstanceField(obj, strTrim, null));
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(str)) {
                            for (String str4 : strArrSplit2) {
                                try {
                                    String strTrim2 = str4.trim();
                                    Object instanceField = ReflectHelper.getInstanceField(obj, strTrim2);
                                    map.put(strTrim2, instanceField == null ? null : instanceField.toString());
                                } catch (Throwable unused) {
                                }
                            }
                            try {
                                map.put(x.b("021LchehgceggdgegegbMbHfiebebfiAe]ehKiIcj2dWcb2eDci"), ReflectHelper.invokeInstanceMethod(obj, x.b("018Wchehgceggdgegece0bMfiJe]ehYiQcj]dEcb3eYci"), new Object[0]));
                            } catch (Throwable unused2) {
                            }
                            try {
                                if (DH.SyncMtd.getOSVersionIntForFly() < 28) {
                                    List list2 = (List) ReflectHelper.getInstanceField(obj, x.b("009cd6cd6iKedchNde(eh"));
                                    map.put(x.b("009cd-cd]iBedchEdeFeh"), list2 == null ? null : new ArrayList(list2));
                                }
                            } catch (Throwable unused3) {
                            }
                            arrayList2.add(map);
                        }
                    }
                    return arrayList2;
                }
            } catch (Throwable th) {
                FlyLog.getInstance().w(th);
            }
        }
        return null;
    }

    public boolean z() {
        Object systemServiceSafe;
        if (cn.fly.commons.e.d() && CSCenter.getInstance().isWifiDataEnable() && DH.SyncMtd.checkPermission(x.b("036cd2cbcicjchcbckYie@cicechehehchcj0dFckdcejecdfhcfhcgfeddfbddcgdkebecebfh")) && (systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(x.b("004Lefchdech"))) != null) {
            return ((Boolean) ReflectHelper.invokeInstanceMethodNoThrow(systemServiceSafe, x.b("009]ehGhcAci1h9dk6bcd"), Boolean.FALSE, new Object[0])).booleanValue();
        }
        return false;
    }

    private boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^[a-z0-9]+$");
    }

    private void g(String str) {
        FileOutputStream fileOutputStream;
        File cacheRootFile = ResHelper.getCacheRootFile(this.f1684a, x.b("003Hckcbdg"));
        if (cacheRootFile != null && cacheRootFile.exists()) {
            cacheRootFile.delete();
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(cacheRootFile);
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream);
                try {
                    objectOutputStream2.writeObject(str.toCharArray());
                    objectOutputStream2.flush();
                    C0396r.a(objectOutputStream2, fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    try {
                        FlyLog.getInstance().d(th);
                        C0396r.a(objectOutputStream, fileOutputStream);
                    } catch (Throwable th2) {
                        C0396r.a(objectOutputStream, fileOutputStream);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00ab A[Catch: all -> 0x00b4, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00b4, blocks: (B:30:0x0088, B:40:0x00ab), top: B:48:0x0009 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    private boolean h(String str) {
        Object objC;
        InputStream inputStream;
        ?? inputStreamReader;
        boolean z6;
        ?? r9;
        BufferedReader bufferedReader = null;
        try {
            try {
                objC = C0396r.c(x.b("002iAeh"));
                try {
                    inputStream = (InputStream) ReflectHelper.invokeInstanceMethod(objC, x.b("014FdiAehHdd8di*cf4h7dk2hBciYec0ce"), new Object[0]);
                    try {
                        inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                            try {
                                Pattern patternCompile = Pattern.compile("^\\s*(\\S+)\\s+(\\d+)\\s+(\\d+)\\s+\\S+\\s+\\S+\\s+\\S+\\s+(\\d+)\\s+(\\w)\\s+(.+)$");
                                z6 = true;
                                while (true) {
                                    try {
                                        String line = bufferedReader2.readLine();
                                        if (line == null) {
                                            break;
                                        }
                                        Matcher matcher = patternCompile.matcher(line);
                                        if (matcher.matches()) {
                                            String strGroup = matcher.group(2);
                                            String strGroup2 = matcher.group(3);
                                            String strGroup3 = matcher.group(6);
                                            String packageName = DH.SyncMtd.getPackageName();
                                            if ((TextUtils.equals(packageName, strGroup3) && (TextUtils.equals(strGroup, str) || TextUtils.equals(strGroup2, str))) || (strGroup3 != null && strGroup3.contains(packageName) && TextUtils.equals(str, strGroup))) {
                                                z6 = false;
                                            }
                                        }
                                    } catch (Throwable unused) {
                                        bufferedReader = bufferedReader2;
                                        r9 = inputStreamReader;
                                        C0396r.a((Closeable[]) new Closeable[]{bufferedReader, r9, inputStream});
                                        if (objC != null) {
                                            ReflectHelper.invokeInstanceMethod(objC, x.b("007RcbQe%ehSh4cicjdb"), new Object[0]);
                                        }
                                        return z6;
                                    }
                                }
                                C0396r.a((Closeable[]) new Closeable[]{bufferedReader2, inputStreamReader, inputStream});
                                if (objC != null) {
                                    ReflectHelper.invokeInstanceMethod(objC, x.b("007RcbQe%ehSh4cicjdb"), new Object[0]);
                                }
                            } catch (Throwable unused2) {
                                z6 = true;
                            }
                        } catch (Throwable unused3) {
                            z6 = true;
                            r9 = inputStreamReader;
                            C0396r.a((Closeable[]) new Closeable[]{bufferedReader, r9, inputStream});
                            if (objC != null) {
                                ReflectHelper.invokeInstanceMethod(objC, x.b("007RcbQe%ehSh4cicjdb"), new Object[0]);
                            }
                            return z6;
                        }
                    } catch (Throwable unused4) {
                        inputStreamReader = 0;
                    }
                } catch (Throwable unused5) {
                    inputStream = null;
                    inputStreamReader = inputStream;
                    z6 = true;
                    r9 = inputStreamReader;
                    C0396r.a((Closeable[]) new Closeable[]{bufferedReader, r9, inputStream});
                    if (objC != null) {
                        ReflectHelper.invokeInstanceMethod(objC, x.b("007RcbQe%ehSh4cicjdb"), new Object[0]);
                    }
                    return z6;
                }
            } catch (Throwable unused6) {
            }
        } catch (Throwable unused7) {
            objC = null;
            inputStream = null;
        }
        return z6;
    }

    public String c(String str) {
        ApplicationInfo applicationInfoA;
        CharSequence charSequenceG;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(str) || (applicationInfoA = c.a(this.f1684a).d().a(str, 1)) == null || (charSequenceG = cn.fly.tools.c.g(applicationInfoA, str)) == null) {
                return null;
            }
            return charSequenceG.toString();
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return null;
        }
    }

    public boolean e(String str) {
        return c.a(this.f1684a).d().a(true, str, 0) != null;
    }

    public synchronized boolean a() {
        String strD;
        strD = C0396r.d();
        return strD != null && strD.length() == 5 && (strD.charAt(3) == '1' || strD.charAt(4) == '1');
    }

    public String b(String str) {
        Object objA;
        Signature[] signatureArrB;
        try {
            if (str.equals(DH.SyncMtd.getPackageName())) {
                objA = c.a(this.f1684a).d().b(false, 0, str, 64);
            } else {
                objA = c.a(this.f1684a).d().a(false, 0, str, 64);
            }
            if (objA == null || (signatureArrB = cn.fly.tools.c.b(objA, str)) == null || signatureArrB.length <= 0) {
                return null;
            }
            return Data.MD5(signatureArrB[0].toByteArray());
        } catch (Exception e) {
            FlyLog.getInstance().w(e);
            return null;
        }
    }

    public String a(String str) {
        return e.a(this.f1684a).a(str);
    }

    public String a(boolean z6) {
        return NtFetcher.getInstance(this.f1684a).getNtType(z6);
    }

    public String a(int i5) {
        long jCurrentTimeMillis = System.currentTimeMillis() ^ SystemClock.elapsedRealtime();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(jCurrentTimeMillis);
        SecureRandom secureRandom = new SecureRandom();
        for (int i6 = 0; i6 < i5; i6++) {
            if (x.b("004bgcTci").equalsIgnoreCase(x.b(secureRandom.nextInt(2) % 2 == 0 ? "004bgc4ci" : "003d]cfce"))) {
                stringBuffer.insert(i6 + 1, (char) (secureRandom.nextInt(26) + 97));
            } else {
                stringBuffer.insert(stringBuffer.length(), secureRandom.nextInt(10));
            }
        }
        return stringBuffer.toString().substring(0, 40);
    }

    public ArrayList<HashMap<String, String>> c(boolean z6) {
        if (CSCenter.getInstance().isAppListDataEnable()) {
            ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
            Set<String> setK = c.a(this.f1684a).d().k(z6);
            return (setK == null || setK.isEmpty()) ? arrayList : a(setK);
        }
        List<PackageInfo> packageInfos = CSCenter.getInstance().getPackageInfos();
        if (packageInfos != null && !packageInfos.isEmpty()) {
            HashMap<String, Object> map = new HashMap<>();
            for (PackageInfo packageInfo : packageInfos) {
                map.put(packageInfo.packageName, packageInfo);
            }
            return a(map);
        }
        return new ArrayList<>();
    }

    public boolean d(String str) {
        int iCheckPermission;
        if (DH.SyncMtd.getOSVersionIntForFly() >= 23) {
            ReflectHelper.importClassNoThrow(x.b("023cd^cbcicjchcbck6bMcj7dhedhGckdccj$dhe$dh@h"), null);
            iCheckPermission = -1;
            Integer num = (Integer) ReflectHelper.invokeInstanceMethodNoThrow(this.f1684a, x.b("019bgeb!dgdk1efZdefk*e3cicechehehchcj]d"), -1, str);
            if (num != null) {
                iCheckPermission = num.intValue();
            }
        } else {
            iCheckPermission = this.f1684a.getPackageManager().checkPermission(str, n());
        }
        return iCheckPermission == 0;
    }

    public String b(boolean z6) {
        String strAA = aA();
        if (!z6 && (TextUtils.isEmpty(strAA) || strAA.length() < 40)) {
            strAA = az();
        }
        if (!TextUtils.isEmpty(strAA) && strAA.length() >= 40 && f(strAA)) {
            return strAA.trim();
        }
        String strAC = aC();
        if (!TextUtils.isEmpty(strAC) && strAC.length() >= 40 && f(strAC)) {
            return strAC.trim();
        }
        String strA = a(40);
        if (TextUtils.isEmpty(strA)) {
            return strA;
        }
        String strTrim = strA.trim();
        g(strTrim);
        return strTrim;
    }

    public ArrayList<HashMap<String, String>> a(ArrayList<HashMap<String, String>> arrayList, int i5) {
        try {
            int i6 = 0;
            FlyLog.getInstance().d("DH PD: fabt " + i5, new Object[0]);
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            ArrayList<HashMap<String, String>> arrayList2 = new ArrayList<>();
            int size = arrayList.size();
            while (i6 < size) {
                HashMap<String, String> map = arrayList.get(i6);
                i6++;
                HashMap<String, String> map2 = map;
                boolean zEquals = TextUtils.equals("1", map2.get(x.b("005Xchehehdbeh")));
                if (i5 != 1 || !zEquals) {
                    if (i5 != 2 || zEquals) {
                        HashMap<String, String> map3 = new HashMap<>(map2);
                        map3.remove(x.b("005*chehehdbeh"));
                        arrayList2.add(map3);
                    }
                }
            }
            return arrayList2;
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return null;
        }
    }

    private void b(HashMap<String, String> map) {
        if (map != null) {
            ResHelper.saveObjectToFile(ResHelper.getDataCacheFile(this.f1684a, x.b("004<ck=cd7eh")).getAbsolutePath(), map);
        }
    }

    private int b(Context context) {
        String strX = X();
        if (TextUtils.isEmpty(strX)) {
            return -1;
        }
        return strX.equals(cn.fly.tools.c.f(c.a(context).d().a(n(), 0), n())) ? 1 : 0;
    }

    private ArrayList<HashMap<String, String>> a(Set<String> set) {
        if (cn.fly.commons.e.b() && set != null && !set.isEmpty()) {
            HashMap<String, Object> map = new HashMap<>();
            for (String str : set) {
                map.put(str, c.a(this.f1684a).d().b(true, 0, str, 0));
            }
            if (!map.isEmpty()) {
                return a(map);
            }
        }
        return new ArrayList<>();
    }

    public ArrayList<HashMap<String, String>> a(HashMap<String, Object> map) {
        String string;
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        if (cn.fly.commons.e.b()) {
            try {
                PackageManager packageManager = this.f1684a.getPackageManager();
                HashMap<String, String> mapAD = aD();
                if (map != null && !map.isEmpty()) {
                    boolean z6 = false;
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value != null) {
                            HashMap<String, String> map2 = new HashMap<>();
                            ApplicationInfo applicationInfoA = cn.fly.tools.c.a(value, key);
                            if (applicationInfoA != null) {
                                if (a(applicationInfoA)) {
                                    map2.put(x.b("0051chehehdbeh"), "1");
                                } else {
                                    map2.put(x.b("005?chehehdbeh"), "0");
                                }
                                map2.put(x.b("003iNdgdi"), key);
                                CharSequence text = null;
                                if (mapAD != null) {
                                    string = mapAD.get(Data.MD5(key));
                                } else {
                                    mapAD = new HashMap<>();
                                    string = null;
                                }
                                if (TextUtils.isEmpty(string)) {
                                    try {
                                        try {
                                            text = cn.fly.tools.c.g(applicationInfoA, key);
                                        } catch (Throwable unused) {
                                            int iC = cn.fly.tools.c.c(applicationInfoA, key);
                                            if (iC > 0) {
                                                text = packageManager.getText(key, iC, applicationInfoA);
                                            }
                                        }
                                    } catch (Throwable unused2) {
                                    }
                                    string = text == null ? key : text.toString();
                                    mapAD.put(Data.MD5(key), string);
                                    z6 = true;
                                }
                                map2.put(x.b("004dc8ce8e"), string);
                                map2.put(x.b("0076ccZe$ciehchcjKd"), cn.fly.tools.c.c(value, key));
                                map2.put(x.b("006edc_ee.fe"), cn.fly.tools.c.e(applicationInfoA, key) ? "1" : "0");
                                map2.put(x.b("016FdechciehIh5dd?d;eh9hcff.ebchceHe"), String.valueOf(cn.fly.tools.c.d(value, key)));
                                map2.put(x.b("014fc5ehFhKdj9i^cbYche(ebchceSe"), String.valueOf(cn.fly.tools.c.e(value, key)));
                                arrayList.add(map2);
                            }
                        }
                    }
                    if (z6) {
                        b(mapAD);
                    }
                }
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
            }
        }
        return arrayList;
    }

    private boolean a(ApplicationInfo applicationInfo) {
        int i5 = applicationInfo.flags;
        return ((i5 & 1) == 1) || ((i5 & 128) != 0);
    }

    public List a(int i5, int i6, boolean z6, boolean z7) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return cn.fly.tools.utils.e.a().a(this.f1684a, i5, i6, z6, z7);
        }
        FlyLog.getInstance().d("glctn can not be called from Main Thread", new Object[0]);
        return null;
    }

    public void a(final BlockingQueue<Boolean> blockingQueue) {
        if (cn.fly.commons.e.d() && CSCenter.getInstance().isWifiDataEnable()) {
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: cn.fly.tools.b.b.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    try {
                        C0396r.a(this);
                        if (x.b("029cd1cbcicjchcbck8deh_ckefchdechckdkdcecdfcgfifhdkdjedebdk").equals(intent.getAction())) {
                            blockingQueue.put(Boolean.TRUE);
                        }
                    } catch (Throwable th) {
                        FlyLog.getInstance().d(th);
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(x.b("029cdScbcicjchcbck<deh<ckefchdechckdkdcecdfcgfifhdkdjedebdk"));
            C0396r.a(broadcastReceiver, intentFilter);
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x0148  */
    /* JADX WARN: Code duplicated, block: B:56:0x0151  */
    private HashMap<String, Object> a(Object obj) {
        String str;
        String strV;
        String strW;
        int iR;
        int iT;
        String strValueOf;
        long jQ;
        int i5;
        int i6;
        int i7;
        int iY;
        int i8;
        int i9;
        int iP;
        int i10;
        int i11;
        String strK;
        int iJ;
        long jK;
        int iL;
        int i12;
        int iA;
        int oSVersionIntForFly = DH.SyncMtd.getOSVersionIntForFly();
        Object objG = cn.fly.tools.utils.a.C0033a.g(obj);
        HashMap<String, Object> map = new HashMap<>();
        if (cn.fly.tools.utils.a.C0033a.b(obj)) {
            strValueOf = String.valueOf(cn.fly.tools.utils.a.C0033a.h(objG));
            int i13 = cn.fly.tools.utils.a.C0033a.i(objG);
            strK = i13 < 10 ? AbstractC0157z.k(i13, "0") : AbstractC0157z.k(i13, "");
            iJ = cn.fly.tools.utils.a.C0033a.j(objG);
            jK = cn.fly.tools.utils.a.C0033a.k(objG);
            iL = cn.fly.tools.utils.a.C0033a.l(objG);
            i12 = 1;
        } else {
            str = null;
            if (cn.fly.tools.utils.a.C0033a.c(obj)) {
                int iM = cn.fly.tools.utils.a.C0033a.m(objG);
                int iN = cn.fly.tools.utils.a.C0033a.n(objG);
                int iO = cn.fly.tools.utils.a.C0033a.o(objG);
                i10 = 2;
                iP = cn.fly.tools.utils.a.C0033a.p(objG);
                jQ = cn.fly.tools.utils.a.C0033a.q(objG);
                i5 = -1;
                i6 = -1;
                i7 = iM;
                i8 = iN;
                i9 = iO;
                strValueOf = null;
                iY = -1;
            } else {
                if (cn.fly.tools.utils.a.C0033a.d(obj)) {
                    strValueOf = String.valueOf(cn.fly.tools.utils.a.C0033a.h(objG));
                    int i14 = cn.fly.tools.utils.a.C0033a.i(objG);
                    strK = i14 < 10 ? AbstractC0157z.k(i14, "0") : AbstractC0157z.k(i14, "");
                    iJ = cn.fly.tools.utils.a.C0033a.j(objG);
                    jK = cn.fly.tools.utils.a.C0033a.k(objG);
                    iL = cn.fly.tools.utils.a.C0033a.l(objG);
                    i12 = 3;
                } else if (cn.fly.tools.utils.a.C0033a.e(obj)) {
                    String strValueOf2 = String.valueOf(cn.fly.tools.utils.a.C0033a.h(objG));
                    int i15 = cn.fly.tools.utils.a.C0033a.i(objG);
                    String strK2 = i15 < 10 ? AbstractC0157z.k(i15, "0") : AbstractC0157z.k(i15, "");
                    int iR2 = cn.fly.tools.utils.a.C0033a.r(objG);
                    long jS = cn.fly.tools.utils.a.C0033a.s(objG);
                    int iT2 = cn.fly.tools.utils.a.C0033a.t(objG);
                    iY = oSVersionIntForFly >= 24 ? cn.fly.tools.utils.a.C0033a.u(objG) : -1;
                    strValueOf = strValueOf2;
                    i10 = 4;
                    i6 = iT2;
                    jQ = jS;
                    i7 = -1;
                    i9 = -1;
                    iP = -1;
                    str = strK2;
                    i5 = iR2;
                    i11 = -1;
                    i8 = -1;
                } else {
                    long jX = -1;
                    if (cn.fly.tools.utils.a.C0033a.f(obj)) {
                        try {
                            strV = cn.fly.tools.utils.a.C0033a.v(objG);
                            try {
                                strW = cn.fly.tools.utils.a.C0033a.w(objG);
                                try {
                                    iR = cn.fly.tools.utils.a.C0033a.r(objG);
                                    try {
                                        jX = cn.fly.tools.utils.a.C0033a.x(objG);
                                        iT = cn.fly.tools.utils.a.C0033a.t(objG);
                                        try {
                                            iY = cn.fly.tools.utils.a.C0033a.y(objG);
                                            strValueOf = strV;
                                            i10 = 5;
                                            jQ = jX;
                                            i5 = iR;
                                            i6 = iT;
                                            i7 = -1;
                                            i8 = -1;
                                            i9 = -1;
                                            iP = -1;
                                        } catch (Throwable th) {
                                            th = th;
                                            FlyLog.getInstance().d(th);
                                            strValueOf = strV;
                                            jQ = jX;
                                            i5 = iR;
                                            i6 = iT;
                                            i7 = -1;
                                            iY = -1;
                                            i8 = -1;
                                            i9 = -1;
                                            iP = -1;
                                            i10 = -1;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        iT = -1;
                                        FlyLog.getInstance().d(th);
                                        strValueOf = strV;
                                        jQ = jX;
                                        i5 = iR;
                                        i6 = iT;
                                        i7 = -1;
                                        iY = -1;
                                        i8 = -1;
                                        i9 = -1;
                                        iP = -1;
                                        i10 = -1;
                                        str = strW;
                                        i11 = -1;
                                        if (DH.SyncMtd.getOSVersionIntForFly() >= 30) {
                                            iA = cn.fly.tools.utils.a.C0033a.A(cn.fly.tools.utils.a.C0033a.z(obj));
                                        } else {
                                            iA = -1;
                                        }
                                        map.put(x.b("003fcb"), Integer.valueOf(i5));
                                        map.put(x.b("004beff"), Long.valueOf(jQ));
                                        map.put(x.b("003i9eh_b"), Integer.valueOf(i11));
                                        map.put(x.b("003Cehchcb"), Integer.valueOf(i7));
                                        map.put(x.b("003d5chcb"), Integer.valueOf(i8));
                                        map.put(x.b("003fch"), Integer.valueOf(i9));
                                        map.put(x.b("003fZcj^d"), Integer.valueOf(iP));
                                        map.put("mcc", strValueOf);
                                        map.put("mnc", str);
                                        map.put(x.b("004h0dbMie"), Integer.valueOf(i10));
                                        map.put("pci", Integer.valueOf(i6));
                                        map.put("xarfcn", Integer.valueOf(iY));
                                        map.put("dbm", Integer.valueOf(iA));
                                        return map;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    iR = -1;
                                    iT = -1;
                                    FlyLog.getInstance().d(th);
                                    strValueOf = strV;
                                    jQ = jX;
                                    i5 = iR;
                                    i6 = iT;
                                    i7 = -1;
                                    iY = -1;
                                    i8 = -1;
                                    i9 = -1;
                                    iP = -1;
                                    i10 = -1;
                                    str = strW;
                                    i11 = -1;
                                    if (DH.SyncMtd.getOSVersionIntForFly() >= 30) {
                                        iA = cn.fly.tools.utils.a.C0033a.A(cn.fly.tools.utils.a.C0033a.z(obj));
                                    } else {
                                        iA = -1;
                                    }
                                    map.put(x.b("003fcb"), Integer.valueOf(i5));
                                    map.put(x.b("004beff"), Long.valueOf(jQ));
                                    map.put(x.b("003i9eh_b"), Integer.valueOf(i11));
                                    map.put(x.b("003Cehchcb"), Integer.valueOf(i7));
                                    map.put(x.b("003d5chcb"), Integer.valueOf(i8));
                                    map.put(x.b("003fch"), Integer.valueOf(i9));
                                    map.put(x.b("003fZcj^d"), Integer.valueOf(iP));
                                    map.put("mcc", strValueOf);
                                    map.put("mnc", str);
                                    map.put(x.b("004h0dbMie"), Integer.valueOf(i10));
                                    map.put("pci", Integer.valueOf(i6));
                                    map.put("xarfcn", Integer.valueOf(iY));
                                    map.put("dbm", Integer.valueOf(iA));
                                    return map;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                strW = null;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            strV = null;
                            strW = null;
                        }
                        str = strW;
                    } else {
                        jQ = -1;
                        strValueOf = null;
                        i7 = -1;
                        iY = -1;
                        i11 = -1;
                        i8 = -1;
                        i5 = -1;
                        i9 = -1;
                        iP = -1;
                        i6 = -1;
                        i10 = -1;
                    }
                }
                if (DH.SyncMtd.getOSVersionIntForFly() >= 30) {
                    iA = cn.fly.tools.utils.a.C0033a.A(cn.fly.tools.utils.a.C0033a.z(obj));
                } else {
                    iA = -1;
                }
                map.put(x.b("003fcb"), Integer.valueOf(i5));
                map.put(x.b("004beff"), Long.valueOf(jQ));
                map.put(x.b("003i9eh_b"), Integer.valueOf(i11));
                map.put(x.b("003Cehchcb"), Integer.valueOf(i7));
                map.put(x.b("003d5chcb"), Integer.valueOf(i8));
                map.put(x.b("003fch"), Integer.valueOf(i9));
                map.put(x.b("003fZcj^d"), Integer.valueOf(iP));
                map.put("mcc", strValueOf);
                map.put("mnc", str);
                map.put(x.b("004h0dbMie"), Integer.valueOf(i10));
                map.put("pci", Integer.valueOf(i6));
                map.put("xarfcn", Integer.valueOf(iY));
                map.put("dbm", Integer.valueOf(iA));
                return map;
            }
            i11 = -1;
            if (DH.SyncMtd.getOSVersionIntForFly() >= 30) {
                iA = cn.fly.tools.utils.a.C0033a.A(cn.fly.tools.utils.a.C0033a.z(obj));
            } else {
                iA = -1;
            }
            map.put(x.b("003fcb"), Integer.valueOf(i5));
            map.put(x.b("004beff"), Long.valueOf(jQ));
            map.put(x.b("003i9eh_b"), Integer.valueOf(i11));
            map.put(x.b("003Cehchcb"), Integer.valueOf(i7));
            map.put(x.b("003d5chcb"), Integer.valueOf(i8));
            map.put(x.b("003fch"), Integer.valueOf(i9));
            map.put(x.b("003fZcj^d"), Integer.valueOf(iP));
            map.put("mcc", strValueOf);
            map.put("mnc", str);
            map.put(x.b("004h0dbMie"), Integer.valueOf(i10));
            map.put("pci", Integer.valueOf(i6));
            map.put("xarfcn", Integer.valueOf(iY));
            map.put("dbm", Integer.valueOf(iA));
            return map;
        }
        jQ = jK;
        i10 = i12;
        i8 = -1;
        i9 = -1;
        iP = -1;
        i6 = -1;
        str = strK;
        i5 = iJ;
        iY = -1;
        i11 = iL;
        i7 = -1;
        if (DH.SyncMtd.getOSVersionIntForFly() >= 30) {
            iA = cn.fly.tools.utils.a.C0033a.A(cn.fly.tools.utils.a.C0033a.z(obj));
        } else {
            iA = -1;
        }
        map.put(x.b("003fcb"), Integer.valueOf(i5));
        map.put(x.b("004beff"), Long.valueOf(jQ));
        map.put(x.b("003i9eh_b"), Integer.valueOf(i11));
        map.put(x.b("003Cehchcb"), Integer.valueOf(i7));
        map.put(x.b("003d5chcb"), Integer.valueOf(i8));
        map.put(x.b("003fch"), Integer.valueOf(i9));
        map.put(x.b("003fZcj^d"), Integer.valueOf(iP));
        map.put("mcc", strValueOf);
        map.put("mnc", str);
        map.put(x.b("004h0dbMie"), Integer.valueOf(i10));
        map.put("pci", Integer.valueOf(i6));
        map.put("xarfcn", Integer.valueOf(iY));
        map.put("dbm", Integer.valueOf(iA));
        return map;
    }
}
