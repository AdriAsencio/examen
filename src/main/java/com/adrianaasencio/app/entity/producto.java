package com.adrianaasencio.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class producto implements Serializable{

		
		private static final long serialVersionUID = 3817750875136419234L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY )
		private Long id; 
		
		@Column(name="descripcion",nullable=false, length = 100)
		private String descri;
		
		@Column(name="precio", nullable=false, length = 10)
		private float pess;
		
		@Column(name="cantidad", nullable=false, length = 10 )
		private int canti;
		
		private float total;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDescri() {
			return descri;
		}

		public void setDescri(String descri) {
			this.descri = descri;
		}

		public float getPess() {
			return pess;
		}

		public void setPess(float pess) {
			this.pess = pess;
		}

		public int getCanti() {
			return canti;
		}

		public void setCanti(int canti) {
			this.canti = canti;
		}

		public float getTotal() {
			return total;
		}

		public void setTotal(float total) {
			this.total = total;
		}
		
		
		
		
		
}
