package constrained;

import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

public class ConstrainedPerson {
    private int age;
    private VetoableChangeSupport support;

    public ConstrainedPerson() {
        support = new VetoableChangeSupport(this);
    }

    public void addVetoableChangeListener(VetoableChangeListener vcl) {
        support.addVetoableChangeListener(vcl);
    }

    public void setAge(int newAge) throws PropertyVetoException {
        support.fireVetoableChange("age", this.age, newAge);

        if (newAge < 18) {
            throw new PropertyVetoException("Age cannot be less than 18", null);
        }
        this.age = newAge;
    }

    public int getAge() { return age; }

    // Main class for testing
    public static void main(String[] args) {
        ConstrainedPerson cp = new ConstrainedPerson();
        cp.addVetoableChangeListener(evt -> {
            System.out.println("Attempting to change " + evt.getPropertyName() +
                               " from " + evt.getOldValue() +
                               " to " + evt.getNewValue());
        });

        try {
            cp.setAge(20); // Valid
            System.out.println("Age set to: " + cp.getAge());
            cp.setAge(15); // Invalid, will throw exception
        } catch (PropertyVetoException e) {
            System.out.println("Change vetoed: " + e.getMessage());
        }
    }
}
