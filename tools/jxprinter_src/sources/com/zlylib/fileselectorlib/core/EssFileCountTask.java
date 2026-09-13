package com.zlylib.fileselectorlib.core;

import android.os.AsyncTask;
import com.zlylib.fileselectorlib.bean.EssFile;
import com.zlylib.fileselectorlib.bean.EssFileCountCallBack;
import com.zlylib.fileselectorlib.bean.EssFileFilter;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class EssFileCountTask extends AsyncTask<Void, Void, Void> {
    private int childFileCount = 0;
    private int childFolderCount = 0;
    private EssFileCountCallBack countCallBack;
    private Boolean isSelectFolder;
    private int position;
    private String queryPath;
    private String[] types;

    public EssFileCountTask(int i5, String str, String[] strArr, Boolean bool, EssFileCountCallBack essFileCountCallBack) {
        this.position = i5;
        this.queryPath = str;
        this.types = strArr;
        this.isSelectFolder = bool;
        this.countCallBack = essFileCountCallBack;
    }

    @Override // android.os.AsyncTask
    public Void doInBackground(Void... voidArr) {
        File[] fileArrListFiles = new File(this.queryPath).listFiles(new EssFileFilter(this.types));
        if (fileArrListFiles == null) {
            return null;
        }
        Iterator<EssFile> it = EssFile.getEssFileList((List<File>) Arrays.asList(fileArrListFiles), this.isSelectFolder.booleanValue()).iterator();
        while (it.hasNext()) {
            if (it.next().isDirectory()) {
                this.childFolderCount++;
            } else {
                this.childFileCount++;
            }
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Void r6) {
        EssFileCountCallBack essFileCountCallBack = this.countCallBack;
        if (essFileCountCallBack != null) {
            essFileCountCallBack.onFindChildFileAndFolderCount(this.position, String.valueOf(this.childFileCount), String.valueOf(this.childFolderCount));
        }
    }
}
