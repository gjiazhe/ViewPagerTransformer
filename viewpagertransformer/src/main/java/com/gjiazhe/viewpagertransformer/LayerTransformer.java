package com.gjiazhe.viewpagertransformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by gjz on 04/12/2016.
 */

public class LayerTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        if (position <= 0f) {
            page.setTranslationX(0f);
        } else {
            page.setTranslationX(-page.getWidth() * position);
        }
    }
}
