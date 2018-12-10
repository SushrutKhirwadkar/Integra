package com.soch.Integra.vendors.dto;

import java.util.List;

import com.soch.Integra.dto.APMBaseResponse;
import com.soch.Integra.dto.VendorsDTO;

public class VendorResponse extends APMBaseResponse{
	
	List<VendorsDTO> vendorsDTOs;

	public List<VendorsDTO> getVendorsDTOs() {
		return vendorsDTOs;
	}

	public void setVendorsDTOs(List<VendorsDTO> vendorsDTOs) {
		this.vendorsDTOs = vendorsDTOs;
	}
	
	

}
