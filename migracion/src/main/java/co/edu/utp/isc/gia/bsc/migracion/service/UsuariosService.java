/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.bsc.migracion.service;

import co.edu.utp.isc.gia.bsc.migracion.entity.usuariosSistemas.UsrUsuariosSistemas;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface UsuariosService {
    
    List<UsrUsuariosSistemas> findAllSistemas();
    
}
