/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemm2025.misingresos.DAO;

import com.hemm2025.misingresos.conexion.conexion;
import com.hemm2025.misingresos.modelos.Ingresos;
import com.hemm2025.misingresos.modelos.Tipo;
import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ingresoDAO implements crud<Ingresos> {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Ingresos ingreso;
    String sql_get = "select * from ingresos where id=?";
    String sql_del = "delete from ingresos where id=?";
    String sql_insert = "insert into ingresos (detalle,fecha,monto,idtipo)values(?,?,?,?)";
    String sql_all = "Select * from ingresos";
    String sql_update = "update ingresos set detalle=?, fecha=?,monto=?,idtipo=? where id=?";

    @Override
    public List<Ingresos> listar() {
        List<Ingresos> lista = new ArrayList();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql_all);
            rs = ps.executeQuery();
            while (rs.next()) {
                ingreso = new Ingresos(rs.getString("detalle"), rs.getDate("fecha"), rs.getBigDecimal("monto"), rs.getInt("idtipo"));
                lista.add(ingreso);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public Ingresos get(int id) {
        Ingresos i = null;

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql_get);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                i = new Ingresos(rs.getString("detalle"), rs.getDate("fecha"), rs.getBigDecimal("monto"), rs.getInt("idtipo"));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return i;
    }

    @Override
    public boolean agregar(Ingresos obj) {
         
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql_insert);
            ps.setString(1, obj.getDetalle());
            ps.setDate(2, (Date) obj.getFecha());
            ps.setBigDecimal(3, obj.getMonto());
            ps.setInt(4, obj.getIdtipo());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }    }

    @Override
    public boolean editar(Ingresos obj) {
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql_update);
            ps.setString(1, obj.getDetalle());
            ps.setDate(2, (Date)obj.getFecha());
            ps.setBigDecimal(3, obj.getMonto());
            ps.setInt(4, obj.getIdtipo());
            ps.setInt(5, obj.getId());
            
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }    }

    @Override
    public boolean eliminar(Ingresos obj) {
  
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql_del);
            ps.setInt(1, obj.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }    }

}
