# Email-Send

Java Provides Java Mail API
A platform and protocol independent framework to build mail and messaging applications

Jars files needed
1)	Activation.jar file
2)	Mail.jar file
        OR
Use this dependencies then automatically the above two jar files com in your maven project
<dependencies>
	<dependency>
		<groupId>com.sun.mail</groupId>
		<artifactId>javax.mail</artifactId>
		<version>1.6.2</version>
	<dependency>
</dependencide>

Important Classes and Interfaces…..
1)	Java.util.Properties: The Properties class represents a persistent set of properties. The Properties can be saved to stream or loaded from a stream.
2)	Javax.mail.Message: This class models an email message. To send a message, subclass of Message (e.g. MineMessage) is instantiated, the attributes and content are filled in, and message is sent using the Transport.send method.
3)	 Javax.mail.MessagingException:  This is base class for all exception thrown by the Messaging classes
4)	import javax.mail.PasswordAuthentication: This class is simply a repository for a user name and a password
5)	javax.mail.Session: Session class represents a mail session
6)	javax.mail.Transport: This is abstract class that models a message transport.
7)	Javax.mail.internet.InternerAddress: This class represents an Internet email address using the syntax of RFC822
8)	import javax.mail.internet.MineMessage:  This class represent a MIME style email message. It implements the Message abstract class and the MimePart interface

There are 3 steps to send the message
1)	Get the session
2)	Compose the message
3)	Sent the message
    
We need gmail account any gmail account I am using
	  testing18072000@gmail.com 
