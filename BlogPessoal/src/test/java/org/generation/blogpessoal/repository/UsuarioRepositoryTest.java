package org.generation.blogpessoal.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.generation.blogpessoal.model.Usuario;
import org.generation.blogpessoal.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
    
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start(){

		usuarioRepository.save(new Usuario(0L, "João Silva", "joaodireita@gmail.com.br", "13465278", "semfoto"));
		
		usuarioRepository.save(new Usuario(0L, "Jhon Med", "jhonmed@gmail.com.br", "13465278", "semfoto"));
		
		usuarioRepository.save(new Usuario(0L, "Penelope Silva", "penolope@gmail.com.br", "13465278", "semfoto"));

        usuarioRepository.save(new Usuario(0L, "Gabriel Silva", "gabis@gmail.com.br", "13465278", "semfoto"));

	}

	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {

		Optional<Usuario> usuario = usuarioRepository.findByUsuario("joaodireita@gmail.com.br");
		assertTrue(usuario.get().getUsuario().equals("joaodireita@gmail.com.br"));
	}

	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {

		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("João Silva"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Penelope Silva"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Gabriel Silva"));
		
	}
}
