# Union Find

## Dynamic Connectivity
Given a set of N objects.
- Union command: connect two objects.
- Find/connected query: is there a path connecting the two objects?

### Quick Union
Data structure.
- Integer array id[] of length N.
- Interpretation: id[i] is parent of i.

![](images/quick_union.jpg)

![](images/quick_union_code.jpg)

*Problem*: Tree's can become really long making the find operation `linear`.

### Weighted Quick Union
![](images/weighted_quick_union.jpg)
