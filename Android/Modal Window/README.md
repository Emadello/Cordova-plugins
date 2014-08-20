Works on Cordova 2.9



How to Install
	1.	Copy the "kr" folder with all its sub-folders to your src folder
	2.	Copy modal.js into your www folder
	3.	Open ModalActivity.java, at Line 7 change the package src to yours
	4.	In AndroidManifest.xml add the following under application tag:
	
	[CODE]<activity android:name="kr.co.purpleworks.cordova.modal.ModalActivity" />[/CODE]

	5.	Open config.xml, add:
	
	[CODE]<plugin name="Modal" value="kr.co.purpleworks.cordova.modal.Modal" />[/CODE]

You're Done!



Usage:

	•	Make sure you include modal.js in your head part of your html page
	•	To open a modal, call modal.open(successcallback, failcallback, url);
	•	To close a modal, call modal.close();
	
	*NOTE: if you're opening a local file, prepend it with "file:///android_asset/www/"
	
	
	
That's all.
