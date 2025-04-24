/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemm2025.misingresos.DAO;

import com.hemm2025.misingresos.conexion.conexion;
import com.hemm2025.misingresos.modelos.Tipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class tipoDAO implements crud<Tipo> {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Tipo tipo;

    @Override
    public Tipo get(int id) {
        Tipo t = null;
        String sql = "select * from tipo where id=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                t = new Tipo(rs.getInt("id"), rs.getString("nombre"), rs.getInt("clase"));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return t;
    }

    @Override
    public boolean eliminar(Tipo obj) {
        String sql = "delete from tipo where id=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean agregar(Tipo obj) {
        String sql = "insert into tipo (nombre,clase)values(?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNombre());
            ps.setInt(2, obj.getClase());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Tipo> listar() {
        List<Tipo> lista = new ArrayList();
        String sql = "Select * from tipo";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                tipo = new Tipo(rs.getInt("id"), rs.getString("nombre"), rs.getInt("clase"));
                lista.add(tipo);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }

    @Override
    public boolean editar(Tipo obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
