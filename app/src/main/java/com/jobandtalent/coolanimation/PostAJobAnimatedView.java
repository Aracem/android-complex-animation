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
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.FrameLayout;

import java.util.Random;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PostAJobAnimatedView extends FrameLayout {

    private static final int CIRCLE_ANIMATION_TIME = 5000;
    private static final int CIRCLE_ANIMATION_DELAY_ONE = 1666;
    private static final int CIRCLE_ANIMATION_DELAY_TWO = 3333;
    private static final int AVATAR_ANIMATION_MAX_TIME = 2500;
    private static final int AVATAR_ANIMATION_MIN_TIME = 2000;
    private static final int AVATAR_FIRST_DELAY = 1500;
    private static final int AVATAR_SECOND_DELAY = 8666;

    @InjectView(R.id.v_circle_1) View circleOne;
    @InjectView(R.id.v_circle_2) View circleTwo;
    @InjectView(R.id.v_circle_3) View circleThree;
    @InjectView(R.id.v_avatar_1) PostAJobAnimationCircleImageView avatarOne;
    @InjectView(R.id.v_avatar_2) PostAJobAnimationCircleImageView avatarTwo;

    private static SparseIntArray avatarResources;
    private boolean isViewReady = false;
    private boolean isWaitingToStart = false;
    private int minAvatarMargin = 0;
    private int avatarSize = 0;
    private int avatarResourcesIndex = 0;

    static {
        avatarResources = new SparseIntArray();

        avatarResources.put(0, R.drawable.avatar_1);
        avatarResources.put(1, R.drawable.avatar_2);
        avatarResources.put(2, R.drawable.avatar_3);
        avatarResources.put(3, R.drawable.avatar_4);
        avatarResources.put(4, R.drawable.avatar_5);
        avatarResources.put(5, R.drawable.avatar_6);
        avatarResources.put(6, R.drawable.avatar_7);
        avatarResources.put(7, R.drawable.avatar_8);
        avatarResources.put(8, R.drawable.avatar_9);
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
        }
    }

    public void startAnimation() {
        if (isViewReady) {
            isWaitingToStart = false;
            calculateDefaultSizes();
            launchCirclesAnimation();
            launchAvatarsAnimation();
        } else {
            isWaitingToStart = true;
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        isViewReady = true;
        if (isWaitingToStart) {
            startAnimation();
        }
    }

    private void launchCirclesAnimation() {
        circleTwo.setScaleX(0f);
        circleTwo.setScaleY(0f);
        circleThree.setScaleX(0f);
        circleThree.setScaleY(0f);

        ObjectAnimator animator = getCircleAnimation(circleOne, CIRCLE_ANIMATION_TIME);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new FastOutLinearInInterpolator());
        animator.start();

        ObjectAnimator animator2 = getCircleAnimation(circleTwo, CIRCLE_ANIMATION_TIME);
        animator2.setStartDelay(CIRCLE_ANIMATION_DELAY_ONE);
        animator2.setRepeatMode(ValueAnimator.RESTART);
        animator2.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new BounceInterpolator());
        animator2.start();

        ObjectAnimator animator3 = getCircleAnimation(circleThree, CIRCLE_ANIMATION_TIME);
        animator3.setStartDelay(CIRCLE_ANIMATION_DELAY_TWO);
        animator3.setRepeatMode(ValueAnimator.RESTART);
        animator3.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator3.start();
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private ObjectAnimator getCircleAnimation(View view, int millis) {
        PropertyValuesHolder pvhScaleX = PropertyValuesHolder.ofKeyframe(View.SCALE_X,
                Keyframe.ofFloat(0f, 0.01f),
                Keyframe.ofFloat(.2f, .65f),
                Keyframe.ofFloat(.3f, .84f),
                Keyframe.ofFloat(.35f, .87f),
                Keyframe.ofFloat(.4f, .895f),
                Keyframe.ofFloat(.45f, .915f),
                Keyframe.ofFloat(.5f, .930f),
                Keyframe.ofFloat(.55f, .940f),
                Keyframe.ofFloat(.6f, .945f),
                Keyframe.ofFloat(1f, 1f)
        );

        PropertyValuesHolder pvhScaleY = PropertyValuesHolder.ofKeyframe(View.SCALE_Y,
                Keyframe.ofFloat(0f, 0.01f),
                Keyframe.ofFloat(.2f, .65f),
                Keyframe.ofFloat(.3f, .84f),
                Keyframe.ofFloat(.35f, .87f),
                Keyframe.ofFloat(.4f, .895f),
                Keyframe.ofFloat(.45f, .915f),
                Keyframe.ofFloat(.5f, .930f),
                Keyframe.ofFloat(.55f, .940f),
                Keyframe.ofFloat(.6f, .945f),
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
        avatarOne.setScaleX(0f);
        avatarOne.setScaleY(0f);
        avatarTwo.setScaleX(0f);
        avatarTwo.setScaleY(0f);

        avatarOne.setImageResource(getNextAvatar());
        randomizeAvatarPosition(avatarOne);
        ObjectAnimator avatarAnimation = getAvatarAnimation(avatarOne, getAvatarRandomTime());
        avatarAnimation.setRepeatMode(ValueAnimator.RESTART);
        avatarAnimation.setRepeatCount(ValueAnimator.INFINITE);
        avatarAnimation.setStartDelay(AVATAR_FIRST_DELAY);
        avatarAnimation.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                randomizeAvatarPosition(avatarOne);
                avatarOne.setImageResource(getNextAvatar());
            }
        });
        avatarAnimation.start();

        avatarTwo.setImageResource(getNextAvatar());
        randomizeAvatarPosition(avatarTwo);
        ObjectAnimator avatarAnimation2 = getAvatarAnimation(avatarTwo, getAvatarRandomTime());
        avatarAnimation2.setRepeatMode(ValueAnimator.RESTART);
        avatarAnimation2.setRepeatCount(ValueAnimator.INFINITE);
        avatarAnimation2.setStartDelay(AVATAR_SECOND_DELAY);
        avatarAnimation2.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                randomizeAvatarPosition(avatarTwo);
                avatarTwo.setImageResource(getNextAvatar());
            }
        });
        avatarAnimation2.start();
    }

    private int getAvatarRandomTime() {
        return new Random().nextInt(AVATAR_ANIMATION_MAX_TIME - AVATAR_ANIMATION_MIN_TIME) + AVATAR_ANIMATION_MIN_TIME;
    }

    synchronized private int getNextAvatar() {
        int result = avatarResources.get(avatarResourcesIndex);
        avatarResourcesIndex = ++avatarResourcesIndex % avatarResources.size();
        return result;
    }

    private void randomizeAvatarPosition(View view) {
        FrameLayout.LayoutParams params = (LayoutParams) view.getLayoutParams();
        int width = getWidth();
        int height = getHeight();
        int newWidth = new Random().nextInt(width - minAvatarMargin - avatarSize) + minAvatarMargin;
        int newHeight = new Random().nextInt(height - minAvatarMargin - avatarSize) + minAvatarMargin;

        params.topMargin = newHeight;
        params.leftMargin = newWidth;
        view.setLayoutParams(params);
    }

    private void calculateDefaultSizes() {
        minAvatarMargin = getContext().getResources().getDimensionPixelOffset(
                R.dimen.postajob_animation_avatar_min_layout_margin);
        avatarSize = getContext().getResources().getDimensionPixelSize(
                R.dimen.postajob_animation_avatar);
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private ObjectAnimator getAvatarAnimation(View view, int millis) {
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

        return ObjectAnimator.ofPropertyValuesHolder(view, pvhScaleX, pvhScaleY).
                setDuration(millis);
    }

    private void renderEditMode() {
        circleOne.setVisibility(VISIBLE);
        circleOne.setScaleX(3f);
        circleOne.setScaleY(3f);
    }
}
