



import java.util.Objects;

import java.util.Comparator;


public class Exercise5 {

    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        CityDao cityDao = InMemoryWorldDao.getInstance();
        countryDao.findAllCountries()
        .stream()
        .map(country->country.getCapital())
        .map(capitalId -> cityDao.findCityById(capitalId))
        .filter(Objects::nonNull)
        .max(Comparator.comparing(City::getPopulation))
        .ifPresent(city -> System.out.println(city));
    }

}