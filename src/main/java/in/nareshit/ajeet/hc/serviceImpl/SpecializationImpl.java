package in.nareshit.ajeet.hc.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.ajeet.hc.entity.Specialization;
import in.nareshit.ajeet.hc.repo.SpecializtionRepository;
import in.nareshit.ajeet.hc.service.ISpecializationService;
@Service
public class SpecializationImpl implements ISpecializationService {
	@Autowired
	private SpecializtionRepository repo;

	public Long saveSpecialization(Specialization spec) {
		// TODO Auto-generated method stub
		return repo.save(spec).getId();
	}

	@Override
	public List<Specialization> getAllSpecializations() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void removeSpecialization(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);

	}

	
	@Override
	public void updateSpecialization(Specialization spec) {
		// TODO Auto-generated method stub
		repo.save(spec);

	}

	@Override
	public Specialization getOneSpecialization(Long id) {
		// TODO Auto-generated method stub
		Optional<Specialization> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			
		
		return null;
	}

}}
