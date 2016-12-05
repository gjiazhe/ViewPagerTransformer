package com.gjiazhe.viewpagertransformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by gjz on 04/12/2016.
 */

public class AccordionPageTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        // Counteract the default slide transition
        page.setTranslationX(-position * page.getWidth());

        page.setPivotX(position < 0 ? 0 : page.getWidth());
        page.setScaleX(1 - Math.abs(position));
    }
}
