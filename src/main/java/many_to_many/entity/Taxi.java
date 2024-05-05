package many_to_many.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "taxi")
public class Taxi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    private List<Passeger> passegerList;

    public Taxi() {
    }

    public Taxi(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addPassegerToTaxi(Passeger passeger) {
        if (passegerList == null) {
            passegerList = new ArrayList<Passeger>();
        }
        passegerList.add(passeger);
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

    public List<Passeger> getPassegerList() {
        return passegerList;
    }

    public void setPassegerList(List<Passeger> passegerList) {
        this.passegerList = passegerList;
    }

    @Override
    public String toString() {
        return "Taxi{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}
