package tech.luigui.katas;

import java.util.List;

public class PaginationHelper<I> {

    private final List<I> collection;
    private final int itemsPerPage;

    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        double division = ((double) collection.size())/itemsPerPage;
        return (int) Math.ceil(division);
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if(outOfRangePageIndex(pageIndex)) {
            return -1;
        } else if(pageIndex == pageCount() - 1) {
            return itemCount() % itemsPerPage;
        } else {
            return itemsPerPage;
        }
    }

    private boolean outOfRangePageIndex(int pageIndex) {
        return pageIndex < 0 || pageIndex >= pageCount();
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if(itemIndex < 0 || itemIndex >= itemCount()) {
            return -1;
        } else {
            return (int) Math.floor(((double) itemIndex) / itemsPerPage);
        }
    }
}
