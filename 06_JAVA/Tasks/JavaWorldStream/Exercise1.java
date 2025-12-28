import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;




public class Exercise1 {

   public static void main(String[] args) {
      CountryDao countryDao= InMemoryWorldDao.getInstance();
      countryDao.findAllCountries()
    .forEach(country -> 
        country.getCities().stream()
               .max(Comparator.comparing(City::getPopulation))
               .ifPresent(city -> 
                   System.out.println(country.getName() + " - " + city.getName() + ": " + city.getPopulation())
               )
    );
      // Map<Integer, String> populationMap = new HashMap<>();
      // for (Country country : countryDao.findAllCountries()) {
      //    for (City c : country.getCities()) {
      //       populationMap.put(c.getPopulation(), c.getName());
      //    }
      // }
//         CountryDao.findAllCountries()
//             .forEach(country-> country.getCities())
//                 .stream()
//                     .max(Comparator.comparing(city-> city.getPopulation()))
//                         .ifPresent(city-> System.out.println(country.getName() + " " + city.getName() + " " + city.getPopulation()));


// CountryDao.findAllCountries()
//     .forEach(country -> {
//         country.getCities()
//             .stream()
//             .max(Comparator.comparing(City::getPopulation))
//             .ifPresent(city -> 
//                 System.out.println(country.getName() + " " + 
//                                    city.getName() + " " + 
//                                    city.getPopulation())
//             );
//     });




      // Stream.of()
   }

}