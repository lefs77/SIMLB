package com.mx.simlb.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mx.simlb.dao.PersonaDAO;
import com.mx.simlb.dto.Cliente;
import com.mx.simlb.dto.Domicilios;
import com.mx.simlb.dto.Empleado;
import com.mx.simlb.dto.LocalidadDomicilio;
import com.mx.simlb.dto.Municipios;
import com.mx.simlb.dto.Personas;
import com.mx.simlb.dto.PersonasLocalidadDomicilio;
import com.mx.simlb.dto.Usuarios;

@SuppressWarnings({ "deprecation", "unused" })
@Repository
public class PersonaDAOImpl extends JdbcDaoSupport implements PersonaDAO{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public PersonaDAOImpl(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate= new NamedParameterJdbcTemplate(dataSource);
		
	}
	
public Boolean registrarPersona(Personas personas, String localidadDomicilio)throws Exception{
		
		try{
			Boolean registroExitoso = false;
			Boolean registroCliente = false;
			Boolean registroEmpleado = false;
			Boolean registroUsuario = false;
			
			PersonasLocalidadDomicilio insertPLD = new PersonasLocalidadDomicilio();
				
			
			 final String sqlPersona = "INSERT INTO personas (nombre_uno, nombre_dos, ape_paterno, ape_materno, nombre_completo, sexo, "
			 					+ "codigo_postal,estatus_persona,telefono_uno,telefono_dos,"
			 					+ "rol_persona, numero_int, numero_ext, fecha_alta, usuario_alta) "
	                    + " VALUES( :nombreUno, :nombreDos, :apePaterno, :apeMaterno, "
	                    		 + ":nombreCompleto, :sexo, :codigoPostal, :estatusPersona, "
	                    		 + ":telefonoUno, :telefonoDos, :rolPersona, :numeroInt , :numeroExt,"
	                    		 + ":fechaAlta, :usuarioAlta)";
		        
				KeyHolder keyHolder = new GeneratedKeyHolder();
		        NamedParameterJdbcTemplate namedJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		        SqlParameterSource parameters = new BeanPropertySqlParameterSource(personas);
		        int nb = namedJdbcTemplate.update(sqlPersona, parameters, keyHolder, new String[]{"id_persona"});
		        Long idPersona = keyHolder.getKey().longValue();
			
		        insertPLD.setIdPersona(idPersona);
		        insertPLD.setIdLocalidadDomicilio(Long.valueOf(localidadDomicilio));
		        
		        final String sqlPersonaLocalidadDomicilio = "INSERT INTO personas_localidad_domicilio (id_persona, id_localidad_domicilio ) "
                + " VALUES( :idPersona, :idLocalidadDomicilio)";
		
		        KeyHolder keyHolder2 = new GeneratedKeyHolder();
		        NamedParameterJdbcTemplate namedJdbcTemplate2 = new NamedParameterJdbcTemplate(getDataSource());
		        SqlParameterSource parameters2 = new BeanPropertySqlParameterSource(insertPLD);
		        int nb2 = namedJdbcTemplate.update(sqlPersonaLocalidadDomicilio, parameters2, keyHolder2, new String[]{"id_Personas_Localidad_Domicilio"});
		        Long idPersonasLocalidadDomicilio = keyHolder.getKey().longValue();
		
		        //inserta cliente
		        if(personas.getCliente() !=null && !personas.getCliente().getClaveCliente().equals("")) {
			        
		        	registroCliente = registraCliente(personas.getCliente());
		        	
			        if(!registroCliente) {
			        	throw new Exception("Ocurrio un error al registrar al cliente ");
			        }
		        }
		        
		        //inserta empleado
		        if(personas.getEmpleado()!=null && !personas.getEmpleado().getClaveEmpleado().equals("")) {
		        	
		        	registroEmpleado = registraEmpleado(personas.getEmpleado());
			        
			        if(!registroEmpleado) {
			        	throw new Exception("Ocurrio un error al registrar al empleado ");
			        }
		        }
		        
		        //inserta usuario
		        if(personas.getUsuarios() !=null && !personas.getUsuarios().getCodigoUsuario().equals("")) {
		        	
		        	registroUsuario = registrausuario(personas.getUsuarios());
			        
			        if(!registroUsuario) {
			        	throw new Exception("Ocurrio un error al registrar al usuario ");
			        }
		        }
		       
		        
		        
		        
		        if(idPersonasLocalidadDomicilio !=null && idPersonasLocalidadDomicilio>0) {
		        	registroExitoso =true;
		        }
		        
			return registroExitoso;
			
		}catch(Exception ex){
			throw new Exception("Error : "+ex.getMessage());
		}
		
	}

	public Boolean registraCliente(Cliente cliente) throws Exception {
		
		try{
			
			Boolean registroExitoso = false;
			
			final String sqlCliente = "INSERT INTO cat_cliente (clave_cliente, estatus_cliente, fecha_alta, usuario_alta ) "
            + " VALUES( :claveCliente, :estatusCliente, :fechaAlta, :usuarioAlta)";
			
			KeyHolder keyHolder = new GeneratedKeyHolder();
	        NamedParameterJdbcTemplate namedJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
	        SqlParameterSource parameters = new BeanPropertySqlParameterSource(cliente);
	        int nb = namedJdbcTemplate.update(sqlCliente, parameters, keyHolder, new String[]{"id_cat_cliente"});
	        Long idCatCliente = keyHolder.getKey().longValue();
	        
	        if(idCatCliente !=null && idCatCliente>0) {
	        	registroExitoso =true;
	        }
			
	        return registroExitoso;
		}catch(Exception ex) {
			throw new Exception("Error : "+ex.getMessage());
		}
		
	}
	
	public Boolean registraEmpleado(Empleado empleado) throws Exception {
		
		try{
			
			Boolean registroExitoso = false;
			
			final String sqlEmpleado = "INSERT INTO cat_empleado (clave_empleado, estatus_empleado, fecha_alta, usuario_alta ) "
            + " VALUES( :claveEmpleado, :estatusEmpleado, :fechaAlta, :usuarioAlta)";
			
			KeyHolder keyHolder = new GeneratedKeyHolder();
	        NamedParameterJdbcTemplate namedJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
	        SqlParameterSource parameters = new BeanPropertySqlParameterSource(empleado);
	        
	        int nb = namedJdbcTemplate.update(sqlEmpleado, parameters, keyHolder, new String[]{"id_cat_empleado"});
	        Long idCatEmpleado = keyHolder.getKey().longValue();
	        
	        if(idCatEmpleado !=null && idCatEmpleado>0) {
	        	registroExitoso =true;
	        }
			
	        return registroExitoso;
	        
		}catch(Exception ex) {
			throw new Exception("Error : "+ex.getMessage());
		}
	}

	public Boolean registrausuario(Usuarios usuario) throws Exception {

		try{
			
			Boolean registroExitoso = false;
			
			final String sqlUsuario = "INSERT INTO cat_usuarios (codigo_usuario, puesto_ocupado,estatus_usuario, fecha_alta, usuario_alta ) "
            + " VALUES( :codigoUsuario, :puestoOcupado, :estatusUsuario, :fechaAlta, :usuarioAlta)";
			
			KeyHolder keyHolder = new GeneratedKeyHolder();
	        NamedParameterJdbcTemplate namedJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
	        SqlParameterSource parameters = new BeanPropertySqlParameterSource(usuario);
	        
	        int nb = namedJdbcTemplate.update(sqlUsuario, parameters, keyHolder, new String[]{"id_cat_usuarios"});
	        Long idCatUsuario = keyHolder.getKey().longValue();
	        
	        if(idCatUsuario !=null && idCatUsuario>0) {
	        	registroExitoso =true;
	        }
			
	        return registroExitoso;
	        
		}catch(Exception ex) {
			throw new Exception("Error : "+ex.getMessage());
		}
	}
}
