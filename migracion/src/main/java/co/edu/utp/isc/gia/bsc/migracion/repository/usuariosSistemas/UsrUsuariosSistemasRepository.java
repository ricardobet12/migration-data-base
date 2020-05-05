/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.bsc.migracion.repository.usuariosSistemas;

import co.edu.utp.isc.gia.bsc.migracion.entity.usuariosSistemas.UsrUsuariosSistemas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ricardo
 */

@Repository
public interface UsrUsuariosSistemasRepository extends JpaRepository<UsrUsuariosSistemas, Integer>{
    
}
