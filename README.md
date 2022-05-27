# Most Active Cookie

 Gets the most active cookie from a given day.
 
## Build instructions:

**What you'll need**
- Access to a command prompt.
- [Maven 3.6.3 and above.](https://maven.apache.org/download.cgi)
- [JDK 8 or later.](https://openjdk.java.net/install/)
 
1. In main directory (containing pom.xml,README.md etc..) open a command prompt and type:
          
       mvn clean install
       
    A "most_active_cookie.jar" file will be created in "target" folder.

## Usage instructions:

1. Place the "most_active_cookie.jar" file in the same folder as a csv file.

    **Example format of .csv file:**

       cookie,timestamp
       AtY0laUfhglK3lC7,2018-12-09T14:19:00+00:00
       SAZuXPGUrfbcn5UA,2018-12-09T10:13:00+00:00
       5UAVanZf6UtGyKVS,2018-12-09T07:25:00+00:00
       AtY0laUfhglK3lC7,2018-12-09T06:19:00+00:00
       SAZuXPGUrfbcn5UA,2018-12-08T22:03:00+00:00
       4sMM2LxV07bPJzwf,2018-12-08T21:30:00+00:00
       fbcn5UAVanZf6UtG,2018-12-08T09:30:00+00:00
       4sMM2LxV07bPJzwf,2018-12-07T23:30:00+00:00

2. Open command prompt and cd into this folder containing the csv and jar files

3. Type:

       java -jav most_active_cookie.jar <cookie_log_filename>.csv <day_being_checked(format: yyyy-MM-dd)>

    **Example format of input:**

        java -jar most_active_cookie.jar cookie_log.csv 2018-12-09
