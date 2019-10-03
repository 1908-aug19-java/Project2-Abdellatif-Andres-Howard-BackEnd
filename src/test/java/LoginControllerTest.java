import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.revature.controllers.LoginController;
import com.revature.models.Trainer;
import com.revature.services.TrainerService;

public class LoginControllerTest {
	 @InjectMocks
	    private LoginController loginController;

	    @Mock
		private TrainerService trainerService;	

	    @Before
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	    }
	    @Test
	    public void testgetUserLogin() {
	        Trainer t = new Trainer("abdo123","1234");	  
	        when(trainerService.validateTrainer(t)).thenReturn(true);
	        ResponseEntity<Trainer> tt =  loginController.getUserLogin(t);
	        assertEquals(200, tt.getStatusCodeValue());//ok
	    }
	    

}
