package amazon;

import java.util.Comparator;

class CityComparator
  implements Comparator<City>
{
  public int compare(City c1, City c2)
  {
    return c1.getPopulation() == c2.getPopulation() ? 0 : c1.getPopulation() > c2.getPopulation() ? -1 : 1;
  }
}
