package com.soch.Integra.vendors.dto;

import java.util.List;

import com.soch.Integra.dto.APMBaseResponse;
import com.soch.Integra.dto.PrecinctTypeDTO;
import com.soch.Integra.dto.VendorsDTO;

public class SolutionOnLoadResp extends APMBaseResponse{
	List<VendorsDTO> vendorsDTOs;
	List<SystemTypeDTO> systemTypeDTOs;
	List<LabVendorsDTO> labVendorsDTOs;
	List<HostingTypeDTO> hostingTypeDTOs;
	List<SolutionTypeDTO> solutionTypeDTOs;
	List<PrecinctTypeDTO> precinctTypeDTOs;
	
	public List<VendorsDTO> getVendorsDTOs() {
		return vendorsDTOs;
	}
	public void setVendorsDTOs(List<VendorsDTO> vendorsDTOs) {
		this.vendorsDTOs = vendorsDTOs;
	}
	public List<SystemTypeDTO> getSystemTypeDTOs() {
		return systemTypeDTOs;
	}
	public void setSystemTypeDTOs(List<SystemTypeDTO> systemTypeDTOs) {
		this.systemTypeDTOs = systemTypeDTOs;
	}
	public List<LabVendorsDTO> getLabVendorsDTOs() {
		return labVendorsDTOs;
	}
	public void setLabVendorsDTOs(List<LabVendorsDTO> labVendorsDTOs) {
		this.labVendorsDTOs = labVendorsDTOs;
	}
	public List<SolutionTypeDTO> getSolutionTypeDTOs() {
		return solutionTypeDTOs;
	}
	public void setSolutionTypeDTOs(List<SolutionTypeDTO> solutionTypeDTOs) {
		this.solutionTypeDTOs = solutionTypeDTOs;
	}
	public List<HostingTypeDTO> getHostingTypeDTOs() {
		return hostingTypeDTOs;
	}
	public void setHostingTypeDTOs(List<HostingTypeDTO> hostingTypeDTOs) {
		this.hostingTypeDTOs = hostingTypeDTOs;
	}
	public List<PrecinctTypeDTO> getPrecinctTypeDTOs() {
		return precinctTypeDTOs;
	}
	public void setPrecinctTypeDTOs(List<PrecinctTypeDTO> precinctTypeDTOs) {
		this.precinctTypeDTOs = precinctTypeDTOs;
	}
	
}
