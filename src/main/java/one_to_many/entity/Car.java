package one_to_many.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "model")
    private String model;
    @Column(name = "speed")
    private double speed;

    public Car() {
    }

    public Car(String model, double speed) {
        this.model = model;
        this.speed = speed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    @Override
    public String toString() {
        return "Car{" +
               "id=" + id +
               ", model='" + model + '\'' +
               ", speed=" + speed +
               '}';
    }
}
