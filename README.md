Nominet Coding Challenge

This program determines whether a set of receiving towers can receive a signal from a set of transmitting towers on a remote (and conveniently rectangular) island. 

This application has been tested in an Ubuntu Linux environment.

Getting Started

1. Create a suitable directory in your Linux system, eg /home/grid
2. Download a copy of /dist/grid.jar and input.txt and place them in the /home/grid directory 

Pre-requisites

Ensure JRE 1.8 is installed in the linux OS.

How to run (assuming /home/grid is the directory being used)

Open a terminal 
cd /home/grid
chmod +r input.txt
chmod +x grid.jar
java -jar grid.jar

How to test.

If you need to test the application and verify that it is working correctly download a copy of the
NominetCodingChallengeTestDocument.doc from the /documenation directory in git. Follow the steps in
this document

Example contents of Input.txt (Note blank lines, trailing spaces or lines nut in this format will cause
the program to exit with an error message.

10 10
1 2 5 1
2 0 6 3
3 1 2 2
4 3 5 3
1 0 1
2 8 8
3 6 5

Example output if the above input.txt used:
2/3
4 5

Acknowledgments

    http://cljavacode.blogspot.ie/2017/02/chebyshev-distance-between-two-points.html
