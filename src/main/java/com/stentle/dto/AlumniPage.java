package com.stentle.dto;

import com.stentle.domain.collections.Alumnus;

import java.util.List;

/**
 * Created by gioiaballin on 08/11/15.
 */
public class AlumniPage {

    private long totalCount;
    private int totalPages;
    private int page;
    private List<Alumnus> data;

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public void setData(List<Alumnus> data) {
        this.data = data;
    }

    public List<Alumnus> getData() {
        return data;
    }
}
