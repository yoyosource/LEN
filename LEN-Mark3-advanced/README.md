# LENmk3-advanced (LixEntNow Mark 3 Advanced)
Finished building on 28 August of 2021

## Instruction Set
- +1 -> increment current cell (Value in Composter: 3)
- -1 -> decrement current cell (Value in Composter: 5)
- rotate -> rotate to next cell (Value in Composter: 6)
- input -> wait on change and read input and put value in currently active cell (Value in Composter: 7)
- output -> write current cell value to output and compare with one cell, reset if current selected is greater (Value in Composter: 4)
- while -> starts a do while loop (Value in Composter: 1)
- endwhile -> ends a do while loop, jumps back if current cell is not ZERO (Value in Composter: 2)

## Specs
- Width: 10
- Height: 10
- Depth: 20
- AU (Arithmetic Unit) 9 ticks
- LU (Logic Unit) 20 ticks
- Ram: 8 Variables
- Program tape: bidirectional, 61 cells, jump 1 cell in 15/20 of a second
- DigOut: 10 individual values (expandable to 15)
- Binary In
- Delta input
