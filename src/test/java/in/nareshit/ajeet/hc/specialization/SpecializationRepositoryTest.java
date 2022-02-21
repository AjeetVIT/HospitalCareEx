package in.nareshit.ajeet.hc.specialization;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import in.nareshit.ajeet.hc.entity.Specialization;
import in.nareshit.ajeet.hc.repo.SpecializtionRepository;

@DataJpaTest(showSql=true)
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
public class SpecializationRepositoryTest {
	@Autowired
	private SpecializtionRepository repo;

	@Test
	@Order(1)
	public void testSpecCreate() {
		Specialization spec= new Specialization(null,"CRDLS","Cardiologists","They’re experts on the heart and blood vessels.");
		 spec = repo.save(spec);
		 assertnotnull(spec.getId(),"Spec is not Created!");
	}
	@Test
	@Order(2)
	public void testFetchAll() {
		List<Specialization> list = repo.findAll();
		assertNotNull(list);
	
		assertThat(list.isEmpty());
		{
			fail("No Data Exist in Database");
		}
		
	}
	private void assertnotnull(Long id, String string) {
		// TODO Auto-generated method stub
		
	}

}
