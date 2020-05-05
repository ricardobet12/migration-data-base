/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.bsc.migracion.entity.usuariosSistemas;

/**
 *
 * @author ricardo
 */
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author UTP
 */
@Entity
@Table(name = "usr_usuario", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsrUsuariosSistemas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Basic(optional = false)
    @Column(name = "numero_documento")
    private int numeroDocumento;
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "avatar")
    private String avatar;
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    /**
     * Roles are being eagerly loaded here because
     * they are a fairly small collection of items for this example.
     */
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_role", joinColumns
//            = @JoinColumn(name = "user_id",
//            referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "id_rol",
//                    referencedColumnName = "id_rol"))
//    private List<UsrRol> roles;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "userId")
    private List<UsrUsuarioRol> roles;
}
