package pulltorefresh;

/**
 * 刷新加载回调接口
 *
 * @author chenjing
 *
 */
public interface OnRefreshListener
{
    /**
     * 刷新操作
     */
    void onRefresh(PullToRefreshLayout pullToRefreshLayout);

    /**
     * 加载操作
     */
    void onLoadMore(PullToRefreshLayout pullToRefreshLayout);
}
