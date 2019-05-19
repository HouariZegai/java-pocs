## autowire
allow spring to check a bean of each attribute of triangle class
* by name: bean have a same name of attribute
* by type: work only if there is one variable of the type of bean (bean class)
* constructor: work only if there is one variable of this type

## Scope
* Singleton (default behaviour): all bean have initialized (all obj have the same reference) Only once per spring container.
* Prototype: new bean created with every request or reference.
* and other
![image of bean scopes](additional_spring_bean_scopes.PNG)
