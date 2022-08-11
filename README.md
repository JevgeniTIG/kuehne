### application.properties
- Copy application.properties.example file and name it application.properties. This will allow maven to build the project.
- Change datasource configuration(url, username, password) to correct values.
- Change file location to correct one.

### launching project
- The project should be launched once. Otherwise, there could happen database overlaps, as there are not any checks on duplicates implemented.