# Pre-work - AndroidProject-1

To-Do List is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: Martha Cornejo

Time spent: 3.5 hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **successfully add and remove items** from the todo list
* [x] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [x] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [ ] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [ ] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [ ] Add support for completion due dates for todo items (and display within listview item)
* [ ] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [ ] Add support for selecting the priority of each todo item (and display in listview item)
* [ ] Tweak the style improving the UI / UX, play with colors, images or backgrounds

The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='http://imgur.com/sB5qj4a.gif' title='Video Walkthrough' width='600' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

**Answer:** My reaction to Android Studio while working on the pre-work assignment has been positive. Android Studio was easy to install and navigate to find and set different settings, SDKs and emulators. In the past I have used Eclipse to create GUIs where I used the Design and Source tab to customize the layouts and user interfaces. Android Studio has a very similar approach with Design and Text tab, both editors are intuitive to use, customizing and switching between different layouts such as RelativeLayout and ConstraintLayout is easy to do from either editor.

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:** An Adapter binds the data source to the UI Component. More specifically an Adapter takes data from Java Objects such as ArrayList or HashMaps and converts it into view items that we can use in our UI Component, for example ListView or GridView. In the context of our To-Do app, we used an ArrayAdapter to convert the objects from an ArrayList into view items that we displayed to the user using a ListView. 


The adapter and ListView allow the application to use recycling, where only the row items that are currently visible in the screen of the device are instantiated instead of instantiating and all the items that are currently visible and those that not visible to the user. This helps our app use less memory which helps app performance. 
The convertView in the getView method of the ArrayAdapter helps our application recycle views by only creating views once and reusing them by replacing the rows with new data. The convertView is an old view that has scrolled out of view from the screen. convertView also lets us know if the the view that will be displayed has been recycled. If the new view has been recycled, convertView != null and we can just replace the data values into the appropriate row. Otherwise if convertView == null the view item has not been recycled and a new row view needs to be created. 



## Notes

Describe any challenges encountered while building the app.

## License

    Copyright [2017] [Martha Cornejo]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
