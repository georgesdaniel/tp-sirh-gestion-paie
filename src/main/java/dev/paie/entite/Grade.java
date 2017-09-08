package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GRADES")
public class Grade {
	
	/** id : Integer */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/** code : String */
	@Column(name="CODE")
	private String code;
	
	/** nbHeuresBase : BigDecimal */
	@Column(name="NB_HEURES_BASE")
	private BigDecimal nbHeuresBase;
	
	/** tauxBase : BigDecimal */
	@Column(name="TAUX_BASE")
	private BigDecimal tauxBase;
	
	/**
	 * Constructeur @Entity
	 */
	public Grade() {
	}
	
	/** Constructeur 
	 * @param code code
	 * @param nbHeuresBase nombre d'heures de base
	 * @param tauxBase taux de base
	 */
	public Grade(String code, BigDecimal nbHeuresBase, BigDecimal tauxBase) {
		super();
		this.code = code;
		this.nbHeuresBase = nbHeuresBase;
		this.tauxBase = tauxBase;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getNbHeuresBase() {
		return nbHeuresBase;
	}
	public void setNbHeuresBase(BigDecimal nbHeuresBase) {
		this.nbHeuresBase = nbHeuresBase;
	}
	public BigDecimal getTauxBase() {
		return tauxBase;
	}
	public void setTauxBase(BigDecimal tauxBase) {
		this.tauxBase = tauxBase;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	

}