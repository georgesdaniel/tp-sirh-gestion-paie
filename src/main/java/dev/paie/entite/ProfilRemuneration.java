package dev.paie.entite;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "ProfilRemuneration")
public class ProfilRemuneration {
	@Id
	private Integer id;
	private String code;
    
	@ManyToMany
	@JoinTable(name = "PRF_COT_NOT_IMP", 
	joinColumns = @JoinColumn(name = "ID_PRF", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "COT_ID", referencedColumnName = "ID")
	)
	private List<Cotisation> cotisationsNonImposables;

	@ManyToMany
	@JoinTable(name = "PRF_COT_IMP", joinColumns =
	@JoinColumn(name = "ID_PRF", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "COT_ID", referencedColumnName = "ID")
	)
	private List<Cotisation> cotisationsImposables;

	@Transient  //(mappedBy = "profilRemuneration")
	private List<Avantage> avantages;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

}
