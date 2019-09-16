package ac.za.cput.repostory.demography;

import ac.za.cput.domain.demography.Race;
import ac.za.cput.repostory.IRepository;

import java.util.Set;

public interface RaceRepository extends IRepository<Race, String> {
    Race retrieveByDesc(String raceDesc);
    Set<Race> getAll();
}
