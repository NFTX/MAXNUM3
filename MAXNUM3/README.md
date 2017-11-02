# Maximum Number
Maximum Number - challenge from Code Chef - Problem Code: MAXNUM3

Solved by NFTX.

Solution available in https://github.com/NFTX/MAXNUM3

Given an integer **A** that contains **n** **>** **1** digits. You are asked to remove **exactly one** digit to make the result number is divisible by 6, also make it biggest possible.

 
**Input**

The first line contains an integer **T**, denotes the number of test cases. Each test case is described by an integer **A** in a single line.

 
**Output**

Each test case, output the answer on a single line (it's allowed to delete a digit such that the resulting number contains leading zeroes, you **shouldn't remove them in this case**). If it is impossible to make the result number satisfies the above condition, output -1.

 
Constraints

    1 ≤ T ≤ 100
    2 ≤ n ≤ 10^5
    A will not contain leading zeroes
    the sum of n over all test cases ≤ 10^6

 

Subtasks:

	Subtask #1 (30 points): the sum of n over all test cases ≤ 2000
	Subtask #2 (70 points): original constrains

Example

**Input:**

	3
	123
	100222
	10003

**Output:**

	12
	00222
	-1
