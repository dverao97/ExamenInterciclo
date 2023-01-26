package com.example.ExamenPracticoM5B.controller;

import com.example.ExamenPracticoM5B.model.Producto;
import com.example.ExamenPracticoM5B.repository.ProductoRepository;
import com.example.ExamenPracticoM5B.service.ProductoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping("/producto")
    public ResponseEntity<List<Producto>> ObtenerProducto(){
        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/producto")
    public ResponseEntity<Producto>Crear(@RequestBody Producto p){
        return  new ResponseEntity<>(productoService.save(p),HttpStatus.CREATED);
    }

    @PutMapping("/producto/{codigo}")
    public ResponseEntity<Producto>Actualizar(@PathVariable Integer codigo,@RequestBody Producto p){
        if (productoService.findById(codigo)==null){
            return ResponseEntity.notFound().build();
        }
        Producto pr=productoService.findById(codigo);
        pr.setCantidad(p.getCantidad());
        pr.setDescripcion(p.getDescripcion());
        pr.setPrecio(p.getPrecio());
        return new ResponseEntity<>(productoService.save(pr),HttpStatus.CREATED);
    }
    @DeleteMapping("/producto/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void Eliminar(@PathVariable Integer codigo){
        productoService.delete(codigo);
    }
}
