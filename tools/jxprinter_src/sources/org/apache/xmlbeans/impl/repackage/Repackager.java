package org.apache.xmlbeans.impl.repackage;

import androidx.collection.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Repackager {
    private Matcher[] _fromMatchers;
    private String[] _toPackageNames;
    private final List<List<String>> _fromPackages = new ArrayList();
    private final List<List<String>> _toPackages = new ArrayList();

    public Repackager(String str) {
        boolean z6;
        List<String> listSplitPath = splitPath(str, ';');
        do {
            z6 = false;
            for (int i5 = 1; i5 < listSplitPath.size(); i5++) {
                int i6 = i5 - 1;
                String str2 = listSplitPath.get(i6);
                String str3 = listSplitPath.get(i5);
                if (str2.indexOf(58) < str3.indexOf(58)) {
                    listSplitPath.set(i6, str3);
                    listSplitPath.set(i5, str2);
                    z6 = true;
                }
            }
        } while (z6);
        for (String str4 : listSplitPath) {
            int iIndexOf = str4.indexOf(58);
            if (iIndexOf >= 0) {
                int i7 = iIndexOf + 1;
                if (str4.indexOf(58, i7) < 0) {
                    String strSubstring = str4.substring(0, iIndexOf);
                    String strSubstring2 = str4.substring(i7);
                    this._fromPackages.add(splitPath(strSubstring, '.'));
                    this._toPackages.add(splitPath(strSubstring2, '.'));
                }
            }
            throw new RuntimeException("Illegal repackage specification: ".concat(str4));
        }
        this._fromMatchers = new Matcher[this._fromPackages.size() * 2];
        this._toPackageNames = new String[this._fromPackages.size() * 2];
        addPatterns('.', 0);
        addPatterns('/', this._fromPackages.size());
    }

    public static String dirForPath(String str) {
        return new File(str).getParent();
    }

    public static List<String> splitPath(String str, char c) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            int iIndexOf = str.indexOf(c);
            if (iIndexOf < 0) {
                break;
            }
            arrayList.add(str.substring(0, iIndexOf));
            str = str.substring(iIndexOf + 1);
        }
        if (str.length() > 0) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public void addPatterns(char c, int i5) {
        for (int i6 = 0; i6 < this._fromPackages.size(); i6++) {
            List<String> list = this._fromPackages.get(i6);
            List<String> list2 = this._toPackages.get(i6);
            String string = "";
            for (int i7 = 0; i7 < list.size(); i7++) {
                if (i7 > 0) {
                    string = string + "\\" + c;
                }
                StringBuilder sbR = a.r(string);
                sbR.append(list.get(i7));
                string = sbR.toString();
            }
            String string2 = "";
            for (int i8 = 0; i8 < list2.size(); i8++) {
                if (i8 > 0) {
                    string2 = string2 + c;
                }
                StringBuilder sbR2 = a.r(string2);
                sbR2.append(list2.get(i8));
                string2 = sbR2.toString();
            }
            int i9 = i5 + i6;
            this._fromMatchers[i9] = Pattern.compile(string).matcher("");
            this._toPackageNames[i9] = string2;
        }
    }

    public List<List<String>> getFromPackages() {
        return this._fromPackages;
    }

    public List<List<String>> getToPackages() {
        return this._toPackages;
    }

    public StringBuffer repackage(StringBuffer stringBuffer) {
        int i5 = 0;
        StringBuffer stringBuffer2 = null;
        while (true) {
            Matcher[] matcherArr = this._fromMatchers;
            if (i5 >= matcherArr.length) {
                return stringBuffer;
            }
            Matcher matcher = matcherArr[i5];
            matcher.reset(stringBuffer);
            while (matcher.find()) {
                if (stringBuffer2 == null) {
                    stringBuffer2 = new StringBuffer();
                }
                matcher.appendReplacement(stringBuffer2, this._toPackageNames[i5]);
            }
            if (stringBuffer2 != null) {
                matcher.appendTail(stringBuffer2);
                stringBuffer = stringBuffer2;
                stringBuffer2 = null;
            }
            i5++;
        }
    }
}
