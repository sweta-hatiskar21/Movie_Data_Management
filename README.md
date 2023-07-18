# Movie_Data_Management

This project includes the 2 Controller 
1- For importing the dataset from .tsv files to the database tables
2- Provides the endpoint for

2(a).Searching for actors detail by there name.
2(b).Retrieving detailed information about an actor, including a list of movies they have appeared in.

below are the endpoints
/getActorsByName--- gets the actor detail by there name
/getActorsDetail--- gets the actors detail along with all the movies created by them
/getTsvFile--- provides the funcionality to import the data from file into database without saving the file to storage which save our server space.
