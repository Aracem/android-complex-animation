package com.jobandtalent.coolanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.FrameLayout;

import java.util.HashMap;
import java.util.Random;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PostAJobAnimatedView extends FrameLayout {

    private static final int CIRCLE_ANIMATION_TIME = 5000;
    private static final int CIRCLE_ANIMATION_DELAY_ONE = 1666;
    private static final int CIRCLE_ANIMATION_DELAY_TWO = 3333;

    @InjectView(R.id.v_circle_1) View mCircleOne;
    @InjectView(R.id.v_circle_2) View mCircleTwo;
    @InjectView(R.id.v_circle_3) View mCircleThree;
    @InjectView(R.id.v_avatar_1) PostAJobAnimationCircleImageView mAvatarOne;
    @InjectView(R.id.v_avatar_2) PostAJobAnimationCircleImageView mAvatarTwo;

    private static HashMap<Integer, Integer> mAvatarResources;

    static {
        mAvatarResources = new HashMap<>();

        mAvatarResources.put(0, R.drawable.avatar_1);
        mAvatarResources.put(1, R.drawable.avatar_2);
        mAvatarResources.put(2, R.drawable.avatar_3);
        mAvatarResources.put(3, R.drawable.avatar_4);
        mAvatarResources.put(4, R.drawable.avatar_5);
        mAvatarResources.put(5, R.drawable.avatar_6);
        mAvatarResources.put(6, R.drawable.avatar_7);
        mAvatarResources.put(7, R.drawable.avatar_8);
        mAvatarResources.put(8, R.drawable.avatar_9);
    }

    public PostAJobAnimatedView(Context context) {
        super(context);
    }

    public PostAJobAnimatedView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PostAJobAnimatedView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PostAJobAnimatedView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        LayoutInflater.from(getContext()).inflate(R.layout.view_postajob_animation, this);
        ButterKnife.inject(this);
        if (isInEditMode()) {
            renderEditMode();
            return;
        }
    }

    public void startAnimation() {
        launchCirclesAnimation();
        launchAvatarsAnimation();
    }

    private void launchCirclesAnimation() {
        mCircleTwo.setScaleX(0f);
        mCircleTwo.setScaleY(0f);
        mCircleThree.setScaleX(0f);
        mCircleThree.setScaleY(0f);

        ObjectAnimator animator = getCircleAnimation(mCircleOne, CIRCLE_ANIMATION_TIME);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new FastOutLinearInInterpolator());
        animator.start();

        ObjectAnimator animator2 = getCircleAnimation(mCircleTwo, CIRCLE_ANIMATION_TIME);
        animator2.setStartDelay(CIRCLE_ANIMATION_DELAY_ONE);
        animator2.setRepeatMode(ValueAnimator.RESTART);
        animator2.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new BounceInterpolator());
        animator2.start();

        ObjectAnimator animator3 = getCircleAnimation(mCircleThree, CIRCLE_ANIMATION_TIME);
        animator3.setStartDelay(CIRCLE_ANIMATION_DELAY_TWO);
        animator3.setRepeatMode(ValueAnimator.RESTART);
        animator3.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator3.start();
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public static ObjectAnimator getCircleAnimation(View view, int millis) {
        PropertyValuesHolder pvhScaleX = PropertyValuesHolder.ofKeyframe(View.SCALE_X,
                Keyframe.ofFloat(0f, 0.01f),
                Keyframe.ofFloat(.2f, .65f),
                Keyframe.ofFloat(.3f, .83f),
                Keyframe.ofFloat(.35f, .86f),
                Keyframe.ofFloat(.4f, .885f),
                Keyframe.ofFloat(.45f, .905f),
                Keyframe.ofFloat(.5f, .915f),
                Keyframe.ofFloat(.55f, .940f),
                Keyframe.ofFloat(.6f, .955f),
                Keyframe.ofFloat(1f, 1f)
        );

//        Keyframe.ofFloat(0f, 0.01f),
//                Keyframe.ofFloat(.3f, .7f),
//                Keyframe.ofFloat(.4f, .79f),
//                Keyframe.ofFloat(.45f, .835f),
//                Keyframe.ofFloat(.5f, .865f),
//                Keyframe.ofFloat(.55f, .895f),
//                Keyframe.ofFloat(.6f, .92f),
//                Keyframe.ofFloat(.65f, .935f),
//                Keyframe.ofFloat(.7f, .95f),
//                Keyframe.ofFloat(1f, 1f)

        PropertyValuesHolder pvhScaleY = PropertyValuesHolder.ofKeyframe(View.SCALE_Y,
                Keyframe.ofFloat(0f, 0.01f),
                Keyframe.ofFloat(.2f, .65f),
                Keyframe.ofFloat(.3f, .83f),
                Keyframe.ofFloat(.35f, .86f),
                Keyframe.ofFloat(.4f, .885f),
                Keyframe.ofFloat(.45f, .905f),
                Keyframe.ofFloat(.5f, .915f),
                Keyframe.ofFloat(.55f, .940f),
                Keyframe.ofFloat(.6f, .955f),
                Keyframe.ofFloat(1f, 1f)
        );

        PropertyValuesHolder pvhAlpha = PropertyValuesHolder.ofKeyframe(View.ALPHA,
                Keyframe.ofFloat(0f, .6f),
                Keyframe.ofFloat(.2f, .7f),
                Keyframe.ofFloat(.6f, .7f),
                Keyframe.ofFloat(1f, 0f)
        );

        return ObjectAnimator.ofPropertyValuesHolder(view, pvhScaleX, pvhScaleY, pvhAlpha).
                setDuration(millis);
    }


    private void launchAvatarsAnimation() {
        mAvatarOne.setScaleX(0f);
        mAvatarOne.setScaleY(0f);
        mAvatarTwo.setScaleX(0f);
        mAvatarTwo.setScaleY(0f);

        mAvatarOne.setImageResource(getNextAvatar());
        randomizeAvatarPosition(mAvatarOne);
        ObjectAnimator avatarAnimation = getAvatarAnimation(mAvatarOne, getAvatarRandomTime());
        avatarAnimation.setRepeatMode(ValueAnimator.RESTART);
        avatarAnimation.setRepeatCount(ValueAnimator.INFINITE);
        avatarAnimation.setStartDelay(1500);
        avatarAnimation.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                randomizeAvatarPosition(mAvatarOne);
                mAvatarOne.setImageResource(getNextAvatar());
            }
        });
        avatarAnimation.start();

        mAvatarTwo.setImageResource(getNextAvatar());
        randomizeAvatarPosition(mAvatarTwo);
        ObjectAnimator avatarAnimation2 = getAvatarAnimation(mAvatarTwo, getAvatarRandomTime());
        avatarAnimation2.setRepeatMode(ValueAnimator.RESTART);
        avatarAnimation2.setRepeatCount(ValueAnimator.INFINITE);
        avatarAnimation2.setStartDelay(8666);
        avatarAnimation2.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                randomizeAvatarPosition(mAvatarTwo);
                mAvatarTwo.setImageResource(getNextAvatar());
            }
        });
        avatarAnimation2.start();
    }

    private int getAvatarRandomTime() {
        return new Random().nextInt(2500 - 2000) + 2000;
    }

    private int mAvatarResourcesIndex = 0;

    synchronized private int getNextAvatar() {
        int result = mAvatarResources.get(mAvatarResourcesIndex);
        mAvatarResourcesIndex = ++mAvatarResourcesIndex % mAvatarResources.size();
        return result;
    }

    private void randomizeAvatarPosition(View view) {
        FrameLayout.LayoutParams params = (LayoutParams) view.getLayoutParams();
        int width = 720; //getWidth();
        int height = 880; //getHeight();
        int minMargin = getContext().getResources().getDimensionPixelOffset(
                R.dimen.postajob_animation_avatar_min_layout_margin);


        int newWidth = new Random().nextInt(width - minMargin) + minMargin + getLeft();
        int newHeight = new Random().nextInt(height - minMargin) + minMargin + getTop();
        Log.d("Animation", "Random width: " + newWidth + " : randomHeight: " + newHeight);

        params.topMargin = newHeight;
        params.leftMargin = newWidth;
        view.setLayoutParams(params);
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public static ObjectAnimator getAvatarAnimation(View view, int millis) {
        PropertyValuesHolder pvhScaleX = PropertyValuesHolder.ofKeyframe(View.SCALE_X,
                Keyframe.ofFloat(0f, 0.01f),
                Keyframe.ofFloat(.035f, 0.45f),
                Keyframe.ofFloat(.07f, 1.1f),
                Keyframe.ofFloat(.09f, 1f),
                Keyframe.ofFloat(.93f, .9f),
                Keyframe.ofFloat(1f, 0f)
        );

        PropertyValuesHolder pvhScaleY = PropertyValuesHolder.ofKeyframe(View.SCALE_Y,
                Keyframe.ofFloat(0f, 0.01f),
                Keyframe.ofFloat(.035f, 0.45f),
                Keyframe.ofFloat(.07f, 1.1f),
                Keyframe.ofFloat(.09f, 1f),
                Keyframe.ofFloat(.93f, .9f),
                Keyframe.ofFloat(1f, 0f)
        );

        PropertyValuesHolder pvhCustom = PropertyValuesHolder.ofKeyframe("mode",
                Keyframe.ofInt(0f, 0),
                Keyframe.ofInt(.07f, 1),
                Keyframe.ofInt(.93f, 1),
                Keyframe.ofInt(1f, 0)
        );

        PropertyValuesHolder pvhTranslateX = PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X,
                Keyframe.ofFloat(0f, 0f),
                Keyframe.ofFloat(.1f, 0f),
                Keyframe.ofFloat(.8f, .05f),
                Keyframe.ofFloat(1f, .05f)
        );

        PropertyValuesHolder pvhTranslateY = PropertyValuesHolder.ofKeyframe(View.TRANSLATION_Y,
                Keyframe.ofFloat(0f, 0f),
                Keyframe.ofFloat(.1f, 0f),
                Keyframe.ofFloat(.8f, .05f),
                Keyframe.ofFloat(1f, .05f)
        );

        return ObjectAnimator.ofPropertyValuesHolder(view, pvhScaleX, pvhScaleY).
                setDuration(millis);
    }

    private void renderEditMode() {
        mCircleOne.setVisibility(VISIBLE);
        mCircleOne.setScaleX(3f);
        mCircleOne.setScaleY(3f);
    }
}
