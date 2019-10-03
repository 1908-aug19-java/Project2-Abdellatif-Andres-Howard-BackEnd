
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.revature.controllers.PokemonController;
import com.revature.models.Pokemon;
import com.revature.services.PokemonService;

public class PokemonControllerTest {

	 @InjectMocks
	 private PokemonController pokemonController;

	    @Mock
		private PokemonService pokemonService;	

	    @Before
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	    }    
	    @Test
	    public void testfindAllPokemonByUserId() {
	        List<Pokemon> pokeList=new ArrayList<>();
	        Pokemon p1 = new Pokemon(1,1,"mew","mew mew","fire","fly");
	        Pokemon p2 = new Pokemon(2,1,"poke2","pokeNik","Ice","swim");
	        pokeList.add(p1);
	        pokeList.add(p2);

	        when(pokemonService.findPokemonsByUserId(1)).thenReturn(pokeList);
	        List<Pokemon> pokemonList =pokemonController.getAllPokemonsByUserId(1);
	        
	        verify(pokemonService).findPokemonsByUserId(1);
	        assertEquals(2, pokemonList.size());
	        assertNotNull(pokemonController.getAllPokemonsByUserId(1));
	    }
	    @Test
	    public void testaddPokemon() {
	        Pokemon p  = new Pokemon(1,1,"mew","mew mew","fire","fly");
	        when(pokemonService.addPokemon(p)).thenReturn(p);
	       
	        ResponseEntity<Pokemon> pp = pokemonController.addPokemon(p);
	        verify(pokemonService).addPokemon(p);   
	        assertEquals(201,pp.getStatusCodeValue());
	    }
	    @Test
	    public void testUpdatePokemon() {
	        Pokemon p  = new Pokemon(1,1,"mew","mew mew","fire","fly");
	        String nickname="newNinckname";				
	        when(pokemonService.updatePokemon(p)).thenReturn(p);
	       
	        Pokemon pp = pokemonController.updatePokemon(nickname, p);
	        verify(pokemonService).updatePokemon(p); 
	        assertEquals(nickname,pp.getPokemonNickName());

	    }

	
	
}
