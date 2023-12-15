package org.example.storage;

import org.example.storage.hibernate.PropertyHibernate;
import org.flywaydb.core.Flyway;

public class DatabaseinitService {
    public void initDb() {
//         Create the Flyway instance and point it to the database
        String connectionURL = PropertyHibernate.getConnectionUrlForH2();
        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionURL, null, null)
                .load();

        // Start the migration
        flyway.migrate();
    }
}

