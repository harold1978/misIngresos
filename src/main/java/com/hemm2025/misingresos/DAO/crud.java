/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hemm2025.misingresos.DAO;

import java.util.List;

/**
 *
 * @author Administrator
 */
public interface crud<T> {
    public List<T> listar();
    public T get(int id);
    public boolean agregar(T obj);
    public boolean editar(T obj);
    public boolean eliminar(T obj);
}
