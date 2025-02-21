package com.Proyectochacras.FoodOrganic.controllers;

import com.Proyectochacras.FoodOrganic.models.Productor;
import com.Proyectochacras.FoodOrganic.service.ProductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductorController {}

    //@Autowired
    //private ProductorService productorService;


//    // Muestra el formulario de registro
//    @GetMapping("productor/register")
//    public String mostrarFormularioRegistro(Model model) {
//        model.addAttribute("productor", new Productor());
//        return "registro"; // Vista de registro (HTML)
//    }
//
//    // Procesa el formulario de registro y guarda al productor en la base de datos
//    @PostMapping("productor/register")
//    public String registrarProductor(@ModelAttribute Productor productor) {
//        // Llamamos al servicio para guardar el productor
//        productorService.registrarProductor(productor);
//        return "redirect:/login"; // Redirige a la página de login después de registrarse
//    }
//}