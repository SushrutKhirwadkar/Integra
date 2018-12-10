package com.soch.Integra.entities;


public class DivisionEntitiesId implements java.io.Serializable {

	private int divisionId;
	private int officeTblOfficeId;

	public DivisionEntitiesId() {
	}

	public DivisionEntitiesId(int divisionId, int officeTblOfficeId) {
		this.divisionId = divisionId;
		this.officeTblOfficeId = officeTblOfficeId;
	}


	public int getDivisionId() {
		return this.divisionId;
	}

	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}

	public int getOfficeTblOfficeId() {
		return this.officeTblOfficeId;
	}

	public void setOfficeTblOfficeId(int officeTblOfficeId) {
		this.officeTblOfficeId = officeTblOfficeId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DivisionEntitiesId))
			return false;
		DivisionEntitiesId castOther = (DivisionEntitiesId) other;

		return (this.getDivisionId() == castOther.getDivisionId())
				&& (this.getOfficeTblOfficeId() == castOther.getOfficeTblOfficeId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getDivisionId();
		result = 37 * result + this.getOfficeTblOfficeId();
		return result;
	}

}
