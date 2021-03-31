# LEN (LixEntNow)

## About
The Project "Lixent" was started in 2018 by Lixfel and xEntex4 with the goal to build **the** smallest Minecraft CPU ever. It had to be turing-complete, 10x10x20 blocks big and be able to both receive as well as output data. Multiple attempts were made, but ultimately none of them reached a fully-functional state. With the addition of the composter block, which allows for 8 different states to be saved in one block, the project was revived in early 2021. With Yoyonow joining the team, much progress was made and the first-ever fully functional version, the LENmk1 was completed. However, rather quickly the idea came up to further improve on the design featuring things like a binary output and a bidirectional program-tape. This version ended up becoming the LENmk2. 

## Version history
- ??.?? 2018 LixEnt
- 03.28 2021 LixEntNow Mark1
- 03.31 2021 LixEntNow Mark2

## Instruction Set
- +1 -> increment current cell (Value in Composter: 3)
- -1 -> decrement current cell (Value in Composter: 5)
- rotieren -> rotate to next cell (Value in Composter: 7)
- eingeben -> read input and put value in currently active cell (Value in Composter: 6)
- ausgeben -> write current cell value to output (Value in Composter: 4)
- while -> starts a do while loop (Value in Composter: 1)
- endwhile -> ends a do while loop, jumps back if current cell is not ZERO (Value in Composter: 2)
