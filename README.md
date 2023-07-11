# Cat-Area-Generator

The main target of this Java program to generate random cats first, and check if they are living in the same location. If they are in the same location, then our program will change the location of the cat which is living there for least months. And it will put that cat to a location which has no cats. So, it looks quite simple but we need a bunch of methods to detect the locations and move the cats.

By CatInfoGenerator we can generate random ArrayLists for cat names, locations and months. We have these three methods here which returns ArrayLists: getRandomNameList, getRandomLocationList, getRandomMonthList. We will use those in the other document, Cat Generator Main.

So, the main part is the file called Cat Generator Main. You can generate as many cats as you want by using the methods from our previous file. And in the main we print both the cats before moving and after moving to see the changes. We have some methods to move the cats successfully:

doesIntersect: Takes two locations as String and checks if those two locations intersect. We find the locations by creating substrings and then converting them to double. (Since location String is as "134,213" for an example.)

countIntersecting: Takes a String location and ArrayList locations. Controls the location with each element from locations and count every intersection.

displayIntersections: Displays the cats which intersects if there is any.

findMinMonthsAtLocation: 

findRandomLocation: Generates random location between the given border.

moveCats: The most important method since it moves cats to a location which has no cats. So, first it controls if any cats are intersecting. And then detect which one of the intersecting cats has the least month. And then put that cat to another location. To find a location without any other cat, we are using a loop.

With the help of all these methods, our program runs successfully.

I would love to see your comments, suggestions and upgrades for this project! Hope you like it. 

Here you can contact me easily: 
e.anil.polat@gmail.com
https://twitter.com/Anlpolt

