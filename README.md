# Cities | Population of American states
* List of States:

* Planning: I began the project by defining the requirements and planning the application's structure. I determined that the initial screen should display a list of U.S. states and * decided that the states would be organized in alphabetical order to facilitate navigation.
* User Interface (UI): I created the user interface for the state list screen. I used standard Android user interface elements to display the list of states and the number of * * * * inhabitants next to each state.
* API Integration: To load state population data, I used a reliable data source API - DATAUSA. I implemented the logic to make requests to the API and retrieve the necessary data.
* Implementation of Search: A search bar was added at the top of the screen to allow users to search for states by name. I implemented the search logic, ensuring that the results * * were updated in real-time as the user typed.
* State Details Screen:

* Navigation: I configured the screen navigation so that, when clicking on a state in the list, the user was directed to the details screen of that state.
* Display of Details: On the details screen, I created a user interface to display the state's details, including the ID, name, year of population data, population, and slug.
* Data Editing: I added the ability to edit data on the details screen, allowing users to change the content of the fields.
* Save Button: A "Save" button was added at the bottom of the details screen. When pressed, it triggered the temporary saving function that stored the changes in the device's memory.
* Memory Saving:

* Save Logic: I implemented the logic for temporarily saving data in the device's memory. This involved creating a data structure to store state information and updating that data * when the "Save" button was pressed.
* Temporary Data Management: I ensured that edited data was only temporarily held in memory and that changes were discarded when the application was closed.
* Throughout the development of the "Cities | População dos Estados Americanos" project, I focused on creating an intuitive and functional user experience, ensuring that data was * * loaded from the API and allowing users to make temporary edits to state details. The application was designed to provide convenient access to demographic information about the U.S. * states.

![wirefreme](https://user-images.githubusercontent.com/59364674/148001859-6be7a344-468c-4fbe-af2b-c71013c3dc7f.png)

* User-Friendly Application: The project aims to create a user-friendly application with an intuitive interface that allows users to easily access and explore population data for U.S. states.

* List of States: The application would successfully display a list of U.S. states, organized in alphabetical order, along with the respective population figures.

* API Integration: The project intends to integrate a reliable data source API (DATAUSA) to retrieve population data for the states, ensuring the accuracy and timeliness of the information.

* Search Functionality: Users should be able to search for states by name, and the search results should update in real-time as they type. This feature enhances the app's usability.

* State Details Screen: The application is expected to provide a detailed view of each state, including unique identifiers, state name, year of population data, population figures, and a slug.

* Data Editing: Users would be able to make temporary edits to the state details, with the option to change the content of fields on the details screen.

* Temporary Data Saving: The "Save" button on the details screen is designed to temporarily save any edits made by users in the device's memory.

* Memorable User Experience: The project's success would be measured by its ability to offer a memorable and valuable user experience, making it a convenient tool for accessing demographic information about U.S. states.

Android Manisfest Permissions
 ```
 <uses-permission android:name="android.permission.INTERNET" />
 ```
Available API routes and links
```
https://datausa.io/api/data?drilldowns=State&measures=Population&year=latest
```

Third-party libraries
```
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
implementation 'com.squareup.okhttp3:logging-interceptor:4.2.1'
```

Useful links:
 * [DATA USA](https://datausa.io/)
 * [Gson Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/gson)
 * [OkHttp](https://github.com/square/okhttp)
 * [Retrofit](https://github.com/square/retrofit)
 * [WS WORK SISTEMAS](https://www.wswork.com.br/)
