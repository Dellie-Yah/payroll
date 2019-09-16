package ac.za.cput.repostory.demography.impl;

import ac.za.cput.domain.demography.Race;
import ac.za.cput.repostory.demography.RaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImpl implements RaceRepository {

    private static RaceRepository raceRepository = null;
    private Set<Race> races;

    private RaceRepositoryImpl() {
        this.races = new HashSet<>();
    }

    public static RaceRepository getRaceRepository() {
        if (raceRepository == null) raceRepository = new RaceRepositoryImpl();
        return raceRepository;
    }

    @Override
    public Race create(Race race) {
        this.races.add(race);
        return race;
    }

    @Override
    public Race read(String s) {
        return this.races.stream().filter(race -> race.getId().equalsIgnoreCase(s)).findAny().orElse(null);
    }

    @Override
    public Race update(Race race) {
        Race r = read(race.getId());
        if (r != null) {
            delete(r.getId());
            create(race);
            return race;
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Race race = read(s);
        if (race != null) {
            this.races.remove(race);
        }
    }

    @Override
    public Race retrieveByDesc(String raceDesc) {
        System.out.println(raceDesc);
        return this.races.stream().filter(race -> race.getDesc().equalsIgnoreCase(raceDesc)).findAny().orElse(null);
    }

    @Override
    public Set<Race> getAll() {
        return this.races;
    }
}
