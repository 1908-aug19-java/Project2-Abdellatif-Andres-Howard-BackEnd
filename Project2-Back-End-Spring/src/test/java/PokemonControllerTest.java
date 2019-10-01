
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
import com.revature.models.Trainer;
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
	    public void testFindPokemonById() {
	        Pokemon p  = new Pokemon();
	        p.setPokemonId(1);
	        when(pokemonService.findPokemonById(1)).thenReturn(p);
	        
	        Pokemon pp = pokemonController.getPokemonById(1);
	        System.out.println("pp"+pp);
	        verify(pokemonService).findPokemonById(1);
	        assertEquals(1,pp.getPokemonId().intValue());
	    }
	    
	    @Test
	    public void testfindAllPokemonByUserId() {

	        List<Pokemon> pokeList=new ArrayList<>();

	        Pokemon p1 = new Pokemon(1,1,"mew","mew mew","fire","fly");
	        Pokemon p2 = new Pokemon(2,1,"poke2","pokeNik","Ice","swim");
	        pokeList.add(p1);
	        pokeList.add(p2);

	        when(pokemonService.getPokemonsByUserId(1)).thenReturn(pokeList);
	        List<Pokemon> pokemonList =pokemonController.getAllPokemonsByUserId(1);
	        
	        verify(pokemonService).getPokemonsByUserId(1);
	        assertEquals(2, pokemonList.size());
	        assertNotNull(pokemonController.getAllPokemonsByUserId(1));
	    }
	    @Test
	    public void testaddPokemon() {
	        Pokemon p  = new Pokemon(1,1,"mew","mew mew","fire","fly");
	        //p.setPokemonId(1);
	        when(pokemonService.addPokemon(p)).thenReturn(p);
	        
	        ResponseEntity<Pokemon> pp = pokemonController.addPokemon(p);
	        System.out.println("pokemon created code status"+pp.getStatusCode());
	       verify(pokemonService).addPokemon(p);   
	        assertEquals(201,pp.getStatusCodeValue());
	    }
	 

	
	
}
