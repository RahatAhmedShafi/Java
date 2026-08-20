# UIU CSE1115: OOP Midterm Success Roadmap
> [!IMPORTANT]
> Based on the patterns analyzed in the Summer 2025 (252), Fall 2025 (253), and Spring 2026 (261) past papers, you need to master **five core conceptual pillars** to score full marks (30/30).

---

## 🗺️ The Five Exam Pillars & Score Checklist

### 1. Jagged 2D Arrays of Objects (Q1 Pattern)
You must know how to allocate and interact with non-rectangular arrays where rows represent different student cohorts or seat layouts.

* **Key Concept:** You cannot allocate a jagged 2D array in one line. You must initialize the rows, then allocate each row's array size individually on the heap.
* **Reference Mutation:** Be ready for questions that create a local helper reference pointer pointing to an array cell, modify it, and expect the change to reflect in the main array.
```java
// Step 1: Initialize row array
Seat[][] hall = new Seat[3][];
// Step 2: Allocate column array for each row
hall[0] = new Seat[2];
hall[1] = new Seat[3];
// Step 3: Populate in nested loops
for(int r = 0; r < hall.length; r++) {
    for(int c = 0; c < hall[r].length; c++) {
        hall[r][c] = new Seat(r, c);
    }
}
```

---

### 2. Execution Order Tracing (Q2/Q3 Pattern)
You must memorize the exact sequence the Java Virtual Machine (JVM) follows when loading classes and instantiating objects.

#### 🔄 Order of Execution Table
| Sequence | Phase | Target | What Happens |
| :--- | :--- | :--- | :--- |
| **1st** | **Class Loading** | `static` variables & `static { }` blocks | Executed once per class in order of appearance (Parent first, then Child). |
| **2nd** | **Instance Prep** | Instance variables & `{ }` blocks | Executed every time `new` is called (Parent first, then Child). |
| **3rd** | **Constructor** | Constructor body | Runs after field initializations. Delegates to `this(...)` or `super(...)`. |

> [!WARNING]
> **Constructor Delegation Rule:** `this(...)` (overloaded constructor call) or `super(...)` (parent constructor call) **must be the very first statement** in a constructor. Placing them after any other code results in a compiler error.

---

### 3. Encapsulation Gotchas & final Fields
You must identify compiler errors involving access modifiers and immutable variable states.

* **Encapsulation Protection:** If a class attribute is `private`, any statement trying to access or change it directly from another class (e.g. `phone.imei_no = 123;`) will fail to compile. You must write public getters and setters.
* **Immutable final Fields:** If a class attribute is marked `final`, it can only be initialized once (either inline or inside the constructor). Any setter trying to modify a final field (e.g. `this.company = company`) will throw a compiler error.

---

### 4. Inheritance & Super Constructor Chaining
You must manage parent-child relationships and constructor delegations.

* **Hiding Instance Variables:** If a child class redeclares an instance variable with the same name as the parent class (e.g. `String name`), it hides the parent's version. Use `super.name` to access or modify the parent version.
* **Implicit super():** If a child constructor does not write `super(...)` explicitly, the compiler inserts `super()` (the parent's parameterless constructor) as the first statement.
* **Undefined Super Constructor Error:** If the parent class has *only* a parameterized constructor (e.g., `Parent(int x)`) and no default constructor, the child constructor *must* explicitly call `super(value)`. Omitting it causes a compiler error.

---

### 5. Polymorphism, Downcasting & `instanceof` (Final Q Pattern)
You must navigate runtime method resolution and downcasting checks.

#### ⚖️ Binding and Casting Comparison
| Concept | Compile-Time (Early Binding) | Runtime (Late Binding) |
| :--- | :--- | :--- |
| **Variable Reference** | Determines **which methods are visible** to compile (e.g., `Shape s = new Rectangle()`; you cannot call `s.getArea()` if `Shape` does not declare it). | Determines **which overridden method executes** based on the actual object instantiated on the Heap. |
| **Resolution Type** | Static methods, private methods, and final methods. | Overridden instance methods. |

> [!TIP]
> **Safe Downcasting Checklist:**
> 1. Use the `instanceof` operator to verify the dynamic type: `if (s instanceof Rectangle)`.
> 2. Cast explicitly: `double area = ((Rectangle) s).getArea();`.
> 3. Attempting to cast a parent reference to a subclass type it does not belong to (e.g., casting a `Rectangle` reference to a `Square`) compiles but throws a `ClassCastException` at runtime.

---

## 🏆 Checklist to Score Full Marks in the Exam
- [ ] Write `this.x = x` inside constructors to resolve variable shadowing.
- [ ] Implement validation inside setters and call those setters inside constructors (e.g., `setAge(age)` instead of `this.age = age`).
- [ ] For code tracing, draw a Stack/Heap diagram on rough paper to track static variables (single shared box) vs instance variables (separate boxes for each object).
- [ ] Use `Math.abs(a - b) < 1e-5` to compare floating-point (double/float) values instead of `==`.
- [ ] Check if the parent class has a default constructor before writing a child constructor.
- [ ] Verify that final attributes are only set once during object creation.
- [ ] When using subclass polymorphism, remember that the reference variable type limits what methods you can invoke at compile-time.
