package bound;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BoundPerson {
    private String name;
    private PropertyChangeSupport support;

    public BoundPerson() {
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void setName(String newName) {
        String oldName = this.name;
        this.name = newName;
        support.firePropertyChange("name", oldName, newName);
    }

    public String getName() { return name; }

    // Main class for testing
    public static void main(String[] args) {
        BoundPerson bp = new BoundPerson();
        bp.addPropertyChangeListener(evt -> {
            System.out.println("Property changed: " + evt.getPropertyName() +
                               " from " + evt.getOldValue() +
                               " to " + evt.getNewValue());
        });
        bp.setName("Anushka");
        bp.setName("Priya");
    }
}
