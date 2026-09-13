package p079o;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.a;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzer;
import com.google.android.gms.internal.play_billing.zzes;
import com.google.android.gms.internal.play_billing.zzim;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p024d5.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class J {
    public static String a(String str) {
        String str2 = "";
        if (str.endsWith("asc")) {
            str = str.replace("asc", "").trim();
            str2 = " asc";
        } else if (str.endsWith("desc")) {
            str = str.replace("desc", "").trim();
            str2 = " desc";
        }
        return b(str) + str2;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(",");
        sb.append(str.toLowerCase(Locale.US));
        sb.append(",");
        return ",abort,add,after,all,alter,and,as,asc,autoincrement,before,begin,between,by,cascade,check,collate,column,commit,conflict,constraint,create,cross,database,deferrable,deferred,delete,desc,distinct,drop,each,end,escape,except,exclusive,exists,foreign,from,glob,group,having,in,index,inner,insert,intersect,into,is,isnull,join,like,limit,match,natural,not,notnull,null,of,offset,on,or,order,outer,plan,pragma,primary,query,raise,references,regexp,reindex,release,rename,replace,restrict,right,rollback,row,savepoint,select,set,table,temp,temporary,then,to,transaction,trigger,union,unique,update,using,vacuum,values,view,virtual,when,where,".contains(sb.toString()) ? a.n(str, "_lpcolumn") : str;
    }

    public static String c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                Matcher matcher = Pattern.compile("(\\w+\\s*(=|!=|<>|<|>)|\\w+\\s+(not\\s+)?(like|between)\\s+|\\w+\\s+(not\\s+)?(in)\\s*\\()").matcher(str);
                while (matcher.find()) {
                    String strGroup = matcher.group();
                    String strReplaceAll = strGroup.replaceAll("(\\s*(=|!=|<>|<|>)|\\s+(not\\s+)?(like|between)\\s+|\\s+(not\\s+)?(in)\\s*\\()", "");
                    String strReplace = strGroup.replace(strReplaceAll, "");
                    matcher.appendReplacement(stringBuffer, b(strReplaceAll) + strReplace);
                }
                matcher.appendTail(stringBuffer);
                return stringBuffer.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static ArrayList d(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("select * from sqlite_master where type = ?", new String[]{"table"});
                if (cursorRawQuery.moveToFirst()) {
                    do {
                        String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("tbl_name"));
                        if (!arrayList.contains(string)) {
                            arrayList.add(string);
                        }
                    } while (cursorRawQuery.moveToNext());
                }
                cursorRawQuery.close();
                return arrayList;
            } catch (Exception e) {
                e.printStackTrace();
                throw new b(e.getMessage());
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public static String f(String str, String str2) {
        return AbstractC1282k.a(k(str) + "_" + str2);
    }

    public static String g(String str) {
        return AbstractC1282k.a(k(str) + "_id");
    }

    public static String i(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Locale locale = Locale.US;
        return str.toLowerCase(locale).compareTo(str2.toLowerCase(locale)) <= 0 ? a.o(str, "_", str2) : a.o(str2, "_", str);
    }

    public static String j(Field field) {
        return AbstractC1282k.a(field.getName() + "_id");
    }

    public static String k(String str) {
        if (TextUtils.isEmpty(str) || '.' == str.charAt(str.length() - 1)) {
            return null;
        }
        return str.substring(str.lastIndexOf(Consts.DOT) + 1);
    }

    public static boolean l(String str, SQLiteDatabase sQLiteDatabase) {
        try {
            return AbstractC1282k.c(str, d(sQLiteDatabase));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Bundle m(zzes zzesVar, zzim zzimVar) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("REQUEST_METADATA", zzesVar.zzQ());
        bundle.putByteArray("REQUEST_PARAMS", zzimVar.zzQ());
        return bundle;
    }

    public static zzes n(Context context, String str) {
        String strValueOf;
        zzer zzerVarZza = zzes.zza();
        zzerVarZza.zzd("9.1.0");
        zzerVarZza.zze(24);
        zzerVarZza.zzb(context.getPackageName());
        zzerVarZza.zzc(str);
        try {
            strValueOf = String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            zzc.zzn("DelegationApiParamsBuilder", "No version code is found!");
            strValueOf = null;
        }
        if (strValueOf != null) {
            zzerVarZza.zza(strValueOf);
        }
        return (zzes) zzerVarZza.zzi();
    }
}
