# Annotation

#### Required
* when i make `required` annotation in a set method: if i don't use this method it throw an exception

#### Autowired
* when i make `autowired` annotation in a set method, it's set a value of method automaticly using bean founded (one bean, if there is a multiple bean it's throw an exception)

#### Notes:
* For import all bean post processor we use: `<context:annotation-config/>`

## JSR-250 (java specification request) annotation

#### Resource
* specify the name of bean injected

#### PostConstruct
* with method: it's executed after the bean has been initialize.

#### PreDestroy
* with method: it's executed before the been has been destroy.

## Component & stereotype

#### Component
* replace bean class definition
* For scan package if there is a component annotation we use `<context:component-scan base-package="package_Name"></context:component-scan>`

#### More annotation
* Controller
* Repository
* Service
