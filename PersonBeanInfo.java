package beaninfo;

import java.beans.*;
import beans.Person;

public class PersonBeanInfo extends SimpleBeanInfo {

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor name = new PropertyDescriptor("name", Person.class);
            PropertyDescriptor age = new PropertyDescriptor("age", Person.class);

            return new PropertyDescriptor[]{name, age};

        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Main class for testing
    public static void main(String[] args) {

        PersonBeanInfo info = new PersonBeanInfo();
        PropertyDescriptor[] props = info.getPropertyDescriptors();

        if (props != null) {
            for (PropertyDescriptor pd : props) {
                System.out.println("Property: " + pd.getName());
            }
        } else {
            System.out.println("No properties found.");
        }
    }
}