package com.zlylib.fileselectorlib.core;

import android.os.AsyncTask;
import com.zlylib.fileselectorlib.bean.EssFile;
import com.zlylib.fileselectorlib.bean.EssFileFilter;
import com.zlylib.fileselectorlib.bean.EssFileListCallBack;
import com.zlylib.fileselectorlib.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class EssFileListTask extends AsyncTask<Void, Void, List<EssFile>> {
    private EssFileListCallBack callBack;
    private Boolean isSelectFolder;
    private List<EssFile> mSelectedFileList;
    private int mSortType;
    private String queryPath;
    private String[] types;

    public EssFileListTask(List<EssFile> list, String str, String[] strArr, int i5, Boolean bool, EssFileListCallBack essFileListCallBack) {
        this.mSelectedFileList = list;
        this.queryPath = str;
        this.types = strArr;
        this.mSortType = i5;
        this.isSelectFolder = bool;
        this.callBack = essFileListCallBack;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
    }

    @Override // android.os.AsyncTask
    public List<EssFile> doInBackground(Void... voidArr) {
        File[] fileArrListFiles = new File(this.queryPath).listFiles(new EssFileFilter(this.types));
        if (fileArrListFiles == null) {
            return new ArrayList();
        }
        List listAsList = Arrays.asList(fileArrListFiles);
        int i5 = this.mSortType;
        if (i5 == 0) {
            Collections.sort(listAsList, new FileUtils.SortByName());
        } else if (i5 == 1) {
            Collections.sort(listAsList, new FileUtils.SortByName());
            Collections.reverse(listAsList);
        } else if (i5 == 2) {
            Collections.sort(listAsList, new FileUtils.SortByTime());
        } else if (i5 == 3) {
            Collections.sort(listAsList, new FileUtils.SortByTime());
            Collections.reverse(listAsList);
        } else if (i5 == 4) {
            Collections.sort(listAsList, new FileUtils.SortBySize());
        } else if (i5 == 5) {
            Collections.sort(listAsList, new FileUtils.SortBySize());
            Collections.reverse(listAsList);
        } else if (i5 == 6) {
            Collections.sort(listAsList, new FileUtils.SortByExtension());
        } else if (i5 == 7) {
            Collections.sort(listAsList, new FileUtils.SortByExtension());
            Collections.reverse(listAsList);
        }
        List<EssFile> essFileList = EssFile.getEssFileList((List<File>) listAsList, this.isSelectFolder.booleanValue());
        for (EssFile essFile : this.mSelectedFileList) {
            for (int i6 = 0; i6 < essFileList.size(); i6++) {
                if (essFile.getAbsolutePath().equals(essFileList.get(i6).getAbsolutePath())) {
                    essFileList.get(i6).setChecked(true);
                    break;
                }
            }
        }
        return essFileList;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(List<EssFile> list) {
        EssFileListCallBack essFileListCallBack = this.callBack;
        if (essFileListCallBack != null) {
            essFileListCallBack.onFindFileList(this.queryPath, list);
        }
    }
}
