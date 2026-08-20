# UIU CSE1115: Object-Oriented Programming (Midterm Prep Guide)

This guide is tailored specifically for your upcoming OOP midterm exam. It is based on your lecture slides, class notes, and past exam patterns using direct variable access (no private encapsulation).

---

## 📘 Section 1: Core OOP Theory & Concepts

### 1. Classes and Objects
* **Class**: A blueprint or template that defines the structure (state) and behavior of a group of objects. It does not occupy memory at runtime until instantiated.
* **Object**: An instance of a class. It represents a real-world entity and occupies space in memory.
* **Instantiation**: Creating an object using the `new` keyword. 
  ```java
  Point p1 = new Point(5, 6);
  ```
  Here:
  - `Point p1` declares a reference variable named `p1` of type `Point`.
  - `new Point(5, 6)` allocates memory on the heap for the new object and runs the constructor.
  - The assignment operator `=` stores the memory address (reference) of the new object in `p1`.

### 2. Constructor & Shadowing
* **Constructor**: A special method used to initialize objects. It has the same name as the class and has no return type.
* **Shadowing**: When a local variable (e.g., a constructor parameter) has the same name as an instance variable.
* **Use of `this` keyword**: 
  - To resolve shadowing: `this.x = x;` tells the compiler to assign the local variable `x` to the instance variable `x` of the current object.
  - To refer to the current object: `this` acts as a reference to the object that invoked the method or constructor.
  - Example:
    ```java
    class Point {
        int x, y; // Instance variables
        Point(int x, int y) { // Parameter variables
            this.x = x; // 'this.x' is the instance variable, 'x' is the parameter
            this.y = y;
        }
    }
    ```

### 3. Instance Variables vs. Static Variables
* **Instance Variables**: Belong to a specific instance (object). Each object has its own copy. Accessed via `objectName.variableName`.
* **Static Variables**: Belong to the class itself. Only one copy is shared among all instances. Memory is allocated only once when the class is loaded. Accessed using `ClassName.variableName` (preferred) or `objectName.variableName`.

#### Code Trace Example (From `basics_OOP.txt`):
```java
class Point {
    int x, y;          // Instance variables
    static int s;      // Static variable
}
```
If you do:
```java
Point p1 = new Point(1, 2);
Point p2 = new Point(10, 10);
p1.s = 5;       // Modifies the shared static variable 's' to 5
Point.s = 7;    // Modifies the shared static variable 's' to 7
System.out.println(p1.s); // Output: 7
System.out.println(p2.s); // Output: 7
```

---

## 📐 Section 2: Complete Implementation of Lecture Exercises (Direct Field Style)

Here is the complete implementation of the classes specified in your lecture slides (`class_object_encapsulation_updated.pdf`), using package-private variables and direct field referencing (just like in your `Circle point.txt` and `Rectangle.txt` files).

### 1. Point Class
```java
class Point {
    int x;
    int y;

    // Constructor
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Method to calculate distance between this point and another point p
    double distance(Point p) {
        int dx = this.x - p.x;
        int dy = this.y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
```

### 2. Circle Class
```java
class Circle {
    Point center;
    double radius;

    // Constructor
    Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    // Method to check if point p resides inside this circle
    boolean pointInsideCircle(Point p) {
        // Distance from center to point p must be <= radius
        double dist = this.center.distance(p);
        return dist <= this.radius;
    }

    // Method to check if circle C resides entirely inside this circle
    boolean circleInsideCircle(Circle C) {
        // Distance between centers + radius of C must be <= radius of this circle
        double centerDistance = this.center.distance(C.center);
        return (centerDistance + C.radius) <= this.radius;
    }
}
```

### 3. Rectangle Class
```java
class Rectangle {
    Point bottomLeft;
    Point topRight;

    // Constructor
    Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    // Method to check if a circle C resides entirely inside this rectangle
    boolean circleInsideRectangle(Circle C) {
        // Circle's bounding coordinates
        double circleLeft = C.center.x - C.radius;
        double circleRight = C.center.x + C.radius;
        double circleBottom = C.center.y - C.radius;
        double circleTop = C.center.y + C.radius;

        // Check if bounding box fits within the rectangle boundaries
        return circleLeft >= this.bottomLeft.x &&
               circleRight <= this.topRight.x &&
               circleBottom >= this.bottomLeft.y &&
               circleTop <= this.topRight.y;
    }

    // Method to check if rectangle R resides entirely inside this rectangle
    boolean RectangleInsideRectangle(Rectangle R) {
        // R is inside if its bottomLeft and topRight coordinates are within bounds
        return R.bottomLeft.x >= this.bottomLeft.x &&
               R.topRight.x <= this.topRight.x &&
               R.bottomLeft.y >= this.bottomLeft.y &&
               R.topRight.y <= this.topRight.y;
    }
}
```

### 4. BangladeshiFlag Class
```java
class BangladeshiFlag {
    Rectangle R;
    Circle C;

    // Constructor
    BangladeshiFlag(Rectangle R, Circle C) {
        this.R = R;
        this.C = C;
    }

    // Method to check if the flag is balanced
    boolean isBalanced() {
        // 1. Check if the circle is strictly inside the rectangle (without touching the edges)
        double circleLeft = C.center.x - C.radius;
        double circleRight = C.center.x + C.radius;
        double circleBottom = C.center.y - C.radius;
        double circleTop = C.center.y + C.radius;

        boolean strictlyInside = circleLeft > R.bottomLeft.x &&
                                 circleRight < R.topRight.x &&
                                 circleBottom > R.bottomLeft.y &&
                                 circleTop < R.topRight.y;

        // 2. Check if the circle center is exactly in the center of the rectangle
        double rectCenterX = (R.bottomLeft.x + R.topRight.x) / 2.0;
        double rectCenterY = (R.bottomLeft.y + R.topRight.y) / 2.0;

        boolean exactlyInMiddle = (C.center.x == rectCenterX) &&
                                  (C.center.y == rectCenterY);

        return strictlyInside && exactlyInMiddle;
    }
}
```

---

## 📝 Section 3: Midterm Practice Questions and Answers

### ❓ Question 1: Code Tracing (Static vs. Instance Members)
**Analyze the following code and write the exact output:**

```java
class Counter {
    int count = 0; // instance variable
    static int staticCount = 0; // static variable

    Counter() {
        count++;
        staticCount++;
        System.out.println("C:" + count + " S:" + staticCount);
    }
}

public class Main {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        c1.count = 5;
        c2.staticCount = 10;
        System.out.println("c1 count: " + c1.count);
        System.out.println("c2 count: " + c2.count);
        System.out.println("c3 staticCount: " + c3.staticCount);
    }
}
```

#### 💡 Answer:
* **Output Tracing:**
  1. `Counter c1 = new Counter();` -> Memory allocated for `c1`. `c1.count` initializes to 0. Increments `c1.count` to 1. `staticCount` (shared) increments to 1. Prints: `C:1 S:1`
  2. `Counter c2 = new Counter();` -> Memory allocated for `c2`. `c2.count` initializes to 0. Increments `c2.count` to 1. `staticCount` (shared) increments to 2. Prints: `C:1 S:2`
  3. `Counter c3 = new Counter();` -> Memory allocated for `c3`. `c3.count` initializes to 0. Increments `c3.count` to 1. `staticCount` (shared) increments to 3. Prints: `C:1 S:3`
  4. `c1.count = 5;` -> Changes `c1.count` to 5.
  5. `c2.staticCount = 10;` -> Changes the shared `staticCount` to 10.
  6. Prints:
     - `c1 count: 5`
     - `c2 count: 1`
     - `c3 staticCount: 10`

* **Final Output Console:**
  ```text
  C:1 S:1
  C:1 S:2
  C:1 S:3
  c1 count: 5
  c2 count: 1
  c3 staticCount: 10
  ```

---

### ❓ Question 2: Use of `this` and Shadows
**Identify all compile-time errors in the code below, explain them, and write the corrected version using the `this` keyword.**

```java
class Student {
    String name;
    int id;

    public void Student(String name, int id) {
        name = name;
        id = id;
    }

    public void show() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}
```

#### 💡 Answer:
* **Errors Identified:**
  1. **Error: Return type on constructor.** `public void Student(...)` defines a normal method, NOT a constructor, because it has a return type of `void`. Constructors **must not** have return types.
  2. **Logical Bug: Parameter Shadowing.** `name = name;` and `id = id;` just assign the parameters to themselves. They do not update the instance variables `name` and `id` of the class. The fields remain null and 0 respectively. We need to use `this.name = name;` and `this.id = id;`.

* **Corrected Version:**
  ```java
  class Student {
      String name;
      int id;

      // Constructor (Removed void)
      Student(String name, int id) {
          this.name = name; // Resolved shadowing using 'this'
          this.id = id;     // Resolved shadowing using 'this'
      }

      public void show() {
          System.out.println("Name: " + this.name + ", ID: " + this.id);
      }
  }
  ```

---

### ❓ Question 3: Practice Problem (Line & Point)
**Create a class `Line` that has a start point and end point. Write a method `double length()` and a method `boolean containsPoint(Point p)` without using any encapsulation (private fields).**

#### 💡 Answer:
```java
// Assuming Point class is already defined with x, y, and distance(Point p)

class Line {
    Point start;
    Point end;

    // Constructor
    Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // Calculate length of the line
    double length() {
        return this.start.distance(this.end);
    }

    // Check if point p lies on this line segment
    boolean containsPoint(Point p) {
        double d1 = this.start.distance(p);
        double d2 = this.end.distance(p);
        double totalLen = this.length();

        // Using a tiny tolerance margin to handle double floating point errors
        double difference = Math.abs((d1 + d2) - totalLen);
        return difference < 1e-5;
    }
}
```

---

## 💡 Exam Strategy & Tips to Score High Marks:
1. **Always use `this` inside constructors**: When matching constructor arguments with field names, write `this.x = x;`.
2. **Double comparison precision**: When performing distance checks, avoid `==` for comparing float/double values. Instead of `a == b`, use `Math.abs(a - b) < 0.00001` to be safe from floating-point errors.
3. **Static members vs Instance**: A static method cannot directly call instance variables (`this.x`) or non-static methods without creating an object reference.
