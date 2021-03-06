Sirius Java Client Win32
======

This is the client for Sirius platform responsible for Win32 GUI applications interactions. It provides communication to [Sirius Win32 Server module](https://github.com/mkolisnyk/Sirius/tree/master/Sirius-Server-Win32#sirius-server-win32-overview) as well as provides the high-level API for making window-based abstractions.

# Installation

The Sirius Win32 client library is delivered in 2 ways:

1. Self-contained Java library provided as **jar** file. It can be taken from [downloads page](http://code.google.com/p/sirius-platform/downloads/list). All we need to do is just unpack the archive and include appropriate **jar** file into the project.

2. Maven dependencies. Each client module is also published to Maven repository. The list of available modules can be found on [the following page](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22sirius.client.win32%22). So, if we have Maven project where we'd like to use Sirius Java client libraries we should update Maven script with the entry like this:
``` xml
	<dependency>
		<groupId>com.github.mkolisnyk</groupId>
		<artifactId>sirius.client.win32</artifactId>
		<version>LATEST</version>
	</dependency>
```
or any similar for all the modules we'd like to include.

# Usage Sample

After that we can use library classes, e.g:

``` java
	import org.sirius.client.win32.Win32Client;
	
	...
	
	Win32Client client = new Win32Client();
```
In this example we've just initialized main entry point for Sirius Win32 API and after that we can make window declarations like:

``` java
	public class NotepadWindow extends MainWindow {
		
		public OpenDialog openDialog;
		SaveMessageDialog dSave;
		public Edit edtText;

		/**
		 * @param client
		 * @param locator
		 */
		public NotepadWindow(Win32Client client, Win32Locator locator) {
			super(client, locator);

			openDialog = new OpenDialog(client, this, new Win32Locator("#32770(.*)",0));
			dSave = new SaveMessageDialog(client, this, new Win32Locator("#32770(.*)",0));
			edtText = new Edit(this,new Win32Locator("Edit",0));
		}		
	}
	
	NotepadWindow notepad = new NotepadWindow(client,new Win32Locator("Notepad",0));
```

and then use them within the test code like:

``` java
	notepad.start("notepad.exe", "", "");
	Assert.assertTrue(notepad.exists(IWin32Options.DEFAULT_TIMEOUT));
	notepad.setActive();
```

Detailed information about Sirius Win32 client API usage can be found on the [project wiki page](https://github.com/mkolisnyk/Sirius/wiki/Win32-Client:-Win32-interaction) where all major concepts are described.

Demo
======

The basic Sirius Win32 demo is available on Youtube:

[![Sirius: Basic Win32 demo](http://img.youtube.com/vi/JI8zuvx5nV4/0.jpg)](http://www.youtube.com/watch?v=JI8zuvx5nV4)

Documentation
======
[Project Wiki](https://github.com/mkolisnyk/Sirius/wiki)

# Releases

All available client modules can be found [at the Maven repository](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.github.mkolisnyk%22%20AND%20a%3A%22sirius.client.win32%22). 

Blog Links
======
[Related blog entries](http://mkolisnyk.blogspot.co.uk/search/label/Sirius)

Authors
======
Myk Kolisnyk (kolesnik.nickolay@gmail.com)

<a href="http://ua.linkedin.com/pub/mykola-kolisnyk/14/533/903"><img src="http://www.linkedin.com/img/webpromo/btn_profile_bluetxt_80x15.png" width="80" height="15" border="0" alt="View Mykola Kolisnyk's profile on LinkedIn"></a>
<a href="http://plus.google.com/108480514086204589709?prsrc=3" rel="publisher" style="text-decoration:none;">
<img src="http://ssl.gstatic.com/images/icons/gplus-16.png" alt="Google+" style="border:0;width:16px;height:16px;"/></a>
