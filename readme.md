# Bus Ticketing System

A prototype of a bus ticketing system which captures credit card taps on/off and charges. 
All credit card numbers used were sourced from http://support.worldpay.com/support/kb/bg/testandgolive/tgl5103.html 
and are safe for testing purposes.

## Getting Started

To successfully compile and run this program, set the main run configuration
to the Driver class. A small sample taps.csv has been provided in src/main/resources
and the path to this file is hardcoded in at the beginning of the CSVReadWrite class.
The trips.csv output file will be written to the same folder. The project was built
using gradle to build external libraries which are, opencsv for parsing and writing .csv
files; and JUnit for testing. Both of these dependencies are included in the build.gradle
file included and should be automatically included once the project is built.

### Prerequisites

The things you need before installing the software.
* Java Jdk 1.8 or later
* IDE Eclipse/IntelliJ

#### Contributors
Michael Blake
