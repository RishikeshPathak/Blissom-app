package com.blissom.catalogservice.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceResponse {

    private String serviceId;
    private String serviceName;
    private String serviceDescription;
    private boolean isActive;
    private List<MediaResponse> media;
    private List<ServicePriceResponse> prices;
    private List<TagResponse> tags;
    private BigDecimal price;
    
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public List<MediaResponse> getMedia() {
		return media;
	}
	public void setMedia(List<MediaResponse> media) {
		this.media = media;
	}
	public List<ServicePriceResponse> getPrices() {
		return prices;
	}
	public void setPrices(List<ServicePriceResponse> prices) {
		this.prices = prices;
	}
	public List<TagResponse> getTags() {
		return tags;
	}
	public void setTags(List<TagResponse> tags) {
		this.tags = tags;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

    
}

