package ac.za.cput.service.demography.impl;

import ac.za.cput.domain.demography.Race;
import ac.za.cput.repostory.demography.RaceRepository;
import ac.za.cput.repostory.demography.impl.RaceRepositoryImpl;
import ac.za.cput.service.demography.RaceService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RaceServiceImpl implements RaceService {

    private static RaceService raceService = null;
    private RaceRepository raceRepository;

    private RaceServiceImpl() {
        this.raceRepository = RaceRepositoryImpl.getRaceRepository();
    }

    public static RaceService getRaceService() {
        if (raceService == null) raceService = new RaceServiceImpl();
        return raceService;
    }

    @Override
    public Race create(Race race) {
        return this.raceRepository.create(race);
    }

    @Override
    public Race read(String s) {
        return this.raceRepository.read(s);
    }

    @Override
    public Race update(Race race) {
        return this.raceRepository.update(race);
    }

    @Override
    public void delete(String s) {
        this.raceRepository.delete(s);
    }

    @Override
    public Race retrieveByDesc(String raceDesc) {
        return this.raceRepository.retrieveByDesc(raceDesc);
    }

    @Override
    public Set<Race> getAll() {
        return this.raceRepository.getAll();
    }
}
