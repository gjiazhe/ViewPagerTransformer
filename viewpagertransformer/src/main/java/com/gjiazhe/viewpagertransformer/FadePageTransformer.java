package com.gjiazhe.viewpagertransformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by gjz on 04/12/2016.
 */

public class FadePageTransformer implements ViewPager.PageTransformer {
    private float finalScale;
    private float minAlpha;

    public FadePageTransformer() {
        finalScale = 1.5f;
        minAlpha = 0f;
    }

    public FadePageTransformer(float finalScale, float minAlpha) {
        setFinalScale(finalScale);
        setMinAlpha(minAlpha);
    }

    @Override
    public void transformPage(View page, float position) {
        // Counteract the default slide transition
        page.setTranslationX(-position * page.getWidth());

        final float scale = 1 - (1 - finalScale) * Math.abs(position);
        final float alpha = 1 - (1 - minAlpha) * Math.abs(position);

        page.setPivotX(page.getWidth() * 0.5f);
        page.setPivotY(page.getHeight() * 0.5f);
        page.setScaleX(scale);
        page.setScaleY(scale);
        page.setAlpha(alpha);
    }

    public float getFinalScale() {
        return finalScale;
    }

    public void setFinalScale(float finalScale) {
        this.finalScale = finalScale;
    }

    public float getMinAlpha() {
        return minAlpha;
    }

    public void setMinAlpha(float minAlpha) {
        this.minAlpha = minAlpha;
    }
}
