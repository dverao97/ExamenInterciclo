package com.example.ExamenPracticoM5B.service;

import com.example.ExamenPracticoM5B.model.Producto;
import com.example.ExamenPracticoM5B.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto,Integer> implements ProductoService{
    @Autowired
    ProductoRepository productoRepository;
    @Override
    public CrudRepository<Producto, Integer> getDao() {
        return productoRepository;
    }
}
