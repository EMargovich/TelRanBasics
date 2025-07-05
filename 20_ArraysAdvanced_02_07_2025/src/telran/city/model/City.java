package telran.city.model;

public class City implements Comparable<City> {
    String name;
    int population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    @Override
    public int compareTo(City o) {
        return Integer.compare(population, o.population);
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", population = " + population +
                '}';
    }
}
