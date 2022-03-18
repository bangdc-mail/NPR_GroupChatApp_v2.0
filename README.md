# NPR_GroupChatApp_v2.0
A simple group chat application.

I. Program Explaination:

In this project, any Compiler Program is acceptable. However, for personal preference, I have used Eclipse. Depending on Java Swing – a library designed to create a GUI, I have built a fairly simple GUI using the JFrame class. The 3 window form, two of which belong to the client side application are created as such:
 

![image](https://user-images.githubusercontent.com/78629757/158971298-3d832d2c-99fe-4eee-be44-f13f9a1c98c9.png)

 
Fig. 1: Server side window
 
  ![image](https://user-images.githubusercontent.com/78629757/158968411-9e7cffb6-007a-428e-ade0-2cc08f4ae91f.png)

 
Fig. 2: Client log in window
 
![image](https://user-images.githubusercontent.com/78629757/158970859-aa995ab4-373b-4860-8945-83153e63e14b.png)

 
Fig. 3: Client window after logged in

Tied with the “Connect”, “Send” and “Stop” button are actionPerfomed() functions to link each of the buttons to their unique actions.

II. Review:
- Can't change port to connect
- Some functions are not yet implemented such as user log in with password, file sending using Stream input and output,…etc. Furthermore, it is advisable that the messages should be encrypted for security reasons. In situations that require a secure connection, an overhaul of the program is recommended. Lastly, the interface of the program is not so user-friendly. However, with a bit of tweaking, this issue can be fixed.
