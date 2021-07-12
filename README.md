# m2dot_CodingChallenge

This is a very basic prove of concept as asked for in the m2dot coding challenge. <br>

The code is also hosted on [heroku](https://m2codingchallenge.herokuapp.com/) (**It is hosted on the free tire therefore loading takes a while**) <br>

# Features:
The application provides a very basic frontend which makes it possible to obtain and validate a license key. An email address is neccessary to get a license key, as it is used to generate it.<br>
A license key can also be validated, the page then either returns true or false. <br>

Neither the response page for the validation nor to obtain a license key have been implemented. <br>

There is no input validation or sanitation. <br>

The app uses an h2 in-memory database to save and validate keys. 