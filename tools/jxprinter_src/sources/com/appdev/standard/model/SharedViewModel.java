package com.appdev.standard.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Integer> currentTab = new MutableLiveData<>();

    public LiveData<Integer> getCurrentTab() {
        return this.currentTab;
    }

    public void setCurrentTab(int i5) {
        this.currentTab.setValue(Integer.valueOf(i5));
    }
}
