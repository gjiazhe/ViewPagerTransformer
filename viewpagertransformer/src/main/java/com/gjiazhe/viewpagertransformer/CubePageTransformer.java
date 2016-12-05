package com.gjiazhe.viewpagertransformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by gjz on 05/12/2016.
 */

public class CubePageTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        final float rotation = 90 * position;
        page.setPivotX(position <= 0f ? page.getWidth() : 0f);
        page.setPivotY(page.getHeight() * 0.5f);
        page.setRotationY(rotation);
    }
}
