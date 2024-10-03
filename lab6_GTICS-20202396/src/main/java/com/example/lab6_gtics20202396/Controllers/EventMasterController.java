package com.example.lab6_gtics20202396.Controllers;

import com.example.lab6_gtics20202396.Entities.Evento;
import com.example.lab6_gtics20202396.Repositories.EventoRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/lab6")
public class EventMasterController {

    final EventoRepository eventoRepository;

    public EventMasterController(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @GetMapping("/pagPrincipal")
    public String showHome() {
        return "home";
    }

    @GetMapping("/eventos")
    public String showEvents(@ModelAttribute("evento") Evento evento, Model model) {
        List<Evento> listaEventos = eventoRepository.findAll();
        model.addAttribute("listaEventos", listaEventos);

        return "evento";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(@ModelAttribute("evento") Evento evento,
                                         Model model) {
        //model.addAttribute("evento", new Evento());
        return "twoCrearEditar";
    }

    @GetMapping("/editar")
    public String mostrarFormularioEditar(@ModelAttribute("evento") Evento evento,
                                          @RequestParam int id, Model model) {
        Optional<Evento> optEvento = eventoRepository.findById(id);
        if(optEvento.isPresent()) {
            evento = optEvento.get();
            model.addAttribute("evento", evento);
        }
        return "twoCrearEditar";
    }

    @PostMapping("/guardar")
    public String guardarEvento(@ModelAttribute("evento") @Valid Evento evento, BindingResult result,
                                RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "twoCrearEditar";
        }else {
            attr.addFlashAttribute("msg","Evento" + (evento.getId()) == null ? "creado" : "actualizado" + "exitosamente");
        }
        eventoRepository.save(evento);
        return "redirect:/lab6/eventos";
    }

}
