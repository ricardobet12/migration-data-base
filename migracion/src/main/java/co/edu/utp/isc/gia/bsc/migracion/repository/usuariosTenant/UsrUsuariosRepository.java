/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.bsc.migracion.repository.usuariosTenant;

import co.edu.utp.isc.gia.bsc.migracion.entity.usuariosTenant.UsrUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ricardo
 */

@Repository
public interface UsrUsuariosRepository extends JpaRepository<UsrUsuarios, Integer>{
    
}
