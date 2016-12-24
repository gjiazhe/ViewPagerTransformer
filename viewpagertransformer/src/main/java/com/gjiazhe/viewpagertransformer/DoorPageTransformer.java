package com.gjiazhe.viewpagertransformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by gjz on 24/12/2016.
 */

public class DoorPageTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        // Counteract the default slide transition
        page.setTranslationX(-position * page.getWidth());

        final float rotation = -90 * position;
        page.setPivotX(position < 0 ? 0 : page.getWidth());
        page.setPivotY(page.getHeight() * 0.5f);

        page.setRotationY(rotation);
    }
}
