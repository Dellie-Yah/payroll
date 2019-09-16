package ac.za.cput.repostory.demography;

import ac.za.cput.domain.demography.Gender;
import ac.za.cput.repostory.IRepository;

import java.util.Set;

public interface GenderRepository extends IRepository<Gender, String> {
    Gender retrieveByDesc(String genderDesc);

    Set<Gender> getAll();
}
