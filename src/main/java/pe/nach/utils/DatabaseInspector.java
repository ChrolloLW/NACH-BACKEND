package pe.nach.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

@Component
public class DatabaseInspector implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n=== ESTRUCTURA DE LA TABLA USUARIO ===");
        DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
        ResultSet columns = metaData.getColumns(null, null, "USUARIO", null);
        
        while (columns.next()) {
            String columnName = columns.getString("COLUMN_NAME");
            String columnType = columns.getString("TYPE_NAME");
            String columnSize = columns.getString("COLUMN_SIZE");
            String isNullable = columns.getString("IS_NULLABLE");
            
            System.out.printf("Columna: %-20s Tipo: %-10s Tamaño: %-5s Nullable: %s%n",
                            columnName, columnType, columnSize, isNullable);
        }
        System.out.println("=====================================\n");
    }
}