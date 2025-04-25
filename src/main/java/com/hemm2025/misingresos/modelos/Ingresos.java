/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemm2025.misingresos.modelos;


import java.math.BigDecimal;
import java.util.Date;


/**
 *
 * @author Administrator
 */
public class Ingresos {

   
    private Integer id;
  
    private String detalle;
  
    private Date fecha;
 
    private BigDecimal monto;
  
    private int idtipo;
 

    public Ingresos() {
    }

    public Ingresos(Integer id, String detalle, Date fecha, BigDecimal monto, int idtipo) {
        this.id = id;
        this.detalle = detalle;
        this.fecha = fecha;
        this.monto = monto;
        this.idtipo = idtipo;
    }

    public Ingresos(String detalle, Date fecha, BigDecimal monto, int idtipo) {
        this.detalle = detalle;
        this.fecha = fecha;
        this.monto = monto;
        this.idtipo = idtipo;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingresos)) {
            return false;
        }
        Ingresos other = (Ingresos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hemm2025.misingresos.modelos.Ingresos[ id=" + id + " ]";
    }
    
}
