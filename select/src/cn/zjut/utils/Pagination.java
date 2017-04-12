package cn.zjut.utils;

import java.io.Serializable;  
import java.util.List;  
  
/**  
 * ���ݷ�ҳ��  
 *   
 * @author GST  
 * @version 1.0, 2006-12-30  
 */  
  
public class Pagination<T> implements Serializable {  
  
    private static final long serialVersionUID = -5884976706259160221L;  
    /**  
     * ��һҳ  
     */  
    private long preIndex;  
    /**  
     * ��ǰҳ  
     */  
    private long curIndex;  
    /**  
     * ��һҳ  
     */  
    private long nextIndex;  
    /**  
     * ÿҳ����  
     */  
    private long pageSize;  
    /**  
     * ������  
     */  
    private long rowsCount;  
  
    public void setPreIndex(long preIndex) {  
        this.preIndex = preIndex;  
    }  
  
    public void setCurIndex(long curIndex) {  
        this.curIndex = curIndex;  
    }  
  
    public void setNextIndex(long nextIndex) {  
        this.nextIndex = nextIndex;  
    }  
  
    public void setPageSize(long pageSize) {  
        this.pageSize = pageSize;  
    }  
  
    /**  
     * ��ҳ��  
     */  
    private long pagesCount;  
    /**  
     * �����б�  
     */  
    private List<T> items;  
  
    /**  
     *   
     * ��ҳ�๹������  
     *   
     */  
    public Pagination() {  
        updateInfo(0, 0, 0);  
    }  
  
    /**  
     *   
     * ��ҳ�๹������  
     *   
     * @param pageIndex  
     *            ��ǰҳ��  
     * @param pageSize  
     *            ÿҳ��¼��  
     */  
    public Pagination(long pageIndex, long pageSize) {  
        updateInfo(pageIndex, pageSize, 0);  
    }  
  
    /**  
     * ��ҳ�๹������  
     *   
     * @param pageIndex  
     *            ��ǰҳ��  
     * @param pageSize  
     *            ÿҳ��¼��  
     * @param rowsCount  
     *            ��¼����  
     */  
    public Pagination(long pageIndex, long pageSize, long rowsCount) {  
        updateInfo(pageIndex, pageSize, rowsCount);  
    }  
  
    /**  
     * ��ȡ��ǰ���¼  
     *   
     * @return  
     */  
    public List<T> getItems() {  
        return items;  
    }  
  
    /**  
     * ���õ�ǰҳ��¼  
     *   
     * @param items  
     */  
    public void setItems(List<T> items) {  
        this.items = items;  
    }  
  
    /**  
     * ��ȡ��ǰҳ��  
     *   
     * @return  
     */  
    public long getCurIndex() {  
        return curIndex;  
    }  
  
    /**  
     * ��ȡ��һҳ��  
     *   
     * @return  
     */  
    public long getNextIndex() {  
        return nextIndex;  
    }  
  
    /**  
     * ��ȡ��ҳ��  
     *   
     * @return  
     */  
    public long getPagesCount() {  
        return pagesCount;  
    }  
  
    /**  
     * ��ȡÿҳ��¼��  
     *   
     * @return  
     */  
    public long getPageSize() {  
        return pageSize;  
    }  
  
    /**  
     * ��ȡ��һҳ��  
     *   
     * @return  
     */  
    public long getPreIndex() {  
        return preIndex;  
    }  
  
    /**  
     * ��ȡ�ܼ�¼��  
     *   
     * @return  
     */  
    public long getRowsCount() {  
        return rowsCount;  
    }  
  
    /**  
     * ��ȡ��ҳ��  
     *   
     * @return  
     */  
    public long getFirstIndex() {  
        return 1;  
    }  
  
    /**  
     * ��ȡĩҳ��  
     *   
     * @return  
     */  
    public long getLastIndex() {  
        return pagesCount;  
    }  
  
    private void updateInfo(long pageIndex, long pageSize, long rowsCount) {  
  
        if (pageSize > 0) {  
  
            this.curIndex = pageIndex;  
            this.rowsCount = rowsCount;  
            this.pageSize = pageSize;  
  
            // ȷ��ҳ��  
            pagesCount = (rowsCount + pageSize - 1) / pageSize;  
            // ȷ����ǰҳ��  
            if (curIndex <= 0)  
                curIndex = 1;  
            if (curIndex > pagesCount)  
                curIndex = pagesCount;  
            // ȷ����һҳ��  
            nextIndex = curIndex + 1;  
            if (nextIndex > pagesCount)  
                nextIndex = pagesCount;  
            // ȷ����һҳ��  
            preIndex = curIndex - 1;  
            if (preIndex <= 0)  
                preIndex = 1;  
        } else {  
            this.preIndex = 1;  
            this.curIndex = 1;  
            this.nextIndex = 1;  
            this.pageSize = 0;  
            this.pagesCount = 1;  
        }  
    }  
  
    /**  
     * �����ܼ�¼��  
     *   
     * @param rowsCount  
     */  
    public void setRowsCount(long rowsCount) {  
        updateInfo(curIndex, pageSize, rowsCount);  
    }  
  
    /**  
     * ������ҳ��  
     *   
     * @param pagesCount  
     */  
    public void setPagesCount(long pagesCount) {  
        this.pagesCount = pagesCount;  
    }  
  
}
