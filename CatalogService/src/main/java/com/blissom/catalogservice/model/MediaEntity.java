package com.blissom.catalogservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MediaEntity {

    @Id
    private String mediaId;

    private String mediaURL;

    private String mediaType;

    private String mediaName;

    private String mediaDescription;

    private String mediaSize;

    private Integer mediaWidth;

    private Integer mediaHeight;

    private Integer mediaDuration;

    private String mediaFormat;

    private String mediaThumbnail;

    private String mediaStatus;

    private String mediaVisibility;

    private String mediaLocation;

    private String mediaCategory;

    private String mediaSubCategory;

    private String mediaTags;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceEntity service;

    public MediaEntity() {
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaURL() {
        return mediaURL;
    }

    public void setMediaURL(String mediaURL) {
        this.mediaURL = mediaURL;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public String getMediaDescription() {
        return mediaDescription;
    }

    public void setMediaDescription(String mediaDescription) {
        this.mediaDescription = mediaDescription;
    }

    public String getMediaSize() {
        return mediaSize;
    }

    public void setMediaSize(String mediaSize) {
        this.mediaSize = mediaSize;
    }

    public Integer getMediaWidth() {
        return mediaWidth;
    }

    public void setMediaWidth(Integer mediaWidth) {
        this.mediaWidth = mediaWidth;
    }

    public Integer getMediaHeight() {
        return mediaHeight;
    }

    public void setMediaHeight(Integer mediaHeight) {
        this.mediaHeight = mediaHeight;
    }

    public Integer getMediaDuration() {
        return mediaDuration;
    }

    public void setMediaDuration(Integer mediaDuration) {
        this.mediaDuration = mediaDuration;
    }

    public String getMediaFormat() {
        return mediaFormat;
    }

    public void setMediaFormat(String mediaFormat) {
        this.mediaFormat = mediaFormat;
    }

    public String getMediaThumbnail() {
        return mediaThumbnail;
    }

    public void setMediaThumbnail(String mediaThumbnail) {
        this.mediaThumbnail = mediaThumbnail;
    }

    public String getMediaStatus() {
        return mediaStatus;
    }

    public void setMediaStatus(String mediaStatus) {
        this.mediaStatus = mediaStatus;
    }

    public String getMediaVisibility() {
        return mediaVisibility;
    }

    public void setMediaVisibility(String mediaVisibility) {
        this.mediaVisibility = mediaVisibility;
    }

    public String getMediaLocation() {
        return mediaLocation;
    }

    public void setMediaLocation(String mediaLocation) {
        this.mediaLocation = mediaLocation;
    }

    public String getMediaCategory() {
        return mediaCategory;
    }

    public void setMediaCategory(String mediaCategory) {
        this.mediaCategory = mediaCategory;
    }

    public String getMediaSubCategory() {
        return mediaSubCategory;
    }

    public void setMediaSubCategory(String mediaSubCategory) {
        this.mediaSubCategory = mediaSubCategory;
    }

    public String getMediaTags() {
        return mediaTags;
    }

    public void setMediaTags(String mediaTags) {
        this.mediaTags = mediaTags;
    }

    public ServiceEntity getService() {
        return service;
    }

    public void setService(ServiceEntity service) {
        this.service = service;
    }

}


