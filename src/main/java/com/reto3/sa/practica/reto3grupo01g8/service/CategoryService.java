/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.sa.practica.reto3grupo01g8.service;

import com.reto3.sa.practica.reto3grupo01g8.entity.Category;
import com.reto3.sa.practica.reto3grupo01g8.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alvaro Fernando Angulo
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    
    /**C
     * Guardar
     */
    public Category saveCategory (Category category){
        return repository.save(category);
        
    }
   
    
    
    
    /**R
     * mostrar todos los productos
     */
    public List<Category> getCategoryAll(){
        return repository.findAll();
        
    }
    /**U
     * 
     * Actualizar Category ID
     * 
     */
    
    public  Category updateCategory(Category category){
      Category existeCategory=repository.findById(category.getId()).orElse(null);
      existeCategory.setName(category.getName());
      existeCategory.setDescription(category.getDescription());
      return repository.save(existeCategory);
      
    }
    
    
    /**
     *  Eliminar Category por ID  
     */
    public String deleteCategory(int id){
        repository.deleteById(id);
        return "Category Removido"+id;
    }
}
