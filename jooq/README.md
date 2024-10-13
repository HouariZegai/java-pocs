# JOOQ with Flyway POC

### Run Migration & Generate JOOQ classes

```shell
 mvn clean compile && mvn flyway:migrate && mvn jooq-codegen:generate
```