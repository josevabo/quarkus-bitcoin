package br.com.alura.model;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class UsuarioTest {

	@Test
	public void testarSeFindByOptionalRetornaUsuarioCorreto() {
		PanacheMock.mock(Usuario.class);
		
		Usuario u = new Usuario();
//		System.out.println("variavel u -> "+ u.toString());
		Optional<PanacheEntityBase> usuario = Optional.of(u);
//		System.out.println("variavel Optional usuario -> "+ usuario.toString());

		
		Mockito.when(Usuario.findByIdOptional(40)).thenReturn(usuario);
				
		Assertions.assertSame(u, Usuario.findByIdOptional(40).get());
	}
}