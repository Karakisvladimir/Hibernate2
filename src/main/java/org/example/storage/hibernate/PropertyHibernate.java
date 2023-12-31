package org.example.storage.hibernate;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

public class PropertyHibernate {
    public static String getConnectionUrlForH2() {
        return Objects.requireNonNull(getProperties())
                .map(properties -> properties.getProperty("hibernate.connection.url")).orElse(null);
    }

        private static Optional<Properties> getProperties() {
        try (InputStream input = PropertyHibernate.class.getClassLoader()
                .getResourceAsStream("hibernate.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find hibernate.properties");
                throw new NullPointerException("Input is NULL");
            }

            prop.load(input);

            return Optional.of(prop);
        } catch (IOException ex) {
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    private PropertyHibernate() {
        throw new IllegalStateException("PropertyHibernate class");
    }
}

