# Logic

This is a library to work with logic. Right know only propositional logic is
implemented, but more will come.

You can use this library to make your logical code more OOP like.

For example instead of writing somethings like this:

````java
private boolean evaluate(){
        return(this.isValid&&this.isType&&this.isWord&&this.isSentence)||
        (this.isValid&&this.name.length()>10);
        }
````

You can do this:

````java
private boolean evaluate(){
        return or(and(this.isValid,this.isType,this.isWord,this.isSentence),
        and(this.isValid,this.name.length()>10);
        }
````

In general you can get more out of this logical symbols:

````java
private boolean evaluate(String binaryInput){
        return new Implication(true,true).valueEquals(binaryInput);
        }
````

---

### Features

- Symbols right now are:
    - AND
    - OR
    - NAND
    - NOR
    - XNOR
    - XOR
    - IMPLICATION
- You can just use the static functionalities of the logical Symbols
- You can get the value or compare logical values with Booleans
- You can get the value or compare logical values as binary String input
- You can see the truth table of the symbols

---
Future plans

Not only implement propositional logic but also predicate logic.
Then you will create your own predicates and define your own rules to evaluate logical problems.

Then not only Boolean or binary String inputs can be compared but all you could imagine.