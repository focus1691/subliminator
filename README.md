[![Subliminator Logo](https://github.com/traderjosh/subliminator/blob/master/Images/ss.png)](https://www.psychotechnology.com/subliminator)

# Subliminator

A desktop program that displays subliminal messages *>50ms* onto your computer screen. The program is built with Java Swing. The method used to create these messages was a combination of `JFrames` and multithreading.

Multithreading was used because up to 5 frames can be displayed at once, and this was a good way to manage their executions, as the CPU may not be able to process them all at the same time.

## Instructions

![Preview 1](https://www.psychotechnology.com/assets/images/1.png)
![Preview 2](https://www.psychotechnology.com/assets/images/2.png)
![Preview 3](https://www.psychotechnology.com/assets/images/2.png)

## Windows Installer

Full details on how to create a Windows desktop installer for Subliminator can be found in [this repository](https://github.com/traderjosh/subliminator-windows-installer).

## Issues

1. The JFrame is not invisible so it can block areas that it appears on top of on your computer. It is like a window appearing on top of something you try to click on.
2. Need a way to multiselect messages besides the "select all". A fast select scroll would be really useful.
