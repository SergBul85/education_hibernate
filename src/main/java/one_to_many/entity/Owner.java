package one_to_many.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "name")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Car> cars;

    public Owner() {
    }

    public Owner(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        if (cars == null) {
            cars = new ArrayList<>();
        }
        cars.add(car);
        car.setOwner(this);
    }

    @Override
    public String toString() {
        return "Owner{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", age=" + age +
               '}';
    }
}
