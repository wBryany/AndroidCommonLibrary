package pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public class PullableWebView extends WebView implements Pullable {


    private boolean canPullDown = true;
    private boolean canPullUp = true;


    public PullableWebView(Context context) {
        super(context);
    }

    public PullableWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullableWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean canPullDown() {

        if(canPullDown){
            if (getScrollY() == 0)
                return true;
            else
                return false;
        }else{
            return  false;
        }

    }

    @Override

    public boolean canPullUp() {

        int scrollY = getScrollY();
        int contentHeight = getContentHeight();
        float scale = getScale();
        int measuredHeight = getMeasuredHeight();

        if(canPullUp){
            if (getScrollY() >= getContentHeight() * getScale()-10 - getMeasuredHeight())
                return true;
            else
                return false;
        }else{
            return  false;
        }

    }


    public void setCanPullDown(boolean canPullDown) {
        this.canPullDown = canPullDown;
    }

    public void setCanPullUp(boolean canPullUp) {
        this.canPullUp = canPullUp;
    }


}
