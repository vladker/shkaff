package androidx.recyclerview.widget;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
class OpReorderer {
    final Callback mCallback;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int i5, int i6, int i7, Object obj);

        void recycleUpdateOp(AdapterHelper.UpdateOp updateOp);
    }

    public OpReorderer(Callback callback) {
        this.mCallback = callback;
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> list) {
        boolean z6 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).cmd != 8) {
                z6 = true;
            } else if (z6) {
                return size;
            }
        }
        return -1;
    }

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> list, int i5, AdapterHelper.UpdateOp updateOp, int i6, AdapterHelper.UpdateOp updateOp2) {
        int i7 = updateOp.itemCount;
        int i8 = updateOp2.positionStart;
        int i9 = i7 < i8 ? -1 : 0;
        int i10 = updateOp.positionStart;
        if (i10 < i8) {
            i9++;
        }
        if (i8 <= i10) {
            updateOp.positionStart = i10 + updateOp2.itemCount;
        }
        int i11 = updateOp2.positionStart;
        if (i11 <= i7) {
            updateOp.itemCount = i7 + updateOp2.itemCount;
        }
        updateOp2.positionStart = i11 + i9;
        list.set(i5, updateOp2);
        list.set(i6, updateOp);
    }

    private void swapMoveOp(List<AdapterHelper.UpdateOp> list, int i5, int i6) {
        AdapterHelper.UpdateOp updateOp = list.get(i5);
        AdapterHelper.UpdateOp updateOp2 = list.get(i6);
        int i7 = updateOp2.cmd;
        if (i7 == 1) {
            swapMoveAdd(list, i5, updateOp, i6, updateOp2);
        } else if (i7 == 2) {
            swapMoveRemove(list, i5, updateOp, i6, updateOp2);
        } else {
            if (i7 != 4) {
                return;
            }
            swapMoveUpdate(list, i5, updateOp, i6, updateOp2);
        }
    }

    public void reorderOps(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int lastMoveOutOfOrder = getLastMoveOutOfOrder(list);
            if (lastMoveOutOfOrder == -1) {
                return;
            } else {
                swapMoveOp(list, lastMoveOutOfOrder, lastMoveOutOfOrder + 1);
            }
        }
    }

    public void swapMoveRemove(List<AdapterHelper.UpdateOp> list, int i5, AdapterHelper.UpdateOp updateOp, int i6, AdapterHelper.UpdateOp updateOp2) {
        boolean z6;
        int i7 = updateOp.positionStart;
        int i8 = updateOp.itemCount;
        boolean z7 = false;
        if (i7 < i8) {
            if (updateOp2.positionStart == i7 && updateOp2.itemCount == i8 - i7) {
                z6 = false;
                z7 = true;
            } else {
                z6 = false;
            }
        } else if (updateOp2.positionStart == i8 + 1 && updateOp2.itemCount == i7 - i8) {
            z6 = true;
            z7 = true;
        } else {
            z6 = true;
        }
        int i9 = updateOp2.positionStart;
        if (i8 < i9) {
            updateOp2.positionStart = i9 - 1;
        } else {
            int i10 = updateOp2.itemCount;
            if (i8 < i9 + i10) {
                updateOp2.itemCount = i10 - 1;
                updateOp.cmd = 2;
                updateOp.itemCount = 1;
                if (updateOp2.itemCount == 0) {
                    list.remove(i6);
                    this.mCallback.recycleUpdateOp(updateOp2);
                    return;
                }
                return;
            }
        }
        int i11 = updateOp.positionStart;
        int i12 = updateOp2.positionStart;
        AdapterHelper.UpdateOp updateOpObtainUpdateOp = null;
        if (i11 <= i12) {
            updateOp2.positionStart = i12 + 1;
        } else {
            int i13 = updateOp2.itemCount;
            if (i11 < i12 + i13) {
                updateOpObtainUpdateOp = this.mCallback.obtainUpdateOp(2, i11 + 1, (i12 + i13) - i11, null);
                updateOp2.itemCount = updateOp.positionStart - updateOp2.positionStart;
            }
        }
        if (z7) {
            list.set(i5, updateOp2);
            list.remove(i6);
            this.mCallback.recycleUpdateOp(updateOp);
            return;
        }
        if (z6) {
            if (updateOpObtainUpdateOp != null) {
                int i14 = updateOp.positionStart;
                if (i14 > updateOpObtainUpdateOp.positionStart) {
                    updateOp.positionStart = i14 - updateOpObtainUpdateOp.itemCount;
                }
                int i15 = updateOp.itemCount;
                if (i15 > updateOpObtainUpdateOp.positionStart) {
                    updateOp.itemCount = i15 - updateOpObtainUpdateOp.itemCount;
                }
            }
            int i16 = updateOp.positionStart;
            if (i16 > updateOp2.positionStart) {
                updateOp.positionStart = i16 - updateOp2.itemCount;
            }
            int i17 = updateOp.itemCount;
            if (i17 > updateOp2.positionStart) {
                updateOp.itemCount = i17 - updateOp2.itemCount;
            }
        } else {
            if (updateOpObtainUpdateOp != null) {
                int i18 = updateOp.positionStart;
                if (i18 >= updateOpObtainUpdateOp.positionStart) {
                    updateOp.positionStart = i18 - updateOpObtainUpdateOp.itemCount;
                }
                int i19 = updateOp.itemCount;
                if (i19 >= updateOpObtainUpdateOp.positionStart) {
                    updateOp.itemCount = i19 - updateOpObtainUpdateOp.itemCount;
                }
            }
            int i20 = updateOp.positionStart;
            if (i20 >= updateOp2.positionStart) {
                updateOp.positionStart = i20 - updateOp2.itemCount;
            }
            int i21 = updateOp.itemCount;
            if (i21 >= updateOp2.positionStart) {
                updateOp.itemCount = i21 - updateOp2.itemCount;
            }
        }
        list.set(i5, updateOp2);
        if (updateOp.positionStart != updateOp.itemCount) {
            list.set(i6, updateOp);
        } else {
            list.remove(i6);
        }
        if (updateOpObtainUpdateOp != null) {
            list.add(i5, updateOpObtainUpdateOp);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0027  */
    /* JADX WARN: Code duplicated, block: B:12:0x002b  */
    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:17:0x0048  */
    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0056  */
    /* JADX WARN: Code duplicated, block: B:22:0x005b  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    public void swapMoveUpdate(List<AdapterHelper.UpdateOp> list, int i5, AdapterHelper.UpdateOp updateOp, int i6, AdapterHelper.UpdateOp updateOp2) {
        AdapterHelper.UpdateOp updateOpObtainUpdateOp;
        int i7;
        int i8;
        int i9;
        int i10 = updateOp.itemCount;
        int i11 = updateOp2.positionStart;
        AdapterHelper.UpdateOp updateOpObtainUpdateOp2 = null;
        if (i10 >= i11) {
            int i12 = updateOp2.itemCount;
            if (i10 < i11 + i12) {
                updateOp2.itemCount = i12 - 1;
                updateOpObtainUpdateOp = this.mCallback.obtainUpdateOp(4, updateOp.positionStart, 1, updateOp2.payload);
            }
            i7 = updateOp.positionStart;
            i8 = updateOp2.positionStart;
            if (i7 <= i8) {
                updateOp2.positionStart = i8 + 1;
            } else {
                i9 = updateOp2.itemCount;
                if (i7 < i8 + i9) {
                    int i13 = (i8 + i9) - i7;
                    updateOpObtainUpdateOp2 = this.mCallback.obtainUpdateOp(4, i7 + 1, i13, updateOp2.payload);
                    updateOp2.itemCount -= i13;
                }
            }
            list.set(i6, updateOp);
            if (updateOp2.itemCount > 0) {
                list.set(i5, updateOp2);
            } else {
                list.remove(i5);
                this.mCallback.recycleUpdateOp(updateOp2);
            }
            if (updateOpObtainUpdateOp != null) {
                list.add(i5, updateOpObtainUpdateOp);
            }
            if (updateOpObtainUpdateOp2 != null) {
                list.add(i5, updateOpObtainUpdateOp2);
            }
        }
        updateOp2.positionStart = i11 - 1;
        updateOpObtainUpdateOp = null;
        i7 = updateOp.positionStart;
        i8 = updateOp2.positionStart;
        if (i7 <= i8) {
            updateOp2.positionStart = i8 + 1;
        } else {
            i9 = updateOp2.itemCount;
            if (i7 < i8 + i9) {
                int i14 = (i8 + i9) - i7;
                updateOpObtainUpdateOp2 = this.mCallback.obtainUpdateOp(4, i7 + 1, i14, updateOp2.payload);
                updateOp2.itemCount -= i14;
            }
        }
        list.set(i6, updateOp);
        if (updateOp2.itemCount > 0) {
            list.set(i5, updateOp2);
        } else {
            list.remove(i5);
            this.mCallback.recycleUpdateOp(updateOp2);
        }
        if (updateOpObtainUpdateOp != null) {
            list.add(i5, updateOpObtainUpdateOp);
        }
        if (updateOpObtainUpdateOp2 != null) {
            list.add(i5, updateOpObtainUpdateOp2);
        }
    }
}
