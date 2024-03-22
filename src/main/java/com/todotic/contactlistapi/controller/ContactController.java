package com.todotic.contactlistapi.controller;

import com.todotic.contactlistapi.dto.ContactDTO;
import com.todotic.contactlistapi.entity.Contact;
import com.todotic.contactlistapi.repository.ContactRepository;
import com.todotic.contactlistapi.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/contacts") //Paso 2 generar una api para el servidor
@RestController //anotación del controlador. Paso 1
public class ContactController {

    private final ContactService contactService; //Crea un repositorio

    @GetMapping  //Endpoint: Queremos habilitar el acceso desde una solicitud http
    public Iterable<Contact> list(){
        return contactService.findAll(); //cargamos todos los datos de lam base de datos
    }
    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id){
        return contactService.findById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact create(@RequestBody ContactDTO contactDTO){
        return contactService.create(contactDTO);
    }
    @PutMapping("{id}")
    public Contact update(@PathVariable Integer id ,
                          @RequestBody ContactDTO contactDTO){
        return contactService.update(id,contactDTO);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id ){
        contactService.delete(id);
    }



}
