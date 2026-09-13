package androidx.core.view;

import W3.InterfaceC0233q;
import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.jvm.internal.E;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class MenuKt {

    /* JADX INFO: renamed from: androidx.core.view.MenuKt$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AnonymousClass1 implements Iterator<MenuItem>, P3.a {
        final /* synthetic */ Menu $this_iterator;
        private int index;

        public AnonymousClass1(Menu menu) {
            this.$this_iterator = menu;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.size();
        }

        @Override // java.util.Iterator
        public void remove() {
            Q q6;
            Menu menu = this.$this_iterator;
            int i5 = this.index - 1;
            this.index = i5;
            MenuItem item = menu.getItem(i5);
            if (item != null) {
                menu.removeItem(item.getItemId());
                q6 = Q.INSTANCE;
            } else {
                q6 = null;
            }
            if (q6 == null) {
                throw new IndexOutOfBoundsException();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public MenuItem next() {
            Menu menu = this.$this_iterator;
            int i5 = this.index;
            this.index = i5 + 1;
            MenuItem item = menu.getItem(i5);
            if (item != null) {
                return item;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(Menu menu, MenuItem menuItem) {
        int size = menu.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (E.a(menu.getItem(i5), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(Menu menu, O3.l lVar) {
        int size = menu.size();
        for (int i5 = 0; i5 < size; i5++) {
            lVar.invoke(menu.getItem(i5));
        }
    }

    public static final void forEachIndexed(Menu menu, O3.p pVar) {
        int size = menu.size();
        for (int i5 = 0; i5 < size; i5++) {
            pVar.invoke(Integer.valueOf(i5), menu.getItem(i5));
        }
    }

    public static final MenuItem get(Menu menu, int i5) {
        return menu.getItem(i5);
    }

    public static final InterfaceC0233q getChildren(final Menu menu) {
        return new InterfaceC0233q() { // from class: androidx.core.view.MenuKt$children$1
            @Override // W3.InterfaceC0233q
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(menu);
            }
        };
    }

    public static final int getSize(Menu menu) {
        return menu.size();
    }

    public static final boolean isEmpty(Menu menu) {
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(Menu menu) {
        return menu.size() != 0;
    }

    public static final Iterator<MenuItem> iterator(Menu menu) {
        return new AnonymousClass1(menu);
    }

    public static final void minusAssign(Menu menu, MenuItem menuItem) {
        menu.removeItem(menuItem.getItemId());
    }

    public static final void removeItemAt(Menu menu, int i5) {
        Q q6;
        MenuItem item = menu.getItem(i5);
        if (item != null) {
            menu.removeItem(item.getItemId());
            q6 = Q.INSTANCE;
        } else {
            q6 = null;
        }
        if (q6 == null) {
            throw new IndexOutOfBoundsException();
        }
    }
}
