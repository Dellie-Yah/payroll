package ac.za.cput.repostory.demography.impl;

import ac.za.cput.domain.demography.Gender;
import ac.za.cput.repostory.demography.GenderRepository;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl implements GenderRepository {

    private static GenderRepository genderRepository;

    private Set<Gender> genderDB;

    private GenderRepositoryImpl() {
        this.genderDB = new HashSet<>();
    }

    public static GenderRepository getGenderRepository() {
        if (genderRepository == null) genderRepository = new GenderRepositoryImpl();
        return genderRepository;
    }

    @Override
    public Gender create(Gender gender) {
        this.genderDB.add(gender);
        return gender;
    }

    @Override
    public Gender read(String s) {
        return this.genderDB.stream().filter(gender -> gender.getId().equalsIgnoreCase(s)).findAny().orElse(null);
    }

    @Override
    public Gender update(Gender gender) {
        Gender g = read(gender.getId());
        if (g != null) {
            delete(g.getId());
            return create(gender);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Gender gender = read(s);
        this.genderDB.remove(gender);
    }

    @Override
    public Gender retrieveByDesc(String genderDesc) {
        return this.genderDB.stream().filter(gender -> gender.getDesc().equalsIgnoreCase(genderDesc)).findAny().orElse(null);
    }

    @Override
    public Set<Gender> getAll() {
        return this.genderDB;
    }
}
