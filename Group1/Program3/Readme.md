##Assignment 

Your assignment is to write a program that will read in a text file and calculate and display the raw score and grade level.

The Dale-Chall formula calculates how easy a given text is to read. The result of the calculation can be used to determine the difficulty of the text in terms of academic grade level. Here are instructions to use the formula:

1. Select several 100-word samples throughout the text.

2. Compute the average sentence length in words (divide the number of words by
the number of sentences).

3. Compute the percentage of words NOT on the Dale–Chall word list of 3,000 easy
words. (This list is available on Course Site.)

4. Compute this equation
Raw Score = 0.1579*(PDW) + 0.0496*(ASL) + 3.6365

o Raw Score = uncorrected reading grade of a student who can answer one- half of the test questions on a passage.
o PDW = Percentage of Difficult Words not on the Dale–Chall word list.
o ASL = Average Sentence Length

5. Finally, to compensate for the "grade-equivalent curve," apply thefollowing chart for the Final Score:

Raw Score --- Final Score
4.9 and below --- Grade 4 and below
5.0 to 5.9 --- Grades 5–6
6.0 to 6.9 --- Grades 7–8
7.0 to 7.9 --- Grades 9–10
8.0 to 8.9 --- Grades 11–12
9.0 to 9.9 --- Grades 13–15 (college)
10 and above --- Grades 16 and above


See the Readability Wikipedia Article (section: The Dale-Chall Formula) for more:
http://en.wikipedia.org/wiki/Readability

##Instructions for use:
Provide the input file and the dalechall wordlist as command line arguments