# SparseMatrix

## Use Case:-
- In some applications, we might want to represent an array with indices very
huge (e.g. 10^8), however, most of it are just zeros (e.g. 95%)
- Creating such huge arrays is very time & memory harmful with no return.
  - Complete: 0 0 20 0 40 50 0 70 0 0
  - Better: (50, 5), (20, 2), (70, 7), (40, 4) = (value, idx) list
- A better idea is to represent such arrays using a linked list
- I Create a linked list: ArrayLinkedList
  - I Use a doubly linked list
- It represents a sparse array. Providing the following functions
  - Set and Get positions, Print array, add arrays
- A useful application: Polynomial representation (e.g. 2X60 + 17X1500)
# 
- A more severe/common case is a sparse matrix where most of it are zeros
- Similarly, we will implement SparseMatrix to act like 2D array
## Design wise:
   - Each row in the sparse matrix, is what we actually implemented in the 1D case
   - Now we can think of sparse matrix as linked list of linked list
     - 2 linked lists
     - First: the 1D array linked list
     - Second: linked list, the data of each node is a 1D linked list
     - Again I used a doubly linked list
 
 ## Screanshots
 
 
![q](https://user-images.githubusercontent.com/92885872/182622833-908afbaf-bc4d-486f-814e-538928ac9f58.png)
# 
![w](https://user-images.githubusercontent.com/92885872/182622404-5bfb1772-d02a-45d7-9e25-f40763c25b8e.png)

