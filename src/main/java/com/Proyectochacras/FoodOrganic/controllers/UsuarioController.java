package com.Proyectochacras.FoodOrganic.controllers;

import com.Proyectochacras.FoodOrganic.models.Usuario;
import com.Proyectochacras.FoodOrganic.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Mostrar el formulario de registro
    @GetMapping("/user/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro"; // Vista que corresponde a 'registro.html'
    }

    // Procesar el formulario de registro
    @PostMapping("/user/register")
    public String registerUser(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "registro";  // Si hay errores de validación, vuelve al formulario
        }
        try {
            usuarioService.saveUsuario(usuario);  // Guardar el usuario en la base de datos
            return "redirect:/login"; // Redirige a la página de login después de un registro exitoso
        } catch (Exception e) {
            e.printStackTrace(); // Mostrar el error en la consola
            return "error";
        }
    }

    // Mostrar el formulario de login
   /* @GetMapping("/login")
    public String showLoginForm() {
        return "login";  // Vista que corresponde a 'login.html'
    }*/

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        boolean isAuthenticated = usuarioService.autenticarUsuario(usuario.getEmail(), usuario.getPassword());

        if (isAuthenticated) {
            return new ResponseEntity<>("Inicio de sesión exitoso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Credenciales incorrectas", HttpStatus.UNAUTHORIZED);
        }
    }

}