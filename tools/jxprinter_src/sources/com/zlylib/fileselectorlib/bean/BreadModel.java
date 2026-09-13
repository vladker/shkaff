package com.zlylib.fileselectorlib.bean;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class BreadModel {
    private String mCurName;
    private String mCurPath;
    private int mPrePosition = 0;

    public static List<BreadModel> getNewBreadModel(List<BreadModel> list, List<BreadModel> list2) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list2 != null && list.size() < list2.size()) {
            for (int i5 = 0; i5 < list2.size(); i5++) {
                if (i5 >= list.size()) {
                    arrayList.add(list2.get(i5));
                }
            }
        }
        return arrayList;
    }

    public static int getRemovedBreadModel(List<BreadModel> list, List<BreadModel> list2) {
        if (list != null && list2 != null && list.size() > list2.size()) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                if (i5 == list2.size()) {
                    return i5;
                }
            }
        }
        return 0;
    }

    public String getCurName() {
        return this.mCurName;
    }

    public String getCurPath() {
        return this.mCurPath;
    }

    public int getPrePosition() {
        return this.mPrePosition;
    }

    public void setCurName(String str) {
        this.mCurName = str;
    }

    public void setPrePosition(int i5) {
        this.mPrePosition = i5;
    }

    public void setmCurPath(String str) {
        this.mCurPath = str;
    }
}
