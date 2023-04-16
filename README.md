# Logic

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Raboro_logic&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=Raboro_logic)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Raboro_logic&metric=coverage)](https://sonarcloud.io/summary/new_code?id=Raboro_logic)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=Raboro_logic&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=Raboro_logic)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Raboro_logic&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=Raboro_logic)

[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=Raboro_logic&metric=bugs)](https://sonarcloud.io/summary/new_code?id=Raboro_logic)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=Raboro_logic&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=Raboro_logic)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=Raboro_logic&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=Raboro_logic)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=Raboro_logic&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=Raboro_logic)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=Raboro_logic&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=Raboro_logic)

---

This is a library to work with logic. Right now only propositional logic is
implemented, but more will come.
You can use this library to make your logical code more OOP like and readable.
For example instead of writing something's like this:

````java
private boolean evaluate() {
    return (!this.a || this.b) || ((this.c && this.b) || (!this.c && !this.b)) || 
        ((this.a && !this.b) || (!this.a && this.b));
}
````

You can do this instead:

````java
private boolean evaluate() {
    return or(implication(this.a, this.b), xnor(this.c, this.b), xor(this.a, this.b));
}
````

---

### Features

- Symbols right now are:
    - ∧: AND
    - ∨: OR 
    - ⊼: NAND
    - ⊽: NOR
    - ⟷: XNOR
    - ⊻: XOR
    - ⟶: IMPLICATION
- You can just use the static functionalities of the logical Symbols
- You can have multiple input arguments for the symbol
- You can get the value or compare logical values with Booleans
- You can get the value or compare logical values as binary String input
- You can see the truth table of the symbols

---
### Future plans

Not only implement propositional logic but also predicate logic.
Then you will create your own predicates and define your own rules to evaluate logical problems.

Then not only Boolean or binary String inputs can be compared but all you could imagine.