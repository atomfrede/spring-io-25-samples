package com.github.atomfrede.jdconf_sample.pagination;

import org.springframework.data.domain.Page;

public class PagerModel {

    private int buttonsToShow = 5;
    private int startPage;
    private int endPage;

    public static PagerModel fromPage(Page<?> page) {
        return new PagerModel(page.getTotalPages(), page.getPageable().getPageNumber() + 1, 3);
    }

    public static PagerModel fromPage(Page<?> page, int buttonsToShow) {
        return new PagerModel(page.getTotalPages(), page.getPageable().getPageNumber() + 1, buttonsToShow);
    }

    public PagerModel(int totalPages, int currentPage, int buttonsToShow) {
        this.buttonsToShow = buttonsToShow;
        int halfPagesToShow = getButtonsToShow() / 2;

        if (totalPages <= getButtonsToShow()) {
            this.startPage = 1;
            setEndPage(totalPages);
        } else if (currentPage - halfPagesToShow <= 0) {
            setStartPage(1);
            setEndPage(getButtonsToShow());
        } else if (currentPage + halfPagesToShow == totalPages) {
            setStartPage(currentPage - halfPagesToShow);
            setEndPage(totalPages);
        } else if (currentPage + halfPagesToShow > totalPages) {
            setStartPage(totalPages - getButtonsToShow() + 1);
            setEndPage(totalPages);
        } else {
            setStartPage(currentPage - halfPagesToShow);
            setEndPage(currentPage + halfPagesToShow);
        }
    }

    public int getButtonsToShow() {
        return buttonsToShow;
    }

    public void setButtonsToShow(int buttonsToShow) {
        if (buttonsToShow % 2 != 0) {
            this.buttonsToShow = buttonsToShow;
        } else {
            throw new IllegalArgumentException("Must be an odd value!");
        }
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    @Override
    public String toString() {
        return "Pager [startPage=%s, endPage=%s]".formatted(startPage, endPage);
    }
}
