

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;



public class Exercise2 {
    // most populated city in each contient
    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        
        countryDao.getAllContinents().stream()
        .map(continent-> countryDao.findCountriesByContinent(continent)
        .stream()
        .flatMap(country -> country.getCities().stream())
        .max(Comparator.comparing(City::getPopulation)))
        .filter(Optional::isPresent)
        .map(Optional::get)
        .forEach(city -> System.out.println(city + " " + countryDao.findCountryByCode(city.getCountryCode()).getContinent()));
        
        // .map(countries -> countries.getCities())
        // .max(Comparator.comparing(City::getPopulation))
        // .ifPresent(city->System.out.println(city.getName() + " " + Country.getContinent()));

    }

}
