package com.zlylib.fileselectorlib.ui;

import S0.e;
import S0.g;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import com.zlylib.fileselectorlib.R;
import com.zlylib.fileselectorlib.SelectOptions;
import com.zlylib.fileselectorlib.adapter.BreadAdapter;
import com.zlylib.fileselectorlib.adapter.FileListAdapter;
import com.zlylib.fileselectorlib.adapter.SelectSdcardAdapter;
import com.zlylib.fileselectorlib.bean.BreadModel;
import com.zlylib.fileselectorlib.bean.EssFile;
import com.zlylib.fileselectorlib.bean.EssFileCountCallBack;
import com.zlylib.fileselectorlib.bean.EssFileListCallBack;
import com.zlylib.fileselectorlib.core.EssFileCountTask;
import com.zlylib.fileselectorlib.core.EssFileListTask;
import com.zlylib.fileselectorlib.utils.Const;
import com.zlylib.fileselectorlib.utils.FileUtils;
import com.zlylib.titlebarlib.ActionBarCommon;
import com.zlylib.titlebarlib.OnActionBarChildClickListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class FileSelectorActivity extends AppCompatActivity implements g, e, View.OnClickListener, FileListAdapter.onLoadFileCountListener, EssFileListCallBack, EssFileCountCallBack {
    private ActionBarCommon abc;
    private EssFileCountTask essFileCountTask;
    private EssFileListTask essFileListTask;
    private FileListAdapter mAdapter;
    private BreadAdapter mBreadAdapter;
    private RecyclerView mBreadRecyclerView;
    private ImageView mImbSelectSdCard;
    private RecyclerView mRecyclerView;
    private List<String> mSdCardList;
    private PopupWindow mSelectSdCardWindow;
    private String mCurFolder = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
    private boolean mHasChangeSdCard = false;
    private ArrayList<EssFile> mSelectedFileList = new ArrayList<>();
    private ArrayList<String> mSelectedList = new ArrayList<>();
    private int mSelectSortTypeIndex = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public void executeListTask(List<EssFile> list, String str, String[] strArr, int i5) {
        EssFileListTask essFileListTask = new EssFileListTask(list, str, strArr, i5, Boolean.valueOf(SelectOptions.getInstance().isOnlyShowFolder()), this);
        this.essFileListTask = essFileListTask;
        essFileListTask.execute(new Void[0]);
    }

    private int findFileIndex(EssFile essFile) {
        for (int i5 = 0; i5 < this.mSelectedFileList.size(); i5++) {
            if (this.mSelectedFileList.get(i5).getAbsolutePath().equals(essFile.getAbsolutePath())) {
                return i5;
            }
        }
        return -1;
    }

    private void initData() {
        executeListTask(this.mSelectedFileList, this.mCurFolder, SelectOptions.getInstance().getFileTypes(), SelectOptions.getInstance().getSortType());
    }

    @SuppressLint({"ResourceAsColor"})
    private void initUi() {
        this.abc = (ActionBarCommon) findViewById(R.id.abc);
        if (SelectOptions.getInstance().getTitleBg() != 0) {
            this.abc.setBackgroundColor(getResources().getColor(SelectOptions.getInstance().getTitleBg()));
        }
        if (SelectOptions.getInstance().getTitleColor() != 0) {
            this.abc.getTitleTextView().setTextColor(getResources().getColor(SelectOptions.getInstance().getTitleColor()));
        }
        if (SelectOptions.getInstance().getTitleLiftColor() != 0) {
            this.abc.getLeftIconView().setColorFilter(getResources().getColor(SelectOptions.getInstance().getTitleLiftColor()));
        }
        if (SelectOptions.getInstance().getTitleRightColor() != 0) {
            this.abc.getRightTextView().setTextColor(getResources().getColor(SelectOptions.getInstance().getTitleRightColor()));
        }
        this.abc.setOnLeftIconClickListener(new OnActionBarChildClickListener() { // from class: com.zlylib.fileselectorlib.ui.FileSelectorActivity.1
            @Override // com.zlylib.titlebarlib.OnActionBarChildClickListener
            public void onClick(View view) {
                FileSelectorActivity.this.onBackPressed();
            }
        });
        this.abc.setOnRightTextClickListener(new OnActionBarChildClickListener() { // from class: com.zlylib.fileselectorlib.ui.FileSelectorActivity.2
            @Override // com.zlylib.titlebarlib.OnActionBarChildClickListener
            public void onClick(View view) {
                if (SelectOptions.getInstance().isOnlySelectFolder()) {
                    FileSelectorActivity.this.mSelectedList.add(FileSelectorActivity.this.mCurFolder);
                }
                if (FileSelectorActivity.this.mSelectedList.isEmpty()) {
                    return;
                }
                Intent intent = new Intent();
                intent.putStringArrayListExtra(Const.EXTRA_RESULT_SELECTION, FileSelectorActivity.this.mSelectedList);
                FileSelectorActivity.this.setResult(-1, intent);
                FileSelectorActivity.this.finish();
            }
        });
        if (SelectOptions.getInstance().isOnlyShowFolder()) {
            this.abc.getRightTextView().setText("选中");
        }
        this.mRecyclerView = (RecyclerView) findViewById(R.id.rcv_file_list);
        this.mBreadRecyclerView = (RecyclerView) findViewById(R.id.breadcrumbs_view);
        ImageView imageView = (ImageView) findViewById(R.id.imb_select_sdcard);
        this.mImbSelectSdCard = imageView;
        imageView.setOnClickListener(this);
        if (!this.mSdCardList.isEmpty() && this.mSdCardList.size() > 1) {
            this.mImbSelectSdCard.setVisibility(0);
        }
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        FileListAdapter fileListAdapter = new FileListAdapter(new ArrayList());
        this.mAdapter = fileListAdapter;
        fileListAdapter.setLoadFileCountListener(this);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mAdapter.onAttachedToRecyclerView(this.mRecyclerView);
        this.mAdapter.setOnItemClickListener(this);
        List<BreadModel> breadModeListFromPath = FileUtils.getBreadModeListFromPath(this.mSdCardList, this.mCurFolder);
        this.mBreadRecyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
        BreadAdapter breadAdapter = new BreadAdapter(breadModeListFromPath);
        this.mBreadAdapter = breadAdapter;
        this.mBreadRecyclerView.setAdapter(breadAdapter);
        this.mBreadAdapter.onAttachedToRecyclerView(this.mBreadRecyclerView);
        this.mBreadAdapter.setOnItemChildClickListener(this);
    }

    private void showPopupWindow() {
        PopupWindow popupWindow = this.mSelectSdCardWindow;
        if (popupWindow != null) {
            popupWindow.showAsDropDown(this.mImbSelectSdCard);
            return;
        }
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.pop_select_sdcard, (ViewGroup) null);
        PopupWindow popupWindow2 = new PopupWindow(viewInflate, -1, -2);
        this.mSelectSdCardWindow = popupWindow2;
        popupWindow2.setFocusable(true);
        this.mSelectSdCardWindow.setOutsideTouchable(true);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.rcv_pop_select_sdcard);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final SelectSdcardAdapter selectSdcardAdapter = new SelectSdcardAdapter(FileUtils.getAllSdCardList(this.mSdCardList));
        recyclerView.setAdapter(selectSdcardAdapter);
        selectSdcardAdapter.onAttachedToRecyclerView(recyclerView);
        selectSdcardAdapter.setOnItemClickListener(new g() { // from class: com.zlylib.fileselectorlib.ui.FileSelectorActivity.3
            @Override // S0.g
            public void onItemClick(O0.e eVar, View view, int i5) {
                FileSelectorActivity.this.mSelectSdCardWindow.dismiss();
                FileSelectorActivity.this.mHasChangeSdCard = true;
                FileSelectorActivity fileSelectorActivity = FileSelectorActivity.this;
                fileSelectorActivity.executeListTask(fileSelectorActivity.mSelectedFileList, FileUtils.getChangeSdCard((String) selectSdcardAdapter.getData().get(i5), FileSelectorActivity.this.mSdCardList), SelectOptions.getInstance().getFileTypes(), SelectOptions.getInstance().getSortType());
            }
        });
        this.mSelectSdCardWindow.showAsDropDown(this.mImbSelectSdCard);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!FileUtils.canBackParent(this.mCurFolder, this.mSdCardList)) {
            super.onBackPressed();
            return;
        }
        executeListTask(this.mSelectedFileList, new File(this.mCurFolder).getParentFile().getAbsolutePath() + File.separator, SelectOptions.getInstance().getFileTypes(), SelectOptions.getInstance().getSortType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.imb_select_sdcard) {
            showPopupWindow();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_select_file);
        List<String> allSdPaths = FileUtils.getAllSdPaths(this);
        this.mSdCardList = allSdPaths;
        if (!allSdPaths.isEmpty()) {
            this.mCurFolder = this.mSdCardList.get(0) + File.separator;
            if (FileUtils.exist(SelectOptions.getInstance().getTargetPath())) {
                this.mCurFolder = SelectOptions.getInstance().getTargetPath();
            }
        }
        initUi();
        initData();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EssFileListTask essFileListTask = this.essFileListTask;
        if (essFileListTask != null) {
            essFileListTask.cancel(true);
        }
        EssFileCountTask essFileCountTask = this.essFileCountTask;
        if (essFileCountTask != null) {
            essFileCountTask.cancel(true);
        }
    }

    @Override // com.zlylib.fileselectorlib.bean.EssFileCountCallBack
    public void onFindChildFileAndFolderCount(int i5, String str, String str2) {
        ((EssFile) this.mAdapter.getData().get(i5)).setChildCounts(str, str2);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.zlylib.fileselectorlib.bean.EssFileListCallBack
    public void onFindFileList(String str, List<EssFile> list) {
        if (list.isEmpty()) {
            this.mAdapter.setEmptyView(R.layout.empty_file_list);
        }
        this.mCurFolder = str;
        this.mAdapter.setNewInstance(list);
        List<BreadModel> breadModeListFromPath = FileUtils.getBreadModeListFromPath(this.mSdCardList, this.mCurFolder);
        if (this.mHasChangeSdCard) {
            this.mBreadAdapter.setNewInstance(breadModeListFromPath);
            this.mHasChangeSdCard = false;
        } else if (breadModeListFromPath.size() > this.mBreadAdapter.getData().size()) {
            this.mBreadAdapter.addData((Collection<Object>) BreadModel.getNewBreadModel(this.mBreadAdapter.getData(), breadModeListFromPath));
        } else {
            int removedBreadModel = BreadModel.getRemovedBreadModel(this.mBreadAdapter.getData(), breadModeListFromPath);
            if (removedBreadModel > 0) {
                BreadAdapter breadAdapter = this.mBreadAdapter;
                breadAdapter.setNewData(breadAdapter.getData().subList(0, removedBreadModel));
            }
        }
        this.mBreadRecyclerView.smoothScrollToPosition(this.mBreadAdapter.getItemCount() - 1);
        this.mRecyclerView.scrollToPosition(0);
        this.mRecyclerView.scrollBy(0, ((BreadModel) this.mBreadAdapter.getData().get(this.mBreadAdapter.getData().size() - 1)).getPrePosition());
    }

    @Override // S0.e
    public void onItemChildClick(O0.e eVar, View view, int i5) {
        if (eVar.equals(this.mBreadAdapter) && view.getId() == R.id.btn_bread) {
            String breadModelListByPosition = FileUtils.getBreadModelListByPosition(this.mSdCardList, this.mBreadAdapter.getData(), i5);
            if (this.mCurFolder.equals(breadModelListByPosition)) {
                return;
            }
            executeListTask(this.mSelectedFileList, breadModelListByPosition, SelectOptions.getInstance().getFileTypes(), SelectOptions.getInstance().getSortType());
        }
    }

    @Override // S0.g
    public void onItemClick(O0.e eVar, View view, int i5) {
        if (eVar.equals(this.mAdapter)) {
            EssFile essFile = (EssFile) this.mAdapter.getData().get(i5);
            if (essFile.isDirectory()) {
                ((BreadModel) this.mBreadAdapter.getData().get(this.mBreadAdapter.getData().size() - 1)).setPrePosition(this.mRecyclerView.computeVerticalScrollOffset());
                executeListTask(this.mSelectedFileList, this.mCurFolder + essFile.getName() + File.separator, SelectOptions.getInstance().getFileTypes(), SelectOptions.getInstance().getSortType());
                return;
            }
            if (SelectOptions.getInstance().isOnlySelectFolder()) {
                if (essFile.getFile().isDirectory()) {
                    return;
                }
                Snackbar.make(this.mRecyclerView, "您只能选择文件夹", -1).show();
                return;
            }
            if (SelectOptions.getInstance().isSingle) {
                this.mSelectedFileList.add(essFile);
                this.mSelectedList.add(essFile.getAbsolutePath());
                Intent intent = new Intent();
                intent.putParcelableArrayListExtra(Const.EXTRA_RESULT_SELECTION, this.mSelectedFileList);
                setResult(-1, intent);
                super.onBackPressed();
                return;
            }
            if (SelectOptions.getInstance().isSingle) {
                this.mSelectedFileList.add(essFile);
                this.mSelectedList.add(essFile.getAbsolutePath());
                Intent intent2 = new Intent();
                intent2.putParcelableArrayListExtra(Const.EXTRA_RESULT_SELECTION, this.mSelectedFileList);
                setResult(-1, intent2);
                super.onBackPressed();
                return;
            }
            if (((EssFile) this.mAdapter.getData().get(i5)).isChecked()) {
                int iFindFileIndex = findFileIndex(essFile);
                if (iFindFileIndex != -1) {
                    this.mSelectedFileList.remove(iFindFileIndex);
                    this.mSelectedList.remove(iFindFileIndex);
                }
            } else {
                if (this.mSelectedFileList.size() >= SelectOptions.getInstance().maxCount) {
                    Snackbar.make(this.mRecyclerView, "您最多只能选择" + SelectOptions.getInstance().maxCount + "个。", -1).show();
                    return;
                }
                this.mSelectedFileList.add(essFile);
                this.mSelectedList.add(essFile.getAbsolutePath());
            }
            ((EssFile) this.mAdapter.getData().get(i5)).setChecked(!((EssFile) this.mAdapter.getData().get(i5)).isChecked());
            this.mAdapter.notifyDataSetChanged();
            this.abc.getRightTextView().setText(String.format(getString(R.string.selected_file_count), String.valueOf(this.mSelectedFileList.size()), String.valueOf(SelectOptions.getInstance().maxCount)));
        }
    }

    @Override // com.zlylib.fileselectorlib.adapter.FileListAdapter.onLoadFileCountListener
    public void onLoadFileCount(int i5) {
        EssFileCountTask essFileCountTask = new EssFileCountTask(i5, ((EssFile) this.mAdapter.getData().get(i5)).getAbsolutePath(), SelectOptions.getInstance().getFileTypes(), Boolean.valueOf(SelectOptions.getInstance().isOnlyShowFolder()), this);
        this.essFileCountTask = essFileCountTask;
        essFileCountTask.execute(new Void[0]);
    }
}
