package org.rygn.kanban;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class developercontrollertest extends controllertest{

	@Test
	public void testGelAllDevelopers() throws Exception {
		mvc.perform(get("/api/developer/developers").contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$.firstname", is("manal")))
					.andExpect(jsonPath("$.lastname", is("el idrissi lalami")))
					.andExpect(jsonPath("$.password", is("password")))
					.andExpect(jsonPath("$.email", is("manelelidrissilalami@gmail.com")));
	}
	

}