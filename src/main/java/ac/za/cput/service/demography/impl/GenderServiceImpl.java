package ac.za.cput.service.demography.impl;

import ac.za.cput.domain.demography.Gender;
import ac.za.cput.repostory.demography.GenderRepository;
import ac.za.cput.repostory.demography.impl.GenderRepositoryImpl;
import ac.za.cput.service.demography.GenderService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GenderServiceImpl implements GenderService {

    private static GenderService genderService = null;
    private GenderRepository genderRepository;

    private GenderServiceImpl() {
        this.genderRepository = GenderRepositoryImpl.getGenderRepository();
    }

    public static GenderService getGenderService() {
        if (genderService == null) genderService = new GenderServiceImpl();
        return genderService;
    }

    @Override
    public Gender create(Gender gender) {
        return this.genderRepository.create(gender);
    }

    @Override
    public Gender read(String s) {
        return this.genderRepository.read(s);
    }

    @Override
    public Gender update(Gender gender) {
        return this.genderRepository.update(gender);
    }

    @Override
    public void delete(String s) {
        this.genderRepository.delete(s);
    }

    @Override
    public Gender retrieveByDesc(String genderDesc) {
        return this.genderRepository.retrieveByDesc(genderDesc);
    }

    @Override
    public Set<Gender> getAll() {
        return this.genderRepository.getAll();
    }
}
