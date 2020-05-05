/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.bsc.migracion.web;

import co.edu.utp.isc.gia.bsc.migracion.entity.usuariosSistemas.UsrUsuariosSistemas;
import co.edu.utp.isc.gia.bsc.migracion.service.UsuariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ricardo
 */

@RestController
@RequestMapping("usuario")
public class usuariosController {
    
    @Autowired
    private UsuariosService service;
    
    
       @GetMapping
    public ResponseEntity<?> getAll() {
        List<UsrUsuariosSistemas> list =service.findAllSistemas();
        if (list != null && !list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
    }
    
}
