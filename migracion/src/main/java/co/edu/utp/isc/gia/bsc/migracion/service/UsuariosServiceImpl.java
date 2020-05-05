/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.bsc.migracion.service;

import co.edu.utp.isc.gia.bsc.migracion.entity.usuariosSistemas.UsrUsuariosSistemas;
import co.edu.utp.isc.gia.bsc.migracion.entity.usuariosTenant.UsrUsuarios;
import co.edu.utp.isc.gia.bsc.migracion.repository.usuariosSistemas.UsrUsuariosSistemasRepository;
import co.edu.utp.isc.gia.bsc.migracion.repository.usuariosTenant.UsrUsuariosRepository;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ricardo
 */
@Service
public class UsuariosServiceImpl implements UsuariosService{
    
    
    @Autowired
    private UsrUsuariosSistemasRepository repoSistemas;
    
    
    @Autowired
    private UsrUsuariosRepository repoTenant;
    
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<UsrUsuariosSistemas> findAllSistemas() {
        List<UsrUsuariosSistemas> listUsers = new ArrayList<>();
        listUsers = this.repoSistemas.findAll();
        if (listUsers != null && !listUsers.isEmpty()) {
            this.saveAll(listUsers);
        }
        return listUsers;
    }

    private void saveAll(List<UsrUsuariosSistemas> result) {
        UsrUsuarios usuario = new UsrUsuarios();
        List<UsrUsuarios> listUsers = new ArrayList<>();
        for (UsrUsuariosSistemas user : result) {
            usuario.setIdUsuario(user.getId());
            usuario.setApellidos(user.getApellidos());
            usuario.setAvatar(user.getAvatar());
            usuario.setContrasena(user.getContrasena());
            usuario.setCorreo(user.getCorreo());
            usuario.setEstado(user.getEstado());
            usuario.setNombreUsuario(user.getNombreUsuario());
            usuario.setNombres(user.getNombres());
            usuario.setNumeroDocumento(user.getNumeroDocumento());
            usuario.setSexo(user.getSexo());
            usuario.setTipoDocumento(user.getTipoDocumento());
            //usuario.setRoles(user.getRoles());
            listUsers.add(usuario);
            this.repoTenant.save(usuario);
        }
    } 
}