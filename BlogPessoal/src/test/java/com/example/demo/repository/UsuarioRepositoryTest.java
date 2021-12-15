package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.example.demo.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeAll
	void start() {

		usuarioRepository.save(new Usuario(0L, "Gabriele Pereira Souza", "gabrielepsouzaa@gmail.com", "13465278"));

		usuarioRepository.save(new Usuario(0L, "Samuel Souza Cabral", "samuel.s.cabral@hotmail.com", "13465278"));

		usuarioRepository.save(new Usuario(0L, "Lucileny Pereira Souza", "lenny20@hotmail.com", "13465278"));

		usuarioRepository.save(new Usuario(0L, "M. Eduarda Lima Souza de Araujo", "melsa21@hotmail.com", "13465278"));

	}

	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {

		Optional<Usuario> usuario = usuarioRepository.findByUsuario("gabrielepsouzaa@gmail.com");
		assertTrue(usuario.get().getUsuario().equals("gabrielepsouzaa@gmail.com"));
	}

	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {

		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Souza");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Gabriele Pereira Souza"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Samuel Souza Cabral"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Lucileny Pereira Souza"));

	}

}
