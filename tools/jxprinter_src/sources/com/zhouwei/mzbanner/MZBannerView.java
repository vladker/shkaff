package com.zhouwei.mzbanner;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;
import com.zhouwei.mzbanner.transformer.CoverModeTransformer;
import com.zhouwei.mzbanner.transformer.ScaleYTransformer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class MZBannerView<T> extends RelativeLayout {
    private static final String TAG = "MZBannerView";
    private MZPagerAdapter mAdapter;
    private BannerPageClickListener mBannerPageClickListener;
    private int mCurrentItem;
    private List<T> mDatas;
    private int mDelayedTime;
    private Handler mHandler;
    private int mIndicatorAlign;
    private LinearLayout mIndicatorContainer;
    private int mIndicatorPaddingBottom;
    private int mIndicatorPaddingLeft;
    private int mIndicatorPaddingRight;
    private int mIndicatorPaddingTop;
    private int[] mIndicatorRes;
    private ArrayList<ImageView> mIndicators;
    private boolean mIsAutoPlay;
    private boolean mIsCanLoop;
    private boolean mIsMiddlePageCover;
    private boolean mIsOpenMZEffect;
    private final Runnable mLoopRunnable;
    private int mMZModePadding;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private CustomViewPager mViewPager;
    private ViewPagerScroller mViewPagerScroller;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface BannerPageClickListener {
        void onPageClick(View view, int i5);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum IndicatorAlign {
        LEFT,
        CENTER,
        RIGHT
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class MZPagerAdapter<T> extends PagerAdapter {
        private boolean canLoop;
        private List<T> mDatas;
        private final int mLooperCountFactor = Videoio.CAP_QT;
        private MZHolderCreator mMZHolderCreator;
        private BannerPageClickListener mPageClickListener;
        private ViewPager mViewPager;

        public MZPagerAdapter(List<T> list, MZHolderCreator mZHolderCreator, boolean z6) {
            if (this.mDatas == null) {
                this.mDatas = new ArrayList();
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                this.mDatas.add(it.next());
            }
            this.mMZHolderCreator = mZHolderCreator;
            this.canLoop = z6;
        }

        private int getRealCount() {
            List<T> list = this.mDatas;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        private int getStartSelectItem() {
            if (getRealCount() == 0) {
                return 0;
            }
            int realCount = (getRealCount() * Videoio.CAP_QT) / 2;
            if (realCount % getRealCount() == 0) {
                return realCount;
            }
            while (realCount % getRealCount() != 0) {
                realCount++;
            }
            return realCount;
        }

        private View getView(int i5, ViewGroup viewGroup) {
            final int realCount = i5 % getRealCount();
            MZViewHolder mZViewHolderCreateViewHolder = this.mMZHolderCreator.createViewHolder();
            if (mZViewHolderCreateViewHolder == null) {
                throw new RuntimeException("can not return a null holder");
            }
            View viewCreateView = mZViewHolderCreateViewHolder.createView(viewGroup.getContext());
            List<T> list = this.mDatas;
            if (list != null && list.size() > 0) {
                mZViewHolderCreateViewHolder.onBind(viewGroup.getContext(), realCount, this.mDatas.get(realCount));
            }
            viewCreateView.setOnClickListener(new View.OnClickListener() { // from class: com.zhouwei.mzbanner.MZBannerView.MZPagerAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MZPagerAdapter.this.mPageClickListener != null) {
                        MZPagerAdapter.this.mPageClickListener.onPageClick(view, realCount);
                    }
                }
            });
            return viewCreateView;
        }

        private void setCurrentItem(int i5) {
            try {
                this.mViewPager.setCurrentItem(i5, false);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i5, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(ViewGroup viewGroup) {
            if (this.canLoop && this.mViewPager.getCurrentItem() == getCount() - 1) {
                setCurrentItem(0);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.canLoop ? getRealCount() * Videoio.CAP_QT : getRealCount();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i5) {
            View view = getView(i5, viewGroup);
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public void setDatas(List<T> list) {
            this.mDatas = list;
        }

        public void setPageClickListener(BannerPageClickListener bannerPageClickListener) {
            this.mPageClickListener = bannerPageClickListener;
        }

        public void setUpViewViewPager(ViewPager viewPager) {
            this.mViewPager = viewPager;
            viewPager.setAdapter(this);
            this.mViewPager.getAdapter().notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.canLoop ? getStartSelectItem() : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ViewPagerScroller extends Scroller {
        private int mDuration;
        private boolean mIsUseDefaultDuration;

        public ViewPagerScroller(Context context) {
            super(context);
            this.mDuration = Videoio.CAP_PVAPI;
            this.mIsUseDefaultDuration = false;
        }

        public int getScrollDuration() {
            return this.mDuration;
        }

        public boolean isUseDefaultDuration() {
            return this.mIsUseDefaultDuration;
        }

        public void setDuration(int i5) {
            this.mDuration = i5;
        }

        public void setUseDefaultDuration(boolean z6) {
            this.mIsUseDefaultDuration = z6;
        }

        @Override // android.widget.Scroller
        public void startScroll(int i5, int i6, int i7, int i8) {
            super.startScroll(i5, i6, i7, i8, this.mDuration);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i5, int i6, int i7, int i8, int i9) {
            if (!this.mIsUseDefaultDuration) {
                i9 = this.mDuration;
            }
            super.startScroll(i5, i6, i7, i8, i9);
        }

        public ViewPagerScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
            this.mDuration = Videoio.CAP_PVAPI;
            this.mIsUseDefaultDuration = false;
        }

        public ViewPagerScroller(Context context, Interpolator interpolator, boolean z6) {
            super(context, interpolator, z6);
            this.mDuration = Videoio.CAP_PVAPI;
            this.mIsUseDefaultDuration = false;
        }
    }

    public MZBannerView(@NonNull Context context) {
        super(context);
        this.mIsAutoPlay = true;
        this.mCurrentItem = 0;
        this.mHandler = new Handler();
        this.mDelayedTime = 3000;
        this.mIsOpenMZEffect = true;
        this.mIsCanLoop = true;
        this.mIndicators = new ArrayList<>();
        this.mIndicatorRes = new int[]{R.drawable.indicator_normal, R.drawable.indicator_selected};
        this.mIndicatorPaddingLeft = 0;
        this.mIndicatorPaddingRight = 0;
        this.mIndicatorPaddingTop = 0;
        this.mIndicatorPaddingBottom = 0;
        this.mMZModePadding = 0;
        this.mIndicatorAlign = 1;
        this.mIsMiddlePageCover = true;
        this.mLoopRunnable = new Runnable() { // from class: com.zhouwei.mzbanner.MZBannerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!MZBannerView.this.mIsAutoPlay) {
                    MZBannerView.this.mHandler.postDelayed(this, MZBannerView.this.mDelayedTime);
                    return;
                }
                MZBannerView mZBannerView = MZBannerView.this;
                mZBannerView.mCurrentItem = mZBannerView.mViewPager.getCurrentItem();
                MZBannerView.access$108(MZBannerView.this);
                if (MZBannerView.this.mCurrentItem != MZBannerView.this.mAdapter.getCount() - 1) {
                    MZBannerView.this.mViewPager.setCurrentItem(MZBannerView.this.mCurrentItem);
                    MZBannerView.this.mHandler.postDelayed(this, MZBannerView.this.mDelayedTime);
                } else {
                    MZBannerView.this.mCurrentItem = 0;
                    MZBannerView.this.mViewPager.setCurrentItem(MZBannerView.this.mCurrentItem, false);
                    MZBannerView.this.mHandler.postDelayed(this, MZBannerView.this.mDelayedTime);
                }
            }
        };
        init();
    }

    public static /* synthetic */ int access$108(MZBannerView mZBannerView) {
        int i5 = mZBannerView.mCurrentItem;
        mZBannerView.mCurrentItem = i5 + 1;
        return i5;
    }

    public static int dpToPx(int i5) {
        return (int) TypedValue.applyDimension(1, i5, Resources.getSystem().getDisplayMetrics());
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private void init() {
        View viewInflate = this.mIsOpenMZEffect ? LayoutInflater.from(getContext()).inflate(R.layout.mz_banner_effect_layout, (ViewGroup) this, true) : LayoutInflater.from(getContext()).inflate(R.layout.mz_banner_normal_layout, (ViewGroup) this, true);
        this.mIndicatorContainer = (LinearLayout) viewInflate.findViewById(R.id.banner_indicator_container);
        CustomViewPager customViewPager = (CustomViewPager) viewInflate.findViewById(R.id.mzbanner_vp);
        this.mViewPager = customViewPager;
        customViewPager.setOffscreenPageLimit(4);
        this.mMZModePadding = dpToPx(30);
        initViewPagerScroll();
        sureIndicatorPosition();
    }

    private void initIndicator() {
        this.mIndicatorContainer.removeAllViews();
        this.mIndicators.clear();
        for (int i5 = 0; i5 < this.mDatas.size(); i5++) {
            ImageView imageView = new ImageView(getContext());
            if (this.mIndicatorAlign == IndicatorAlign.LEFT.ordinal()) {
                if (i5 == 0) {
                    imageView.setPadding((this.mIsOpenMZEffect ? this.mIndicatorPaddingLeft + this.mMZModePadding : this.mIndicatorPaddingLeft) + 6, 0, 6, 0);
                } else {
                    imageView.setPadding(6, 0, 6, 0);
                }
            } else if (this.mIndicatorAlign == IndicatorAlign.RIGHT.ordinal() && i5 == this.mDatas.size() - 1) {
                imageView.setPadding(6, 0, (this.mIsOpenMZEffect ? this.mMZModePadding + this.mIndicatorPaddingRight : this.mIndicatorPaddingRight) + 6, 0);
            } else {
                imageView.setPadding(6, 0, 6, 0);
            }
            if (i5 == this.mCurrentItem % this.mDatas.size()) {
                imageView.setImageResource(this.mIndicatorRes[1]);
            } else {
                imageView.setImageResource(this.mIndicatorRes[0]);
            }
            this.mIndicators.add(imageView);
            this.mIndicatorContainer.addView(imageView);
        }
    }

    private void initViewPagerScroll() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            ViewPagerScroller viewPagerScroller = new ViewPagerScroller(this.mViewPager.getContext());
            this.mViewPagerScroller = viewPagerScroller;
            declaredField.set(this.mViewPager, viewPagerScroller);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
        } catch (NoSuchFieldException e7) {
            e7.printStackTrace();
        }
    }

    private void readAttrs(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MZBannerView);
        this.mIsOpenMZEffect = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MZBannerView_open_mz_mode, true);
        this.mIsMiddlePageCover = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MZBannerView_middle_page_cover, true);
        this.mIsCanLoop = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MZBannerView_canLoop, true);
        this.mIndicatorAlign = typedArrayObtainStyledAttributes.getInt(R.styleable.MZBannerView_indicatorAlign, IndicatorAlign.CENTER.ordinal());
        this.mIndicatorPaddingLeft = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MZBannerView_indicatorPaddingLeft, 0);
        this.mIndicatorPaddingRight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MZBannerView_indicatorPaddingRight, 0);
        this.mIndicatorPaddingTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MZBannerView_indicatorPaddingTop, 0);
        this.mIndicatorPaddingBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MZBannerView_indicatorPaddingBottom, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void setOpenMZEffect() {
        if (this.mIsOpenMZEffect) {
            if (!this.mIsMiddlePageCover) {
                this.mViewPager.setPageTransformer(false, new ScaleYTransformer());
            } else {
                CustomViewPager customViewPager = this.mViewPager;
                customViewPager.setPageTransformer(true, new CoverModeTransformer(customViewPager));
            }
        }
    }

    private void sureIndicatorPosition() {
        int i5 = this.mIndicatorAlign;
        IndicatorAlign indicatorAlign = IndicatorAlign.LEFT;
        if (i5 == indicatorAlign.ordinal()) {
            setIndicatorAlign(indicatorAlign);
            return;
        }
        int i6 = this.mIndicatorAlign;
        IndicatorAlign indicatorAlign2 = IndicatorAlign.CENTER;
        if (i6 == indicatorAlign2.ordinal()) {
            setIndicatorAlign(indicatorAlign2);
        } else {
            setIndicatorAlign(IndicatorAlign.RIGHT);
        }
    }

    public void addPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0020  */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int left;
        float rawX;
        if (!this.mIsCanLoop) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            left = this.mViewPager.getLeft();
            rawX = motionEvent.getRawX();
            if (rawX >= left && rawX < getScreenWidth(getContext()) - left) {
                pause();
            }
        } else if (action == 1) {
            start();
        } else if (action == 2 || action == 3 || action == 4) {
            left = this.mViewPager.getLeft();
            rawX = motionEvent.getRawX();
            if (rawX >= left) {
                pause();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getDuration() {
        return this.mViewPagerScroller.getScrollDuration();
    }

    public LinearLayout getIndicatorContainer() {
        return this.mIndicatorContainer;
    }

    public ViewPager getViewPager() {
        return this.mViewPager;
    }

    public void pause() {
        this.mIsAutoPlay = false;
        this.mHandler.removeCallbacks(this.mLoopRunnable);
    }

    public void setBannerPageClickListener(BannerPageClickListener bannerPageClickListener) {
        this.mBannerPageClickListener = bannerPageClickListener;
    }

    public void setCanLoop(boolean z6) {
        this.mIsCanLoop = z6;
        if (z6) {
            return;
        }
        pause();
    }

    public void setDelayedTime(int i5) {
        this.mDelayedTime = i5;
    }

    public void setDuration(int i5) {
        this.mViewPagerScroller.setDuration(i5);
    }

    public void setIndicatorAlign(IndicatorAlign indicatorAlign) {
        this.mIndicatorAlign = indicatorAlign.ordinal();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mIndicatorContainer.getLayoutParams();
        if (indicatorAlign == IndicatorAlign.LEFT) {
            layoutParams.addRule(9);
        } else if (indicatorAlign == IndicatorAlign.RIGHT) {
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(14);
        }
        layoutParams.setMargins(0, this.mIndicatorPaddingTop, 0, this.mIndicatorPaddingBottom);
        this.mIndicatorContainer.setLayoutParams(layoutParams);
    }

    public void setIndicatorPadding(int i5, int i6, int i7, int i8) {
        this.mIndicatorPaddingLeft = i5;
        this.mIndicatorPaddingTop = i6;
        this.mIndicatorPaddingRight = i7;
        this.mIndicatorPaddingBottom = i8;
        sureIndicatorPosition();
    }

    public void setIndicatorRes(@DrawableRes int i5, @DrawableRes int i6) {
        int[] iArr = this.mIndicatorRes;
        iArr[0] = i5;
        iArr[1] = i6;
    }

    public void setIndicatorVisible(boolean z6) {
        if (z6) {
            this.mIndicatorContainer.setVisibility(0);
        } else {
            this.mIndicatorContainer.setVisibility(8);
        }
    }

    public void setPages(List<T> list, MZHolderCreator mZHolderCreator) {
        if (list == null || mZHolderCreator == null) {
            return;
        }
        this.mDatas = list;
        pause();
        if (list.size() < 3) {
            this.mIsOpenMZEffect = false;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mViewPager.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            this.mViewPager.setLayoutParams(marginLayoutParams);
            setClipChildren(true);
            this.mViewPager.setClipChildren(true);
        }
        setOpenMZEffect();
        initIndicator();
        MZPagerAdapter mZPagerAdapter = new MZPagerAdapter(list, mZHolderCreator, this.mIsCanLoop);
        this.mAdapter = mZPagerAdapter;
        mZPagerAdapter.setUpViewViewPager(this.mViewPager);
        this.mAdapter.setPageClickListener(this.mBannerPageClickListener);
        this.mViewPager.clearOnPageChangeListeners();
        this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.zhouwei.mzbanner.MZBannerView.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i5) {
                if (i5 == 1) {
                    MZBannerView.this.mIsAutoPlay = false;
                } else if (i5 == 2) {
                    MZBannerView.this.mIsAutoPlay = true;
                }
                if (MZBannerView.this.mOnPageChangeListener != null) {
                    MZBannerView.this.mOnPageChangeListener.onPageScrollStateChanged(i5);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i5, float f6, int i6) {
                int size = i5 % MZBannerView.this.mIndicators.size();
                if (MZBannerView.this.mOnPageChangeListener != null) {
                    MZBannerView.this.mOnPageChangeListener.onPageScrolled(size, f6, i6);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i5) {
                MZBannerView.this.mCurrentItem = i5;
                int size = MZBannerView.this.mCurrentItem % MZBannerView.this.mIndicators.size();
                for (int i6 = 0; i6 < MZBannerView.this.mDatas.size(); i6++) {
                    if (i6 == size) {
                        ((ImageView) MZBannerView.this.mIndicators.get(i6)).setImageResource(MZBannerView.this.mIndicatorRes[1]);
                    } else {
                        ((ImageView) MZBannerView.this.mIndicators.get(i6)).setImageResource(MZBannerView.this.mIndicatorRes[0]);
                    }
                }
                if (MZBannerView.this.mOnPageChangeListener != null) {
                    MZBannerView.this.mOnPageChangeListener.onPageSelected(size);
                }
            }
        });
    }

    public void setUseDefaultDuration(boolean z6) {
        this.mViewPagerScroller.setUseDefaultDuration(z6);
    }

    public void start() {
        if (this.mAdapter != null && this.mIsCanLoop) {
            pause();
            this.mIsAutoPlay = true;
            this.mHandler.postDelayed(this.mLoopRunnable, this.mDelayedTime);
        }
    }

    public MZBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsAutoPlay = true;
        this.mCurrentItem = 0;
        this.mHandler = new Handler();
        this.mDelayedTime = 3000;
        this.mIsOpenMZEffect = true;
        this.mIsCanLoop = true;
        this.mIndicators = new ArrayList<>();
        this.mIndicatorRes = new int[]{R.drawable.indicator_normal, R.drawable.indicator_selected};
        this.mIndicatorPaddingLeft = 0;
        this.mIndicatorPaddingRight = 0;
        this.mIndicatorPaddingTop = 0;
        this.mIndicatorPaddingBottom = 0;
        this.mMZModePadding = 0;
        this.mIndicatorAlign = 1;
        this.mIsMiddlePageCover = true;
        this.mLoopRunnable = new Runnable() { // from class: com.zhouwei.mzbanner.MZBannerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!MZBannerView.this.mIsAutoPlay) {
                    MZBannerView.this.mHandler.postDelayed(this, MZBannerView.this.mDelayedTime);
                    return;
                }
                MZBannerView mZBannerView = MZBannerView.this;
                mZBannerView.mCurrentItem = mZBannerView.mViewPager.getCurrentItem();
                MZBannerView.access$108(MZBannerView.this);
                if (MZBannerView.this.mCurrentItem != MZBannerView.this.mAdapter.getCount() - 1) {
                    MZBannerView.this.mViewPager.setCurrentItem(MZBannerView.this.mCurrentItem);
                    MZBannerView.this.mHandler.postDelayed(this, MZBannerView.this.mDelayedTime);
                } else {
                    MZBannerView.this.mCurrentItem = 0;
                    MZBannerView.this.mViewPager.setCurrentItem(MZBannerView.this.mCurrentItem, false);
                    MZBannerView.this.mHandler.postDelayed(this, MZBannerView.this.mDelayedTime);
                }
            }
        };
        readAttrs(context, attributeSet);
        init();
    }

    public MZBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5) {
        super(context, attributeSet, i5);
        this.mIsAutoPlay = true;
        this.mCurrentItem = 0;
        this.mHandler = new Handler();
        this.mDelayedTime = 3000;
        this.mIsOpenMZEffect = true;
        this.mIsCanLoop = true;
        this.mIndicators = new ArrayList<>();
        this.mIndicatorRes = new int[]{R.drawable.indicator_normal, R.drawable.indicator_selected};
        this.mIndicatorPaddingLeft = 0;
        this.mIndicatorPaddingRight = 0;
        this.mIndicatorPaddingTop = 0;
        this.mIndicatorPaddingBottom = 0;
        this.mMZModePadding = 0;
        this.mIndicatorAlign = 1;
        this.mIsMiddlePageCover = true;
        this.mLoopRunnable = new Runnable() { // from class: com.zhouwei.mzbanner.MZBannerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!MZBannerView.this.mIsAutoPlay) {
                    MZBannerView.this.mHandler.postDelayed(this, MZBannerView.this.mDelayedTime);
                    return;
                }
                MZBannerView mZBannerView = MZBannerView.this;
                mZBannerView.mCurrentItem = mZBannerView.mViewPager.getCurrentItem();
                MZBannerView.access$108(MZBannerView.this);
                if (MZBannerView.this.mCurrentItem != MZBannerView.this.mAdapter.getCount() - 1) {
                    MZBannerView.this.mViewPager.setCurrentItem(MZBannerView.this.mCurrentItem);
                    MZBannerView.this.mHandler.postDelayed(this, MZBannerView.this.mDelayedTime);
                } else {
                    MZBannerView.this.mCurrentItem = 0;
                    MZBannerView.this.mViewPager.setCurrentItem(MZBannerView.this.mCurrentItem, false);
                    MZBannerView.this.mHandler.postDelayed(this, MZBannerView.this.mDelayedTime);
                }
            }
        };
        readAttrs(context, attributeSet);
        init();
    }

    @RequiresApi(api = 21)
    public MZBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5, @StyleRes int i6) {
        super(context, attributeSet, i5, i6);
        this.mIsAutoPlay = true;
        this.mCurrentItem = 0;
        this.mHandler = new Handler();
        this.mDelayedTime = 3000;
        this.mIsOpenMZEffect = true;
        this.mIsCanLoop = true;
        this.mIndicators = new ArrayList<>();
        this.mIndicatorRes = new int[]{R.drawable.indicator_normal, R.drawable.indicator_selected};
        this.mIndicatorPaddingLeft = 0;
        this.mIndicatorPaddingRight = 0;
        this.mIndicatorPaddingTop = 0;
        this.mIndicatorPaddingBottom = 0;
        this.mMZModePadding = 0;
        this.mIndicatorAlign = 1;
        this.mIsMiddlePageCover = true;
        this.mLoopRunnable = new Runnable() { // from class: com.zhouwei.mzbanner.MZBannerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!MZBannerView.this.mIsAutoPlay) {
                    MZBannerView.this.mHandler.postDelayed(this, MZBannerView.this.mDelayedTime);
                    return;
                }
                MZBannerView mZBannerView = MZBannerView.this;
                mZBannerView.mCurrentItem = mZBannerView.mViewPager.getCurrentItem();
                MZBannerView.access$108(MZBannerView.this);
                if (MZBannerView.this.mCurrentItem != MZBannerView.this.mAdapter.getCount() - 1) {
                    MZBannerView.this.mViewPager.setCurrentItem(MZBannerView.this.mCurrentItem);
                    MZBannerView.this.mHandler.postDelayed(this, MZBannerView.this.mDelayedTime);
                } else {
                    MZBannerView.this.mCurrentItem = 0;
                    MZBannerView.this.mViewPager.setCurrentItem(MZBannerView.this.mCurrentItem, false);
                    MZBannerView.this.mHandler.postDelayed(this, MZBannerView.this.mDelayedTime);
                }
            }
        };
        readAttrs(context, attributeSet);
        init();
    }
}
