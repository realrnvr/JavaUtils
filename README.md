# Java Collections Implementation

## Overview
This repository provides an implementation of essential Java collections, designed to enhance understanding of data structures and their underlying mechanisms. Each data structure is implemented from scratch, closely mirroring Java's standard library implementations. Additionally, comprehensive tests are included for every implementation to ensure correctness and reliability.

### Implemented Data Structures:

1. **ArrayList** - A dynamically resizable array.
2. **HashMap** - A key-value store with hashing.
3. **HashSet** - A unique element storage based on hashing.
4. **LinkedList** - A doubly linked list.
5. **PriorityQueue** - Implements both Min-Heap and Max-Heap.
6. **Queue** - A FIFO (First-In, First-Out) queue.
7. **Stack** - A LIFO (Last-In, First-Out) stack.
8. **StringBuilder** - A mutable string utility.

---

## Implementations & Methods

### 1. Custom ArrayList
A dynamically resizable array with functionality similar to Java's `ArrayList`.
- Methods: `add()`, `get()`, `set()`, `remove()`, `size()`, `isEmpty()`, `contains()`, `indexOf()`, `clear()`.
- **Includes Unit Tests** (Located in `CustomUtil.ArrayList.__test__.TestMain.java`)

### 2. Custom HashMap
A hash-based key-value store with collision handling.
- Methods: `put()`, `get()`, `remove()`, `containsKey()`, `containsValue()`, `getOrDefault()`, `clear()`, `isEmpty()`, `size()`.
- **Includes Unit Tests** (Located in `CustomUtil.HashMap.__test__.TestMain.java`)

### 3. Custom HashSet
A set implementation that ensures uniqueness using hashing.
- Methods: `add()`, `clear()`, `contains()`, `remove()`, `isEmpty()`, `size()`.
- **Includes Unit Tests** (Located in `CustomUtil.HashSet.__test__.TestMain.java`)

### 4. Custom LinkedList
A doubly linked list supporting both forward and backward traversal.
- Methods: `add()`, `addFirst()`, `addLast()`, `remove()`, `removeFirst()`, `removeLast()`, `get()`, `getFirst()`, `getLast()`, `contains()`, `size()`, `isEmpty()`, `clear()`.
- **Includes Unit Tests** (Located in `CustomUtil.LinkedList.__test__.TestMain.java`)

### 5. Custom PriorityQueue
A priority queue supporting both Min-Heap and Max-Heap.
- Methods: `add()`, `peek()`, `poll()`, `isEmpty()`.
- **Includes Unit Tests** (Located in `CustomUtil.PriorityQueue.__test__.TestMain.java`)

### 6. Custom Queue
A first-in-first-out queue implementation.
- Methods: `add()`, `poll()`, `peek()`, `isEmpty()`.
- **Includes Unit Tests** (Located in `CustomUtil.Queue.__test__.TestMain.java`)

### 7. Custom Stack
A last-in-first-out stack implementation.
- Methods: `push()`, `pop()`, `peek()`, `isEmpty()`, `size()`, `clear()`, `contains()`.
- **Includes Unit Tests** (Located in `CustomUtil.Stack.__test__.TestMain.java`)

### 8. Custom StringBuilder
A mutable string utility for efficient string manipulations.
- Methods: `append()`, `insert()`, `delete()`, `replace()`, `charAt()`, `length()`, `reverse()`, `isEmpty()`, `clear()`.
- **Includes Unit Tests** (Located in `CustomUtil.StringBuilder.__test__.TestMain.java`)

---

## Installation & Usage

### Clone the repository:
```sh
 git clone https://github.com/realrnvr/JavaUtils.git
```

### Compile and run:
```sh
javac Main.java
java Main
```

### Run Tests:
Each data structure has a dedicated test package inside its respective directory. Run the test using:
```sh
javac CustomUtil/<DataStructure>/__test__/TestMain.java
java CustomUtil.<DataStructure>.__test__.TestMain
```
Replace `<DataStructure>` with the specific utility name (e.g., `ArrayList`, `HashMap`).

---

## License
This project is licensed under the MIT License. Feel free to use and modify it as needed.

---

## Contributing
Contributions are welcome! If you have any suggestions, feel free to open an issue or submit a pull request.

---

## Contact
For inquiries or issues, reach out via GitHub Issues or email at `realrnvr@gmail.com`.
