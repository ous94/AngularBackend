package com.base.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="document")
public class Document implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Column(name = "name")
	private String name;
    
    @Column(name = "namefile")
    private String namefile;
    
    @Column(name = "logo")
     private byte[] logo;
    

	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//constructeur
	public Document(String name, String namefile, byte[] logo) {
		super();
		this.name = name;
		this.namefile = namefile;
		this.logo = logo;
	}



	public Document(Long id, String name, String namefile, byte[] logo) {
		super();
		this.id = id;
		this.name = name;
		this.namefile = namefile;
		this.logo = logo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNamefile() {
		return namefile;
	}


	public void setNamefile(String namefile) {
		this.namefile = namefile;
	}


	public byte[] getLogo() {
		return logo;
	}


	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	






	
}