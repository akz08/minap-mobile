Looking Inside
=============

Current Solution Analysis
-------------
MINAP's participants use a web application for data capture. The web application is limited in its use to the Windows platform as well as to the Internet Explorer (ver 9 and below) web browser. While hospitals and clinics have this in mind, and thus have their equipment ready for these limitations, newer participants may need to go out of their way to accomodate MINAP's needs.

Logging in
------------

[insert log in screencap]

Authorised users are given a set of credentials unique to them. These credentials then create a session that keeps track of both the user and the user's workplace throughout the data capture process and are automatically filled in to the appropriate fields in the web application. 

[insert legal disclaimer screencap]

If the user's log in details are cleared against MINAP's users database, a legal disclaimer page will be shown in order to protect the sensitive data about to be used.

Data Capture
------------

[insert Initial Diagnosis screencap]

Data Capture itself can take several minutes to an hour depending on the patient's information. The navigation buttons along the left side of the screen are of no concern for this project. The right side of the screen will display the patient's demographic information as well as identifying the user that created the record in use across the top half.

Each pages' bottom half will display the controls necessary to capture the patient's information. Controls that may be used include (but are not limited to) text fields, buttons, radio buttons, dropdown lists, and calendar input boxes. In addition each field contains a tool tip for the information that it captures as well as the corresponding field number in MINAP's dataset.

Navigation-wise, each page has at least three buttons: "Save" places all data onto a permanent record; "Close" will end the data capture without saving progress (a message box will inform the user of this), the user will then be directed to a listing of all patients entered into the system. The other three buttons: "Next", "Back" and what MINAP refers to as the "Compass" need further looking into.

[insert compass screencap]

The "Compass" is, in essence, a navigation map. Pressing this button will bring the user to a flow-diagram-like display of the pages that are available for data capture. The user can then navigate directly to the page desired provided it is available. If the "Compass" is not used, the web app has a linear way of navigating through screens. "Next" and "Back" will fulfill the expected functions in this linear way. It should be noted that if the user accessed a page via the "Compass" page, pressing "Back" will not bring up the "Compass", but the page that precedes the current display in the previously mentioned linear navigation.

It must be mentioned that throughout the data capture process, the decisions made across certain field or fields will trigger the appearance of one or more fields and even entire pages for further capture.
