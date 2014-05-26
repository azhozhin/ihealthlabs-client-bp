package com.ihealthlabs.client.bp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BPDataResponse extends ResponseBase {

    @JsonProperty("BPDataList")
    private List<BPDataItem> bpDataList;

    // The url of next page
    @JsonProperty("NextPageUrl")
    private String nextPageUrl;

    //The count of current page
    @JsonProperty("CurrentRecordCount")
    private int currentRecordCount;

    // The length of one page
    @JsonProperty("PageLength")
    private int pageLength;

    // The total page count of data records
    @JsonProperty("PageNumber")
    private int pageNumber;

    // The url of previous page
    @JsonProperty("PrevPageUrl")
    private String prevPageUrl;

    // The total number of data records
    @JsonProperty("RecordCount")
    private int recordCount;

    // The unit of blood pressure
    @JsonProperty("BPUnit")
    private int bpUnit;

    public List<BPDataItem> getBpDataList() {
        return bpDataList;
    }

    public void setBpDataList(List<BPDataItem> bpDataList) {
        this.bpDataList = bpDataList;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public int getCurrentRecordCount() {
        return currentRecordCount;
    }

    public void setCurrentRecordCount(int currentRecordCount) {
        this.currentRecordCount = currentRecordCount;
    }

    public int getPageLength() {
        return pageLength;
    }

    public void setPageLength(int pageLength) {
        this.pageLength = pageLength;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPrevPageUrl() {
        return prevPageUrl;
    }

    public void setPrevPageUrl(String prevPageUrl) {
        this.prevPageUrl = prevPageUrl;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getBpUnit() {
        return bpUnit;
    }

    public void setBpUnit(int bpUnit) {
        this.bpUnit = bpUnit;
    }
}
