Objective

Use some basic UI widgets.
Use Intents to call other Activities Handling the Keyboard Using Fragments.
Permanent storage.
Using Firebase Firestore.
You will be trying out a number of different UI elements. You do not need different
layouts for landscape and portrait views.

Person Activity

The first or main activity collects the basic information about a person. This activity’s
view will look like a basic form. The information we will collect is:
First (given) name Family (last) name Age Email
Phone
Birthdate
Country and state(providence)

For each of the first six items (first name, last name, age, email and phone) use a
text field to allow the user to enter the data. In each text field the appropriate
keyboard needs to be used. The keyboard should not hide the text field the user is
entering. All items need a label indicating what information they contain (first name,
last name, etc). All items are on a separate line.

For the birthdate use the date picker, not the date picker dialog. This will not fit on
the current activity. So on the birthdate line add a button labeled “Set”. When tapped
the button takes the user to a different activity/view - the date activity/view. When the
user returns from the date activity after selecting a date that date should be shown.
If the user does not select a date or cancels the date activity then no change is
made to the date information shown. The user should not be able to edit the date
information in the user activity view. They can only do that when they go to the date
activity/view.

For the country and state we will also use a separate activity. Like the birthdate
there is a set button on the country & state line which takes the user to the country/state
view where the user can select a country and a state. When the user returns from
the country/state view the result is displayed. If the user does not select anything in
the country/state view then no change is made to the country/state data.
Finally there is a done button. When the done button is pressed the user information
is saved to Firebase Firestore. On the ActionBar there must a menu having menu
item as List of users.

ListUser Activity

After user clicks on List of users, this activity should be displayed. In the activity,
user will see list of all the users present in Firebase Firestore. In the list item, user
must see users name, phone and country. When user clicks on particular list item,
user must see all the details of the person.

Date Activity

The date activity has a date picker date where the user can select a date using
either year, month, and day spinners or a CalendarView. It also has a cancel button
and a done button. When the done button is selected the date in the date picker is
returned to the Person Activity, the view goes to the Person Activity and the date
activity is destroyed. Make sure that the the app goes to the previous user active
and does not create a new Person Activity. When the cancel button is selected the
operation is cancelled and like the done button the app goes back to the Person
Activity.

Country/State Activity

This activity has a list fragment, a done button and a cancel button. The done button
and cancel button act like the buttons in the Date activity. The list contains the of
countries given below. The user can select one item in the list. When they select a
country they then see a list of state(providences) which they can select. You can
either display the list of states in the same view or in a different view. In any case
both lists need to use a list fragment.

Challenge Features
1. Allow the user to go back to the Person Activity via the action bar. Make sure that
the app goes back to the first activity and not create a new instance of the first
activity. If the app is displaying a one of the other activities, that activity needs to be
destroyed when you go back to the first activity.
2. Add items to the Action Bar to allow the user to select which activity to go to.
Country & States
Below there is country and state data. You’ll need to store them on Firebase
Firestore. Everytime you the app is opened you’ll have to read the country and state
from firebase.

China
Beijing Municipality
Tianjin Municipality
Hebei
Shanxi
Inner Mongolia
Liaoning
Jilin
HeilongjiangShanghai Municipality
Jiangsu
Zhejiang
Anhui
Fujian
Jiangxi
Shandong
Henan
Hubei
Hunan
Guangdong
Guangxi Zhuang
Hainan
Chongqing Municipality
Sichuan
Guizhou
Yunnan
Tibet Autonomous Region
Shaanxi
Gansu
Qinghai
Ningxia Hui
Xinjiang Uyghur
Hong Kong
Macau
Taiwan

India
Andhra Pradesh
Arunachal Pradesh
Assam
Bihar
Chhattisgarh
Goa
Gujarat
Haryana
Himachal Pradesh
Jammu and Kashmir
Jharkhand
Karnataka
Kerala
Madhya Pradesh
Maharashtra
Manipur
Meghalaya
MizoramNagaland
Odisha
Punjab
Rajasthan
Sikkim
Tamil Nadu
Telangana
Tripura
Uttar Pradesh
Uttarakhand
West Bengal

Mexico
Aguascalientes
Baja California
Baja California Sur
Campeche
Chiapas
Chihuahua
Coahuil
Colim
Durango
Guanajuato
Guerrero
Hidalgo
Jalisco
México
Michoacán
Morelos
Nayarit
Nuevo Leó
Oaxaca
Puebla
Querétaro
Quintana Roo
San Luis Potosí
Sinaloa
Sonor
Tabasc
Tamaulipa
Tlaxcala
Veracruz
Yucatá
Zacatecas

USA
Alabama
Alaska
Arizona
Arkansas
California
Colorado
Connecticut
Delaware
Florida
Georgia
Hawaii
Idaho
Illinois
Indiana
Iowa
Kansas
Kentucky
Louisiana
Maine
Maryland
Massachusetts
Michigan
Minnesota
Mississippi
Missouri
Montana
Nebraska
Nevada
New Hampshire
New Jersey
New Mexico
New York
North Carolina
North Dakota
Ohio
Oklahoma
Oregon
Pennsylvania
Rhode Island
South Carolina
South Dakota
Tennessee
Texas
Utah
Vermont
Virginia
WashingtonWest Virginia
Wisconsin
Wyoming
